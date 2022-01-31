package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$SystemMsgAction
  extends MessageMicro
{
  public static final int ACTION_FIELD_NUMBER = 3;
  public static final int ACTION_INFO_FIELD_NUMBER = 4;
  public static final int DETAIL_NAME_FIELD_NUMBER = 5;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int RESULT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "name", "result", "action", "action_info", "detail_name" }, new Object[] { "", "", Integer.valueOf(0), null, "" }, SystemMsgAction.class);
  public final PBUInt32Field action = PBField.initUInt32(0);
  public structmsg.SystemMsgActionInfo action_info = new structmsg.SystemMsgActionInfo();
  public final PBStringField detail_name = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField result = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.SystemMsgAction
 * JD-Core Version:    0.7.0.1
 */