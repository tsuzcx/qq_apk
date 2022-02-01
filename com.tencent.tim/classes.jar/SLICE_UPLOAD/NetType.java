package SLICE_UPLOAD;

import java.io.Serializable;

public final class NetType
  implements Serializable
{
  public static final NetType NET_2G;
  public static final NetType NET_3G;
  public static final NetType NET_4G;
  public static final NetType NET_ETHERNET;
  public static final NetType NET_UNKOWN;
  public static final NetType NET_WIFI;
  public static final int _NET_2G = 2;
  public static final int _NET_3G = 3;
  public static final int _NET_4G = 4;
  public static final int _NET_ETHERNET = 5;
  public static final int _NET_UNKOWN = 0;
  public static final int _NET_WIFI = 1;
  private static NetType[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!NetType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new NetType[6];
      NET_UNKOWN = new NetType(0, 0, "NET_UNKOWN");
      NET_WIFI = new NetType(1, 1, "NET_WIFI");
      NET_2G = new NetType(2, 2, "NET_2G");
      NET_3G = new NetType(3, 3, "NET_3G");
      NET_4G = new NetType(4, 4, "NET_4G");
      NET_ETHERNET = new NetType(5, 5, "NET_ETHERNET");
      return;
    }
  }
  
  private NetType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static NetType convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static NetType convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
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
 * Qualified Name:     SLICE_UPLOAD.NetType
 * JD-Core Version:    0.7.0.1
 */