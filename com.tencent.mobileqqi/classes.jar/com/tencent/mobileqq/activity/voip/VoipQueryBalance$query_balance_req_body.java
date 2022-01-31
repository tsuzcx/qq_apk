package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VoipQueryBalance$query_balance_req_body
  extends MessageMicro
{
  public static final int CALLER_PHONE_TYPE_FIELD_NUMBER = 2;
  public static final int CALLER_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "caller_uin", "caller_phone_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, query_balance_req_body.class);
  public final PBUInt32Field caller_phone_type = PBField.initUInt32(0);
  public final PBInt64Field caller_uin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipQueryBalance.query_balance_req_body
 * JD-Core Version:    0.7.0.1
 */