package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class C2CType0x211_SubC2CType0x8$JudgeResult
  extends MessageMicro
{
  public static final int INT32_IDLE_TIMEOUT_FIELD_NUMBER = 4;
  public static final int STR_SSID_FIELD_NUMBER = 2;
  public static final int STR_TIPS_FIELD_NUMBER = 3;
  public static final int TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_FLAGS_NETCHECK_FIELD_NUMBER = 8;
  public static final int UINT32_FLAGS_WIFIPSW_FIELD_NUMBER = 7;
  public static final int UINT32_FORCE_WIFI_FIELD_NUMBER = 6;
  public static final int UINT32_IDLE_WAITING_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64 }, new String[] { "type", "str_ssid", "str_tips", "int32_idle_timeout", "uint32_idle_waiting", "uint32_force_wifi", "uint32_flags_wifipsw", "uint32_flags_netcheck" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, JudgeResult.class);
  public final PBInt32Field int32_idle_timeout = PBField.initInt32(0);
  public final PBStringField str_ssid = PBField.initString("");
  public final PBStringField str_tips = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(0);
  public final PBUInt32Field uint32_flags_netcheck = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flags_wifipsw = PBField.initUInt32(0);
  public final PBUInt32Field uint32_force_wifi = PBField.initUInt32(0);
  public final PBUInt32Field uint32_idle_waiting = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.JudgeResult
 * JD-Core Version:    0.7.0.1
 */