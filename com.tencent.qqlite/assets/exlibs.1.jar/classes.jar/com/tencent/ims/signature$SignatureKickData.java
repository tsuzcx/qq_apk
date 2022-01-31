package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class signature$SignatureKickData
  extends MessageMicro
{
  public static final int STR_LEFT_BUTTON_FIELD_NUMBER = 4;
  public static final int STR_PACKNAME_FIELD_NUMBER = 2;
  public static final int STR_RIGHT_BUTTON_FIELD_NUMBER = 5;
  public static final int STR_URL_FIELD_NUMBER = 6;
  public static final int U32_CHECK_RESULT_FIELD_NUMBER = 3;
  public static final int U32_PROTOCOL_VERSION_FIELD_NUMBER = 8;
  public static final int U32_TIMEOUT_FIELD_NUMBER = 7;
  public static final int U64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64 }, new String[] { "u64_uin", "str_packname", "u32_check_result", "str_left_button", "str_right_button", "str_url", "u32_timeout", "u32_protocol_version" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, SignatureKickData.class);
  public final PBStringField str_left_button = PBField.initString("");
  public final PBStringField str_packname = PBField.initString("");
  public final PBStringField str_right_button = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field u32_check_result = PBField.initUInt32(0);
  public final PBUInt32Field u32_protocol_version = PBField.initUInt32(0);
  public final PBUInt32Field u32_timeout = PBField.initUInt32(0);
  public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.ims.signature.SignatureKickData
 * JD-Core Version:    0.7.0.1
 */