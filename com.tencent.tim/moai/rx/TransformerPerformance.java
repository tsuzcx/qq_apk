package moai.rx;

import android.util.Log;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

public class TransformerPerformance<T> implements Observable.Transformer<T, T> {
    private final String tag;

    public TransformerPerformance(String tag) {
        this.tag = tag;
    }

    @Override
    public Observable<T> call(final Observable<T> obs) {
        return Observable.using(new Func0<Long>() {
            @Override
            public Long call() {
                return System.currentTimeMillis();
            }
        }, new Func1<Long, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Long aLong) {
                return obs;
            }
        }, new Action1<Long>() {
            @Override
            public void call(Long time) {
                Log.v("trace", String.format("<%s> cost +%sms", tag,
                        (System.currentTimeMillis() - time)));
            }
        });
    }
}
