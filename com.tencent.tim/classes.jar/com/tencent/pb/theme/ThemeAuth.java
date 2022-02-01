package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth
{
  public static final class DiyThemeDetail
    extends MessageMicro<DiyThemeDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uin32_id", "str_name", "uin32_feetype", "str_bg_url", "str_bg_thumbnail_url", "str_bg_preview_url" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "" }, DiyThemeDetail.class);
    public final PBStringField str_bg_preview_url = PBField.initString("");
    public final PBStringField str_bg_thumbnail_url = PBField.initString("");
    public final PBStringField str_bg_url = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uin32_feetype = PBField.initUInt32(0);
    public final PBUInt32Field uin32_id = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58 }, new String[] { "uint32_sub_cmd", "int32_plat_id", "str_qq_version", "uint32_qq_version", "msg_subcmd0x1_req_auth", "msg_subcmd0x2_req_check", "msg_subcmd0x3_req_set" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null, null, null }, ReqBody.class);
    public final PBInt32Field int32_plat_id = PBField.initInt32(0);
    public ThemeAuth.SubCmd0x1ReqAuth msg_subcmd0x1_req_auth = new ThemeAuth.SubCmd0x1ReqAuth();
    public ThemeAuth.SubCmd0x2ReqCheck msg_subcmd0x2_req_check = new ThemeAuth.SubCmd0x2ReqCheck();
    public ThemeAuth.SubCmd0x3ReqSet msg_subcmd0x3_req_set = new ThemeAuth.SubCmd0x3ReqSet();
    public final PBStringField str_qq_version = PBField.initString("");
    public final PBUInt32Field uint32_qq_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "msg_subcmd0x1_rsp_auth", "msg_subcmd0x2_rsp_check", "msg_subcmd0x3_rsp_set" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public ThemeAuth.SubCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new ThemeAuth.SubCmd0x1RspAuth();
    public ThemeAuth.SubCmd0x2RspCheck msg_subcmd0x2_rsp_check = new ThemeAuth.SubCmd0x2RspCheck();
    public ThemeAuth.SubCmd0x3RspSet msg_subcmd0x3_rsp_set = new ThemeAuth.SubCmd0x3RspSet();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspDiyThemeDetail
    extends MessageMicro<RspDiyThemeDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "drawer_tab_detail", "message_tab_detail", "aio_tab_detail", "friend_tab_detail", "dynamic_tab_detail" }, new Object[] { null, null, null, null, null }, RspDiyThemeDetail.class);
    public ThemeAuth.DiyThemeDetail aio_tab_detail = new ThemeAuth.DiyThemeDetail();
    public ThemeAuth.DiyThemeDetail drawer_tab_detail = new ThemeAuth.DiyThemeDetail();
    public ThemeAuth.DiyThemeDetail dynamic_tab_detail = new ThemeAuth.DiyThemeDetail();
    public ThemeAuth.DiyThemeDetail friend_tab_detail = new ThemeAuth.DiyThemeDetail();
    public ThemeAuth.DiyThemeDetail message_tab_detail = new ThemeAuth.DiyThemeDetail();
  }
  
  public static final class RspDiyThemeInfo
    extends MessageMicro<RspDiyThemeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 56, 66, 72, 82 }, new String[] { "uin32_drawer_tab_id", "str_drawer_tab_url", "uin32_message_tab_id", "str_message_tab_url", "uin32_aio_tab_id", "str_aio_tab_url", "uin32_friend_tab_id", "str_friend_tab_url", "uin32_dynamic_tab_id", "str_dynamic_tab_url" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "" }, RspDiyThemeInfo.class);
    public final PBStringField str_aio_tab_url = PBField.initString("");
    public final PBStringField str_drawer_tab_url = PBField.initString("");
    public final PBStringField str_dynamic_tab_url = PBField.initString("");
    public final PBStringField str_friend_tab_url = PBField.initString("");
    public final PBStringField str_message_tab_url = PBField.initString("");
    public final PBUInt32Field uin32_aio_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_drawer_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_dynamic_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_friend_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_message_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x1ReqAuth
    extends MessageMicro<SubCmd0x1ReqAuth>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_op_type", "uint32_theme_id", "str_theme_version", "str_theme_density_type", "rpt_msg_topic_file_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", null }, SubCmd0x1ReqAuth.class);
    public final PBRepeatMessageField<ThemeAuth.ThemeFileInfo> rpt_msg_topic_file_info = PBField.initRepeatMessage(ThemeAuth.ThemeFileInfo.class);
    public final PBStringField str_theme_density_type = PBField.initString("");
    public final PBStringField str_theme_version = PBField.initString("");
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x1RspAuth
    extends MessageMicro<SubCmd0x1RspAuth>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 72, 82, 88, 98 }, new String[] { "int32_result", "uint32_theme_id", "str_download_url", "str_version", "uint32_size", "int32_is_sound_theme", "int32_suit_id", "str_err_msg", "uint32_diy_theme_flag", "rsp_diy_theme_info", "int32_disable_download", "rsp_diy_theme_detail" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0), null }, SubCmd0x1RspAuth.class);
    public final PBInt32Field int32_disable_download = PBField.initInt32(0);
    public final PBInt32Field int32_is_sound_theme = PBField.initInt32(0);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBInt32Field int32_suit_id = PBField.initInt32(0);
    public ThemeAuth.RspDiyThemeDetail rsp_diy_theme_detail = new ThemeAuth.RspDiyThemeDetail();
    public ThemeAuth.RspDiyThemeInfo rsp_diy_theme_info = new ThemeAuth.RspDiyThemeInfo();
    public final PBStringField str_download_url = PBField.initString("");
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field uint32_diy_theme_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x2ReqCheck
    extends MessageMicro<SubCmd0x2ReqCheck>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_theme_id", "str_theme_version" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x2ReqCheck.class);
    public final PBStringField str_theme_version = PBField.initString("");
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x2RspCheck
    extends MessageMicro<SubCmd0x2RspCheck>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_result" }, new Object[] { Integer.valueOf(0) }, SubCmd0x2RspCheck.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
  }
  
  public static final class SubCmd0x3ReqSet
    extends MessageMicro<SubCmd0x3ReqSet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_theme_id", "uint32_suit_id", "uint32_diy_theme_flag", "diy_theme_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, SubCmd0x3ReqSet.class);
    public ThemeAuth.diyThemeInfo diy_theme_info = new ThemeAuth.diyThemeInfo();
    public final PBUInt32Field uint32_diy_theme_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_suit_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x3RspSet
    extends MessageMicro<SubCmd0x3RspSet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_result", "uint32_theme_id", "uint32_suit_id", "str_diy_theme_err_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, SubCmd0x3RspSet.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField str_diy_theme_err_msg = PBField.initString("");
    public final PBInt32Field uint32_suit_id = PBField.initInt32(0);
    public final PBInt32Field uint32_theme_id = PBField.initInt32(0);
  }
  
  public static final class ThemeFileInfo
    extends MessageMicro<ThemeFileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_file_path", "str_file_md5" }, new Object[] { "", "" }, ThemeFileInfo.class);
    public final PBStringField str_file_md5 = PBField.initString("");
    public final PBStringField str_file_path = PBField.initString("");
  }
  
  public static final class diyThemeInfo
    extends MessageMicro<diyThemeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uin32_drawer_tab_id", "uin32_message_tab_id", "uin32_aio_tab_id", "uin32_freind_tab_id", "uin32_dynamics_tab_id", "uin32_high_definition" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, diyThemeInfo.class);
    public final PBUInt32Field uin32_aio_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_drawer_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_dynamics_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_freind_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uin32_high_definition = PBField.initUInt32(0);
    public final PBUInt32Field uin32_message_tab_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth
 * JD-Core Version:    0.7.0.1
 */