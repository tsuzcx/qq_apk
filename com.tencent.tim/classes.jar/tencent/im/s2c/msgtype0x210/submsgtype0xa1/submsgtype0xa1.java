package tencent.im.s2c.msgtype0x210.submsgtype0xa1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xa1
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29, 32, 40 }, new String[] { "uint32_sub_cmd", "uint64_qid", "fixed32_update_time", "uint32_team_created_destroied", "rpt_uint64_office_face_changed_uins" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, MsgBody.class);
    public final PBFixed32Field fixed32_update_time = PBField.initFixed32(0);
    public final PBRepeatField<Long> rpt_uint64_office_face_changed_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_team_created_destroied = PBField.initUInt32(0);
    public final PBUInt64Field uint64_qid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xa1.submsgtype0xa1
 * JD-Core Version:    0.7.0.1
 */