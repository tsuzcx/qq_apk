package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$ReportCheckResultReq
  extends MessageMicro
{
  public static final int RPT_MSG_CHECK_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_intchk_id", "rpt_msg_check_result" }, new Object[] { Integer.valueOf(0), null }, ReportCheckResultReq.class);
  public final PBRepeatMessageField rpt_msg_check_result = PBField.initRepeatMessage(intchk.CheckResult.class);
  public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.ims.intchk.ReportCheckResultReq
 * JD-Core Version:    0.7.0.1
 */