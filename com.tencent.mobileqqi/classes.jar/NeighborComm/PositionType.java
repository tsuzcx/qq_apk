package NeighborComm;

import java.io.Serializable;

public final class PositionType
  implements Serializable
{
  public static final PositionType PosType_DEC;
  public static final PositionType PosType_ENC;
  public static final int _PosType_DEC = 0;
  public static final int _PosType_ENC = 1;
  private static PositionType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!PositionType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new PositionType[2];
      PosType_DEC = new PositionType(0, 0, "PosType_DEC");
      PosType_ENC = new PositionType(1, 1, "PosType_ENC");
      return;
    }
  }
  
  private PositionType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static PositionType convert(int paramInt)
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
  
  public static PositionType convert(String paramString)
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
 * Qualified Name:     NeighborComm.PositionType
 * JD-Core Version:    0.7.0.1
 */