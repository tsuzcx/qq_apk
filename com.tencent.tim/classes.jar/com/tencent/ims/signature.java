package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class signature
{
  public static final class SignatureKickData
    extends MessageMicro<SignatureKickData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64, 72 }, new String[] { "u64_uin", "str_packname", "u32_check_result", "str_left_button", "str_right_button", "str_url", "u32_timeout", "u32_protocol_version", "u32_cache_time" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SignatureKickData.class);
    public final PBStringField str_left_button = PBField.initString("");
    public final PBStringField str_packname = PBField.initString("");
    public final PBStringField str_right_button = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field u32_cache_time = PBField.initUInt32(0);
    public final PBUInt32Field u32_check_result = PBField.initUInt32(0);
    public final PBUInt32Field u32_protocol_version = PBField.initUInt32(0);
    public final PBUInt32Field u32_timeout = PBField.initUInt32(0);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SignatureKickResult
    extends MessageMicro<SignatureKickResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_title", "str_content", "bytes_data" }, new Object[] { "", "", localByteStringMicro }, SignatureKickResult.class);
    }
  }
  
  public static final class SignatureReport
    extends MessageMicro<SignatureReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64 }, new String[] { "u64_uin", "u32_client_type", "u32_is_repack", "str_packname", "str_version", "str_md5", "str_signature", "u32_protocol_version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0) }, SignatureReport.class);
    public final PBStringField str_md5 = PBField.initString("");
    public final PBStringField str_packname = PBField.initString("");
    public final PBStringField str_signature = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field u32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_is_repack = PBField.initUInt32(0);
    public final PBUInt32Field u32_protocol_version = PBField.initUInt32(0);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SignatureResult
    extends MessageMicro<SignatureResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 66, 72, 80, 88 }, new String[] { "u64_uin", "str_packname", "u32_check_result", "str_title", "str_content", "str_left_button", "str_right_button", "str_url", "u32_timeout", "u32_protocol_version", "u32_cache_time" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SignatureResult.class);
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_left_button = PBField.initString("");
    public final PBStringField str_packname = PBField.initString("");
    public final PBStringField str_right_button = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field u32_cache_time = PBField.initUInt32(0);
    public final PBUInt32Field u32_check_result = PBField.initUInt32(0);
    public final PBUInt32Field u32_protocol_version = PBField.initUInt32(0);
    public final PBUInt32Field u32_timeout = PBField.initUInt32(0);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.signature
 * JD-Core Version:    0.7.0.1
 */