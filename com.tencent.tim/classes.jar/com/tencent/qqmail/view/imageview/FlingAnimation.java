package com.tencent.qqmail.view.imageview;

public class FlingAnimation
  implements Animation
{
  private float factor = 0.85F;
  private FlingAnimationListener listener;
  private float threshold = 10.0F;
  private float velocityX;
  private float velocityY;
  
  public void setFactor(float paramFloat)
  {
    this.factor = paramFloat;
  }
  
  public void setListener(FlingAnimationListener paramFlingAnimationListener)
  {
    this.listener = paramFlingAnimationListener;
  }
  
  public void setVelocityX(float paramFloat)
  {
    this.velocityX = paramFloat;
  }
  
  public void setVelocityY(float paramFloat)
  {
    this.velocityY = paramFloat;
  }
  
  public boolean update(QMGestureImageView paramQMGestureImageView, long paramLong)
  {
    float f1 = (float)paramLong / 1000.0F;
    float f2 = this.velocityX;
    float f3 = this.velocityY;
    this.velocityX *= this.factor;
    this.velocityY *= this.factor;
    if ((Math.abs(this.velocityX) > this.threshold) && (Math.abs(this.velocityY) > this.threshold)) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.listener != null)
      {
        this.listener.onMove(f2 * f1, f3 * f1);
        if (!bool) {
          this.listener.onComplete();
        }
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.FlingAnimation
 * JD-Core Version:    0.7.0.1
 */