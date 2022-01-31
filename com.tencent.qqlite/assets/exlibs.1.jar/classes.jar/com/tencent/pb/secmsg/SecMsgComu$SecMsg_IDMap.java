package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class SecMsgComu$SecMsg_IDMap
  extends MessageMicro
{
  public static final int SUID_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "suid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, SecMsg_IDMap.class);
  public final PBInt64Field suid = PBField.initInt64(0L);
  public final PBInt64Field uin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_IDMap
 * JD-Core Version:    0.7.0.1
 */