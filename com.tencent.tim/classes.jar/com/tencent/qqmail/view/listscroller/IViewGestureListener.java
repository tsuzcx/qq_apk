package com.tencent.qqmail.view.listscroller;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public abstract interface IViewGestureListener
  extends GestureDetector.OnGestureListener
{
  public abstract boolean doTouchUp(MotionEvent paramMotionEvent);
  
  public abstract boolean doTounchDown(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.IViewGestureListener
 * JD-Core Version:    0.7.0.1
 */