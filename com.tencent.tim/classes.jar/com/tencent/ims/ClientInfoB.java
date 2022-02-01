package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClientInfoB
{
  public static final class EnvParamPacket
    extends MessageMicro<EnvParamPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_qqversion = PBField.initString("");
    public final PBStringField str_safeversion = PBField.initString("");
    public final PBStringField str_sysversion = PBField.initString("");
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field u32_appid = PBField.initUInt32(0);
    public final PBUInt32Field u32_platform = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58 }, new String[] { "u32_platform", "str_sysversion", "u32_appid", "str_uin", "str_qqversion", "str_safeversion", "bytes_guid" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", localByteStringMicro }, EnvParamPacket.class);
    }
  }
  
  public static final class ReportDetectResultPacket
    extends MessageMicro<ReportDetectResultPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_buffer2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public ClientInfoB.EnvParamPacket envParam = new ClientInfoB.EnvParamPacket();
    public final PBStringField str_safemd5 = PBField.initString("");
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_cmd", "envParam", "bytes_buffer", "bytes_buffer2", "str_safemd5" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, "" }, ReportDetectResultPacket.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.ClientInfoB
 * JD-Core Version:    0.7.0.1
 */