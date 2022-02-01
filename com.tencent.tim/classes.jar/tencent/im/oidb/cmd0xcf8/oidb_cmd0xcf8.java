package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xcf8
{
  public static final class ConfigGroupInfo
    extends MessageMicro<ConfigGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "config_info" }, new Object[] { null }, ConfigGroupInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigInfo> config_info = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigInfo.class);
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
  
  public static final class GetPublicAccountDetailInfoRequest
    extends MessageMicro<GetPublicAccountDetailInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 32, 42 }, new String[] { "seqno", "luin", "version", "versionInfo" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, GetPublicAccountDetailInfoRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class GetPublicAccountDetailInfoResponse
    extends MessageMicro<GetPublicAccountDetailInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154, 162, 170, 178, 186, 192 }, new String[] { "ret_info", "seqno", "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "config_group_info", "is_show_share_button", "is_show_follow_button", "follow_type", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_background_color", "config_background_img", "config_group_info_new", "certified_description", "unified_account_descrpition", "account_flag2" }, new Object[] { null, Integer.valueOf(0), "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), null, Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", null, "", "", Long.valueOf(0L) }, GetPublicAccountDetailInfoResponse.class);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
    public final PBStringField certified_description = PBField.initString("");
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBStringField config_background_color = PBField.initString("");
    public final PBStringField config_background_img = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigGroupInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigGroupInfo.class);
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
    public oidb_cmd0xcf8.RetInfo ret_info = new oidb_cmd0xcf8.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBStringField summary = PBField.initString("");
    public final PBStringField unified_account_descrpition = PBField.initString("");
  }
  
  public static final class GetPublicInfoRequest
    extends MessageMicro<GetPublicInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 32 }, new String[] { "seqno", "luin", "version" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GetPublicInfoRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class GetPublicInfoResponse
    extends MessageMicro<GetPublicInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ret_info", "seqno", "info" }, new Object[] { null, Integer.valueOf(0), null }, GetPublicInfoResponse.class);
    public oidb_cmd0xcf8.PublicAccountInfo info = new oidb_cmd0xcf8.PublicAccountInfo();
    public oidb_cmd0xcf8.RetInfo ret_info = new oidb_cmd0xcf8.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class PublicAccountInfo
    extends MessageMicro<PublicAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96, 106, 114, 120 }, new String[] { "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_group_info", "config_group_info_new", "account_flag2" }, new Object[] { "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, Long.valueOf(0L) }, PublicAccountInfo.class);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigGroupInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigGroupInfo.class);
    public final PBStringField display_number = PBField.initString("");
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBBoolField is_sync_lbs = PBField.initBool(false);
    public final PBUInt64Field luin = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBStringField summary = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqBody.class);
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8
 * JD-Core Version:    0.7.0.1
 */