package tencent.qun.group_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_activity$GroupAct
  extends MessageMicro
{
  public static final int STRING_BTNTEXT_FIELD_NUMBER = 8;
  public static final int STRING_DES_FIELD_NUMBER = 3;
  public static final int STRING_ICONURL_FIELD_NUMBER = 7;
  public static final int STRING_JUMPPARAM_FIELD_NUMBER = 6;
  public static final int STRING_TITLE_FIELD_NUMBER = 2;
  public static final int STRING_URL_FIELD_NUMBER = 4;
  public static final int UINT32_ACT_ID_FIELD_NUMBER = 1;
  public static final int UINT32_END_TIME_FIELD_NUMBER = 10;
  public static final int UINT32_JUMPTYPE_FIELD_NUMBER = 5;
  public static final int UINT32_START_TIME_FIELD_NUMBER = 9;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 72, 80 }, new String[] { "uint32_act_id", "string_title", "string_des", "string_url", "uint32_jumptype", "string_jumpparam", "string_iconurl", "string_btntext", "uint32_start_time", "uint32_end_time" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, GroupAct.class);
  public final PBStringField string_btntext = PBField.initString("");
  public final PBStringField string_des = PBField.initString("");
  public final PBStringField string_iconurl = PBField.initString("");
  public final PBStringField string_jumpparam = PBField.initString("");
  public final PBStringField string_title = PBField.initString("");
  public final PBStringField string_url = PBField.initString("");
  public final PBUInt32Field uint32_act_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jumptype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.qun.group_activity.group_activity.GroupAct
 * JD-Core Version:    0.7.0.1
 */