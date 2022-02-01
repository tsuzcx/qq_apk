package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class enum_mood_modify_define
  implements Serializable
{
  private static enum_mood_modify_define[] __values;
  public static final int _enum_modify_content = 1;
  public static final int _enum_modify_ugcright = 2;
  public static final enum_mood_modify_define enum_modify_content;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_mood_modify_define.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new enum_mood_modify_define[1];
      enum_modify_content = new enum_mood_modify_define(0, 1, "enum_modify_content");
      return;
    }
  }
  
  private enum_mood_modify_define(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static enum_mood_modify_define convert(int paramInt)
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
  
  public static enum_mood_modify_define convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_OPERATION.enum_mood_modify_define
 * JD-Core Version:    0.7.0.1
 */