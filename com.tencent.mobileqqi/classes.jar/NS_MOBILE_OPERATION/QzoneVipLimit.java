package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class QzoneVipLimit
  implements Serializable
{
  public static final int _enum_seal_qzonevip = 1;
  public static final int _enum_seal_super_qzonevip = 2;
  public static final int _enum_seal_ulimit = 0;
  private static QzoneVipLimit[] a;
  public static final QzoneVipLimit enum_seal_qzonevip;
  public static final QzoneVipLimit enum_seal_super_qzonevip;
  public static final QzoneVipLimit enum_seal_ulimit;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!QzoneVipLimit.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new QzoneVipLimit[3];
      enum_seal_ulimit = new QzoneVipLimit(0, 0, "enum_seal_ulimit");
      enum_seal_qzonevip = new QzoneVipLimit(1, 1, "enum_seal_qzonevip");
      enum_seal_super_qzonevip = new QzoneVipLimit(2, 2, "enum_seal_super_qzonevip");
      return;
    }
  }
  
  private QzoneVipLimit(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static QzoneVipLimit convert(int paramInt)
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
  
  public static QzoneVipLimit convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_OPERATION.QzoneVipLimit
 * JD-Core Version:    0.7.0.1
 */