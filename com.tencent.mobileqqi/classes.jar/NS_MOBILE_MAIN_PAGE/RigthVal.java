package NS_MOBILE_MAIN_PAGE;

import java.io.Serializable;

public final class RigthVal
  implements Serializable
{
  public static final RigthVal RIGHT2_MASK;
  public static final RigthVal RIGHT2_PASSWD;
  public static final RigthVal RIGHT2_SPECLIST;
  public static final RigthVal RIGHT_ALL_FRIEND;
  public static final RigthVal RIGHT_GROUP_FRIEND;
  public static final RigthVal RIGHT_MASK;
  public static final RigthVal RIGHT_PASSWD;
  public static final RigthVal RIGHT_PUBLIC;
  public static final RigthVal RIGHT_SELF;
  public static final RigthVal RIGHT_SPECLIST;
  public static final int _RIGHT2_MASK = 240;
  public static final int _RIGHT2_PASSWD = 32;
  public static final int _RIGHT2_SPECLIST = 16;
  public static final int _RIGHT_ALL_FRIEND = 1;
  public static final int _RIGHT_GROUP_FRIEND = 2;
  public static final int _RIGHT_MASK = 15;
  public static final int _RIGHT_PASSWD = 4;
  public static final int _RIGHT_PUBLIC = 0;
  public static final int _RIGHT_SELF = 5;
  public static final int _RIGHT_SPECLIST = 3;
  private static RigthVal[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!RigthVal.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new RigthVal[10];
      RIGHT_PUBLIC = new RigthVal(0, 0, "RIGHT_PUBLIC");
      RIGHT_ALL_FRIEND = new RigthVal(1, 1, "RIGHT_ALL_FRIEND");
      RIGHT_GROUP_FRIEND = new RigthVal(2, 2, "RIGHT_GROUP_FRIEND");
      RIGHT_SPECLIST = new RigthVal(3, 3, "RIGHT_SPECLIST");
      RIGHT_PASSWD = new RigthVal(4, 4, "RIGHT_PASSWD");
      RIGHT_SELF = new RigthVal(5, 5, "RIGHT_SELF");
      RIGHT_MASK = new RigthVal(6, 15, "RIGHT_MASK");
      RIGHT2_SPECLIST = new RigthVal(7, 16, "RIGHT2_SPECLIST");
      RIGHT2_PASSWD = new RigthVal(8, 32, "RIGHT2_PASSWD");
      RIGHT2_MASK = new RigthVal(9, 240, "RIGHT2_MASK");
      return;
    }
  }
  
  private RigthVal(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static RigthVal convert(int paramInt)
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
  
  public static RigthVal convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.RigthVal
 * JD-Core Version:    0.7.0.1
 */