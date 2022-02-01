package com.tencent.mqp.app.bps;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class c
  extends MessageMicro<c>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField package_name = PBField.initString("");
  public final PBStringField str_apkmd5 = PBField.initString("");
  public final PBStringField str_apkversion = PBField.initString("");
  public final PBStringField str_brand = PBField.initString("");
  public final PBStringField str_channelid = PBField.initString("");
  public final PBStringField str_model = PBField.initString("");
  public final PBStringField str_rsamd5 = PBField.initString("");
  public final PBStringField str_signature = PBField.initString("");
  public final PBStringField str_sysversion = PBField.initString("");
  public final PBStringField str_txsfcfgkmd5 = PBField.initString("");
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122 }, new String[] { "uint32_cmd", "uint32_result", "uint32_appid", "str_signature", "str_apkmd5", "str_rsamd5", "str_txsfcfgkmd5", "str_apkversion", "str_channelid", "str_uin", "bytes_guid", "str_sysversion", "str_brand", "str_model", "package_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", "", localByteStringMicro, "", "", "", "" }, c.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.bps.c
 * JD-Core Version:    0.7.0.1
 */