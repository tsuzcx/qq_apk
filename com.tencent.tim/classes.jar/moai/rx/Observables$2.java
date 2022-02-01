package moai.rx;

import rx.Observable;
import rx.functions.Func2;

final class Observables$2
  implements Func2<T1, T2, Observable<R>>
{
  Observables$2(Func2 paramFunc2) {}
  
  public Observable<R> call(T1 paramT1, T2 paramT2)
  {
    return (Observable)this.val$f2.call(paramT1, paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.Observables.2
 * JD-Core Version:    0.7.0.1
 */