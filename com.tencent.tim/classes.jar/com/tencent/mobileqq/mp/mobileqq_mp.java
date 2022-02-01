package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp
{
  public static final class ABTestControlMsgRequest
    extends MessageMicro<ABTestControlMsgRequest>
  {
    public static final int ABTEST_GUANLIZHONGXIN = 2;
    public static final int ABTEST_SUBSCRIBE = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "versionInfo", "testType" }, new Object[] { "", Integer.valueOf(1) }, ABTestControlMsgRequest.class);
    public final PBEnumField testType = PBField.initEnum(1);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class ABTestControlMsgResponse
    extends MessageMicro<ABTestControlMsgResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "ret_info", "subscribe_newaio_switch", "abtest_switch", "extra_info" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, ABTestControlMsgResponse.class);
    public final PBInt32Field abtest_switch = PBField.initInt32(0);
    public final PBStringField extra_info = PBField.initString("");
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBInt32Field subscribe_newaio_switch = PBField.initInt32(0);
  }
  
  public static final class ActionInfo
    extends MessageMicro<ActionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "actionData", "i_actionData", "a_actionData", "appid" }, new Object[] { "", "", "", Integer.valueOf(0) }, ActionInfo.class);
    public final PBStringField a_actionData = PBField.initString("");
    public final PBStringField actionData = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField i_actionData = PBField.initString("");
  }
  
  public static final class ButtonInfo
    extends MessageMicro<ButtonInfo>
  {
    public static final int AUTH_NONE = 0;
    public static final int AUTH_SID = 1;
    public static final int AUTH_VKEY = 2;
    public static final int CLICK = 1;
    public static final int EVENT = 3;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 88, 98, 106, 112, 122, 130, 138 }, new String[] { "id", "name", "key", "url", "auth_type", "type", "sub_button", "event_id", "event_param", "is_need_lbs", "item_id", "actionInfo", "media_id", "is_new_menu", "logo_url", "bg_colors", "texture_url" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(1), null, Boolean.valueOf(false), Integer.valueOf(0), null, "", Boolean.valueOf(false), "", "", "" }, ButtonInfo.class);
    public mobileqq_mp.ActionInfo actionInfo = new mobileqq_mp.ActionInfo();
    public final PBEnumField auth_type = PBField.initEnum(0);
    public final PBStringField bg_colors = PBField.initString("");
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBRepeatMessageField<mobileqq_mp.ButtonInfo_EventInfoParam> event_param = PBField.initRepeatMessage(mobileqq_mp.ButtonInfo_EventInfoParam.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBBoolField is_new_menu = PBField.initBool(false);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBStringField key = PBField.initString("");
    public final PBStringField logo_url = PBField.initString("");
    public final PBStringField media_id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<ButtonInfo> sub_button = PBField.initRepeatMessage(ButtonInfo.class);
    public final PBStringField texture_url = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ButtonInfo_EventInfoParam
    extends MessageMicro<ButtonInfo_EventInfoParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, ButtonInfo_EventInfoParam.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class CRMSendLBSInfoRequest
    extends MessageMicro<CRMSendLBSInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 25, 34 }, new String[] { "uin", "latitude", "longitude", "cityinfo" }, new Object[] { Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), "" }, CRMSendLBSInfoRequest.class);
    public final PBStringField cityinfo = PBField.initString("");
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class CRMSendLBSInfoResponse
    extends MessageMicro<CRMSendLBSInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, CRMSendLBSInfoResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class ConfigGroupInfo
    extends MessageMicro<ConfigGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "config_info" }, new Object[] { null }, ConfigGroupInfo.class);
    public final PBRepeatMessageField<mobileqq_mp.ConfigInfo> config_info = PBField.initRepeatMessage(mobileqq_mp.ConfigInfo.class);
  }
  
  public static final class ConfigInfo
    extends MessageMicro<ConfigInfo>
  {
    public static final int LOCAL_EVENT = 3;
    public static final int NEED_UIN = 1;
    public static final int NO_AUTH = 0;
    public static final int PACF_FLOD_IN_ASSISTANT = 5;
    public static final int PACF_MSG_SETTING = 6;
    public static final int PACF_RECV_EMAIL_NOTIF = 2;
    public static final int PACF_RECV_LBS_MSG = 3;
    public static final int PACF_RECV_MSG = 1;
    public static final int PACF_RECV_MSG_NOTIF = 4;
    public static final int RICH_PIC_TEXT = 5;
    public static final int RICH_TEXT = 4;
    public static final int STATE_CHANGE = 2;
    public static final int WEBVIEW = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 74, 80 }, new String[] { "type", "title", "content", "event_id", "url", "auth_type", "state", "confirm_flag", "confirm_tips", "state_id" }, new Object[] { Integer.valueOf(1), "", "", Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(1) }, ConfigInfo.class);
    public final PBEnumField auth_type = PBField.initEnum(0);
    public final PBUInt32Field confirm_flag = PBField.initUInt32(0);
    public final PBStringField confirm_tips = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBEnumField state_id = PBField.initEnum(1);
    public final PBStringField title = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class EqqAccountInfo
    extends MessageMicro<EqqAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66, 72 }, new String[] { "uin", "name", "display_number", "summary", "certified_grade", "logo", "luin", "config_group_info", "account_flag" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Long.valueOf(0L), null, Long.valueOf(0L) }, EqqAccountInfo.class);
    public final PBUInt64Field account_flag = PBField.initUInt64(0L);
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
    public final PBStringField display_number = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class FollowRequest
    extends MessageMicro<FollowRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uin", "ext", "account_type", "luin", "type" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, FollowRequest.class);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBStringField ext = PBField.initString("");
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class FollowResponse
    extends MessageMicro<FollowResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, FollowResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class GetEqqAccountDetailInfoResponse
    extends MessageMicro<GetEqqAccountDetailInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 74, 80, 90 }, new String[] { "ret_info", "accountInfo", "address", "lng", "lat", "phone_number", "is_recv_msg", "follow_type", "config_group_info", "seqno", "introduce" }, new Object[] { null, null, "", "", "", "", Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), "" }, GetEqqAccountDetailInfoResponse.class);
    public mobileqq_mp.EqqAccountInfo accountInfo = new mobileqq_mp.EqqAccountInfo();
    public final PBStringField address = PBField.initString("");
    public final PBRepeatMessageField<mobileqq_mp.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBStringField introduce = PBField.initString("");
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBStringField lat = PBField.initString("");
    public final PBStringField lng = PBField.initString("");
    public final PBStringField phone_number = PBField.initString("");
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class GetEqqDetailInfoRequest
    extends MessageMicro<GetEqqDetailInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "eqq_id", "seqno", "leqq_id", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GetEqqDetailInfoRequest.class);
    public final PBUInt32Field eqq_id = PBField.initUInt32(0);
    public final PBUInt64Field leqq_id = PBField.initUInt64(0L);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class GetMessageConfigurationRequest
    extends MessageMicro<GetMessageConfigurationRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26 }, new String[] { "uin", "versionInfo" }, new Object[] { Long.valueOf(0L), "" }, GetMessageConfigurationRequest.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class GetMessageConfigurationResponse
    extends MessageMicro<GetMessageConfigurationResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret_info", "type" }, new Object[] { null, Integer.valueOf(0) }, GetMessageConfigurationResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class GetPublicAccountDetailInfoRequest
    extends MessageMicro<GetPublicAccountDetailInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "seqno", "uin", "luin", "version", "versionInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, GetPublicAccountDetailInfoRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class GetPublicAccountDetailInfoResponse
    extends MessageMicro<GetPublicAccountDetailInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154, 162, 170, 178, 186, 192 }, new String[] { "ret_info", "seqno", "uin", "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "config_group_info", "is_show_share_button", "is_show_follow_button", "follow_type", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_background_color", "config_background_img", "config_group_info_new", "certified_description", "unified_account_descrpition", "account_flag2" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), null, Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", null, "", "", Long.valueOf(0L) }, GetPublicAccountDetailInfoResponse.class);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
    public final PBStringField certified_description = PBField.initString("");
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBStringField config_background_color = PBField.initString("");
    public final PBStringField config_background_img = PBField.initString("");
    public final PBRepeatMessageField<mobileqq_mp.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
    public final PBRepeatMessageField<mobileqq_mp.ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
    public final PBStringField display_number = PBField.initString("");
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBBoolField is_show_follow_button = PBField.initBool(false);
    public final PBBoolField is_show_share_button = PBField.initBool(false);
    public final PBBoolField is_sync_lbs = PBField.initBool(false);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBStringField summary = PBField.initString("");
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField unified_account_descrpition = PBField.initString("");
  }
  
  public static final class GetPublicAccountMenuRequest
    extends MessageMicro<GetPublicAccountMenuRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "seqno", "uin", "luin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GetPublicAccountMenuRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class GetPublicAccountMenuResponse
    extends MessageMicro<GetPublicAccountMenuResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64 }, new String[] { "ret_info", "seqno", "uin", "button_info", "update_type", "luin", "update_internal", "menu_type" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetPublicAccountMenuResponse.class);
    public final PBRepeatMessageField<mobileqq_mp.ButtonInfo> button_info = PBField.initRepeatMessage(mobileqq_mp.ButtonInfo.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field menu_type = PBField.initUInt32(0);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field update_internal = PBField.initUInt32(0);
    public final PBUInt32Field update_type = PBField.initUInt32(0);
  }
  
  public static final class GetPublicInfoRequest
    extends MessageMicro<GetPublicInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "seqno", "uin", "luin", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GetPublicInfoRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class GetPublicInfoResponse
    extends MessageMicro<GetPublicInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ret_info", "seqno", "info" }, new Object[] { null, Integer.valueOf(0), null }, GetPublicInfoResponse.class);
    public mobileqq_mp.PublicAccountInfo info = new mobileqq_mp.PublicAccountInfo();
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class GetSharePublicAccountListRequest
    extends MessageMicro<GetSharePublicAccountListRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "seqno" }, new Object[] { Integer.valueOf(0) }, GetSharePublicAccountListRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class GetSharePublicAccountListResponse
    extends MessageMicro<GetSharePublicAccountListResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ret_info", "seqno", "share_info" }, new Object[] { null, Integer.valueOf(0), null }, GetSharePublicAccountListResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp.ShareInfo> share_info = PBField.initRepeatMessage(mobileqq_mp.ShareInfo.class);
  }
  
  public static final class GetUserEqqListRequest
    extends MessageMicro<GetUserEqqListRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "begin", "limit", "seqno", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetUserEqqListRequest.class);
    public final PBUInt32Field begin = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class GetUserEqqListResponse
    extends MessageMicro<GetUserEqqListResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "ret_info", "accountInfo", "seqno", "is_over", "next_pos" }, new Object[] { null, null, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, GetUserEqqListResponse.class);
    public final PBRepeatMessageField<mobileqq_mp.EqqAccountInfo> accountInfo = PBField.initRepeatMessage(mobileqq_mp.EqqAccountInfo.class);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBUInt32Field next_pos = PBField.initUInt32(0);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class GetUserFollowListRequest
    extends MessageMicro<GetUserFollowListRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "follow_seqno", "public_account_seqno", "begin", "limit", "is_increment", "group_info_seqno", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, GetUserFollowListRequest.class);
    public final PBUInt32Field begin = PBField.initUInt32(0);
    public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
    public final PBUInt32Field group_info_seqno = PBField.initUInt32(0);
    public final PBBoolField is_increment = PBField.initBool(false);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field public_account_seqno = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class GetUserFollowListResponse
    extends MessageMicro<GetUserFollowListResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "ret_info", "follow_seqno", "public_account_seqno", "total_count", "info", "has_next", "group_info_seqno", "group_info" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Boolean.valueOf(false), Integer.valueOf(0), null }, GetUserFollowListResponse.class);
    public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp.GroupInfo> group_info = PBField.initRepeatMessage(mobileqq_mp.GroupInfo.class);
    public final PBUInt32Field group_info_seqno = PBField.initUInt32(0);
    public final PBBoolField has_next = PBField.initBool(false);
    public final PBRepeatMessageField<mobileqq_mp.PublicAccountInfo> info = PBField.initRepeatMessage(mobileqq_mp.PublicAccountInfo.class);
    public final PBUInt32Field public_account_seqno = PBField.initUInt32(0);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field total_count = PBField.initUInt32(0);
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "id", "name", "flag" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, GroupInfo.class);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class JSApiWebServerRequest
    extends MessageMicro<JSApiWebServerRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "versionInfo", "cmd", "body" }, new Object[] { "", Integer.valueOf(0), "" }, JSApiWebServerRequest.class);
    public final PBStringField body = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class JSApiWebServerResponse
    extends MessageMicro<JSApiWebServerResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "body" }, new Object[] { null, "" }, JSApiWebServerResponse.class);
    public final PBStringField body = PBField.initString("");
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class LolaUpdateRequest
    extends MessageMicro<LolaUpdateRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "versionInfo", "request_item" }, new Object[] { "", null }, LolaUpdateRequest.class);
    public final PBRepeatMessageField<mobileqq_mp.UpdateRequestItem> request_item = PBField.initRepeatMessage(mobileqq_mp.UpdateRequestItem.class);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class LolaUpdateResponse
    extends MessageMicro<LolaUpdateResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "response_item" }, new Object[] { null, null }, LolaUpdateResponse.class);
    public final PBRepeatMessageField<mobileqq_mp.UpdateResponseItem> response_item = PBField.initRepeatMessage(mobileqq_mp.UpdateResponseItem.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class LongMsgUrlRequest
    extends MessageMicro<LongMsgUrlRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "puin", "str_fileid" }, new Object[] { Long.valueOf(0L), "" }, LongMsgUrlRequest.class);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBStringField str_fileid = PBField.initString("");
  }
  
  public static final class LongMsgUrlResponse
    extends MessageMicro<LongMsgUrlResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret_info", "str_url", "str_file_md5" }, new Object[] { null, "", "" }, LongMsgUrlResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBStringField str_file_md5 = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
  }
  
  public static final class ModuleDecrypResponse
    extends MessageMicro<ModuleDecrypResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "ret_info", "module_id", "module_version", "decrypt", "pwd" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), "" }, ModuleDecrypResponse.class);
    public final PBBoolField decrypt = PBField.initBool(false);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
    public final PBStringField pwd = PBField.initString("");
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class ModuleDecrytRequest
    extends MessageMicro<ModuleDecrytRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "versionInfo", "module_id", "module_version" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, ModuleDecrytRequest.class);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class PAInfoElem
    extends MessageMicro<PAInfoElem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "puin", "account_type", "index", "uin_seq", "time", "unread_num", "pa_msg_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, PAInfoElem.class);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBStringField pa_msg_id = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBUInt64Field time = PBField.initUInt64(0L);
    public final PBUInt64Field uin_seq = PBField.initUInt64(0L);
    public final PBUInt32Field unread_num = PBField.initUInt32(0);
  }
  
  public static final class PublicAccountInfo
    extends MessageMicro<PublicAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96, 106, 114, 120 }, new String[] { "uin", "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_group_info", "config_group_info_new", "account_flag2" }, new Object[] { Integer.valueOf(0), "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, Long.valueOf(0L) }, PublicAccountInfo.class);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
    public final PBRepeatMessageField<mobileqq_mp.ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
    public final PBStringField display_number = PBField.initString("");
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBBoolField is_sync_lbs = PBField.initBool(false);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBStringField summary = PBField.initString("");
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class PunchCardInfoRequest
    extends MessageMicro<PunchCardInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "versionInfo", "cuin", "cmd" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0) }, PunchCardInfoRequest.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field cuin = PBField.initUInt64(0L);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class PunchCardInfoResponse
    extends MessageMicro<PunchCardInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "body" }, new Object[] { null, "" }, PunchCardInfoResponse.class);
    public final PBStringField body = PBField.initString("");
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class ReportPublicAccountRequest
    extends MessageMicro<ReportPublicAccountRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90, 98 }, new String[] { "tag", "mainAction", "toUin", "subAction", "actionName", "fromType", "count", "result", "r2", "r3", "r4", "r5" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, ReportPublicAccountRequest.class);
    public final PBStringField actionName = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field fromType = PBField.initUInt32(0);
    public final PBStringField mainAction = PBField.initString("");
    public final PBStringField r2 = PBField.initString("");
    public final PBStringField r3 = PBField.initString("");
    public final PBStringField r4 = PBField.initString("");
    public final PBRepeatField<String> r5 = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField subAction = PBField.initString("");
    public final PBStringField tag = PBField.initString("");
    public final PBStringField toUin = PBField.initString("");
  }
  
  public static final class ReportPublicAccountResponse
    extends MessageMicro<ReportPublicAccountResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, ReportPublicAccountResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class ReportRecentListPAInfoReponse
    extends MessageMicro<ReportRecentListPAInfoReponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, ReportRecentListPAInfoReponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class ReportRecentListPAInfoRequest
    extends MessageMicro<ReportRecentListPAInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "versionInfo", "max_rows_of_screen", "pa_info_in_list" }, new Object[] { "", Integer.valueOf(0), null }, ReportRecentListPAInfoRequest.class);
    public final PBUInt32Field max_rows_of_screen = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp.PAInfoElem> pa_info_in_list = PBField.initRepeatMessage(mobileqq_mp.PAInfoElem.class);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
  
  public static final class SecMsgConfigsRequest
    extends MessageMicro<SecMsgConfigsRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SecMsgConfigsRequest.class);
  }
  
  public static final class SecMsgConfigsResponse
    extends MessageMicro<SecMsgConfigsResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_ret", "int32_show_in_palist" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SecMsgConfigsResponse.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBInt32Field int32_show_in_palist = PBField.initInt32(0);
  }
  
  public static final class SendLBSInfoRequest
    extends MessageMicro<SendLBSInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 25, 32, 42 }, new String[] { "uin", "latitude", "longitude", "luin", "cityinfo" }, new Object[] { Integer.valueOf(0), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L), "" }, SendLBSInfoRequest.class);
    public final PBStringField cityinfo = PBField.initString("");
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class SendLBSInfoResponse
    extends MessageMicro<SendLBSInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SendLBSInfoResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class SendMenuEventRequest
    extends MessageMicro<SendMenuEventRequest>
  {
    public static final int CLICK = 1;
    public static final int CUSTOM_MENU = 1;
    public static final int EVENT = 3;
    public static final int SM_CLICK = 2;
    public static final int UNKNOW = 0;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 41, 49, 56, 64, 72, 82, 90, 98, 106, 112, 122, 128, 136, 146, 154, 160, 168 }, new String[] { "uin", "key", "type", "is_need_lbs", "latitude", "longitude", "luin", "msg_id", "s_type", "url", "actionInfo", "scan_result", "media_id", "event_id", "versionInfo", "is_new_menu", "pictureCount", "lbsAddressLabel", "picture_Md5s", "scanType", "menu_type" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(1), Boolean.valueOf(false), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", null, "", "", Integer.valueOf(1), "", Boolean.valueOf(false), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, SendMenuEventRequest.class);
    public mobileqq_mp.ActionInfo actionInfo = new mobileqq_mp.ActionInfo();
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBBoolField is_new_menu = PBField.initBool(false);
    public final PBStringField key = PBField.initString("");
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBStringField lbsAddressLabel = PBField.initString("");
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBStringField media_id = PBField.initString("");
    public final PBUInt32Field menu_type = PBField.initUInt32(0);
    public final PBUInt64Field msg_id = PBField.initUInt64(0L);
    public final PBUInt32Field pictureCount = PBField.initUInt32(0);
    public final PBRepeatField<String> picture_Md5s = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField s_type = PBField.initEnum(0);
    public final PBUInt32Field scanType = PBField.initUInt32(0);
    public final PBStringField scan_result = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class SendMenuEventResponse
    extends MessageMicro<SendMenuEventResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret_info", "seqno" }, new Object[] { null, Integer.valueOf(0) }, SendMenuEventResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class SendOrderPayEventRequest
    extends MessageMicro<SendOrderPayEventRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "versionInfo", "cmd", "body" }, new Object[] { "", Integer.valueOf(0), "" }, SendOrderPayEventRequest.class);
    public final PBStringField body = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class SendOrderPayEventResponse
    extends MessageMicro<SendOrderPayEventResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SendOrderPayEventResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class SendPreMessageStatusRequest
    extends MessageMicro<SendPreMessageStatusRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "luin", "uint64_unique_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, SendPreMessageStatusRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0L);
  }
  
  public static final class SendPreMessageStatusResponse
    extends MessageMicro<SendPreMessageStatusResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SendPreMessageStatusResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class SendPublicAccountMessageReceiptRequest
    extends MessageMicro<SendPublicAccountMessageReceiptRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_unique_id", "uint32_op", "pcuin", "cuin", "receipt_type", "unique_ids" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, SendPublicAccountMessageReceiptRequest.class);
    public final PBUInt64Field cuin = PBField.initUInt64(0L);
    public final PBUInt64Field pcuin = PBField.initUInt64(0L);
    public final PBUInt32Field receipt_type = PBField.initUInt32(0);
    public final PBUInt64Field uint32_op = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0L);
    public final PBRepeatField<Long> unique_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class SendPublicAccountMessageReceiptResponse
    extends MessageMicro<SendPublicAccountMessageReceiptResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SendPublicAccountMessageReceiptResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class SetFunctionFlagRequset
    extends MessageMicro<SetFunctionFlagRequset>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uin", "type", "value", "account_type", "luin", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, SetFunctionFlagRequset.class);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field value = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class SetFunctionFlagResponse
    extends MessageMicro<SetFunctionFlagResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SetFunctionFlagResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class SetMessageConfigurationRequest
    extends MessageMicro<SetMessageConfigurationRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "type", "versionInfo" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, SetMessageConfigurationRequest.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class SetMessageConfigurationResponse
    extends MessageMicro<SetMessageConfigurationResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SetMessageConfigurationResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class SetRefuseFollowRequest
    extends MessageMicro<SetRefuseFollowRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "luin", "account_type", "refuse_forever", "refuse_period" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, SetRefuseFollowRequest.class);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBBoolField refuse_forever = PBField.initBool(false);
    public final PBUInt32Field refuse_period = PBField.initUInt32(0);
  }
  
  public static final class SetRefuseFollowResponse
    extends MessageMicro<SetRefuseFollowResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SetRefuseFollowResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class ShareInfo
    extends MessageMicro<ShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uin", "name", "luin" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, ShareInfo.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class ShareToPublicAccountRequest
    extends MessageMicro<ShareToPublicAccountRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uin", "url", "luin" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, ShareToPublicAccountRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ShareToPublicAccountResponse
    extends MessageMicro<ShareToPublicAccountResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, ShareToPublicAccountResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class SubscribeRequest
    extends MessageMicro<SubscribeRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "puin", "template_id", "msg_id", "index" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0) }, SubscribeRequest.class);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt64Field msg_id = PBField.initUInt64(0L);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBStringField template_id = PBField.initString("");
  }
  
  public static final class SubscribeResponse
    extends MessageMicro<SubscribeResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, SubscribeResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class UnFollowRequest
    extends MessageMicro<UnFollowRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "account_type", "luin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, UnFollowRequest.class);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class UnFollowResponse
    extends MessageMicro<UnFollowResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_info" }, new Object[] { null }, UnFollowResponse.class);
    public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  }
  
  public static final class UpdateRequestItem
    extends MessageMicro<UpdateRequestItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "module_id", "module_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UpdateRequestItem.class);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
  }
  
  public static final class UpdateResponseItem
    extends MessageMicro<UpdateResponseItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58 }, new String[] { "module_id", "module_version", "module_state", "download_url", "md5", "decrypt", "pwd" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Boolean.valueOf(false), "" }, UpdateResponseItem.class);
    public final PBBoolField decrypt = PBField.initBool(false);
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_state = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
    public final PBStringField pwd = PBField.initString("");
  }
  
  public static final class WebviewWhiteListRequset
    extends MessageMicro<WebviewWhiteListRequset>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "version", "qqversion", "gziped", "implat" }, new Object[] { "", "", Boolean.valueOf(false), Integer.valueOf(0) }, WebviewWhiteListRequset.class);
    public final PBBoolField gziped = PBField.initBool(false);
    public final PBUInt32Field implat = PBField.initUInt32(0);
    public final PBStringField qqversion = PBField.initString("");
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class WebviewWhiteListResponse
    extends MessageMicro<WebviewWhiteListResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField data = PBField.initString("");
    public final PBBytesField gziped_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public RetInfo ret_info = new RetInfo();
    public final PBStringField version = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "ret_info", "version", "data", "gziped_data" }, new Object[] { null, "", "", localByteStringMicro }, WebviewWhiteListResponse.class);
    }
    
    public static final class RetInfo
      extends MessageMicro<RetInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
      public final PBStringField err_info = PBField.initString("");
      public final PBUInt32Field ret_code = PBField.initUInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp
 * JD-Core Version:    0.7.0.1
 */