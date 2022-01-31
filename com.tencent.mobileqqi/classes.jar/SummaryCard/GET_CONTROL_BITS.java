package SummaryCard;

import java.io.Serializable;

public final class GET_CONTROL_BITS
  implements Serializable
{
  public static final GET_CONTROL_BITS FEEDS_FROM_QZONE;
  public static final GET_CONTROL_BITS FILTER_OUT_400;
  public static final GET_CONTROL_BITS GET_ACCELERATION;
  public static final GET_CONTROL_BITS GET_DIAMONDS;
  public static final GET_CONTROL_BITS GET_ENTERPRISE_FLAG;
  public static final GET_CONTROL_BITS GET_LOGIN_DAYS;
  public static final GET_CONTROL_BITS GET_MUSIC_GENE;
  public static final GET_CONTROL_BITS GET_RICH_SIGN;
  public static final GET_CONTROL_BITS GET_SHOW_NAME;
  public static final GET_CONTROL_BITS GET_STAR;
  public static final GET_CONTROL_BITS GET_TEMPLATE_ID;
  public static final GET_CONTROL_BITS GET_VOICE_CARD;
  public static final int _FEEDS_FROM_QZONE = 2048;
  public static final int _FILTER_OUT_400 = 64;
  public static final int _GET_ACCELERATION = 1024;
  public static final int _GET_DIAMONDS = 512;
  public static final int _GET_ENTERPRISE_FLAG = 8;
  public static final int _GET_LOGIN_DAYS = 16;
  public static final int _GET_MUSIC_GENE = 128;
  public static final int _GET_RICH_SIGN = 4;
  public static final int _GET_SHOW_NAME = 1;
  public static final int _GET_STAR = 256;
  public static final int _GET_TEMPLATE_ID = 32;
  public static final int _GET_VOICE_CARD = 2;
  private static GET_CONTROL_BITS[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!GET_CONTROL_BITS.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new GET_CONTROL_BITS[12];
      GET_SHOW_NAME = new GET_CONTROL_BITS(0, 1, "GET_SHOW_NAME");
      GET_VOICE_CARD = new GET_CONTROL_BITS(1, 2, "GET_VOICE_CARD");
      GET_RICH_SIGN = new GET_CONTROL_BITS(2, 4, "GET_RICH_SIGN");
      GET_ENTERPRISE_FLAG = new GET_CONTROL_BITS(3, 8, "GET_ENTERPRISE_FLAG");
      GET_LOGIN_DAYS = new GET_CONTROL_BITS(4, 16, "GET_LOGIN_DAYS");
      GET_TEMPLATE_ID = new GET_CONTROL_BITS(5, 32, "GET_TEMPLATE_ID");
      FILTER_OUT_400 = new GET_CONTROL_BITS(6, 64, "FILTER_OUT_400");
      GET_MUSIC_GENE = new GET_CONTROL_BITS(7, 128, "GET_MUSIC_GENE");
      GET_STAR = new GET_CONTROL_BITS(8, 256, "GET_STAR");
      GET_DIAMONDS = new GET_CONTROL_BITS(9, 512, "GET_DIAMONDS");
      GET_ACCELERATION = new GET_CONTROL_BITS(10, 1024, "GET_ACCELERATION");
      FEEDS_FROM_QZONE = new GET_CONTROL_BITS(11, 2048, "FEEDS_FROM_QZONE");
      return;
    }
  }
  
  private GET_CONTROL_BITS(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static GET_CONTROL_BITS convert(int paramInt)
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
  
  public static GET_CONTROL_BITS convert(String paramString)
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
 * Qualified Name:     SummaryCard.GET_CONTROL_BITS
 * JD-Core Version:    0.7.0.1
 */