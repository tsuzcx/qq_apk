package com.tencent.i18n.translate.util;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Translate$TranslateReq
  extends MessageMicro
{
  public static final int ARRAY_TEXT_FIELD_NUMBER = 2;
  public static final int REQUEST_TIME_FIELD_NUMBER = 3;
  public static final int TARGET_LANGUAGE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "target_language", "array_text", "request_time" }, new Object[] { "", "", Long.valueOf(0L) }, TranslateReq.class);
  public final PBRepeatField array_text = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt64Field request_time = PBField.initUInt64(0L);
  public final PBStringField target_language = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.translate.util.Translate.TranslateReq
 * JD-Core Version:    0.7.0.1
 */