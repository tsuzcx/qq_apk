package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ConfigurationService$Config
  extends MessageMicro
{
  public static final int CONTENT_LIST_FIELD_NUMBER = 3;
  public static final int TYPE_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "type", "version", "content_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, Config.class);
  public final PBRepeatField content_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBInt32Field version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
 * JD-Core Version:    0.7.0.1
 */