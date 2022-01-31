package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$EqqAccountInfo
  extends MessageMicro
{
  public static final int ACCOUNT_FLAG_FIELD_NUMBER = 9;
  public static final int CERTIFIED_GRADE_FIELD_NUMBER = 5;
  public static final int CONFIG_GROUP_INFO_FIELD_NUMBER = 8;
  public static final int DISPLAY_NUMBER_FIELD_NUMBER = 3;
  public static final int LOGO_FIELD_NUMBER = 6;
  public static final int LUIN_FIELD_NUMBER = 7;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int SUMMARY_FIELD_NUMBER = 4;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66, 72 }, new String[] { "uin", "name", "display_number", "summary", "certified_grade", "logo", "luin", "config_group_info", "account_flag" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Long.valueOf(0L), null, Long.valueOf(0L) }, EqqAccountInfo.class);
  public final PBUInt64Field account_flag = PBField.initUInt64(0L);
  public final PBUInt32Field certified_grade = PBField.initUInt32(0);
  public final PBRepeatMessageField config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
  public final PBStringField display_number = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBStringField summary = PBField.initString("");
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.EqqAccountInfo
 * JD-Core Version:    0.7.0.1
 */