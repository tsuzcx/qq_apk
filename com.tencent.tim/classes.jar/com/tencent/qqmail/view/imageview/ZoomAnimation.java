package com.tencent.qqmail.view.imageview;

import android.graphics.PointF;
import android.util.Log;

public class ZoomAnimation
  implements Animation
{
  private long animationLengthMS = 200L;
  private boolean firstFrame = true;
  private float scaleDiff;
  private float startScale;
  private float startX;
  private float startY;
  private long totalTime = 0L;
  private float touchX;
  private float touchY;
  private float xDiff;
  private float yDiff;
  private float zoom;
  private ZoomAnimationListener zoomAnimationListener;
  
  public long getAnimationLengthMS()
  {
    return this.animationLengthMS;
  }
  
  public float getTouchX()
  {
    return this.touchX;
  }
  
  public float getTouchY()
  {
    return this.touchY;
  }
  
  public float getZoom()
  {
    return this.zoom;
  }
  
  public ZoomAnimationListener getZoomAnimationListener()
  {
    return this.zoomAnimationListener;
  }
  
  public void reset()
  {
    this.firstFrame = true;
    this.totalTime = 0L;
  }
  
  public void setAnimationLengthMS(long paramLong)
  {
    this.animationLengthMS = paramLong;
  }
  
  public void setTouchX(float paramFloat)
  {
    this.touchX = paramFloat;
  }
  
  public void setTouchY(float paramFloat)
  {
    this.touchY = paramFloat;
  }
  
  public void setZoom(float paramFloat)
  {
    this.zoom = paramFloat;
  }
  
  public void setZoomAnimationListener(ZoomAnimationListener paramZoomAnimationListener)
  {
    this.zoomAnimationListener = paramZoomAnimationListener;
  }
  
  public boolean update(QMGestureImageView paramQMGestureImageView, long paramLong)
  {
    if (this.firstFrame)
    {
      Log.d("download", "imageview-> zoom animation first");
      this.firstFrame = false;
      this.startX = paramQMGestureImageView.getImageX();
      this.startY = paramQMGestureImageView.getImageY();
      this.startScale = paramQMGestureImageView.getScale();
      this.scaleDiff = (this.zoom * this.startScale - this.startScale);
      if (this.scaleDiff <= 0.0F) {
        break label294;
      }
      paramQMGestureImageView = new VectorF();
      paramQMGestureImageView.setStart(new PointF(this.touchX, this.touchY));
      paramQMGestureImageView.setEnd(new PointF(this.startX, this.startY));
      paramQMGestureImageView.calculateAngle();
      paramQMGestureImageView.length = (paramQMGestureImageView.calculateLength() * this.zoom);
      paramQMGestureImageView.calculateEndPoint();
      this.xDiff = (paramQMGestureImageView.end.x - this.startX);
    }
    for (this.yDiff = (paramQMGestureImageView.end.y - this.startY);; this.yDiff = (paramQMGestureImageView.getCenterY() - this.startY))
    {
      this.totalTime += paramLong;
      f1 = (float)this.totalTime / (float)this.animationLengthMS;
      if (f1 >= 1.0F) {
        break;
      }
      if (f1 > 0.0F)
      {
        f2 = this.scaleDiff;
        f3 = this.startScale;
        f4 = this.xDiff;
        f5 = this.startX;
        f6 = this.yDiff;
        float f7 = this.startY;
        if (this.zoomAnimationListener != null) {
          this.zoomAnimationListener.onZoom(f2 * f1 + f3, f4 * f1 + f5, f1 * f6 + f7);
        }
      }
      Log.d("download", "imageview-> zoom animation <1 ");
      return true;
      label294:
      this.xDiff = (paramQMGestureImageView.getCenterX() - this.startX);
    }
    float f1 = this.scaleDiff;
    float f2 = this.startScale;
    float f3 = this.xDiff;
    float f4 = this.startX;
    float f5 = this.yDiff;
    float f6 = this.startY;
    if (this.zoomAnimationListener != null)
    {
      this.zoomAnimationListener.onZoom(f1 + f2, f3 + f4, f5 + f6);
      this.zoomAnimationListener.onComplete();
    }
    Log.d("download", "imageview-> zoom animation =1 ");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.ZoomAnimation
 * JD-Core Version:    0.7.0.1
 */