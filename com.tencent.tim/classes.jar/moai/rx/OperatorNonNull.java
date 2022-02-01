package moai.rx;

import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorNonNull<T>
  implements Observable.Operator<T, T>
{
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorNonNull.1(this, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.OperatorNonNull
 * JD-Core Version:    0.7.0.1
 */