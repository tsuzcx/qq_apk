package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VoipGetUid$ResponseBody
  extends MessageMicro
{
  public static final int CASH_FIELD_NUMBER = 4;
  public static final int DOMAIN_FIELD_NUMBER = 3;
  public static final int ERR_CODE_FIELD_NUMBER = 6;
  public static final int ERR_MSG_FIELD_NUMBER = 7;
  public static final int EXTERN_SIGN_FIELD_NUMBER = 5;
  public static final int PASSWORD_FIELD_NUMBER = 2;
  public static final int USER_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 37, 40, 48, 58, 66 }, new String[] { "user", "password", "domain", "cash", "extern_sign", "err_code", "err_msg", "version" }, new Object[] { "", "", "", Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), "", "" }, ResponseBody.class);
  public final PBFloatField cash = PBField.initFloat(0.0F);
  public final PBStringField domain = PBField.initString("");
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBInt32Field extern_sign = PBField.initInt32(0);
  public final PBStringField password = PBField.initString("");
  public final PBStringField user = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipGetUid.ResponseBody
 * JD-Core Version:    0.7.0.1
 */