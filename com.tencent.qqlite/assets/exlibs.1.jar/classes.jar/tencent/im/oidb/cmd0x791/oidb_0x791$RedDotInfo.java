package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x791$RedDotInfo
  extends MessageMicro
{
  public static final int BOOL_DISPLAY_REDDOT_FIELD_NUMBER = 2;
  public static final int UINT32_APPID_FIELD_NUMBER = 1;
  public static final int UINT32_LAST_TIME_FIELD_NUMBER = 5;
  public static final int UINT32_NUMBER_FIELD_NUMBER = 3;
  public static final int UINT32_REASON_FIELD_NUMBER = 4;
  public static final int UINT64_CMD_UIN_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_appid", "bool_display_reddot", "uint32_number", "uint32_reason", "uint32_last_time", "uint64_cmd_uin" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RedDotInfo.class);
  public final PBBoolField bool_display_reddot = PBField.initBool(false);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo
 * JD-Core Version:    0.7.0.1
 */