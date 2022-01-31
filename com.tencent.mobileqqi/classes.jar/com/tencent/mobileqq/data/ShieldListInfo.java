package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin")
public class ShieldListInfo
  extends Entity
{
  public static final int SHIELD_LIST_DEFAULT_SRC_SUB_ID = 0;
  public static final int SHIELD_LIST_INFO_FLAG_IS_SHIELD = 1;
  public static final int SHIELD_LIST_INFO_FLAG_NOT_SHIELD = 0;
  public static final int SHIELD_LIST_SOURCE_ID_CIRCLE_GROUP = 23;
  public static final int SHIELD_LIST_SOURCE_ID_CONTECT = 8;
  public static final int SHIELD_LIST_SOURCE_ID_DIS_TEMP = 7;
  public static final int SHIELD_LIST_SOURCE_ID_GRP_TEMP = 6;
  public static final int SHIELD_LIST_SOURCE_ID_INVALID = -1;
  public static final int SHIELD_LIST_SOURCE_ID_LBSFRIEND = 9;
  public static final int SHIELD_LIST_SOURCE_ID_OPEN_TROOP_TEMP = 132;
  public static final int SHIELD_LIST_SOURCE_ID_PC_QQ_SEARCH = 24;
  public static final int SHIELD_LIST_SOURCE_ID_RICH_STATE = 18;
  public static final int SHIELD_LIST_SOURCE_ID_VALIDATION = 21;
  public static final int SHIELD_LIST_SOURCE_ID_WPA = 10;
  public int flags;
  public int source_id;
  public int source_sub_id;
  @unique
  public String uin;
  
  public static int AIO_TYPE_2_SOURCE_ID(int paramInt)
  {
    switch (paramInt)
    {
    case 1002: 
    case 1003: 
    case 1007: 
    case 1008: 
    case 1010: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    default: 
      return -1;
    case 1000: 
      return 6;
    case 1020: 
      return 132;
    case 1004: 
      return 7;
    case 1005: 
      return 10;
    case 1023: 
      return 24;
    case 1006: 
      return 8;
    case 1009: 
      return 18;
    case 1001: 
      return 9;
    case 1021: 
      return 23;
    }
    return 21;
  }
  
  public static int SOURCE_ID_2_AIO_TYPE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 6: 
      return 1000;
    case 132: 
      return 1020;
    case 7: 
      return 1004;
    case 10: 
      return 1005;
    case 24: 
      return 1023;
    case 8: 
      return 1006;
    case 18: 
      return 1009;
    case 9: 
      return 1001;
    case 23: 
      return 1021;
    }
    return 1022;
  }
  
  private void shieldMsg(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.flags = i;
      return;
    }
  }
  
  public boolean isShieldMsg()
  {
    return this.flags == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShieldListInfo
 * JD-Core Version:    0.7.0.1
 */