package com.tencent.turingfd.sdk.base;

import android.os.Handler;
import android.os.HandlerThread;

public class aa
{
  public static final cx<aa> a = new a();
  public Handler b;
  
  public aa()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMWorker");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public static final class a
    extends cx<aa>
  {
    public Object a()
    {
      return new aa(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.aa
 * JD-Core Version:    0.7.0.1
 */