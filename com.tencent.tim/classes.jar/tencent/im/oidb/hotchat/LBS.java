package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LBS
{
  public static final class Attribute
    extends MessageMicro<Attribute>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField imei = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField imsi = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField phone_num = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "imei", "imsi", "phone_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, Attribute.class);
    }
  }
  
  public static final class Cell
    extends MessageMicro<Cell>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "mcc", "mnc", "lac", "cellid", "rssi" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Cell.class);
    public final PBInt32Field cellid = PBField.initInt32(0);
    public final PBInt32Field lac = PBField.initInt32(0);
    public final PBInt32Field mcc = PBField.initInt32(0);
    public final PBInt32Field mnc = PBField.initInt32(0);
    public final PBInt32Field rssi = PBField.initInt32(0);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "latitude", "longitude", "altitude", "coordinate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GPS.class);
    public final PBInt32Field altitude = PBField.initInt32(0);
    public final PBEnumField coordinate = PBField.initEnum(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBInt32Field longitude = PBField.initInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "gps", "rpt_wifi", "rpt_cell", "attribute" }, new Object[] { null, null, null, null }, LBSInfo.class);
    public LBS.Attribute attribute = new LBS.Attribute();
    public LBS.GPS gps = new LBS.GPS();
    public final PBRepeatMessageField<LBS.Cell> rpt_cell = PBField.initRepeatMessage(LBS.Cell.class);
    public final PBRepeatMessageField<LBS.Wifi> rpt_wifi = PBField.initRepeatMessage(LBS.Wifi.class);
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField essid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field mac = PBField.initUInt64(0L);
    public final PBInt32Field rssi = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "mac", "essid", "rssi" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, Wifi.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.LBS
 * JD-Core Version:    0.7.0.1
 */