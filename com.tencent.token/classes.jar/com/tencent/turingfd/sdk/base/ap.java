package com.tencent.turingfd.sdk.base;

import android.os.Handler;
import android.os.HandlerThread;

public class ap
{
  public static final dj a = new ao();
  public Handler b;
  
  public ap()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMWorker");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ap
 * JD-Core Version:    0.7.0.1
 */