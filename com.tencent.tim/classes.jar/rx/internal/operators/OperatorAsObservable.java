package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorAsObservable<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorAsObservable<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return paramSubscriber;
  }
  
  static final class Holder
  {
    static final OperatorAsObservable<Object> INSTANCE = new OperatorAsObservable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorAsObservable
 * JD-Core Version:    0.7.0.1
 */