package moai.storage;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import java.util.Collections;
import java.util.Set;

final class Domain$3
  extends CacheLoader<String, Set<Domain>>
{
  public Set<Domain> load(String paramString)
    throws Exception
  {
    return Collections.newSetFromMap(CacheBuilder.newBuilder().weakKeys().build().asMap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Domain.3
 * JD-Core Version:    0.7.0.1
 */