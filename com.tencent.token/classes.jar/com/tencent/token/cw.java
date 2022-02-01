package com.tencent.token;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class cw
{
  public static a a(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2)
    {
      paramXmlPullParser.require(2, null, "font-family");
      if (paramXmlPullParser.getName().equals("font-family")) {
        return b(paramXmlPullParser, paramResources);
      }
      a(paramXmlPullParser);
      return null;
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public static List<List<byte[]>> a(Resources paramResources, int paramInt)
  {
    Object localObject = null;
    ArrayList localArrayList = null;
    if (paramInt != 0)
    {
      TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
      localObject = localArrayList;
      if (localTypedArray.length() > 0)
      {
        localArrayList = new ArrayList();
        int i;
        if (localTypedArray.getResourceId(0, 0) != 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          paramInt = 0;
          for (;;)
          {
            localObject = localArrayList;
            if (paramInt >= localTypedArray.length()) {
              break;
            }
            localArrayList.add(a(paramResources.getStringArray(localTypedArray.getResourceId(paramInt, 0))));
            paramInt += 1;
          }
        }
        localArrayList.add(a(paramResources.getStringArray(paramInt)));
        localObject = localArrayList;
      }
      localTypedArray.recycle();
    }
    if (localObject != null) {
      return localObject;
    }
    return Collections.emptyList();
  }
  
  private static List<byte[]> a(String[] paramArrayOfString)
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
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    while (i > 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 3: 
        i -= 1;
        break;
      case 2: 
        i += 1;
      }
    }
  }
  
  private static a b(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), bj.b.FontFamily);
    String str1 = ((TypedArray)localObject).getString(bj.b.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(bj.b.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(bj.b.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(bj.b.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(bj.b.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(bj.b.FontFamily_fontProviderFetchTimeout, 500);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        a(paramXmlPullParser);
      }
      return new d(new ds(str1, str2, str3, a(paramResources, i)), j, k);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(c(paramXmlPullParser, paramResources));
        } else {
          a(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new b((c[])((List)localObject).toArray(new c[((List)localObject).size()]));
  }
  
  private static c c(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), bj.b.FontFamilyFont);
    if (paramResources.hasValue(bj.b.FontFamilyFont_fontWeight)) {
      i = bj.b.FontFamilyFont_fontWeight;
    } else {
      i = bj.b.FontFamilyFont_android_fontWeight;
    }
    int j = paramResources.getInt(i, 400);
    if (paramResources.hasValue(bj.b.FontFamilyFont_fontStyle)) {
      i = bj.b.FontFamilyFont_fontStyle;
    } else {
      i = bj.b.FontFamilyFont_android_fontStyle;
    }
    int i = paramResources.getInt(i, 0);
    boolean bool = true;
    if (1 != i) {
      bool = false;
    }
    if (paramResources.hasValue(bj.b.FontFamilyFont_font)) {
      i = bj.b.FontFamilyFont_font;
    } else {
      i = bj.b.FontFamilyFont_android_font;
    }
    int k = paramResources.getResourceId(i, 0);
    String str = paramResources.getString(i);
    paramResources.recycle();
    while (paramXmlPullParser.next() != 3) {
      a(paramXmlPullParser);
    }
    return new c(str, j, bool, k);
  }
  
  public static abstract interface a {}
  
  public static final class b
    implements cw.a
  {
    public final cw.c[] a;
    
    public b(cw.c[] paramArrayOfc)
    {
      this.a = paramArrayOfc;
    }
  }
  
  public static final class c
  {
    public final String a;
    public int b;
    public boolean c;
    public int d;
    
    public c(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.c = paramBoolean;
      this.d = paramInt2;
    }
  }
  
  public static final class d
    implements cw.a
  {
    public final ds a;
    public final int b;
    public final int c;
    
    public d(ds paramds, int paramInt1, int paramInt2)
    {
      this.a = paramds;
      this.c = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cw
 * JD-Core Version:    0.7.0.1
 */