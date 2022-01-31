package QQService;

import java.io.Serializable;

public final class EDIAMOND
  implements Serializable
{
  public static final EDIAMOND E_DIAMOND_GREEN;
  public static final EDIAMOND E_DIAMOND_RED;
  public static final EDIAMOND E_DIAMOND_YELLOW;
  public static final int _E_DIAMOND_GREEN = 103;
  public static final int _E_DIAMOND_RED = 101;
  public static final int _E_DIAMOND_YELLOW = 102;
  private static EDIAMOND[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!EDIAMOND.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EDIAMOND[3];
      E_DIAMOND_RED = new EDIAMOND(0, 101, "E_DIAMOND_RED");
      E_DIAMOND_YELLOW = new EDIAMOND(1, 102, "E_DIAMOND_YELLOW");
      E_DIAMOND_GREEN = new EDIAMOND(2, 103, "E_DIAMOND_GREEN");
      return;
    }
  }
  
  private EDIAMOND(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EDIAMOND convert(int paramInt)
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
  
  public static EDIAMOND convert(String paramString)
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
 * Qualified Name:     QQService.EDIAMOND
 * JD-Core Version:    0.7.0.1
 */