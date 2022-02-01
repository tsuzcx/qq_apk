package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x501
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10250 }, new String[] { "msg_subcmd_0x501_req_body" }, new Object[] { null }, ReqBody.class);
    public subcmd0x501.SubCmd0x501ReqBody msg_subcmd_0x501_req_body = new subcmd0x501.SubCmd0x501ReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10250 }, new String[] { "msg_subcmd_0x501_rsp_body" }, new Object[] { null }, RspBody.class);
    public subcmd0x501.SubCmd0x501Rspbody msg_subcmd_0x501_rsp_body = new subcmd0x501.SubCmd0x501Rspbody();
  }
  
  public static final class SubCmd0x501ReqBody
    extends MessageMicro<SubCmd0x501ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_login_sig_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_uint32_service_types = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_sig_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_request_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64 }, new String[] { "uint64_uin", "uint32_idc_id", "uint32_appid", "uint32_login_sig_type", "bytes_login_sig_ticket", "uint32_request_flag", "rpt_uint32_service_types", "uint32_bid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x501ReqBody.class);
    }
  }
  
  public static final class SubCmd0x501Rspbody
    extends MessageMicro<SubCmd0x501Rspbody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_httpconn_sig_session = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<SrvAddrs> rpt_msg_httpconn_addrs = PBField.initRepeatMessage(SrvAddrs.class);
    public final PBUInt32Field uint32_share_channel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_share_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 96, 104 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_share_type", "uint32_share_channel" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x501Rspbody.class);
    }
    
    public static final class IpAddr
      extends MessageMicro<IpAddr>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32 }, new String[] { "uint32_type", "uint32_ip", "uint32_port", "uint32_area" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IpAddr.class);
      public final PBUInt32Field uint32_area = PBField.initUInt32(0);
      public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
      public final PBUInt32Field uint32_port = PBField.initUInt32(0);
      public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }
    
    public static final class SrvAddrs
      extends MessageMicro<SrvAddrs>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_service_type", "rpt_msg_addrs" }, new Object[] { Integer.valueOf(0), null }, SrvAddrs.class);
      public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.IpAddr> rpt_msg_addrs = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.IpAddr.class);
      public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x501
 * JD-Core Version:    0.7.0.1
 */