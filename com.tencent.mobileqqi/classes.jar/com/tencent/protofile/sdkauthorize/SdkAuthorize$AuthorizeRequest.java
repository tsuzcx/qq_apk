package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SdkAuthorize$AuthorizeRequest
  extends MessageMicro
{
  public static final int CLIENT_ID_FIELD_NUMBER = 2;
  public static final int NEED_PAY_FIELD_NUMBER = 5;
  public static final int OPENAPI_FIELD_NUMBER = 3;
  public static final int OS_FIELD_NUMBER = 11;
  public static final int PASSDATA_FIELD_NUMBER = 12;
  public static final int PF_FIELD_NUMBER = 4;
  public static final int QQV_FIELD_NUMBER = 10;
  public static final int RESPONSE_TYPE_FIELD_NUMBER = 1;
  public static final int SDKP_FIELD_NUMBER = 8;
  public static final int SDKV_FIELD_NUMBER = 7;
  public static final int SID_FIELD_NUMBER = 15;
  public static final int SIGN_FIELD_NUMBER = 6;
  public static final int SKEY_FIELD_NUMBER = 13;
  public static final int TIME_FIELD_NUMBER = 9;
  public static final int VKEY_FIELD_NUMBER = 14;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 122 }, new String[] { "response_type", "client_id", "openapi", "pf", "need_pay", "sign", "sdkv", "sdkp", "time", "qqv", "os", "passData", "skey", "vkey", "sid" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", Long.valueOf(0L), "", "", "", "", "", "" }, AuthorizeRequest.class);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBSInt32Field need_pay = PBField.initSInt32(0);
  public final PBRepeatField openapi = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField os = PBField.initString("");
  public final PBStringField passData = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField response_type = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sdkv = PBField.initString("");
  public final PBStringField sid = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt64Field time = PBField.initInt64(0L);
  public final PBStringField vkey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest
 * JD-Core Version:    0.7.0.1
 */