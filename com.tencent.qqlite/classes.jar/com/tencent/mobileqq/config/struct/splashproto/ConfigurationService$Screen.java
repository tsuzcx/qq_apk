package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$Screen
  extends MessageMicro
{
  public static final int DPI_FIELD_NUMBER = 4;
  public static final int HEIGHT_FIELD_NUMBER = 3;
  public static final int MODEL_FIELD_NUMBER = 1;
  public static final int MULTI_TOUCH_FIELD_NUMBER = 5;
  public static final int WIDTH_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "model", "width", "height", "dpi", "multi_touch" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, Screen.class);
  public final PBUInt32Field dpi = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBStringField model = PBField.initString("");
  public final PBBoolField multi_touch = PBField.initBool(false);
  public final PBUInt32Field width = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen
 * JD-Core Version:    0.7.0.1
 */