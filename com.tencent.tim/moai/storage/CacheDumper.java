package moai.storage;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.google.common.cache.CacheStats;

import java.io.PrintStream;
import java.util.Map;

/**
 * Created by ayangxu.
 */
public class CacheDumper implements DumperPlugin {
    @Override
    public String getName() {
        return "cache";
    }

    @Override
    public void dump(DumperContext dumperContext) throws DumpException {
        PrintStream writer = dumperContext.getStdout();
        Map<String, Cache> caches = Cache.nameCaches;
        for (Cache cache : caches.values()) {
            for (String key : cache.table.keySet()) {
                CacheStats stat = cache.loader.get(cache.table.get(key)).cacheWrapper.loadingCache.stats();
                writer.println(String.format("%s: ", key));
                writer.println(String.format(" -> hitRate: %.2f%%, load: %.2fms, hit: %d, evict: %d",
                        stat.hitRate() * 100, stat.averageLoadPenalty() / (1000 * 1000),
                        stat.hitCount(), stat.evictionCount()));
                writer.println(String.format(" -> missRate: %.2f%%, exceptionRate: %.2f%%, loadCount: %d",
                        stat.missRate() * 100, stat.loadExceptionRate() * 100, stat.loadCount()));
            }
        }
    }
}
