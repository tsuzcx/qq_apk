package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class SearchHistory
  extends Entity
{
  public int count;
  public String displayName;
  public String extralInfo;
  @unique
  public String key;
  public long time;
  public String troopUin;
  public int type;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SearchHistory
 * JD-Core Version:    0.7.0.1
 */