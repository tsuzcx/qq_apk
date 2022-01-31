package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BnrReport$BNReportConfigReq
  extends MessageMicro
{
  public static final int GROUP_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "group_info" }, new Object[] { null }, BNReportConfigReq.class);
  public final PBRepeatMessageField group_info = PBField.initRepeatMessage(BnrReport.BNReportGroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bnr.BnrReport.BNReportConfigReq
 * JD-Core Version:    0.7.0.1
 */