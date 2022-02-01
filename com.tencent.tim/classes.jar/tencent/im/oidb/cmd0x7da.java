package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7da
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_msg_appoint_ids", "uint32_appoint_operation", "uint32_operation_reason", "uint32_overwrite" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<appoint_define.AppointID> rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
    public final PBUInt32Field uint32_appoint_operation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_operation_reason = PBField.initUInt32(0);
    public final PBUInt32Field uint32_overwrite = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_wording", "rpt_msg_appoint_info", "uint32_operation_reason" }, new Object[] { "", null, Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<appoint_define.AppointInfo> rpt_msg_appoint_info = PBField.initRepeatMessage(appoint_define.AppointInfo.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_operation_reason = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7da
 * JD-Core Version:    0.7.0.1
 */