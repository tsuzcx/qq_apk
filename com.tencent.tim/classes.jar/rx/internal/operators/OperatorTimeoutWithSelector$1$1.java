package rx.internal.operators;

import rx.Subscriber;

class OperatorTimeoutWithSelector$1$1
  extends Subscriber<U>
{
  OperatorTimeoutWithSelector$1$1(OperatorTimeoutWithSelector.1 param1, OperatorTimeoutBase.TimeoutSubscriber paramTimeoutSubscriber, Long paramLong) {}
  
  public void onCompleted()
  {
    this.val$timeoutSubscriber.onTimeout(this.val$seqId.longValue());
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$timeoutSubscriber.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    this.val$timeoutSubscriber.onTimeout(this.val$seqId.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.1.1
 * JD-Core Version:    0.7.0.1
 */