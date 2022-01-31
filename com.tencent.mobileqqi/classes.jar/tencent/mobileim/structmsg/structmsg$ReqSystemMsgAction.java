package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqSystemMsgAction
  extends MessageMicro
{
  public static final int ACTION_INFO_FIELD_NUMBER = 8;
  public static final int GROUP_MSG_TYPE_FIELD_NUMBER = 7;
  public static final int LANGUAGE_FIELD_NUMBER = 9;
  public static final int MSG_SEQ_FIELD_NUMBER = 2;
  public static final int MSG_TYPE_FIELD_NUMBER = 1;
  public static final int REQ_UIN_FIELD_NUMBER = 3;
  public static final int SRC_ID_FIELD_NUMBER = 5;
  public static final int SUB_SRC_ID_FIELD_NUMBER = 6;
  public static final int SUB_TYPE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "msg_type", "msg_seq", "req_uin", "sub_type", "src_id", "sub_src_id", "group_msg_type", "action_info", "language" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, ReqSystemMsgAction.class);
  public structmsg.SystemMsgActionInfo action_info = new structmsg.SystemMsgActionInfo();
  public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field language = PBField.initUInt32(0);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBEnumField msg_type = PBField.initEnum(1);
  public final PBUInt64Field req_uin = PBField.initUInt64(0L);
  public final PBUInt32Field src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.ReqSystemMsgAction
 * JD-Core Version:    0.7.0.1
 */