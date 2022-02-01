package com.tencent.qqmail.view.imageview;

import android.graphics.PointF;
import android.view.MotionEvent;

public class VectorF
{
  public float angle;
  public final PointF end = new PointF();
  public float length;
  public final PointF start = new PointF();
  
  public float calculateAngle()
  {
    this.angle = MathUtils.angle(this.start, this.end);
    return this.angle;
  }
  
  public void calculateEndPoint()
  {
    this.end.x = ((float)Math.cos(this.angle) * this.length + this.start.x);
    this.end.y = ((float)Math.sin(this.angle) * this.length + this.start.y);
  }
  
  public float calculateLength()
  {
    this.length = MathUtils.distance(this.start, this.end);
    return this.length;
  }
  
  public void set(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.start.x = paramMotionEvent.getX(0);
      this.start.y = paramMotionEvent.getY(0);
      this.end.x = paramMotionEvent.getX(1);
      this.end.y = paramMotionEvent.getY(1);
    }
  }
  
  public void setEnd(PointF paramPointF)
  {
    this.end.x = paramPointF.x;
    this.end.y = paramPointF.y;
  }
  
  public void setStart(PointF paramPointF)
  {
    this.start.x = paramPointF.x;
    this.start.y = paramPointF.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.VectorF
 * JD-Core Version:    0.7.0.1
 */