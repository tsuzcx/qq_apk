package com.tencent.token;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class agy
  implements Runnable
{
  public agy(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
  
  public final void run()
  {
    if (this.a.get()) {
      return;
    }
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      ??? = agg.a(agg.aH);
      StackTraceElement[] arrayOfStackTraceElement = localException.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localStackTraceElement.getClassName());
        localStringBuilder.append("_");
        localStringBuilder.append(localStackTraceElement.getMethodName());
        if (((String)???).equals(localStringBuilder.toString())) {
          this.b.set(Boolean.TRUE);
        }
        i += 1;
      }
      synchronized (this.c)
      {
        this.c.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agy
 * JD-Core Version:    0.7.0.1
 */