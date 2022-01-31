package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbSendMsgResp
  extends MessageMicro
{
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SEND_TIME_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "result", "errmsg", "send_time" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, PbSendMsgResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field send_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbSendMsgResp
 * JD-Core Version:    0.7.0.1
 */