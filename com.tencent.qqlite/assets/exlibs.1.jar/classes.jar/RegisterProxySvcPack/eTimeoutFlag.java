package RegisterProxySvcPack;

import java.io.Serializable;

public final class eTimeoutFlag
  implements Serializable
{
  public static final eTimeoutFlag C2C_MSG_TIMEOUT;
  public static final eTimeoutFlag DIS_LIST_TIMEOUT;
  public static final eTimeoutFlag DIS_MSG_TIMEOUT;
  public static final eTimeoutFlag DIS_SEQ_TIMEOUT;
  public static final eTimeoutFlag GRP_MASK_TIMEOUT;
  public static final eTimeoutFlag GRP_MSG_TIMEOUT;
  public static final eTimeoutFlag GRP_SEQ_TIMEOUT;
  public static final eTimeoutFlag STAT_REG_TIMEOUT;
  public static final int _C2C_MSG_TIMEOUT = 2;
  public static final int _DIS_LIST_TIMEOUT = 32;
  public static final int _DIS_MSG_TIMEOUT = 128;
  public static final int _DIS_SEQ_TIMEOUT = 64;
  public static final int _GRP_MASK_TIMEOUT = 16;
  public static final int _GRP_MSG_TIMEOUT = 8;
  public static final int _GRP_SEQ_TIMEOUT = 4;
  public static final int _STAT_REG_TIMEOUT = 1;
  private static eTimeoutFlag[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eTimeoutFlag.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new eTimeoutFlag[8];
      STAT_REG_TIMEOUT = new eTimeoutFlag(0, 1, "STAT_REG_TIMEOUT");
      C2C_MSG_TIMEOUT = new eTimeoutFlag(1, 2, "C2C_MSG_TIMEOUT");
      GRP_SEQ_TIMEOUT = new eTimeoutFlag(2, 4, "GRP_SEQ_TIMEOUT");
      GRP_MSG_TIMEOUT = new eTimeoutFlag(3, 8, "GRP_MSG_TIMEOUT");
      GRP_MASK_TIMEOUT = new eTimeoutFlag(4, 16, "GRP_MASK_TIMEOUT");
      DIS_LIST_TIMEOUT = new eTimeoutFlag(5, 32, "DIS_LIST_TIMEOUT");
      DIS_SEQ_TIMEOUT = new eTimeoutFlag(6, 64, "DIS_SEQ_TIMEOUT");
      DIS_MSG_TIMEOUT = new eTimeoutFlag(7, 128, "DIS_MSG_TIMEOUT");
      return;
    }
  }
  
  private eTimeoutFlag(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static eTimeoutFlag convert(int paramInt)
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
  
  public static eTimeoutFlag convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     RegisterProxySvcPack.eTimeoutFlag
 * JD-Core Version:    0.7.0.1
 */