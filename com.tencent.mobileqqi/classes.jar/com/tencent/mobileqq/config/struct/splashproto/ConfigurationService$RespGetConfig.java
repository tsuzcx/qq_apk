package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ConfigurationService$RespGetConfig
  extends MessageMicro
{
  public static final int CONFIG_LIST_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "config_list" }, new Object[] { Integer.valueOf(0), null }, RespGetConfig.class);
  public final PBRepeatMessageField config_list = PBField.initRepeatMessage(ConfigurationService.Config.class);
  public final PBInt32Field result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig
 * JD-Core Version:    0.7.0.1
 */