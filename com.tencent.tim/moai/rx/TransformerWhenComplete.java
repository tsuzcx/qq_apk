package moai.rx;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * 等待源 Observable 全部完成之后，再进行下一个 Observable ，中间支持 delay 一段时间。
 *
 * <p>
 * 利用 {@link Observable#count()} ，在源 Observable 的全部事情完成之后，再通过
 * {@link Observable#flatMap(Func1)} 传递给下一个 Observable。
 * </p>
 */
public class TransformerWhenComplete<T> implements Observable.Transformer<T, T> {

    private final Func0<Observable<? extends T>> func;
    private final TimeUnit timeUnit;
    private final long delay;

    public TransformerWhenComplete(Func0<Observable<? extends T>> func) {
        this(0, null, func);
    }

    public TransformerWhenComplete(long delay, TimeUnit timeUnit,
                                   Func0<Observable<? extends T>> func) {
        this.func = func;
        this.timeUnit = timeUnit;
        this.delay = delay;
    }

    @Override
    public Observable<T> call(final Observable<T> observable) {
        return observable.count().flatMap(new Func1<Integer, Observable<T>>() {
            @Override
            public Observable<T> call(final Integer count) {
                Observable<T> obs = Observable.defer(new Func0<Observable<T>>() {
                    @Override
                    public Observable<T> call() {
                        //noinspection unchecked
                        return (Observable<T>) func.call();
                    }
                });
                if (timeUnit == null) return obs;
                return obs.delaySubscription(delay, timeUnit);
            }
        });
    }
}
