package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class e_albumtype
  implements Serializable
{
  public static final e_albumtype ENUM_ALBUM_TYPE_MOBILE;
  public static final e_albumtype ENUM_ALBUM_TYPE_SECRET_TIETU;
  public static final e_albumtype ENUM_ALBUM_TYPE_TIETU;
  public static final int _ENUM_ALBUM_TYPE_MOBILE = 1;
  public static final int _ENUM_ALBUM_TYPE_SECRET_TIETU = 7;
  public static final int _ENUM_ALBUM_TYPE_TIETU = 2;
  private static e_albumtype[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_albumtype.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_albumtype[3];
      ENUM_ALBUM_TYPE_MOBILE = new e_albumtype(0, 1, "ENUM_ALBUM_TYPE_MOBILE");
      ENUM_ALBUM_TYPE_TIETU = new e_albumtype(1, 2, "ENUM_ALBUM_TYPE_TIETU");
      ENUM_ALBUM_TYPE_SECRET_TIETU = new e_albumtype(2, 7, "ENUM_ALBUM_TYPE_SECRET_TIETU");
      return;
    }
  }
  
  private e_albumtype(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_albumtype convert(int paramInt)
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
  
  public static e_albumtype convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_OPERATION.e_albumtype
 * JD-Core Version:    0.7.0.1
 */