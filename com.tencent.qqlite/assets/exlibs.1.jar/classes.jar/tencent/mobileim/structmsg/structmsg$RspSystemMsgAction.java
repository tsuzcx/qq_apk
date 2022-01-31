package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$RspSystemMsgAction
  extends MessageMicro
{
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int MSG_DETAIL_FIELD_NUMBER = 2;
  public static final int MSG_INVALID_DECIDED_FIELD_NUMBER = 5;
  public static final int REMARK_RESULT_FIELD_NUMBER = 6;
  public static final int TYPE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 42, 48 }, new String[] { "head", "msg_detail", "type", "msg_invalid_decided", "remark_result" }, new Object[] { null, "", Integer.valueOf(0), "", Integer.valueOf(0) }, RspSystemMsgAction.class);
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBStringField msg_detail = PBField.initString("");
  public final PBStringField msg_invalid_decided = PBField.initString("");
  public final PBUInt32Field remark_result = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.RspSystemMsgAction
 * JD-Core Version:    0.7.0.1
 */