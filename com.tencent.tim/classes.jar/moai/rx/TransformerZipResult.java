package moai.rx;

import rx.Observable;
import rx.Observable.Transformer;

public class TransformerZipResult<T>
  implements Observable.Transformer<Observable<T>, T>
{
  public Observable<T> call(Observable<Observable<T>> paramObservable)
  {
    return paramObservable.flatMap(new TransformerZipResult.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerZipResult
 * JD-Core Version:    0.7.0.1
 */