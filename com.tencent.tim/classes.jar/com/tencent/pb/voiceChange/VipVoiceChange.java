package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipVoiceChange
{
  public static final class subCmd0x1ReqAuth
    extends MessageMicro<subCmd0x1ReqAuth>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_item_id" }, new Object[] { Integer.valueOf(0) }, subCmd0x1ReqAuth.class);
    public final PBInt32Field int32_item_id = PBField.initInt32(0);
  }
  
  public static final class subCmd0x1RspAuth
    extends MessageMicro<subCmd0x1RspAuth>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret", "str_error_msg", "str_active_url" }, new Object[] { Integer.valueOf(0), "", "" }, subCmd0x1RspAuth.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBStringField str_active_url = PBField.initString("");
    public final PBStringField str_error_msg = PBField.initString("");
  }
  
  public static final class voiceChangeReq
    extends MessageMicro<voiceChangeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 82 }, new String[] { "int32_sub_cmd", "int32_platform", "str_qq_version", "msg_subcmd0x1_req_auth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, voiceChangeReq.class);
    public final PBInt32Field int32_platform = PBField.initInt32(0);
    public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
    public VipVoiceChange.subCmd0x1ReqAuth msg_subcmd0x1_req_auth = new VipVoiceChange.subCmd0x1ReqAuth();
    public final PBStringField str_qq_version = PBField.initString("");
  }
  
  public static final class voiceChangeRsp
    extends MessageMicro<voiceChangeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 42 }, new String[] { "int32_sub_cmd", "msg_subcmd0x1_rsp_auth" }, new Object[] { Integer.valueOf(0), null }, voiceChangeRsp.class);
    public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
    public VipVoiceChange.subCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new VipVoiceChange.subCmd0x1RspAuth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.voiceChange.VipVoiceChange
 * JD-Core Version:    0.7.0.1
 */