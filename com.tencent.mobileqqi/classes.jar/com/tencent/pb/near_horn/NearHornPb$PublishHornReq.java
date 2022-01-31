package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NearHornPb$PublishHornReq
  extends MessageMicro
{
  public static final int CLIENT_BUFF_FIELD_NUMBER = 4;
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int SVR_BUFF_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "head", "content", "svr_buff", "client_buff" }, new Object[] { null, "", "", "" }, PublishHornReq.class);
  public final PBStringField client_buff = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public NearHornPb.HornReqHead head = new NearHornPb.HornReqHead();
  public final PBStringField svr_buff = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.PublishHornReq
 * JD-Core Version:    0.7.0.1
 */