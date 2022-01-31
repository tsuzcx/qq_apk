package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class TroopMessageNavigateInfo
  extends Entity
{
  public static int STATUS_ADD;
  public static int STATUS_DELETE = 3;
  public static int STATUS_MODIFY;
  public static int STATUS_NORMAL = 0;
  public long msgseq;
  public int status = STATUS_NORMAL;
  public String summary;
  public String troopCode;
  public int type;
  
  static
  {
    STATUS_ADD = 1;
    STATUS_MODIFY = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */