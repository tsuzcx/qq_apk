package NS_UNDEAL_COUNT;

import java.io.Serializable;

public final class enum_visit_qzone_rsp_type
  implements Serializable
{
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_ACTIVE_COUNT;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_APP_COUNT;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_BAN_INFO;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_FRIEND_BIRTHDAY_COUNT;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_FRIEND_COUNT;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_MAIN_PAGE_COUNT;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_NICK_NAME;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_PASSIVE_COUNT;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_PHOTO_UPLOAD;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_SELF_BIRTH;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_VISITOR_COUNT;
  public static final enum_visit_qzone_rsp_type ENUM_VISIT_QZONE_TYPE_WNS_STATE;
  public static final int _ENUM_VISIT_QZONE_TYPE_ACTIVE_COUNT = 2;
  public static final int _ENUM_VISIT_QZONE_TYPE_APP_COUNT = 512;
  public static final int _ENUM_VISIT_QZONE_TYPE_BAN_INFO = 32;
  public static final int _ENUM_VISIT_QZONE_TYPE_FRIEND_BIRTHDAY_COUNT = 1024;
  public static final int _ENUM_VISIT_QZONE_TYPE_FRIEND_COUNT = 8;
  public static final int _ENUM_VISIT_QZONE_TYPE_MAIN_PAGE_COUNT = 2048;
  public static final int _ENUM_VISIT_QZONE_TYPE_NICK_NAME = 256;
  public static final int _ENUM_VISIT_QZONE_TYPE_PASSIVE_COUNT = 1;
  public static final int _ENUM_VISIT_QZONE_TYPE_PHOTO_UPLOAD = 128;
  public static final int _ENUM_VISIT_QZONE_TYPE_SELF_BIRTH = 16;
  public static final int _ENUM_VISIT_QZONE_TYPE_VISITOR_COUNT = 4;
  public static final int _ENUM_VISIT_QZONE_TYPE_WNS_STATE = 64;
  private static enum_visit_qzone_rsp_type[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_visit_qzone_rsp_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_visit_qzone_rsp_type[12];
      ENUM_VISIT_QZONE_TYPE_PASSIVE_COUNT = new enum_visit_qzone_rsp_type(0, 1, "ENUM_VISIT_QZONE_TYPE_PASSIVE_COUNT");
      ENUM_VISIT_QZONE_TYPE_ACTIVE_COUNT = new enum_visit_qzone_rsp_type(1, 2, "ENUM_VISIT_QZONE_TYPE_ACTIVE_COUNT");
      ENUM_VISIT_QZONE_TYPE_VISITOR_COUNT = new enum_visit_qzone_rsp_type(2, 4, "ENUM_VISIT_QZONE_TYPE_VISITOR_COUNT");
      ENUM_VISIT_QZONE_TYPE_FRIEND_COUNT = new enum_visit_qzone_rsp_type(3, 8, "ENUM_VISIT_QZONE_TYPE_FRIEND_COUNT");
      ENUM_VISIT_QZONE_TYPE_SELF_BIRTH = new enum_visit_qzone_rsp_type(4, 16, "ENUM_VISIT_QZONE_TYPE_SELF_BIRTH");
      ENUM_VISIT_QZONE_TYPE_BAN_INFO = new enum_visit_qzone_rsp_type(5, 32, "ENUM_VISIT_QZONE_TYPE_BAN_INFO");
      ENUM_VISIT_QZONE_TYPE_WNS_STATE = new enum_visit_qzone_rsp_type(6, 64, "ENUM_VISIT_QZONE_TYPE_WNS_STATE");
      ENUM_VISIT_QZONE_TYPE_PHOTO_UPLOAD = new enum_visit_qzone_rsp_type(7, 128, "ENUM_VISIT_QZONE_TYPE_PHOTO_UPLOAD");
      ENUM_VISIT_QZONE_TYPE_NICK_NAME = new enum_visit_qzone_rsp_type(8, 256, "ENUM_VISIT_QZONE_TYPE_NICK_NAME");
      ENUM_VISIT_QZONE_TYPE_APP_COUNT = new enum_visit_qzone_rsp_type(9, 512, "ENUM_VISIT_QZONE_TYPE_APP_COUNT");
      ENUM_VISIT_QZONE_TYPE_FRIEND_BIRTHDAY_COUNT = new enum_visit_qzone_rsp_type(10, 1024, "ENUM_VISIT_QZONE_TYPE_FRIEND_BIRTHDAY_COUNT");
      ENUM_VISIT_QZONE_TYPE_MAIN_PAGE_COUNT = new enum_visit_qzone_rsp_type(11, 2048, "ENUM_VISIT_QZONE_TYPE_MAIN_PAGE_COUNT");
      return;
    }
  }
  
  private enum_visit_qzone_rsp_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_visit_qzone_rsp_type convert(int paramInt)
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
  
  public static enum_visit_qzone_rsp_type convert(String paramString)
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
 * Qualified Name:     NS_UNDEAL_COUNT.enum_visit_qzone_rsp_type
 * JD-Core Version:    0.7.0.1
 */