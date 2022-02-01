package com.tencent.TMG.opengl.texture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.FloatMath;

public class StringTexture
  extends UploadedTexture
{
  protected Canvas mCanvas;
  private final Bitmap.Config mConfig;
  private final Paint.FontMetricsInt mMetrics;
  private final TextPaint mPaint;
  private final String mText;
  
  private StringTexture(String paramString, TextPaint paramTextPaint, Paint.FontMetricsInt paramFontMetricsInt, int paramInt1, int paramInt2)
  {
    this.mText = paramString;
    this.mPaint = paramTextPaint;
    this.mMetrics = paramFontMetricsInt;
    this.mConfig = Bitmap.Config.ARGB_8888;
    setTextureSize(paramInt1, paramInt2);
    setOpaque(false);
  }
  
  public static TextPaint getDefaultPaint(float paramFloat, int paramInt)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(paramFloat);
    localTextPaint.setAntiAlias(true);
    localTextPaint.setColor(paramInt);
    localTextPaint.setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
    return localTextPaint;
  }
  
  public static StringTexture newInstance(String paramString, float paramFloat, int paramInt)
  {
    return newInstance(paramString, getDefaultPaint(paramFloat, paramInt));
  }
  
  public static StringTexture newInstance(String paramString, float paramFloat1, int paramInt, float paramFloat2, boolean paramBoolean)
  {
    TextPaint localTextPaint = getDefaultPaint(paramFloat1, paramInt);
    if (paramBoolean) {
      localTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    }
    String str = paramString;
    if (paramFloat2 > 0.0F) {
      str = TextUtils.ellipsize(paramString, localTextPaint, paramFloat2, TextUtils.TruncateAt.END).toString();
    }
    return newInstance(str, localTextPaint);
  }
  
  private static StringTexture newInstance(String paramString, TextPaint paramTextPaint)
  {
    int j = 1;
    Paint.FontMetricsInt localFontMetricsInt = paramTextPaint.getFontMetricsInt();
    int m = (int)FloatMath.ceil(paramTextPaint.measureText(paramString));
    int k = localFontMetricsInt.bottom - localFontMetricsInt.top;
    int i = m;
    if (m <= 0) {
      i = 1;
    }
    if (k <= 0) {}
    for (;;)
    {
      return new StringTexture(paramString, paramTextPaint, localFontMetricsInt, i, j);
      j = k;
    }
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap)
  {
    if (!inFinalizer()) {
      paramBitmap.recycle();
    }
  }
  
  protected Bitmap onGetBitmap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, this.mConfig);
    this.mCanvas = new Canvas(localBitmap);
    this.mCanvas.translate(0.0F, -this.mMetrics.ascent);
    this.mCanvas.drawText(this.mText, 0.0F, 0.0F, this.mPaint);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.StringTexture
 * JD-Core Version:    0.7.0.1
 */