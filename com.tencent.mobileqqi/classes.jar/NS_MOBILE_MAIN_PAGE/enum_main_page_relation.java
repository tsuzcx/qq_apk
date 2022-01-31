package NS_MOBILE_MAIN_PAGE;

import java.io.Serializable;

public final class enum_main_page_relation
  implements Serializable
{
  public static final int _enum_relation_creditlevel_low = 9;
  public static final int _enum_relation_friend_needanswer = 4;
  public static final int _enum_relation_friend_noregist = 7;
  public static final int _enum_relation_friend_notpass = 3;
  public static final int _enum_relation_friend_pass = 1;
  public static final int _enum_relation_notfriend_needanswer = 6;
  public static final int _enum_relation_notfriend_noregist = 8;
  public static final int _enum_relation_notfriend_notpass = 5;
  public static final int _enum_relation_notfriend_pass = 2;
  public static final int _enum_relation_self = 0;
  private static enum_main_page_relation[] a;
  public static final enum_main_page_relation enum_relation_creditlevel_low;
  public static final enum_main_page_relation enum_relation_friend_needanswer;
  public static final enum_main_page_relation enum_relation_friend_noregist;
  public static final enum_main_page_relation enum_relation_friend_notpass;
  public static final enum_main_page_relation enum_relation_friend_pass;
  public static final enum_main_page_relation enum_relation_notfriend_needanswer;
  public static final enum_main_page_relation enum_relation_notfriend_noregist;
  public static final enum_main_page_relation enum_relation_notfriend_notpass;
  public static final enum_main_page_relation enum_relation_notfriend_pass;
  public static final enum_main_page_relation enum_relation_self;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_main_page_relation.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_main_page_relation[10];
      enum_relation_self = new enum_main_page_relation(0, 0, "enum_relation_self");
      enum_relation_friend_pass = new enum_main_page_relation(1, 1, "enum_relation_friend_pass");
      enum_relation_notfriend_pass = new enum_main_page_relation(2, 2, "enum_relation_notfriend_pass");
      enum_relation_friend_notpass = new enum_main_page_relation(3, 3, "enum_relation_friend_notpass");
      enum_relation_friend_needanswer = new enum_main_page_relation(4, 4, "enum_relation_friend_needanswer");
      enum_relation_notfriend_notpass = new enum_main_page_relation(5, 5, "enum_relation_notfriend_notpass");
      enum_relation_notfriend_needanswer = new enum_main_page_relation(6, 6, "enum_relation_notfriend_needanswer");
      enum_relation_friend_noregist = new enum_main_page_relation(7, 7, "enum_relation_friend_noregist");
      enum_relation_notfriend_noregist = new enum_main_page_relation(8, 8, "enum_relation_notfriend_noregist");
      enum_relation_creditlevel_low = new enum_main_page_relation(9, 9, "enum_relation_creditlevel_low");
      return;
    }
  }
  
  private enum_main_page_relation(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_main_page_relation convert(int paramInt)
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
  
  public static enum_main_page_relation convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.enum_main_page_relation
 * JD-Core Version:    0.7.0.1
 */