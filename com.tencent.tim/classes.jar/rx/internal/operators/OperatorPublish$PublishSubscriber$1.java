package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Action0;

class OperatorPublish$PublishSubscriber$1
  implements Action0
{
  OperatorPublish$PublishSubscriber$1(OperatorPublish.PublishSubscriber paramPublishSubscriber) {}
  
  public void call()
  {
    this.this$0.producers.getAndSet(OperatorPublish.PublishSubscriber.TERMINATED);
    this.this$0.current.compareAndSet(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorPublish.PublishSubscriber.1
 * JD-Core Version:    0.7.0.1
 */