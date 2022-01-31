package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbDeleteMsgReq
  extends MessageMicro
{
  public static final int MSGITEMS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msgItems" }, new Object[] { null }, PbDeleteMsgReq.class);
  public final PBRepeatMessageField msgItems = PBField.initRepeatMessage(msg_svc.PbDeleteMsgReq.MsgItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDeleteMsgReq
 * JD-Core Version:    0.7.0.1
 */