package com.tencent.qqmail.view.listscroller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;

public class ScrollContacTextView
  extends TextView
{
  public static final int PROGRESS_ANIMATE_DURATION = 20;
  private Runnable mAnimator = new ScrollContacTextView.1(this);
  protected int mCanTranslate;
  protected int mCenterDegree;
  protected int mCircleDuration = 200;
  protected long mCircleStartTime;
  protected int mCirclrCount;
  protected float mCurDegree;
  protected Bitmap mDrawLeft = ((BitmapDrawable)getCompoundDrawables()[0]).getBitmap();
  protected int mDrawLeftHalfHeight;
  protected int mDrawLeftHalfWidth;
  protected int mDrawLeftTop;
  protected int mDrawLeftWidth;
  protected int mEndDegree = -14;
  protected Handler mHandler = null;
  protected boolean mIsStart;
  protected Matrix mMatrix;
  protected Paint mPaint;
  protected int mPauseDuration = 200;
  protected long mPauseStartTime;
  private ScrollDialHandler mScrollDialHandler;
  protected int mScrollLeft;
  protected int mScrollX = 0;
  protected int mStartDegree = 28;
  
  public ScrollContacTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setCompoundDrawables(null, null, null, null);
    this.mDrawLeftWidth = this.mDrawLeft.getWidth();
    this.mDrawLeftHalfWidth = (this.mDrawLeftWidth >> 1);
    this.mDrawLeftHalfHeight = (this.mDrawLeft.getHeight() >> 1);
    this.mHandler = new Handler();
    this.mMatrix = new Matrix();
    this.mPaint = new Paint(1);
    this.mPaint.setFilterBitmap(true);
    this.mCenterDegree = (this.mStartDegree + (this.mEndDegree - this.mStartDegree >> 1));
  }
  
  public void doScrollTextView(int paramInt, boolean paramBoolean)
  {
    if (paramInt < this.mCanTranslate)
    {
      this.mScrollX = (paramInt - this.mCanTranslate);
      if (paramBoolean)
      {
        startCarton();
        return;
      }
    }
    stopCarton();
  }
  
  protected void drawComponent(Canvas paramCanvas)
  {
    if (this.mScrollX < 0)
    {
      paramCanvas.translate(this.mScrollX + this.mScrollLeft, 0.0F);
      paramCanvas.translate(0.0F, this.mDrawLeftTop);
      paramCanvas.drawBitmap(this.mDrawLeft, this.mMatrix, this.mPaint);
      paramCanvas.translate(this.mDrawLeftWidth, -this.mDrawLeftTop);
      return;
    }
    paramCanvas.translate(this.mScrollLeft, 0.0F);
    paramCanvas.drawBitmap(this.mDrawLeft, 0.0F, this.mDrawLeftTop, null);
    paramCanvas.translate(this.mDrawLeftWidth, 0.0F);
  }
  
  public int getCanScrollTextView()
  {
    return this.mCanTranslate;
  }
  
  public void invalidate()
  {
    if (this.mScrollDialHandler != null)
    {
      this.mScrollDialHandler.invalidate();
      return;
    }
    super.invalidate();
  }
  
  protected void looperSelf()
  {
    this.mHandler.removeCallbacks(this.mAnimator);
    this.mHandler.postDelayed(this.mAnimator, 20L);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    drawComponent(paramCanvas);
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCanTranslate = (this.mScrollLeft - (getWidth() - (int)getLayout().getPaint().measureText(getText(), 0, length()) - this.mDrawLeftWidth - getCompoundPaddingLeft() * 2 + DeviceUtil.dip2px(8.0F) >> 1));
    this.mDrawLeftTop = (getHeight() - this.mDrawLeft.getHeight() >> 1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void reset()
  {
    if (this.mScrollX != 0) {
      this.mScrollX = 0;
    }
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mScrollLeft = paramInt1;
    return super.setFrame(0, paramInt2, paramInt3, paramInt4);
  }
  
  public void setScrollDialHandler(ScrollDialHandler paramScrollDialHandler)
  {
    this.mScrollDialHandler = paramScrollDialHandler;
  }
  
  protected void startCarton()
  {
    if (!this.mIsStart)
    {
      this.mHandler.removeCallbacks(this.mAnimator);
      this.mHandler.post(this.mAnimator);
      this.mIsStart = true;
    }
  }
  
  protected void stopCarton()
  {
    if (this.mIsStart)
    {
      this.mHandler.removeCallbacks(this.mAnimator);
      this.mCircleStartTime = 0L;
      this.mCirclrCount = 0;
      this.mIsStart = false;
      this.mMatrix.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.ScrollContacTextView
 * JD-Core Version:    0.7.0.1
 */