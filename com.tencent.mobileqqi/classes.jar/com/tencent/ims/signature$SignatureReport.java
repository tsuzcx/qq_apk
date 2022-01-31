package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class signature$SignatureReport
  extends MessageMicro
{
  public static final int STR_MD5_FIELD_NUMBER = 6;
  public static final int STR_PACKNAME_FIELD_NUMBER = 4;
  public static final int STR_SIGNATURE_FIELD_NUMBER = 7;
  public static final int STR_VERSION_FIELD_NUMBER = 5;
  public static final int U32_CLIENT_TYPE_FIELD_NUMBER = 2;
  public static final int U32_IS_REPACK_FIELD_NUMBER = 3;
  public static final int U32_PROTOCOL_VERSION_FIELD_NUMBER = 8;
  public static final int U64_UIN_FIELD_NUMBER = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.ims.signature.SignatureReport
 * JD-Core Version:    0.7.0.1
 */