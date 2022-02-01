package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorIgnoreElements<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorIgnoreElements<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorIgnoreElements.1 local1 = new OperatorIgnoreElements.1(this, paramSubscriber);
    paramSubscriber.add(local1);
    return local1;
  }
  
  static class Holder
  {
    static final OperatorIgnoreElements<?> INSTANCE = new OperatorIgnoreElements();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorIgnoreElements
 * JD-Core Version:    0.7.0.1
 */