package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecMsgComu$SecMsg_SSInfo_Item
  extends MessageMicro
{
  public static final int ACTIVE_TS_FIELD_NUMBER = 5;
  public static final int CREATE_TS_FIELD_NUMBER = 4;
  public static final int IDMAP_FIELD_NUMBER = 8;
  public static final int MY_SUID_FIELD_NUMBER = 2;
  public static final int OWNER_SUID_FIELD_NUMBER = 3;
  public static final int PAPER_ID_FIELD_NUMBER = 6;
  public static final int SSID_FIELD_NUMBER = 1;
  public static final int TITLE_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66 }, new String[] { "ssid", "my_suid", "owner_suid", "create_ts", "active_ts", "paper_id", "title", "idmap" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", null }, SecMsg_SSInfo_Item.class);
  public final PBInt64Field active_ts = PBField.initInt64(0L);
  public final PBInt64Field create_ts = PBField.initInt64(0L);
  public final PBRepeatMessageField idmap = PBField.initRepeatMessage(SecMsgComu.SecMsg_IDMap.class);
  public final PBInt64Field my_suid = PBField.initInt64(0L);
  public final PBInt64Field owner_suid = PBField.initInt64(0L);
  public final PBInt64Field paper_id = PBField.initInt64(0L);
  public final PBStringField ssid = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_SSInfo_Item
 * JD-Core Version:    0.7.0.1
 */