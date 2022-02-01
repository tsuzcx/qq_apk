package moai.proxy;

import com.google.common.cache.CacheLoader;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class JavaBeanProxy$1
  extends CacheLoader<Object, Set<String>>
{
  public Set<String> load(Object paramObject)
    throws Exception
  {
    return Collections.newSetFromMap(new ConcurrentHashMap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.proxy.JavaBeanProxy.1
 * JD-Core Version:    0.7.0.1
 */