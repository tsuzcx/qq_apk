package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VoipGetUid$RequestBody
  extends MessageMicro
{
  public static final int CALLED_MOBILE_FIELD_NUMBER = 6;
  public static final int COUNTRY_FIELD_NUMBER = 5;
  public static final int LANGUAGE_FIELD_NUMBER = 4;
  public static final int MOBILE_FIELD_NUMBER = 3;
  public static final int PLATFORM_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uin", "platform", "mobile", "language", "country", "called_mobile" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "", "" }, RequestBody.class);
  public final PBStringField called_mobile = PBField.initString("");
  public final PBStringField country = PBField.initString("");
  public final PBStringField language = PBField.initString("");
  public final PBStringField mobile = PBField.initString("");
  public final PBInt32Field platform = PBField.initInt32(0);
  public final PBInt64Field uin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipGetUid.RequestBody
 * JD-Core Version:    0.7.0.1
 */