package moai.core.watcher;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.google.common.cache.Cache;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

import rx.Subscription;

/**
 * Created by ayangxu.
 */
public class WatcherDumper implements DumperPlugin {
    @Override
    public String getName() {
        return "watcher";
    }

    @Override
    public void dump(DumperContext dumperContext) throws DumpException {
        PrintStream writer = dumperContext.getStdout();
        Map<Class<? extends Watchers.Watcher>,
                Cache<Watchers.Watcher, Subscription>> consumers = Watchers.instance.consumers;
        TreeSet<Map.Entry<Class<? extends Watchers.Watcher>,
                Cache<Watchers.Watcher, Subscription>>> entries = new TreeSet<>(
                new Comparator<Map.Entry<Class<? extends Watchers.Watcher>,
                                Cache<Watchers.Watcher, Subscription>>>() {
                    @Override
                    public int compare(Map.Entry<Class<? extends Watchers.Watcher>, Cache<Watchers.Watcher, Subscription>> lhs,
                                       Map.Entry<Class<? extends Watchers.Watcher>, Cache<Watchers.Watcher, Subscription>> rhs) {
                        return lhs.getKey().getSimpleName().compareTo(rhs.getKey().getSimpleName());
                    }
                });
        entries.addAll(consumers.entrySet());
        for (Map.Entry<Class<? extends Watchers.Watcher>,
                Cache<Watchers.Watcher, Subscription>> entry : entries) {
            writer.println(entry.getKey().getSimpleName() + ":");
            for (Watchers.Watcher watcher : entry.getValue().asMap().keySet()) {
                writer.println(String.format("  [%s] %s",
                        Integer.toHexString(System.identityHashCode(watcher)),
                        watcher.getClass().getCanonicalName()));
            }
        }
    }
}
