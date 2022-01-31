package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x8fd$ReqBody
  extends MessageMicro
{
  public static final int MSG_REQFILTER_FIELD_NUMBER = 2;
  public static final int RPT_UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "rpt_uint64_group_code", "msg_reqfilter" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public Oidb_0x8fd.ReqFilter msg_reqfilter = new Oidb_0x8fd.ReqFilter();
  public final PBRepeatField rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fd.Oidb_0x8fd.ReqBody
 * JD-Core Version:    0.7.0.1
 */