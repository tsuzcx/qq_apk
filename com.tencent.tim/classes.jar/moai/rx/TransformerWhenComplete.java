package moai.rx;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.Transformer;
import rx.functions.Func0;

public class TransformerWhenComplete<T>
  implements Observable.Transformer<T, T>
{
  private final long delay;
  private final Func0<Observable<? extends T>> func;
  private final TimeUnit timeUnit;
  
  public TransformerWhenComplete(long paramLong, TimeUnit paramTimeUnit, Func0<Observable<? extends T>> paramFunc0)
  {
    this.func = paramFunc0;
    this.timeUnit = paramTimeUnit;
    this.delay = paramLong;
  }
  
  public TransformerWhenComplete(Func0<Observable<? extends T>> paramFunc0)
  {
    this(0L, null, paramFunc0);
  }
  
  public Observable<T> call(Observable<T> paramObservable)
  {
    return paramObservable.count().flatMap(new TransformerWhenComplete.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerWhenComplete
 * JD-Core Version:    0.7.0.1
 */