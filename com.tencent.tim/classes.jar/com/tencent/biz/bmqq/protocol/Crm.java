package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Crm
{
  public static final class C2CActionReport
    extends MessageMicro<C2CActionReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_action_content" }, new Object[] { "" }, C2CActionReport.class);
    public final PBStringField str_action_content = PBField.initString("");
  }
  
  public static final class CrmAllocKfext
    extends MessageMicro<CrmAllocKfext>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField crm_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field crm_msg_flag = PBField.initUInt32(0);
    public final PBInt32Field int32_flag = PBField.initInt32(0);
    public final PBStringField str_add_tips = PBField.initString("");
    public final PBUInt32Field uint32_track_right = PBField.initUInt32(0);
    public final PBUInt64Field uint64_alloc_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_alloc_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58 }, new String[] { "int32_flag", "crm_msg_flag", "crm_msg", "uint64_alloc_from_uin", "uint64_alloc_to_uin", "uint32_track_right", "str_add_tips" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, CrmAllocKfext.class);
    }
  }
  
  public static final class CrmCCNotify
    extends MessageMicro<CrmCCNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_video_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public Crm.CrmAllocKfext crm_alloc_kfext = new Crm.CrmAllocKfext();
    public final PBUInt32Field crm_flag = PBField.initUInt32(0);
    public final PBUInt32Field crm_user_type = PBField.initUInt32(0);
    public Crm.LightTalkMsg light_talk_msg = new Crm.LightTalkMsg();
    public Crm.C2CActionReport msg_c2c_action_report = new Crm.C2CActionReport();
    public Crm.GrayMsg msg_gray_msg = new Crm.GrayMsg();
    public Crm.LinkTextWithOpenAIOAction msg_linktext_withOepenAIO = new Crm.LinkTextWithOpenAIOAction();
    public Crm.QidianGroupMsg qidian_group_msg = new Crm.QidianGroupMsg();
    public final PBStringField str_check_id = PBField.initString("");
    public final PBStringField str_client_headurl = PBField.initString("");
    public final PBStringField str_client_nickname = PBField.initString("");
    public final PBStringField str_ext_nick_name = PBField.initString("");
    public final PBStringField str_publicacc_name = PBField.initString("");
    public final PBStringField str_visitId = PBField.initString("");
    public final PBStringField str_wx_openid = PBField.initString("");
    public Crm.SvrCCMsgFlag svr_cc_msg_flag = new Crm.SvrCCMsgFlag();
    public final PBUInt32Field uint32_IsTipsMode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_pubacc_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_real_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 106, 112, 122, 130, 138, 226, 338, 354 }, new String[] { "crm_flag", "crm_alloc_kfext", "str_wx_openid", "bytes_video_uuid", "crm_user_type", "uint64_real_uin", "str_client_headurl", "str_client_nickname", "uint64_pubacc_id", "str_publicacc_name", "light_talk_msg", "msg_linktext_withOepenAIO", "msg_c2c_action_report", "uint32_IsTipsMode", "svr_cc_msg_flag", "qidian_group_msg", "str_visitId", "msg_gray_msg", "str_check_id", "str_ext_nick_name" }, new Object[] { Integer.valueOf(0), null, "", localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), "", "", Long.valueOf(0L), "", null, null, null, Integer.valueOf(0), null, null, "", null, "", "" }, CrmCCNotify.class);
    }
  }
  
  public static final class GrayMsg
    extends MessageMicro<GrayMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "str_text", "uint64_from_uin" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, GrayMsg.class);
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  }
  
  public static final class LightTalkMsg
    extends MessageMicro<LightTalkMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cuin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_client_headurl = PBField.initString("");
    public final PBStringField str_client_nickname = PBField.initString("");
    public final PBStringField str_mobile_number = PBField.initString("");
    public final PBUInt32Field uint32_call_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_model_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_duration = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_timestap = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_timestap = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_virtual_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 64, 72, 82, 90, 96 }, new String[] { "bytes_cuin", "uint64_virtual_uin", "str_mobile_number", "uint32_model_type", "uint32_call_type", "uint32_call_result", "uint64_start_timestap", "uint64_end_timestap", "uint64_duration", "str_client_headurl", "str_client_nickname", "uint32_mobile_source" }, new Object[] { localByteStringMicro, Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0) }, LightTalkMsg.class);
    }
  }
  
  public static final class LinkTextWithOpenAIOAction
    extends MessageMicro<LinkTextWithOpenAIOAction>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_uin", "str_link_text", "str_attach_content" }, new Object[] { Long.valueOf(0L), "", "" }, LinkTextWithOpenAIOAction.class);
    public final PBStringField str_attach_content = PBField.initString("");
    public final PBStringField str_link_text = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class QidianGroupMsg
    extends MessageMicro<QidianGroupMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint32_group_task_id", "uint32_group_msg_type", "uint64_kfuin", "uint32_show_tip", "str_tip_text" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, QidianGroupMsg.class);
    public final PBStringField str_tip_text = PBField.initString("");
    public final PBUInt32Field uint32_group_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_task_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_tip = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  }
  
  public static final class SvrCCMsgFlag
    extends MessageMicro<SvrCCMsgFlag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "str_text_msg" }, new Object[] { Integer.valueOf(0), "" }, SvrCCMsgFlag.class);
    public final PBStringField str_text_msg = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.Crm
 * JD-Core Version:    0.7.0.1
 */