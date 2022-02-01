package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class userinfo
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plat_type", "str_app_version" }, new Object[] { Integer.valueOf(1), "" }, AppInfo.class);
    public final PBEnumField plat_type = PBField.initEnum(1);
    public final PBStringField str_app_version = PBField.initString("");
  }
  
  public static final class Cell
    extends MessageMicro<Cell>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_mcc", "uint32_mnc", "uint32_lac", "uint32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Cell.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt32Field uint32_cellid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lac = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mcc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mnc = PBField.initUInt32(0);
  }
  
  public static final class DevAttr
    extends MessageMicro<DevAttr>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_imei", "str_imsi", "str_phonenum" }, new Object[] { "", "", "" }, DevAttr.class);
    public final PBStringField str_imei = PBField.initString("");
    public final PBStringField str_imsi = PBField.initString("");
    public final PBStringField str_phonenum = PBField.initString("");
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_lat", "uint32_lon", "int32_alt", "type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GPS.class);
    public final PBInt32Field int32_alt = PBField.initInt32(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field uint32_lat = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lon = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public userinfo.AppInfo app_info = new userinfo.AppInfo();
    public userinfo.DevAttr attr = new userinfo.DevAttr();
    public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public userinfo.GPS gps = new userinfo.GPS();
    public final PBRepeatMessageField<userinfo.Cell> rpt_cell = PBField.initRepeatMessage(userinfo.Cell.class);
    public final PBRepeatMessageField<userinfo.Wifi> rpt_wifi = PBField.initRepeatMessage(userinfo.Wifi.class);
    public final PBStringField skey = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uin", "skey", "gps", "rpt_wifi", "rpt_cell", "attr", "app_info", "bytes_client_version" }, new Object[] { Long.valueOf(0L), "", null, null, null, null, null, localByteStringMicro }, UserInfo.class);
    }
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.troop_search_userinfo.userinfo
 * JD-Core Version:    0.7.0.1
 */