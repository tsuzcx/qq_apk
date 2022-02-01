package rx.internal.operators;

import rx.Notification;
import rx.Producer;
import rx.Subscriber;

class OnSubscribeRedo$3$1
  extends Subscriber<Notification<?>>
{
  OnSubscribeRedo$3$1(OnSubscribeRedo.3 param3, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$filteredTerminals.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$filteredTerminals.onError(paramThrowable);
  }
  
  public void onNext(Notification<?> paramNotification)
  {
    if ((paramNotification.isOnCompleted()) && (this.this$1.this$0.stopOnComplete))
    {
      this.val$filteredTerminals.onCompleted();
      return;
    }
    if ((paramNotification.isOnError()) && (this.this$1.this$0.stopOnError))
    {
      this.val$filteredTerminals.onError(paramNotification.getThrowable());
      return;
    }
    this.val$filteredTerminals.onNext(paramNotification);
  }
  
  public void setProducer(Producer paramProducer)
  {
    paramProducer.request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.3.1
 * JD-Core Version:    0.7.0.1
 */