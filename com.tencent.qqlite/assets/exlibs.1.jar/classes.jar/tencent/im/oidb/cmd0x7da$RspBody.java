package tencent.im.oidb;

import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x7da$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_APPOINT_INFO_FIELD_NUMBER = 2;
  public static final int STR_WORDING_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_wording", "rpt_msg_appoint_info" }, new Object[] { "", null }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_appoint_info = PBField.initRepeatMessage(appoint_define.AppointInfo.class);
  public final PBStringField str_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7da.RspBody
 * JD-Core Version:    0.7.0.1
 */