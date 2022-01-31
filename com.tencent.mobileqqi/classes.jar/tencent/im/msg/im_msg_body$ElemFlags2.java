package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$ElemFlags2
  extends MessageMicro
{
  public static final int RPT_INSTS_FIELD_NUMBER = 7;
  public static final int SRC_INST_FIELD_NUMBER = 9;
  public static final int UINT32_COLOR_TEXT_ID_FIELD_NUMBER = 1;
  public static final int UINT32_COMPATIBLE_ID_FIELD_NUMBER = 6;
  public static final int UINT32_MSG_RPT_CNT_FIELD_NUMBER = 8;
  public static final int UINT32_PTT_CHANGE_BIT_FIELD_NUMBER = 4;
  public static final int UINT32_VIP_STATUS_FIELD_NUMBER = 5;
  public static final int UINT32_WHISPER_SESSION_ID_FIELD_NUMBER = 3;
  public static final int UINT64_MSG_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 74 }, new String[] { "uint32_color_text_id", "uint64_msg_id", "uint32_whisper_session_id", "uint32_ptt_change_bit", "uint32_vip_status", "uint32_compatible_id", "rpt_insts", "uint32_msg_rpt_cnt", "src_inst" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null }, ElemFlags2.class);
  public final PBRepeatMessageField rpt_insts = PBField.initRepeatMessage(im_msg_body.ElemFlags2.Inst.class);
  public im_msg_body.ElemFlags2.Inst src_inst = new im_msg_body.ElemFlags2.Inst();
  public final PBUInt32Field uint32_color_text_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_compatible_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_rpt_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_change_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_whisper_session_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msg_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ElemFlags2
 * JD-Core Version:    0.7.0.1
 */