package com.tencent.qqmail.view.imageview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class FlingListener
  extends GestureDetector.SimpleOnGestureListener
{
  private float velocityX;
  private float velocityY;
  
  public float getVelocityX()
  {
    return this.velocityX;
  }
  
  public float getVelocityY()
  {
    return this.velocityY;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.velocityX = paramFloat1;
    this.velocityY = paramFloat2;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.FlingListener
 * JD-Core Version:    0.7.0.1
 */