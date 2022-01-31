package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AccountSecurityInfo$AccSecInfoRequire
  extends MessageMicro
{
  public static final int STR_VERSION_FIELD_NUMBER = 2;
  public static final int U32_CLIENT_TYPE_FIELD_NUMBER = 3;
  public static final int U64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "u64_uin", "str_version", "u32_client_type" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0) }, AccSecInfoRequire.class);
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt32Field u32_client_type = PBField.initUInt32(0);
  public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.ims.AccountSecurityInfo.AccSecInfoRequire
 * JD-Core Version:    0.7.0.1
 */