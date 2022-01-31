package com.tencent.i18n.translate.util;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Translate$TranslateResp
  extends MessageMicro
{
  public static final int ERROR_INFO_FIELD_NUMBER = 3;
  public static final int RESULT_CODE_FIELD_NUMBER = 1;
  public static final int TRANSLATED_ARRAY_TEXT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result_code", "translated_array_text", "error_info" }, new Object[] { Integer.valueOf(0), "", "" }, TranslateResp.class);
  public final PBStringField error_info = PBField.initString("");
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBRepeatField translated_array_text = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.translate.util.Translate.TranslateResp
 * JD-Core Version:    0.7.0.1
 */