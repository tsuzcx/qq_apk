package com.tencent.feedback.common;

import java.util.concurrent.ScheduledExecutorService;

public abstract class b
{
  private static b a;
  
  public static b a(ScheduledExecutorService paramScheduledExecutorService)
  {
    return new b.a(paramScheduledExecutorService);
  }
  
  public static void a(b paramb)
  {
    try
    {
      e.a("rqdp{  AsyncTaskHandlerAbs setInstance} " + paramb, new Object[0]);
      if ((a != null) && (a != paramb)) {
        a.a();
      }
      a = paramb;
      e.a("rqdp{  AsyncTaskHandlerAbs setInstance end}", new Object[0]);
      return;
    }
    finally {}
  }
  
  public static b b()
  {
    try
    {
      if (a == null) {
        a = new b.a();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public abstract boolean a();
  
  public abstract boolean a(Runnable paramRunnable);
  
  public abstract boolean a(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.b
 * JD-Core Version:    0.7.0.1
 */