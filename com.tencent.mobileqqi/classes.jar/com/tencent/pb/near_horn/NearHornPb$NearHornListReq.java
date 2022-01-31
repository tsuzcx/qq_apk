package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class NearHornPb$NearHornListReq
  extends MessageMicro
{
  public static final int CLIENT_BUFF_FIELD_NUMBER = 5;
  public static final int CONF_ONLY_FIELD_NUMBER = 6;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int HORN_KEY_FIELD_NUMBER = 2;
  public static final int PUBLISH_TIME_FIELD_NUMBER = 3;
  public static final int SVR_BUFF_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "head", "horn_key", "publish_time", "svr_buff", "client_buff", "conf_only" }, new Object[] { null, "", Long.valueOf(0L), "", "", Boolean.valueOf(false) }, NearHornListReq.class);
  public final PBStringField client_buff = PBField.initString("");
  public final PBBoolField conf_only = PBField.initBool(false);
  public NearHornPb.HornReqHead head = new NearHornPb.HornReqHead();
  public final PBStringField horn_key = PBField.initString("");
  public final PBInt64Field publish_time = PBField.initInt64(0L);
  public final PBStringField svr_buff = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.NearHornListReq
 * JD-Core Version:    0.7.0.1
 */