package ResPackage;

import java.io.Serializable;

public final class OPTYPE
  implements Serializable
{
  public static final OPTYPE OP_ADD;
  public static final OPTYPE OP_DEL;
  public static final OPTYPE OP_INIT;
  public static final OPTYPE OP_REPLACE;
  public static final OPTYPE OP_SELECT;
  public static final OPTYPE OP_UPDATE;
  public static final int _OP_ADD = 1;
  public static final int _OP_DEL = 2;
  public static final int _OP_INIT = 0;
  public static final int _OP_REPLACE = 4;
  public static final int _OP_SELECT = 5;
  public static final int _OP_UPDATE = 3;
  private static OPTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!OPTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new OPTYPE[6];
      OP_INIT = new OPTYPE(0, 0, "OP_INIT");
      OP_ADD = new OPTYPE(1, 1, "OP_ADD");
      OP_DEL = new OPTYPE(2, 2, "OP_DEL");
      OP_UPDATE = new OPTYPE(3, 3, "OP_UPDATE");
      OP_REPLACE = new OPTYPE(4, 4, "OP_REPLACE");
      OP_SELECT = new OPTYPE(5, 5, "OP_SELECT");
      return;
    }
  }
  
  private OPTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static OPTYPE convert(int paramInt)
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
  
  public static OPTYPE convert(String paramString)
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
 * Qualified Name:     ResPackage.OPTYPE
 * JD-Core Version:    0.7.0.1
 */