package rx.internal.operators;

import java.util.Iterator;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.Subscribers;

public final class OperatorZipIterable<T1, T2, R>
  implements Observable.Operator<R, T1>
{
  final Iterable<? extends T2> iterable;
  final Func2<? super T1, ? super T2, ? extends R> zipFunction;
  
  public OperatorZipIterable(Iterable<? extends T2> paramIterable, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    this.iterable = paramIterable;
    this.zipFunction = paramFunc2;
  }
  
  public Subscriber<? super T1> call(Subscriber<? super R> paramSubscriber)
  {
    Object localObject = this.iterable.iterator();
    try
    {
      if (!((Iterator)localObject).hasNext())
      {
        paramSubscriber.onCompleted();
        localObject = Subscribers.empty();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, paramSubscriber);
      return Subscribers.empty();
    }
    return new OperatorZipIterable.1(this, paramSubscriber, paramSubscriber, localThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorZipIterable
 * JD-Core Version:    0.7.0.1
 */