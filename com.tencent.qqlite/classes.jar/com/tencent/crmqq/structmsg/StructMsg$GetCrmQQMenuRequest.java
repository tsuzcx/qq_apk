package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StructMsg$GetCrmQQMenuRequest
  extends MessageMicro
{
  public static final int SEQNO_FIELD_NUMBER = 1;
  public static final int UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "seqno", "uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetCrmQQMenuRequest.class);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.crmqq.structmsg.StructMsg.GetCrmQQMenuRequest
 * JD-Core Version:    0.7.0.1
 */