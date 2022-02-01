package tencent.im.oidb.cmd0xcca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xcca
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_grp_code", "uint64_msg_seq", "uint64_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_grp_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_group_members_num", "uint32_group_friends_num", "friends_uins", "uint32_status" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatField<Long> friends_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_group_friends_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_members_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcca.cmd0xcca
 * JD-Core Version:    0.7.0.1
 */