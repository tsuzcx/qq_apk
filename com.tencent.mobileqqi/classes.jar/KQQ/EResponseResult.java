package KQQ;

import java.io.Serializable;

public final class EResponseResult
  implements Serializable
{
  public static final int _eFail = 1;
  public static final int _eSucc = 0;
  private static EResponseResult[] a;
  public static final EResponseResult eFail;
  public static final EResponseResult eSucc;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!EResponseResult.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EResponseResult[2];
      eSucc = new EResponseResult(0, 0, "eSucc");
      eFail = new EResponseResult(1, 1, "eFail");
      return;
    }
  }
  
  private EResponseResult(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EResponseResult convert(int paramInt)
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
  
  public static EResponseResult convert(String paramString)
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
 * Qualified Name:     KQQ.EResponseResult
 * JD-Core Version:    0.7.0.1
 */