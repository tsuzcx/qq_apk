package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_Msg_Item
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 6;
  public static final int FROM_SUID_FIELD_NUMBER = 3;
  public static final int SEQ_FIELD_NUMBER = 1;
  public static final int SSID_FIELD_NUMBER = 4;
  public static final int TS_FIELD_NUMBER = 5;
  public static final int TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "seq", "type", "from_suid", "ssid", "ts", "content" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Long.valueOf(0L), "" }, SecMsg_Msg_Item.class);
  public final PBStringField content = PBField.initString("");
  public final PBInt64Field from_suid = PBField.initInt64(0L);
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBStringField ssid = PBField.initString("");
  public final PBInt64Field ts = PBField.initInt64(0L);
  public final PBInt64Field type = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_Msg_Item
 * JD-Core Version:    0.7.0.1
 */