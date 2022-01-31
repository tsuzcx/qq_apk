package VIP;

import java.io.Serializable;

public final class QWalletOpenPayDef
  implements Serializable
{
  public static final QWalletOpenPayDef E_OPEN_API_NULL;
  public static final QWalletOpenPayDef E_OPEN_AUTH_1;
  public static final QWalletOpenPayDef E_OPEN_AUTH_2;
  public static final QWalletOpenPayDef E_OPEN_AUTH_3;
  public static final QWalletOpenPayDef E_OPEN_AUTH_4;
  public static final QWalletOpenPayDef E_OPEN_BIND_0;
  public static final QWalletOpenPayDef E_OPEN_BIND_1;
  public static final QWalletOpenPayDef E_OPEN_PAY_SUCC;
  public static final int _E_OPEN_API_NULL = 3001;
  public static final int _E_OPEN_AUTH_1 = 1001;
  public static final int _E_OPEN_AUTH_2 = 1002;
  public static final int _E_OPEN_AUTH_3 = 1003;
  public static final int _E_OPEN_AUTH_4 = 1004;
  public static final int _E_OPEN_BIND_0 = 2001;
  public static final int _E_OPEN_BIND_1 = 2002;
  public static final int _E_OPEN_PAY_SUCC = 0;
  private static QWalletOpenPayDef[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!QWalletOpenPayDef.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new QWalletOpenPayDef[8];
      E_OPEN_PAY_SUCC = new QWalletOpenPayDef(0, 0, "E_OPEN_PAY_SUCC");
      E_OPEN_AUTH_1 = new QWalletOpenPayDef(1, 1001, "E_OPEN_AUTH_1");
      E_OPEN_AUTH_2 = new QWalletOpenPayDef(2, 1002, "E_OPEN_AUTH_2");
      E_OPEN_AUTH_3 = new QWalletOpenPayDef(3, 1003, "E_OPEN_AUTH_3");
      E_OPEN_AUTH_4 = new QWalletOpenPayDef(4, 1004, "E_OPEN_AUTH_4");
      E_OPEN_BIND_0 = new QWalletOpenPayDef(5, 2001, "E_OPEN_BIND_0");
      E_OPEN_BIND_1 = new QWalletOpenPayDef(6, 2002, "E_OPEN_BIND_1");
      E_OPEN_API_NULL = new QWalletOpenPayDef(7, 3001, "E_OPEN_API_NULL");
      return;
    }
  }
  
  private QWalletOpenPayDef(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static QWalletOpenPayDef convert(int paramInt)
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
  
  public static QWalletOpenPayDef convert(String paramString)
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
 * Qualified Name:     VIP.QWalletOpenPayDef
 * JD-Core Version:    0.7.0.1
 */