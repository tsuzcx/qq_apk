package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqconnect
{
  public static final class AndroidAppInfo
    extends MessageMicro<AndroidAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "pack_name", "pack_sign", "apk_down_url" }, new Object[] { "", "", "" }, AndroidAppInfo.class);
    public final PBStringField apk_down_url = PBField.initString("");
    public final PBStringField pack_name = PBField.initString("");
    public final PBStringField pack_sign = PBField.initString("");
  }
  
  public static final class Appinfo
    extends MessageMicro<Appinfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 74, 82, 90, 98, 106, 168, 176, 184, 194, 202, 208, 218, 226, 232, 240, 248, 802, 810, 818, 826 }, new String[] { "appid", "app_type", "platform", "app_name", "app_key", "app_state", "iphone_url_scheme", "android_pack_name", "icon_url", "source_url", "icon_small_url", "icon_middle_url", "tencent_docs_appinfo", "developer_uin", "app_class", "app_subclass", "remark", "icon_mini_url", "auth_time", "app_url", "universal_link", "qqconnect_feature", "is_hatchery", "test_uin_list", "template_msg_config", "mini_app_info", "web_app_info", "mobile_app_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", "", "", null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, null, null }, Appinfo.class);
    public final PBStringField android_pack_name = PBField.initString("");
    public final PBUInt32Field app_class = PBField.initUInt32(0);
    public final PBStringField app_key = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt32Field app_state = PBField.initUInt32(0);
    public final PBUInt32Field app_subclass = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBStringField app_url = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt64Field auth_time = PBField.initUInt64(0L);
    public final PBUInt64Field developer_uin = PBField.initUInt64(0L);
    public final PBStringField icon_middle_url = PBField.initString("");
    public final PBStringField icon_mini_url = PBField.initString("");
    public final PBStringField icon_small_url = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField iphone_url_scheme = PBField.initString("");
    public final PBInt32Field is_hatchery = PBField.initInt32(0);
    public qqconnect.MiniAppInfo mini_app_info = new qqconnect.MiniAppInfo();
    public qqconnect.MobileAppInfo mobile_app_info = new qqconnect.MobileAppInfo();
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field qqconnect_feature = PBField.initUInt32(0);
    public final PBStringField remark = PBField.initString("");
    public final PBStringField source_url = PBField.initString("");
    public qqconnect.TemplateMsgConfig template_msg_config = new qqconnect.TemplateMsgConfig();
    public qqconnect.TencentDocsAppinfo tencent_docs_appinfo = new qqconnect.TencentDocsAppinfo();
    public final PBRepeatField<Long> test_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField universal_link = PBField.initString("");
    public qqconnect.WebAppInfo web_app_info = new qqconnect.WebAppInfo();
  }
  
  public static final class ConnectClientInfo
    extends MessageMicro<ConnectClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 170, 178, 250, 258, 266, 330 }, new String[] { "platform", "sdk_version", "system_name", "system_version", "android_package_name", "android_signature", "ios_bundle_id", "ios_device_id", "ios_app_token", "pc_sign" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", "", "", "" }, ConnectClientInfo.class);
    public final PBStringField android_package_name = PBField.initString("");
    public final PBStringField android_signature = PBField.initString("");
    public final PBStringField ios_app_token = PBField.initString("");
    public final PBStringField ios_bundle_id = PBField.initString("");
    public final PBStringField ios_device_id = PBField.initString("");
    public final PBStringField pc_sign = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField sdk_version = PBField.initString("");
    public final PBStringField system_name = PBField.initString("");
    public final PBStringField system_version = PBField.initString("");
  }
  
  public static final class IOSAppInfo
    extends MessageMicro<IOSAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bundle_id", "url_scheme", "store_id" }, new Object[] { "", "", "" }, IOSAppInfo.class);
    public final PBStringField bundle_id = PBField.initString("");
    public final PBStringField store_id = PBField.initString("");
    public final PBStringField url_scheme = PBField.initString("");
  }
  
  public static final class MiniAppInfo
    extends MessageMicro<MiniAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 98, 104, 114, 120 }, new String[] { "super_uin", "owner_type", "owner_name", "owner_id_card_type", "owner_id_card", "owner_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, MiniAppInfo.class);
    public final PBStringField owner_id_card = PBField.initString("");
    public final PBUInt32Field owner_id_card_type = PBField.initUInt32(0);
    public final PBStringField owner_name = PBField.initString("");
    public final PBUInt32Field owner_status = PBField.initUInt32(0);
    public final PBUInt32Field owner_type = PBField.initUInt32(0);
    public final PBUInt64Field super_uin = PBField.initUInt64(0L);
  }
  
  public static final class MobileAppInfo
    extends MessageMicro<MobileAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "android_app_info", "ios_app_info" }, new Object[] { null, null }, MobileAppInfo.class);
    public final PBRepeatMessageField<qqconnect.AndroidAppInfo> android_app_info = PBField.initRepeatMessage(qqconnect.AndroidAppInfo.class);
    public final PBRepeatMessageField<qqconnect.IOSAppInfo> ios_app_info = PBField.initRepeatMessage(qqconnect.IOSAppInfo.class);
  }
  
  public static final class MsgUinInfo
    extends MessageMicro<MsgUinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 802, 810 }, new String[] { "uin", "msg_type", "appid", "app_type", "ctime", "mtime", "mp_type", "nick", "face_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, MsgUinInfo.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBStringField face_url = PBField.initString("");
    public final PBUInt32Field mp_type = PBField.initUInt32(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field mtime = PBField.initUInt32(0);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class TemplateMsgConfig
    extends MessageMicro<TemplateMsgConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "service_msg_uin", "public_msg_uin", "camp_msg_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, TemplateMsgConfig.class);
    public final PBUInt64Field camp_msg_uin = PBField.initUInt64(0L);
    public final PBUInt64Field public_msg_uin = PBField.initUInt64(0L);
    public final PBUInt64Field service_msg_uin = PBField.initUInt64(0L);
  }
  
  public static final class TencentDocsAppinfo
    extends MessageMicro<TencentDocsAppinfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "open_types", "opts", "ejs", "callback_url_test", "callback_url", "domain", "userinfo_callback", "userinfo_callback_test" }, new Object[] { "", "", "", "", "", "", "", "" }, TencentDocsAppinfo.class);
    public final PBStringField callback_url = PBField.initString("");
    public final PBStringField callback_url_test = PBField.initString("");
    public final PBStringField domain = PBField.initString("");
    public final PBStringField ejs = PBField.initString("");
    public final PBStringField open_types = PBField.initString("");
    public final PBStringField opts = PBField.initString("");
    public final PBStringField userinfo_callback = PBField.initString("");
    public final PBStringField userinfo_callback_test = PBField.initString("");
  }
  
  public static final class WebAppInfo
    extends MessageMicro<WebAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "website_url", "provider", "icp", "callback_url" }, new Object[] { "", "", "", "" }, WebAppInfo.class);
    public final PBStringField callback_url = PBField.initString("");
    public final PBStringField icp = PBField.initString("");
    public final PBStringField provider = PBField.initString("");
    public final PBStringField website_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qqconnect
 * JD-Core Version:    0.7.0.1
 */