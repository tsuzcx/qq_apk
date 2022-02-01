package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

public abstract class ThreadBoundProxy
  implements ThreadBound
{
  private final ThreadBound mEnforcer;
  
  public ThreadBoundProxy(ThreadBound paramThreadBound)
  {
    this.mEnforcer = ((ThreadBound)Util.throwIfNull(paramThreadBound));
  }
  
  public final boolean checkThreadAccess()
  {
    return this.mEnforcer.checkThreadAccess();
  }
  
  public final <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable)
  {
    return this.mEnforcer.postAndWait(paramUncheckedCallable);
  }
  
  public final void postAndWait(Runnable paramRunnable)
  {
    this.mEnforcer.postAndWait(paramRunnable);
  }
  
  public final void postDelayed(Runnable paramRunnable, long paramLong)
  {
    this.mEnforcer.postDelayed(paramRunnable, paramLong);
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    this.mEnforcer.removeCallbacks(paramRunnable);
  }
  
  public final void verifyThreadAccess()
  {
    this.mEnforcer.verifyThreadAccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.helper.ThreadBoundProxy
 * JD-Core Version:    0.7.0.1
 */