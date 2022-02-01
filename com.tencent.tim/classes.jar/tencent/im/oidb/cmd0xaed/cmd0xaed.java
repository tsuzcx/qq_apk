package tencent.im.oidb.cmd0xaed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xaed
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_qq_uin", "rpt_uint64_add_qim_uins" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_add_qim_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_succ_qim_uins" }, new Object[] { Long.valueOf(0L) }, RspBody.class);
    public final PBRepeatField<Long> rpt_uint64_succ_qim_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaed.cmd0xaed
 * JD-Core Version:    0.7.0.1
 */