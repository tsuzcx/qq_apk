package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$NearFieldFileSendReq
  extends MessageMicro
{
  public static final int INT32_CONN_WIFIAP_TIMEOUT_FIELD_NUMBER = 6;
  public static final int INT32_IP_FIELD_NUMBER = 3;
  public static final int INT32_UDP_PORT_FIELD_NUMBER = 4;
  public static final int RPT_MSG_FILE_LIST_FIELD_NUMBER = 2;
  public static final int STR_SSID_FIELD_NUMBER = 5;
  public static final int STR_WIFIPSW_FIELD_NUMBER = 8;
  public static final int UINT32_FORCE_WIFI_FIELD_NUMBER = 7;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_to_uin", "rpt_msg_file_list", "int32_ip", "int32_udp_port", "str_ssid", "int32_conn_wifiap_timeout", "uint32_force_wifi", "str_wifipsw" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, NearFieldFileSendReq.class);
  public final PBInt32Field int32_conn_wifiap_timeout = PBField.initInt32(0);
  public final PBInt32Field int32_ip = PBField.initInt32(0);
  public final PBInt32Field int32_udp_port = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_msg_file_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.NearFieldFileInfo.class);
  public final PBStringField str_ssid = PBField.initString("");
  public final PBStringField str_wifipsw = PBField.initString("");
  public final PBUInt32Field uint32_force_wifi = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.NearFieldFileSendReq
 * JD-Core Version:    0.7.0.1
 */