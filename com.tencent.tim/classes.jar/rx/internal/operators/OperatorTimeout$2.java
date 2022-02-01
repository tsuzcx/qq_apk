package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;

class OperatorTimeout$2
  implements OperatorTimeoutBase.TimeoutStub<T>
{
  OperatorTimeout$2(long paramLong, TimeUnit paramTimeUnit) {}
  
  public Subscription call(OperatorTimeoutBase.TimeoutSubscriber<T> paramTimeoutSubscriber, Long paramLong, T paramT, Scheduler.Worker paramWorker)
  {
    return paramWorker.schedule(new OperatorTimeout.2.1(this, paramTimeoutSubscriber, paramLong), this.val$timeout, this.val$timeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeout.2
 * JD-Core Version:    0.7.0.1
 */