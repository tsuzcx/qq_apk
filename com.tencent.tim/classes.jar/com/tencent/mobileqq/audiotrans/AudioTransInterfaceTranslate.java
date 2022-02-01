package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransInterfaceTranslate
{
  public static final class IntTransChangeSessionReq
    extends MessageMicro<IntTransChangeSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "bool_translate" }, new Object[] { Boolean.valueOf(false) }, IntTransChangeSessionReq.class);
    public final PBBoolField bool_translate = PBField.initBool(false);
  }
  
  public static final class IntTransChangeSessionRsp
    extends MessageMicro<IntTransChangeSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransChangeSessionRsp.class);
  }
  
  public static final class IntTransClientReportReq
    extends MessageMicro<IntTransClientReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransClientReportReq.class);
  }
  
  public static final class IntTransClientReportRsp
    extends MessageMicro<IntTransClientReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransClientReportRsp.class);
  }
  
  public static final class IntTransExitSessionReq
    extends MessageMicro<IntTransExitSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransExitSessionReq.class);
  }
  
  public static final class IntTransExitSessionRsp
    extends MessageMicro<IntTransExitSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransExitSessionRsp.class);
  }
  
  public static final class IntTransFailedRsp
    extends MessageMicro<IntTransFailedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_errcode", "str_errmsg" }, new Object[] { Integer.valueOf(0), "" }, IntTransFailedRsp.class);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
  }
  
  public static final class IntTransHead
    extends MessageMicro<IntTransHead>
  {
    public static final int INT_TRANS_CHANGE_SESSION_REQ = 3;
    public static final int INT_TRANS_CHANGE_SESSION_RSP = 4;
    public static final int INT_TRANS_CLIENT_REPORT_REQ = 9;
    public static final int INT_TRANS_CLIENT_REPORT_RSP = 10;
    public static final int INT_TRANS_EXIT_SESSION_REQ = 5;
    public static final int INT_TRANS_EXIT_SESSION_RSP = 6;
    public static final int INT_TRANS_JOIN_SESSION_REQ = 1;
    public static final int INT_TRANS_JOIN_SESSION_RSP = 2;
    public static final int INT_TRANS_RAW_DATA_REQ = 7;
    public static final int INT_TRANS_RAW_DATA_RSP = 8;
    public static final int INT_TRANS_REPORT_CHANGE_REQ = 15;
    public static final int INT_TRANS_REPORT_CHANGE_RSP = 16;
    public static final int TRANS_INT_PUSH_DATA_REQ = 11;
    public static final int TRANS_INT_PUSH_DATA_RSP = 12;
    public static final int TRANS_INT_TIMEOUT_EXIT_REQ = 13;
    public static final int TRANS_INT_TIMEOUT_EXIT_RSP = 14;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_session_id", "str_uin", "uint32_seq", "enum_body_type", "uint32_error_no" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, IntTransHead.class);
    public final PBEnumField enum_body_type = PBField.initEnum(1);
    public final PBStringField str_session_id = PBField.initString("");
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class IntTransJoinSessionReq
    extends MessageMicro<IntTransJoinSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "enum_business_type", "msg_crypt_info", "bool_translate", "uint32_data_timeout" }, new Object[] { Integer.valueOf(1), null, Boolean.valueOf(false), Integer.valueOf(0) }, IntTransJoinSessionReq.class);
    public final PBBoolField bool_translate = PBField.initBool(false);
    public final PBEnumField enum_business_type = PBField.initEnum(1);
    public AudioTransCommon.AudioCryptInfo msg_crypt_info = new AudioTransCommon.AudioCryptInfo();
    public final PBUInt32Field uint32_data_timeout = PBField.initUInt32(0);
  }
  
  public static final class IntTransJoinSessionRsp
    extends MessageMicro<IntTransJoinSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransJoinSessionRsp.class);
  }
  
  public static final class IntTransRawDataReq
    extends MessageMicro<IntTransRawDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_data" }, new Object[] { localByteStringMicro }, IntTransRawDataReq.class);
    }
  }
  
  public static final class IntTransRawDataRsp
    extends MessageMicro<IntTransRawDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransRawDataRsp.class);
  }
  
  public static final class IntTransReportReq
    extends MessageMicro<IntTransReportReq>
  {
    public static final int INT_TRANS_CREATE_REPORT = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_business_type", "enum_report_reason" }, new Object[] { Integer.valueOf(1), Integer.valueOf(1) }, IntTransReportReq.class);
    public final PBEnumField enum_business_type = PBField.initEnum(1);
    public final PBEnumField enum_report_reason = PBField.initEnum(1);
  }
  
  public static final class IntTransReportRsp
    extends MessageMicro<IntTransReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IntTransReportRsp.class);
  }
  
  public static final class IntTransReqBody
    extends MessageMicro<IntTransReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "msg_join_session_req", "msg_change_session_req", "msg_exit_session_req", "msg_raw_data_req", "msg_client_report_req", "msg_push_data_req", "msg_data_timeout_req", "msg_report_change_req" }, new Object[] { null, null, null, null, null, null, null, null }, IntTransReqBody.class);
    public AudioTransInterfaceTranslate.IntTransChangeSessionReq msg_change_session_req = new AudioTransInterfaceTranslate.IntTransChangeSessionReq();
    public AudioTransInterfaceTranslate.IntTransClientReportReq msg_client_report_req = new AudioTransInterfaceTranslate.IntTransClientReportReq();
    public AudioTransInterfaceTranslate.TransIntTimeoutReq msg_data_timeout_req = new AudioTransInterfaceTranslate.TransIntTimeoutReq();
    public AudioTransInterfaceTranslate.IntTransExitSessionReq msg_exit_session_req = new AudioTransInterfaceTranslate.IntTransExitSessionReq();
    public AudioTransInterfaceTranslate.IntTransJoinSessionReq msg_join_session_req = new AudioTransInterfaceTranslate.IntTransJoinSessionReq();
    public AudioTransInterfaceTranslate.TransIntPushDataReq msg_push_data_req = new AudioTransInterfaceTranslate.TransIntPushDataReq();
    public AudioTransInterfaceTranslate.IntTransRawDataReq msg_raw_data_req = new AudioTransInterfaceTranslate.IntTransRawDataReq();
    public AudioTransInterfaceTranslate.IntTransReportReq msg_report_change_req = new AudioTransInterfaceTranslate.IntTransReportReq();
  }
  
  public static final class IntTransRspBody
    extends MessageMicro<IntTransRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "msg_failed_rsp", "msg_join_session_rsp", "msg_change_session_rsp", "msg_exit_session_rsp", "msg_raw_data_rsp", "msg_client_report_rsp", "msg_push_data_rsp", "msg_data_timeout_rsp", "msg_report_change_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null }, IntTransRspBody.class);
    public AudioTransInterfaceTranslate.IntTransChangeSessionRsp msg_change_session_rsp = new AudioTransInterfaceTranslate.IntTransChangeSessionRsp();
    public AudioTransInterfaceTranslate.IntTransClientReportRsp msg_client_report_rsp = new AudioTransInterfaceTranslate.IntTransClientReportRsp();
    public AudioTransInterfaceTranslate.TransIntTimeoutRsp msg_data_timeout_rsp = new AudioTransInterfaceTranslate.TransIntTimeoutRsp();
    public AudioTransInterfaceTranslate.IntTransExitSessionRsp msg_exit_session_rsp = new AudioTransInterfaceTranslate.IntTransExitSessionRsp();
    public AudioTransInterfaceTranslate.IntTransFailedRsp msg_failed_rsp = new AudioTransInterfaceTranslate.IntTransFailedRsp();
    public AudioTransInterfaceTranslate.IntTransJoinSessionRsp msg_join_session_rsp = new AudioTransInterfaceTranslate.IntTransJoinSessionRsp();
    public AudioTransInterfaceTranslate.TransIntPushDataRsp msg_push_data_rsp = new AudioTransInterfaceTranslate.TransIntPushDataRsp();
    public AudioTransInterfaceTranslate.IntTransRawDataRsp msg_raw_data_rsp = new AudioTransInterfaceTranslate.IntTransRawDataRsp();
    public AudioTransInterfaceTranslate.IntTransReportRsp msg_report_change_rsp = new AudioTransInterfaceTranslate.IntTransReportRsp();
  }
  
  public static final class TransIntPushDataReq
    extends MessageMicro<TransIntPushDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField translate_result = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "translate_result" }, new Object[] { localByteStringMicro }, TransIntPushDataReq.class);
    }
  }
  
  public static final class TransIntPushDataRsp
    extends MessageMicro<TransIntPushDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TransIntPushDataRsp.class);
  }
  
  public static final class TransIntTimeoutReq
    extends MessageMicro<TransIntTimeoutReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TransIntTimeoutReq.class);
  }
  
  public static final class TransIntTimeoutRsp
    extends MessageMicro<TransIntTimeoutRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TransIntTimeoutRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate
 * JD-Core Version:    0.7.0.1
 */