package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xa80
{
  public static final class MemberInfo
    extends MessageMicro<MemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint64_member_uin", "uint64_flag_ex_pos", "uint32_heartbeat_time", "uint64_group_msg_mask", "uint32_group_msg_hide_switch", "uint32_group_msg_preview_switch", "uint32_group_ringtone_switch", "uint32_group_vibrate_switch", "uint32_group_ringtone_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MemberInfo.class);
    public final PBUInt32Field uint32_group_msg_hide_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_msg_preview_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_ringtone_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_ringtone_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_vibrate_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_heartbeat_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_flag_ex_pos = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_msg_mask = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_req_group_info" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xa80.ReqGroupInfo> rpt_msg_req_group_info = PBField.initRepeatMessage(oidb_cmd0xa80.ReqGroupInfo.class);
  }
  
  public static final class ReqGroupInfo
    extends MessageMicro<ReqGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uint64_group_code", "rpt_msg_member_info", "uint32_op", "uint32_client_type", "uint64_root_code" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqGroupInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xa80.MemberInfo> rpt_msg_member_info = PBField.initRepeatMessage(oidb_cmd0xa80.MemberInfo.class);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_root_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_rsp_group_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xa80.RspGroupInfo> rpt_msg_rsp_group_info = PBField.initRepeatMessage(oidb_cmd0xa80.RspGroupInfo.class);
  }
  
  public static final class RspGroupInfo
    extends MessageMicro<RspGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint32_result", "bytes_error_msg" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, RspGroupInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa80.oidb_cmd0xa80
 * JD-Core Version:    0.7.0.1
 */