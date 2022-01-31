package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_shake_type
  implements Serializable
{
  public static final e_shake_type AppList;
  public static final e_shake_type Detial;
  public static final e_shake_type HomePage;
  public static final e_shake_type PhotoView;
  public static final e_shake_type Web;
  public static final int _AppList = 1;
  public static final int _Detial = 0;
  public static final int _HomePage = 3;
  public static final int _PhotoView = 2;
  public static final int _Web = 4;
  private static e_shake_type[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_shake_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_shake_type[5];
      Detial = new e_shake_type(0, 0, "Detial");
      AppList = new e_shake_type(1, 1, "AppList");
      PhotoView = new e_shake_type(2, 2, "PhotoView");
      HomePage = new e_shake_type(3, 3, "HomePage");
      Web = new e_shake_type(4, 4, "Web");
      return;
    }
  }
  
  private e_shake_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_shake_type convert(int paramInt)
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
  
  public static e_shake_type convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.e_shake_type
 * JD-Core Version:    0.7.0.1
 */