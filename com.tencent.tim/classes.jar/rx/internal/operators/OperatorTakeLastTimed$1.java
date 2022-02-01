package rx.internal.operators;

import java.util.Deque;
import rx.Scheduler;
import rx.Subscriber;

class OperatorTakeLastTimed$1
  extends Subscriber<T>
{
  OperatorTakeLastTimed$1(OperatorTakeLastTimed paramOperatorTakeLastTimed, Subscriber paramSubscriber1, Deque paramDeque1, Deque paramDeque2, NotificationLite paramNotificationLite, Subscriber paramSubscriber2, TakeLastQueueProducer paramTakeLastQueueProducer)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    runEvictionPolicy(this.this$0.scheduler.now());
    this.val$timestampBuffer.clear();
    this.val$buffer.offer(this.val$notification.completed());
    this.val$producer.startEmitting();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$timestampBuffer.clear();
    this.val$buffer.clear();
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    long l = this.this$0.scheduler.now();
    this.val$timestampBuffer.add(Long.valueOf(l));
    this.val$buffer.add(this.val$notification.next(paramT));
    runEvictionPolicy(l);
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
  
  protected void runEvictionPolicy(long paramLong)
  {
    while ((this.this$0.count >= 0) && (this.val$buffer.size() > this.this$0.count))
    {
      this.val$timestampBuffer.pollFirst();
      this.val$buffer.pollFirst();
    }
    while ((!this.val$buffer.isEmpty()) && (((Long)this.val$timestampBuffer.peekFirst()).longValue() < paramLong - this.this$0.ageMillis))
    {
      this.val$timestampBuffer.pollFirst();
      this.val$buffer.pollFirst();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeLastTimed.1
 * JD-Core Version:    0.7.0.1
 */