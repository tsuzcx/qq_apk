package com.tencent.ims;

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

public final class SecSharedInfo
{
  public static final class FileInfo
    extends MessageMicro<FileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "package_name", "soft_name", "cert_md5", "apk_filesize" }, new Object[] { "", "", "", Integer.valueOf(0) }, FileInfo.class);
    public final PBUInt32Field apk_filesize = PBField.initUInt32(0);
    public final PBStringField cert_md5 = PBField.initString("");
    public final PBStringField package_name = PBField.initString("");
    public final PBStringField soft_name = PBField.initString("");
  }
  
  public static final class SendInfo
    extends MessageMicro<SendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "type", "md5", "url", "src_uin", "des_uin", "des_type" }, new Object[] { Integer.valueOf(1), "", "", "", "", Integer.valueOf(0) }, SendInfo.class);
    public final PBInt32Field des_type = PBField.initInt32(0);
    public final PBStringField des_uin = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField src_uin = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class SharedInfoPacket
    extends MessageMicro<SharedInfoPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public SecSharedInfo.FileInfo file_info = new SecSharedInfo.FileInfo();
    public final PBUInt32Field qq_version = PBField.initUInt32(0);
    public final PBRepeatMessageField<SecSharedInfo.SendInfo> send_info = PBField.initRepeatMessage(SecSharedInfo.SendInfo.class);
    public final PBStringField str_brand = PBField.initString("");
    public final PBStringField str_model = PBField.initString("");
    public final PBStringField str_sysversion = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 64, 74, 82 }, new String[] { "version", "type", "bytes_guid", "uint32_appid", "str_sysversion", "str_brand", "str_model", "qq_version", "send_info", "file_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro, Integer.valueOf(0), "", "", "", Integer.valueOf(0), null, null }, SharedInfoPacket.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.SecSharedInfo
 * JD-Core Version:    0.7.0.1
 */