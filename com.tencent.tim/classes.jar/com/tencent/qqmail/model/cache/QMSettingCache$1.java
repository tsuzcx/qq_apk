package com.tencent.qqmail.model.cache;

class QMSettingCache$1
  implements IQuery<SettingItem>
{
  QMSettingCache$1(QMSettingCache paramQMSettingCache, int paramInt) {}
  
  public boolean map(SettingItem paramSettingItem)
  {
    return paramSettingItem.accountId == this.val$accountId;
  }
  
  public void reduce(SettingItem paramSettingItem)
  {
    this.this$0.remove(paramSettingItem.key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMSettingCache.1
 * JD-Core Version:    0.7.0.1
 */