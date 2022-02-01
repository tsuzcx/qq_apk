package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSerialize<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorSerialize<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new SerializedSubscriber(new OperatorSerialize.1(this, paramSubscriber, paramSubscriber));
  }
  
  static final class Holder
  {
    static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorSerialize
 * JD-Core Version:    0.7.0.1
 */