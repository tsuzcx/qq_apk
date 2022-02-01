package com.tencent.mobileqq.nearby.widget;

import akkf;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class AutoScrollImageView
  extends ImageView
{
  private ValueAnimator az;
  private Bitmap cj;
  private Rect mDstRect = new Rect();
  private int mDuration = 14000;
  private Paint mPaint = new Paint();
  private int mRadius;
  private Rect mSrcRect = new Rect();
  private int mTop;
  private boolean yT;
  
  public AutoScrollImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoScrollImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoScrollImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  private void Q(Canvas paramCanvas)
  {
    if (this.az == null)
    {
      this.az = ValueAnimator.ofInt(new int[] { 0, this.cj.getHeight() - getMeasuredHeight() });
      this.az.setDuration(this.mDuration);
      this.az.setInterpolator(new LinearInterpolator());
      this.az.setRepeatCount(-1);
      this.az.setRepeatMode(2);
      this.az.addUpdateListener(new akkf(this));
      this.az.start();
    }
    if (this.mRadius == 0)
    {
      aW(paramCanvas);
      return;
    }
    int j = getMeasuredWidth();
    int k = getMeasuredHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, j, k);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (int i = paramCanvas.saveLayer(localRectF, null);; i = paramCanvas.saveLayer(localRectF, null, 31))
    {
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, j, k), this.mRadius, this.mRadius, this.mPaint);
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      aW(paramCanvas);
      this.mPaint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      return;
    }
  }
  
  private void aW(Canvas paramCanvas)
  {
    if (this.cj == null) {
      return;
    }
    this.mSrcRect.left = 0;
    this.mSrcRect.right = this.cj.getWidth();
    this.mSrcRect.top = this.mTop;
    this.mSrcRect.bottom = (this.mSrcRect.top + getMeasuredHeight());
    this.mDstRect.left = 0;
    this.mDstRect.right = getMeasuredWidth();
    this.mDstRect.top = 0;
    this.mDstRect.bottom = getMeasuredHeight();
    paramCanvas.drawBitmap(this.cj, this.mSrcRect, this.mDstRect, this.mPaint);
  }
  
  private Bitmap l(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.i("AutoScrollImageView", 1, "error=" + paramBitmap.toString());
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.az != null) && (this.az.isRunning())) {
      this.az.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.yT)
    {
      this.cj = null;
      super.onDraw(paramCanvas);
      return;
    }
    if (this.cj != null)
    {
      Q(paramCanvas);
      return;
    }
    Object localObject = getDrawable();
    if ((localObject != null) && ((localObject instanceof BitmapDrawable)))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.cj = l((Bitmap)localObject, getMeasuredWidth(), getMeasuredWidth() * ((Bitmap)localObject).getHeight() / ((Bitmap)localObject).getWidth());
      if (this.cj != null)
      {
        Q(paramCanvas);
        return;
      }
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAutoScroll(boolean paramBoolean)
  {
    this.yT = paramBoolean;
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt >= 0) {
      this.mDuration = paramInt;
    }
  }
  
  public void setRadius(int paramInt)
  {
    this.mRadius = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AutoScrollImageView
 * JD-Core Version:    0.7.0.1
 */