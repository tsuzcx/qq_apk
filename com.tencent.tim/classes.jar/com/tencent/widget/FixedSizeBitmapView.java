package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;

public class FixedSizeBitmapView
  extends View
{
  private Rect dst = new Rect(0, 0, 0, 0);
  private Drawable gF;
  private Bitmap mBitmap;
  private int mBitmapHeight = -1;
  private int mBitmapWidth = -1;
  private Matrix mDrawMatrix;
  private Paint mPaint = new Paint();
  private ImageView.ScaleType mScaleType;
  
  public FixedSizeBitmapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixedSizeBitmapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setAntiAlias(true);
    this.mScaleType = ImageView.ScaleType.FIT_XY;
  }
  
  private void configureBounds()
  {
    float f2 = 0.0F;
    int j = this.mBitmapWidth;
    int k = this.mBitmapHeight;
    if ((j <= 0) || (k <= 0)) {
      return;
    }
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1;; i = 0)
    {
      this.mDrawMatrix = new Matrix();
      if (i != 0) {
        break;
      }
      if (ImageView.ScaleType.CENTER != this.mScaleType) {
        break label152;
      }
      this.mDrawMatrix.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      return;
    }
    label152:
    float f1;
    float f3;
    if (ImageView.ScaleType.CENTER_CROP == this.mScaleType)
    {
      if (j * n > m * k)
      {
        f1 = n / k;
        f3 = (m - j * f1) * 0.5F;
      }
      for (;;)
      {
        this.mDrawMatrix.setScale(f1, f1);
        this.mDrawMatrix.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
        return;
        f1 = m / j;
        f2 = n;
        float f4 = k;
        f3 = 0.0F;
        f2 = (f2 - f4 * f1) * 0.5F;
      }
    }
    if (ImageView.ScaleType.CENTER_INSIDE == this.mScaleType)
    {
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.mDrawMatrix.setScale(f1, f1);
        this.mDrawMatrix.postTranslate(f2, f3);
        return;
      }
    }
    this.mDrawMatrix.setScale(m / j, n / k);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mBitmap == null) {
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.mDrawMatrix == null) {
      configureBounds();
    }
    paramCanvas.drawBitmap(this.mBitmap, this.mDrawMatrix, this.mPaint);
    if (this.gF != null)
    {
      this.gF.setBounds(0, 0, getWidth() - getPaddingLeft() - getPaddingRight(), getHeight() - getPaddingTop() - getPaddingBottom());
      this.gF.draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void setForgroundDrawable(Drawable paramDrawable)
  {
    if (this.gF != paramDrawable)
    {
      this.gF = paramDrawable;
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.mBitmap != paramBitmap)
    {
      if (paramBitmap == null) {
        break label63;
      }
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      this.mBitmap = paramBitmap;
      if ((this.mBitmapWidth != i) || (this.mBitmapHeight != j))
      {
        this.mBitmapWidth = i;
        this.mBitmapHeight = j;
        this.mDrawMatrix = null;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      label63:
      this.mBitmapHeight = -1;
      this.mBitmapWidth = -1;
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      throw new NullPointerException();
    }
    if (this.mScaleType != paramScaleType)
    {
      this.mScaleType = paramScaleType;
      this.mDrawMatrix = null;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.FixedSizeBitmapView
 * JD-Core Version:    0.7.0.1
 */