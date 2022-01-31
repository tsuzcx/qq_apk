package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$AppointInfo
  extends MessageMicro
{
  public static final int MSG_APPOINTMENT_FIELD_NUMBER = 2;
  public static final int MSG_APPOINT_ID_FIELD_NUMBER = 1;
  public static final int STR_JOIN_WORDING_FIELD_NUMBER = 4;
  public static final int STR_VIEW_WORDING_FIELD_NUMBER = 5;
  public static final int UINT32_APPOINT_STATUS_FIELD_NUMBER = 3;
  public static final int UINT32_JOIN_FIELD_NUMBER = 8;
  public static final int UINT32_OWNER_FIELD_NUMBER = 7;
  public static final int UINT32_UNREAD_COUNT_FIELD_NUMBER = 6;
  public static final int UINT32_VIEW_FIELD_NUMBER = 9;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56, 64, 72 }, new String[] { "msg_appoint_id", "msg_appointment", "uint32_appoint_status", "str_join_wording", "str_view_wording", "uint32_unread_count", "uint32_owner", "uint32_join", "uint32_view" }, new Object[] { null, null, Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AppointInfo.class);
  public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
  public appoint_define.AppointContent msg_appointment = new appoint_define.AppointContent();
  public final PBStringField str_join_wording = PBField.initString("");
  public final PBStringField str_view_wording = PBField.initString("");
  public final PBUInt32Field uint32_appoint_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join = PBField.initUInt32(0);
  public final PBUInt32Field uint32_owner = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_view = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.AppointInfo
 * JD-Core Version:    0.7.0.1
 */