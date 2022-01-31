package AccostSvc;

import java.io.Serializable;

public final class CMDTYPE
  implements Serializable
{
  public static final CMDTYPE CMD_CLT_Msg;
  public static final CMDTYPE CMD_DELETE_BlackList;
  public static final CMDTYPE CMD_GET_BlackList;
  public static final CMDTYPE CMD_GET_BlackList_Msg;
  public static final CMDTYPE CMD_GET_BlackList_Profile;
  public static final CMDTYPE CMD_INIT;
  public static final CMDTYPE CMD_INSERT_BlackList;
  public static final CMDTYPE CMD_SVR_Msg;
  public static final CMDTYPE CMD_SWAP_BlackList;
  public static final int _CMD_CLT_Msg = 1;
  public static final int _CMD_DELETE_BlackList = 104;
  public static final int _CMD_GET_BlackList = 101;
  public static final int _CMD_GET_BlackList_Msg = 106;
  public static final int _CMD_GET_BlackList_Profile = 105;
  public static final int _CMD_INIT = 0;
  public static final int _CMD_INSERT_BlackList = 103;
  public static final int _CMD_SVR_Msg = 2;
  public static final int _CMD_SWAP_BlackList = 102;
  private static CMDTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CMDTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new CMDTYPE[9];
      CMD_INIT = new CMDTYPE(0, 0, "CMD_INIT");
      CMD_CLT_Msg = new CMDTYPE(1, 1, "CMD_CLT_Msg");
      CMD_SVR_Msg = new CMDTYPE(2, 2, "CMD_SVR_Msg");
      CMD_GET_BlackList = new CMDTYPE(3, 101, "CMD_GET_BlackList");
      CMD_SWAP_BlackList = new CMDTYPE(4, 102, "CMD_SWAP_BlackList");
      CMD_INSERT_BlackList = new CMDTYPE(5, 103, "CMD_INSERT_BlackList");
      CMD_DELETE_BlackList = new CMDTYPE(6, 104, "CMD_DELETE_BlackList");
      CMD_GET_BlackList_Profile = new CMDTYPE(7, 105, "CMD_GET_BlackList_Profile");
      CMD_GET_BlackList_Msg = new CMDTYPE(8, 106, "CMD_GET_BlackList_Msg");
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
 * Qualified Name:     AccostSvc.CMDTYPE
 * JD-Core Version:    0.7.0.1
 */