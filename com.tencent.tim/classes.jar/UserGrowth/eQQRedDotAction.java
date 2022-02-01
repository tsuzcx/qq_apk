package UserGrowth;

import java.io.Serializable;

public final class eQQRedDotAction
  implements Serializable
{
  private static eQQRedDotAction[] __values;
  public static final int _eQQRedDotActionExpose = 2;
  public static final int _eQQRedDotActionRequest = 1;
  public static final eQQRedDotAction eQQRedDotActionExpose;
  public static final eQQRedDotAction eQQRedDotActionRequest;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eQQRedDotAction.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eQQRedDotAction[2];
      eQQRedDotActionRequest = new eQQRedDotAction(0, 1, "eQQRedDotActionRequest");
      eQQRedDotActionExpose = new eQQRedDotAction(1, 2, "eQQRedDotActionExpose");
      return;
    }
  }
  
  private eQQRedDotAction(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eQQRedDotAction convert(int paramInt)
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
  
  public static eQQRedDotAction convert(String paramString)
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
 * Qualified Name:     UserGrowth.eQQRedDotAction
 * JD-Core Version:    0.7.0.1
 */