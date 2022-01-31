package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x899$memberlist
  extends MessageMicro
{
  public static final int UINT32_JOIN_TIME_FIELD_NUMBER = 6;
  public static final int UINT32_LAST_SPEAK_TIME_FIELD_NUMBER = 9;
  public static final int UINT32_LEVEL_FIELD_NUMBER = 10;
  public static final int UINT32_NEW_MSG_SEQ_FIELD_NUMBER = 8;
  public static final int UINT32_OLD_MSG_SEQ_FIELD_NUMBER = 7;
  public static final int UINT32_POINT_FIELD_NUMBER = 11;
  public static final int UINT32_SHUTUP_TIMESTAP_FIELD_NUMBER = 12;
  public static final int UINT32_UIN_ARCH_FLAG_FIELD_NUMBER = 5;
  public static final int UINT32_UIN_FLAGEX_FIELD_NUMBER = 3;
  public static final int UINT32_UIN_FLAG_FIELD_NUMBER = 2;
  public static final int UINT32_UIN_MOBILE_FLAG_FIELD_NUMBER = 4;
  public static final int UINT64_MEMBER_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96 }, new String[] { "uint64_member_uin", "uint32_uin_flag", "uint32_uin_flagex", "uint32_uin_mobile_flag", "uint32_uin_arch_flag", "uint32_join_time", "uint32_old_msg_seq", "uint32_new_msg_seq", "uint32_last_speak_time", "uint32_level", "uint32_point", "uint32_shutup_timestap" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, memberlist.class);
  public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_speak_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_old_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_timestap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_arch_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_flagex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_mobile_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x899.oidb_0x899.memberlist
 * JD-Core Version:    0.7.0.1
 */