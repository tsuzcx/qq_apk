package tencent.im.oidb.cmd0x72d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x72d
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_groupcode" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_groupcode = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint32_ret_code", "rpt_uint64_groupcode", "opt_uint64_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
    public final PBUInt32Field opt_uint32_ret_code = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_timestamp = PBField.initUInt64(0L);
    public final PBRepeatField<Long> rpt_uint64_groupcode = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x72d.cmd0x72d
 * JD-Core Version:    0.7.0.1
 */