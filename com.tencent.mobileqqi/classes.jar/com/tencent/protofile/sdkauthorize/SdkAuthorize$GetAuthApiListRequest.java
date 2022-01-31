package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SdkAuthorize$GetAuthApiListRequest
  extends MessageMicro
{
  public static final int CLIENT_ID_FIELD_NUMBER = 1;
  public static final int OS_FIELD_NUMBER = 9;
  public static final int PF_FIELD_NUMBER = 3;
  public static final int QQV_FIELD_NUMBER = 8;
  public static final int SCOPE_FIELD_NUMBER = 2;
  public static final int SDKP_FIELD_NUMBER = 6;
  public static final int SDKV_FIELD_NUMBER = 5;
  public static final int SIGN_FIELD_NUMBER = 4;
  public static final int TIME_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74 }, new String[] { "client_id", "scope", "pf", "sign", "sdkv", "sdkp", "time", "qqv", "os" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "", "" }, GetAuthApiListRequest.class);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBStringField os = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField scope = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sdkv = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBInt64Field time = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest
 * JD-Core Version:    0.7.0.1
 */