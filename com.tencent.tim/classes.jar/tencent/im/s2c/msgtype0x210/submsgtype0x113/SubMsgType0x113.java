package tencent.im.s2c.msgtype0x210.submsgtype0x113;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class SubMsgType0x113
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int TASK_OP_RECALL = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_app_id", "int32_task_id", "enum_task_op" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) }, MsgBody.class);
    public final PBEnumField enum_task_op = PBField.initEnum(1);
    public final PBInt32Field int32_app_id = PBField.initInt32(0);
    public final PBInt32Field int32_task_id = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x113.SubMsgType0x113
 * JD-Core Version:    0.7.0.1
 */