package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class enum_mobile_operation_define
  implements Serializable
{
  public static final int _enum_operation_add_favour = 14;
  public static final int _enum_operation_addcomment = 2;
  public static final int _enum_operation_del_favour = 15;
  public static final int _enum_operation_delcomment = 11;
  public static final int _enum_operation_delreply = 10;
  public static final int _enum_operation_getsealdetail = 18;
  public static final int _enum_operation_getsealgroup = 17;
  public static final int _enum_operation_getsignininfo = 9;
  public static final int _enum_operation_getsigninseal = 12;
  public static final int _enum_operation_publishblog = 7;
  public static final int _enum_operation_publishmood = 5;
  public static final int _enum_operation_publishsignin = 8;
  public static final int _enum_operation_publishsigninv4 = 13;
  public static final int _enum_operation_upd_favour = 16;
  public static final int _enum_operetion_addreply = 3;
  public static final int _enum_operetion_delugc = 4;
  public static final int _enum_operetion_forward = 1;
  public static final int _enum_operetion_like = 0;
  public static final int _enum_operetion_publishmessage = 6;
  private static enum_mobile_operation_define[] a;
  public static final enum_mobile_operation_define enum_operation_add_favour;
  public static final enum_mobile_operation_define enum_operation_addcomment;
  public static final enum_mobile_operation_define enum_operation_del_favour;
  public static final enum_mobile_operation_define enum_operation_delcomment;
  public static final enum_mobile_operation_define enum_operation_delreply;
  public static final enum_mobile_operation_define enum_operation_getsealdetail;
  public static final enum_mobile_operation_define enum_operation_getsealgroup;
  public static final enum_mobile_operation_define enum_operation_getsignininfo;
  public static final enum_mobile_operation_define enum_operation_getsigninseal;
  public static final enum_mobile_operation_define enum_operation_publishblog;
  public static final enum_mobile_operation_define enum_operation_publishmood;
  public static final enum_mobile_operation_define enum_operation_publishsignin;
  public static final enum_mobile_operation_define enum_operation_publishsigninv4;
  public static final enum_mobile_operation_define enum_operation_upd_favour;
  public static final enum_mobile_operation_define enum_operetion_addreply;
  public static final enum_mobile_operation_define enum_operetion_delugc;
  public static final enum_mobile_operation_define enum_operetion_forward;
  public static final enum_mobile_operation_define enum_operetion_like;
  public static final enum_mobile_operation_define enum_operetion_publishmessage;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_mobile_operation_define.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_mobile_operation_define[19];
      enum_operetion_like = new enum_mobile_operation_define(0, 0, "enum_operetion_like");
      enum_operetion_forward = new enum_mobile_operation_define(1, 1, "enum_operetion_forward");
      enum_operation_addcomment = new enum_mobile_operation_define(2, 2, "enum_operation_addcomment");
      enum_operetion_addreply = new enum_mobile_operation_define(3, 3, "enum_operetion_addreply");
      enum_operetion_delugc = new enum_mobile_operation_define(4, 4, "enum_operetion_delugc");
      enum_operation_publishmood = new enum_mobile_operation_define(5, 5, "enum_operation_publishmood");
      enum_operetion_publishmessage = new enum_mobile_operation_define(6, 6, "enum_operetion_publishmessage");
      enum_operation_publishblog = new enum_mobile_operation_define(7, 7, "enum_operation_publishblog");
      enum_operation_publishsignin = new enum_mobile_operation_define(8, 8, "enum_operation_publishsignin");
      enum_operation_getsignininfo = new enum_mobile_operation_define(9, 9, "enum_operation_getsignininfo");
      enum_operation_delreply = new enum_mobile_operation_define(10, 10, "enum_operation_delreply");
      enum_operation_delcomment = new enum_mobile_operation_define(11, 11, "enum_operation_delcomment");
      enum_operation_getsigninseal = new enum_mobile_operation_define(12, 12, "enum_operation_getsigninseal");
      enum_operation_publishsigninv4 = new enum_mobile_operation_define(13, 13, "enum_operation_publishsigninv4");
      enum_operation_add_favour = new enum_mobile_operation_define(14, 14, "enum_operation_add_favour");
      enum_operation_del_favour = new enum_mobile_operation_define(15, 15, "enum_operation_del_favour");
      enum_operation_upd_favour = new enum_mobile_operation_define(16, 16, "enum_operation_upd_favour");
      enum_operation_getsealgroup = new enum_mobile_operation_define(17, 17, "enum_operation_getsealgroup");
      enum_operation_getsealdetail = new enum_mobile_operation_define(18, 18, "enum_operation_getsealdetail");
      return;
    }
  }
  
  private enum_mobile_operation_define(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_mobile_operation_define convert(int paramInt)
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
  
  public static enum_mobile_operation_define convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_OPERATION.enum_mobile_operation_define
 * JD-Core Version:    0.7.0.1
 */