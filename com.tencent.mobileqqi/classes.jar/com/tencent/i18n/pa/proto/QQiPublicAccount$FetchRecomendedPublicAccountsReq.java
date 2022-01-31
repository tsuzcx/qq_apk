package com.tencent.i18n.pa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQiPublicAccount$FetchRecomendedPublicAccountsReq
  extends MessageMicro
{
  public static final int CITYINFO_FIELD_NUMBER = 5;
  public static final int CITYPOSITION_FIELD_NUMBER = 4;
  public static final int IPADDRESS_FIELD_NUMBER = 3;
  public static final int LANGUAGE_FIELD_NUMBER = 2;
  public static final int LIST_PUBLIC_ACCOUNT_UIN_FIELD_NUMBER = 6;
  public static final int UINT32_NEXT_FETCH_TIME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "uint32_next_fetch_time", "language", "ipAddress", "cityPosition", "cityInfo", "list_public_account_uin" }, new Object[] { Integer.valueOf(0), "", "", null, null, Long.valueOf(0L) }, FetchRecomendedPublicAccountsReq.class);
  public QQiPublicAccount.CityInfo cityInfo = new QQiPublicAccount.CityInfo();
  public QQiPublicAccount.Position cityPosition = new QQiPublicAccount.Position();
  public final PBStringField ipAddress = PBField.initString("");
  public final PBStringField language = PBField.initString("");
  public final PBRepeatField list_public_account_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_next_fetch_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.pa.proto.QQiPublicAccount.FetchRecomendedPublicAccountsReq
 * JD-Core Version:    0.7.0.1
 */