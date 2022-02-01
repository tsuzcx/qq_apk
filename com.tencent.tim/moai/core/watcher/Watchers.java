package moai.core.watcher;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import moai.proxy.Reflections;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

/**
 * <h3>An EventBus base on RxJava's {@link Subject} and Guava's {@link Cache}.</h3>
 *
 * <p>It's thread-safe, memory-friendly, with the simplest API in the world.</p>
 *
 * <h5>1. define an event, by extending the {@link Watcher} interface</h5>
 * <pre>
 *     public interface PushWatcher extends Watcher {
 *         void notify(PushMessage msg);
 *     }
 * </pre>
 *
 * <h5>2. listener to an event, by implementing the methods. </h5>
 * <pre>
 *      PushWatcher watcher = new PushWatcher() {
 *          public void notify(PushMessage msg) {
 *              Log.d("watcher", "receive msg");
 *          }
 *      };
 * </pre>
 *
 * <h5>3. bind or unbind an event. </h5>
 * <pre>
 *      Watchers.bind(watcher);
 *      Watchers.unbind(watcher);
 * </pre>
 *
 * <h5>3. trigger an event. </h5>
 * <pre>
 *     Watchers.of(PushWatcher.class).notify(new PushMessage());
 * </pre>
 *
 * <h5>Event more..</h5>
 * <pre>
 *     public class MyFragment extends Fragment implement PushWatcher, NetworkChangedWatcher {
 *          public void notify(PushMessage msg) {
 *              Log.d("watcher", "receive msg: " + msg);
 *          }
 *          public void onNetworkChanged(boolean isConnected) {
 *              Log.d("watcher", "network connected: " + isConnected);
 *          }
 *          protected void onStart() {
 *              Watchers.bind(this);
 *          }
 *          protected void onStop() {
 *              Watchers.unbind(this);
 *          }
 *     }
 * </pre>
 */
public class Watchers {
    static final Watchers instance = new Watchers();

    /** base interface for identify this is a watcher. */
    @Config
    public interface Watcher { }

    /** all kinds of subjects. */
    public enum Subjects {
        /** {@link PublishSubject} */
        PUBLISH {
            @Override
            Subject<Context, Context> create() {
                return PublishSubject.create();
            }
        },
        /** {@link BehaviorSubject} */
        BEHAVIOR {
            @Override
            Subject<Context, Context> create() {
                return BehaviorSubject.create();
            }
        },
        /** {@link AsyncSubject} */
        ASYNC {
            @Override
            Subject<Context, Context> create() {
                return AsyncSubject.create();
            }
        },
        /** {@link ReplaySubject} */
        REPLAY {
            @Override
            Subject<Context, Context> create() {
                return ReplaySubject.create();
            }
        };
        abstract Subject<Context, Context> create();
    }

    /** Configuration for watcher. */
    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Config {
        /** choose a subject, or use {@link PublishSubject} by default. */
        Subjects subject() default Subjects.PUBLISH;
        /** delegate for {@link Observable#sample(long, TimeUnit)} */
        long sample() default 0;
        /** delegate for {@link Observable#sample(long, TimeUnit)} */
        TimeUnit timeunit() default TimeUnit.MILLISECONDS;
        /** delegate for {@link Observable#onBackpressureDrop()} */
        boolean backpressureDrop() default false;
        /** delegate for {@link Observable#onBackpressureBuffer(long)} */
        int backpressureBuffer() default 0;
        /** consume the arguments just once, for the listeners whom first bind to this watcher. */
        boolean once() default false;
    }

    private static class Context {
        private final AtomicBoolean consumed = new AtomicBoolean(false);
        private final Method method;
        private final Object[] args;

        private Context(Method method, Object[] args) {
            this.method = method;
            this.args = args;
        }
    }

    final ConcurrentMap<Class<? extends Watcher>, Cache<Watcher, Subscription>>
            consumers = new ConcurrentHashMap<>();
    final ConcurrentMap<Class<? extends Watcher>, Subject<Context, Context>>
            producers = new ConcurrentHashMap<>();

    private final ConcurrentMap<Class<? extends Watcher>, Watcher> watchers =
            new ConcurrentHashMap<>();

	private Watchers() { }

    /** obtain a watcher adapter for trigger. */
    public static <T extends Watcher> T of(Class<T> clz) {
        return instance.getWatcher(clz);
    }

    /** bind the watcher into its adapters. with specific callback Scheduler. */
    public static void bind(Watcher watcher, Scheduler observeOn) {
        instance.bindWatcher(watcher, observeOn);
    }
    /** bind of unbind*/
    public static void bind(Watcher watcher, boolean toBind){
        if(toBind){
            bind(watcher);
        }
        else{
            unbind(watcher);
        }
    }
    /** bind the watcher into its adapters. with same Scheduler as the adapter triggers. */
    public static void bind(Watcher watcher) {
        instance.bindWatcher(watcher);
    }

    /** unbind the watcher from its adapters. */
    public static void unbind(Watcher watcher) {
        instance.unbindWatcher(watcher);
    }

    private <T extends Watcher> T getWatcher(Class<T> clz) {
        if (!watchers.containsKey(clz)) {
            watchers.putIfAbsent(clz, create(clz));
        }

        return clz.cast(watchers.get(clz));
    }

    private static <T extends Watcher> T create(Class<T> clazz) {
        if (!clazz.isInterface()) {
            throw new IllegalArgumentException(
                    "Only interface endpoint definitions are supported.");
        }
        if (!(Reflections.getAllInterfaces(clazz).contains(Watcher.class))) {
            return clazz.cast(Proxy.newProxyInstance(
                    clazz.getClassLoader(), new Class[]{clazz},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method,
                                             Object[] args) throws Throwable {
                            throw new IllegalArgumentException(
                                    "Interface definitions must extend Watcher interface.");
                        }
                    }
            ));
        }
        return clazz.cast(Proxy.newProxyInstance(
                clazz.getClassLoader(), new Class[]{clazz}, new WatcherHandler(clazz)));
    }

    static class WatcherHandler implements InvocationHandler {
        private final Class<? extends Watcher> clazz;
        WatcherHandler(Class<? extends Watcher> clazz) {
            this.clazz = clazz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, args);
            }
            instance.trigger(clazz, method, args);
            return null;
        }
    }

    private void bindWatcher(Watcher watcher) {
        bindWatcher(watcher, null);
    }

	private void bindWatcher(final Watcher watcher, Scheduler observeOn) {
        HashSet<Class<? extends Watcher>> classes = findWatchers(watcher);

        for (Class<? extends Watcher> clazz : classes) {
            bindWatcher(watcher, observeOn, clazz);
        }
	}

    private void bindWatcher(final Watcher watcher, Scheduler observeOnScheduler,
                             Class<? extends Watcher> clazz) {
        prepare(clazz);

        Cache<Watcher, Subscription> watchers = consumers.get(clazz);

        if (watchers.getIfPresent(watcher) == null) {
            Observable<Context> obs = producers.get(clazz);
            final Config config = getWatcherConfig(clazz);
            if (config.sample() > 0 && config.timeunit() != null) {
                obs = obs.sample(config.sample(), config.timeunit());
            }
            if (config.backpressureDrop()) {
                obs = obs.onBackpressureDrop();
            }
            if (config.backpressureBuffer() > 0) {
                obs = obs.onBackpressureBuffer(config.backpressureBuffer());
            }
            if (observeOnScheduler != null) {
                obs = obs.observeOn(observeOnScheduler);
            }
            watchers.put(watcher, obs.subscribe(new Action1<Context>() {
                @Override
                public void call(Context context) {
                    if (config.once() && context.consumed.getAndSet(true)) return;
                    try {
                        Class<?> clazz = watcher.getClass();
                        Method method = clazz.getMethod(
                                context.method.getName(),
                                context.method.getParameterTypes());
                        method.invoke(watcher, context.args);
                    } catch (Exception e) {
                        if (e instanceof InvocationTargetException) {
                            throw new RuntimeException(
                                    ((InvocationTargetException) e).getTargetException());
                        }
                        throw new RuntimeException(e);
                    }
                }
            }));
        }
    }

    /** find all watchers from this object. */
    private HashSet<Class<? extends Watcher>> findWatchers(Watcher watcher) {
        return Reflections.filterSuperBy(Watcher.class, watcher.getClass());
    }

    private void prepare(Class<? extends Watcher> clazz) {
        Subject<Context, Context> cache = producers.get(clazz);
        if (cache == null) {
            cache = createSubject(clazz);
            producers.putIfAbsent(clazz, cache);
        }

        Cache<Watcher, Subscription> watchers = consumers.get(clazz);
        if (watchers == null) {
            watchers = CacheBuilder.newBuilder().weakKeys().weakValues().build();
            consumers.putIfAbsent(clazz, watchers);
        }
    }

    private void unbindWatcher(Watcher watcher) {
        HashSet<Class<? extends Watcher>> classes = findWatchers(watcher);
        for (Class<? extends Watcher> clazz : classes) {
            unbindWatcher(watcher, clazz);
        }
	}

    private void unbindWatcher(Watcher watcher, Class<? extends Watcher> clazz) {
        prepare(clazz);
        Cache<Watcher, Subscription> cache = consumers.get(clazz);
        if (cache != null) {
            Subscription sub = cache.getIfPresent(watcher);
            if (sub != null && !sub.isUnsubscribed()) {
                sub.unsubscribe();
            }
            cache.invalidate(watcher);
        }
    }

    private void trigger(Class<? extends Watcher> clazz, Method baseMethod, Object...args) {
        prepare(clazz);
        Subject<Context, Context> cache = producers.get(clazz);
        cache.onNext(new Context(baseMethod, args));
	}

    private Subject<Context, Context> createSubject(Class<? extends Watcher> clazz) {
        return getWatcherConfig(clazz).subject().create();
    }

    private Config getWatcherConfig(Class<? extends Watcher> clazz) {
        Config config = clazz.getAnnotation(Config.class);
        return config != null ? config : Watcher.class.getAnnotation(Config.class);
    }
}
