package com.tencent.mobileqq.highway.protocol;

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
    public static final int MSG_SUBCMD_0X501_REQ_BODY_FIELD_NUMBER = 1281;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10250 }, new String[] { "msg_subcmd_0x501_req_body" }, new Object[] { null }, ReqBody.class);
    public subcmd0x501.SubCmd0x501ReqBody msg_subcmd_0x501_req_body = new subcmd0x501.SubCmd0x501ReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_SUBCMD_0X501_RSP_BODY_FIELD_NUMBER = 1281;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10250 }, new String[] { "msg_subcmd_0x501_rsp_body" }, new Object[] { null }, RspBody.class);
    public subcmd0x501.SubCmd0x501Rspbody msg_subcmd_0x501_rsp_body = new subcmd0x501.SubCmd0x501Rspbody();
  }
  
  public static final class SubCmd0x501ReqBody
    extends MessageMicro<SubCmd0x501ReqBody>
  {
    public static final int BYTES_LOGIN_SIG_TICKET_FIELD_NUMBER = 5;
    public static final int RPT_UINT32_SERVICE_TYPES_FIELD_NUMBER = 7;
    public static final int UINT32_APPID_FIELD_NUMBER = 3;
    public static final int UINT32_BID_FIELD_NUMBER = 8;
    public static final int UINT32_CALLER_FIELD_NUMBER = 12;
    public static final int UINT32_IDC_ID_FIELD_NUMBER = 2;
    public static final int UINT32_LOGIN_SIG_TYPE_FIELD_NUMBER = 4;
    public static final int UINT32_NET_FIELD_NUMBER = 11;
    public static final int UINT32_PLAT_FIELD_NUMBER = 10;
    public static final int UINT32_REQUEST_FLAG_FIELD_NUMBER = 6;
    public static final int UINT32_TERM_FIELD_NUMBER = 9;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_login_sig_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_uint32_service_types = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_caller = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_sig_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net = PBField.initUInt32(0);
    public final PBUInt32Field uint32_plat = PBField.initUInt32(0);
    public final PBUInt32Field uint32_request_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88, 96 }, new String[] { "uint64_uin", "uint32_idc_id", "uint32_appid", "uint32_login_sig_type", "bytes_login_sig_ticket", "uint32_request_flag", "rpt_uint32_service_types", "uint32_bid", "uint32_term", "uint32_plat", "uint32_net", "uint32_caller" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x501ReqBody.class);
    }
  }
  
  public static final class SubCmd0x501Rspbody
    extends MessageMicro<SubCmd0x501Rspbody>
  {
    public static final int BYTES_HTTPCONN_SIG_SESSION_FIELD_NUMBER = 1;
    public static final int BYTES_SESSION_KEY_FIELD_NUMBER = 2;
    public static final int RPT_MSG_HTTPCONN_ADDRS_FIELD_NUMBER = 3;
    public static final int UINT32_PRE_CONNECTION_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_httpconn_sig_session = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<SrvAddrs> rpt_msg_httpconn_addrs = PBField.initRepeatMessage(SrvAddrs.class);
    public final PBUInt32Field uint32_pre_connection = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_pre_connection" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, SubCmd0x501Rspbody.class);
    }
    
    public static final class IpAddr
      extends MessageMicro<IpAddr>
    {
      public static final int UINT32_AREA_FIELD_NUMBER = 4;
      public static final int UINT32_IP_FIELD_NUMBER = 2;
      public static final int UINT32_PORT_FIELD_NUMBER = 3;
      public static final int UINT32_TYPE_FIELD_NUMBER = 1;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32 }, new String[] { "uint32_type", "uint32_ip", "uint32_port", "uint32_area" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IpAddr.class);
      public final PBUInt32Field uint32_area = PBField.initUInt32(0);
      public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
      public final PBUInt32Field uint32_port = PBField.initUInt32(0);
      public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }
    
    public static final class NetSegConf
      extends MessageMicro<NetSegConf>
    {
      public static final int UINT32_CURCONNNUM_FIELD_NUMBER = 4;
      public static final int UINT32_NET_TYPE_FIELD_NUMBER = 1;
      public static final int UINT32_SEGNUM_FIELD_NUMBER = 3;
      public static final int UINT32_SEGSIZE_FIELD_NUMBER = 2;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_net_type", "uint32_segsize", "uint32_segnum", "uint32_curconnnum" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NetSegConf.class);
      public final PBUInt32Field uint32_curconnnum = PBField.initUInt32(0);
      public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_segnum = PBField.initUInt32(0);
      public final PBUInt32Field uint32_segsize = PBField.initUInt32(0);
    }
    
    public static final class SrvAddrs
      extends MessageMicro<SrvAddrs>
    {
      public static final int RPT_MSG_ADDRS_FIELD_NUMBER = 2;
      public static final int RPT_MSG_NETSEGCONF_FIELD_NUMBER = 4;
      public static final int UINT32_FRAGMENT_SIZE_FIELD_NUMBER = 3;
      public static final int UINT32_SERVICE_TYPE_FIELD_NUMBER = 1;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_service_type", "rpt_msg_addrs", "uint32_fragment_size", "rpt_msg_netsegconf" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), null }, SrvAddrs.class);
      public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.IpAddr> rpt_msg_addrs = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.IpAddr.class);
      public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.NetSegConf.class);
      public final PBUInt32Field uint32_fragment_size = PBField.initUInt32(0);
      public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501
 * JD-Core Version:    0.7.0.1
 */