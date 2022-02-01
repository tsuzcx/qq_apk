package moai.rx;

import rx.Observable;
import rx.functions.Func1;

class TransformerWhenComplete$1
  implements Func1<Integer, Observable<T>>
{
  TransformerWhenComplete$1(TransformerWhenComplete paramTransformerWhenComplete) {}
  
  public Observable<T> call(Integer paramInteger)
  {
    paramInteger = Observable.defer(new TransformerWhenComplete.1.1(this));
    if (TransformerWhenComplete.access$100(this.this$0) == null) {
      return paramInteger;
    }
    return paramInteger.delaySubscription(TransformerWhenComplete.access$200(this.this$0), TransformerWhenComplete.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerWhenComplete.1
 * JD-Core Version:    0.7.0.1
 */