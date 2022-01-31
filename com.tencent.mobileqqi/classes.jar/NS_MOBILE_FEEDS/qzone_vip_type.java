package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class qzone_vip_type
  implements Serializable
{
  public static final int _enum_hight_qzone_vip = 1;
  public static final int _enum_normal_qzone_vip = 0;
  private static qzone_vip_type[] a;
  public static final qzone_vip_type enum_hight_qzone_vip;
  public static final qzone_vip_type enum_normal_qzone_vip;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!qzone_vip_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new qzone_vip_type[2];
      enum_normal_qzone_vip = new qzone_vip_type(0, 0, "enum_normal_qzone_vip");
      enum_hight_qzone_vip = new qzone_vip_type(1, 1, "enum_hight_qzone_vip");
      return;
    }
  }
  
  private qzone_vip_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static qzone_vip_type convert(int paramInt)
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
  
  public static qzone_vip_type convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.qzone_vip_type
 * JD-Core Version:    0.7.0.1
 */