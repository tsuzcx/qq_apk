package moai.rx;

import android.os.Handler;
import android.os.Looper;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.TimeUnit;
import moai.fragment.base.LifeDetection;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public class ContextScheduler
  extends Scheduler
{
  private static final LoadingCache<LifeDetection, ContextScheduler> cachedScheduler = CacheBuilder.newBuilder().weakKeys().weakValues().build(new ContextScheduler.1());
  private static final Handler mainHandler = new Handler(Looper.getMainLooper());
  private final LifeDetection context;
  
  public ContextScheduler(LifeDetection paramLifeDetection)
  {
    this.context = paramLifeDetection;
  }
  
  public static Scheduler of(LifeDetection paramLifeDetection)
  {
    return (Scheduler)cachedScheduler.getUnchecked(paramLifeDetection);
  }
  
  public Scheduler.Worker createWorker()
  {
    return new ContextWorker(this.context);
  }
  
  static class ContextWorker
    extends Scheduler.Worker
  {
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();
    private final LifeDetection context;
    
    public ContextWorker(LifeDetection paramLifeDetection)
    {
      this.context = paramLifeDetection;
    }
    
    public boolean isUnsubscribed()
    {
      return this.compositeSubscription.isUnsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      return schedule(paramAction0, 0L, TimeUnit.MILLISECONDS);
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      paramAction0 = new ScheduledAction(paramAction0);
      ContextScheduler.ContextWorker.1 local1 = new ContextScheduler.ContextWorker.1(this, paramAction0);
      if (paramTimeUnit.toMillis(paramLong) > 0L)
      {
        paramAction0.add(Subscriptions.create(new ContextScheduler.ContextWorker.2(this, local1)));
        paramAction0.addParent(this.compositeSubscription);
        this.compositeSubscription.add(paramAction0);
        ContextScheduler.mainHandler.postDelayed(local1, paramTimeUnit.toMillis(paramLong));
        return paramAction0;
      }
      paramTimeUnit = new ContextScheduler.ContextWorker.3(this, local1);
      paramAction0.add(Subscriptions.create(new ContextScheduler.ContextWorker.4(this, paramTimeUnit)));
      paramAction0.addParent(this.compositeSubscription);
      this.compositeSubscription.add(paramAction0);
      ContextScheduler.mainHandler.post(paramTimeUnit);
      return paramAction0;
    }
    
    public void unsubscribe()
    {
      this.compositeSubscription.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ContextScheduler
 * JD-Core Version:    0.7.0.1
 */