package NS_MOBILE_PHOTO;

import java.io.Serializable;

public final class enum_album_limit_define
  implements Serializable
{
  public static final int _enum_all_person = 1;
  public static final int _enum_answer = 2;
  public static final int _enum_answer_question = 5;
  public static final int _enum_friend_only = 4;
  public static final int _enum_friend_some = 6;
  public static final int _enum_limit_end = 7;
  public static final int _enum_limit_start = 0;
  public static final int _enum_master_only = 3;
  private static enum_album_limit_define[] a;
  public static final enum_album_limit_define enum_all_person;
  public static final enum_album_limit_define enum_answer;
  public static final enum_album_limit_define enum_answer_question;
  public static final enum_album_limit_define enum_friend_only;
  public static final enum_album_limit_define enum_friend_some;
  public static final enum_album_limit_define enum_limit_end;
  public static final enum_album_limit_define enum_limit_start;
  public static final enum_album_limit_define enum_master_only;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_album_limit_define.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_album_limit_define[8];
      enum_limit_start = new enum_album_limit_define(0, 0, "enum_limit_start");
      enum_all_person = new enum_album_limit_define(1, 1, "enum_all_person");
      enum_answer = new enum_album_limit_define(2, 2, "enum_answer");
      enum_master_only = new enum_album_limit_define(3, 3, "enum_master_only");
      enum_friend_only = new enum_album_limit_define(4, 4, "enum_friend_only");
      enum_answer_question = new enum_album_limit_define(5, 5, "enum_answer_question");
      enum_friend_some = new enum_album_limit_define(6, 6, "enum_friend_some");
      enum_limit_end = new enum_album_limit_define(7, 7, "enum_limit_end");
      return;
    }
  }
  
  private enum_album_limit_define(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_album_limit_define convert(int paramInt)
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
  
  public static enum_album_limit_define convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_PHOTO.enum_album_limit_define
 * JD-Core Version:    0.7.0.1
 */