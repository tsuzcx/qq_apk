package tencent.im.oidb.cmd0xdc0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdc0
{
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xdc0.LocationInfo> rpt_location_list = PBField.initRepeatMessage(oidb_0xdc0.LocationInfo.class);
    public final PBUInt32Field uint32_order = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 90 }, new String[] { "bytes_name", "uint32_order", "rpt_location_list" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, GroupInfo.class);
    }
  }
  
  public static final class LocationInfo
    extends MessageMicro<LocationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_city_code = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_country = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_province = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_order = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114 }, new String[] { "uint32_id", "uint32_order", "bytes_country", "bytes_province", "bytes_city", "bytes_city_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, LocationInfo.class);
    }
  }
  
  public static final class LocationList
    extends MessageMicro<LocationList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_group_list" }, new Object[] { null }, LocationList.class);
    public final PBRepeatMessageField<oidb_0xdc0.GroupInfo> rpt_group_list = PBField.initRepeatMessage(oidb_0xdc0.GroupInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_req_type" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "msg_location_list" }, new Object[] { null }, RspBody.class);
    public oidb_0xdc0.LocationList msg_location_list = new oidb_0xdc0.LocationList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc0.oidb_0xdc0
 * JD-Core Version:    0.7.0.1
 */