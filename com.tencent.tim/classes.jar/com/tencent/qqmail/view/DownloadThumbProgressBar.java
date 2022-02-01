package com.tencent.qqmail.view;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class DownloadThumbProgressBar
  extends View
{
  public static final int STATE_DOWNLOADED = 3;
  public static final int STATE_DOWNLOADING = 1;
  public static final int STATE_PAUSED = 2;
  public static final int STATE_UNDOWNLOAD = 0;
  private static final String UNDOWNLOAD_TIPS = "未下载";
  private PorterDuffXfermode mAddfermode;
  private PorterDuffXfermode mClearXfermode;
  private Context mContext;
  private int mCurrentProgress = 0;
  private float mFinishAnimateRadius;
  private boolean mIsFailPause = false;
  private boolean mIsFinishAnimating = false;
  private boolean mIsPauseAnimating = false;
  private int mMax = 100;
  private int mOuterDistance;
  private Paint mPaint;
  private int mPauseMaxRadius;
  private RectF mPauseOval;
  private int mPauseRadius;
  private ValueAnimator mProgressChangeAnimator;
  private int mProgressMaskColor;
  private RectF mProgressOval;
  private int mRadiusInner;
  private int mRadiusOuter;
  private int mRingWidth;
  private PorterDuffXfermode mSrcXfermode;
  private int mState = 0;
  private Bitmap mUnStartBitmap;
  
  public DownloadThumbProgressBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DownloadThumbProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mProgressMaskColor = this.mContext.getResources().getColor(2131166565);
    this.mOuterDistance = QMUIKit.dpToPx(4);
    this.mRingWidth = QMUIKit.dpToPx(2);
    this.mPauseMaxRadius = QMUIKit.dpToPx(10);
    this.mPaint = new Paint();
    this.mPaint.setColor(this.mProgressMaskColor);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setAntiAlias(true);
    this.mClearXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.mSrcXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC);
    this.mAddfermode = new PorterDuffXfermode(PorterDuff.Mode.ADD);
    this.mProgressOval = new RectF();
    this.mPauseOval = new RectF();
    this.mUnStartBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130840898);
  }
  
  private void progressAnim(int paramInt, Animator.AnimatorListener paramAnimatorListener)
  {
    if ((this.mProgressChangeAnimator != null) && (this.mProgressChangeAnimator.isRunning()))
    {
      this.mProgressChangeAnimator.removeAllUpdateListeners();
      this.mProgressChangeAnimator.cancel();
    }
    this.mProgressChangeAnimator = ValueAnimator.ofInt(new int[] { this.mCurrentProgress, paramInt });
    this.mProgressChangeAnimator.setDuration(200L);
    this.mProgressChangeAnimator.addUpdateListener(new DownloadThumbProgressBar.1(this));
    if (paramAnimatorListener != null) {
      this.mProgressChangeAnimator.addListener(paramAnimatorListener);
    }
    this.mProgressChangeAnimator.start();
  }
  
  public void complete()
  {
    Threads.runOnMainThread(new DownloadThumbProgressBar.6(this), 200L);
  }
  
  public int getCurrentProgress()
  {
    return this.mCurrentProgress;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i;
    switch (this.mState)
    {
    default: 
      return;
    case 0: 
      this.mPaint.setXfermode(null);
      paramCanvas.drawBitmap(this.mUnStartBitmap, getWidth() - this.mUnStartBitmap.getWidth(), getHeight() - this.mUnStartBitmap.getHeight(), this.mPaint);
      return;
    case 1: 
    case 2: 
      i = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      paramCanvas.drawARGB(127, 0, 0, 0);
      this.mPaint.setXfermode(this.mClearXfermode);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadiusOuter, this.mPaint);
      this.mPaint.setXfermode(this.mSrcXfermode);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadiusInner, this.mPaint);
      this.mPaint.setXfermode(this.mClearXfermode);
      if ((this.mMax <= 0) || (this.mCurrentProgress < 0)) {
        break;
      }
    }
    for (float f1 = 360.0F * (this.mCurrentProgress / this.mMax);; f1 = 0.0F)
    {
      paramCanvas.drawArc(this.mProgressOval, 270.0F, f1, true, this.mPaint);
      if (this.mState == 2)
      {
        this.mPauseOval.left = (getWidth() / 2.0F - this.mPauseRadius);
        this.mPauseOval.top = (getHeight() / 2.0F - this.mPauseRadius);
        this.mPauseOval.right = (getWidth() / 2.0F + this.mPauseRadius);
        this.mPauseOval.bottom = (getHeight() / 2.0F + this.mPauseRadius);
        this.mPaint.setXfermode(this.mAddfermode);
        paramCanvas.drawArc(this.mPauseOval, 270.0F, f1, true, this.mPaint);
        this.mPaint.setXfermode(this.mClearXfermode);
        f1 = (float)(this.mPauseOval.left + this.mPauseRadius * 0.6444D);
        float f2 = (float)(this.mPauseOval.right - this.mPauseRadius * 0.6444D);
        float f3 = (float)(this.mPauseOval.top + this.mPauseRadius * 0.5111D);
        float f4 = (float)(this.mPauseRadius * 0.13333D);
        float f5 = (float)(this.mPauseOval.bottom - this.mPauseRadius * 0.5111D);
        paramCanvas.drawRect(f1, f3, f1 + f4, f5, this.mPaint);
        paramCanvas.drawRect(f2 - f4, f3, f2, f5, this.mPaint);
      }
      paramCanvas.restoreToCount(i);
      return;
      if (!this.mIsFinishAnimating) {
        break;
      }
      i = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      paramCanvas.drawARGB(127, 0, 0, 0);
      this.mPaint.setXfermode(this.mClearXfermode);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mFinishAnimateRadius, this.mPaint);
      paramCanvas.restoreToCount(i);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mRadiusOuter = (getMeasuredWidth() / 2 - this.mOuterDistance);
    this.mRadiusInner = (this.mRadiusOuter - this.mRingWidth);
    this.mFinishAnimateRadius = this.mRadiusOuter;
    this.mProgressOval.left = ((getMeasuredWidth() - this.mRadiusInner * 2.0F) / 2.0F - QMUIKit.dpToPx(1));
    this.mProgressOval.top = ((getMeasuredHeight() - this.mRadiusInner * 2.0F) / 2.0F - QMUIKit.dpToPx(1));
    this.mProgressOval.right = (getMeasuredWidth() - (getMeasuredWidth() - this.mRadiusInner * 2) / 2.0F + QMUIKit.dpToPx(1));
    this.mProgressOval.bottom = (getMeasuredHeight() - (getMeasuredHeight() - this.mRadiusInner * 2.0F) / 2.0F + QMUIKit.dpToPx(1));
  }
  
  public void pause(boolean paramBoolean)
  {
    this.mIsFailPause = paramBoolean;
    if ((this.mProgressChangeAnimator != null) && (this.mProgressChangeAnimator.isRunning()))
    {
      this.mProgressChangeAnimator.removeAllUpdateListeners();
      this.mProgressChangeAnimator.cancel();
    }
    setState(2);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.mPauseMaxRadius });
    localValueAnimator.addUpdateListener(new DownloadThumbProgressBar.4(this));
    localValueAnimator.addListener(new DownloadThumbProgressBar.5(this));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
  
  public void setCurrProgressNoAnim(int paramInt)
  {
    this.mCurrentProgress = paramInt;
    invalidate();
  }
  
  public void setCurrentProgress(int paramInt)
  {
    if (this.mState != 1) {}
    while (paramInt > this.mMax) {
      return;
    }
    progressAnim(paramInt, null);
  }
  
  public void setMax(int paramInt)
  {
    this.mMax = paramInt;
  }
  
  public void setState(int paramInt)
  {
    if (!this.mIsPauseAnimating)
    {
      this.mState = paramInt;
      invalidate();
    }
  }
  
  public void start()
  {
    this.mIsFailPause = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.mPauseMaxRadius, 0 });
    localValueAnimator.addUpdateListener(new DownloadThumbProgressBar.2(this));
    localValueAnimator.addListener(new DownloadThumbProgressBar.3(this));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DownloadThumbProgressBar
 * JD-Core Version:    0.7.0.1
 */