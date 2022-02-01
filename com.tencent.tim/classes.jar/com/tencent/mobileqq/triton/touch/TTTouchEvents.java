package com.tencent.mobileqq.triton.touch;

import com.tencent.mobileqq.triton.jni.TTNativeCall;
import java.util.ArrayList;

public class TTTouchEvents
{
  @TTNativeCall
  public int action;
  @TTNativeCall
  public ArrayList<Touch> changedTouches = new ArrayList();
  @TTNativeCall
  public double timeStamp;
  @TTNativeCall
  public ArrayList<Touch> touches = new ArrayList();
  
  public TTTouchEvents a()
  {
    TTTouchEvents localTTTouchEvents = new TTTouchEvents();
    localTTTouchEvents.action = this.action;
    localTTTouchEvents.timeStamp = this.timeStamp;
    localTTTouchEvents.touches.addAll(this.touches);
    localTTTouchEvents.changedTouches.addAll(this.changedTouches);
    return localTTTouchEvents;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.TTTouchEvents
 * JD-Core Version:    0.7.0.1
 */