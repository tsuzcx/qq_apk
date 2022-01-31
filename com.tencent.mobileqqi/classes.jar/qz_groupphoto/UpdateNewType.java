package qz_groupphoto;

import java.io.Serializable;

public final class UpdateNewType
  implements Serializable
{
  public static final UpdateNewType ADDCNT;
  public static final UpdateNewType GROUPLASTTIME;
  public static final UpdateNewType PASSCNT;
  public static final UpdateNewType REDUCECNT;
  public static final UpdateNewType USERGROUPTIME;
  public static final int _ADDCNT = 3;
  public static final int _GROUPLASTTIME = 0;
  public static final int _PASSCNT = 2;
  public static final int _REDUCECNT = 4;
  public static final int _USERGROUPTIME = 1;
  private static UpdateNewType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!UpdateNewType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new UpdateNewType[5];
      GROUPLASTTIME = new UpdateNewType(0, 0, "GROUPLASTTIME");
      USERGROUPTIME = new UpdateNewType(1, 1, "USERGROUPTIME");
      PASSCNT = new UpdateNewType(2, 2, "PASSCNT");
      ADDCNT = new UpdateNewType(3, 3, "ADDCNT");
      REDUCECNT = new UpdateNewType(4, 4, "REDUCECNT");
      return;
    }
  }
  
  private UpdateNewType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static UpdateNewType convert(int paramInt)
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
  
  public static UpdateNewType convert(String paramString)
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
 * Qualified Name:     qz_groupphoto.UpdateNewType
 * JD-Core Version:    0.7.0.1
 */