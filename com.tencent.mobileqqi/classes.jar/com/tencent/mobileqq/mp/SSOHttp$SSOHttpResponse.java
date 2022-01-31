package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SSOHttp$SSOHttpResponse
  extends MessageMicro
{
  public static final int BODY_FIELD_NUMBER = 3;
  public static final int HEADER_FIELD_NUMBER = 2;
  public static final int RETCODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "retcode", "header", "body" }, new Object[] { Integer.valueOf(0), "", "" }, SSOHttpResponse.class);
  public final PBStringField body = PBField.initString("");
  public final PBStringField header = PBField.initString("");
  public final PBInt32Field retcode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.SSOHttp.SSOHttpResponse
 * JD-Core Version:    0.7.0.1
 */