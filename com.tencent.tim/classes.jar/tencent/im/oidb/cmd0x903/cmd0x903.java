package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x903
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "opt_msg_check_forbit_group_req", "opt_msg_get_invited_uin_list_req", "uint32_client_type", "uint32_client_version" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public cmd0x903.SubCmd0x1Req opt_msg_check_forbit_group_req = new cmd0x903.SubCmd0x1Req();
    public cmd0x903.SubCmd0x2Req opt_msg_get_invited_uin_list_req = new cmd0x903.SubCmd0x2Req();
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x903.SubCmd0x1Rsp opt_msg_check_forbit_group_rsp = new cmd0x903.SubCmd0x1Rsp();
    public cmd0x903.SubCmd0x2Rsp opt_msg_get_invited_uin_list_rsp = new cmd0x903.SubCmd0x2Rsp();
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "opt_uint32_result", "opt_bytes_errmsg", "opt_msg_check_forbit_group_rsp", "opt_msg_get_invited_uin_list_rsp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null }, RspBody.class);
    }
  }
  
  public static final class SubCmd0x1Req
    extends MessageMicro<SubCmd0x1Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_group_code" }, new Object[] { Long.valueOf(0L) }, SubCmd0x1Req.class);
    public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class SubCmd0x1Rsp
    extends MessageMicro<SubCmd0x1Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_group_code" }, new Object[] { Long.valueOf(0L) }, SubCmd0x1Rsp.class);
    public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class SubCmd0x2Req
    extends MessageMicro<SubCmd0x2Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint64_group_code", "uint64_req_start_time", "uint32_uin_num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, SubCmd0x2Req.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_uin_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_start_time = PBField.initUInt64(0L);
  }
  
  public static final class SubCmd0x2Rsp
    extends MessageMicro<SubCmd0x2Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "rpt_uint64_uin", "opt_uint64_group_code", "uint64_rsp_end_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, SubCmd0x2Rsp.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_rsp_end_time = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x903.cmd0x903
 * JD-Core Version:    0.7.0.1
 */