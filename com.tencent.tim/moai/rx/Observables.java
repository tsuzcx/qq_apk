package moai.rx;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;

/**
 * Created by ayangxu.
 */
public class Observables {
    public static <R, T1, T2> Observable<R> asyncZip(Observable<T1> o1, Observable<T2> o2,
                                                     final Func2<T1, T2, Observable<R>> f2) {
        return Observable.zip(o1, o2, new Func2<T1, T2, Observable<R>>() {
            @Override
            public Observable<R> call(T1 t1, T2 t2) {
                return f2.call(t1, t2);
            }
        }).flatMap(new Func1<Observable<R>, Observable<R>>() {
            @Override
            public Observable<R> call(Observable<R> rObservable) {
                return rObservable;
            }
        });
    }
}
