package NeighborSvc;

import java.io.Serializable;

public final class CMDTYPE
  implements Serializable
{
  public static final CMDTYPE CMD_CHECK_IN;
  public static final CMDTYPE CMD_CHECK_IN_CRC;
  public static final CMDTYPE CMD_CHECK_IN_ECT;
  public static final CMDTYPE CMD_CHECK_IN_ECT_CRC;
  public static final CMDTYPE CMD_CHECK_IN_ECT_V1;
  public static final CMDTYPE CMD_CHECK_IN_IBOSS;
  public static final CMDTYPE CMD_GET_LAST_POSITION;
  public static final CMDTYPE CMD_GET_NEIGHBORS;
  public static final CMDTYPE CMD_GET_POINT;
  public static final CMDTYPE CMD_GET_SELF_LAST_POSITION;
  public static final CMDTYPE CMD_GET_SELF_SHARE_TRACE;
  public static final CMDTYPE CMD_GET_SHARE_TRACE_LIST;
  public static final CMDTYPE CMD_GET_SWITCHES;
  public static final CMDTYPE CMD_GET_USERS;
  public static final CMDTYPE CMD_INIT;
  public static final CMDTYPE CMD_RELATION;
  public static final CMDTYPE CMD_SET_SHARE_TRACE;
  public static final CMDTYPE CMD_SET_STATE_SWITCH;
  public static final CMDTYPE CMD_SET_USER_STATE;
  public static final int _CMD_CHECK_IN = 1;
  public static final int _CMD_CHECK_IN_CRC = 103;
  public static final int _CMD_CHECK_IN_ECT = 101;
  public static final int _CMD_CHECK_IN_ECT_CRC = 104;
  public static final int _CMD_CHECK_IN_ECT_V1 = 105;
  public static final int _CMD_CHECK_IN_IBOSS = 106;
  public static final int _CMD_GET_LAST_POSITION = 7;
  public static final int _CMD_GET_NEIGHBORS = 2;
  public static final int _CMD_GET_POINT = 4;
  public static final int _CMD_GET_SELF_LAST_POSITION = 9;
  public static final int _CMD_GET_SELF_SHARE_TRACE = 8;
  public static final int _CMD_GET_SHARE_TRACE_LIST = 6;
  public static final int _CMD_GET_SWITCHES = 10;
  public static final int _CMD_GET_USERS = 102;
  public static final int _CMD_INIT = 0;
  public static final int _CMD_RELATION = 107;
  public static final int _CMD_SET_SHARE_TRACE = 5;
  public static final int _CMD_SET_STATE_SWITCH = 11;
  public static final int _CMD_SET_USER_STATE = 3;
  private static CMDTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CMDTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new CMDTYPE[19];
      CMD_INIT = new CMDTYPE(0, 0, "CMD_INIT");
      CMD_CHECK_IN = new CMDTYPE(1, 1, "CMD_CHECK_IN");
      CMD_GET_NEIGHBORS = new CMDTYPE(2, 2, "CMD_GET_NEIGHBORS");
      CMD_SET_USER_STATE = new CMDTYPE(3, 3, "CMD_SET_USER_STATE");
      CMD_GET_POINT = new CMDTYPE(4, 4, "CMD_GET_POINT");
      CMD_SET_SHARE_TRACE = new CMDTYPE(5, 5, "CMD_SET_SHARE_TRACE");
      CMD_GET_SHARE_TRACE_LIST = new CMDTYPE(6, 6, "CMD_GET_SHARE_TRACE_LIST");
      CMD_GET_LAST_POSITION = new CMDTYPE(7, 7, "CMD_GET_LAST_POSITION");
      CMD_GET_SELF_SHARE_TRACE = new CMDTYPE(8, 8, "CMD_GET_SELF_SHARE_TRACE");
      CMD_GET_SELF_LAST_POSITION = new CMDTYPE(9, 9, "CMD_GET_SELF_LAST_POSITION");
      CMD_GET_SWITCHES = new CMDTYPE(10, 10, "CMD_GET_SWITCHES");
      CMD_SET_STATE_SWITCH = new CMDTYPE(11, 11, "CMD_SET_STATE_SWITCH");
      CMD_CHECK_IN_ECT = new CMDTYPE(12, 101, "CMD_CHECK_IN_ECT");
      CMD_GET_USERS = new CMDTYPE(13, 102, "CMD_GET_USERS");
      CMD_CHECK_IN_CRC = new CMDTYPE(14, 103, "CMD_CHECK_IN_CRC");
      CMD_CHECK_IN_ECT_CRC = new CMDTYPE(15, 104, "CMD_CHECK_IN_ECT_CRC");
      CMD_CHECK_IN_ECT_V1 = new CMDTYPE(16, 105, "CMD_CHECK_IN_ECT_V1");
      CMD_CHECK_IN_IBOSS = new CMDTYPE(17, 106, "CMD_CHECK_IN_IBOSS");
      CMD_RELATION = new CMDTYPE(18, 107, "CMD_RELATION");
      return;
    }
  }
  
  private CMDTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static CMDTYPE convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static CMDTYPE convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.CMDTYPE
 * JD-Core Version:    0.7.0.1
 */