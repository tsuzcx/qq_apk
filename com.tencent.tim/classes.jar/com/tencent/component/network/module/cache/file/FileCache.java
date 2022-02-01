package com.tencent.component.network.module.cache.file;

import com.tencent.component.network.module.cache.common.LruCache;
import com.tencent.component.network.utils.FileUtils;

public class FileCache<K>
  extends LruCache<K, String>
{
  public FileCache(int paramInt)
  {
    super(paramInt);
  }
  
  private static int getFileSize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    return 1;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {}
    while ((paramString1 != null) && (paramString1.equals(paramString2))) {
      return;
    }
    try
    {
      recycle(paramString1);
      return;
    }
    finally {}
  }
  
  public void recycle(String paramString)
  {
    if (paramString != null) {
      FileUtils.delete(paramString);
    }
  }
  
  protected int sizeOf(K paramK, String paramString)
  {
    return getFileSize(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileCache
 * JD-Core Version:    0.7.0.1
 */