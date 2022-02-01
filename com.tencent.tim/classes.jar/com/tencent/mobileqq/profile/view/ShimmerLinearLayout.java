package com.tencent.mobileqq.profile.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ShimmerLinearLayout
  extends LinearLayout
{
  private boolean cwR;
  private int dty;
  private int dtz;
  private Bitmap fT;
  private ValueAnimator mAnimator;
  private int mDuration;
  public Bitmap mMaskBitmap;
  private Paint mMaskPaint = new Paint();
  private int mOffsetX;
  private int mOffsetY;
  
  public ShimmerLinearLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ShimmerLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShimmerLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setDither(true);
    this.mMaskPaint.setFilterBitmap(true);
    this.mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
  }
  
  private ValueAnimator a(boolean paramBoolean)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        ValueAnimator localValueAnimator;
        if (this.mAnimator != null)
        {
          if (!paramBoolean)
          {
            localValueAnimator = this.mAnimator;
            return localValueAnimator;
          }
          QLog.i("ShimmerLinearLayout", 1, "getShimmerAnimation animator remove");
          this.mAnimator.removeAllUpdateListeners();
          this.mAnimator.cancel();
          this.mAnimator = null;
        }
        QLog.i("ShimmerLinearLayout", 1, "getShimmerAnimation recreate = " + paramBoolean + "call stack = " + Log.getStackTraceString(new Throwable()));
        int k = getWidth();
        i = getHeight();
        switch (this.dty)
        {
        case 0: 
          this.mAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F + this.dtz / this.mDuration });
          this.mAnimator.setDuration(this.mDuration + this.dtz);
          this.mAnimator.setRepeatMode(1);
          this.mAnimator.setRepeatCount(-1);
          this.mAnimator.addUpdateListener(new a(this, i, j, k, m, null));
          localValueAnimator = this.mAnimator;
          continue;
          i = -this.mMaskBitmap.getWidth();
          j = 0;
          break;
        case 1: 
          j = this.mMaskBitmap.getHeight();
          j = -j;
          k = 0;
          int n = 0;
          m = i;
          i = n;
          break;
        default: 
          k = 0;
        }
      }
      finally {}
      int j = 0;
      int i = 0;
    }
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!paramBoolean) {}
      System.gc();
      return a(paramInt1, paramInt2, false);
    }
    catch (Exception localException)
    {
      QLog.d("ShimmerLinearLayout", 1, localException.getMessage());
    }
    return localObject;
    return null;
  }
  
  private Bitmap aE()
  {
    if (this.fT == null) {
      this.fT = a(getWidth(), getHeight(), true);
    }
    return this.fT;
  }
  
  private void bd(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mMaskBitmap;
    if (localBitmap == null) {
      return;
    }
    if (this.mMaskBitmap.getWidth() != getWidth()) {
      localBitmap = getMaskBitmap();
    }
    paramCanvas.clipRect(this.mOffsetX, this.mOffsetY, this.mOffsetX + localBitmap.getWidth(), this.mOffsetY + localBitmap.getHeight());
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawBitmap(localBitmap, this.mOffsetX, this.mOffsetY, this.mMaskPaint);
  }
  
  private boolean e(Canvas paramCanvas)
  {
    Bitmap localBitmap = aE();
    if ((localBitmap == null) || (this.mMaskBitmap == null)) {
      return false;
    }
    super.dispatchDraw(paramCanvas);
    bd(new Canvas(localBitmap));
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    return true;
  }
  
  private Bitmap getMaskBitmap()
  {
    int i = this.mMaskBitmap.getWidth();
    int j = this.mMaskBitmap.getHeight();
    int k = getWidth() * j / i;
    Bitmap localBitmap = a(getWidth(), k, true);
    if (localBitmap != null)
    {
      new Canvas(localBitmap).drawBitmap(this.mMaskBitmap, new Rect(0, 0, i, j), new Rect(0, 0, getWidth(), k), null);
      this.mMaskBitmap = localBitmap;
      this.mAnimator = a(true);
      this.mAnimator.start();
    }
    return this.mMaskBitmap;
  }
  
  public void dFP()
  {
    if (this.mMaskBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShimmerLinearLayout", 2, "startShimmer mMaskBitmap = null");
      }
      return;
    }
    this.mAnimator = a(false);
    if (!this.mAnimator.isRunning()) {
      this.mAnimator.start();
    }
    this.cwR = true;
  }
  
  public void dFQ()
  {
    if (this.mMaskBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShimmerLinearLayout", 2, "stopShimmer mMaskBitmap = null");
      }
      return;
    }
    Bitmap localBitmap = aE();
    if (localBitmap != null) {
      new Canvas(localBitmap).drawColor(0, PorterDuff.Mode.CLEAR);
    }
    this.mAnimator = a(false);
    this.mAnimator.cancel();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((!this.cwR) || (getWidth() <= 0) || (getHeight() <= 0))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    e(paramCanvas);
  }
  
  void ji(int paramInt1, int paramInt2)
  {
    if ((this.mOffsetX == paramInt1) && (this.mOffsetY == paramInt2)) {
      return;
    }
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
    invalidate();
  }
  
  public void onDestroy()
  {
    if (this.mAnimator != null)
    {
      QLog.i("ShimmerLinearLayout", 1, "ShimmerLinearLayout.onDestroy");
      this.mAnimator.removeAllUpdateListeners();
      this.mAnimator.cancel();
    }
    this.mAnimator = null;
    this.cwR = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.i("ShimmerLinearLayout", 1, "ShimmerLinearLayout.onDetachedFromWindow()");
    onDestroy();
  }
  
  public void setMask(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMaskBitmap = paramBitmap;
    this.dty = paramInt1;
    this.dtz = paramInt2;
    this.mDuration = paramInt3;
  }
  
  static class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    private WeakReference<ShimmerLinearLayout> an;
    final int fromX;
    final int fromY;
    final int toX;
    final int toY;
    
    private a(ShimmerLinearLayout paramShimmerLinearLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.an = new WeakReference(paramShimmerLinearLayout);
      this.fromX = paramInt1;
      this.fromY = paramInt2;
      this.toX = paramInt3;
      this.toY = paramInt4;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f1 = Math.max(0.0F, Math.min(1.0F, ((Float)paramValueAnimator.getAnimatedValue()).floatValue()));
      paramValueAnimator = (ShimmerLinearLayout)this.an.get();
      if (paramValueAnimator != null)
      {
        int i = (int)(this.fromX * (1.0F - f1) + this.toX * f1);
        float f2 = this.fromY;
        paramValueAnimator.ji(i, (int)(f1 * this.toY + f2 * (1.0F - f1)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ShimmerLinearLayout
 * JD-Core Version:    0.7.0.1
 */