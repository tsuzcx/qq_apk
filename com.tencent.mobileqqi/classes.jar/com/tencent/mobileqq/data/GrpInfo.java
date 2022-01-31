package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class GrpInfo
  extends Entity
{
  public long grpArchStamp;
  public long grpDataStamp;
  @unique
  public String grpID;
  public String grpMemberNum;
  public String grpName;
  public long grpOffMsgSeek;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.GrpInfo
 * JD-Core Version:    0.7.0.1
 */