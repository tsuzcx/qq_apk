package NS_MOBILE_TEMPLATE_GIFT;

import java.io.Serializable;

public final class enum_get_type_list_category
  implements Serializable
{
  public static final int _enum_get_all_type_list = 2;
  public static final int _enum_get_common_type_list = 1;
  public static final int _enum_get_diy_type_list = 0;
  private static enum_get_type_list_category[] a;
  public static final enum_get_type_list_category enum_get_all_type_list;
  public static final enum_get_type_list_category enum_get_common_type_list;
  public static final enum_get_type_list_category enum_get_diy_type_list;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_get_type_list_category.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_get_type_list_category[3];
      enum_get_diy_type_list = new enum_get_type_list_category(0, 0, "enum_get_diy_type_list");
      enum_get_common_type_list = new enum_get_type_list_category(1, 1, "enum_get_common_type_list");
      enum_get_all_type_list = new enum_get_type_list_category(2, 2, "enum_get_all_type_list");
      return;
    }
  }
  
  private enum_get_type_list_category(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_get_type_list_category convert(int paramInt)
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
  
  public static enum_get_type_list_category convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.enum_get_type_list_category
 * JD-Core Version:    0.7.0.1
 */