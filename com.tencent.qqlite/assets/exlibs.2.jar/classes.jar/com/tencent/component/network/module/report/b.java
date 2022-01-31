package com.tencent.component.network.module.report;

import android.os.Handler;
import android.os.HandlerThread;

public final class b
  extends HandlerThread
{
  private Handler a;
  
  static
  {
    new b("CommonTaskThread");
  }
  
  public b(String paramString)
  {
    super(paramString, 10);
    start();
  }
  
  public final void a(Runnable paramRunnable)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public final void b(Runnable paramRunnable)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.postDelayed(paramRunnable, 300000L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.b
 * JD-Core Version:    0.7.0.1
 */