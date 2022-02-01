package tencent.im.lbs;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class member_lbs
{
  public static final class Attr
    extends MessageMicro<Attr>
  {
    public static final int STR_IMEI_FIELD_NUMBER = 1;
    public static final int STR_IMSI_FIELD_NUMBER = 2;
    public static final int STR_PHONE_NUM_FIELD_NUMBER = 3;
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
    public static final int INT32_CELL_ID_FIELD_NUMBER = 4;
    public static final int INT32_LOCATION_AREA_CODE_FIELD_NUMBER = 3;
    public static final int INT32_MOBILE_COUNTRY_CODE_FIELD_NUMBER = 1;
    public static final int INT32_MOBILE_NETWORK_CODE_FIELD_NUMBER = 2;
    public static final int INT32_RSSI_FIELD_NUMBER = 5;
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
    public static final int INT64_ALTITUDE_FIELD_NUMBER = 3;
    public static final int INT64_LATITUDE_FIELD_NUMBER = 1;
    public static final int INT64_LONGITUDE_FIELD_NUMBER = 2;
    public static final int UINT32_GPS_TYPE_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int64_latitude", "int64_longitude", "int64_altitude", "uint32_gps_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GPS.class);
    public final PBInt64Field int64_altitude = PBField.initInt64(0L);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
    public final PBUInt32Field uint32_gps_type = PBField.initUInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    public static final int INT64_PRECISION_FIELD_NUMBER = 6;
    public static final int MSG_ATTR_FIELD_NUMBER = 5;
    public static final int MSG_GPS_FIELD_NUMBER = 1;
    public static final int RPT_MSG_CELLS_FIELD_NUMBER = 3;
    public static final int RPT_MSG_WIFIS_FIELD_NUMBER = 2;
    public static final int UINT32_IP_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 37, 42, 48 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells", "uint32_ip", "msg_attr", "int64_precision" }, new Object[] { null, null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, LBSInfo.class);
    public final PBInt64Field int64_precision = PBField.initInt64(0L);
    public member_lbs.Attr msg_attr = new member_lbs.Attr();
    public member_lbs.GPS msg_gps = new member_lbs.GPS();
    public final PBRepeatMessageField<member_lbs.Cell> rpt_msg_cells = PBField.initRepeatMessage(member_lbs.Cell.class);
    public final PBRepeatMessageField<member_lbs.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(member_lbs.Wifi.class);
    public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
  }
  
  public static final class Location
    extends MessageMicro<Location>
  {
    public static final int INT64_LATITUDE_FIELD_NUMBER = 1;
    public static final int INT64_LONGITUDE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_latitude", "int64_longitude" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, Location.class);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  }
  
  public static final class MemsDistance
    extends MessageMicro<MemsDistance>
  {
    public static final int INT64_DISTANCE_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "int64_distance" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, MemsDistance.class);
    public final PBInt64Field int64_distance = PBField.initInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class NeighbourInfo
    extends MessageMicro<NeighbourInfo>
  {
    public static final int DOUBLE_DISTANCE_FIELD_NUMBER = 4;
    public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
    public static final int INT64_LONGITUDE_FIELD_NUMBER = 3;
    public static final int STR_NICK_FIELD_NUMBER = 7;
    public static final int UINT32_AGE_FIELD_NUMBER = 6;
    public static final int UINT32_SEX_FIELD_NUMBER = 5;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBDoubleField double_distance = PBField.initDouble(0.0D);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
    public final PBBytesField str_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 33, 40, 48, 58 }, new String[] { "uint64_uin", "int64_latitude", "int64_longitude", "double_distance", "uint32_sex", "uint32_age", "str_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, NeighbourInfo.class);
    }
  }
  
  public static final class NeighbourNumber
    extends MessageMicro<NeighbourNumber>
  {
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    public static final int UINT64_LOCATED_NUMBER_FIELD_NUMBER = 3;
    public static final int UINT64_NEIGHBOUR_NUMBER_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_code", "uint64_neighbour_number", "uint64_located_number" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, NeighbourNumber.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_located_number = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_neighbour_number = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int BOOL_NEED_NEIGHBOURS_FIELD_NUMBER = 4;
    public static final int MSG_LBSINFO_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "msg_lbsinfo", "uint64_group_code", "uint64_uin", "bool_need_neighbours" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, ReqBody.class);
    public final PBBoolField bool_need_neighbours = PBField.initBool(false);
    public member_lbs.LBSInfo msg_lbsinfo = new member_lbs.LBSInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int BOOL_SHOW_TIPS_FIELD_NUMBER = 6;
    public static final int MSG_LOCATION_FIELD_NUMBER = 3;
    public static final int MSG_MEMS_DISTANCE_FIELD_NUMBER = 5;
    public static final int MSG_NEIGHBOUR_NUMBER_FIELD_NUMBER = 4;
    public static final int RPT_MSG_NEIGHBOURS_INFO_FIELD_NUMBER = 10;
    public static final int STR_RESULT_INFO_FIELD_NUMBER = 2;
    public static final int STR_TIPS_NATIVE_URL_FIELD_NUMBER = 8;
    public static final int STR_TIPS_WEB_URL_FIELD_NUMBER = 9;
    public static final int STR_TIPS_WORDING_FIELD_NUMBER = 7;
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_show_tips = PBField.initBool(false);
    public member_lbs.Location msg_location = new member_lbs.Location();
    public member_lbs.MemsDistance msg_mems_distance = new member_lbs.MemsDistance();
    public member_lbs.NeighbourNumber msg_neighbour_number = new member_lbs.NeighbourNumber();
    public final PBRepeatMessageField<member_lbs.NeighbourInfo> rpt_msg_neighbours_info = PBField.initRepeatMessage(member_lbs.NeighbourInfo.class);
    public final PBBytesField str_result_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_tips_native_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_tips_web_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 74, 82 }, new String[] { "uint32_result", "str_result_info", "msg_location", "msg_neighbour_number", "msg_mems_distance", "bool_show_tips", "str_tips_wording", "str_tips_native_url", "str_tips_web_url", "rpt_msg_neighbours_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, null, null, Boolean.valueOf(false), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null }, RspBody.class);
    }
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    public static final int INT32_RSSI_FIELD_NUMBER = 2;
    public static final int INT64_MAC_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBInt64Field int64_mac = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.lbs.member_lbs
 * JD-Core Version:    0.7.0.1
 */