package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;

public final class acn
{
  public static final afk<acn> a = new a();
  public Handler b;
  
  public acn()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMWorker");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public static final class a
    extends afk<acn>
  {
    public final Object a()
    {
      return new acn((byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acn
 * JD-Core Version:    0.7.0.1
 */