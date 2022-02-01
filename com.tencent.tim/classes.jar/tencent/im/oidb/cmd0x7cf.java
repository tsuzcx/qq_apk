package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7cf
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 800 }, new String[] { "uint32_stamp", "uint32_start", "uint32_want", "uint32_req_valid_only", "rpt_msg_appoint_ids", "uint32_appoint_operation", "uint64_request_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatMessageField<appoint_define.AppointID> rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
    public final PBUInt32Field uint32_appoint_operation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_valid_only = PBField.initUInt32(0);
    public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want = PBField.initUInt32(0);
    public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_stamp", "uint32_over", "uint32_next", "rpt_msg_appoints_info", "uint32_unread_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<appoint_define.AppointInfo> rpt_msg_appoints_info = PBField.initRepeatMessage(appoint_define.AppointInfo.class);
    public final PBUInt32Field uint32_next = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cf
 * JD-Core Version:    0.7.0.1
 */