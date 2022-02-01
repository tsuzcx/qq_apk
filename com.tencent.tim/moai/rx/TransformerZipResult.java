package moai.rx;


import rx.Observable;
import rx.functions.Func1;

public class TransformerZipResult<T> implements Observable.Transformer<Observable<T>, T> {
    @Override
    public Observable<T> call(Observable<Observable<T>> observable) {
        return observable.flatMap(new Func1<Observable<T>, Observable<T>>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable;
            }
        });
    }
}
