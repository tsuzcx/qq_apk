package tencent.im.oidb.cmd0x6df;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x6df
{
  public static final class DevInfo
    extends MessageMicro<DevInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_androidid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_imei = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vendorid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "uint32_appid", "bytes_imei", "bytes_guid", "bytes_vendorid", "bytes_androidid", "uint32_wifi" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, DevInfo.class);
    }
  }
  
  public static final class PhoneInfo
    extends MessageMicro<PhoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_type", "str_country_code", "str_phone", "uint32_bu_status" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, PhoneInfo.class);
    public final PBStringField str_country_code = PBField.initString("");
    public final PBStringField str_phone = PBField.initString("");
    public final PBUInt32Field uint32_bu_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_src", "str_country_code", "str_phone", "dev_info" }, new Object[] { Integer.valueOf(0), "", "", null }, ReqBody.class);
    public Oidb_0x6df.DevInfo dev_info = new Oidb_0x6df.DevInfo();
    public final PBStringField str_country_code = PBField.initString("");
    public final PBStringField str_phone = PBField.initString("");
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_skip_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vas_result = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Oidb_0x6df.PhoneInfo> phone_info = PBField.initRepeatMessage(Oidb_0x6df.PhoneInfo.class);
    public final PBStringField str_binding_phone = PBField.initString("");
    public final PBStringField str_country_code = PBField.initString("");
    public final PBUInt32Field uint32_binding_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_unify = PBField.initUInt32(0);
    public final PBUInt32Field uint32_phone_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 74, 82 }, new String[] { "uint32_result", "uint32_src", "str_country_code", "str_binding_phone", "uint32_binding_time", "uint32_need_unify", "uint32_phone_type", "phone_info", "bytes_skip_url", "bytes_vas_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6df.Oidb_0x6df
 * JD-Core Version:    0.7.0.1
 */