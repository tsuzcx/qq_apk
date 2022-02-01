package UserGrowth;

import java.io.Serializable;

public final class eConfigBit
  implements Serializable
{
  private static eConfigBit[] __values;
  public static final int _eGetAuth = 4;
  public static final int _eGetCallInBg = 8;
  public static final int _eSetAuth = 2;
  public static final int _eShowConfirmWindow = 1;
  public static final eConfigBit eGetAuth;
  public static final eConfigBit eGetCallInBg;
  public static final eConfigBit eSetAuth;
  public static final eConfigBit eShowConfirmWindow;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eConfigBit.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eConfigBit[4];
      eShowConfirmWindow = new eConfigBit(0, 1, "eShowConfirmWindow");
      eSetAuth = new eConfigBit(1, 2, "eSetAuth");
      eGetAuth = new eConfigBit(2, 4, "eGetAuth");
      eGetCallInBg = new eConfigBit(3, 8, "eGetCallInBg");
      return;
    }
  }
  
  private eConfigBit(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eConfigBit convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static eConfigBit convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.eConfigBit
 * JD-Core Version:    0.7.0.1
 */