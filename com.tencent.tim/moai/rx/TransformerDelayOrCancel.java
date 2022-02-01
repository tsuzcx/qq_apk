package moai.rx;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * <p>在某个值保持一定时间不变的情况下再执行此任务。比如：</p>
 *
 * <ul>
 *     <li>停留在某章节一秒，则预读下一章</li>
 *     <li>停留在当前页1秒，则发请求保存阅读进度</li>
 * </ul>
 */
public abstract class TransformerDelayOrCancel<T, R> implements Observable.Transformer<T, T> {
    private final long delay;
    private final R value;
    public abstract R getValue();

    public TransformerDelayOrCancel(long delay) {
        this.delay = delay;
        this.value = getValue();
    }

    @Override
    public Observable<T> call(final Observable<T> source) {
        final Observable<T> none = Observable.just(null);
        return none.delay(delay, TimeUnit.MILLISECONDS)
                .flatMap(new Func1<T, Observable<T>>() {
                    @Override
                    public Observable<T> call(T t) {
                        if (getValue().equals(value)) {
                            return source;
                        }
                        return none;
                    }
                });
    }
}
