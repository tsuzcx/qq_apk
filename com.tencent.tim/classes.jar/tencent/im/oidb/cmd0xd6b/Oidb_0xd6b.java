package tencent.im.oidb.cmd0xd6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.mutualmark.mutualmark.MutualMark;

public final class Oidb_0xd6b
{
  public static final class MutualMarkData
    extends MessageMicro<MutualMarkData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint64_frd_uin", "uint32_result", "mutualmark_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, MutualMarkData.class);
    public final PBRepeatMessageField<mutualmark.MutualMark> mutualmark_info = PBField.initRepeatMessage(mutualmark.MutualMark.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 88 }, new String[] { "max_pkg_size", "start_time", "rpt_uin_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt32Field max_pkg_size = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 96 }, new String[] { "rpt_msg_mutualmark_data", "rpt_uint64_unfinished_uins" }, new Object[] { null, Long.valueOf(0L) }, RspBody.class);
    public final PBRepeatMessageField<Oidb_0xd6b.MutualMarkData> rpt_msg_mutualmark_data = PBField.initRepeatMessage(Oidb_0xd6b.MutualMarkData.class);
    public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd6b.Oidb_0xd6b
 * JD-Core Version:    0.7.0.1
 */