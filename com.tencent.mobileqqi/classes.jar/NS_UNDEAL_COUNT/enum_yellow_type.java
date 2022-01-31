package NS_UNDEAL_COUNT;

import java.io.Serializable;

public final class enum_yellow_type
  implements Serializable
{
  public static final enum_yellow_type ENUM_COMM_USER;
  public static final enum_yellow_type ENUM_HIGH_YELLOW_USER;
  public static final enum_yellow_type ENUM_YELLOW_USER;
  public static final int _ENUM_COMM_USER = 0;
  public static final int _ENUM_HIGH_YELLOW_USER = 2;
  public static final int _ENUM_YELLOW_USER = 1;
  private static enum_yellow_type[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_yellow_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_yellow_type[3];
      ENUM_COMM_USER = new enum_yellow_type(0, 0, "ENUM_COMM_USER");
      ENUM_YELLOW_USER = new enum_yellow_type(1, 1, "ENUM_YELLOW_USER");
      ENUM_HIGH_YELLOW_USER = new enum_yellow_type(2, 2, "ENUM_HIGH_YELLOW_USER");
      return;
    }
  }
  
  private enum_yellow_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_yellow_type convert(int paramInt)
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
  
  public static enum_yellow_type convert(String paramString)
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
 * Qualified Name:     NS_UNDEAL_COUNT.enum_yellow_type
 * JD-Core Version:    0.7.0.1
 */