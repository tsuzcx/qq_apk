package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;

public final class acm
{
  public static final afj<acm> a = new a();
  public Handler b;
  
  public acm()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMWorker");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public static final class a
    extends afj<acm>
  {
    public final Object a()
    {
      return new acm((byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acm
 * JD-Core Version:    0.7.0.1
 */