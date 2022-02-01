package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subjects.BehaviorSubject;

class OnSubscribeRedo$2$1
  extends Subscriber<T>
{
  boolean done;
  
  OnSubscribeRedo$2$1(OnSubscribeRedo.2 param2) {}
  
  private void decrementConsumerCapacity()
  {
    long l;
    do
    {
      l = this.this$1.val$consumerCapacity.get();
    } while ((l != 9223372036854775807L) && (!this.this$1.val$consumerCapacity.compareAndSet(l, l - 1L)));
  }
  
  public void onCompleted()
  {
    if (!this.done)
    {
      this.done = true;
      unsubscribe();
      this.this$1.val$terminals.onNext(Notification.createOnCompleted());
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.done)
    {
      this.done = true;
      unsubscribe();
      this.this$1.val$terminals.onNext(Notification.createOnError(paramThrowable));
    }
  }
  
  public void onNext(T paramT)
  {
    if (!this.done)
    {
      this.this$1.val$child.onNext(paramT);
      decrementConsumerCapacity();
      this.this$1.val$arbiter.produced(1L);
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.this$1.val$arbiter.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.2.1
 * JD-Core Version:    0.7.0.1
 */