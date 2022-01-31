package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8b8$ModifyOrderReq
  extends MessageMicro
{
  public static final int RPT_UINT32_PIC_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_PIC_CNT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_pic_cnt", "rpt_uint32_pic_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ModifyOrderReq.class);
  public final PBRepeatField rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ModifyOrderReq
 * JD-Core Version:    0.7.0.1
 */