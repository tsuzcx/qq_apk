package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x787$ReqBody
  extends MessageMicro
{
  public static final int OPT_FILTER_FIELD_NUMBER = 6;
  public static final int RPT_UIN_LIST_FIELD_NUMBER = 5;
  public static final int UINT64_BEGIN_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_DATA_TIME_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 40, 50 }, new String[] { "uint64_group_code", "uint64_begin_uin", "uint64_data_time", "rpt_uin_list", "opt_filter" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, ReqBody.class);
  public oidb_0x787.Filter opt_filter = new oidb_0x787.Filter();
  public final PBRepeatField rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_begin_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_data_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody
 * JD-Core Version:    0.7.0.1
 */