package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SdkAuthorize$AuthorizeResponse
  extends MessageMicro
{
  public static final int ACCESS_TOKEN_FIELD_NUMBER = 3;
  public static final int ENCRYKEY_FIELD_NUMBER = 10;
  public static final int ENCRYTOKEN_FIELD_NUMBER = 7;
  public static final int EXPIRES_IN_FIELD_NUMBER = 4;
  public static final int INSTALLWORDING_FIELD_NUMBER = 13;
  public static final int MD5KEY_FIELD_NUMBER = 11;
  public static final int MD5QQKEY_FIELD_NUMBER = 16;
  public static final int MSG_FIELD_NUMBER = 2;
  public static final int OPENID_FIELD_NUMBER = 5;
  public static final int PASSDATARESP_FIELD_NUMBER = 14;
  public static final int PAY_TOKEN_FIELD_NUMBER = 6;
  public static final int PFKEY_FIELD_NUMBER = 9;
  public static final int PF_FIELD_NUMBER = 8;
  public static final int RET_FIELD_NUMBER = 1;
  public static final int SENDINSTALL_FIELD_NUMBER = 12;
  public static final int SIGNQQKEY_FIELD_NUMBER = 15;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130 }, new String[] { "ret", "msg", "access_token", "expires_in", "openid", "pay_token", "encrytoken", "pf", "pfkey", "encrykey", "md5key", "sendinstall", "installwording", "passDataResp", "signQQkey", "md5QQkey" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), "", "", "", "", "", "", "", Integer.valueOf(0), "", null, "", "" }, AuthorizeResponse.class);
  public final PBStringField access_token = PBField.initString("");
  public final PBStringField encrykey = PBField.initString("");
  public final PBStringField encrytoken = PBField.initString("");
  public final PBInt64Field expires_in = PBField.initInt64(0L);
  public final PBStringField installwording = PBField.initString("");
  public final PBStringField md5QQkey = PBField.initString("");
  public final PBStringField md5key = PBField.initString("");
  public final PBStringField msg = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBRepeatMessageField passDataResp = PBField.initRepeatMessage(SdkAuthorize.PassData.class);
  public final PBStringField pay_token = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField pfkey = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt32Field sendinstall = PBField.initUInt32(0);
  public final PBStringField signQQkey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
 * JD-Core Version:    0.7.0.1
 */