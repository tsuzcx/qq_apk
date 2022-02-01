package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontRequest;
import d.a;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 500;
  public static final int FETCH_STRATEGY_ASYNC = 1;
  public static final int FETCH_STRATEGY_BLOCKING = 0;
  public static final int INFINITE_TIMEOUT_VALUE = -1;
  private static final int ITALIC = 1;
  private static final int NORMAL_WEIGHT = 400;
  
  private static int getType(TypedArray paramTypedArray, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramTypedArray.getType(paramInt);
    }
    TypedValue localTypedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, localTypedValue);
    return localTypedValue.type;
  }
  
  @Nullable
  public static FamilyResourceEntry parse(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    return readFamilies(paramXmlPullParser, paramResources);
  }
  
  public static List<List<byte[]>> readCerts(Resources paramResources, @ArrayRes int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    for (;;)
    {
      try
      {
        if (localTypedArray.length() == 0)
        {
          paramResources = Collections.emptyList();
          return paramResources;
        }
        ArrayList localArrayList = new ArrayList();
        if (getType(localTypedArray, 0) == 1)
        {
          paramInt = i;
          if (paramInt < localTypedArray.length())
          {
            i = localTypedArray.getResourceId(paramInt, 0);
            if (i == 0) {
              break label121;
            }
            localArrayList.add(toByteArrayList(paramResources.getStringArray(i)));
            break label121;
          }
        }
        else
        {
          localArrayList.add(toByteArrayList(paramResources.getStringArray(paramInt)));
        }
        return localArrayList;
      }
      finally
      {
        localTypedArray.recycle();
      }
      label121:
      paramInt += 1;
    }
  }
  
  @Nullable
  private static FamilyResourceEntry readFamilies(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return readFamily(paramXmlPullParser, paramResources);
    }
    skip(paramXmlPullParser);
    return null;
  }
  
  @Nullable
  private static FamilyResourceEntry readFamily(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), d.a.FontFamily);
    String str1 = ((TypedArray)localObject).getString(d.a.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(d.a.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(d.a.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(d.a.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(d.a.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(d.a.FontFamily_fontProviderFetchTimeout, 500);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      return new ProviderResourceEntry(new FontRequest(str1, str2, str3, readCerts(paramResources, i)), j, k);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(readFont(paramXmlPullParser, paramResources));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new FontFamilyFilesResourceEntry((FontFileResourceEntry[])((List)localObject).toArray(new FontFileResourceEntry[((List)localObject).size()]));
  }
  
  private static FontFileResourceEntry readFont(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    boolean bool = true;
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), d.a.FontFamilyFont);
    int k;
    label53:
    label63:
    label77:
    int j;
    label91:
    String str1;
    if (paramResources.hasValue(d.a.FontFamilyFont_fontWeight))
    {
      i = d.a.FontFamilyFont_fontWeight;
      k = paramResources.getInt(i, 400);
      if (!paramResources.hasValue(d.a.FontFamilyFont_fontStyle)) {
        break label162;
      }
      i = d.a.FontFamilyFont_fontStyle;
      if (1 != paramResources.getInt(i, 0)) {
        break label169;
      }
      if (!paramResources.hasValue(d.a.FontFamilyFont_ttcIndex)) {
        break label175;
      }
      i = d.a.FontFamilyFont_ttcIndex;
      if (!paramResources.hasValue(d.a.FontFamilyFont_fontVariationSettings)) {
        break label182;
      }
      j = d.a.FontFamilyFont_fontVariationSettings;
      str1 = paramResources.getString(j);
      j = paramResources.getInt(i, 0);
      if (!paramResources.hasValue(d.a.FontFamilyFont_font)) {
        break label189;
      }
    }
    int m;
    String str2;
    label162:
    label169:
    label175:
    label182:
    label189:
    for (int i = d.a.FontFamilyFont_font;; i = d.a.FontFamilyFont_android_font)
    {
      m = paramResources.getResourceId(i, 0);
      str2 = paramResources.getString(i);
      paramResources.recycle();
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      i = d.a.FontFamilyFont_android_fontWeight;
      break;
      i = d.a.FontFamilyFont_android_fontStyle;
      break label53;
      bool = false;
      break label63;
      i = d.a.FontFamilyFont_android_ttcIndex;
      break label77;
      j = d.a.FontFamilyFont_android_fontVariationSettings;
      break label91;
    }
    return new FontFileResourceEntry(str2, k, bool, str1, j, m);
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = 1;
    while (i > 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        i += 1;
        break;
      case 3: 
        i -= 1;
      }
    }
  }
  
  private static List<byte[]> toByteArrayList(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    return localArrayList;
  }
  
  public static abstract interface FamilyResourceEntry {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FetchStrategy {}
  
  public static final class FontFamilyFilesResourceEntry
    implements FontResourcesParserCompat.FamilyResourceEntry
  {
    @NonNull
    private final FontResourcesParserCompat.FontFileResourceEntry[] mEntries;
    
    public FontFamilyFilesResourceEntry(@NonNull FontResourcesParserCompat.FontFileResourceEntry[] paramArrayOfFontFileResourceEntry)
    {
      this.mEntries = paramArrayOfFontFileResourceEntry;
    }
    
    @NonNull
    public FontResourcesParserCompat.FontFileResourceEntry[] getEntries()
    {
      return this.mEntries;
    }
  }
  
  public static final class FontFileResourceEntry
  {
    @NonNull
    private final String mFileName;
    private boolean mItalic;
    private int mResourceId;
    private int mTtcIndex;
    private String mVariationSettings;
    private int mWeight;
    
    public FontFileResourceEntry(@NonNull String paramString1, int paramInt1, boolean paramBoolean, @Nullable String paramString2, int paramInt2, int paramInt3)
    {
      this.mFileName = paramString1;
      this.mWeight = paramInt1;
      this.mItalic = paramBoolean;
      this.mVariationSettings = paramString2;
      this.mTtcIndex = paramInt2;
      this.mResourceId = paramInt3;
    }
    
    @NonNull
    public String getFileName()
    {
      return this.mFileName;
    }
    
    public int getResourceId()
    {
      return this.mResourceId;
    }
    
    public int getTtcIndex()
    {
      return this.mTtcIndex;
    }
    
    @Nullable
    public String getVariationSettings()
    {
      return this.mVariationSettings;
    }
    
    public int getWeight()
    {
      return this.mWeight;
    }
    
    public boolean isItalic()
    {
      return this.mItalic;
    }
  }
  
  public static final class ProviderResourceEntry
    implements FontResourcesParserCompat.FamilyResourceEntry
  {
    @NonNull
    private final FontRequest mRequest;
    private final int mStrategy;
    private final int mTimeoutMs;
    
    public ProviderResourceEntry(@NonNull FontRequest paramFontRequest, int paramInt1, int paramInt2)
    {
      this.mRequest = paramFontRequest;
      this.mStrategy = paramInt1;
      this.mTimeoutMs = paramInt2;
    }
    
    public int getFetchStrategy()
    {
      return this.mStrategy;
    }
    
    @NonNull
    public FontRequest getRequest()
    {
      return this.mRequest;
    }
    
    public int getTimeout()
    {
      return this.mTimeoutMs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.content.res.FontResourcesParserCompat
 * JD-Core Version:    0.7.0.1
 */