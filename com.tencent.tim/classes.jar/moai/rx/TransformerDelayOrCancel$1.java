package moai.rx;

import rx.Observable;
import rx.functions.Func1;

class TransformerDelayOrCancel$1
  implements Func1<T, Observable<T>>
{
  TransformerDelayOrCancel$1(TransformerDelayOrCancel paramTransformerDelayOrCancel, Observable paramObservable1, Observable paramObservable2) {}
  
  public Observable<T> call(T paramT)
  {
    if (this.this$0.getValue().equals(TransformerDelayOrCancel.access$000(this.this$0))) {
      return this.val$source;
    }
    return this.val$none;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerDelayOrCancel.1
 * JD-Core Version:    0.7.0.1
 */