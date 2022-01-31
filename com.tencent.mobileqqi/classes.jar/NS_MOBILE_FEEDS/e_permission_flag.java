package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_permission_flag
  implements Serializable
{
  public static final int _enum_permission_delete = 1;
  private static e_permission_flag[] a;
  public static final e_permission_flag enum_permission_delete;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_permission_flag.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_permission_flag[1];
      enum_permission_delete = new e_permission_flag(0, 1, "enum_permission_delete");
      return;
    }
  }
  
  private e_permission_flag(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_permission_flag convert(int paramInt)
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
  
  public static e_permission_flag convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.e_permission_flag
 * JD-Core Version:    0.7.0.1
 */