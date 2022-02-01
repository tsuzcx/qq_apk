package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class OperatorDistinct<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends U> keySelector;
  
  public OperatorDistinct(Func1<? super T, ? extends U> paramFunc1)
  {
    this.keySelector = paramFunc1;
  }
  
  public static <T> OperatorDistinct<T, T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorDistinct.1(this, paramSubscriber, paramSubscriber);
  }
  
  static class Holder
  {
    static final OperatorDistinct<?, ?> INSTANCE = new OperatorDistinct(UtilityFunctions.identity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorDistinct
 * JD-Core Version:    0.7.0.1
 */