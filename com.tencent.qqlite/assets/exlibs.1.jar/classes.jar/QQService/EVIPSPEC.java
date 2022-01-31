package QQService;

import java.io.Serializable;

public final class EVIPSPEC
  implements Serializable
{
  public static final EVIPSPEC E_SP_QQVIP;
  public static final EVIPSPEC E_SP_SUPERQQ;
  public static final EVIPSPEC E_SP_SUPERVIP;
  public static final int _E_SP_QQVIP = 1;
  public static final int _E_SP_SUPERQQ = 2;
  public static final int _E_SP_SUPERVIP = 3;
  private static EVIPSPEC[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!EVIPSPEC.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EVIPSPEC[3];
      E_SP_QQVIP = new EVIPSPEC(0, 1, "E_SP_QQVIP");
      E_SP_SUPERQQ = new EVIPSPEC(1, 2, "E_SP_SUPERQQ");
      E_SP_SUPERVIP = new EVIPSPEC(2, 3, "E_SP_SUPERVIP");
      return;
    }
  }
  
  private EVIPSPEC(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EVIPSPEC convert(int paramInt)
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
  
  public static EVIPSPEC convert(String paramString)
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
 * Qualified Name:     QQService.EVIPSPEC
 * JD-Core Version:    0.7.0.1
 */