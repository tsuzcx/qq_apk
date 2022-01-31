package com.tencent.turingfd.sdk.base;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class t
  implements ae
{
  public t(z paramz, AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
  
  public void a(int paramInt, float arg2)
  {
    if (this.a.get()) {
      return;
    }
    if ((paramInt == 0) && (??? != null)) {
      this.b.set(???);
    }
    synchronized (this.c)
    {
      this.c.notify();
      return;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.t
 * JD-Core Version:    0.7.0.1
 */