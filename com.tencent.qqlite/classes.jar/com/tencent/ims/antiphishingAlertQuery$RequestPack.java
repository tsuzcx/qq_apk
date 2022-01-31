package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class antiphishingAlertQuery$RequestPack
  extends MessageMicro
{
  public static final int I32_XOFFSET_FIELD_NUMBER = 3;
  public static final int I32_YOFFSET_FIELD_NUMBER = 4;
  public static final int STR_URL_FIELD_NUMBER = 2;
  public static final int U32_ACCOUNT_TYPE_FIELD_NUMBER = 8;
  public static final int U32_APP_TYPE_FIELD_NUMBER = 1;
  public static final int U32_CLI_URL_VER_FIELD_NUMBER = 9;
  public static final int U32_CTRL_HEIGHT_FIELD_NUMBER = 6;
  public static final int U32_CTRL_WIDTH_FIELD_NUMBER = 5;
  public static final int U32_PROTO_VER_FIELD_NUMBER = 11;
  public static final int U32_SEQ_FIELD_NUMBER = 10;
  public static final int U64_INPUT_UIN_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "u32_app_type", "str_url", "i32_xoffset", "i32_yoffset", "u32_ctrl_width", "u32_ctrl_height", "u64_input_uin", "u32_account_type", "u32_cli_url_ver", "u32_seq", "u32_proto_ver" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RequestPack.class);
  public final PBInt32Field i32_xoffset = PBField.initInt32(0);
  public final PBInt32Field i32_yoffset = PBField.initInt32(0);
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field u32_account_type = PBField.initUInt32(0);
  public final PBUInt32Field u32_app_type = PBField.initUInt32(0);
  public final PBUInt32Field u32_cli_url_ver = PBField.initUInt32(0);
  public final PBUInt32Field u32_ctrl_height = PBField.initUInt32(0);
  public final PBUInt32Field u32_ctrl_width = PBField.initUInt32(0);
  public final PBUInt32Field u32_proto_ver = PBField.initUInt32(0);
  public final PBUInt32Field u32_seq = PBField.initUInt32(0);
  public final PBUInt64Field u64_input_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.ims.antiphishingAlertQuery.RequestPack
 * JD-Core Version:    0.7.0.1
 */