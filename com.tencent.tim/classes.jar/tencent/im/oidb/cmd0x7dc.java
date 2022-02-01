package tencent.im.oidb;

import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7dc
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_APPOINTMENT_FIELD_NUMBER = 2;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 3;
    public static final int UINT32_OVERWRITE_FIELD_NUMBER = 4;
    public static final int UINT32_SEQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_seq", "msg_appointment", "msg_lbs_info", "uint32_overwrite" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, ReqBody.class);
    public appoint_define.AppointContent msg_appointment = new appoint_define.AppointContent();
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBUInt32Field uint32_overwrite = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_MSG_APPOINT_INFO_FIELD_NUMBER = 3;
    public static final int STR_WORDING_FIELD_NUMBER = 2;
    public static final int UINT32_SEQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_seq", "str_wording", "rpt_msg_appoint_info" }, new Object[] { Integer.valueOf(0), "", null }, RspBody.class);
    public final PBRepeatMessageField<appoint_define.AppointInfo> rpt_msg_appoint_info = PBField.initRepeatMessage(appoint_define.AppointInfo.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7dc
 * JD-Core Version:    0.7.0.1
 */