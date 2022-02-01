package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x87c
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_butype = PBField.initEnum(0);
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_sms_code = PBField.initString("");
    public final PBStringField str_telephone = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "str_country", "str_telephone", "str_sms_code", "bytes_guid", "enum_butype" }, new Object[] { "", "", "", localByteStringMicro, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_telephone = PBField.initString("");
    public final PBUInt32Field uint32_key_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "str_country", "str_telephone", "uint32_key_type", "bytes_key", "bytes_guid" }, new Object[] { "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x87c
 * JD-Core Version:    0.7.0.1
 */