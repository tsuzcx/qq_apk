package NeighborSvc;

import java.io.Serializable;

public final class MqqSysType
  implements Serializable
{
  public static final MqqSysType MqqSysType_Android;
  public static final MqqSysType MqqSysType_HD;
  public static final MqqSysType MqqSysType_HD_MINI;
  public static final MqqSysType MqqSysType_Iphone;
  public static final MqqSysType MqqSysType_MTK;
  public static final MqqSysType MqqSysType_SNG;
  public static final MqqSysType MqqSysType_Symbian_V3;
  public static final MqqSysType MqqSysType_Symbian_V5;
  public static final MqqSysType MqqSysType_WP7;
  public static final MqqSysType MqqSysType_default;
  public static final int _MqqSysType_Android = 2;
  public static final int _MqqSysType_HD = 6;
  public static final int _MqqSysType_HD_MINI = 7;
  public static final int _MqqSysType_Iphone = 1;
  public static final int _MqqSysType_MTK = 8;
  public static final int _MqqSysType_SNG = 9;
  public static final int _MqqSysType_Symbian_V3 = 5;
  public static final int _MqqSysType_Symbian_V5 = 3;
  public static final int _MqqSysType_WP7 = 4;
  public static final int _MqqSysType_default = 0;
  private static MqqSysType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!MqqSysType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new MqqSysType[10];
      MqqSysType_default = new MqqSysType(0, 0, "MqqSysType_default");
      MqqSysType_Iphone = new MqqSysType(1, 1, "MqqSysType_Iphone");
      MqqSysType_Android = new MqqSysType(2, 2, "MqqSysType_Android");
      MqqSysType_Symbian_V5 = new MqqSysType(3, 3, "MqqSysType_Symbian_V5");
      MqqSysType_WP7 = new MqqSysType(4, 4, "MqqSysType_WP7");
      MqqSysType_Symbian_V3 = new MqqSysType(5, 5, "MqqSysType_Symbian_V3");
      MqqSysType_HD = new MqqSysType(6, 6, "MqqSysType_HD");
      MqqSysType_HD_MINI = new MqqSysType(7, 7, "MqqSysType_HD_MINI");
      MqqSysType_MTK = new MqqSysType(8, 8, "MqqSysType_MTK");
      MqqSysType_SNG = new MqqSysType(9, 9, "MqqSysType_SNG");
      return;
    }
  }
  
  private MqqSysType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static MqqSysType convert(int paramInt)
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
  
  public static MqqSysType convert(String paramString)
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
 * Qualified Name:     NeighborSvc.MqqSysType
 * JD-Core Version:    0.7.0.1
 */