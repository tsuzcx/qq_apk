package com.tencent.component.network.module.cache;

import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.cache.file.FileStorageHandler.Collector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class CacheManager$1
  implements FileStorageHandler.Collector
{
  public Collection<FileCacheService> collect()
  {
    synchronized ()
    {
      if (CacheManager.access$000().size() <= 0)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject1 = new ArrayList(CacheManager.access$000().values());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.cache.CacheManager.1
 * JD-Core Version:    0.7.0.1
 */