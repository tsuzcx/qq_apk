package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import aqcx;
import ram;

public class ProgressPointer
  extends View
  implements Handler.Callback
{
  private long Co;
  private int frameHeight;
  private int frameWidth;
  private Handler handler = new Handler(Looper.getMainLooper(), this);
  private int mDuration;
  private int mEnd;
  private int mHeight;
  private int mPadding;
  private Paint mPaint;
  private float mProgress = -1.0F;
  private int mStart;
  
  public ProgressPointer(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ProgressPointer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ProgressPointer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPadding = aqcx.dip2px(getContext(), ScrollFrameSelectBar.PADDING_LEFT_DP);
  }
  
  public void bvB()
  {
    this.Co = System.currentTimeMillis();
    this.mProgress = 0.0F;
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      long l1 = System.currentTimeMillis();
      long l2 = this.Co;
      this.Co = l1;
      this.mProgress = ((float)(l1 - l2) * 100.0F / this.mDuration + this.mProgress);
      if (this.mProgress > 100.0F) {
        this.mProgress = 100.0F;
      }
      invalidate();
      this.handler.sendEmptyMessageDelayed(1, 50L);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.handler.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mProgress >= 0.0F)
    {
      float f = (this.mEnd - this.mStart) * this.mProgress / 100.0F + this.mStart;
      paramCanvas.drawRect(f - 2.0F, 0.0F, 2.0F + f, this.frameHeight, this.mPaint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mHeight = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void reset()
  {
    this.Co = System.currentTimeMillis();
    this.mProgress = 100.0F;
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessage(1);
  }
  
  public void setFrameSize(int paramInt1, int paramInt2)
  {
    this.frameHeight = paramInt1;
    this.frameWidth = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2, int paramInt3)
  {
    ram.a("Q.qqstory.frameWidget.ProgressPointer", "++++++++setRange++++++start=%s,end=%s,duration=%s,mProgress=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(this.mProgress));
    this.mStart = paramInt1;
    this.mEnd = paramInt2;
    this.mDuration = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ProgressPointer
 * JD-Core Version:    0.7.0.1
 */