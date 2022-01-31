package NS_UNDEAL_COUNT;

import java.io.Serializable;

public final class enum_visit_qzone_type
  implements Serializable
{
  public static final enum_visit_qzone_type ENUM_VISIT_QZONE_TYPE_HOME_BACK;
  public static final enum_visit_qzone_type ENUM_VISIT_QZONE_TYPE_INIT_APP;
  public static final enum_visit_qzone_type ENUM_VISIT_QZONE_TYPE_TIMER_GET;
  public static final int _ENUM_VISIT_QZONE_TYPE_HOME_BACK = 2;
  public static final int _ENUM_VISIT_QZONE_TYPE_INIT_APP = 1;
  public static final int _ENUM_VISIT_QZONE_TYPE_TIMER_GET = 3;
  private static enum_visit_qzone_type[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_visit_qzone_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_visit_qzone_type[3];
      ENUM_VISIT_QZONE_TYPE_INIT_APP = new enum_visit_qzone_type(0, 1, "ENUM_VISIT_QZONE_TYPE_INIT_APP");
      ENUM_VISIT_QZONE_TYPE_HOME_BACK = new enum_visit_qzone_type(1, 2, "ENUM_VISIT_QZONE_TYPE_HOME_BACK");
      ENUM_VISIT_QZONE_TYPE_TIMER_GET = new enum_visit_qzone_type(2, 3, "ENUM_VISIT_QZONE_TYPE_TIMER_GET");
      return;
    }
  }
  
  private enum_visit_qzone_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_visit_qzone_type convert(int paramInt)
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
  
  public static enum_visit_qzone_type convert(String paramString)
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
 * Qualified Name:     NS_UNDEAL_COUNT.enum_visit_qzone_type
 * JD-Core Version:    0.7.0.1
 */