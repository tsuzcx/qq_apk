package wns_proxy;

import java.io.Serializable;

public final class EnumHttpMethod
  implements Serializable
{
  private static EnumHttpMethod[] __values = new EnumHttpMethod[2];
  public static final int _eGET = 0;
  public static final int _ePOST = 1;
  public static final EnumHttpMethod eGET = new EnumHttpMethod(0, 0, "eGET");
  public static final EnumHttpMethod ePOST = new EnumHttpMethod(1, 1, "ePOST");
  private String __T = new String();
  private int __value;
  
  private EnumHttpMethod(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static EnumHttpMethod convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EnumHttpMethod[] arrayOfEnumHttpMethod = __values;
      if (i >= arrayOfEnumHttpMethod.length) {
        break;
      }
      if (arrayOfEnumHttpMethod[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EnumHttpMethod convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EnumHttpMethod[] arrayOfEnumHttpMethod = __values;
      if (i >= arrayOfEnumHttpMethod.length) {
        break;
      }
      if (arrayOfEnumHttpMethod[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wns_proxy.EnumHttpMethod
 * JD-Core Version:    0.7.0.1
 */