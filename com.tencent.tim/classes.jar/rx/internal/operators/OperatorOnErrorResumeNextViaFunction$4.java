package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

class OperatorOnErrorResumeNextViaFunction$4
  extends Subscriber<T>
{
  private boolean done;
  long produced;
  
  OperatorOnErrorResumeNextViaFunction$4(OperatorOnErrorResumeNextViaFunction paramOperatorOnErrorResumeNextViaFunction, Subscriber paramSubscriber, ProducerArbiter paramProducerArbiter, SerialSubscription paramSerialSubscription) {}
  
  public void onCompleted()
  {
    if (this.done) {
      return;
    }
    this.done = true;
    this.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.done)
    {
      Exceptions.throwIfFatal(paramThrowable);
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    this.done = true;
    try
    {
      unsubscribe();
      OperatorOnErrorResumeNextViaFunction.4.1 local1 = new OperatorOnErrorResumeNextViaFunction.4.1(this);
      this.val$ssub.set(local1);
      long l = this.produced;
      if (l != 0L) {
        this.val$pa.produced(l);
      }
      ((Observable)this.this$0.resumeFunction.call(paramThrowable)).unsafeSubscribe(local1);
      return;
    }
    catch (Throwable paramThrowable)
    {
      Exceptions.throwOrReport(paramThrowable, this.val$child);
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.done) {
      return;
    }
    this.produced += 1L;
    this.val$child.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$pa.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction.4
 * JD-Core Version:    0.7.0.1
 */