package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class VideoFeedsCustomFrameLayout
  extends FrameLayout
{
  private boolean aov;
  private float jM;
  private float jN;
  private boolean mIsScrollable = true;
  
  public VideoFeedsCustomFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsCustomFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsCustomFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jM = paramMotionEvent.getY();
      this.jN = paramMotionEvent.getX();
    }
    while ((paramMotionEvent.getAction() != 2) || (this.mIsScrollable) || (paramMotionEvent.getY() - this.jM <= 300.0F) || (this.aov)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    this.aov = true;
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mIsScrollable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCustomFrameLayout
 * JD-Core Version:    0.7.0.1
 */