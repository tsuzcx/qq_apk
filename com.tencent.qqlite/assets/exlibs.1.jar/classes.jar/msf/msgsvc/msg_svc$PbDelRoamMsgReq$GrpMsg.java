package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDelRoamMsgReq$GrpMsg
  extends MessageMicro
{
  public static final int GROUP_CODE_FIELD_NUMBER = 1;
  public static final int MSG_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_code", "msg_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GrpMsg.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDelRoamMsgReq.GrpMsg
 * JD-Core Version:    0.7.0.1
 */