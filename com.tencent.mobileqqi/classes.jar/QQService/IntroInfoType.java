package QQService;

import java.io.Serializable;

public final class IntroInfoType
  implements Serializable
{
  public static final IntroInfoType IntroInfoType_Audio;
  public static final IntroInfoType IntroInfoType_Pic;
  public static final IntroInfoType IntroInfoType_Tags;
  public static final IntroInfoType IntroInfoType_Words;
  public static final int _IntroInfoType_Audio = 2;
  public static final int _IntroInfoType_Pic = 3;
  public static final int _IntroInfoType_Tags = 4;
  public static final int _IntroInfoType_Words = 1;
  private static IntroInfoType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!IntroInfoType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new IntroInfoType[4];
      IntroInfoType_Words = new IntroInfoType(0, 1, "IntroInfoType_Words");
      IntroInfoType_Audio = new IntroInfoType(1, 2, "IntroInfoType_Audio");
      IntroInfoType_Pic = new IntroInfoType(2, 3, "IntroInfoType_Pic");
      IntroInfoType_Tags = new IntroInfoType(3, 4, "IntroInfoType_Tags");
      return;
    }
  }
  
  private IntroInfoType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static IntroInfoType convert(int paramInt)
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
  
  public static IntroInfoType convert(String paramString)
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
 * Qualified Name:     QQService.IntroInfoType
 * JD-Core Version:    0.7.0.1
 */