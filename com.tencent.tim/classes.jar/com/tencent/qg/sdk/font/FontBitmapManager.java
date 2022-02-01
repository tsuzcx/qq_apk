package com.tencent.qg.sdk.font;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.TextUtils;

public class FontBitmapManager
{
  public static Bitmap createBitmap(String paramString1, String paramString2, float paramFloat, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    Paint localPaint = new Paint(1);
    localPaint.setTypeface(Typeface.create(paramString1, 0));
    localPaint.setTextSize(paramFloat);
    if (paramBoolean) {
      localPaint.setStyle(Paint.Style.FILL);
    }
    for (;;)
    {
      paramFloat = -localPaint.ascent();
      int i = (int)(localPaint.measureText(paramString2) + 0.5F);
      int j = (int)(localPaint.descent() + paramFloat + 0.5F);
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      paramString1 = Bitmap.createBitmap(i, j, Bitmap.Config.ALPHA_8);
      new Canvas(paramString1).drawText(paramString2, 0.0F, paramFloat, localPaint);
      return paramString1;
      localPaint.setStyle(Paint.Style.STROKE);
    }
  }
  
  public static float measureText(String paramString1, String paramString2, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return 0.0F;
    }
    Paint localPaint = new Paint();
    localPaint.setTypeface(Typeface.create(paramString1, 0));
    localPaint.setTextSize(paramFloat);
    return localPaint.measureText(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.font.FontBitmapManager
 * JD-Core Version:    0.7.0.1
 */