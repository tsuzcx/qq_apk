package SLICE_UPLOAD;

import java.io.Serializable;

public final class CheckType
  implements Serializable
{
  public static final CheckType TYPE_MD5;
  public static final CheckType TYPE_NONE;
  public static final CheckType TYPE_SHA1;
  public static final int _TYPE_MD5 = 0;
  public static final int _TYPE_NONE = 2;
  public static final int _TYPE_SHA1 = 1;
  private static CheckType[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CheckType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new CheckType[3];
      TYPE_MD5 = new CheckType(0, 0, "TYPE_MD5");
      TYPE_SHA1 = new CheckType(1, 1, "TYPE_SHA1");
      TYPE_NONE = new CheckType(2, 2, "TYPE_NONE");
      return;
    }
  }
  
  private CheckType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static CheckType convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static CheckType convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SLICE_UPLOAD.CheckType
 * JD-Core Version:    0.7.0.1
 */