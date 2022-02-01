package moai.storage;


import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;
import android.util.SparseBooleanArray;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import rx.Observable;
import rx.Subscriber;

/**
 * <p>配合 ORM 框架和 SQLite UpdateHook 的通用缓存管理。基于 Guava 的 {@link LoadingCache}</p>
 *
 * <p>缓存的 Key 只支持 int，也就是主键，在 ORM 框架下，主键可以通过 <code>generateId(Object...)</code>
 * 来生成。</p>
 */
public class Cache {
    private static final ConcurrentHashMap<SQLiteDatabase, Cache> caches = new ConcurrentHashMap<>();
    static final ConcurrentHashMap<String, Cache> nameCaches = new ConcurrentHashMap<>();
    private static final String defaultCacheName = "Default";
    private final SQLiteOpenHelper helper;
    final String name;

    public static void create(Context context, SQLiteOpenHelper helper) {
        create(context, helper, defaultCacheName);
    }
    public static void create(Context context, SQLiteOpenHelper helper, String name) {
        if (!caches.containsKey(helper.getReadableDatabase())) {
            final Cache cache = new Cache(helper, name);
            caches.putIfAbsent(helper.getReadableDatabase(), cache);
            nameCaches.putIfAbsent(name, cache);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                context.getApplicationContext()
                        .registerComponentCallbacks(new ComponentCallbacks2() {
                            @Override
                            public void onTrimMemory(int level) {
                                if (level >= ComponentCallbacks2.TRIM_MEMORY_MODERATE) {
                                    onLowMemory();
                                } else {
                                    cache.cleanUp();
                                }
                            }

                            @Override
                            public void onConfigurationChanged(Configuration newConfig) {

                            }

                            @Override
                            public void onLowMemory() {
                                cache.invalidateAll();
                            }
                        });
            }
        }
    }

    public Cache(SQLiteOpenHelper helper, String name) {
        this.helper = helper;
        this.name = name;
    }

    public static Cache from(SQLiteDatabase db) {
        return caches.get(db);
    }

    public static Cache from(String name) {
        return nameCaches.get(name);
    }

    private final static CacheWrapper safety = new CacheWrapper<>(
            null,
            CacheBuilder.newBuilder().weakValues()
                    .build(new CacheLoader<Integer, Optional<Domain>>() {
                        @Override
                        public Optional<Domain> load(Integer integer) throws Exception {
                            Log.d("Cache", "load: key:" + integer);
                            return Optional.absent();
                        }
                    }));

    @SuppressWarnings("unchecked")
    public static <T extends Domain> CacheWrapper<T> of(Class<T> domainClass) {
        if (from(defaultCacheName) == null) return safety;
        return Optional.fromNullable(from(defaultCacheName).getCache(domainClass)).or(safety);
    }

    static class Loader<T extends Domain> {

        Class<T> parameterizedType;
        String tableName;
        String sql;
        CacheWrapper<T> cacheWrapper;

        Loader(Class<T> clazz) {
            try {
                parameterizedType = clazz;
                tableName = (String) parameterizedType.getDeclaredField("tableName").get(null);
                Field primaryKeyField = parameterizedType.getDeclaredField("primaryKey");
                primaryKeyField.setAccessible(true);
                String primaryKey = (String) primaryKeyField.get(null);
                Method getAllQueryFields = parameterizedType.getMethod("getAllQueryFields");
                getAllQueryFields.setAccessible(true);
                String allQueryFields = (String) getAllQueryFields.invoke(null);
                sql = String.format(
                        "SELECT %s FROM main.%s WHERE %s IN (?)", allQueryFields, tableName, primaryKey);
            } catch (Exception e) {
                throw new RuntimeException(e); // should not happened
            }
        }
    }

    public static class CacheWrapper<T extends Domain> {
        final LoadingCache<Integer, Optional<T>> loadingCache;
        final String tableName;

        CacheWrapper(String tableName, LoadingCache<Integer, Optional<T>> loadingCache) {
            this.tableName = tableName;
            this.loadingCache = loadingCache;
        }

        public boolean contains(int key) {
            return loadingCache.getIfPresent(key) != null;
        }

        public T get(int key) {
            return loadingCache.getUnchecked(key).orNull();
        }

        public Observable<T> async(final int key) {
            return Observable.create(new Observable.OnSubscribe<T>() {
                @Override
                public void call(Subscriber<? super T> subscriber) {
                    subscriber.onNext(loadingCache.getUnchecked(key).orNull());
                    subscriber.onCompleted();
                }
            });
        }

        public Optional<T> optional(int key) {
            return loadingCache.getUnchecked(key);
        }

        public List<T> list(Iterable<Integer> ids) throws ExecutionException {
            return Lists.transform(Lists.newLinkedList(loadingCache.getAll(ids).values()),
                    new Function<Optional<T>, T>() {
                        @Override
                        public T apply(Optional<T> o) {
                            return o.orNull();
                        }
                    });
        }

        public Observable<List<T>> asyncList(final Iterable<Integer> ids) {
            return Observable.create(new Observable.OnSubscribe<List<T>>() {
                @Override
                public void call(Subscriber<? super List<T>> subscriber) {
                    try {
                        subscriber.onNext(list(ids));
                        subscriber.onCompleted();
                    } catch (ExecutionException e) {
                        subscriber.onError(e);
                    }
                }
            });
        }

        public Observable<List<T>> asyncList(Iterable<Integer> ids, List<T> defaults) {
            return asyncList(ids).onErrorResumeNext(Observable.just(defaults));
        }

        public List<T> list(Iterable<Integer> ids, List<T> defaults) {
            try {
                return list(ids);
            } catch (ExecutionException ignored) {
                return defaults;
            }
        }

        /**
         * <p>调用 {@link Domain#convertFrom(Cursor)} 从 {@link Cursor} 转换数据时，尝试从缓存中获取。</p>
         * <p>该方法尝试按约定（<code>tableName_primaryKey</code>）查找列，如果能找到，则直接返回该对象，
         * 避免从 {@link android.database.CursorWindow} 的 native 层复制数据到 JVM。</p>
         */
        public boolean clone(Cursor cursor, T domain, String aliasName) {
            if (aliasName == null) aliasName = tableName;
            if (aliasName == null) return false;
            int idx = cursor.getColumnIndex(aliasName + "_" + domain.getPrimaryKeyName());
            if (idx < 0) return false;
            int primaryKey = cursor.getInt(idx);
            Optional<T> cached = loadingCache.getIfPresent(primaryKey);
            if (cached != null && cached.isPresent()) {
                domain.cloneFrom(cached.get());
                return true;
            }
            return false;
        }

        public void put(int i, T v) {
            if (tableName == null) return;
            loadingCache.put(i, Optional.of(v));
        }
    }

    final ConcurrentHashMap<Class<? extends Domain>, Loader> loader = new ConcurrentHashMap<>();
    final ConcurrentHashMap<String, Class<? extends Domain>> table = new ConcurrentHashMap<>();

    public interface CacheStrategy {
        CacheBuilder builder();
    }
    private static final ConcurrentHashMap<Class<? extends Domain>, CacheStrategy>
            strategies = new ConcurrentHashMap<>();

    /**
     * 监听 SQLite UpdateHook 的变化，让缓存失效。
     *
     * <pre>
     *     db.addUpdateHook(new SQLiteDatabase.UpdateHook() {
     *         public void callback(SQLiteDatabase.HookType type, String dbName,
     *                              String tableName, int rowId) {
     *             Cache.from(db).updateHook(tableName, rowId);
     *         }
     *     }
     * </pre>
     */
    public void updateHook(String tableName, int rowId) {
        if (table.containsKey(tableName)) {
            loader.get(table.get(tableName)).cacheWrapper.loadingCache.invalidate(rowId);
        }
    }

    /**
     * 针对某个类型配置缓存策略，在缓存第一次获取的时候初始化。
     */
    @SuppressWarnings("unused")
    public <T extends Domain> void setStrategy(Class<T> domainClazz, CacheStrategy builder) {
        strategies.putIfAbsent(domainClazz, builder);
    }

    /**
     * 清除单例，让所有数据失效。
     */
    public void invalidateAll() {
        for (Loader values : loader.values()) {
            values.cacheWrapper.loadingCache.invalidateAll();
        }
    }

    /**
     * 清除单例，让所有数据失效。
     */
    public void cleanUp() {
        for (Loader values : loader.values()) {
            values.cacheWrapper.loadingCache.cleanUp();
        }
    }

    /**
     * <p>根据 {@link Domain} 的 Class 获取一个缓存。在第一次调用的时候构造，缓存策略由
     * {@link #setStrategy(Class, CacheStrategy)} 决定，默认采用
     * {@link CacheBuilder#softValues()}。</p>
     */
    @SuppressWarnings("unchecked")
    public <T extends Domain> CacheWrapper<T> getCache(Class<T> domainClass) {
        if (!loader.containsKey(domainClass)) {
            Loader queryLoader = new Loader(domainClass);
            CacheStrategy strategy = strategies.get(queryLoader.parameterizedType);
            CacheBuilder builder = strategy == null ?
                    CacheBuilder.newBuilder().softValues() : strategy.builder();
            queryLoader.cacheWrapper = new CacheWrapper(
                    queryLoader.tableName,
                    builder.recordStats()
                            .build(newCacheLoader(queryLoader))
            );
            table.putIfAbsent(queryLoader.tableName, domainClass);
            loader.putIfAbsent(domainClass, queryLoader);
        }

        return loader.get(domainClass).cacheWrapper;
    }

    private CacheLoader<Integer, Optional<Domain>> newCacheLoader(final Loader queryLoader) {
        return new CacheLoader<Integer, Optional<Domain>>() {

            @Override
            public Optional<Domain> load(Integer key) throws Exception {
                SQLiteDatabase database = helper.getReadableDatabase();
                Class<?> type = queryLoader.parameterizedType;
                Cursor cursor = database.rawQuery(queryLoader.sql,
                        new String[]{String.valueOf(key)});
                Domain ret = null;
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        ret = (Domain) type.newInstance();
                        ret.convertFrom(cursor);
                    }
                    cursor.close();
                }
                return Optional.fromNullable(ret);
            }

            private final Joiner joiner = Joiner.on(",");

            @Override
            public Map<Integer, Optional<Domain>> loadAll(
                    Iterable<? extends Integer> keys) throws Exception {
                SQLiteDatabase database = helper.getReadableDatabase();
                Class<?> type = queryLoader.parameterizedType;
                String sql = queryLoader.sql.replace("?", joiner.join(keys));
                Cursor cursor = database.rawQuery(sql, null);
                ImmutableMap.Builder<Integer, Optional<Domain>> ret =
                        ImmutableMap.builder();
                SparseBooleanArray fetched = new SparseBooleanArray();
                if (cursor != null) {
                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToPosition(i);
                        Domain domain = (Domain) type.newInstance();
                        domain.convertFrom(cursor);
                        fetched.put(domain.getPrimaryKeyValue(), true);
                        ret.put(domain.getPrimaryKeyValue(), Optional.of(domain));
                    }
                    cursor.close();
                }
                for (int key : keys) {
                    if (!fetched.get(key, false)) {
                        ret.put(key, Optional.<Domain>absent());
                    }
                }
                return ret.build();
            }
        };
    }
}
