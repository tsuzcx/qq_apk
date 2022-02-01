package moai.storage;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CacheDumper
  implements DumperPlugin
{
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    paramDumperContext = paramDumperContext.getStdout();
    Iterator localIterator1 = Cache.nameCaches.values().iterator();
    while (localIterator1.hasNext())
    {
      Cache localCache = (Cache)localIterator1.next();
      Iterator localIterator2 = localCache.table.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        CacheStats localCacheStats = ((Cache.Loader)localCache.loader.get(localCache.table.get(str))).cacheWrapper.loadingCache.stats();
        paramDumperContext.println(String.format("%s: ", new Object[] { str }));
        paramDumperContext.println(String.format(" -> hitRate: %.2f%%, load: %.2fms, hit: %d, evict: %d", new Object[] { Double.valueOf(localCacheStats.hitRate() * 100.0D), Double.valueOf(localCacheStats.averageLoadPenalty() / 1000000.0D), Long.valueOf(localCacheStats.hitCount()), Long.valueOf(localCacheStats.evictionCount()) }));
        paramDumperContext.println(String.format(" -> missRate: %.2f%%, exceptionRate: %.2f%%, loadCount: %d", new Object[] { Double.valueOf(localCacheStats.missRate() * 100.0D), Double.valueOf(localCacheStats.loadExceptionRate() * 100.0D), Long.valueOf(localCacheStats.loadCount()) }));
      }
    }
  }
  
  public String getName()
  {
    return "cache";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.CacheDumper
 * JD-Core Version:    0.7.0.1
 */