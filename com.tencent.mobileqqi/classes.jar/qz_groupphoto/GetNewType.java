package qz_groupphoto;

import java.io.Serializable;

public final class GetNewType
  implements Serializable
{
  public static final GetNewType NEWCNT;
  public static final GetNewType NEWHOT;
  public static final GetNewType NEWHOTANDCNT;
  public static final int _NEWCNT = 2;
  public static final int _NEWHOT = 1;
  public static final int _NEWHOTANDCNT = 0;
  private static GetNewType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!GetNewType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new GetNewType[3];
      NEWHOTANDCNT = new GetNewType(0, 0, "NEWHOTANDCNT");
      NEWHOT = new GetNewType(1, 1, "NEWHOT");
      NEWCNT = new GetNewType(2, 2, "NEWCNT");
      return;
    }
  }
  
  private GetNewType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static GetNewType convert(int paramInt)
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
  
  public static GetNewType convert(String paramString)
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
 * Qualified Name:     qz_groupphoto.GetNewType
 * JD-Core Version:    0.7.0.1
 */