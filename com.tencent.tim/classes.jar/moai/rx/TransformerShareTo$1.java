package moai.rx;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

final class TransformerShareTo$1
  extends CacheLoader<String, Cache>
{
  public Cache load(String paramString)
    throws Exception
  {
    return CacheBuilder.newBuilder().recordStats().build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerShareTo.1
 * JD-Core Version:    0.7.0.1
 */