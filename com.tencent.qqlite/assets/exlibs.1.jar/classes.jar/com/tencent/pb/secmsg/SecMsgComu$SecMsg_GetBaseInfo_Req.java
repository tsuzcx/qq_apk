package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SecMsgComu$SecMsg_GetBaseInfo_Req
  extends MessageMicro
{
  public static final int MASK_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "mask" }, new Object[] { Long.valueOf(0L) }, SecMsg_GetBaseInfo_Req.class);
  public final PBUInt64Field mask = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetBaseInfo_Req
 * JD-Core Version:    0.7.0.1
 */