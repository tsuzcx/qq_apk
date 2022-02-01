package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class ProfileCardScrollImageView
  extends ImageView
{
  private DecelerateInterpolator b;
  private boolean daW;
  private int ehy;
  private int ehz;
  private boolean isDone;
  private int mDuration = 1500;
  private boolean mIsScroll;
  private int mScrollState = 3;
  private long mStartTimeMillis;
  
  public ProfileCardScrollImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ProfileCardScrollImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ProfileCardScrollImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (this.b == null) {
      this.b = new DecelerateInterpolator(1.0F);
    }
  }
  
  public void YD(int paramInt)
  {
    this.ehz = paramInt;
    this.mScrollState = 0;
    this.isDone = false;
    invalidate();
  }
  
  public void eiA()
  {
    this.mScrollState = 3;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.mIsScroll) {
      super.onDraw(paramCanvas);
    }
    for (;;)
    {
      return;
      switch (this.mScrollState)
      {
      }
      while (!this.isDone)
      {
        invalidate();
        return;
        super.onDraw(paramCanvas);
        continue;
        this.ehy = 0;
        this.mStartTimeMillis = SystemClock.uptimeMillis();
        this.mScrollState = 1;
        this.daW = false;
        super.onDraw(paramCanvas);
        continue;
        float f1;
        if (this.mStartTimeMillis >= 0L)
        {
          f1 = (float)(SystemClock.uptimeMillis() - this.mStartTimeMillis) / this.mDuration;
          if (f1 < 1.0F) {
            break label210;
          }
          if (this.daW) {
            break label202;
          }
          this.daW = true;
          this.mStartTimeMillis = SystemClock.uptimeMillis();
        }
        for (;;)
        {
          if (this.isDone) {
            this.mScrollState = 4;
          }
          paramCanvas.save();
          paramCanvas.translate(0.0F, this.ehy);
          super.onDraw(paramCanvas);
          paramCanvas.restore();
          if (!this.isDone) {
            break;
          }
          invalidate();
          break;
          label202:
          this.isDone = true;
          continue;
          label210:
          f1 = Math.min(f1, 1.0F);
          float f2;
          if (!this.daW)
          {
            f2 = this.ehz;
            this.ehy = ((int)(this.b.getInterpolation(f1) * f2));
          }
          else
          {
            int i = this.ehz;
            f2 = this.ehz;
            this.ehy = (i - (int)(this.b.getInterpolation(f1) * f2));
          }
        }
        paramCanvas.save();
        paramCanvas.translate(0.0F, 0.0F);
        super.onDraw(paramCanvas);
        paramCanvas.restore();
      }
    }
  }
  
  public void setIsScroll(boolean paramBoolean)
  {
    this.mIsScroll = paramBoolean;
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardScrollImageView
 * JD-Core Version:    0.7.0.1
 */