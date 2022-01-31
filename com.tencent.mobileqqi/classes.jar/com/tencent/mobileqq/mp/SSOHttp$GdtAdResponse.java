package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SSOHttp$GdtAdResponse
  extends MessageMicro
{
  public static final int ADSTYPE_FIELD_NUMBER = 2;
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int RETCODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "retcode", "adsType", "data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, GdtAdResponse.class);
  public final PBEnumField adsType = PBField.initEnum(0);
  public final PBStringField data = PBField.initString("");
  public final PBInt32Field retcode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.SSOHttp.GdtAdResponse
 * JD-Core Version:    0.7.0.1
 */