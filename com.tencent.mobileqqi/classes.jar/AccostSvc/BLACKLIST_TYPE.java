package AccostSvc;

import java.io.Serializable;

public final class BLACKLIST_TYPE
  implements Serializable
{
  public static final BLACKLIST_TYPE BL_ALL;
  public static final BLACKLIST_TYPE BL_CONTACT;
  public static final BLACKLIST_TYPE BL_NEIGHBOUR;
  public static final int _BL_ALL = 2;
  public static final int _BL_CONTACT = 1;
  public static final int _BL_NEIGHBOUR = 0;
  private static BLACKLIST_TYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!BLACKLIST_TYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new BLACKLIST_TYPE[3];
      BL_NEIGHBOUR = new BLACKLIST_TYPE(0, 0, "BL_NEIGHBOUR");
      BL_CONTACT = new BLACKLIST_TYPE(1, 1, "BL_CONTACT");
      BL_ALL = new BLACKLIST_TYPE(2, 2, "BL_ALL");
      return;
    }
  }
  
  private BLACKLIST_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static BLACKLIST_TYPE convert(int paramInt)
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
  
  public static BLACKLIST_TYPE convert(String paramString)
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
 * Qualified Name:     AccostSvc.BLACKLIST_TYPE
 * JD-Core Version:    0.7.0.1
 */