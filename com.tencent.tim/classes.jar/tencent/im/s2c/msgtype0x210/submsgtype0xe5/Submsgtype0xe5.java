package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5
{
  public static final class CrmS2CMsgHead
    extends MessageMicro<CrmS2CMsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint32_crm_sub_cmd", "uint32_head_len", "uint32_ver_no", "uint64_kf_uin", "uint32_seq", "uint32_pack_num", "uint32_cur_pack", "str_buf_sig" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, CrmS2CMsgHead.class);
    public final PBStringField str_buf_sig = PBField.initString("");
    public final PBUInt32Field uint32_crm_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_pack = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pack_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_s2c_cc_agent_status_change_push", "msg_s2c_cc_config_change_push", "msg_s2c_cc_exception_occur_push", "msg_s2c_cc_talking_status_change_push", "msg_s2c_cc_agent_action_result_push", "msg_s2c_call_record_change_push", "msg_s2c_sms_event_push", "msg_s2c_agent_call_status_event_push", "msg_s2c_user_get_coupon_for_kfext_event_push", "msg_s2c_user_get_coupon_for_c_event_push" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null }, MsgBody.class);
    public Submsgtype0xe5.CrmS2CMsgHead msg_crm_common_head = new Submsgtype0xe5.CrmS2CMsgHead();
    public S2CAgentCallStatusEventPush msg_s2c_agent_call_status_event_push = new S2CAgentCallStatusEventPush();
    public S2CCallRecordChangePush msg_s2c_call_record_change_push = new S2CCallRecordChangePush();
    public S2CCcAgentActionResultPush msg_s2c_cc_agent_action_result_push = new S2CCcAgentActionResultPush();
    public S2CCcAgentStatusChangePush msg_s2c_cc_agent_status_change_push = new S2CCcAgentStatusChangePush();
    public S2CCcConfigChangePush msg_s2c_cc_config_change_push = new S2CCcConfigChangePush();
    public S2CCcExceptionOccurPush msg_s2c_cc_exception_occur_push = new S2CCcExceptionOccurPush();
    public S2CCcTalkingStatusChangePush msg_s2c_cc_talking_status_change_push = new S2CCcTalkingStatusChangePush();
    public S2CSMSEventPush msg_s2c_sms_event_push = new S2CSMSEventPush();
    public S2CUserGetCouponForCEventPush msg_s2c_user_get_coupon_for_c_event_push = new S2CUserGetCouponForCEventPush();
    public S2CUserGetCouponForKFExtEventPush msg_s2c_user_get_coupon_for_kfext_event_push = new S2CUserGetCouponForKFExtEventPush();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    
    public static final class S2CAgentCallStatusEventPush
      extends MessageMicro<S2CAgentCallStatusEventPush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_type", "uint32_call_status", "uint32_ring_asr", "str_callid", "uint64_from_kfext", "uint32_timestamp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0) }, S2CAgentCallStatusEventPush.class);
      public final PBStringField str_callid = PBField.initString("");
      public final PBUInt32Field uint32_call_status = PBField.initUInt32(0);
      public final PBUInt32Field uint32_ring_asr = PBField.initUInt32(0);
      public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
      public final PBUInt32Field uint32_type = PBField.initUInt32(0);
      public final PBUInt64Field uint64_from_kfext = PBField.initUInt64(0L);
    }
    
    public static final class S2CCallRecordChangePush
      extends MessageMicro<S2CCallRecordChangePush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17 }, new String[] { "uint64_kfext", "fixed64_timestamp" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, S2CCallRecordChangePush.class);
      public final PBFixed64Field fixed64_timestamp = PBField.initFixed64(0L);
      public final PBUInt64Field uint64_kfext = PBField.initUInt64(0L);
    }
    
    public static final class S2CCcAgentActionResultPush
      extends MessageMicro<S2CCcAgentActionResultPush>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_target_name = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_callid = PBField.initString("");
      public final PBUInt32Field uint32_result = PBField.initUInt32(0);
      public final PBUInt32Field uint32_status = PBField.initUInt32(0);
      public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
      public final PBUInt32Field uint32_type = PBField.initUInt32(0);
      public final PBUInt64Field uint64_target_kfext = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56 }, new String[] { "uint32_type", "str_callid", "uint32_result", "uint32_timestamp", "uint32_status", "bytes_target_name", "uint64_target_kfext" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, S2CCcAgentActionResultPush.class);
      }
    }
    
    public static final class S2CCcAgentStatusChangePush
      extends MessageMicro<S2CCcAgentStatusChangePush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_ready_device", "uint64_update_time", "uint32_device_sub_state" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, S2CCcAgentStatusChangePush.class);
      public final PBUInt32Field uint32_device_sub_state = PBField.initUInt32(0);
      public final PBUInt32Field uint32_ready_device = PBField.initUInt32(0);
      public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
    }
    
    public static final class S2CCcConfigChangePush
      extends MessageMicro<S2CCcConfigChangePush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_optype" }, new Object[] { Integer.valueOf(0) }, S2CCcConfigChangePush.class);
      public final PBUInt32Field uint32_optype = PBField.initUInt32(0);
    }
    
    public static final class S2CCcExceptionOccurPush
      extends MessageMicro<S2CCcExceptionOccurPush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_optype" }, new Object[] { Integer.valueOf(0) }, S2CCcExceptionOccurPush.class);
      public final PBUInt32Field uint32_optype = PBField.initUInt32(0);
    }
    
    public static final class S2CCcTalkingStatusChangePush
      extends MessageMicro<S2CCcTalkingStatusChangePush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_talking_status", "str_callid" }, new Object[] { Integer.valueOf(0), "" }, S2CCcTalkingStatusChangePush.class);
      public final PBStringField str_callid = PBField.initString("");
      public final PBUInt32Field uint32_talking_status = PBField.initUInt32(0);
    }
    
    public static final class S2CSMSEventPush
      extends MessageMicro<S2CSMSEventPush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint32_type", "str_phone_num", "uint64_timestamp", "str_sms_id", "str_event_msg" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", "" }, S2CSMSEventPush.class);
      public final PBStringField str_event_msg = PBField.initString("");
      public final PBStringField str_phone_num = PBField.initString("");
      public final PBStringField str_sms_id = PBField.initString("");
      public final PBUInt32Field uint32_type = PBField.initUInt32(0);
      public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
    }
    
    public static final class S2CUserGetCouponForCEventPush
      extends MessageMicro<S2CUserGetCouponForCEventPush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_qquin", "uint64_kfuin", "uint64_coupon_id", "uint32_timestamp", "uint64_kfext", "str_tips_content" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "" }, S2CUserGetCouponForCEventPush.class);
      public final PBStringField str_tips_content = PBField.initString("");
      public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
      public final PBUInt64Field uint64_coupon_id = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_kfext = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
    }
    
    public static final class S2CUserGetCouponForKFExtEventPush
      extends MessageMicro<S2CUserGetCouponForKFExtEventPush>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96 }, new String[] { "uint32_channel_type", "uint64_fakeuin", "uint64_qquin", "str_openid", "str_visitorid", "str_appid", "uint64_qq_pub_uin", "uint64_kfuin", "uint64_coupon_id", "str_notify_tips", "uint32_timestamp", "uint64_kfext" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L) }, S2CUserGetCouponForKFExtEventPush.class);
      public final PBStringField str_appid = PBField.initString("");
      public final PBStringField str_notify_tips = PBField.initString("");
      public final PBStringField str_openid = PBField.initString("");
      public final PBStringField str_visitorid = PBField.initString("");
      public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
      public final PBUInt64Field uint64_coupon_id = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_fakeuin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_kfext = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_qq_pub_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5
 * JD-Core Version:    0.7.0.1
 */