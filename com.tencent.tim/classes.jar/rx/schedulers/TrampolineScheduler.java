package rx.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class TrampolineScheduler
  extends Scheduler
{
  private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();
  
  static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  static TrampolineScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new InnerCurrentThreadScheduler();
  }
  
  static class InnerCurrentThreadScheduler
    extends Scheduler.Worker
    implements Subscription
  {
    final AtomicInteger counter = new AtomicInteger();
    private final BooleanSubscription innerSubscription = new BooleanSubscription();
    final PriorityBlockingQueue<TrampolineScheduler.TimedAction> queue = new PriorityBlockingQueue();
    private final AtomicInteger wip = new AtomicInteger();
    
    private Subscription enqueue(Action0 paramAction0, long paramLong)
    {
      if (this.innerSubscription.isUnsubscribed()) {
        return Subscriptions.unsubscribed();
      }
      paramAction0 = new TrampolineScheduler.TimedAction(paramAction0, Long.valueOf(paramLong), this.counter.incrementAndGet());
      this.queue.add(paramAction0);
      if (this.wip.getAndIncrement() == 0)
      {
        do
        {
          paramAction0 = (TrampolineScheduler.TimedAction)this.queue.poll();
          if (paramAction0 != null) {
            paramAction0.action.call();
          }
        } while (this.wip.decrementAndGet() > 0);
        return Subscriptions.unsubscribed();
      }
      return Subscriptions.create(new TrampolineScheduler.InnerCurrentThreadScheduler.1(this, paramAction0));
    }
    
    public boolean isUnsubscribed()
    {
      return this.innerSubscription.isUnsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      return enqueue(paramAction0, now());
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      paramLong = now() + paramTimeUnit.toMillis(paramLong);
      return enqueue(new SleepingAction(paramAction0, this, paramLong), paramLong);
    }
    
    public void unsubscribe()
    {
      this.innerSubscription.unsubscribe();
    }
  }
  
  static final class TimedAction
    implements Comparable<TimedAction>
  {
    final Action0 action;
    final int count;
    final Long execTime;
    
    TimedAction(Action0 paramAction0, Long paramLong, int paramInt)
    {
      this.action = paramAction0;
      this.execTime = paramLong;
      this.count = paramInt;
    }
    
    public int compareTo(TimedAction paramTimedAction)
    {
      int j = this.execTime.compareTo(paramTimedAction.execTime);
      int i = j;
      if (j == 0) {
        i = TrampolineScheduler.compare(this.count, paramTimedAction.count);
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.schedulers.TrampolineScheduler
 * JD-Core Version:    0.7.0.1
 */