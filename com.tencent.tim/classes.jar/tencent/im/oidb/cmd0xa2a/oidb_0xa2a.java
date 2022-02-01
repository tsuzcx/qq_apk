package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa2a
{
  public static final class Attr
    extends MessageMicro<Attr>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_imei = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_imsi = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_phone_num = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_imei", "str_imsi", "str_phone_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, Attr.class);
    }
  }
  
  public static final class Cell
    extends MessageMicro<Cell>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mobile_country_code", "int32_mobile_network_code", "int32_location_area_code", "int32_cell_id", "int32_rssi" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Cell.class);
    public final PBInt32Field int32_cell_id = PBField.initInt32(0);
    public final PBInt32Field int32_location_area_code = PBField.initInt32(0);
    public final PBInt32Field int32_mobile_country_code = PBField.initInt32(0);
    public final PBInt32Field int32_mobile_network_code = PBField.initInt32(0);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int64_latitude", "int64_longitude", "int64_altitude", "uint32_gps_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GPS.class);
    public final PBInt64Field int64_altitude = PBField.initInt64(0L);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
    public final PBUInt32Field uint32_gps_type = PBField.initUInt32(0);
  }
  
  public static final class GroupOnlineInfo
    extends MessageMicro<GroupOnlineInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "group_id", "online_num", "star_num", "hok_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupOnlineInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field hok_num = PBField.initUInt32(0);
    public final PBUInt32Field online_num = PBField.initUInt32(0);
    public final PBUInt32Field star_num = PBField.initUInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 37, 42, 48 }, new String[] { "msg_gpsdw", "rpt_msg_wifis", "rpt_msg_cells", "uint32_ip", "msg_attr", "int64_precision" }, new Object[] { null, null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, LBSInfo.class);
    public final PBInt64Field int64_precision = PBField.initInt64(0L);
    public oidb_0xa2a.Attr msg_attr = new oidb_0xa2a.Attr();
    public oidb_0xa2a.GPS msg_gpsdw = new oidb_0xa2a.GPS();
    public final PBRepeatMessageField<oidb_0xa2a.Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xa2a.Cell.class);
    public final PBRepeatMessageField<oidb_0xa2a.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xa2a.Wifi.class);
    public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "group_id", "lbs_info", "is_private", "is_ignore_show_num", "online_num", "online_info", "hok_appid", "hok_type" }, new Object[] { Long.valueOf(0L), null, Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field hok_appid = PBField.initUInt32(0);
    public final PBUInt32Field hok_type = PBField.initUInt32(0);
    public final PBBoolField is_ignore_show_num = PBField.initBool(false);
    public final PBBoolField is_private = PBField.initBool(false);
    public oidb_0xa2a.LBSInfo lbs_info = new oidb_0xa2a.LBSInfo();
    public final PBRepeatMessageField<oidb_0xa2a.GroupOnlineInfo> online_info = PBField.initRepeatMessage(oidb_0xa2a.GroupOnlineInfo.class);
    public final PBUInt32Field online_num = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64 }, new String[] { "online_info", "infos", "cache_time", "group_id", "list_type", "online_num", "game_switch_status", "show_game_switch_status" }, new Object[] { "", null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field cache_time = PBField.initUInt32(0);
    public final PBUInt32Field game_switch_status = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0xa2a.UserInfo> infos = PBField.initRepeatMessage(oidb_0xa2a.UserInfo.class);
    public final PBUInt32Field list_type = PBField.initUInt32(0);
    public final PBStringField online_info = PBField.initString("");
    public final PBUInt32Field online_num = PBField.initUInt32(0);
    public final PBUInt32Field show_game_switch_status = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "uin", "nick", "tag", "tag_color", "distance", "score" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, UserInfo.class);
    public final PBStringField distance = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBStringField tag = PBField.initString("");
    public final PBUInt32Field tag_color = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBInt64Field int64_mac = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a
 * JD-Core Version:    0.7.0.1
 */