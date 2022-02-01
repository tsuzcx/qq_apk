package moai.rx;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by ayangxu.
 */
public class SharedDumper implements DumperPlugin {
    @Override
    public String getName() {
        return "shared";
    }

    @Override
    public void dump(DumperContext dumperContext) throws DumpException {
        PrintStream writer = dumperContext.getStdout();
        Map<String, Cache> shares = TransformerShareTo.shares.asMap();
        TreeSet<Map.Entry<String, Cache>> entries = new TreeSet<>(new Comparator<Map.Entry<String, Cache>>() {
            @Override
            public int compare(Map.Entry<String, Cache> lhs, Map.Entry<String, Cache> rhs) {
                return lhs.getKey().compareTo(rhs.getKey());
            }
        });
        entries.addAll(shares.entrySet());
        writer.println("reentrant rate, less is better.");
        for (Map.Entry<String, Cache> entry : entries) {
            CacheStats stats = entry.getValue().stats();
            writer.println(String.format(
                    "%s => %.2f%%", entry.getKey(), stats.hitRate()));
        }
    }
}
