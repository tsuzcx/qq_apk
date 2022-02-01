package com.facebook.stetho.common.android;

import com.facebook.stetho.common.UncheckedCallable;

final class HandlerUtil$1
  extends HandlerUtil.WaitableRunnable<V>
{
  HandlerUtil$1(UncheckedCallable paramUncheckedCallable) {}
  
  protected V onRun()
  {
    return this.val$c.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.HandlerUtil.1
 * JD-Core Version:    0.7.0.1
 */