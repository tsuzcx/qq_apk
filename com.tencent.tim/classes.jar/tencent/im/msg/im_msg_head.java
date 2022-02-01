package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_head
{
  public static final class C2CHead
    extends MessageMicro<C2CHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auth_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_auth_pic_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_auth_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField string_phone_number = PBField.initString("");
    public final PBUInt32Field uint32_cc_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cc_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 72, 80, 90 }, new String[] { "uint64_to_uin", "uint64_from_uin", "uint32_cc_type", "uint32_cc_cmd", "bytes_auth_pic_sig", "bytes_auth_sig", "bytes_auth_buf", "uint32_server_time", "uint32_client_time", "uint32_rand", "string_phone_number" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, C2CHead.class);
    }
  }
  
  public static final class CSHead
    extends MessageMicro<CSHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 85, 88, 101, 104, 117, 120, 133, 136, 149, 152, 160, 168, 176, 184, 192 }, new String[] { "uint64_uin", "uint32_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pubno", "uint32_localid", "uint32_timezone", "uint32_client_ip", "uint32_client_port", "uint32_conn_ip", "uint32_conn_port", "uint32_interface_ip", "uint32_interface_port", "uint32_actual_ip", "uint32_flag", "uint32_timestamp", "uint32_subcmd", "uint32_result", "uint32_app_id", "uint32_instance_id", "uint64_session_id", "uint32_idc_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, CSHead.class);
    public final PBFixed32Field uint32_actual_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_command = PBField.initUInt32(0);
    public final PBFixed32Field uint32_conn_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_conn_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    public final PBFixed32Field uint32_interface_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_interface_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_localid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pubno = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBFixed32Field uint32_timestamp = PBField.initFixed32(0);
    public final PBUInt32Field uint32_timezone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class DeltaHead
    extends MessageMicro<DeltaHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ack_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ack_offset = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_offset = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_len = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56 }, new String[] { "uint64_total_len", "uint64_offset", "uint64_ack_offset", "bytes_cookie", "bytes_ack_cookie", "uint32_result", "uint32_flags" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, DeltaHead.class);
    }
  }
  
  public static final class Head
    extends MessageMicro<Head>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 82 }, new String[] { "uint32_head_type", "msg_cs_head", "msg_s2c_head", "msg_httpconn_head", "uint32_paint_flag", "msg_login_sig", "msg_delta_head", "msg_c2c_head", "msg_sconn_head", "msg_inst_ctrl" }, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), null, null, null, null, null }, Head.class);
    public im_msg_head.C2CHead msg_c2c_head = new im_msg_head.C2CHead();
    public im_msg_head.CSHead msg_cs_head = new im_msg_head.CSHead();
    public im_msg_head.DeltaHead msg_delta_head = new im_msg_head.DeltaHead();
    public im_msg_head.HttpConnHead msg_httpconn_head = new im_msg_head.HttpConnHead();
    public im_msg_head.InstCtrl msg_inst_ctrl = new im_msg_head.InstCtrl();
    public im_msg_head.LoginSig msg_login_sig = new im_msg_head.LoginSig();
    public im_msg_head.S2CHead msg_s2c_head = new im_msg_head.S2CHead();
    public im_msg_head.SConnHead msg_sconn_head = new im_msg_head.SConnHead();
    public final PBUInt32Field uint32_head_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_paint_flag = PBField.initUInt32(0);
  }
  
  public static final class HttpConnHead
    extends MessageMicro<HttpConnHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_msg_head.TransOidbHead msg_oidbhead = new im_msg_head.TransOidbHead();
    public im_msg_head.RedirectMsg msg_redirect = new im_msg_head.RedirectMsg();
    public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_command = PBField.initUInt32(0);
    public final PBUInt32Field uint32_command_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_compress_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_local_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_origin_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pub_no = PBField.initUInt32(0);
    public final PBFixed32Field uint32_qzhttp_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_qzhttp_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_cmdid = PBField.initUInt32(0);
    public final PBFixed32Field uint32_spp_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_spp_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_command = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_zone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 93, 96, 109, 112, 125, 128, 136, 146, 152, 160, 168, 178, 184, 192, 202 }, new String[] { "uint64_uin", "uint32_command", "uint32_sub_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pub_no", "uint32_local_id", "uint32_time_zone", "uint32_client_ip", "uint32_client_port", "uint32_qzhttp_ip", "uint32_qzhttp_port", "uint32_spp_ip", "uint32_spp_port", "uint32_flag", "bytes_key", "uint32_compress_type", "uint32_origin_size", "uint32_error_code", "msg_redirect", "uint32_command_id", "uint32_service_cmdid", "msg_oidbhead" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null }, HttpConnHead.class);
    }
  }
  
  public static final class InstCtrl
    extends MessageMicro<InstCtrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst" }, new Object[] { null, null, null }, InstCtrl.class);
    public im_msg_head.InstInfo msg_from_inst = new im_msg_head.InstInfo();
    public final PBRepeatMessageField<im_msg_head.InstInfo> rpt_msg_exclude_inst = PBField.initRepeatMessage(im_msg_head.InstInfo.class);
    public final PBRepeatMessageField<im_msg_head.InstInfo> rpt_msg_send_to_inst = PBField.initRepeatMessage(im_msg_head.InstInfo.class);
  }
  
  public static final class InstInfo
    extends MessageMicro<InstInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80 }, new String[] { "uint32_apppid", "uint32_instid", "uint32_platform", "enum_device_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, InstInfo.class);
    public final PBEnumField enum_device_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "bytes_sig" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LoginSig.class);
    }
  }
  
  public static final class RedirectMsg
    extends MessageMicro<RedirectMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 32, 40 }, new String[] { "uint32_last_redirect_ip", "uint32_last_redirect_port", "uint32_redirect_ip", "uint32_redirect_port", "uint32_redirect_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RedirectMsg.class);
    public final PBFixed32Field uint32_last_redirect_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_last_redirect_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_redirect_count = PBField.initUInt32(0);
    public final PBFixed32Field uint32_redirect_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_redirect_port = PBField.initUInt32(0);
  }
  
  public static final class S2CHead
    extends MessageMicro<S2CHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 48, 56 }, new String[] { "uint32_sub_msgtype", "uint32_msg_type", "uint64_from_uin", "uint32_msg_id", "uint32_relay_ip", "uint32_relay_port", "uint64_to_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, S2CHead.class);
    public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBFixed32Field uint32_relay_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_relay_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_msgtype = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class SConnHead
    extends MessageMicro<SConnHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SConnHead.class);
  }
  
  public static final class TransOidbHead
    extends MessageMicro<TransOidbHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_command", "uint32_service_type", "uint32_result", "str_error_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, TransOidbHead.class);
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBUInt32Field uint32_command = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_head
 * JD-Core Version:    0.7.0.1
 */