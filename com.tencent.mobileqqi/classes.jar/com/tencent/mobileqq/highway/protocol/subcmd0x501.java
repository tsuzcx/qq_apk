package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
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
    public static final int MSG_DOWNLOAD_ENCRYPT_CONF_FIELD_NUMBER = 9;
    public static final int MSG_DYN_TIMEOUT_CONF_FIELD_NUMBER = 7;
    public static final int MSG_IP_LEARN_CONF_FIELD_NUMBER = 6;
    public static final int MSG_OPEN_UP_CONF_FIELD_NUMBER = 8;
    public static final int MSG_SHORT_VIDEO_CONF_FIELD_NUMBER = 10;
    public static final int RPT_MSG_HTTPCONN_ADDRS_FIELD_NUMBER = 3;
    public static final int UINT32_CS_CONN_FIELD_NUMBER = 5;
    public static final int UINT32_PRE_CONNECTION_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_httpconn_sig_session = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public DownloadEncryptConf msg_download_encrypt_conf = new DownloadEncryptConf();
    public DynTimeOutConf msg_dyn_timeout_conf = new DynTimeOutConf();
    public IpLearnConf msg_ip_learn_conf = new IpLearnConf();
    public OpenUpConf msg_open_up_conf = new OpenUpConf();
    public ShortVideoConf msg_short_video_conf = new ShortVideoConf();
    public final PBRepeatMessageField<SrvAddrs> rpt_msg_httpconn_addrs = PBField.initRepeatMessage(SrvAddrs.class);
    public final PBUInt32Field uint32_cs_conn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pre_connection = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 66, 74, 82 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_pre_connection", "uint32_cs_conn", "msg_ip_learn_conf", "msg_dyn_timeout_conf", "msg_open_up_conf", "msg_download_encrypt_conf", "msg_short_video_conf" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, SubCmd0x501Rspbody.class);
    }
    
    public static final class DownloadEncryptConf
      extends MessageMicro<DownloadEncryptConf>
    {
      public static final int BOOL_ENABLE_ENCRYPTED_PIC_FIELD_NUMBER = 2;
      public static final int BOOL_ENABLE_ENCRYPT_REQUEST_FIELD_NUMBER = 1;
      public static final int UINT32_CTRL_FLAG_FIELD_NUMBER = 3;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bool_enable_encrypt_request", "bool_enable_encrypted_pic", "uint32_ctrl_flag" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0) }, DownloadEncryptConf.class);
      public final PBBoolField bool_enable_encrypt_request = PBField.initBool(false);
      public final PBBoolField bool_enable_encrypted_pic = PBField.initBool(false);
      public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
    }
    
    public static final class DynTimeOutConf
      extends MessageMicro<DynTimeOutConf>
    {
      public static final int UINT32_ENABLE_DYN_TIMEOUT_FIELD_NUMBER = 10;
      public static final int UINT32_HB_TIMEOUT_2G_FIELD_NUMBER = 15;
      public static final int UINT32_HB_TIMEOUT_3G_FIELD_NUMBER = 16;
      public static final int UINT32_HB_TIMEOUT_4G_FIELD_NUMBER = 17;
      public static final int UINT32_HB_TIMEOUT_DEFAULT_FIELD_NUMBER = 19;
      public static final int UINT32_HB_TIMEOUT_WIFI_FIELD_NUMBER = 18;
      public static final int UINT32_MAX_TIMEOUT_2G_FIELD_NUMBER = 11;
      public static final int UINT32_MAX_TIMEOUT_3G_FIELD_NUMBER = 12;
      public static final int UINT32_MAX_TIMEOUT_4G_FIELD_NUMBER = 13;
      public static final int UINT32_MAX_TIMEOUT_FIELD_NUMBER = 9;
      public static final int UINT32_MAX_TIMEOUT_WIFI_FIELD_NUMBER = 14;
      public static final int UINT32_TBASE_2G_FIELD_NUMBER = 1;
      public static final int UINT32_TBASE_3G_FIELD_NUMBER = 2;
      public static final int UINT32_TBASE_4G_FIELD_NUMBER = 3;
      public static final int UINT32_TBASE_WIFI_FIELD_NUMBER = 4;
      public static final int UINT32_TORG_2G_FIELD_NUMBER = 5;
      public static final int UINT32_TORG_3G_FIELD_NUMBER = 6;
      public static final int UINT32_TORG_4G_FIELD_NUMBER = 7;
      public static final int UINT32_TORG_WIFI_FIELD_NUMBER = 8;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152 }, new String[] { "uint32_tbase_2g", "uint32_tbase_3g", "uint32_tbase_4g", "uint32_tbase_wifi", "uint32_torg_2g", "uint32_torg_3g", "uint32_torg_4g", "uint32_torg_wifi", "uint32_max_timeout", "uint32_enable_dyn_timeout", "uint32_max_timeout_2g", "uint32_max_timeout_3g", "uint32_max_timeout_4g", "uint32_max_timeout_wifi", "uint32_hb_timeout_2g", "uint32_hb_timeout_3g", "uint32_hb_timeout_4g", "uint32_hb_timeout_wifi", "uint32_hb_timeout_default" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DynTimeOutConf.class);
      public final PBUInt32Field uint32_enable_dyn_timeout = PBField.initUInt32(0);
      public final PBUInt32Field uint32_hb_timeout_2g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_hb_timeout_3g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_hb_timeout_4g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_hb_timeout_default = PBField.initUInt32(0);
      public final PBUInt32Field uint32_hb_timeout_wifi = PBField.initUInt32(0);
      public final PBUInt32Field uint32_max_timeout = PBField.initUInt32(0);
      public final PBUInt32Field uint32_max_timeout_2g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_max_timeout_3g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_max_timeout_4g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_max_timeout_wifi = PBField.initUInt32(0);
      public final PBUInt32Field uint32_tbase_2g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_tbase_3g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_tbase_4g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_tbase_wifi = PBField.initUInt32(0);
      public final PBUInt32Field uint32_torg_2g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_torg_3g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_torg_4g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_torg_wifi = PBField.initUInt32(0);
    }
    
    public static final class IpAddr
      extends MessageMicro<IpAddr>
    {
      public static final int UINT32_AREA_FIELD_NUMBER = 4;
      public static final int UINT32_IP_FIELD_NUMBER = 2;
      public static final int UINT32_PORT_FIELD_NUMBER = 3;
      public static final int UINT32_SAME_ISP_FIELD_NUMBER = 5;
      public static final int UINT32_TYPE_FIELD_NUMBER = 1;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40 }, new String[] { "uint32_type", "uint32_ip", "uint32_port", "uint32_area", "uint32_same_isp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IpAddr.class);
      public final PBUInt32Field uint32_area = PBField.initUInt32(0);
      public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
      public final PBUInt32Field uint32_port = PBField.initUInt32(0);
      public final PBUInt32Field uint32_same_isp = PBField.initUInt32(0);
      public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }
    
    public static final class IpLearnConf
      extends MessageMicro<IpLearnConf>
    {
      public static final int UINT32_ENABLE_IP_LEARN_FIELD_NUMBER = 2;
      public static final int UINT32_REFRESH_CACHED_IP_FIELD_NUMBER = 1;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_refresh_cached_ip", "uint32_enable_ip_learn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, IpLearnConf.class);
      public final PBUInt32Field uint32_enable_ip_learn = PBField.initUInt32(0);
      public final PBUInt32Field uint32_refresh_cached_ip = PBField.initUInt32(0);
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
    
    public static final class OpenUpConf
      extends MessageMicro<OpenUpConf>
    {
      public static final int BOOL_ENABLE_OPENUP_FIELD_NUMBER = 1;
      public static final int UINT32_PRE_SEND_SEGNUM_3G_FIELD_NUMBER = 3;
      public static final int UINT32_PRE_SEND_SEGNUM_4G_FIELD_NUMBER = 4;
      public static final int UINT32_PRE_SEND_SEGNUM_FIELD_NUMBER = 2;
      public static final int UINT32_PRE_SEND_SEGNUM_WIFI_FIELD_NUMBER = 5;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "bool_enable_openup", "uint32_pre_send_segnum", "uint32_pre_send_segnum_3g", "uint32_pre_send_segnum_4g", "uint32_pre_send_segnum_wifi" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, OpenUpConf.class);
      public final PBBoolField bool_enable_openup = PBField.initBool(false);
      public final PBUInt32Field uint32_pre_send_segnum = PBField.initUInt32(0);
      public final PBUInt32Field uint32_pre_send_segnum_3g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_pre_send_segnum_4g = PBField.initUInt32(0);
      public final PBUInt32Field uint32_pre_send_segnum_wifi = PBField.initUInt32(0);
    }
    
    public static final class ShortVideoConf
      extends MessageMicro<ShortVideoConf>
    {
      public static final int BOOL_OPEN_HARDWARE_CODEC_FIELD_NUMBER = 3;
      public static final int CHANNEL_TYPE_NEW = 2;
      public static final int CHANNEL_TYPE_OLD = 1;
      public static final int CHANNEL_TYPE_TRANSFER_WHILE_RECORDING = 3;
      public static final int RPT_MSG_NETSEGCONF_FIELD_NUMBER = 2;
      public static final int UINT32_CHANNEL_TYPE_FIELD_NUMBER = 1;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_channel_type", "rpt_msg_netsegconf", "bool_open_hardware_codec" }, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(false) }, ShortVideoConf.class);
      public final PBBoolField bool_open_hardware_codec = PBField.initBool(false);
      public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.NetSegConf.class);
      public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501
 * JD-Core Version:    0.7.0.1
 */