package android.support.v4.provider;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SelfDestructiveThread$3
  implements Runnable
{
  SelfDestructiveThread$3(SelfDestructiveThread paramSelfDestructiveThread, AtomicReference paramAtomicReference, Callable paramCallable, ReentrantLock paramReentrantLock, AtomicBoolean paramAtomicBoolean, Condition paramCondition) {}
  
  public void run()
  {
    try
    {
      this.val$holder.set(this.val$callable.call());
      label16:
      this.val$lock.lock();
      try
      {
        this.val$running.set(false);
        this.val$cond.signal();
        return;
      }
      finally
      {
        this.val$lock.unlock();
      }
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.SelfDestructiveThread.3
 * JD-Core Version:    0.7.0.1
 */