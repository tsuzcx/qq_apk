package com.tencent.qqmail.model.cache;

public class QMSettingCache
  extends QMReadWriteCache<String, SettingItem>
{
  public String getKeyByItem(SettingItem paramSettingItem)
  {
    return null;
  }
  
  public String getValue(String paramString)
  {
    paramString = (SettingItem)get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.value;
  }
  
  public void remove(String[] paramArrayOfString, Runnable paramRunnable)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      remove(paramArrayOfString[i]);
      i += 1;
    }
    runJobsIfNotNull(paramRunnable);
  }
  
  public void removeByAccountId(int paramInt)
  {
    super.select(new QMSettingCache.1(this, paramInt));
  }
  
  public void setValue(String paramString, SettingItem paramSettingItem, Runnable paramRunnable)
  {
    if ((paramString != null) && (paramSettingItem != null))
    {
      put(paramString, paramSettingItem);
      runJobsIfNotNull(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMSettingCache
 * JD-Core Version:    0.7.0.1
 */