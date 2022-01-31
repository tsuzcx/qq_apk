package wns_proxy;

import java.io.Serializable;

public final class EnumHttpMethod
  implements Serializable
{
  public static final int _eGET = 0;
  public static final int _ePOST = 1;
  private static EnumHttpMethod[] a;
  public static final EnumHttpMethod eGET;
  public static final EnumHttpMethod ePOST;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!EnumHttpMethod.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EnumHttpMethod[2];
      eGET = new EnumHttpMethod(0, 0, "eGET");
      ePOST = new EnumHttpMethod(1, 1, "ePOST");
      return;
    }
  }
  
  private EnumHttpMethod(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EnumHttpMethod convert(int paramInt)
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
  
  public static EnumHttpMethod convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     wns_proxy.EnumHttpMethod
 * JD-Core Version:    0.7.0.1
 */