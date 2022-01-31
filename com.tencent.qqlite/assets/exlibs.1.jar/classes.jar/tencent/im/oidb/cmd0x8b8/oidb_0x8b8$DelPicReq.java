package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8b8$DelPicReq
  extends MessageMicro
{
  public static final int RPT_UINT32_DEL_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_DEL_CNT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_del_cnt", "rpt_uint32_del_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, DelPicReq.class);
  public final PBRepeatField rpt_uint32_del_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_del_cnt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8.DelPicReq
 * JD-Core Version:    0.7.0.1
 */