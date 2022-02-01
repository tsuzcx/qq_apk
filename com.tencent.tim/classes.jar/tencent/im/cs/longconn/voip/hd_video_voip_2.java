package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2
{
  public static final class BalanceAccount
    extends MessageMicro<BalanceAccount>
  {
    public static final int AT_MULTI = 2;
    public static final int AT_PAIR = 1;
    public static final int AT_TEAM = 3;
    public static final int AT_UNKNOW = 0;
    public static final int FROM_TYPE_LT = 1;
    public static final int FROM_TYPE_QQ = 2;
    public static final int FROM_TYPE_UNKNOW = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_balance_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_app = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_from_app", "uint64_id", "uint32_account_type", "bytes_balance_cookie" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, BalanceAccount.class);
    }
  }
  
  public static final class CmdFailedRspBody
    extends MessageMicro<CmdFailedRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_error_code", "bytes_error_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CmdFailedRspBody.class);
    }
  }
  
  public static final class CmdGetCallTypeReqBody
    extends MessageMicro<CmdGetCallTypeReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_from_flag", "msg_from_tel", "msg_to_tel", "uint32_call_policy" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, CmdGetCallTypeReqBody.class);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
    public final PBUInt32Field uint32_call_policy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_flag = PBField.initUInt32(0);
  }
  
  public static final class CmdGetCallTypeRspBody
    extends MessageMicro<CmdGetCallTypeRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_call_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_call_ability = PBField.initUInt32(0);
    public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tiny_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_call_type", "uint64_tiny_id", "bytes_call_id", "bytes_call_phone", "uint32_call_ability" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, CmdGetCallTypeRspBody.class);
    }
  }
  
  public static final class CmdPhoneBindReqBody
    extends MessageMicro<CmdPhoneBindReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> bytes_last_call_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_prvt_session = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public hd_video_voip_2.SpeedTestInfo msg_speed_test_info = new hd_video_voip_2.SpeedTestInfo();
    public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
    public final PBUInt32Field uint32_call_policy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58, 66 }, new String[] { "uint32_from_flag", "msg_from_tel", "msg_to_tel", "uint32_call_policy", "msg_speed_test_info", "uint64_prvt_id", "bytes_prvt_session", "bytes_last_call_id" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, CmdPhoneBindReqBody.class);
    }
  }
  
  public static final class CmdPhoneBindRspBody
    extends MessageMicro<CmdPhoneBindRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_call_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_call_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ability = PBField.initUInt32(0);
    public final PBUInt32Field uint32_call_phone_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cb_line_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_call_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 64 }, new String[] { "uint32_call_type", "uint64_call_id", "bytes_call_id", "bytes_call_prompt", "bytes_call_phone", "uint32_ability", "uint32_call_phone_type", "uint32_cb_line_count" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CmdPhoneBindRspBody.class);
    }
  }
  
  public static final class CmdPhoneCallBackReqBody
    extends MessageMicro<CmdPhoneCallBackReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> bytes_last_call_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_prvt_session = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
    public final PBUInt32Field uint32_cost_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_balance = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58 }, new String[] { "msg_from_tel", "msg_to_tel", "uint64_balance", "uint32_cost_type", "uint64_prvt_id", "bytes_prvt_session", "bytes_last_call_id" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, CmdPhoneCallBackReqBody.class);
    }
  }
  
  public static final class CmdPhoneCallBackRspBody
    extends MessageMicro<CmdPhoneCallBackRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_call_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_call_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_call_phone_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cb_line_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "bytes_call_id", "bytes_call_prompt", "bytes_call_phone", "uint32_call_phone_type", "uint32_cb_line_count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, CmdPhoneCallBackRspBody.class);
    }
  }
  
  public static final class CmdPhoneCancelCallBackReqBody
    extends MessageMicro<CmdPhoneCancelCallBackReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_from_tel", "msg_to_tel", "bytes_call_id" }, new Object[] { null, null, localByteStringMicro }, CmdPhoneCancelCallBackReqBody.class);
    }
  }
  
  public static final class CmdPhoneCancelCallBackRspBody
    extends MessageMicro<CmdPhoneCancelCallBackRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_call_id" }, new Object[] { localByteStringMicro }, CmdPhoneCancelCallBackRspBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatCancelReqBody
    extends MessageMicro<CmdPhoneMultiChatCancelReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_from_tel", "bytes_conf_id" }, new Object[] { null, localByteStringMicro }, CmdPhoneMultiChatCancelReqBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatCancelRspBody
    extends MessageMicro<CmdPhoneMultiChatCancelRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_conf_id" }, new Object[] { localByteStringMicro }, CmdPhoneMultiChatCancelRspBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatCreateReqBody
    extends MessageMicro<CmdPhoneMultiChatCreateReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_from_tel", "msg_to_tel", "uint64_balance" }, new Object[] { null, null, Long.valueOf(0L) }, CmdPhoneMultiChatCreateReqBody.class);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_to_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    public final PBUInt64Field uint64_balance = PBField.initUInt64(0L);
  }
  
  public static final class CmdPhoneMultiChatCreateRspBody
    extends MessageMicro<CmdPhoneMultiChatCreateRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_call_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_call_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_not_support_to_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    public final PBUInt32Field uint32_call_phone_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "bytes_conf_id", "msg_not_support_to_tel", "bytes_call_prompt", "bytes_call_phone", "uint32_call_phone_type" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, CmdPhoneMultiChatCreateRspBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatInviteReqBody
    extends MessageMicro<CmdPhoneMultiChatInviteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_invite_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_from_tel", "bytes_conf_id", "msg_invite_tel" }, new Object[] { null, localByteStringMicro, null }, CmdPhoneMultiChatInviteReqBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatInviteRspBody
    extends MessageMicro<CmdPhoneMultiChatInviteRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_invite_fail_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_invite_succ_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_conf_id", "msg_invite_fail_tel", "msg_invite_succ_tel" }, new Object[] { localByteStringMicro, null, null }, CmdPhoneMultiChatInviteRspBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatKickReqBody
    extends MessageMicro<CmdPhoneMultiChatKickReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_kick_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_from_tel", "bytes_conf_id", "msg_kick_tel" }, new Object[] { null, localByteStringMicro, null }, CmdPhoneMultiChatKickReqBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatKickRspBody
    extends MessageMicro<CmdPhoneMultiChatKickRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_kick_fail_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_kick_succ_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_conf_id", "msg_kick_fail_tel", "msg_kick_succ_tel" }, new Object[] { localByteStringMicro, null, null }, CmdPhoneMultiChatKickRspBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatQueryReqBody
    extends MessageMicro<CmdPhoneMultiChatQueryReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_from_tel", "bytes_conf_id" }, new Object[] { null, localByteStringMicro }, CmdPhoneMultiChatQueryReqBody.class);
    }
  }
  
  public static final class CmdPhoneMultiChatQueryRspBody
    extends MessageMicro<CmdPhoneMultiChatQueryRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<hd_video_voip_2.TelInfo> msg_chating_tel = PBField.initRepeatMessage(hd_video_voip_2.TelInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_conf_id", "msg_chating_tel" }, new Object[] { localByteStringMicro, null }, CmdPhoneMultiChatQueryRspBody.class);
    }
  }
  
  public static final class CmdPhoneSpeedTestReq
    extends MessageMicro<CmdPhoneSpeedTestReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21 }, new String[] { "uint64_self_uin", "fixed32_self_client_ip" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, CmdPhoneSpeedTestReq.class);
    public final PBFixed32Field fixed32_self_client_ip = PBField.initFixed32(0);
    public final PBUInt64Field uint64_self_uin = PBField.initUInt64(0L);
  }
  
  public static final class CmdPhoneSpeedTestRsp
    extends MessageMicro<CmdPhoneSpeedTestRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82 }, new String[] { "uint32_result", "uint32_test_type", "uint32_pkglen", "uint32_pkgnum_per_second", "uint32_sendpkg_keep_time", "uint32_ping_interval_time", "uint32_ping_cnt", "uint32_ping_packet_size", "uint32_server_interval", "rpt_msg_ipspeed_info_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, CmdPhoneSpeedTestRsp.class);
    public final PBRepeatMessageField<IPSpeedSvrInfo> rpt_msg_ipspeed_info_list = PBField.initRepeatMessage(IPSpeedSvrInfo.class);
    public final PBUInt32Field uint32_ping_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ping_interval_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ping_packet_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pkglen = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pkgnum_per_second = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sendpkg_keep_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_test_type = PBField.initUInt32(0);
    
    public static final class IPSpeedSvrInfo
      extends MessageMicro<IPSpeedSvrInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16 }, new String[] { "fixed32_server_ip", "uint32_server_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, IPSpeedSvrInfo.class);
      public final PBFixed32Field fixed32_server_ip = PBField.initFixed32(0);
      public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
    }
  }
  
  public static final class PhoneH5CheckReqBody
    extends MessageMicro<PhoneH5CheckReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_seq", "msg_from_tel", "msg_to_tel", "uint64_prvt_id" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L) }, PhoneH5CheckReqBody.class);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
    public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class PhoneH5CheckRspBody
    extends MessageMicro<PhoneH5CheckRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint64_seq", "msg_from_tel", "msg_to_tel", "uint32_error_no", "uint64_balance" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), Long.valueOf(0L) }, PhoneH5CheckRspBody.class);
    public hd_video_voip_2.TelInfo msg_from_tel = new hd_video_voip_2.TelInfo();
    public hd_video_voip_2.TelInfo msg_to_tel = new hd_video_voip_2.TelInfo();
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_balance = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 410 }, new String[] { "msg_voip_head", "msg_phone_bind_req_body", "msg_phone_callback_req_body", "msg_phone_cancel_callback_req_body", "msg_phone_speed_test_req_body", "msg_phone_multi_chat_create_req_body", "msg_phone_multi_chat_invite_req_body", "msg_phone_multi_chat_query_req_body", "msg_phone_multi_chat_kick_req_body", "msg_phone_multi_chat_cancel_req_body", "msg_phone_h5_check_req_body", "msg_bm", "msg_get_call_type_req_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public hd_video_voip_2.BalanceAccount msg_bm = new hd_video_voip_2.BalanceAccount();
    public hd_video_voip_2.CmdGetCallTypeReqBody msg_get_call_type_req_body = new hd_video_voip_2.CmdGetCallTypeReqBody();
    public hd_video_voip_2.CmdPhoneBindReqBody msg_phone_bind_req_body = new hd_video_voip_2.CmdPhoneBindReqBody();
    public hd_video_voip_2.CmdPhoneCallBackReqBody msg_phone_callback_req_body = new hd_video_voip_2.CmdPhoneCallBackReqBody();
    public hd_video_voip_2.CmdPhoneCancelCallBackReqBody msg_phone_cancel_callback_req_body = new hd_video_voip_2.CmdPhoneCancelCallBackReqBody();
    public hd_video_voip_2.PhoneH5CheckReqBody msg_phone_h5_check_req_body = new hd_video_voip_2.PhoneH5CheckReqBody();
    public hd_video_voip_2.CmdPhoneMultiChatCancelReqBody msg_phone_multi_chat_cancel_req_body = new hd_video_voip_2.CmdPhoneMultiChatCancelReqBody();
    public hd_video_voip_2.CmdPhoneMultiChatCreateReqBody msg_phone_multi_chat_create_req_body = new hd_video_voip_2.CmdPhoneMultiChatCreateReqBody();
    public hd_video_voip_2.CmdPhoneMultiChatInviteReqBody msg_phone_multi_chat_invite_req_body = new hd_video_voip_2.CmdPhoneMultiChatInviteReqBody();
    public hd_video_voip_2.CmdPhoneMultiChatKickReqBody msg_phone_multi_chat_kick_req_body = new hd_video_voip_2.CmdPhoneMultiChatKickReqBody();
    public hd_video_voip_2.CmdPhoneMultiChatQueryReqBody msg_phone_multi_chat_query_req_body = new hd_video_voip_2.CmdPhoneMultiChatQueryReqBody();
    public hd_video_voip_2.CmdPhoneSpeedTestReq msg_phone_speed_test_req_body = new hd_video_voip_2.CmdPhoneSpeedTestReq();
    public hd_video_voip_2.VoipHead msg_voip_head = new hd_video_voip_2.VoipHead();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 418 }, new String[] { "msg_voip_head", "msg_failed_body", "msg_phone_bind_rsp_body", "msg_phone_callback_rsp_body", "msg_phone_cancel_callback_rsp_body", "msg_phone_speed_test_rsp_body", "msg_phone_multi_chat_create_rsp_body", "msg_phone_multi_chat_invite_rsp_body", "msg_phone_multi_chat_query_rsp_body", "msg_phone_multi_chat_kick_rsp_body", "msg_phone_multi_chat_cancel_rsp_body", "msg_phone_h5_check_rsp_body", "msg_get_call_type_rsp_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
    public hd_video_voip_2.CmdFailedRspBody msg_failed_body = new hd_video_voip_2.CmdFailedRspBody();
    public hd_video_voip_2.CmdGetCallTypeRspBody msg_get_call_type_rsp_body = new hd_video_voip_2.CmdGetCallTypeRspBody();
    public hd_video_voip_2.CmdPhoneBindRspBody msg_phone_bind_rsp_body = new hd_video_voip_2.CmdPhoneBindRspBody();
    public hd_video_voip_2.CmdPhoneCallBackRspBody msg_phone_callback_rsp_body = new hd_video_voip_2.CmdPhoneCallBackRspBody();
    public hd_video_voip_2.CmdPhoneCancelCallBackRspBody msg_phone_cancel_callback_rsp_body = new hd_video_voip_2.CmdPhoneCancelCallBackRspBody();
    public hd_video_voip_2.PhoneH5CheckRspBody msg_phone_h5_check_rsp_body = new hd_video_voip_2.PhoneH5CheckRspBody();
    public hd_video_voip_2.CmdPhoneMultiChatCancelRspBody msg_phone_multi_chat_cancel_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatCancelRspBody();
    public hd_video_voip_2.CmdPhoneMultiChatCreateRspBody msg_phone_multi_chat_create_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatCreateRspBody();
    public hd_video_voip_2.CmdPhoneMultiChatInviteRspBody msg_phone_multi_chat_invite_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatInviteRspBody();
    public hd_video_voip_2.CmdPhoneMultiChatKickRspBody msg_phone_multi_chat_kick_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatKickRspBody();
    public hd_video_voip_2.CmdPhoneMultiChatQueryRspBody msg_phone_multi_chat_query_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatQueryRspBody();
    public hd_video_voip_2.CmdPhoneSpeedTestRsp msg_phone_speed_test_rsp_body = new hd_video_voip_2.CmdPhoneSpeedTestRsp();
    public hd_video_voip_2.VoipHead msg_voip_head = new hd_video_voip_2.VoipHead();
  }
  
  public static final class SpeedTestInfo
    extends MessageMicro<SpeedTestInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_total_pkg", "uint32_real_recv_pkg", "uint32_delay", "uint32_jitter", "uint32_loss_continue", "uint32_estimate_bandwidth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SpeedTestInfo.class);
    public final PBUInt32Field uint32_delay = PBField.initUInt32(0);
    public final PBUInt32Field uint32_estimate_bandwidth = PBField.initUInt32(0);
    public final PBUInt32Field uint32_jitter = PBField.initUInt32(0);
    public final PBUInt32Field uint32_loss_continue = PBField.initUInt32(0);
    public final PBUInt32Field uint32_real_recv_pkg = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_pkg = PBField.initUInt32(0);
  }
  
  public static final class TelInfo
    extends MessageMicro<TelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nation = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_binded_id_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq_instanceid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_binded_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public final PBUInt32Field uint64_uin_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 152, 160, 168, 176, 184, 192, 200, 208 }, new String[] { "bytes_nation", "bytes_prefix", "bytes_mobile", "uint32_status", "uint32_appid", "uint64_uin", "uint64_uin_type", "uint64_binded_id", "uint32_binded_id_type", "uint32_mobile_type", "uint32_qq_appid", "uint32_qq_instanceid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TelInfo.class);
    }
  }
  
  public static final class VoipHead
    extends MessageMicro<VoipHead>
  {
    public static final int CMD_GET_CALL_TYPE_REQ = 51;
    public static final int CMD_GET_CALL_TYPE_RSP = 52;
    public static final int CMD_PHONE_BIND_ID_REQ = 1;
    public static final int CMD_PHONE_BIND_ID_RSP = 2;
    public static final int CMD_PHONE_CALLBACK_REQ = 3;
    public static final int CMD_PHONE_CALLBACK_RSP = 4;
    public static final int CMD_PHONE_CANCEL_CALLBACK_REQ = 5;
    public static final int CMD_PHONE_CANCEL_CALLBACK_RSP = 6;
    public static final int CMD_PHONE_H5_CHECK_REQ = 19;
    public static final int CMD_PHONE_H5_CHECK_RSP = 20;
    public static final int CMD_PHONE_MULTICHAT_CANCEL_REQ = 17;
    public static final int CMD_PHONE_MULTICHAT_CANCEL_RSP = 18;
    public static final int CMD_PHONE_MULTICHAT_CREATE_REQ = 9;
    public static final int CMD_PHONE_MULTICHAT_CREATE_RSP = 10;
    public static final int CMD_PHONE_MULTICHAT_INVITE_REQ = 11;
    public static final int CMD_PHONE_MULTICHAT_INVITE_RSP = 12;
    public static final int CMD_PHONE_MULTICHAT_KICK_REQ = 15;
    public static final int CMD_PHONE_MULTICHAT_KICK_RSP = 16;
    public static final int CMD_PHONE_MULTICHAT_QUERY_REQ = 13;
    public static final int CMD_PHONE_MULTICHAT_QUERY_RSP = 14;
    public static final int CMD_PHONE_SPEED_TEST_REQ = 7;
    public static final int CMD_PHONE_SPEED_TEST_RSP = 8;
    public static final int ERR_BILL_NOT_ENOUGH = 3;
    public static final int ERR_CALLBACK_SERVER = 4;
    public static final int ERR_CANCEL_CALLBACK = 5;
    public static final int ERR_MULTICHAT_CONFID = 12;
    public static final int ERR_MULTICHAT_OVER_MAX = 11;
    public static final int ERR_MULTICHAT_PARA = 13;
    public static final int ERR_MULTICHAT_PHONE = 10;
    public static final int ERR_MULTICHAT_SERVER = 9;
    public static final int ERR_PHONE_ERROR = 7;
    public static final int ERR_PHONE_FOREIGN = 8;
    public static final int ERR_PHONE_LIMIT = 6;
    public static final int ERR_PHONE_NOT_SUPPORT = 1;
    public static final int ERR_QCALL_BOTH_MASK = 16;
    public static final int ERR_QCALL_CALLEE_MASK = 15;
    public static final int ERR_QCALL_CALLER_MASK = 14;
    public static final int ERR_UNKNOWN = 255;
    public static final int ERR_VOIP_NO_PERMISSION = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_sub_service_type = PBField.initInt32(0);
    public final PBUInt32Field uint32_app_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biz_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 176 }, new String[] { "uint64_uin", "uint64_seq", "uint32_cmd", "uint32_error_no", "bytes_build_ver", "uint32_term_type", "uint32_app_type", "uint32_biz_id", "int32_sub_service_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VoipHead.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2
 * JD-Core Version:    0.7.0.1
 */