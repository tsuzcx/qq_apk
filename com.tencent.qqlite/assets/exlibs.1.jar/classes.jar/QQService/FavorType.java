package QQService;

import java.io.Serializable;

public final class FavorType
  implements Serializable
{
  public static final FavorType FAVOR_TYPE_FAVORITE;
  public static final FavorType FAVOR_TYPE_UNFAVORITE;
  public static final int _FAVOR_TYPE_FAVORITE = 0;
  public static final int _FAVOR_TYPE_UNFAVORITE = 1;
  private static FavorType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!FavorType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new FavorType[2];
      FAVOR_TYPE_FAVORITE = new FavorType(0, 0, "FAVOR_TYPE_FAVORITE");
      FAVOR_TYPE_UNFAVORITE = new FavorType(1, 1, "FAVOR_TYPE_UNFAVORITE");
      return;
    }
  }
  
  private FavorType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static FavorType convert(int paramInt)
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
  
  public static FavorType convert(String paramString)
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
 * Qualified Name:     QQService.FavorType
 * JD-Core Version:    0.7.0.1
 */