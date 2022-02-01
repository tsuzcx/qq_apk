package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class MessageOuterClass$TimMsgBody
  extends MessageMicro<TimMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "msg_type", "content", "from_user" }, new Object[] { Integer.valueOf(0), null, null }, TimMsgBody.class);
  public MessageOuterClass.MsgContent content = new MessageOuterClass.MsgContent();
  public CommonOuterClass.QQUserId from_user = new CommonOuterClass.QQUserId();
  public final PBInt32Field msg_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.TimMsgBody
 * JD-Core Version:    0.7.0.1
 */