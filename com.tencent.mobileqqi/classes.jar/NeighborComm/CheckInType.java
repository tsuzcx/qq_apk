package NeighborComm;

import java.io.Serializable;

public final class CheckInType
  implements Serializable
{
  public static final CheckInType CheckInType_Active;
  public static final CheckInType CheckInType_Passive;
  public static final int _CheckInType_Active = 0;
  public static final int _CheckInType_Passive = 1;
  private static CheckInType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CheckInType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new CheckInType[2];
      CheckInType_Active = new CheckInType(0, 0, "CheckInType_Active");
      CheckInType_Passive = new CheckInType(1, 1, "CheckInType_Passive");
      return;
    }
  }
  
  private CheckInType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static CheckInType convert(int paramInt)
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
  
  public static CheckInType convert(String paramString)
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
 * Qualified Name:     NeighborComm.CheckInType
 * JD-Core Version:    0.7.0.1
 */