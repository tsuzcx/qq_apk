package NeighborComm;

import java.io.Serializable;

public final class CMDTYPE
  implements Serializable
{
  public static final CMDTYPE CMD_INIT;
  public static final int _CMD_INIT = 0;
  private static CMDTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CMDTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new CMDTYPE[1];
      CMD_INIT = new CMDTYPE(0, 0, "CMD_INIT");
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
 * Qualified Name:     NeighborComm.CMDTYPE
 * JD-Core Version:    0.7.0.1
 */