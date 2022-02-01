package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import aqho;
import ncn;

public class BezierSideBarView
  extends View
{
  ValueAnimator F;
  protected Paint aE = new Paint();
  private int aXD;
  private float kj;
  private Paint mArrowPaint = new Paint();
  private Bitmap mBitmap;
  private int mCenterY;
  protected Drawable mDrawable;
  private int mRadius;
  private float mRatio;
  private int mWidth;
  private Path s = new Path();
  
  public BezierSideBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void ad(Canvas paramCanvas)
  {
    this.s.reset();
    this.s.moveTo(this.mWidth, oN());
    int i = this.mCenterY - this.mRadius * 2;
    int k = (int)(this.mWidth - this.mRadius * Math.cos(0.7853981633974483D) * this.mRatio);
    int j = (int)(i + this.mRadius * Math.sin(0.7853981633974483D));
    this.s.quadTo(this.mWidth, i, k, j);
    i = (int)(this.mWidth - t());
    j = this.mCenterY;
    int m = this.mCenterY + this.mRadius * 2;
    int n = (int)(m - this.mRadius * Math.cos(0.7853981633974483D));
    this.s.quadTo(i, j, k, n);
    this.s.quadTo(this.mWidth, m, this.mWidth, oO());
    this.s.close();
    paramCanvas.drawPath(this.s, this.aE);
    if ((this.mBitmap != null) && (this.mDrawable == null))
    {
      k = this.mBitmap.getWidth();
      m = this.mBitmap.getHeight();
      n = i + 50;
      int i1 = j - m / 2;
      Rect localRect1 = new Rect(0, 0, k, m);
      Rect localRect2 = new Rect(n, i1, k + n, m + i1);
      this.mArrowPaint.setAlpha((int)(this.mRatio * 255.0F));
      paramCanvas.drawBitmap(this.mBitmap, localRect1, localRect2, this.mArrowPaint);
    }
    if (this.mDrawable != null)
    {
      this.mDrawable.getIntrinsicWidth();
      k = this.mDrawable.getIntrinsicHeight() / 2;
      paramCanvas.save();
      paramCanvas.translate(i + 50, j - k);
      this.mDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.kj = ((int)aqho.convertDpToPixel(paramContext, 18.0F));
    this.aXD = -16777216;
    this.mRadius = ((int)aqho.convertDpToPixel(paramContext, 18.0F));
    this.mArrowPaint = new Paint();
    this.mArrowPaint.setAntiAlias(true);
    this.mArrowPaint.setStyle(Paint.Style.FILL);
    this.mArrowPaint.setColor(-1);
    this.aE = new Paint();
    this.aE.setAntiAlias(true);
    this.aE.setStyle(Paint.Style.FILL);
    this.aE.setColor(this.aXD);
    paramAttributeSet = BitmapFactory.decodeResource(paramContext.getResources(), 2130844076);
    if (paramAttributeSet != null) {
      this.mBitmap = Bitmap.createScaledBitmap(paramAttributeSet, (int)aqho.convertDpToPixel(paramContext, 7.0F), (int)aqho.convertDpToPixel(paramContext, 12.0F), true);
    }
  }
  
  public void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.F == null) {
      this.F = new ValueAnimator();
    }
    this.F.cancel();
    this.F.setFloatValues(new float[] { this.mRatio, 0.0F });
    this.F.addUpdateListener(new ncn(this, paramAnimatorUpdateListener));
    this.F.start();
  }
  
  public void aNo()
  {
    a(null);
  }
  
  public void d(float paramFloat, int paramInt)
  {
    this.mCenterY = paramInt;
    if (paramFloat < 0.0F) {
      return;
    }
    float f = paramFloat;
    if (paramFloat > this.kj) {
      f = this.kj;
    }
    this.mRatio = (f / this.kj);
    invalidate();
  }
  
  public int getRadius()
  {
    return this.mRadius;
  }
  
  protected int oN()
  {
    return this.mCenterY - this.mRadius * 3;
  }
  
  protected int oO()
  {
    return this.mCenterY + this.mRadius * 2 + this.mRadius;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ad(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = getMeasuredWidth();
    this.mCenterY = (getMeasuredHeight() / 2);
  }
  
  public int qu()
  {
    return this.mCenterY;
  }
  
  public double t()
  {
    return 1.8F * this.mRadius * Math.sin(1.570796326794897D) * this.mRatio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView
 * JD-Core Version:    0.7.0.1
 */