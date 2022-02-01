package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class gq
{
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2)
    {
      String str = paramXmlPullParser.getName();
      if (str.equals("selector")) {
        return a(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
      }
      paramResources = new StringBuilder();
      paramResources.append(paramXmlPullParser.getPositionDescription());
      paramResources.append(": invalid color state list tag ");
      paramResources.append(str);
      throw new XmlPullParserException(paramResources.toString());
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  private static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    int i1 = paramXmlPullParser.getDepth() + 1;
    Object localObject1 = new int[20][];
    int[] arrayOfInt = new int[20];
    int i = 0;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i1) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i1)) {
        if (paramXmlPullParser.getName().equals("item"))
        {
          Object localObject2 = gp.j.ColorStateListItem;
          if (paramTheme == null) {
            localObject2 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject2);
          } else {
            localObject2 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, 0, 0);
          }
          int i2 = ((TypedArray)localObject2).getColor(gp.j.ColorStateListItem_android_color, -65281);
          boolean bool = ((TypedArray)localObject2).hasValue(gp.j.ColorStateListItem_android_alpha);
          float f = 1.0F;
          if (bool) {
            f = ((TypedArray)localObject2).getFloat(gp.j.ColorStateListItem_android_alpha, 1.0F);
          } else if (((TypedArray)localObject2).hasValue(gp.j.ColorStateListItem_alpha)) {
            f = ((TypedArray)localObject2).getFloat(gp.j.ColorStateListItem_alpha, 1.0F);
          }
          ((TypedArray)localObject2).recycle();
          int i3 = paramAttributeSet.getAttributeCount();
          localObject2 = new int[i3];
          j = 0;
          int m;
          for (k = 0; j < i3; k = m)
          {
            int n = paramAttributeSet.getAttributeNameResource(j);
            m = k;
            if (n != 16843173)
            {
              m = k;
              if (n != 16843551)
              {
                m = k;
                if (n != gp.a.alpha)
                {
                  if (paramAttributeSet.getAttributeBooleanValue(j, false)) {
                    m = n;
                  } else {
                    m = -n;
                  }
                  localObject2[k] = m;
                  m = k + 1;
                }
              }
            }
            j += 1;
          }
          localObject2 = StateSet.trimStateSet((int[])localObject2, k);
          arrayOfInt = gs.a(arrayOfInt, i, cz.b(i2, Math.round(Color.alpha(i2) * f)));
          localObject1 = (int[][])gs.a((Object[])localObject1, i, localObject2);
          i += 1;
        }
        else {}
      }
    }
    paramResources = new int[i];
    paramXmlPullParser = new int[i][];
    System.arraycopy(arrayOfInt, 0, paramResources, 0, i);
    System.arraycopy(localObject1, 0, paramXmlPullParser, 0, i);
    return new ColorStateList(paramXmlPullParser, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gq
 * JD-Core Version:    0.7.0.1
 */