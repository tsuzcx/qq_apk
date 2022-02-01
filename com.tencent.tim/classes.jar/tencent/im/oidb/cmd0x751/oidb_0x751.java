package tencent.im.oidb.cmd0x751;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x751
{
  public static final class CheckIsConfMemberResult
    extends MessageMicro<CheckIsConfMemberResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_conf_uin", "uint32_is_conf_member" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, CheckIsConfMemberResult.class);
    public final PBUInt32Field uint32_is_conf_member = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "msg_req_check_is_conf_member" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public oidb_0x751.ReqCheckIsConfMember msg_req_check_is_conf_member = new oidb_0x751.ReqCheckIsConfMember();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class ReqCheckIsConfMember
    extends MessageMicro<ReqCheckIsConfMember>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_conf_uin" }, new Object[] { Long.valueOf(0L) }, ReqCheckIsConfMember.class);
    public final PBRepeatField<Long> rpt_uint64_conf_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x751.RspCheckIsConfMember msg_rsp_check_is_conf_member = new oidb_0x751.RspCheckIsConfMember();
    public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_err_code", "bytes_err_msg", "msg_rsp_check_is_conf_member" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, RspBody.class);
    }
  }
  
  public static final class RspCheckIsConfMember
    extends MessageMicro<RspCheckIsConfMember>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_check_is_conf_member_result" }, new Object[] { null }, RspCheckIsConfMember.class);
    public final PBRepeatMessageField<oidb_0x751.CheckIsConfMemberResult> msg_check_is_conf_member_result = PBField.initRepeatMessage(oidb_0x751.CheckIsConfMemberResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x751.oidb_0x751
 * JD-Core Version:    0.7.0.1
 */