package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StructMsg$GetCRMMenuResponse
  extends MessageMicro
{
  public static final int BUTTON_INFO_FIELD_NUMBER = 4;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int SEQNO_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 3;
  public static final int UPDATE_TYPE_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "ret_info", "seqno", "uin", "button_info", "update_type" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, GetCRMMenuResponse.class);
  public final PBRepeatMessageField button_info = PBField.initRepeatMessage(StructMsg.ButtonInfo.class);
  public StructMsg.RetInfo ret_info = new StructMsg.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field update_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse
 * JD-Core Version:    0.7.0.1
 */