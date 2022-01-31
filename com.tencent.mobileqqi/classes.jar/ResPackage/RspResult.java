package ResPackage;

import java.io.Serializable;

public final class RspResult
  implements Serializable
{
  public static final RspResult Result_ERR;
  public static final RspResult Result_NOAUTH;
  public static final RspResult Result_NOAUTH_ACTION;
  public static final RspResult Result_NOAUTH_LIMIT;
  public static final RspResult Result_NOAUTH_SVIP;
  public static final RspResult Result_NOAUTH_VIP;
  public static final RspResult Result_OK;
  public static final int _Result_ERR = 1;
  public static final int _Result_NOAUTH = 100;
  public static final int _Result_NOAUTH_ACTION = 96;
  public static final int _Result_NOAUTH_LIMIT = 97;
  public static final int _Result_NOAUTH_SVIP = 98;
  public static final int _Result_NOAUTH_VIP = 99;
  public static final int _Result_OK = 0;
  private static RspResult[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!RspResult.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new RspResult[7];
      Result_OK = new RspResult(0, 0, "Result_OK");
      Result_ERR = new RspResult(1, 1, "Result_ERR");
      Result_NOAUTH_ACTION = new RspResult(2, 96, "Result_NOAUTH_ACTION");
      Result_NOAUTH_LIMIT = new RspResult(3, 97, "Result_NOAUTH_LIMIT");
      Result_NOAUTH_SVIP = new RspResult(4, 98, "Result_NOAUTH_SVIP");
      Result_NOAUTH_VIP = new RspResult(5, 99, "Result_NOAUTH_VIP");
      Result_NOAUTH = new RspResult(6, 100, "Result_NOAUTH");
      return;
    }
  }
  
  private RspResult(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static RspResult convert(int paramInt)
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
  
  public static RspResult convert(String paramString)
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
 * Qualified Name:     ResPackage.RspResult
 * JD-Core Version:    0.7.0.1
 */