package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88d$GroupHeadPortrait
  extends MessageMicro
{
  public static final int RPT_MSG_INFO_FIELD_NUMBER = 2;
  public static final int UINT32_DEFAULT_ID_FIELD_NUMBER = 3;
  public static final int UINT32_PIC_CNT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_pic_cnt", "rpt_msg_info", "uint32_default_id" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, GroupHeadPortrait.class);
  public final PBRepeatMessageField rpt_msg_info = PBField.initRepeatMessage(oidb_0x88d.GroupHeadPortraitInfo.class);
  public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait
 * JD-Core Version:    0.7.0.1
 */