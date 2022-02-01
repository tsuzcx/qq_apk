package tencent.im.oidb.cmd0x777;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x777
{
  public static final class AddFrdInfo
    extends MessageMicro<AddFrdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uint64_uin", "bytes_remark", "uint32_allow_type", "uint32_send_req_flag", "uint32_send_req_result" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AddFrdInfo.class);
    public final PBStringField bytes_remark = PBField.initString("");
    public final PBUInt32Field uint32_allow_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_req_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_req_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "bytes_msg", "uint32_source_id", "uint32_sub_source_id", "rpt_uint64_uin", "uint64_group_uin" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBStringField bytes_msg = PBField.initString("");
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_add_frd_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x777.AddFrdInfo> rpt_add_frd_info = PBField.initRepeatMessage(cmd0x777.AddFrdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x777.cmd0x777
 * JD-Core Version:    0.7.0.1
 */