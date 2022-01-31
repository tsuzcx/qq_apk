package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$MemberInfo
  extends MessageMicro
{
  public static final int BOOL_IS_ALLOW_MOD_CARD_FIELD_NUMBER = 21;
  public static final int BOOL_IS_CONCERNED_FIELD_NUMBER = 6;
  public static final int BOOL_IS_FRIEND_FIELD_NUMBER = 4;
  public static final int BOOL_IS_SUPER_QQ_FIELD_NUMBER = 25;
  public static final int BOOL_IS_SUPER_VIP_FIELD_NUMBER = 24;
  public static final int BOOL_IS_VIP_FIELD_NUMBER = 22;
  public static final int BOOL_IS_YEAR_VIP_FIELD_NUMBER = 23;
  public static final int RPT_MSG_CUSTOM_ENTIES_FIELD_NUMBER = 16;
  public static final int RPT_MSG_GBAR_CONCERNED_FIELD_NUMBER = 17;
  public static final int STR_CARD_FIELD_NUMBER = 8;
  public static final int STR_ERRMSG_FIELD_NUMBER = 3;
  public static final int STR_GBAR_TITLE_FIELD_NUMBER = 18;
  public static final int STR_GBAR_URL_FIELD_NUMBER = 19;
  public static final int STR_LEV_FIELD_NUMBER = 13;
  public static final int STR_LOCATION_FIELD_NUMBER = 10;
  public static final int STR_NICK_FIELD_NUMBER = 11;
  public static final int STR_REMARK_FIELD_NUMBER = 5;
  public static final int UINT32_AGE_FIELD_NUMBER = 12;
  public static final int UINT32_CREDIT_FIELD_NUMBER = 7;
  public static final int UINT32_GBAR_CNT_FIELD_NUMBER = 20;
  public static final int UINT32_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_ROLE_FIELD_NUMBER = 27;
  public static final int UINT32_SEX_FIELD_NUMBER = 9;
  public static final int UINT32_VIP_LEV_FIELD_NUMBER = 26;
  public static final int UINT64_JOIN_FIELD_NUMBER = 14;
  public static final int UINT64_LAST_SPEAK_FIELD_NUMBER = 15;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_allow_mod_card = PBField.initBool(false);
  public final PBBoolField bool_is_concerned = PBField.initBool(false);
  public final PBBoolField bool_is_friend = PBField.initBool(false);
  public final PBBoolField bool_is_super_qq = PBField.initBool(false);
  public final PBBoolField bool_is_super_vip = PBField.initBool(false);
  public final PBBoolField bool_is_vip = PBField.initBool(false);
  public final PBBoolField bool_is_year_vip = PBField.initBool(false);
  public final PBRepeatMessageField rpt_msg_custom_enties = PBField.initRepeatMessage(group_member_info.CustomEntry.class);
  public final PBRepeatMessageField rpt_msg_gbar_concerned = PBField.initRepeatMessage(group_member_info.GBarInfo.class);
  public final PBBytesField str_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_gbar_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_gbar_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_lev = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_location = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_credit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gbar_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_role = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_lev = PBField.initUInt32(0);
  public final PBUInt64Field uint64_join = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_speak = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 72, 82, 90, 96, 106, 112, 120, 130, 138, 146, 154, 160, 168, 176, 184, 192, 200, 208, 216 }, new String[] { "uint64_uin", "uint32_result", "str_errmsg", "bool_is_friend", "str_remark", "bool_is_concerned", "uint32_credit", "str_card", "uint32_sex", "str_location", "str_nick", "uint32_age", "str_lev", "uint64_join", "uint64_last_speak", "rpt_msg_custom_enties", "rpt_msg_gbar_concerned", "str_gbar_title", "str_gbar_url", "uint32_gbar_cnt", "bool_is_allow_mod_card", "bool_is_vip", "bool_is_year_vip", "bool_is_super_vip", "bool_is_super_qq", "uint32_vip_lev", "uint32_role" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), localByteStringMicro2, Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, Long.valueOf(0L), Long.valueOf(0L), null, null, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, MemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.group.group_member_info.MemberInfo
 * JD-Core Version:    0.7.0.1
 */