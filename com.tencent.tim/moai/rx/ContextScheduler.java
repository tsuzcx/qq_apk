package moai.rx;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

import moai.fragment.app.Fragment;
import moai.fragment.base.LifeDetection;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public class ContextScheduler extends Scheduler {
    private final static Handler mainHandler = new Handler(Looper.getMainLooper());
    private final static LoadingCache<LifeDetection, ContextScheduler> cachedScheduler =
            CacheBuilder.newBuilder().weakKeys().weakValues()
                    .build(new CacheLoader<LifeDetection, ContextScheduler>() {
                        @Override
                        public ContextScheduler load(@NonNull LifeDetection context) throws Exception {
                            return new ContextScheduler(context);
                        }
                    });

    /**
     * <p>带上下文的 Scheduler，在 {@link Activity}/{@link Fragment} 的 <code>onStart/onPause</code>
     * 之间触发，其他时间不会回调。</p>
     * <p>需要 {@link Fragment}/{@link Activity} 实现 {@link LifeDetection} 接口，在主线程回调。</p>
     */
    public static Scheduler of(LifeDetection context) {
        return cachedScheduler.getUnchecked(context);
    }

    static class ContextWorker extends Worker {
        private final CompositeSubscription compositeSubscription = new CompositeSubscription();
        private final LifeDetection context;

        public ContextWorker(LifeDetection context) {
            this.context = context;
        }

        @Override
        public Subscription schedule(Action0 action) {
            return schedule(action, 0, TimeUnit.MILLISECONDS);
        }

        @Override
        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            final ScheduledAction scheduledAction = new ScheduledAction(action);
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (context.isAttachedToActivity()) {
                        scheduledAction.run();
                    }
                }
            };

            if (unit.toMillis(delayTime) > 0) {
                scheduledAction.add(Subscriptions.create(new Action0() {
                    @Override
                    public void call() {
                        mainHandler.removeCallbacks(runnable);
                    }
                }));
                scheduledAction.addParent(compositeSubscription);
                compositeSubscription.add(scheduledAction);
                mainHandler.postDelayed(runnable, unit.toMillis(delayTime));
            } else {
                final Runnable runAfterAnimation = new Runnable() {
                    @Override
                    public void run() {
                        if (context.isAnimationRunning()) {
                            mainHandler.postDelayed(this, 100);
                        } else {
                            runnable.run();
                        }
                    }
                };

                scheduledAction.add(Subscriptions.create(new Action0() {
                    @Override
                    public void call() {
                        mainHandler.removeCallbacks(runAfterAnimation);
                    }
                }));
                scheduledAction.addParent(compositeSubscription);
                compositeSubscription.add(scheduledAction);
                mainHandler.post(runAfterAnimation);
            }


            return scheduledAction;
        }

        @Override
        public void unsubscribe() {
            compositeSubscription.unsubscribe();
        }

        @Override
        public boolean isUnsubscribed() {
            return compositeSubscription.isUnsubscribed();
        }
    }

    private final LifeDetection context;

    public ContextScheduler(LifeDetection context) {
        this.context = context;
    }

    @Override
    public Worker createWorker() {
        return new ContextWorker(context);
    }
}
