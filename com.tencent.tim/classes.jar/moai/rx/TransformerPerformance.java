package moai.rx;

import rx.Observable;
import rx.Observable.Transformer;

public class TransformerPerformance<T>
  implements Observable.Transformer<T, T>
{
  private final String tag;
  
  public TransformerPerformance(String paramString)
  {
    this.tag = paramString;
  }
  
  public Observable<T> call(Observable<T> paramObservable)
  {
    return Observable.using(new TransformerPerformance.1(this), new TransformerPerformance.2(this, paramObservable), new TransformerPerformance.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerPerformance
 * JD-Core Version:    0.7.0.1
 */