package com.tencent.qqmail.model.cache;

public class SettingItem
{
  public int accountId;
  public String key;
  public int type;
  public String value;
  
  public SettingItem(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.key = paramString1;
    this.value = paramString2;
    this.accountId = paramInt1;
    this.type = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.SettingItem
 * JD-Core Version:    0.7.0.1
 */