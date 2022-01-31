package msf.onlinepush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import msf.msgcomm.msg_comm.Msg;

public final class msg_onlinepush$PbPushMsg
  extends MessageMicro
{
  public static final int MSG_FIELD_NUMBER = 1;
  public static final int SVRIP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg", "svrip" }, new Object[] { null, Integer.valueOf(0) }, PbPushMsg.class);
  public msg_comm.Msg msg = new msg_comm.Msg();
  public final PBInt32Field svrip = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.onlinepush.msg_onlinepush.PbPushMsg
 * JD-Core Version:    0.7.0.1
 */