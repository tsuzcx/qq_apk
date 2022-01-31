package VIP;

import java.io.Serializable;

public final class EOpenCodeDef
  implements Serializable
{
  public static final EOpenCodeDef E_OPEN_API_NULL;
  public static final EOpenCodeDef E_OPEN_ASYNC_STATUS;
  public static final EOpenCodeDef E_OPEN_AUTH_DECODE;
  public static final EOpenCodeDef E_OPEN_AUTH_FAIL;
  public static final EOpenCodeDef E_OPEN_BIND_DECODE;
  public static final EOpenCodeDef E_OPEN_BIND_FAIL;
  public static final EOpenCodeDef E_OPEN_PAY_SUCC;
  public static final EOpenCodeDef E_OPEN_SSO_DECODE;
  public static final EOpenCodeDef E_OPEN_SSO_ENCODE;
  public static final int _E_OPEN_API_NULL = 3001;
  public static final int _E_OPEN_ASYNC_STATUS = 3;
  public static final int _E_OPEN_AUTH_DECODE = 1002;
  public static final int _E_OPEN_AUTH_FAIL = 1001;
  public static final int _E_OPEN_BIND_DECODE = 2002;
  public static final int _E_OPEN_BIND_FAIL = 2001;
  public static final int _E_OPEN_PAY_SUCC = 0;
  public static final int _E_OPEN_SSO_DECODE = 2;
  public static final int _E_OPEN_SSO_ENCODE = 1;
  private static EOpenCodeDef[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!EOpenCodeDef.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EOpenCodeDef[9];
      E_OPEN_PAY_SUCC = new EOpenCodeDef(0, 0, "E_OPEN_PAY_SUCC");
      E_OPEN_SSO_ENCODE = new EOpenCodeDef(1, 1, "E_OPEN_SSO_ENCODE");
      E_OPEN_SSO_DECODE = new EOpenCodeDef(2, 2, "E_OPEN_SSO_DECODE");
      E_OPEN_ASYNC_STATUS = new EOpenCodeDef(3, 3, "E_OPEN_ASYNC_STATUS");
      E_OPEN_AUTH_FAIL = new EOpenCodeDef(4, 1001, "E_OPEN_AUTH_FAIL");
      E_OPEN_AUTH_DECODE = new EOpenCodeDef(5, 1002, "E_OPEN_AUTH_DECODE");
      E_OPEN_BIND_FAIL = new EOpenCodeDef(6, 2001, "E_OPEN_BIND_FAIL");
      E_OPEN_BIND_DECODE = new EOpenCodeDef(7, 2002, "E_OPEN_BIND_DECODE");
      E_OPEN_API_NULL = new EOpenCodeDef(8, 3001, "E_OPEN_API_NULL");
      return;
    }
  }
  
  private EOpenCodeDef(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EOpenCodeDef convert(int paramInt)
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
  
  public static EOpenCodeDef convert(String paramString)
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
 * Qualified Name:     VIP.EOpenCodeDef
 * JD-Core Version:    0.7.0.1
 */