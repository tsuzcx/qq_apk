package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7c4$GetRecommendSNFrdListRsp
  extends MessageMicro
{
  public static final int RPT_MSG_ONE_FRD_DATA_FIELD_NUMBER = 5;
  public static final int UINT32_NEXT_START_IDX_FIELD_NUMBER = 4;
  public static final int UINT32_OVER_FIELD_NUMBER = 3;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint32_sequence", "uint32_over", "uint32_next_start_idx", "rpt_msg_one_frd_data" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetRecommendSNFrdListRsp.class);
  public final PBRepeatMessageField rpt_msg_one_frd_data = PBField.initRepeatMessage(cmd0x7c4.OneFrdData.class);
  public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetRecommendSNFrdListRsp
 * JD-Core Version:    0.7.0.1
 */