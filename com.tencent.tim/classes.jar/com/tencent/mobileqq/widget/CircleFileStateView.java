package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import atau.a;

public class CircleFileStateView
  extends View
{
  private boolean cZD;
  private int eeZ;
  private int efa = -16776961;
  private int efb = -16776961;
  private int efc = -7829368;
  private int efd;
  private int efe = -7829368;
  private int eff = -3355444;
  private int efg;
  private int efh;
  private Bitmap gG;
  private Bitmap gH;
  private float mDensity = getResources().getDisplayMetrics().density;
  private Paint mPaint;
  private float mProgress;
  private int mProgressBgColor = -1;
  private int mRadius;
  private int mRingWidth = 3;
  private int mShadowColor;
  private int mState;
  
  public CircleFileStateView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircleFileStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleFileStateView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pQ);
      this.efa = paramContext.getColor(10, -16776961);
      this.mProgressBgColor = paramContext.getColor(7, -1);
      this.efe = paramContext.getColor(0, -7829368);
      this.efb = paramContext.getColor(11, -16776961);
      this.efc = paramContext.getColor(8, -7829368);
      this.eff = paramContext.getColor(1, -3355444);
      this.efd = paramContext.getInteger(9, 255);
      this.eeZ = paramContext.getInteger(6, 51);
      this.mRingWidth = paramContext.getDimensionPixelOffset(12, 3);
      this.mProgress = paramContext.getInteger(2, 50);
      this.mState = paramContext.getInteger(3, 0);
      this.gG = drawableToBitmap(paramContext.getDrawable(4));
      this.gH = drawableToBitmap(paramContext.getDrawable(5));
      paramContext.recycle();
    }
    for (;;)
    {
      this.cZD = true;
      this.efg = this.efa;
      this.efh = this.efe;
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      setClickable(true);
      return;
      this.gG = BitmapFactory.decodeResource(paramContext.getResources(), 2130845127);
      this.gH = BitmapFactory.decodeResource(paramContext.getResources(), 2130845128);
    }
  }
  
  private Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public void TH(boolean paramBoolean)
  {
    this.cZD = paramBoolean;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setColor(this.efh);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setAlpha(255);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.mRadius / 2, this.mRadius / 2, this.mRadius / 2 - this.mRingWidth, this.mPaint);
    Bitmap localBitmap;
    switch (this.mState)
    {
    default: 
      localBitmap = null;
    }
    for (;;)
    {
      if (this.cZD)
      {
        this.mPaint.setColor(this.mProgressBgColor);
        this.mPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.mShadowColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mRingWidth);
        paramCanvas.drawArc(new RectF(this.mRingWidth / 2, this.mRingWidth / 2, this.mRadius - this.mRingWidth / 2, this.mRadius - this.mRingWidth / 2), -90.0F, 360.0F, false, this.mPaint);
        this.mPaint.setColor(this.efg);
        this.mPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.mShadowColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mRingWidth);
        paramCanvas.drawArc(new RectF(this.mRingWidth / 2, this.mRingWidth / 2, this.mRadius - this.mRingWidth / 2, this.mRadius - this.mRingWidth / 2), -90.0F, (float)(3.6D * this.mProgress), false, this.mPaint);
      }
      if (localBitmap != null)
      {
        this.mPaint.setAntiAlias(true);
        float f = (this.mRadius - this.mRingWidth * 2.0F) / localBitmap.getWidth();
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(f, f);
        localMatrix.postTranslate(this.mRingWidth, this.mRingWidth);
        paramCanvas.drawBitmap(localBitmap, localMatrix, this.mPaint);
      }
      return;
      localBitmap = null;
      continue;
      localBitmap = this.gH;
      continue;
      localBitmap = this.gG;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mRadius = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt1));
    setMeasuredDimension(this.mRadius, this.mRadius);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      this.efg = this.efa;
      if (this.mState != 1) {
        this.efg = this.efc;
      }
      this.efh = this.efe;
      invalidate();
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.efg = this.efb;
      this.efh = this.eff;
      invalidate();
    }
  }
  
  public void setBackGroundColor(int paramInt1, int paramInt2)
  {
    this.mProgressBgColor = paramInt2;
    this.eeZ = paramInt1;
  }
  
  public void setCenterBgColor(int paramInt)
  {
    this.efe = paramInt;
    this.efh = this.efe;
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt > 100)
    {
      f = 100.0F;
      this.mProgress = f;
      if (paramInt >= 0) {
        break label37;
      }
    }
    label37:
    for (float f = 0.0F;; f = paramInt)
    {
      this.mProgress = f;
      invalidate();
      return;
      f = paramInt;
      break;
    }
  }
  
  public void setProgressColor(int paramInt1, int paramInt2)
  {
    this.efa = paramInt1;
    this.efd = paramInt2;
    invalidate();
  }
  
  public void setProgressRingWidth(float paramFloat)
  {
    this.mRingWidth = ((int)(this.mDensity * paramFloat + 0.5D));
    this.mPaint.setStrokeWidth(this.mRingWidth);
    invalidate();
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
    this.efg = this.efa;
    if (this.mState != 1) {
      this.efg = this.efc;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleFileStateView
 * JD-Core Version:    0.7.0.1
 */