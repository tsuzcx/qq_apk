package moai.rx;

import android.util.Log;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import rx.Observable;
import rx.functions.Action0;

/**
 * <p>如果某个任务正在执行，就没必要重新执行了，直接复用这个任务的回调。</p>
 *
 * <p>用于重用某些比较重的任务，需指定一个容器存放这些正在执行的任务。</p>
 *
 * <ul>
 *     <li>某个章节的排版，只要有任何一处发起了排版请求，则别人只需要等待第一个返回即可。</li>
 *     <li>登录超时时会有很多并发请求同时发起重试，仅需要等待第一个重试返回即可。</li>
 * </ul>
 *
 * <p>事实上大部分网络请求都适用此场景，保证任务正在执行时，不会重复执行</p>
 *
 * @param <K> 用于排重的 Key 类型
 * @param <T> 上一个 Observable 处理的类型
 */
public class TransformerShareTo<K, T> implements Observable.Transformer<T, T> {
    static final LoadingCache<String, Cache> shares =
            CacheBuilder.newBuilder()
                .build(new CacheLoader<String, Cache>() {
                    @Override
                    public Cache load(String name) throws Exception {
                        return CacheBuilder.newBuilder().recordStats().build();
                    }
                });

    private final Cache<K, Observable<T>> shared;
    private final K key;
    private final String name;
    public TransformerShareTo(String name, K key) {
        this.name = name;
        this.key = key;
        //noinspection unchecked
        this.shared = shares.getUnchecked(name);
    }

    public TransformerShareTo(K key) {
        this("Default", key);
    }

    @Override
    public Observable<T> call(Observable<T> source) {
        Observable<T> obs = shared.getIfPresent(key);
        Log.d("shareTo", String.format("[%s] %s => %s", name, obs != null ? "shared" : "newobs", key));

        if (obs == null) {
            obs = source.cache()
                    .doAfterTerminate(new Action0() {
                        @Override
                        public void call() {
                            invalidateKey(key);
                        }
                    });
            shared.put(key, obs);
        }
        return obs;
    }

    protected void invalidateKey(Object key) {
        shared.invalidate(key);
    }

    public String name() {
        return name;
    }
}
