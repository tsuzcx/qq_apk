package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian
{
  public static final class CRMMsgHead
    extends MessageMicro<CRMMsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "uint32_crm_sub_cmd", "uint32_ver_no", "uint64_kf_uin", "uint32_seq", "uint32_pack_num", "uint32_cur_pack", "uint64_ext_uin", "uint64_puin", "uint64_kfaccount", "uint32_terminal_version", "uint32_terminal_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, CRMMsgHead.class);
    public final PBUInt32Field uint32_crm_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_pack = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pack_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_terminal_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ext_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_kfaccount = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  }
  
  public static final class CheckMpqqRefuseFlagReq
    extends MessageMicro<CheckMpqqRefuseFlagReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mpqq_uin", "uint64_qq_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, CheckMpqqRefuseFlagReq.class);
    public final PBUInt64Field uint64_mpqq_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
  }
  
  public static final class CheckMpqqRefuseFlagRsp
    extends MessageMicro<CheckMpqqRefuseFlagRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_result", "uint32_is_refuse" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, CheckMpqqRefuseFlagRsp.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt32Field uint32_is_refuse = PBField.initUInt32(0);
  }
  
  public static final class ClickEManReqBody
    extends MessageMicro<ClickEManReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_key" }, new Object[] { "" }, ClickEManReqBody.class);
    public final PBStringField str_key = PBField.initString("");
  }
  
  public static final class ClickEManRspBody
    extends MessageMicro<ClickEManRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_ret", "str_msg" }, new Object[] { null, "" }, ClickEManRspBody.class);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
    public final PBStringField str_msg = PBField.initString("");
  }
  
  public static final class ClickReplyCmdActionReqBody
    extends MessageMicro<ClickReplyCmdActionReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 33, 41, 48, 58, 64, 72 }, new String[] { "str_key", "uint32_type", "bool_is_need_lbs", "double_latitude", "double_longitude", "uint32_src_type", "str_menu_title", "uint32_terminal_type", "uint32_pubno" }, new Object[] { "", Integer.valueOf(0), Boolean.valueOf(false), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, ClickReplyCmdActionReqBody.class);
    public final PBBoolField bool_is_need_lbs = PBField.initBool(false);
    public final PBDoubleField double_latitude = PBField.initDouble(0.0D);
    public final PBDoubleField double_longitude = PBField.initDouble(0.0D);
    public final PBStringField str_key = PBField.initString("");
    public final PBStringField str_menu_title = PBField.initString("");
    public final PBUInt32Field uint32_pubno = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class ClickReplyCmdActionRspBody
    extends MessageMicro<ClickReplyCmdActionRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_ret" }, new Object[] { null }, ClickReplyCmdActionRspBody.class);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  }
  
  public static final class CloseSessionReqBody
    extends MessageMicro<CloseSessionReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "msg_corp_report_info", "msg_ext_report_info", "uint32_close_session_time", "uint64_cqq_uin" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L) }, CloseSessionReqBody.class);
    public mobileqq_qidian.CorpReportInfo msg_corp_report_info = new mobileqq_qidian.CorpReportInfo();
    public mobileqq_qidian.ExtReportInfo msg_ext_report_info = new mobileqq_qidian.ExtReportInfo();
    public final PBUInt32Field uint32_close_session_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cqq_uin = PBField.initUInt64(0L);
  }
  
  public static final class CloseSessionRspBody
    extends MessageMicro<CloseSessionRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_ret" }, new Object[] { null }, CloseSessionRspBody.class);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  }
  
  public static final class CompanyShowCaseInfo
    extends MessageMicro<CompanyShowCaseInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "string_show_case_title", "string_show_case_link", "string_show_case_image" }, new Object[] { "", "", "" }, CompanyShowCaseInfo.class);
    public final PBStringField string_show_case_image = PBField.initString("");
    public final PBStringField string_show_case_link = PBField.initString("");
    public final PBStringField string_show_case_title = PBField.initString("");
  }
  
  public static final class ConfigCorpSimpleInfo
    extends MessageMicro<ConfigCorpSimpleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_corp_name", "str_short_name", "str_detail_desc", "str_click_url" }, new Object[] { "", "", "", "" }, ConfigCorpSimpleInfo.class);
    public final PBStringField str_click_url = PBField.initString("");
    public final PBStringField str_corp_name = PBField.initString("");
    public final PBStringField str_detail_desc = PBField.initString("");
    public final PBStringField str_short_name = PBField.initString("");
  }
  
  public static final class ConfigGroupInfo
    extends MessageMicro<ConfigGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_config_info" }, new Object[] { null }, ConfigGroupInfo.class);
    public final PBRepeatMessageField<mobileqq_qidian.ConfigInfo> rpt_msg_config_info = PBField.initRepeatMessage(mobileqq_qidian.ConfigInfo.class);
  }
  
  public static final class ConfigInfo
    extends MessageMicro<ConfigInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "uint32_type", "uint32_event", "str_title", "str_content", "str_action", "str_aaction", "str_iaction", "str_paction", "msg_corp_simple", "str_url", "str_log", "str_lat" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", null, "", "", "" }, ConfigInfo.class);
    public mobileqq_qidian.ConfigCorpSimpleInfo msg_corp_simple = new mobileqq_qidian.ConfigCorpSimpleInfo();
    public final PBStringField str_aaction = PBField.initString("");
    public final PBStringField str_action = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_iaction = PBField.initString("");
    public final PBStringField str_lat = PBField.initString("");
    public final PBStringField str_log = PBField.initString("");
    public final PBStringField str_paction = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_event = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class CorpInfo
    extends MessageMicro<CorpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74 }, new String[] { "str_corp_short_name", "str_corp_intro", "str_homepage", "str_address", "str_corp_call", "str_postcode", "str_logo", "uint64_master_uin", "str_corp_full_name" }, new Object[] { "", "", "", "", "", "", "", Long.valueOf(0L), "" }, CorpInfo.class);
    public final PBStringField str_address = PBField.initString("");
    public final PBStringField str_corp_call = PBField.initString("");
    public final PBStringField str_corp_full_name = PBField.initString("");
    public final PBStringField str_corp_intro = PBField.initString("");
    public final PBStringField str_corp_short_name = PBField.initString("");
    public final PBStringField str_homepage = PBField.initString("");
    public final PBStringField str_logo = PBField.initString("");
    public final PBStringField str_postcode = PBField.initString("");
    public final PBUInt64Field uint64_master_uin = PBField.initUInt64(0L);
  }
  
  public static final class CorpReportInfo
    extends MessageMicro<CorpReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_kfuin", "uint64_kfaccount" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, CorpReportInfo.class);
    public final PBUInt64Field uint64_kfaccount = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  }
  
  public static final class ExtReportInfo
    extends MessageMicro<ExtReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_ext_uin" }, new Object[] { Long.valueOf(0L) }, ExtReportInfo.class);
    public final PBUInt64Field uint64_ext_uin = PBField.initUInt64(0L);
  }
  
  public static final class ExternalInfo
    extends MessageMicro<ExternalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 122, 128, 136, 144, 154, 160, 170, 178, 186 }, new String[] { "uint64_uin", "str_external_nick", "str_external_icon", "str_external_sign", "uint32_external_gender", "uint64_external_country", "uint64_external_province", "uint64_external_city", "uint64_external_district", "str_external_job", "str_external_tel", "str_external_mobile", "str_external_mail", "rpt_msg_pubacc_item", "rpt_msg_group_item", "uint64_master_uin", "uint32_verity", "uint32_entcallshow", "rpt_msg_company_show_case_info", "uint32_videoshow", "str_thirdpart_verity_icon", "str_thirdpart_verity_hover", "str_thirdpart_verity_url" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", null, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "", "", "" }, ExternalInfo.class);
    public final PBRepeatMessageField<mobileqq_qidian.CompanyShowCaseInfo> rpt_msg_company_show_case_info = PBField.initRepeatMessage(mobileqq_qidian.CompanyShowCaseInfo.class);
    public final PBRepeatMessageField<mobileqq_qidian.GroupItem> rpt_msg_group_item = PBField.initRepeatMessage(mobileqq_qidian.GroupItem.class);
    public final PBRepeatMessageField<mobileqq_qidian.PubAccItem> rpt_msg_pubacc_item = PBField.initRepeatMessage(mobileqq_qidian.PubAccItem.class);
    public final PBStringField str_external_icon = PBField.initString("");
    public final PBStringField str_external_job = PBField.initString("");
    public final PBStringField str_external_mail = PBField.initString("");
    public final PBStringField str_external_mobile = PBField.initString("");
    public final PBStringField str_external_nick = PBField.initString("");
    public final PBStringField str_external_sign = PBField.initString("");
    public final PBStringField str_external_tel = PBField.initString("");
    public final PBStringField str_thirdpart_verity_hover = PBField.initString("");
    public final PBStringField str_thirdpart_verity_icon = PBField.initString("");
    public final PBStringField str_thirdpart_verity_url = PBField.initString("");
    public final PBUInt32Field uint32_entcallshow = PBField.initUInt32(0);
    public final PBUInt32Field uint32_external_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_videoshow = PBField.initUInt32(0);
    public final PBUInt64Field uint64_external_city = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_external_country = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_external_district = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_external_province = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_master_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetAccountTypeReqBody
    extends MessageMicro<GetAccountTypeReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_kfext_uin" }, new Object[] { Long.valueOf(0L) }, GetAccountTypeReqBody.class);
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetAccountTypeRspBody
    extends MessageMicro<GetAccountTypeRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_result", "uint64_kfext_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetAccountTypeRspBody.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetBusinessMobileReq
    extends MessageMicro<GetBusinessMobileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_cqquin", "uint64_extuin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetBusinessMobileReq.class);
    public final PBUInt64Field uint64_cqquin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_extuin = PBField.initUInt64(0L);
  }
  
  public static final class GetBusinessMobileRsp
    extends MessageMicro<GetBusinessMobileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_ret", "str_mobile" }, new Object[] { null, "" }, GetBusinessMobileRsp.class);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
    public final PBStringField str_mobile = PBField.initString("");
  }
  
  public static final class GetCorpUinDetailInfoReqBody
    extends MessageMicro<GetCorpUinDetailInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_req_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GetCorpUinDetailInfoReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetCorpUinDetailInfoRspBody
    extends MessageMicro<GetCorpUinDetailInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret", "msg_external_info", "rpt_msg_config_group_info" }, new Object[] { Integer.valueOf(0), null, null }, GetCorpUinDetailInfoRspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public mobileqq_qidian.ExternalInfo msg_external_info = new mobileqq_qidian.ExternalInfo();
    public final PBRepeatMessageField<mobileqq_qidian.ConfigGroupInfo> rpt_msg_config_group_info = PBField.initRepeatMessage(mobileqq_qidian.ConfigGroupInfo.class);
  }
  
  public static final class GetCustomerTransferInfoReqBody
    extends MessageMicro<GetCustomerTransferInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_qq_uin", "uint64_kfext_uin", "uint32_mobile_client", "uint32_ver_no" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetCustomerTransferInfoReqBody.class);
    public final PBUInt32Field uint32_mobile_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetCustomerTransferInfoRspBody
    extends MessageMicro<GetCustomerTransferInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_ret", "str_transfer_info", "str_link_info", "str_link_url", "str_pt_url" }, new Object[] { null, "", "", "", "" }, GetCustomerTransferInfoRspBody.class);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
    public final PBStringField str_link_info = PBField.initString("");
    public final PBStringField str_link_url = PBField.initString("");
    public final PBStringField str_pt_url = PBField.initString("");
    public final PBStringField str_transfer_info = PBField.initString("");
  }
  
  public static final class GetNavigationMenuConfigReqBody
    extends MessageMicro<GetNavigationMenuConfigReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_puin", "uint64_uin", "uint32_ver_no", "uint32_unread_msg_count", "uint32_is_click_graytip", "uint32_is_support_cc_nav" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNavigationMenuConfigReqBody.class);
    public final PBUInt32Field uint32_is_click_graytip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_support_cc_nav = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_msg_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetNavigationMenuConfigRspBody
    extends MessageMicro<GetNavigationMenuConfigRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "msg_ret", "int32_is_show", "uint32_ver_no", "uint64_puin", "uint64_kf_uin", "uint32_is_show_graytip" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GetNavigationMenuConfigRspBody.class);
    public final PBInt32Field int32_is_show = PBField.initInt32(0);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
    public final PBUInt32Field uint32_is_show_graytip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  }
  
  public static final class GetQiDianGroupInfoReq
    extends MessageMicro<GetQiDianGroupInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_groupcode", "uint64_groupowner" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetQiDianGroupInfoReq.class);
    public final PBUInt32Field uint32_groupcode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_groupowner = PBField.initUInt64(0L);
  }
  
  public static final class GetQiDianGroupInfoRsp
    extends MessageMicro<GetQiDianGroupInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_grouplink = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qrcodelink = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wpalink = PBField.initBytes(ByteStringMicro.EMPTY);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_ret", "bytes_grouplink", "bytes_wpalink", "bytes_qrcodelink" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, GetQiDianGroupInfoRsp.class);
    }
  }
  
  public static final class GetUserDetailInfoReqBody
    extends MessageMicro<GetUserDetailInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_req_type", "uint64_uin", "uint32_mobile_client" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GetUserDetailInfoReqBody.class);
    public final PBUInt32Field uint32_mobile_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetUserDetailInfoRspBody
    extends MessageMicro<GetUserDetailInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "msg_ret", "uint32_req_type", "msg_internal_info", "msg_external_info", "msg_corp_info", "rpt_msg_config_group_info" }, new Object[] { null, Integer.valueOf(0), null, null, null, null }, GetUserDetailInfoRspBody.class);
    public mobileqq_qidian.CorpInfo msg_corp_info = new mobileqq_qidian.CorpInfo();
    public mobileqq_qidian.ExternalInfo msg_external_info = new mobileqq_qidian.ExternalInfo();
    public mobileqq_qidian.InternalInfo msg_internal_info = new mobileqq_qidian.InternalInfo();
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
    public final PBRepeatMessageField<mobileqq_qidian.ConfigGroupInfo> rpt_msg_config_group_info = PBField.initRepeatMessage(mobileqq_qidian.ConfigGroupInfo.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class GroupItem
    extends MessageMicro<GroupItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_groupid", "uint32_group_level", "str_group_name", "uint32_member_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0) }, GroupItem.class);
    public final PBStringField str_group_name = PBField.initString("");
    public final PBUInt32Field uint32_group_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_groupid = PBField.initUInt64(0L);
  }
  
  public static final class InternalInfo
    extends MessageMicro<InternalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 90, 98, 106, 114, 122, 130 }, new String[] { "uint64_uin", "str_internal_icon", "str_strID", "str_name", "str_internal_sign", "uint32_internal_gender", "uint64_internal_country", "uint64_internal_province", "uint64_internal_city", "uint64_internal_district", "rpt_msg_org_job_union", "str_internal_tel", "str_internal_mobile", "str_internal_corp_mail", "str_internal_regular_mail", "str_internal_job" }, new Object[] { Long.valueOf(0L), "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, "", "", "", "", "" }, InternalInfo.class);
    public final PBRepeatMessageField<mobileqq_qidian.OrgJobUnion> rpt_msg_org_job_union = PBField.initRepeatMessage(mobileqq_qidian.OrgJobUnion.class);
    public final PBStringField str_internal_corp_mail = PBField.initString("");
    public final PBStringField str_internal_icon = PBField.initString("");
    public final PBStringField str_internal_job = PBField.initString("");
    public final PBStringField str_internal_mobile = PBField.initString("");
    public final PBStringField str_internal_regular_mail = PBField.initString("");
    public final PBStringField str_internal_sign = PBField.initString("");
    public final PBStringField str_internal_tel = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_strID = PBField.initString("");
    public final PBUInt32Field uint32_internal_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_internal_city = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_internal_country = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_internal_district = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_internal_province = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class NotRecvQdGroupMsgReq
    extends MessageMicro<NotRecvQdGroupMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_extuin", "uint64_kfuin", "uint64_taskid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, NotRecvQdGroupMsgReq.class);
    public final PBUInt64Field uint64_extuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_taskid = PBField.initUInt64(0L);
  }
  
  public static final class NotRecvQdGroupMsgRsp
    extends MessageMicro<NotRecvQdGroupMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_ret" }, new Object[] { null }, NotRecvQdGroupMsgRsp.class);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  }
  
  public static final class OrgJobUnion
    extends MessageMicro<OrgJobUnion>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_parentorgid", "str_job" }, new Object[] { Long.valueOf(0L), "" }, OrgJobUnion.class);
    public final PBStringField str_job = PBField.initString("");
    public final PBUInt64Field uint64_parentorgid = PBField.initUInt64(0L);
  }
  
  public static final class PubAccItem
    extends MessageMicro<PubAccItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64, 72, 82, 90, 98 }, new String[] { "uint32_type", "str_uin", "uint32_verity", "str_name", "str_desc", "str_verify_data", "uint64_state", "uint32_grade", "uint64_display", "str_extra", "str_face_url", "str_qr_url" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", "", "" }, PubAccItem.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_extra = PBField.initString("");
    public final PBStringField str_face_url = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_qr_url = PBField.initString("");
    public final PBStringField str_uin = PBField.initString("");
    public final PBStringField str_verify_data = PBField.initString("");
    public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verity = PBField.initUInt32(0);
    public final PBUInt64Field uint64_display = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_state = PBField.initUInt64(0L);
  }
  
  public static final class QidianWpaAddFriendReqBody
    extends MessageMicro<QidianWpaAddFriendReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_visitID", "uint64_customer_uin" }, new Object[] { "", Long.valueOf(0L) }, QidianWpaAddFriendReqBody.class);
    public final PBStringField str_visitID = PBField.initString("");
    public final PBUInt64Field uint64_customer_uin = PBField.initUInt64(0L);
  }
  
  public static final class QidianWpaAddFriendRspBody
    extends MessageMicro<QidianWpaAddFriendRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_ret" }, new Object[] { null }, QidianWpaAddFriendRspBody.class);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 8066, 8074, 8082, 8090, 8098, 8146 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_wpa_assign_kfext_req", "msg_wpa_sigt_to_sigmsg_req", "msg_click_reply_cmd_action_req", "msg_get_user_detail_info_req", "msg_get_account_type_req", "msg_get_business_mobile_req", "msg_verify_wpa_uin_and_key_req", "msg_check_mpqq_refuse_flag_req", "msg_get_customer_transfer_info_req", "msg_not_recv_qd_group_msg_req", "msg_get_navigation_menu_config_req_body", "msg_req_corpuin_wpa_req", "msg_get_corpuin_detail_info_req_body", "msg_click_eman_req", "msg_close_session_req", "msg_qidian_wpa_addfriend_req", "msg_get_qidian_group_info_req" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public mobileqq_qidian.CheckMpqqRefuseFlagReq msg_check_mpqq_refuse_flag_req = new mobileqq_qidian.CheckMpqqRefuseFlagReq();
    public mobileqq_qidian.ClickEManReqBody msg_click_eman_req = new mobileqq_qidian.ClickEManReqBody();
    public mobileqq_qidian.ClickReplyCmdActionReqBody msg_click_reply_cmd_action_req = new mobileqq_qidian.ClickReplyCmdActionReqBody();
    public mobileqq_qidian.CloseSessionReqBody msg_close_session_req = new mobileqq_qidian.CloseSessionReqBody();
    public mobileqq_qidian.CRMMsgHead msg_crm_common_head = new mobileqq_qidian.CRMMsgHead();
    public mobileqq_qidian.GetAccountTypeReqBody msg_get_account_type_req = new mobileqq_qidian.GetAccountTypeReqBody();
    public mobileqq_qidian.GetBusinessMobileReq msg_get_business_mobile_req = new mobileqq_qidian.GetBusinessMobileReq();
    public mobileqq_qidian.GetCorpUinDetailInfoReqBody msg_get_corpuin_detail_info_req_body = new mobileqq_qidian.GetCorpUinDetailInfoReqBody();
    public mobileqq_qidian.GetCustomerTransferInfoReqBody msg_get_customer_transfer_info_req = new mobileqq_qidian.GetCustomerTransferInfoReqBody();
    public mobileqq_qidian.GetNavigationMenuConfigReqBody msg_get_navigation_menu_config_req_body = new mobileqq_qidian.GetNavigationMenuConfigReqBody();
    public mobileqq_qidian.GetQiDianGroupInfoReq msg_get_qidian_group_info_req = new mobileqq_qidian.GetQiDianGroupInfoReq();
    public mobileqq_qidian.GetUserDetailInfoReqBody msg_get_user_detail_info_req = new mobileqq_qidian.GetUserDetailInfoReqBody();
    public mobileqq_qidian.NotRecvQdGroupMsgReq msg_not_recv_qd_group_msg_req = new mobileqq_qidian.NotRecvQdGroupMsgReq();
    public mobileqq_qidian.QidianWpaAddFriendReqBody msg_qidian_wpa_addfriend_req = new mobileqq_qidian.QidianWpaAddFriendReqBody();
    public mobileqq_qidian.ReqCorpUinWpaReq msg_req_corpuin_wpa_req = new mobileqq_qidian.ReqCorpUinWpaReq();
    public mobileqq_qidian.VerifyWpaUinAndKeyReq msg_verify_wpa_uin_and_key_req = new mobileqq_qidian.VerifyWpaUinAndKeyReq();
    public mobileqq_qidian.WpaAssignKfextReqBody msg_wpa_assign_kfext_req = new mobileqq_qidian.WpaAssignKfextReqBody();
    public mobileqq_qidian.WpaSigtToSigMsgReqBody msg_wpa_sigt_to_sigmsg_req = new mobileqq_qidian.WpaSigtToSigMsgReqBody();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class ReqCorpUinWpaReq
    extends MessageMicro<ReqCorpUinWpaReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sigt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_assign_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_assign_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "bytes_sigt", "uint64_qquin", "uint64_touin", "uint32_assign_type", "uint64_assign_id" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqCorpUinWpaReq.class);
    }
  }
  
  public static final class ReqCorpUinWpaRsp
    extends MessageMicro<ReqCorpUinWpaRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sigmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
    public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_ret", "uint32_aio_type", "bytes_sigmsg" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, ReqCorpUinWpaRsp.class);
    }
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_ret_code", "str_error_msg" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 8066, 8074, 8082, 8090, 8098, 8146 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_wpa_assign_kfext_rsp", "msg_wpa_sigt_to_sigmsg_rsp", "msg_click_reply_cmd_action_rsp", "msg_subcmd_get_user_detail_info_rsp_body", "msg_get_account_type_rsp", "msg_get_business_mobile_rsp", "msg_verify_wpa_uin_and_key_rsp", "msg_check_mpqq_refuse_flag_rsp", "msg_get_customer_transfer_info_rsp", "msg_not_recv_qd_group_msg_rsp", "msg_get_navigation_menu_config_rsp_body", "msg_req_corpuin_wpa_rsp", "msg_get_corpuin_detail_info_rsp_body", "msg_click_eman_rsp", "msg_close_session_rsp", "msg_qidian_wpa_addfriend_rsp", "msg_get_qidian_group_info_rsp" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
    public mobileqq_qidian.CheckMpqqRefuseFlagRsp msg_check_mpqq_refuse_flag_rsp = new mobileqq_qidian.CheckMpqqRefuseFlagRsp();
    public mobileqq_qidian.ClickEManRspBody msg_click_eman_rsp = new mobileqq_qidian.ClickEManRspBody();
    public mobileqq_qidian.ClickReplyCmdActionRspBody msg_click_reply_cmd_action_rsp = new mobileqq_qidian.ClickReplyCmdActionRspBody();
    public mobileqq_qidian.CloseSessionRspBody msg_close_session_rsp = new mobileqq_qidian.CloseSessionRspBody();
    public mobileqq_qidian.CRMMsgHead msg_crm_common_head = new mobileqq_qidian.CRMMsgHead();
    public mobileqq_qidian.GetAccountTypeRspBody msg_get_account_type_rsp = new mobileqq_qidian.GetAccountTypeRspBody();
    public mobileqq_qidian.GetBusinessMobileRsp msg_get_business_mobile_rsp = new mobileqq_qidian.GetBusinessMobileRsp();
    public mobileqq_qidian.GetCorpUinDetailInfoRspBody msg_get_corpuin_detail_info_rsp_body = new mobileqq_qidian.GetCorpUinDetailInfoRspBody();
    public mobileqq_qidian.GetCustomerTransferInfoRspBody msg_get_customer_transfer_info_rsp = new mobileqq_qidian.GetCustomerTransferInfoRspBody();
    public mobileqq_qidian.GetNavigationMenuConfigRspBody msg_get_navigation_menu_config_rsp_body = new mobileqq_qidian.GetNavigationMenuConfigRspBody();
    public mobileqq_qidian.GetQiDianGroupInfoRsp msg_get_qidian_group_info_rsp = new mobileqq_qidian.GetQiDianGroupInfoRsp();
    public mobileqq_qidian.NotRecvQdGroupMsgRsp msg_not_recv_qd_group_msg_rsp = new mobileqq_qidian.NotRecvQdGroupMsgRsp();
    public mobileqq_qidian.QidianWpaAddFriendRspBody msg_qidian_wpa_addfriend_rsp = new mobileqq_qidian.QidianWpaAddFriendRspBody();
    public mobileqq_qidian.ReqCorpUinWpaRsp msg_req_corpuin_wpa_rsp = new mobileqq_qidian.ReqCorpUinWpaRsp();
    public mobileqq_qidian.GetUserDetailInfoRspBody msg_subcmd_get_user_detail_info_rsp_body = new mobileqq_qidian.GetUserDetailInfoRspBody();
    public mobileqq_qidian.VerifyWpaUinAndKeyRsp msg_verify_wpa_uin_and_key_rsp = new mobileqq_qidian.VerifyWpaUinAndKeyRsp();
    public mobileqq_qidian.WpaAssignKfextRspBody msg_wpa_assign_kfext_rsp = new mobileqq_qidian.WpaAssignKfextRspBody();
    public mobileqq_qidian.WpaSigtToSigMsgRspBody msg_wpa_sigt_to_sigmsg_rsp = new mobileqq_qidian.WpaSigtToSigMsgRspBody();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class VerifyWpaUinAndKeyReq
    extends MessageMicro<VerifyWpaUinAndKeyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uint64_dst_uin", "str_key", "str_json_info", "str_rkey", "uint32_terminal_type", "uint32_terminal_version" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, VerifyWpaUinAndKeyReq.class);
    public final PBStringField str_json_info = PBField.initString("");
    public final PBStringField str_key = PBField.initString("");
    public final PBStringField str_rkey = PBField.initString("");
    public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_terminal_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  }
  
  public static final class VerifyWpaUinAndKeyRsp
    extends MessageMicro<VerifyWpaUinAndKeyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_result", "uint32_is_valid", "str_welcome_word" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, VerifyWpaUinAndKeyRsp.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField str_welcome_word = PBField.initString("");
    public final PBUInt32Field uint32_is_valid = PBField.initUInt32(0);
  }
  
  public static final class WpaAssignKfextReqBody
    extends MessageMicro<WpaAssignKfextReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_need_sigmsg = PBField.initBool(false);
    public final PBBytesField bytes_sigT_kf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_rkey = PBField.initString("");
    public final PBUInt32Field uint32_wpa_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_assign_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_customer_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "uint32_wpa_type", "bytes_sigT_kf", "uint64_assign_id", "uint64_customer_uin", "str_rkey", "bool_need_sigmsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), "", Boolean.valueOf(false) }, WpaAssignKfextReqBody.class);
    }
  }
  
  public static final class WpaAssignKfextRspBody
    extends MessageMicro<WpaAssignKfextRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sigT_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sigmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ext_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "int32_result", "uint64_ext_uin", "bytes_sigT_ext", "str_err_msg", "uint32_aio_type", "bytes_sigmsg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, "", Integer.valueOf(0), localByteStringMicro2 }, WpaAssignKfextRspBody.class);
    }
  }
  
  public static final class WpaSigtToSigMsgReqBody
    extends MessageMicro<WpaSigtToSigMsgReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sigT_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_sigT_ext", "uint64_kfext_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, WpaSigtToSigMsgReqBody.class);
    }
  }
  
  public static final class WpaSigtToSigMsgRspBody
    extends MessageMicro<WpaSigtToSigMsgRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sigmsg_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "int32_result", "bytes_sigmsg_ext", "uint64_kfext_uin", "str_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), "" }, WpaSigtToSigMsgRspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian
 * JD-Core Version:    0.7.0.1
 */