package moai.rx;

import rx.Observable;
import rx.functions.Func2;

public class Observables
{
  public static <R, T1, T2> Observable<R> asyncZip(Observable<T1> paramObservable, Observable<T2> paramObservable1, Func2<T1, T2, Observable<R>> paramFunc2)
  {
    return Observable.zip(paramObservable, paramObservable1, new Observables.2(paramFunc2)).flatMap(new Observables.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.Observables
 * JD-Core Version:    0.7.0.1
 */