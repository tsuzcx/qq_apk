package com.tencent.pb.remind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RemindPB$ReqBody
  extends MessageMicro
{
  public static final int REP_CLEAR_UIN_FIELD_NUMBER = 3;
  public static final int REP_SET_INFO_FIELD_NUMBER = 2;
  public static final int UINT32_METHOD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_method", "rep_set_info", "rep_clear_uin" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, ReqBody.class);
  public final PBRepeatField rep_clear_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField rep_set_info = PBField.initRepeatMessage(RemindPB.RemindItem.class);
  public final PBUInt32Field uint32_method = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.remind.RemindPB.ReqBody
 * JD-Core Version:    0.7.0.1
 */