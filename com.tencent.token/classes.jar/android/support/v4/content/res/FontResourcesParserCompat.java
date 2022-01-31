package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.ArrayRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.compat.R.styleable;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class FontResourcesParserCompat
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 500;
  public static final int FETCH_STRATEGY_ASYNC = 1;
  public static final int FETCH_STRATEGY_BLOCKING = 0;
  public static final int INFINITE_TIMEOUT_VALUE = -1;
  private static final int ITALIC = 1;
  private static final int NORMAL_WEIGHT = 400;
  
  @Nullable
  public static FontResourcesParserCompat.FamilyResourceEntry parse(XmlPullParser paramXmlPullParser, Resources paramResources)
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
  
  public static List readCerts(Resources paramResources, @ArrayRes int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    TypedArray localTypedArray;
    if (paramInt != 0)
    {
      localTypedArray = paramResources.obtainTypedArray(paramInt);
      localObject1 = localObject2;
      if (localTypedArray.length() > 0)
      {
        localObject1 = new ArrayList();
        if (localTypedArray.getResourceId(0, 0) != 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label106;
          }
          paramInt = 0;
          while (paramInt < localTypedArray.length())
          {
            ((List)localObject1).add(toByteArrayList(paramResources.getStringArray(localTypedArray.getResourceId(paramInt, 0))));
            paramInt += 1;
          }
        }
      }
    }
    for (;;)
    {
      localTypedArray.recycle();
      if (localObject1 == null) {
        break;
      }
      return localObject1;
      label106:
      ((List)localObject1).add(toByteArrayList(paramResources.getStringArray(paramInt)));
    }
    return Collections.emptyList();
  }
  
  @Nullable
  private static FontResourcesParserCompat.FamilyResourceEntry readFamilies(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return readFamily(paramXmlPullParser, paramResources);
    }
    skip(paramXmlPullParser);
    return null;
  }
  
  @Nullable
  private static FontResourcesParserCompat.FamilyResourceEntry readFamily(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamily);
    String str1 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      return new FontResourcesParserCompat.ProviderResourceEntry(new FontRequest(str1, str2, str3, readCerts(paramResources, i)), j, k);
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
    return new FontResourcesParserCompat.FontFamilyFilesResourceEntry((FontResourcesParserCompat.FontFileResourceEntry[])((List)localObject).toArray(new FontResourcesParserCompat.FontFileResourceEntry[((List)localObject).size()]));
  }
  
  private static FontResourcesParserCompat.FontFileResourceEntry readFont(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
    int j;
    label49:
    boolean bool;
    if (paramResources.hasValue(R.styleable.FontFamilyFont_fontWeight))
    {
      i = R.styleable.FontFamilyFont_fontWeight;
      j = paramResources.getInt(i, 400);
      if (!paramResources.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
        break label119;
      }
      i = R.styleable.FontFamilyFont_fontStyle;
      if (1 != paramResources.getInt(i, 0)) {
        break label126;
      }
      bool = true;
      label62:
      if (!paramResources.hasValue(R.styleable.FontFamilyFont_font)) {
        break label132;
      }
    }
    int k;
    String str;
    label132:
    for (int i = R.styleable.FontFamilyFont_font;; i = R.styleable.FontFamilyFont_android_font)
    {
      k = paramResources.getResourceId(i, 0);
      str = paramResources.getString(i);
      paramResources.recycle();
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      i = R.styleable.FontFamilyFont_android_fontWeight;
      break;
      label119:
      i = R.styleable.FontFamilyFont_android_fontStyle;
      break label49;
      label126:
      bool = false;
      break label62;
    }
    return new FontResourcesParserCompat.FontFileResourceEntry(str, j, bool, k);
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
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
  
  private static List toByteArrayList(String[] paramArrayOfString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.res.FontResourcesParserCompat
 * JD-Core Version:    0.7.0.1
 */