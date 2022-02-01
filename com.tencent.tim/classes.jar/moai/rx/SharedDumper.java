package moai.rx;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class SharedDumper
  implements DumperPlugin
{
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    paramDumperContext = paramDumperContext.getStdout();
    Object localObject1 = TransformerShareTo.shares.asMap();
    Object localObject2 = new TreeSet(new SharedDumper.1(this));
    ((TreeSet)localObject2).addAll(((Map)localObject1).entrySet());
    paramDumperContext.println("reentrant rate, less is better.");
    localObject1 = ((TreeSet)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      CacheStats localCacheStats = ((Cache)((Map.Entry)localObject2).getValue()).stats();
      paramDumperContext.println(String.format("%s => %.2f%%", new Object[] { ((Map.Entry)localObject2).getKey(), Double.valueOf(localCacheStats.hitRate()) }));
    }
  }
  
  public String getName()
  {
    return "shared";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.SharedDumper
 * JD-Core Version:    0.7.0.1
 */