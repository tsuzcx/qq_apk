package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;

public final class a
  implements Thread.UncaughtExceptionHandler
{
  private static c a = ;
  private static volatile a b = null;
  private static Thread.UncaughtExceptionHandler c = null;
  private boolean d = false;
  private Context e = null;
  
  private a(Context paramContext)
  {
    this.e = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  public void a()
  {
    if (c != null) {
      return;
    }
    c = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(b);
    a.h("set up java crash handler:" + b);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.d) {
      a.f("already handle the uncaugth exception:" + paramThrowable);
    }
    do
    {
      do
      {
        return;
        this.d = true;
        a.h("catch app crash");
        StatServiceImpl.a(this.e, paramThrowable);
      } while (c == null);
      a.h("Call the original uncaught exception handler.");
    } while ((c instanceof a));
    c.uncaughtException(paramThread, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.a
 * JD-Core Version:    0.7.0.1
 */