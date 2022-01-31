package QQService;

import java.io.Serializable;

public final class TransType
  implements Serializable
{
  public static final TransType TransType_C2CPic;
  public static final TransType TransType_File;
  public static final TransType TransType_Pic;
  public static final int _TransType_C2CPic = 3;
  public static final int _TransType_File = 1;
  public static final int _TransType_Pic = 2;
  private static TransType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!TransType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new TransType[3];
      TransType_File = new TransType(0, 1, "TransType_File");
      TransType_Pic = new TransType(1, 2, "TransType_Pic");
      TransType_C2CPic = new TransType(2, 3, "TransType_C2CPic");
      return;
    }
  }
  
  private TransType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static TransType convert(int paramInt)
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
  
  public static TransType convert(String paramString)
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
 * Qualified Name:     QQService.TransType
 * JD-Core Version:    0.7.0.1
 */