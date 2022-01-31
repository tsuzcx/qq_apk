package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_gift_url
  implements Serializable
{
  public static final int _enum_audio_background = 4;
  public static final int _enum_audio_url = 3;
  public static final int _enum_gift_url_big = 2;
  public static final int _enum_gift_url_small = 1;
  private static e_gift_url[] a;
  public static final e_gift_url enum_audio_background;
  public static final e_gift_url enum_audio_url;
  public static final e_gift_url enum_gift_url_big;
  public static final e_gift_url enum_gift_url_small;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_gift_url.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_gift_url[4];
      enum_gift_url_small = new e_gift_url(0, 1, "enum_gift_url_small");
      enum_gift_url_big = new e_gift_url(1, 2, "enum_gift_url_big");
      enum_audio_url = new e_gift_url(2, 3, "enum_audio_url");
      enum_audio_background = new e_gift_url(3, 4, "enum_audio_background");
      return;
    }
  }
  
  private e_gift_url(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_gift_url convert(int paramInt)
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
  
  public static e_gift_url convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.e_gift_url
 * JD-Core Version:    0.7.0.1
 */