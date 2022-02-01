package moai.rx;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.Transformer;

public abstract class TransformerDelayOrCancel<T, R>
  implements Observable.Transformer<T, T>
{
  private final long delay;
  private final R value;
  
  public TransformerDelayOrCancel(long paramLong)
  {
    this.delay = paramLong;
    this.value = getValue();
  }
  
  public Observable<T> call(Observable<T> paramObservable)
  {
    Observable localObservable = Observable.just(null);
    return localObservable.delay(this.delay, TimeUnit.MILLISECONDS).flatMap(new TransformerDelayOrCancel.1(this, paramObservable, localObservable));
  }
  
  public abstract R getValue();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerDelayOrCancel
 * JD-Core Version:    0.7.0.1
 */