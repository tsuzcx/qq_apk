package tencent.im.oidb.oidb_0x8cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8cf$RspBody
  extends MessageMicro
{
  public static final int OPT_UINT64_GROUPCODE_FIELD_NUMBER = 1;
  public static final int RPT_UINT64_APPID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint64_groupcode", "rpt_uint64_appid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
  public final PBUInt64Field opt_uint64_groupcode = PBField.initUInt64(0L);
  public final PBRepeatField rpt_uint64_appid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.RspBody
 * JD-Core Version:    0.7.0.1
 */