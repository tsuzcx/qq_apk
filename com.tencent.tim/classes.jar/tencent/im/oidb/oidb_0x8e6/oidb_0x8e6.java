package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8e6
{
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8e6.LoginSig msg_login_sig = new oidb_0x8e6.LoginSig();
    public final PBRepeatMessageField<oidb_0x8e6.VoteInfo> rpt_vote_info = PBField.initRepeatMessage(oidb_0x8e6.VoteInfo.class);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "rpt_vote_info", "uint32_portal", "uint32_client", "bytes_version", "msg_login_sig" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_level", "uint32_can_vote_free_user_count", "uint32_can_vote_free_count", "uint32_remain_total", "int32_consume_total", "rpt_vote_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
    public final PBInt32Field int32_consume_total = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_0x8e6.VoteResult> rpt_vote_result = PBField.initRepeatMessage(oidb_0x8e6.VoteResult.class);
    public final PBUInt32Field uint32_can_vote_free_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_vote_free_user_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remain_total = PBField.initUInt32(0);
  }
  
  public static final class VoteInfo
    extends MessageMicro<VoteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_tinyid", "uint64_uin", "uint32_free_vote_count", "uint32_pay_vote_count", "uint32_source" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VoteInfo.class);
    public final PBUInt32Field uint32_free_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pay_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class VoteResult
    extends MessageMicro<VoteResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBUInt32Field uint32_succ_free_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_succ_pay_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_pay_stock = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64 }, new String[] { "uint32_ret", "bytes_err_msg", "uint64_tinyid", "uint64_uin", "uint32_vote_count", "uint32_succ_free_vote_count", "uint32_succ_pay_vote_count", "uint64_pay_stock" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, VoteResult.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e6.oidb_0x8e6
 * JD-Core Version:    0.7.0.1
 */