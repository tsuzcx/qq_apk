package tencent.im.s2c.msgtype0x210.submsgtype0x54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x54$MsgBody$TaskInfo
  extends MessageMicro
{
  public static final int TASK_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "task_id" }, new Object[] { Integer.valueOf(0) }, TaskInfo.class);
  public final PBUInt32Field task_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody.TaskInfo
 * JD-Core Version:    0.7.0.1
 */