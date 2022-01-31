package com.tencent.i18n.pa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQiPublicAccount$RecommendedPublicAccountInfo
  extends MessageMicro
{
  public static final int STRING_NAME_FIELD_NUMBER = 2;
  public static final int STRING_REMARK_FIELD_NUMBER = 3;
  public static final int UIN64_PUBLIC_ACCOUNT_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin64_public_account_uin", "string_name", "string_remark" }, new Object[] { Long.valueOf(0L), "", "" }, RecommendedPublicAccountInfo.class);
  public final PBStringField string_name = PBField.initString("");
  public final PBStringField string_remark = PBField.initString("");
  public final PBUInt64Field uin64_public_account_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.pa.proto.QQiPublicAccount.RecommendedPublicAccountInfo
 * JD-Core Version:    0.7.0.1
 */