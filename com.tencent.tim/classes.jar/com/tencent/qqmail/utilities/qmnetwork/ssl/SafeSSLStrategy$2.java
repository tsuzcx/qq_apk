package com.tencent.qqmail.utilities.qmnetwork.ssl;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.functions.Action0;

class SafeSSLStrategy$2
  implements Action0
{
  SafeSSLStrategy$2(SafeSSLStrategy paramSafeSSLStrategy, int paramInt, AtomicBoolean paramAtomicBoolean) {}
  
  public void call()
  {
    synchronized (SafeSSLStrategy.access$300().get(Integer.valueOf(this.val$id)))
    {
      ???.notifyAll();
      this.val$hasNotify.set(true);
      SafeSSLStrategy.access$300().remove(Integer.valueOf(this.val$id));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.2
 * JD-Core Version:    0.7.0.1
 */