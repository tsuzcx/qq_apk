package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatBaseImpl
{
  private static final int INVALID_KEY = 0;
  private static final String TAG = "TypefaceCompatBaseImpl";
  private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap();
  
  private void addFontFamily(Typeface paramTypeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry)
  {
    long l = getUniqueKey(paramTypeface);
    if (l != 0L) {
      this.mFontFamilies.put(Long.valueOf(l), paramFontFamilyFilesResourceEntry);
    }
  }
  
  private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, int paramInt)
  {
    return (FontResourcesParserCompat.FontFileResourceEntry)findBestFont(paramFontFamilyFilesResourceEntry.getEntries(), paramInt, new TypefaceCompatBaseImpl.2(this));
  }
  
  private static <T> T findBestFont(T[] paramArrayOfT, int paramInt, StyleExtractor<T> paramStyleExtractor)
  {
    int i;
    int i1;
    label19:
    Object localObject;
    label32:
    int k;
    if ((paramInt & 0x1) == 0)
    {
      i = 400;
      if ((paramInt & 0x2) == 0) {
        break label117;
      }
      i1 = 1;
      localObject = null;
      int j = 2147483647;
      int m = paramArrayOfT.length;
      paramInt = 0;
      if (paramInt >= m) {
        break label129;
      }
      T ? = paramArrayOfT[paramInt];
      int n = Math.abs(paramStyleExtractor.getWeight(?) - i);
      if (paramStyleExtractor.isItalic(?) != i1) {
        break label123;
      }
      k = 0;
      label74:
      k += n * 2;
      if ((localObject != null) && (j <= k)) {
        break label132;
      }
      j = k;
      localObject = ?;
    }
    label129:
    label132:
    for (;;)
    {
      paramInt += 1;
      break label32;
      i = 700;
      break;
      label117:
      i1 = 0;
      break label19;
      label123:
      k = 1;
      break label74;
      return localObject;
    }
  }
  
  private static long getUniqueKey(@Nullable Typeface paramTypeface)
  {
    if (paramTypeface == null) {
      return 0L;
    }
    try
    {
      Field localField = Typeface.class.getDeclaredField("native_instance");
      localField.setAccessible(true);
      long l = ((Number)localField.get(paramTypeface)).longValue();
      return l;
    }
    catch (NoSuchFieldException paramTypeface)
    {
      Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", paramTypeface);
      return 0L;
    }
    catch (IllegalAccessException paramTypeface)
    {
      Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", paramTypeface);
    }
    return 0L;
  }
  
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    FontResourcesParserCompat.FontFileResourceEntry localFontFileResourceEntry = findBestEntry(paramFontFamilyFilesResourceEntry, paramInt);
    if (localFontFileResourceEntry == null) {
      return null;
    }
    paramContext = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, localFontFileResourceEntry.getResourceId(), localFontFileResourceEntry.getFileName(), paramInt);
    addFontFamily(paramContext, paramFontFamilyFilesResourceEntry);
    return paramContext;
  }
  
  /* Error */
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable android.os.CancellationSignal paramCancellationSignal, @androidx.annotation.NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 153	androidx/core/graphics/TypefaceCompatBaseImpl:findBestInfo	([Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 159	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: aload_2
    //   21: invokevirtual 165	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   24: invokevirtual 171	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   27: astore_2
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: invokevirtual 175	androidx/core/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   34: astore_1
    //   35: aload_2
    //   36: invokestatic 181	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: invokestatic 181	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_2
    //   54: invokestatic 181	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: goto -7 -> 53
    //   63: astore_1
    //   64: goto -20 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	TypefaceCompatBaseImpl
    //   0	67	1	paramContext	Context
    //   0	67	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	67	3	paramArrayOfFontInfo	FontsContractCompat.FontInfo[]
    //   0	67	4	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   16	28	41	java/io/IOException
    //   16	28	50	finally
    //   28	35	59	finally
    //   28	35	63	java/io/IOException
  }
  
  protected Typeface createFromInputStream(Context paramContext, InputStream paramInputStream)
  {
    paramContext = TypefaceCompatUtil.getTempFile(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = TypefaceCompatUtil.copyToFile(paramContext, paramInputStream);
      if (!bool) {
        return null;
      }
      paramInputStream = Typeface.createFromFile(paramContext.getPath());
      return paramInputStream;
    }
    catch (RuntimeException paramInputStream)
    {
      return null;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = TypefaceCompatUtil.getTempFile(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = TypefaceCompatUtil.copyToFile(paramContext, paramResources, paramInt1);
      if (!bool) {
        return null;
      }
      paramResources = Typeface.createFromFile(paramContext.getPath());
      return paramResources;
    }
    catch (RuntimeException paramResources)
    {
      return null;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    return (FontsContractCompat.FontInfo)findBestFont(paramArrayOfFontInfo, paramInt, new TypefaceCompatBaseImpl.1(this));
  }
  
  @Nullable
  FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface paramTypeface)
  {
    long l = getUniqueKey(paramTypeface);
    if (l == 0L) {
      return null;
    }
    return (FontResourcesParserCompat.FontFamilyFilesResourceEntry)this.mFontFamilies.get(Long.valueOf(l));
  }
  
  static abstract interface StyleExtractor<T>
  {
    public abstract int getWeight(T paramT);
    
    public abstract boolean isItalic(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */