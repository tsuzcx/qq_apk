package com.tencent.qconn.protofile.fastauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FastAuthorize$AuthorizeRequest
  extends MessageMicro
{
  public static final int APK_SIGN_FIELD_NUMBER = 13;
  public static final int CLIENT_ID_FIELD_NUMBER = 2;
  public static final int FLAGS_FIELD_NUMBER = 10;
  public static final int OS_FIELD_NUMBER = 11;
  public static final int PF_FIELD_NUMBER = 3;
  public static final int QQV_FIELD_NUMBER = 5;
  public static final int SDKP_FIELD_NUMBER = 6;
  public static final int SID_FIELD_NUMBER = 12;
  public static final int SKEY_FIELD_NUMBER = 7;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 9;
  public static final int VKEY_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 42, 50, 58, 66, 74, 80, 90, 98, 106 }, new String[] { "uin", "client_id", "pf", "qqv", "sdkp", "skey", "vkey", "version", "flags", "os", "sid", "apk_sign" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", "1.0", Integer.valueOf(0), "", "", "" }, AuthorizeRequest.class);
  public final PBStringField apk_sign = PBField.initString("");
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBInt32Field flags = PBField.initInt32(0);
  public final PBStringField os = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sid = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBStringField version = PBField.initString("1.0");
  public final PBStringField vkey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest
 * JD-Core Version:    0.7.0.1
 */