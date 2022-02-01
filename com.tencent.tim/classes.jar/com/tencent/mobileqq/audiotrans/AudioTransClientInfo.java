package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientInfo
{
  public static final class InfoC2SCreateSessionReq
    extends MessageMicro<InfoC2SCreateSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_business_type", "rpt_member_list" }, new Object[] { Integer.valueOf(1), "" }, InfoC2SCreateSessionReq.class);
    public final PBEnumField enum_business_type = PBField.initEnum(1);
    public final PBRepeatField<String> rpt_member_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class InfoC2SCreateSessionRsp
    extends MessageMicro<InfoC2SCreateSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "enum_channel_type", "rpt_msg_interface_list", "bool_client_ans" }, new Object[] { Integer.valueOf(1), null, Boolean.valueOf(false) }, InfoC2SCreateSessionRsp.class);
    public final PBBoolField bool_client_ans = PBField.initBool(false);
    public final PBEnumField enum_channel_type = PBField.initEnum(1);
    public final PBRepeatMessageField<AudioTransCommon.NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon.NetAddr.class);
  }
  
  public static final class InfoC2SFailedRsp
    extends MessageMicro<InfoC2SFailedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_errcode", "str_errmsg" }, new Object[] { Integer.valueOf(0), "" }, InfoC2SFailedRsp.class);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
  }
  
  public static final class InfoHead
    extends MessageMicro<InfoHead>
  {
    public static final int INFO_C2S_CREATE_SESSION_REQ = 1;
    public static final int INFO_C2S_CREATE_SESSION_RSP = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_session_id", "str_uin", "uint32_seq", "enum_body_type", "uint32_error_no" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, InfoHead.class);
    public final PBEnumField enum_body_type = PBField.initEnum(1);
    public final PBStringField str_session_id = PBField.initString("");
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class InfoReqBody
    extends MessageMicro<InfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_create_session_req" }, new Object[] { null }, InfoReqBody.class);
    public AudioTransClientInfo.InfoC2SCreateSessionReq msg_create_session_req = new AudioTransClientInfo.InfoC2SCreateSessionReq();
  }
  
  public static final class InfoRspBody
    extends MessageMicro<InfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_failed_rsp", "msg_create_session_rsp" }, new Object[] { null, null }, InfoRspBody.class);
    public AudioTransClientInfo.InfoC2SCreateSessionRsp msg_create_session_rsp = new AudioTransClientInfo.InfoC2SCreateSessionRsp();
    public AudioTransClientInfo.InfoC2SFailedRsp msg_failed_rsp = new AudioTransClientInfo.InfoC2SFailedRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInfo
 * JD-Core Version:    0.7.0.1
 */