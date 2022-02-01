package com.facebook.stetho.common;

public abstract interface ThreadBound
{
  public abstract boolean checkThreadAccess();
  
  public abstract <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable);
  
  public abstract void postAndWait(Runnable paramRunnable);
  
  public abstract void postDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract void removeCallbacks(Runnable paramRunnable);
  
  public abstract void verifyThreadAccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.ThreadBound
 * JD-Core Version:    0.7.0.1
 */