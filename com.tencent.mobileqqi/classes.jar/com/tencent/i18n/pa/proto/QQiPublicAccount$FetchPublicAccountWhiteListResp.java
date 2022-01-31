package com.tencent.i18n.pa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQiPublicAccount$FetchPublicAccountWhiteListResp
  extends MessageMicro
{
  public static final int STRING_ERROR_STRING_FIELD_NUMBER = 2;
  public static final int UIN64_WHITE_ACCOUNT_LIST_FIELD_NUMBER = 3;
  public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_error_code", "string_error_string", "uin64_white_account_list" }, new Object[] { Integer.valueOf(1), "", Long.valueOf(0L) }, FetchPublicAccountWhiteListResp.class);
  public final PBStringField string_error_string = PBField.initString("");
  public final PBRepeatField uin64_white_account_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.pa.proto.QQiPublicAccount.FetchPublicAccountWhiteListResp
 * JD-Core Version:    0.7.0.1
 */