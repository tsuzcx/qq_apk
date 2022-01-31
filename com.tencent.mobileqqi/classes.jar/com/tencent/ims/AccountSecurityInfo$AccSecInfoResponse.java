package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AccountSecurityInfo$AccSecInfoResponse
  extends MessageMicro
{
  public static final int STR_ACCINFOURL_FIELD_NUMBER = 3;
  public static final int STR_WORDING_FIELD_NUMBER = 2;
  public static final int U32_VALID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "u32_valid", "str_wording", "str_AccInfoUrl" }, new Object[] { Integer.valueOf(0), "", "" }, AccSecInfoResponse.class);
  public final PBStringField str_AccInfoUrl = PBField.initString("");
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field u32_valid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.ims.AccountSecurityInfo.AccSecInfoResponse
 * JD-Core Version:    0.7.0.1
 */