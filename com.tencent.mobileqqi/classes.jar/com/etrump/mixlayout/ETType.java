package com.etrump.mixlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.util.DisplayMetrics;

public class ETType
{
  public static final int a = 1033;
  public static final String a = "";
  public static final int b = 57344;
  public static final String b = "";
  public static final int c = 57345;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 0;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 5;
  public static final int t = -16777216;
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static Rect a(String paramString, float paramFloat)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    Paint.FontMetrics localFontMetrics = localPaint.getFontMetrics();
    int i1 = (int)localPaint.measureText(paramString);
    int i2 = (int)(localFontMetrics.bottom - localFontMetrics.top);
    localRect.right = i1;
    localRect.bottom = i2;
    return localRect;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETType
 * JD-Core Version:    0.7.0.1
 */