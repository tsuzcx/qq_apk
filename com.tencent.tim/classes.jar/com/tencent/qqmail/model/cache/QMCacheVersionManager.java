package com.tencent.qqmail.model.cache;

import java.util.concurrent.ConcurrentHashMap;

public class QMCacheVersionManager<K>
  implements IVersionManager<K>
{
  private ConcurrentHashMap<K, Integer> versions = new ConcurrentHashMap(16, 0.9F, 1);
  
  public void clear()
  {
    this.versions.clear();
  }
  
  public boolean dataHasChanged(K paramK, int paramInt)
  {
    int i = getVersion(paramK);
    return (i > paramInt) || ((paramInt > i) && (i == -1));
  }
  
  public int getVersion(K paramK)
  {
    paramK = (Integer)this.versions.get(paramK);
    if (paramK == null) {
      return -1;
    }
    return paramK.intValue();
  }
  
  public void incrVersion(K paramK)
  {
    Integer localInteger2 = (Integer)this.versions.get(paramK);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.versions.put(paramK, Integer.valueOf(localInteger1.intValue() + 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMCacheVersionManager
 * JD-Core Version:    0.7.0.1
 */