package com.tencent.mobileqq.msgbackup.data;

import com.tencent.mobileqq.persistence.Entity;

public class MsgBackupExtraEntity
  extends Entity
{
  public static final String TABLE_NAME = "ex_info";
  public String name;
  public String value;
  
  public String getTableName()
  {
    return "ex_info";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity
 * JD-Core Version:    0.7.0.1
 */