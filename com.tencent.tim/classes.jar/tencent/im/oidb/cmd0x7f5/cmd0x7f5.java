package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7f5
{
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_altitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cityid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "uint32_latitude", "uint32_longitude", "uint32_altitude", "uint32_accuracy", "uint32_time", "uint32_flag", "uint32_cityid", "bytes_client_version", "uint32_client" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, GPS.class);
    }
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_location = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ilat = PBField.initInt32(0);
    public final PBInt32Field int32_ilon = PBField.initInt32(0);
    public cmd0x7f5.LabelRspInfo label_info = new cmd0x7f5.LabelRspInfo();
    public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField string_join_auth_key = PBField.initString("");
    public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_extflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_createtime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_member_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_owner = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 64, 80, 88, 106, 114, 122, 130 }, new String[] { "uint64_group_code", "uint32_accuracy", "int32_ilat", "int32_ilon", "bytes_location", "uint32_extflag", "uint32_group_member_num", "uint64_group_owner", "uint32_group_createtime", "string_group_name", "string_group_finger_memo", "label_info", "string_join_auth_key" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, null, "" }, GroupInfo.class);
    }
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x7f5.Color edging_color = new cmd0x7f5.Color();
    public final PBEnumField enum_type = PBField.initEnum(1);
    public cmd0x7f5.Color text_color = new cmd0x7f5.Color();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class LabelInfo
    extends MessageMicro<LabelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_result", "uint64_group_code", "rpt_group_label" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, LabelInfo.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x7f5.Label> rpt_group_label = PBField.initRepeatMessage(cmd0x7f5.Label.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class LabelRspInfo
    extends MessageMicro<LabelRspInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x7f5.LabelInfo> rpt_label_info = PBField.initRepeatMessage(cmd0x7f5.LabelInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_error", "rpt_label_info" }, new Object[] { localByteStringMicro, null }, LabelRspInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_route_mac = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x7f5.GPS msg_gps = new cmd0x7f5.GPS();
    public final PBRepeatMessageField<cmd0x7f5.Wifi> rpt_msg_wifi_mac = PBField.initRepeatMessage(cmd0x7f5.Wifi.class);
    public final PBUInt32Field uint32_area_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filter_id = PBField.initUInt32(0);
    public final PBFixed32Field uint32_ipv4 = PBField.initFixed32(0);
    public final PBUInt32Field uint32_loc_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 53, 58, 66, 72, 80, 88, 96 }, new String[] { "uint32_max_count", "uint32_max_distance", "uint32_loc_type", "msg_gps", "bytes_route_mac", "uint32_ipv4", "rpt_msg_wifi_mac", "bytes_req_context", "uint32_area_count", "uint32_sort_type", "uint32_filter_id", "uint32_strategy" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x7f5.GroupInfo> rpt_group_info = PBField.initRepeatMessage(cmd0x7f5.GroupInfo.class);
    public final PBUInt32Field uint32_completed_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recruit_number = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_completed_flag", "uint32_recruit_number", "rpt_group_info", "bytes_req_context" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mac = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_rssi = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_mac", "uint32_rssi" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Wifi.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5
 * JD-Core Version:    0.7.0.1
 */