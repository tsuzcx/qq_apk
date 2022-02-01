package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public final class ci
  implements Interpolator
{
  private float[] a;
  private float[] b;
  
  public ci(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser);
  }
  
  private ci(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    paramResources = dp.a(paramResources, paramTheme, paramAttributeSet, cc.l);
    if (dp.a(paramXmlPullParser, "pathData"))
    {
      paramTheme = dp.b(paramResources, paramXmlPullParser, "pathData", 4);
      paramAttributeSet = dr.a(paramTheme);
      if (paramAttributeSet != null) {
        a(paramAttributeSet);
      } else {
        throw new InflateException("The path is null, which is created from ".concat(String.valueOf(paramTheme)));
      }
    }
    else
    {
      if (!dp.a(paramXmlPullParser, "controlX1")) {
        break label252;
      }
      if (!dp.a(paramXmlPullParser, "controlY1")) {
        break label242;
      }
      float f1 = dp.a(paramResources, paramXmlPullParser, "controlX1", 0, 0.0F);
      float f2 = dp.a(paramResources, paramXmlPullParser, "controlY1", 1, 0.0F);
      boolean bool = dp.a(paramXmlPullParser, "controlX2");
      if (bool != dp.a(paramXmlPullParser, "controlY2")) {
        break label232;
      }
      if (!bool)
      {
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.quadTo(f1, f2, 1.0F, 1.0F);
        a(paramTheme);
      }
      else
      {
        float f3 = dp.a(paramResources, paramXmlPullParser, "controlX2", 2, 0.0F);
        float f4 = dp.a(paramResources, paramXmlPullParser, "controlY2", 3, 0.0F);
        paramTheme = new Path();
        paramTheme.moveTo(0.0F, 0.0F);
        paramTheme.cubicTo(f1, f2, f3, f4, 1.0F, 1.0F);
        a(paramTheme);
      }
    }
    paramResources.recycle();
    return;
    label232:
    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
    label242:
    throw new InflateException("pathInterpolator requires the controlY1 attribute");
    label252:
    throw new InflateException("pathInterpolator requires the controlX1 attribute");
  }
  
  private void a(Path paramPath)
  {
    int j = 0;
    paramPath = new PathMeasure(paramPath, false);
    float f1 = paramPath.getLength();
    int k = Math.min(3000, (int)(f1 / 0.002F) + 1);
    if (k > 0)
    {
      this.a = new float[k];
      this.b = new float[k];
      float[] arrayOfFloat = new float[2];
      int i = 0;
      while (i < k)
      {
        paramPath.getPosTan(i * f1 / (k - 1), arrayOfFloat, null);
        this.a[i] = arrayOfFloat[0];
        this.b[i] = arrayOfFloat[1];
        i += 1;
      }
      if ((Math.abs(this.a[0]) <= 1.E-005D) && (Math.abs(this.b[0]) <= 1.E-005D))
      {
        arrayOfFloat = this.a;
        i = k - 1;
        if ((Math.abs(arrayOfFloat[i] - 1.0F) <= 1.E-005D) && (Math.abs(this.b[i] - 1.0F) <= 1.E-005D))
        {
          i = 0;
          f1 = 0.0F;
          while (j < k)
          {
            arrayOfFloat = this.a;
            float f2 = arrayOfFloat[i];
            if (f2 >= f1)
            {
              arrayOfFloat[j] = f2;
              j += 1;
              f1 = f2;
              i += 1;
            }
            else
            {
              throw new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f2)));
            }
          }
          if (!paramPath.nextContour()) {
            return;
          }
          throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
      }
      paramPath = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
      paramPath.append(this.a[0]);
      paramPath.append(",");
      paramPath.append(this.b[0]);
      paramPath.append(" end:");
      arrayOfFloat = this.a;
      i = k - 1;
      paramPath.append(arrayOfFloat[i]);
      paramPath.append(",");
      paramPath.append(this.b[i]);
      throw new IllegalArgumentException(paramPath.toString());
    }
    throw new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(f1)));
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int j = 0;
    int i = this.a.length - 1;
    while (i - j > 1)
    {
      int k = (j + i) / 2;
      if (paramFloat < this.a[k]) {
        i = k;
      } else {
        j = k;
      }
    }
    float[] arrayOfFloat = this.a;
    float f = arrayOfFloat[i] - arrayOfFloat[j];
    if (f == 0.0F) {
      return this.b[j];
    }
    paramFloat = (paramFloat - arrayOfFloat[j]) / f;
    arrayOfFloat = this.b;
    f = arrayOfFloat[j];
    return f + paramFloat * (arrayOfFloat[i] - f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ci
 * JD-Core Version:    0.7.0.1
 */