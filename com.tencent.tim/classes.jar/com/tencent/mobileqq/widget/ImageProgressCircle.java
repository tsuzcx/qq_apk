package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class ImageProgressCircle
  extends View
{
  private int centerX;
  private int centerY;
  boolean dai = true;
  boolean inited = false;
  boolean isDrawText = true;
  Bitmap mBitmap;
  Matrix mMatrix = new Matrix();
  Paint mPaint = new Paint();
  private int mProgress;
  String mProgressText = "";
  private int size;
  
  public ImageProgressCircle(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    try
    {
      this.mBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130849452);
      int i = (int)(paramContext.getResources().getDisplayMetrics().density * 12.0F);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(-1);
      this.mPaint.setTextSize(i);
      this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
      this.isDrawText = true;
      this.size = paramContext.getResources().getDimensionPixelSize(2131297469);
      this.centerX = (this.size / 2);
      this.centerY = (this.size / 2);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public String CR()
  {
    return this.mProgressText;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i;
    int j;
    if ((this.dai) && (this.mBitmap != null))
    {
      paramCanvas.save();
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      i = this.mBitmap.getWidth() / 2;
      j = this.mBitmap.getHeight() / 2;
      if (!this.inited)
      {
        this.mMatrix.reset();
        this.mMatrix.postTranslate(this.centerX - i, this.centerY - j);
        this.inited = true;
      }
      this.mMatrix.postRotate(5.0F, this.centerX, this.centerY);
      paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, null);
      if (this.isDrawText)
      {
        if (this.mProgress < 10) {
          break label189;
        }
        paramCanvas.drawText(this.mProgressText, (float)(this.centerX - i * 0.66D), (float)(this.centerY + j * 0.25D), this.mPaint);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      postInvalidate();
      return;
      label189:
      paramCanvas.drawText(this.mProgressText, (float)(this.centerX - i * 0.25D), (float)(this.centerY + j * 0.25D), this.mPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 - paramInt1 == 0)
    {
      layout(paramInt1 - this.size / 2, paramInt2, this.size / 2 + paramInt3, paramInt4);
      return;
    }
    if (paramInt4 - paramInt2 == 0)
    {
      layout(paramInt1, paramInt2 - this.size / 2, paramInt3, this.size / 2 + paramInt4);
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setProgress(int paramInt)
  {
    int i = 99;
    if (paramInt >= 100) {
      this.dai = false;
    }
    paramInt = paramInt * 100 / 85;
    if (paramInt > 99) {
      paramInt = i;
    }
    for (;;)
    {
      this.mProgress = paramInt;
      this.mProgressText = (this.mProgress + "%");
      postInvalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageProgressCircle
 * JD-Core Version:    0.7.0.1
 */