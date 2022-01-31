package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8b8$RspBody
  extends MessageMicro
{
  public static final int RPT_UINT32_PIC_LIST_FIELD_NUMBER = 7;
  public static final int UINT32_DEFAULT_ID_FIELD_NUMBER = 5;
  public static final int UINT32_PIC_CNT_FIELD_NUMBER = 6;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 3;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 4;
  public static final int UINT64_GROUP_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_result", "uint64_group_uin", "uint32_sequence", "uint32_subcmd", "uint32_default_id", "uint32_pic_cnt", "rpt_uint32_pic_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatField rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody
 * JD-Core Version:    0.7.0.1
 */