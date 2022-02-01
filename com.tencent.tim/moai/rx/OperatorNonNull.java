package moai.rx;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by ayangxu.
 */
public class OperatorNonNull<T> implements Observable.Operator<T, T> {
    @Override
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>() {
            @Override
            public void onCompleted() {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onError(throwable);
                }
            }

            @Override
            public void onNext(T t) {
                if (!subscriber.isUnsubscribed() && t != null) {
                    subscriber.onNext(t);
                }
            }
        };
    }
}
