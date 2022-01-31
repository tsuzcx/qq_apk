package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class PreloadInfoCheckUpdate$PreloadInfoReq
  extends MessageMicro
{
  public static final int APP_BEHAVIOR_FIELD_NUMBER = 2;
  public static final int HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "app_behavior" }, new Object[] { null, null }, PreloadInfoReq.class);
  public final PBRepeatMessageField app_behavior = PBField.initRepeatMessage(PreloadInfoCheckUpdate.AppBehavior.class);
  public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadInfoReq
 * JD-Core Version:    0.7.0.1
 */