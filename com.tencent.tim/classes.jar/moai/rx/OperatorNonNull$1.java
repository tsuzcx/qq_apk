package moai.rx;

import rx.Subscriber;

class OperatorNonNull$1
  extends Subscriber<T>
{
  OperatorNonNull$1(OperatorNonNull paramOperatorNonNull, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!this.val$subscriber.isUnsubscribed()) {
      this.val$subscriber.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.val$subscriber.isUnsubscribed()) {
      this.val$subscriber.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if ((!this.val$subscriber.isUnsubscribed()) && (paramT != null)) {
      this.val$subscriber.onNext(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.OperatorNonNull.1
 * JD-Core Version:    0.7.0.1
 */