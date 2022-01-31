package com.tencent.turingfd.sdk.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class cr
{
  public static final dj a = new cg();
  public boolean b = false;
  public ce c;
  public Handler d;
  public Handler e;
  public final List f = new ArrayList();
  public et g;
  public by h;
  public final cs i = new cs(this, "checkStopSensor");
  public final Runnable j = new ci(this, "openSensorCallback");
  
  public cr()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMSensor");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public final void a()
  {
    ??? = this.c;
    if (??? != null) {
      ((ce)???).b();
    }
    synchronized (this.f)
    {
      this.f.clear();
      return;
    }
  }
  
  public final void a(Handler paramHandler, by paramby)
  {
    for (;;)
    {
      try
      {
        if (this.b)
        {
          ??? = this.g;
          if (??? != null) {}
        }
        else
        {
          return;
        }
        this.b = false;
        paramHandler.removeCallbacks(this.j);
        paramHandler.removeCallbacks(this.i);
        paramHandler = this.c;
        if (paramHandler == null) {
          continue;
        }
        paramHandler.a();
        paramHandler = this.c;
        if ((int)(paramHandler.e.d / dy.a) < 1)
        {
          ((j)paramby).a(-100);
          continue;
        }
        paramHandler = paramHandler.c();
      }
      finally {}
      if (paramHandler.size() == 0)
      {
        ((j)paramby).a(-101);
        continue;
      }
      synchronized (this.f)
      {
        ArrayList localArrayList = new ArrayList(this.f);
        if (localArrayList.size() < 1)
        {
          ((j)paramby).a(-102);
          continue;
        }
        ??? = this.g;
        ((j)paramby).a((et)???, localArrayList, paramHandler);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cr
 * JD-Core Version:    0.7.0.1
 */