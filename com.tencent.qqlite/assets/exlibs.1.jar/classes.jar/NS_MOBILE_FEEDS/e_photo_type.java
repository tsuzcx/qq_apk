package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_photo_type
  implements Serializable
{
  public static final e_photo_type PhotoTypeGIF;
  public static final e_photo_type PhotoTypeJPG;
  public static final e_photo_type PhotoTypePNG;
  public static final e_photo_type PhotoTypeVideo;
  public static final int _PhotoTypeGIF = 2;
  public static final int _PhotoTypeJPG = 1;
  public static final int _PhotoTypePNG = 3;
  public static final int _PhotoTypeVideo = 1000;
  private static e_photo_type[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_photo_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_photo_type[4];
      PhotoTypeJPG = new e_photo_type(0, 1, "PhotoTypeJPG");
      PhotoTypeGIF = new e_photo_type(1, 2, "PhotoTypeGIF");
      PhotoTypePNG = new e_photo_type(2, 3, "PhotoTypePNG");
      PhotoTypeVideo = new e_photo_type(3, 1000, "PhotoTypeVideo");
      return;
    }
  }
  
  private e_photo_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_photo_type convert(int paramInt)
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
  
  public static e_photo_type convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.e_photo_type
 * JD-Core Version:    0.7.0.1
 */