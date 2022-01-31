package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class TroopAppUpdateTimeEntity
  extends Entity
{
  public long timestamp = 0L;
  public long troopCode = 0L;
  
  protected Class getClassForTable()
  {
    return TroopAppFlagInfoEntity.class;
  }
  
  public String getTableName()
  {
    return "TroopAppUpdateTimeEntity" + this.troopCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopAppUpdateTimeEntity
 * JD-Core Version:    0.7.0.1
 */