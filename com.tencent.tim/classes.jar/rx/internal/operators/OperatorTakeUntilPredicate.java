package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class OperatorTakeUntilPredicate<T>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, Boolean> stopPredicate;
  
  public OperatorTakeUntilPredicate(Func1<? super T, Boolean> paramFunc1)
  {
    this.stopPredicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    ParentSubscriber localParentSubscriber = new ParentSubscriber(paramSubscriber);
    paramSubscriber.add(localParentSubscriber);
    paramSubscriber.setProducer(new OperatorTakeUntilPredicate.1(this, localParentSubscriber));
    return localParentSubscriber;
  }
  
  final class ParentSubscriber
    extends Subscriber<T>
  {
    private final Subscriber<? super T> child;
    private boolean done = false;
    
    ParentSubscriber()
    {
      Object localObject;
      this.child = localObject;
    }
    
    void downstreamRequest(long paramLong)
    {
      request(paramLong);
    }
    
    public void onCompleted()
    {
      if (!this.done) {
        this.child.onCompleted();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.done) {
        this.child.onError(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      this.child.onNext(paramT);
      try
      {
        boolean bool = ((Boolean)OperatorTakeUntilPredicate.this.stopPredicate.call(paramT)).booleanValue();
        if (bool)
        {
          this.done = true;
          this.child.onCompleted();
          unsubscribe();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        this.done = true;
        Exceptions.throwOrReport(localThrowable, this.child, paramT);
        unsubscribe();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeUntilPredicate
 * JD-Core Version:    0.7.0.1
 */