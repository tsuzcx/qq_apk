package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x787$Filter
  extends MessageMicro
{
  public static final int UINT32_DATA_TIME_FIELD_NUMBER = 7;
  public static final int UINT32_LEVEL_NAME_FIELD_NUMBER = 6;
  public static final int UINT32_MEMBER_LEVEL_INFO_ACTIVE_DAY_FIELD_NUMBER = 3;
  public static final int UINT32_MEMBER_LEVEL_INFO_LEVEL_FIELD_NUMBER = 4;
  public static final int UINT32_MEMBER_LEVEL_INFO_NAME_FIELD_NUMBER = 5;
  public static final int UINT32_MEMBER_LEVEL_INFO_POINT_FIELD_NUMBER = 2;
  public static final int UINT32_MEMBER_LEVEL_INFO_UIN_FIELD_NUMBER = 1;
  public static final int UINT32_SYS_SHOW_FLAG_FIELD_NUMBER = 9;
  public static final int UINT32_TIME_TO_UPDATE_FIELD_NUMBER = 10;
  public static final int UINT32_USER_SHOW_FLAG_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "uint32_member_level_info_uin", "uint32_member_level_info_point", "uint32_member_level_info_active_day", "uint32_member_level_info_level", "uint32_member_level_info_name", "uint32_level_name", "uint32_data_time", "uint32_user_show_flag", "uint32_sys_show_flag", "uint32_time_to_update" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Filter.class);
  public final PBUInt32Field uint32_data_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level_info_active_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level_info_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level_info_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level_info_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level_info_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_to_update = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787.Filter
 * JD-Core Version:    0.7.0.1
 */