package com.tencent.i18n.pa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQiPublicAccount$FetchRecomendedPublicAccountsResp
  extends MessageMicro
{
  public static final int LIST_PUBLIC_ACCOUNT_FIELD_NUMBER = 3;
  public static final int STRING_ERROR_STRING_FIELD_NUMBER = 2;
  public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 1;
  public static final int UINT32_NEXT_FETCH_TIME_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_error_code", "string_error_string", "list_public_account", "uint32_next_fetch_time" }, new Object[] { Integer.valueOf(1), "", null, Integer.valueOf(0) }, FetchRecomendedPublicAccountsResp.class);
  public final PBRepeatMessageField list_public_account = PBField.initRepeatMessage(QQiPublicAccount.RecommendedPublicAccountInfo.class);
  public final PBStringField string_error_string = PBField.initString("");
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(1);
  public final PBUInt32Field uint32_next_fetch_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.pa.proto.QQiPublicAccount.FetchRecomendedPublicAccountsResp
 * JD-Core Version:    0.7.0.1
 */