package tencent.im.s2c.msgtype0x211.submsgtype0x4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.msg.im_msg_body.NotOnlineFile;

public final class SubMsgType0x4$MsgBody
  extends MessageMicro
{
  public static final int MSG_NOT_ONLINE_FILE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_not_online_file" }, new Object[] { null }, MsgBody.class);
  public im_msg_body.NotOnlineFile msg_not_online_file = new im_msg_body.NotOnlineFile();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody
 * JD-Core Version:    0.7.0.1
 */