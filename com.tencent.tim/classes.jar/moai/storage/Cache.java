package moai.storage;

import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import rx.Observable;

public class Cache
{
  private static final ConcurrentHashMap<SQLiteDatabase, Cache> caches = new ConcurrentHashMap();
  private static final String defaultCacheName = "Default";
  static final ConcurrentHashMap<String, Cache> nameCaches = new ConcurrentHashMap();
  private static final CacheWrapper safety = new CacheWrapper(null, CacheBuilder.newBuilder().weakValues().build(new Cache.2()));
  private static final ConcurrentHashMap<Class<? extends Domain>, CacheStrategy> strategies = new ConcurrentHashMap();
  private final SQLiteOpenHelper helper;
  final ConcurrentHashMap<Class<? extends Domain>, Loader> loader = new ConcurrentHashMap();
  final String name;
  final ConcurrentHashMap<String, Class<? extends Domain>> table = new ConcurrentHashMap();
  
  public Cache(SQLiteOpenHelper paramSQLiteOpenHelper, String paramString)
  {
    this.helper = paramSQLiteOpenHelper;
    this.name = paramString;
  }
  
  public static void create(Context paramContext, SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    create(paramContext, paramSQLiteOpenHelper, "Default");
  }
  
  public static void create(Context paramContext, SQLiteOpenHelper paramSQLiteOpenHelper, String paramString)
  {
    if (!caches.containsKey(paramSQLiteOpenHelper.getReadableDatabase()))
    {
      Cache localCache = new Cache(paramSQLiteOpenHelper, paramString);
      caches.putIfAbsent(paramSQLiteOpenHelper.getReadableDatabase(), localCache);
      nameCaches.putIfAbsent(paramString, localCache);
      if (Build.VERSION.SDK_INT >= 14) {
        paramContext.getApplicationContext().registerComponentCallbacks(new Cache.1(localCache));
      }
    }
  }
  
  public static Cache from(SQLiteDatabase paramSQLiteDatabase)
  {
    return (Cache)caches.get(paramSQLiteDatabase);
  }
  
  public static Cache from(String paramString)
  {
    return (Cache)nameCaches.get(paramString);
  }
  
  private CacheLoader<Integer, Optional<Domain>> newCacheLoader(Loader paramLoader)
  {
    return new Cache.3(this, paramLoader);
  }
  
  public static <T extends Domain> CacheWrapper<T> of(Class<T> paramClass)
  {
    if (from("Default") == null) {
      return safety;
    }
    return (CacheWrapper)Optional.fromNullable(from("Default").getCache(paramClass)).or(safety);
  }
  
  public void cleanUp()
  {
    Iterator localIterator = this.loader.values().iterator();
    while (localIterator.hasNext()) {
      ((Loader)localIterator.next()).cacheWrapper.loadingCache.cleanUp();
    }
  }
  
  public <T extends Domain> CacheWrapper<T> getCache(Class<T> paramClass)
  {
    Loader localLoader;
    if (!this.loader.containsKey(paramClass))
    {
      localLoader = new Loader(paramClass);
      localObject = (CacheStrategy)strategies.get(localLoader.parameterizedType);
      if (localObject != null) {
        break label110;
      }
    }
    label110:
    for (Object localObject = CacheBuilder.newBuilder().softValues();; localObject = ((CacheStrategy)localObject).builder())
    {
      localLoader.cacheWrapper = new CacheWrapper(localLoader.tableName, ((CacheBuilder)localObject).recordStats().build(newCacheLoader(localLoader)));
      this.table.putIfAbsent(localLoader.tableName, paramClass);
      this.loader.putIfAbsent(paramClass, localLoader);
      return ((Loader)this.loader.get(paramClass)).cacheWrapper;
    }
  }
  
  public void invalidateAll()
  {
    Iterator localIterator = this.loader.values().iterator();
    while (localIterator.hasNext()) {
      ((Loader)localIterator.next()).cacheWrapper.loadingCache.invalidateAll();
    }
  }
  
  public <T extends Domain> void setStrategy(Class<T> paramClass, CacheStrategy paramCacheStrategy)
  {
    strategies.putIfAbsent(paramClass, paramCacheStrategy);
  }
  
  public void updateHook(String paramString, int paramInt)
  {
    if (this.table.containsKey(paramString)) {
      ((Loader)this.loader.get(this.table.get(paramString))).cacheWrapper.loadingCache.invalidate(Integer.valueOf(paramInt));
    }
  }
  
  public static abstract interface CacheStrategy
  {
    public abstract CacheBuilder builder();
  }
  
  public static class CacheWrapper<T extends Domain>
  {
    final LoadingCache<Integer, Optional<T>> loadingCache;
    final String tableName;
    
    CacheWrapper(String paramString, LoadingCache<Integer, Optional<T>> paramLoadingCache)
    {
      this.tableName = paramString;
      this.loadingCache = paramLoadingCache;
    }
    
    public Observable<T> async(int paramInt)
    {
      return Observable.create(new Cache.CacheWrapper.1(this, paramInt));
    }
    
    public Observable<List<T>> asyncList(Iterable<Integer> paramIterable)
    {
      return Observable.create(new Cache.CacheWrapper.3(this, paramIterable));
    }
    
    public Observable<List<T>> asyncList(Iterable<Integer> paramIterable, List<T> paramList)
    {
      return asyncList(paramIterable).onErrorResumeNext(Observable.just(paramList));
    }
    
    public boolean clone(Cursor paramCursor, T paramT, String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = this.tableName;
      }
      if (str == null) {
        return false;
      }
      int i = paramCursor.getColumnIndex(str + "_" + paramT.getPrimaryKeyName());
      if (i < 0) {
        return false;
      }
      i = paramCursor.getInt(i);
      paramCursor = (Optional)this.loadingCache.getIfPresent(Integer.valueOf(i));
      if ((paramCursor != null) && (paramCursor.isPresent()))
      {
        paramT.cloneFrom((Domain)paramCursor.get());
        return true;
      }
      return false;
    }
    
    public boolean contains(int paramInt)
    {
      return this.loadingCache.getIfPresent(Integer.valueOf(paramInt)) != null;
    }
    
    public T get(int paramInt)
    {
      return (Domain)((Optional)this.loadingCache.getUnchecked(Integer.valueOf(paramInt))).orNull();
    }
    
    public List<T> list(Iterable<Integer> paramIterable)
      throws ExecutionException
    {
      return Lists.transform(Lists.newLinkedList(this.loadingCache.getAll(paramIterable).values()), new Cache.CacheWrapper.2(this));
    }
    
    public List<T> list(Iterable<Integer> paramIterable, List<T> paramList)
    {
      try
      {
        paramIterable = list(paramIterable);
        return paramIterable;
      }
      catch (ExecutionException paramIterable) {}
      return paramList;
    }
    
    public Optional<T> optional(int paramInt)
    {
      return (Optional)this.loadingCache.getUnchecked(Integer.valueOf(paramInt));
    }
    
    public void put(int paramInt, T paramT)
    {
      if (this.tableName == null) {
        return;
      }
      this.loadingCache.put(Integer.valueOf(paramInt), Optional.of(paramT));
    }
  }
  
  static class Loader<T extends Domain>
  {
    Cache.CacheWrapper<T> cacheWrapper;
    Class<T> parameterizedType;
    String sql;
    String tableName;
    
    Loader(Class<T> paramClass)
    {
      try
      {
        this.parameterizedType = paramClass;
        this.tableName = ((String)this.parameterizedType.getDeclaredField("tableName").get(null));
        paramClass = this.parameterizedType.getDeclaredField("primaryKey");
        paramClass.setAccessible(true);
        paramClass = (String)paramClass.get(null);
        Method localMethod = this.parameterizedType.getMethod("getAllQueryFields", new Class[0]);
        localMethod.setAccessible(true);
        this.sql = String.format("SELECT %s FROM main.%s WHERE %s IN (?)", new Object[] { (String)localMethod.invoke(null, new Object[0]), this.tableName, paramClass });
        return;
      }
      catch (Exception paramClass)
      {
        throw new RuntimeException(paramClass);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Cache
 * JD-Core Version:    0.7.0.1
 */