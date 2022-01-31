package com.tencent.av.opengl.gesture;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class FlingListener
  extends GestureDetector.SimpleOnGestureListener
{
  private float a;
  private float b;
  
  public float a()
  {
    return this.a;
  }
  
  public float b()
  {
    return this.b;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.FlingListener
 * JD-Core Version:    0.7.0.1
 */