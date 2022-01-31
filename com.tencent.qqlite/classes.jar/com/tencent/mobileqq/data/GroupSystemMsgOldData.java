package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class GroupSystemMsgOldData
  extends Entity
{
  public long msgtime;
  @unique
  public long uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.GroupSystemMsgOldData
 * JD-Core Version:    0.7.0.1
 */