package com.tencent.mobileqq.ar.ARRecord;

import adcj;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ARVideoRecordButtonView
  extends View
{
  private int azd = 2;
  private Bitmap bw;
  private Bitmap eQ;
  private Paint mBackgroundPaint;
  private Bitmap mGrayBitmap;
  private Paint mPaint;
  private float mProgress = 0.0F;
  private Rect mRect;
  private RectF mRectF;
  private float sW = 0.0F;
  
  public ARVideoRecordButtonView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public ARVideoRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public ARVideoRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void O(float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new adcj(this));
    localValueAnimator.start();
  }
  
  private Bitmap b(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void cPY()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  private void initUI()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-48606);
    this.mBackgroundPaint = new Paint();
    this.mBackgroundPaint.setAntiAlias(true);
    this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
    this.mBackgroundPaint.setColor(-1);
    this.mRectF = new RectF();
    this.mRect = new Rect();
    this.eQ = b(2130838731);
    this.bw = b(2130838732);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    switch (this.azd)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
        } while (this.mGrayBitmap == null);
        this.mRect.set(0, 0, this.mGrayBitmap.getWidth(), this.mGrayBitmap.getHeight());
        this.mRectF.set(0.0F, 0.0F, i, j);
        paramCanvas.drawBitmap(this.mGrayBitmap, this.mRect, this.mRectF, this.mPaint);
        return;
      } while (this.eQ == null);
      this.mRect.set(0, 0, this.eQ.getWidth(), this.eQ.getHeight());
      this.mRectF.set(0.0F, 0.0F, i, j);
      paramCanvas.drawBitmap(this.eQ, this.mRect, this.mRectF, this.mPaint);
      return;
    }
    if (this.bw != null)
    {
      this.mRect.set(0, 0, this.bw.getWidth(), this.bw.getHeight());
      this.mRectF.set(0.0F, 0.0F, i, j);
      paramCanvas.drawBitmap(this.bw, this.mRect, this.mRectF, this.mPaint);
    }
    float f1 = 0.08571429F * i;
    float f2 = Math.min(i, j) / 2 - f1 - 0.002857143F * i;
    this.mRectF.set(i / 2 - f2, j / 2 - f2, i / 2 + f2, j / 2 + f2);
    this.mBackgroundPaint.setStrokeWidth(f1);
    this.mPaint.setStrokeWidth(f1);
    paramCanvas.drawArc(this.mRectF, -90.0F, 360.0F, false, this.mBackgroundPaint);
    f1 = this.mProgress;
    paramCanvas.drawArc(this.mRectF, -90.0F, 360.0F - (1.0F - f1) * 360.0F, false, this.mPaint);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
  
  public void setProgress(long paramLong1, long paramLong2)
  {
    float f = Math.min(1.0F, Math.max((float)paramLong1 * 1.0F / (float)paramLong2, 0.0F));
    if (this.azd == 3) {
      ThreadManager.getUIHandler().post(new ARVideoRecordButtonView.1(this, f));
    }
  }
  
  public void setShowState(int paramInt)
  {
    this.azd = paramInt;
    switch (this.azd)
    {
    }
    for (;;)
    {
      cPY();
      return;
      super.setAlpha(1.0F);
      continue;
      this.sW = 0.0F;
      this.mProgress = 0.0F;
      ThreadManager.getUIHandler().post(new ARVideoRecordButtonView.2(this));
      continue;
      this.mProgress = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView
 * JD-Core Version:    0.7.0.1
 */