package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.util.LruCache;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontsContractCompat
{
  private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final String PARCEL_FONT_RESULTS = "font_results";
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
  private static final String TAG = "FontsContractCompat";
  private static final SelfDestructiveThread sBackgroundThread;
  private static final Comparator sByteArrayComparator = new FontsContractCompat.5();
  private static final Object sLock;
  @GuardedBy("sLock")
  private static final SimpleArrayMap sPendingReplies;
  private static final LruCache sTypefaceCache = new LruCache(16);
  
  static
  {
    sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    sLock = new Object();
    sPendingReplies = new SimpleArrayMap();
  }
  
  @Nullable
  public static Typeface buildTypeface(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo)
  {
    return TypefaceCompat.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, 0);
  }
  
  private static List convertToByteArrayList(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return localArrayList;
  }
  
  private static boolean equalsByteArrayList(List paramList1, List paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label62;
      }
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  @NonNull
  public static FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontRequest paramFontRequest)
  {
    ProviderInfo localProviderInfo = getProvider(paramContext.getPackageManager(), paramFontRequest, paramContext.getResources());
    if (localProviderInfo == null) {
      return new FontsContractCompat.FontFamilyResult(1, null);
    }
    return new FontsContractCompat.FontFamilyResult(0, getFontFromProvider(paramContext, paramFontRequest, localProviderInfo.authority, paramCancellationSignal));
  }
  
  private static List getCertificates(FontRequest paramFontRequest, Resources paramResources)
  {
    if (paramFontRequest.getCertificates() != null) {
      return paramFontRequest.getCertificates();
    }
    return FontResourcesParserCompat.readCerts(paramResources, paramFontRequest.getCertificatesArrayResId());
  }
  
  @NonNull
  @VisibleForTesting
  static FontsContractCompat.FontInfo[] getFontFromProvider(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 16) {
          continue;
        }
        paramContext = paramContext.getContentResolver();
        paramFontRequest = paramFontRequest.getQuery();
        paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null, paramCancellationSignal);
        if (paramContext == null) {
          continue;
        }
        try
        {
          if (paramContext.getCount() <= 0) {
            continue;
          }
          int m = paramContext.getColumnIndex("result_code");
          paramString = new ArrayList();
          int n = paramContext.getColumnIndex("_id");
          i1 = paramContext.getColumnIndex("file_id");
          int i2 = paramContext.getColumnIndex("font_ttc_index");
          int i3 = paramContext.getColumnIndex("font_weight");
          int i4 = paramContext.getColumnIndex("font_italic");
          paramFontRequest = paramString;
          if (!paramContext.moveToNext()) {
            continue;
          }
          if (m == -1) {
            continue;
          }
          i = paramContext.getInt(m);
          if (i2 == -1) {
            continue;
          }
          j = paramContext.getInt(i2);
          if (i1 != -1) {
            continue;
          }
          paramFontRequest = ContentUris.withAppendedId(localUri1, paramContext.getLong(n));
          if (i3 == -1) {
            continue;
          }
          k = paramContext.getInt(i3);
          if ((i4 == -1) || (paramContext.getInt(i4) != 1)) {
            continue;
          }
          bool = true;
          paramString.add(new FontsContractCompat.FontInfo(paramFontRequest, j, k, bool, i));
          continue;
          if (paramFontRequest == null) {
            continue;
          }
        }
        finally
        {
          paramFontRequest = paramContext;
          paramContext = paramString;
        }
      }
      finally
      {
        int i1;
        int i;
        int j;
        int k;
        boolean bool;
        paramFontRequest = null;
        continue;
      }
      paramFontRequest.close();
      throw paramContext;
      paramContext = paramContext.getContentResolver();
      paramFontRequest = paramFontRequest.getQuery();
      paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null);
      continue;
      i = 0;
      continue;
      j = 0;
      continue;
      paramFontRequest = ContentUris.withAppendedId(localUri2, paramContext.getLong(i1));
      continue;
      k = 400;
      continue;
      bool = false;
    }
    paramFontRequest = localArrayList;
    if (paramContext != null) {
      paramContext.close();
    }
    return (FontsContractCompat.FontInfo[])paramFontRequest.toArray(new FontsContractCompat.FontInfo[0]);
  }
  
  @NonNull
  private static FontsContractCompat.TypefaceResult getFontInternal(Context paramContext, FontRequest paramFontRequest, int paramInt)
  {
    int i = -3;
    try
    {
      paramFontRequest = fetchFonts(paramContext, null, paramFontRequest);
      if (paramFontRequest.getStatusCode() == 0)
      {
        paramContext = TypefaceCompat.createFromFontInfo(paramContext, null, paramFontRequest.getFonts(), paramInt);
        if (paramContext != null) {
          i = 0;
        }
        return new FontsContractCompat.TypefaceResult(paramContext, i);
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      return new FontsContractCompat.TypefaceResult(null, -1);
    }
    if (paramFontRequest.getStatusCode() == 1) {
      i = -2;
    }
    return new FontsContractCompat.TypefaceResult(null, i);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static Typeface getFontSync(Context paramContext, FontRequest paramFontRequest, @Nullable ResourcesCompat.FontCallback arg2, @Nullable Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    String str = paramFontRequest.getIdentifier() + "-" + paramInt2;
    Typeface localTypeface = (Typeface)sTypefaceCache.get(str);
    if (localTypeface != null)
    {
      if (??? != null) {
        ???.onFontRetrieved(localTypeface);
      }
      return localTypeface;
    }
    if ((paramBoolean) && (paramInt1 == -1))
    {
      paramContext = getFontInternal(paramContext, paramFontRequest, paramInt2);
      if (??? != null)
      {
        if (paramContext.mResult != 0) {
          break label105;
        }
        ???.callbackSuccessAsync(paramContext.mTypeface, paramHandler);
      }
      for (;;)
      {
        return paramContext.mTypeface;
        label105:
        ???.callbackFailAsync(paramContext.mResult, paramHandler);
      }
    }
    paramFontRequest = new FontsContractCompat.1(paramContext, paramFontRequest, paramInt2, str);
    if (paramBoolean) {}
    try
    {
      paramContext = ((FontsContractCompat.TypefaceResult)sBackgroundThread.postAndWait(paramFontRequest, paramInt1)).mTypeface;
      return paramContext;
    }
    catch (InterruptedException paramContext) {}
    if (??? == null) {}
    for (paramContext = null;; paramContext = new FontsContractCompat.2(???, paramHandler)) {
      synchronized (sLock)
      {
        if (!sPendingReplies.containsKey(str)) {
          break;
        }
        if (paramContext != null) {
          ((ArrayList)sPendingReplies.get(str)).add(paramContext);
        }
        return null;
      }
    }
    if (paramContext != null)
    {
      paramHandler = new ArrayList();
      paramHandler.add(paramContext);
      sPendingReplies.put(str, paramHandler);
    }
    sBackgroundThread.postAndReply(paramFontRequest, new FontsContractCompat.3(str));
    return null;
    return null;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  public static ProviderInfo getProvider(@NonNull PackageManager paramPackageManager, @NonNull FontRequest paramFontRequest, @Nullable Resources paramResources)
  {
    String str = paramFontRequest.getProviderAuthority();
    ProviderInfo localProviderInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (localProviderInfo == null) {
      throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
    }
    if (!localProviderInfo.packageName.equals(paramFontRequest.getProviderPackage())) {
      throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + paramFontRequest.getProviderPackage());
    }
    paramPackageManager = convertToByteArrayList(paramPackageManager.getPackageInfo(localProviderInfo.packageName, 64).signatures);
    Collections.sort(paramPackageManager, sByteArrayComparator);
    paramFontRequest = getCertificates(paramFontRequest, paramResources);
    int i = 0;
    while (i < paramFontRequest.size())
    {
      paramResources = new ArrayList((Collection)paramFontRequest.get(i));
      Collections.sort(paramResources, sByteArrayComparator);
      if (equalsByteArrayList(paramPackageManager, paramResources)) {
        return localProviderInfo;
      }
      i += 1;
    }
    return null;
  }
  
  @RequiresApi(19)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static Map prepareFontData(Context paramContext, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfFontInfo.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfFontInfo[i];
      if (((FontsContractCompat.FontInfo)localObject).getResultCode() != 0) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((FontsContractCompat.FontInfo)localObject).getUri();
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static void requestFont(@NonNull Context paramContext, @NonNull FontRequest paramFontRequest, @NonNull FontsContractCompat.FontRequestCallback paramFontRequestCallback, @NonNull Handler paramHandler)
  {
    paramHandler.post(new FontsContractCompat.4(paramContext, paramFontRequest, new Handler(), paramFontRequestCallback));
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static void resetCache()
  {
    sTypefaceCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.FontsContractCompat
 * JD-Core Version:    0.7.0.1
 */