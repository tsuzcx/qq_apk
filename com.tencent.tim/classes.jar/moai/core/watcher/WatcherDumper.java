package moai.core.watcher;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.google.common.cache.Cache;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;

public class WatcherDumper
  implements DumperPlugin
{
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    paramDumperContext = paramDumperContext.getStdout();
    Object localObject1 = Watchers.instance.consumers;
    Object localObject2 = new TreeSet(new WatcherDumper.1(this));
    ((TreeSet)localObject2).addAll(((Map)localObject1).entrySet());
    localObject1 = ((TreeSet)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramDumperContext.println(((Class)((Map.Entry)localObject2).getKey()).getSimpleName() + ":");
      localObject2 = ((Cache)((Map.Entry)localObject2).getValue()).asMap().keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Watchers.Watcher localWatcher = (Watchers.Watcher)((Iterator)localObject2).next();
        paramDumperContext.println(String.format("  [%s] %s", new Object[] { Integer.toHexString(System.identityHashCode(localWatcher)), localWatcher.getClass().getCanonicalName() }));
      }
    }
  }
  
  public String getName()
  {
    return "watcher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.WatcherDumper
 * JD-Core Version:    0.7.0.1
 */