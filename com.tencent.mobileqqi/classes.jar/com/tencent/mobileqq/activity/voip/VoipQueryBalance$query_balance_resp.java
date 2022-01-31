package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VoipQueryBalance$query_balance_resp
  extends MessageMicro
{
  public static final int BODY_FIELD_NUMBER = 5;
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int ECHO_FIELD_NUMBER = 2;
  public static final int ERR_FIELD_NUMBER = 4;
  public static final int RET_CODE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "cmd", "echo", "ret_code", "err", "body" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", null }, query_balance_resp.class);
  public VoipQueryBalance.query_balance_resp_body body = new VoipQueryBalance.query_balance_resp_body();
  public final PBStringField cmd = PBField.initString("");
  public final PBUInt32Field echo = PBField.initUInt32(0);
  public final PBStringField err = PBField.initString("");
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipQueryBalance.query_balance_resp
 * JD-Core Version:    0.7.0.1
 */