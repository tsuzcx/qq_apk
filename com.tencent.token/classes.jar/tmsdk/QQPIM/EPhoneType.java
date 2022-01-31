package tmsdk.QQPIM;

import java.io.Serializable;

public final class EPhoneType
  implements Serializable
{
  public static final EPhoneType MPT_Android;
  public static final EPhoneType MPT_BB;
  public static final EPhoneType MPT_END;
  public static final EPhoneType MPT_Iphone;
  public static final EPhoneType MPT_Kjava;
  public static final EPhoneType MPT_MTK;
  public static final EPhoneType MPT_NONE;
  public static final EPhoneType MPT_PC_Windows;
  public static final EPhoneType MPT_Server;
  public static final EPhoneType MPT_Symbian;
  public static final EPhoneType MPT_SymbianV5;
  public static final EPhoneType MPT_WinPhone;
  public static final int _MPT_Android = 2;
  public static final int _MPT_BB = 8;
  public static final int _MPT_END = 102;
  public static final int _MPT_Iphone = 3;
  public static final int _MPT_Kjava = 4;
  public static final int _MPT_MTK = 7;
  public static final int _MPT_NONE = 0;
  public static final int _MPT_PC_Windows = 9;
  public static final int _MPT_Server = 5;
  public static final int _MPT_Symbian = 1;
  public static final int _MPT_SymbianV5 = 101;
  public static final int _MPT_WinPhone = 6;
  private static EPhoneType[] eq;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!EPhoneType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      eq = new EPhoneType[12];
      MPT_NONE = new EPhoneType(0, 0, "MPT_NONE");
      MPT_Symbian = new EPhoneType(1, 1, "MPT_Symbian");
      MPT_Android = new EPhoneType(2, 2, "MPT_Android");
      MPT_Iphone = new EPhoneType(3, 3, "MPT_Iphone");
      MPT_Kjava = new EPhoneType(4, 4, "MPT_Kjava");
      MPT_Server = new EPhoneType(5, 5, "MPT_Server");
      MPT_WinPhone = new EPhoneType(6, 6, "MPT_WinPhone");
      MPT_MTK = new EPhoneType(7, 7, "MPT_MTK");
      MPT_BB = new EPhoneType(8, 8, "MPT_BB");
      MPT_PC_Windows = new EPhoneType(9, 9, "MPT_PC_Windows");
      MPT_SymbianV5 = new EPhoneType(10, 101, "MPT_SymbianV5");
      MPT_END = new EPhoneType(11, 102, "MPT_END");
      return;
    }
  }
  
  private EPhoneType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    eq[paramInt1] = this;
  }
  
  public static EPhoneType convert(int paramInt)
  {
    int i = 0;
    while (i < eq.length)
    {
      if (eq[i].value() == paramInt) {
        return eq[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static EPhoneType convert(String paramString)
  {
    int i = 0;
    while (i < eq.length)
    {
      if (eq[i].toString().equals(paramString)) {
        return eq[i];
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
    return this.ec;
  }
  
  public int value()
  {
    return this.eb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.EPhoneType
 * JD-Core Version:    0.7.0.1
 */