package tencent.im.s2c.msgtype0x210.submsgtype0x54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x54
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_DISCUSS = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "peer_type", "peer_uin", "task_list" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null }, MsgBody.class);
    public final PBEnumField peer_type = PBField.initEnum(1);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBRepeatMessageField<TaskInfo> task_list = PBField.initRepeatMessage(TaskInfo.class);
    
    public static final class TaskInfo
      extends MessageMicro<TaskInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "task_id" }, new Object[] { Integer.valueOf(0) }, TaskInfo.class);
      public final PBUInt32Field task_id = PBField.initUInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54
 * JD-Core Version:    0.7.0.1
 */