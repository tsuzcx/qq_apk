package NeighborSvc;

import java.io.Serializable;

public final class USERTYPE
  implements Serializable
{
  public static final USERTYPE USERTYPE_GRAY;
  public static final USERTYPE USERTYPE_INIT;
  public static final USERTYPE USERTYPE_LBS_Evil_User;
  public static final USERTYPE USERTYPE_LBS_Friend;
  public static final USERTYPE USERTYPE_LBS_MQQ;
  public static final USERTYPE USERTYPE_LBS_Share_Trace;
  public static final USERTYPE USERTYPE_STATE;
  public static final USERTYPE USERTYPE_WHITE;
  public static final int _USERTYPE_GRAY = 16;
  public static final int _USERTYPE_INIT = 0;
  public static final int _USERTYPE_LBS_Evil_User = 8;
  public static final int _USERTYPE_LBS_Friend = 2;
  public static final int _USERTYPE_LBS_MQQ = 1;
  public static final int _USERTYPE_LBS_Share_Trace = 4;
  public static final int _USERTYPE_STATE = 64;
  public static final int _USERTYPE_WHITE = 32;
  private static USERTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!USERTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new USERTYPE[8];
      USERTYPE_INIT = new USERTYPE(0, 0, "USERTYPE_INIT");
      USERTYPE_LBS_MQQ = new USERTYPE(1, 1, "USERTYPE_LBS_MQQ");
      USERTYPE_LBS_Friend = new USERTYPE(2, 2, "USERTYPE_LBS_Friend");
      USERTYPE_LBS_Share_Trace = new USERTYPE(3, 4, "USERTYPE_LBS_Share_Trace");
      USERTYPE_LBS_Evil_User = new USERTYPE(4, 8, "USERTYPE_LBS_Evil_User");
      USERTYPE_GRAY = new USERTYPE(5, 16, "USERTYPE_GRAY");
      USERTYPE_WHITE = new USERTYPE(6, 32, "USERTYPE_WHITE");
      USERTYPE_STATE = new USERTYPE(7, 64, "USERTYPE_STATE");
      return;
    }
  }
  
  private USERTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static USERTYPE convert(int paramInt)
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
  
  public static USERTYPE convert(String paramString)
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
 * Qualified Name:     NeighborSvc.USERTYPE
 * JD-Core Version:    0.7.0.1
 */