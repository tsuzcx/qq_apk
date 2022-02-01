package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiMsg
{
  public static final class ExternMsg
    extends MessageMicro<ExternMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_channel_type" }, new Object[] { Integer.valueOf(0) }, ExternMsg.class);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  }
  
  public static final class Ipv4Info
    extends MessageMicro<Ipv4Info>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_ip_v4_addr", "uint32_ip_v4_port", "uint32_is_https_addr" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Ipv4Info.class);
    public final PBUInt32Field uint32_ip_v4_addr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ip_v4_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_https_addr = PBField.initUInt32(0);
  }
  
  public static final class Ipv6Info
    extends MessageMicro<Ipv6Info>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ip_v6_addr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ip_v6_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_https_addr = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_ip_v6_addr", "uint32_ip_v6_port", "uint32_is_https_addr" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, Ipv6Info.class);
    }
  }
  
  public static final class MultiMsgApplyDownReq
    extends MessageMicro<MultiMsgApplyDownReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<MultiMsg.Ipv4Info> rpt_ip_v4_info = PBField.initRepeatMessage(MultiMsg.Ipv4Info.class);
    public final PBRepeatMessageField<MultiMsg.Ipv6Info> rpt_ip_v6_info = PBField.initRepeatMessage(MultiMsg.Ipv6Info.class);
    public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66 }, new String[] { "bytes_msg_resid", "uint32_msg_type", "uint64_src_uin", "uint32_apply_id", "bytes_msg_key", "bytes_msg_sig", "rpt_ip_v4_info", "rpt_ip_v6_info" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, null, null }, MultiMsgApplyDownReq.class);
    }
  }
  
  public static final class MultiMsgApplyDownRsp
    extends MessageMicro<MultiMsgApplyDownRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public MultiMsg.ExternMsg msg_extern_info = new MultiMsg.ExternMsg();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_down_ip_v6 = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_down_v6_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58, 66, 72, 80 }, new String[] { "uint32_result", "bytes_thumb_down_para", "bytes_msg_key", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_msg_resid", "msg_extern_info", "rpt_bytes_down_ip_v6", "rpt_uint32_down_v6_port", "uint32_apply_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0) }, MultiMsgApplyDownRsp.class);
    }
  }
  
  public static final class MultiMsgApplyUpReq
    extends MessageMicro<MultiMsgApplyUpReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_dst_uin", "uint64_msg_size", "bytes_msg_md5", "uint32_msg_type", "uint32_apply_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, MultiMsgApplyUpReq.class);
    }
  }
  
  public static final class MultiMsgApplyUpRsp
    extends MessageMicro<MultiMsgApplyUpRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public MultiMsg.ExternMsg msg_extern_info = new MultiMsg.ExternMsg();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_up_ip_v6 = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_up_v6_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 90, 98, 104 }, new String[] { "uint32_result", "bytes_msg_resid", "bytes_msg_ukey", "rpt_uint32_up_ip", "rpt_uint32_up_port", "uint64_block_size", "uint64_up_offset", "uint32_apply_id", "bytes_msg_key", "bytes_msg_sig", "msg_extern_info", "rpt_bytes_up_ip_v6", "rpt_uint32_up_v6_port" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5, Integer.valueOf(0) }, MultiMsgApplyUpRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<MultiMsg.MultiMsgApplyDownReq> rpt_multimsg_applydown_req = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyDownReq.class);
    public final PBRepeatMessageField<MultiMsg.MultiMsgApplyUpReq> rpt_multimsg_applyup_req = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyUpReq.class);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 72 }, new String[] { "uint32_subcmd", "uint32_term_type", "uint32_platform_type", "uint32_net_type", "bytes_build_ver", "rpt_multimsg_applyup_req", "rpt_multimsg_applydown_req", "uint32_bu_type", "uint32_req_channel_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_subcmd", "rpt_multimsg_applyup_rsp", "rpt_multimsg_applydown_rsp" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public final PBRepeatMessageField<MultiMsg.MultiMsgApplyDownRsp> rpt_multimsg_applydown_rsp = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyDownRsp.class);
    public final PBRepeatMessageField<MultiMsg.MultiMsgApplyUpRsp> rpt_multimsg_applyup_rsp = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyUpRsp.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg
 * JD-Core Version:    0.7.0.1
 */