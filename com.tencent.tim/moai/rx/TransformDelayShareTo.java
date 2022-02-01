package moai.rx;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * 对于一定时间内重复启动的相同的任务，只执行一遍，避免因时序问题导致相同的任务执行多遍。
 *
 * Created by roylkchen on 8/11/15.
 */
public class TransformDelayShareTo<K, T> extends TransformerShareTo<K, T> {
    private static final int DELAY_IN_SECOND = 10;
    private static final String NAME_PREFIX = "cached_";
    public TransformDelayShareTo(String name, K key) {
        super(NAME_PREFIX + name, key);
    }

    public TransformDelayShareTo(K key) {
        this("Default", key);
    }

    @Override
    protected void invalidateKey(final Object key) {
        Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                TransformDelayShareTo.super.invalidateKey(key);
            }
        }).delaySubscription(DELAY_IN_SECOND, TimeUnit.SECONDS)
                .subscribe();
    }
}
