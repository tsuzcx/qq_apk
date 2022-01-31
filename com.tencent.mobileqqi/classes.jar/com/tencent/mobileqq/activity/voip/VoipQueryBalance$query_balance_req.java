package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VoipQueryBalance$query_balance_req
  extends MessageMicro
{
  public static final int BODY_FIELD_NUMBER = 3;
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int ECHO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "cmd", "echo", "body" }, new Object[] { "", Integer.valueOf(0), null }, query_balance_req.class);
  public VoipQueryBalance.query_balance_req_body body = new VoipQueryBalance.query_balance_req_body();
  public final PBStringField cmd = PBField.initString("");
  public final PBUInt32Field echo = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipQueryBalance.query_balance_req
 * JD-Core Version:    0.7.0.1
 */