package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class VideoFeedsGestureProgressView
  extends View
{
  private Paint mPaint = new Paint();
  private float mPercent;
  
  public VideoFeedsGestureProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsGestureProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsGestureProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setColor(1711276032);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.mPaint);
    this.mPaint.setColor(-1);
    paramCanvas.drawRect(0.0F, getHeight() - getHeight() * this.mPercent, getWidth(), getHeight(), this.mPaint);
  }
  
  public void setProgress(float paramFloat)
  {
    this.mPercent = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureProgressView
 * JD-Core Version:    0.7.0.1
 */