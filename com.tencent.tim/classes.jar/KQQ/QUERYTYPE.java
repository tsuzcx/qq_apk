package KQQ;

import java.io.Serializable;

public final class QUERYTYPE
  implements Serializable
{
  public static final QUERYTYPE CELL_V2;
  public static final QUERYTYPE GPS_CELL_V1;
  public static final QUERYTYPE GPS_V2;
  public static final QUERYTYPE WIFI_V2;
  public static final int _CELL_V2 = 2;
  public static final int _GPS_CELL_V1 = 0;
  public static final int _GPS_V2 = 1;
  public static final int _WIFI_V2 = 4;
  private static QUERYTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!QUERYTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new QUERYTYPE[4];
      GPS_CELL_V1 = new QUERYTYPE(0, 0, "GPS_CELL_V1");
      GPS_V2 = new QUERYTYPE(1, 1, "GPS_V2");
      CELL_V2 = new QUERYTYPE(2, 2, "CELL_V2");
      WIFI_V2 = new QUERYTYPE(3, 4, "WIFI_V2");
      return;
    }
  }
  
  private QUERYTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static QUERYTYPE convert(int paramInt)
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
  
  public static QUERYTYPE convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     KQQ.QUERYTYPE
 * JD-Core Version:    0.7.0.1
 */