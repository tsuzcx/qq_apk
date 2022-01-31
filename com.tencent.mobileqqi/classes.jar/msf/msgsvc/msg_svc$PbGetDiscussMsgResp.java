package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;

public final class msg_svc$PbGetDiscussMsgResp
  extends MessageMicro
{
  public static final int DISCUSS_INFO_SEQ_FIELD_NUMBER = 8;
  public static final int DISCUSS_UIN_FIELD_NUMBER = 3;
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int LAST_GET_TIME_FIELD_NUMBER = 7;
  public static final int MSG_FIELD_NUMBER = 6;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int RETURN_BEGIN_SEQ_FIELD_NUMBER = 5;
  public static final int RETURN_END_SEQ_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "result", "errmsg", "discuss_uin", "return_end_seq", "return_begin_seq", "msg", "last_get_time", "discuss_info_seq" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L) }, PbGetDiscussMsgResp.class);
  public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
  public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field last_get_time = PBField.initUInt64(0L);
  public final PBRepeatMessageField msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt64Field return_begin_seq = PBField.initUInt64(0L);
  public final PBUInt64Field return_end_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetDiscussMsgResp
 * JD-Core Version:    0.7.0.1
 */