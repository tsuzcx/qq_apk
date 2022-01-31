package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class EmosmPb$SubCmd0x9BqAssocRsp
  extends MessageMicro
{
  public static final int RPT_ASSOC_BQS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_assoc_bqs" }, new Object[] { null }, SubCmd0x9BqAssocRsp.class);
  public final PBRepeatMessageField rpt_assoc_bqs = PBField.initRepeatMessage(EmosmPb.BqAssocInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocRsp
 * JD-Core Version:    0.7.0.1
 */