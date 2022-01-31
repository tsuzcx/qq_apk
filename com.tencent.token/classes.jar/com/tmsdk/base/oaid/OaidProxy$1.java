package com.tmsdk.base.oaid;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

final class OaidProxy$1
  extends Thread
{
  OaidProxy$1(AtomicReference paramAtomicReference, Context paramContext, Object paramObject) {}
  
  public void run()
  {
    this.v.set(OaidProxy.doGetOaid(this.w));
    try
    {
      synchronized (this.x)
      {
        this.x.notifyAll();
        label28:
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.oaid.OaidProxy.1
 * JD-Core Version:    0.7.0.1
 */