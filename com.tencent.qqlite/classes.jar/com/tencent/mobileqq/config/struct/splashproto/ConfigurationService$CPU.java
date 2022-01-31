package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$CPU
  extends MessageMicro
{
  public static final int CORES_FIELD_NUMBER = 2;
  public static final int FREQUENCY_FIELD_NUMBER = 3;
  public static final int MODEL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "model", "cores", "frequency" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, CPU.class);
  public final PBUInt32Field cores = PBField.initUInt32(0);
  public final PBUInt32Field frequency = PBField.initUInt32(0);
  public final PBStringField model = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.CPU
 * JD-Core Version:    0.7.0.1
 */