package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;

public final class adl
{
  public static final agi<adl> a = new a();
  public Handler b;
  
  public adl()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMWorker");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public final class a
    extends agi<adl>
  {
    public final Object a()
    {
      return new adl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adl
 * JD-Core Version:    0.7.0.1
 */