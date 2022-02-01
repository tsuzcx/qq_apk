package com.tencent.qqmail.view.imageview;

public class MoveAnimation
  implements Animation
{
  private long animationTimeMS = 100L;
  private boolean firstFrame = true;
  private MoveAnimationListener moveAnimationListener;
  private float startX;
  private float startY;
  private float targetX;
  private float targetY;
  private long totalTime = 0L;
  
  public long getAnimationTimeMS()
  {
    return this.animationTimeMS;
  }
  
  public float getTargetX()
  {
    return this.targetX;
  }
  
  public float getTargetY()
  {
    return this.targetY;
  }
  
  public void reset()
  {
    this.firstFrame = true;
    this.totalTime = 0L;
  }
  
  public void setAnimationTimeMS(long paramLong)
  {
    this.animationTimeMS = paramLong;
  }
  
  public void setMoveAnimationListener(MoveAnimationListener paramMoveAnimationListener)
  {
    this.moveAnimationListener = paramMoveAnimationListener;
  }
  
  public void setTargetX(float paramFloat)
  {
    this.targetX = paramFloat;
  }
  
  public void setTargetY(float paramFloat)
  {
    this.targetY = paramFloat;
  }
  
  public boolean update(QMGestureImageView paramQMGestureImageView, long paramLong)
  {
    boolean bool = false;
    this.totalTime += paramLong;
    if (this.firstFrame)
    {
      this.firstFrame = false;
      this.startX = paramQMGestureImageView.getImageX();
      this.startY = paramQMGestureImageView.getImageY();
    }
    if (this.totalTime < this.animationTimeMS)
    {
      f1 = (float)this.totalTime / (float)this.animationTimeMS;
      f2 = this.targetX;
      f3 = this.startX;
      f4 = this.startX;
      f5 = this.targetY;
      f6 = this.startY;
      f7 = this.startY;
      if (this.moveAnimationListener != null) {
        this.moveAnimationListener.onMove((f2 - f3) * f1 + f4, f1 * (f5 - f6) + f7);
      }
      bool = true;
    }
    while (this.moveAnimationListener == null)
    {
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      return bool;
    }
    this.moveAnimationListener.onMove(this.targetX, this.targetY);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.MoveAnimation
 * JD-Core Version:    0.7.0.1
 */