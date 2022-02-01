package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorSkip<T>
  implements Observable.Operator<T, T>
{
  final int toSkip;
  
  public OperatorSkip(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramInt);
    }
    this.toSkip = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorSkip.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorSkip
 * JD-Core Version:    0.7.0.1
 */