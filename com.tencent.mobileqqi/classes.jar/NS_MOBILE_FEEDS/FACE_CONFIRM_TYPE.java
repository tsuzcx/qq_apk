package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class FACE_CONFIRM_TYPE
  implements Serializable
{
  public static final FACE_CONFIRM_TYPE FACE_CONFIRM_ALL;
  public static final FACE_CONFIRM_TYPE FACE_CONFIRM_CONFIRMED;
  public static final FACE_CONFIRM_TYPE FACE_CONFIRM_UNCONFIRM;
  public static final int _FACE_CONFIRM_ALL = 65535;
  public static final int _FACE_CONFIRM_CONFIRMED = 1;
  public static final int _FACE_CONFIRM_UNCONFIRM = 0;
  private static FACE_CONFIRM_TYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!FACE_CONFIRM_TYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new FACE_CONFIRM_TYPE[3];
      FACE_CONFIRM_ALL = new FACE_CONFIRM_TYPE(0, 65535, "FACE_CONFIRM_ALL");
      FACE_CONFIRM_UNCONFIRM = new FACE_CONFIRM_TYPE(1, 0, "FACE_CONFIRM_UNCONFIRM");
      FACE_CONFIRM_CONFIRMED = new FACE_CONFIRM_TYPE(2, 1, "FACE_CONFIRM_CONFIRMED");
      return;
    }
  }
  
  private FACE_CONFIRM_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static FACE_CONFIRM_TYPE convert(int paramInt)
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
  
  public static FACE_CONFIRM_TYPE convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.FACE_CONFIRM_TYPE
 * JD-Core Version:    0.7.0.1
 */