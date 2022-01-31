package QQService;

import java.io.Serializable;

public final class EFLAG
  implements Serializable
{
  public static final EFLAG E_DELUXE;
  public static final int _E_DELUXE = 1;
  private static EFLAG[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!EFLAG.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EFLAG[1];
      E_DELUXE = new EFLAG(0, 1, "E_DELUXE");
      return;
    }
  }
  
  private EFLAG(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EFLAG convert(int paramInt)
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
  
  public static EFLAG convert(String paramString)
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
 * Qualified Name:     QQService.EFLAG
 * JD-Core Version:    0.7.0.1
 */