package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientInterface
{
  public static final class IntC2SChangeSessionReq
    extends MessageMicro<IntC2SChangeSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "enum_net_type", "uint32_client_port", "enum_business_direction", "enum_data_source", "bool_translate" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Boolean.valueOf(false) }, IntC2SChangeSessionReq.class);
    public final PBBoolField bool_translate = PBField.initBool(false);
    public final PBEnumField enum_business_direction = PBField.initEnum(1);
    public final PBEnumField enum_data_source = PBField.initEnum(1);
    public final PBEnumField enum_net_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  }
  
  public static final class IntC2SChangeSessionRsp
    extends MessageMicro<IntC2SChangeSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_combine_num", "enum_channel_type", "rpt_msg_interface_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), null }, IntC2SChangeSessionRsp.class);
    public final PBEnumField enum_channel_type = PBField.initEnum(1);
    public final PBRepeatMessageField<AudioTransCommon.NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon.NetAddr.class);
    public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
  }
  
  public static final class IntC2SExitSessionReq
    extends MessageMicro<IntC2SExitSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntC2SExitSessionReq.class);
  }
  
  public static final class IntC2SExitSessionRsp
    extends MessageMicro<IntC2SExitSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntC2SExitSessionRsp.class);
  }
  
  public static final class IntC2SFailedRsp
    extends MessageMicro<IntC2SFailedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_errcode", "str_errmsg" }, new Object[] { Integer.valueOf(0), "" }, IntC2SFailedRsp.class);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
  }
  
  public static final class IntC2SHeartBeatReq
    extends MessageMicro<IntC2SHeartBeatReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntC2SHeartBeatReq.class);
  }
  
  public static final class IntC2SHeartBeatRsp
    extends MessageMicro<IntC2SHeartBeatRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntC2SHeartBeatRsp.class);
  }
  
  public static final class IntC2SJoinSessionReq
    extends MessageMicro<IntC2SJoinSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port", "enum_business_direction", "enum_data_source", "bool_translate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Boolean.valueOf(false) }, IntC2SJoinSessionReq.class);
    public final PBBoolField bool_translate = PBField.initBool(false);
    public final PBEnumField enum_business_direction = PBField.initEnum(1);
    public final PBEnumField enum_data_source = PBField.initEnum(1);
    public final PBEnumField enum_net_type = PBField.initEnum(1);
    public final PBEnumField enum_term = PBField.initEnum(1);
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  }
  
  public static final class IntC2SJoinSessionRsp
    extends MessageMicro<IntC2SJoinSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_heartbeat_duration", "uint32_combine_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, IntC2SJoinSessionRsp.class);
    public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_heartbeat_duration = PBField.initUInt32(0);
  }
  
  public static final class IntC2SRawDataReq
    extends MessageMicro<IntC2SRawDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_key = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_data", "str_key" }, new Object[] { localByteStringMicro, "" }, IntC2SRawDataReq.class);
    }
  }
  
  public static final class IntC2SRawDataRsp
    extends MessageMicro<IntC2SRawDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntC2SRawDataRsp.class);
  }
  
  public static final class IntHead
    extends MessageMicro<IntHead>
  {
    public static final int INT_C2S_CHANGE_SESSION_REQ = 5;
    public static final int INT_C2S_CHANGE_SESSION_RSP = 6;
    public static final int INT_C2S_EXIT_SESSION_REQ = 3;
    public static final int INT_C2S_EXIT_SESSION_RSP = 4;
    public static final int INT_C2S_HEART_BEAT_REQ = 9;
    public static final int INT_C2S_HEART_BEAT_RSP = 10;
    public static final int INT_C2S_JOIN_SESSION_REQ = 1;
    public static final int INT_C2S_JOIN_SESSION_RSP = 2;
    public static final int INT_C2S_RAW_DATA_REQ = 7;
    public static final int INT_C2S_RAW_DATA_RSP = 8;
    public static final int INT_S2C_NOTIFY_EXIT_REQ = 13;
    public static final int INT_S2C_NOTIFY_EXIT_RSP = 14;
    public static final int INT_S2C_PUSH_DATA_REQ = 11;
    public static final int INT_S2C_PUSH_DATA_RSP = 12;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_session_id", "str_uin", "uint32_seq", "enum_body_type", "uint32_error_no" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, IntHead.class);
    public final PBEnumField enum_body_type = PBField.initEnum(1);
    public final PBStringField str_session_id = PBField.initString("");
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class IntReqBody
    extends MessageMicro<IntReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "msg_join_session_req", "msg_exit_session_req", "msg_change_session_req", "msg_raw_data_req", "msg_heart_beat_req", "msg_push_data_req", "msg_notify_exit_req" }, new Object[] { null, null, null, null, null, null, null }, IntReqBody.class);
    public AudioTransClientInterface.IntC2SChangeSessionReq msg_change_session_req = new AudioTransClientInterface.IntC2SChangeSessionReq();
    public AudioTransClientInterface.IntC2SExitSessionReq msg_exit_session_req = new AudioTransClientInterface.IntC2SExitSessionReq();
    public AudioTransClientInterface.IntC2SHeartBeatReq msg_heart_beat_req = new AudioTransClientInterface.IntC2SHeartBeatReq();
    public AudioTransClientInterface.IntC2SJoinSessionReq msg_join_session_req = new AudioTransClientInterface.IntC2SJoinSessionReq();
    public AudioTransClientInterface.IntS2CNotifyExitReq msg_notify_exit_req = new AudioTransClientInterface.IntS2CNotifyExitReq();
    public AudioTransClientInterface.IntS2CPushDataReq msg_push_data_req = new AudioTransClientInterface.IntS2CPushDataReq();
    public AudioTransClientInterface.IntC2SRawDataReq msg_raw_data_req = new AudioTransClientInterface.IntC2SRawDataReq();
  }
  
  public static final class IntRspBody
    extends MessageMicro<IntRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "msg_failed_rsp", "msg_join_session_rsp", "msg_exit_session_rsp", "msg_change_session_rsp", "msg_raw_data_rsp", "msg_heart_beat_rsp", "msg_push_data_rsp", "msg_notify_exit_rsp" }, new Object[] { null, null, null, null, null, null, null, null }, IntRspBody.class);
    public AudioTransClientInterface.IntC2SChangeSessionRsp msg_change_session_rsp = new AudioTransClientInterface.IntC2SChangeSessionRsp();
    public AudioTransClientInterface.IntC2SExitSessionRsp msg_exit_session_rsp = new AudioTransClientInterface.IntC2SExitSessionRsp();
    public AudioTransClientInterface.IntC2SFailedRsp msg_failed_rsp = new AudioTransClientInterface.IntC2SFailedRsp();
    public AudioTransClientInterface.IntC2SHeartBeatRsp msg_heart_beat_rsp = new AudioTransClientInterface.IntC2SHeartBeatRsp();
    public AudioTransClientInterface.IntC2SJoinSessionRsp msg_join_session_rsp = new AudioTransClientInterface.IntC2SJoinSessionRsp();
    public AudioTransClientInterface.IntS2CNotifyExitRsp msg_notify_exit_rsp = new AudioTransClientInterface.IntS2CNotifyExitRsp();
    public AudioTransClientInterface.IntS2CPushDataRsp msg_push_data_rsp = new AudioTransClientInterface.IntS2CPushDataRsp();
    public AudioTransClientInterface.IntC2SRawDataRsp msg_raw_data_rsp = new AudioTransClientInterface.IntC2SRawDataRsp();
  }
  
  public static final class IntS2CNotifyExitReq
    extends MessageMicro<IntS2CNotifyExitReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_reason" }, new Object[] { Integer.valueOf(0) }, IntS2CNotifyExitReq.class);
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
  }
  
  public static final class IntS2CNotifyExitRsp
    extends MessageMicro<IntS2CNotifyExitRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntS2CNotifyExitRsp.class);
  }
  
  public static final class IntS2CPushDataReq
    extends MessageMicro<IntS2CPushDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField str_key = PBField.initString("");
    public final PBBytesField translate_result = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "translate_result", "str_key" }, new Object[] { localByteStringMicro, "" }, IntS2CPushDataReq.class);
    }
  }
  
  public static final class IntS2CPushDataRsp
    extends MessageMicro<IntS2CPushDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntS2CPushDataRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInterface
 * JD-Core Version:    0.7.0.1
 */