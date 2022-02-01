package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LongMsg
{
  public static final class MsgDeleteReq
    extends MessageMicro<MsgDeleteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_msg_resid", "uint32_msg_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, MsgDeleteReq.class);
    }
  }
  
  public static final class MsgDeleteRsp
    extends MessageMicro<MsgDeleteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_msg_resid" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgDeleteRsp.class);
    }
  }
  
  public static final class MsgDownReq
    extends MessageMicro<MsgDownReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_cache = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_uin = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_src_uin", "bytes_msg_resid", "uint32_msg_type", "uint32_need_cache" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, MsgDownReq.class);
    }
  }
  
  public static final class MsgDownRsp
    extends MessageMicro<MsgDownRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_msg_resid", "bytes_msg_content" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, MsgDownRsp.class);
    }
  }
  
  public static final class MsgUpReq
    extends MessageMicro<MsgUpReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_cache = PBField.initUInt32(0);
    public final PBUInt32Field uint32_store_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "uint32_msg_type", "uint64_dst_uin", "uint32_msg_id", "bytes_msg_content", "uint32_store_type", "bytes_msg_ukey", "uint32_need_cache" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, MsgUpReq.class);
    }
  }
  
  public static final class MsgUpRsp
    extends MessageMicro<MsgUpRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_result", "uint32_msg_id", "bytes_msg_resid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, MsgUpRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 80 }, new String[] { "uint32_subcmd", "uint32_term_type", "uint32_platform_type", "rpt_msg_up_req", "rpt_msg_down_req", "rpt_msg_del_req", "uint32_agent_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<LongMsg.MsgDeleteReq> rpt_msg_del_req = PBField.initRepeatMessage(LongMsg.MsgDeleteReq.class);
    public final PBRepeatMessageField<LongMsg.MsgDownReq> rpt_msg_down_req = PBField.initRepeatMessage(LongMsg.MsgDownReq.class);
    public final PBRepeatMessageField<LongMsg.MsgUpReq> rpt_msg_up_req = PBField.initRepeatMessage(LongMsg.MsgUpReq.class);
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "rpt_msg_up_rsp", "rpt_msg_down_rsp", "rpt_msg_del_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public final PBRepeatMessageField<LongMsg.MsgDeleteRsp> rpt_msg_del_rsp = PBField.initRepeatMessage(LongMsg.MsgDeleteRsp.class);
    public final PBRepeatMessageField<LongMsg.MsgDownRsp> rpt_msg_down_rsp = PBField.initRepeatMessage(LongMsg.MsgDownRsp.class);
    public final PBRepeatMessageField<LongMsg.MsgUpRsp> rpt_msg_up_rsp = PBField.initRepeatMessage(LongMsg.MsgUpRsp.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.longconn.longmsg.LongMsg
 * JD-Core Version:    0.7.0.1
 */