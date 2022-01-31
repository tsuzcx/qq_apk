package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TFontSsoReq
  extends MessageMicro
{
  public static final int I32_IMPLAT_FIELD_NUMBER = 3;
  public static final int STR_MQQVER_FIELD_NUMBER = 5;
  public static final int STR_OSVER_FIELD_NUMBER = 4;
  public static final int ST_FRESH_REQ_FIELD_NUMBER = 6;
  public static final int U32_CMD_FIELD_NUMBER = 1;
  public static final int U64_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "u32_cmd", "u64_seq", "i32_implat", "str_osver", "str_mqqver", "st_fresh_req" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null }, TFontSsoReq.class);
  public final PBInt32Field i32_implat = PBField.initInt32(0);
  public VipFontUpdate.TFontFreshReq st_fresh_req = new VipFontUpdate.TFontFreshReq();
  public final PBStringField str_mqqver = PBField.initString("");
  public final PBStringField str_osver = PBField.initString("");
  public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
  public final PBUInt64Field u64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoReq
 * JD-Core Version:    0.7.0.1
 */