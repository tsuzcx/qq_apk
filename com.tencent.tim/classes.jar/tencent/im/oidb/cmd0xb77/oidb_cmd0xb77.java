package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb77
{
  public static final class ArkJsonBody
    extends MessageMicro<ArkJsonBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "json_str" }, new Object[] { "" }, ArkJsonBody.class);
    public final PBStringField json_str = PBField.initString("");
  }
  
  public static final class ArkMsgBody
    extends MessageMicro<ArkMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 82, 90, 98, 106, 114, 122, 130, 162 }, new String[] { "app", "view", "prompt", "ver", "desc", "feature_id", "meta", "meta_url1", "meta_url2", "meta_url3", "meta_text1", "meta_text2", "meta_text3", "config" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "", "", "", "", "", "", "", "" }, ArkMsgBody.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField config = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field feature_id = PBField.initUInt32(0);
    public final PBStringField meta = PBField.initString("");
    public final PBStringField meta_text1 = PBField.initString("");
    public final PBStringField meta_text2 = PBField.initString("");
    public final PBStringField meta_text3 = PBField.initString("");
    public final PBStringField meta_url1 = PBField.initString("");
    public final PBStringField meta_url2 = PBField.initString("");
    public final PBStringField meta_url3 = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBStringField view = PBField.initString("");
  }
  
  public static final class ArkV1MsgBody
    extends MessageMicro<ArkV1MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 82, 90, 162 }, new String[] { "app", "view", "prompt", "ver", "desc", "feature_id", "meta", "items", "config" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "", null, "" }, ArkV1MsgBody.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField config = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field feature_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xb77.TemplateItem> items = PBField.initRepeatMessage(oidb_cmd0xb77.TemplateItem.class);
    public final PBStringField meta = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBStringField view = PBField.initString("");
  }
  
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "platform", "sdk_version", "android_package_name", "android_signature", "ios_bundle_id", "pc_sign" }, new Object[] { Integer.valueOf(0), "", "", "", "", "" }, ClientInfo.class);
    public final PBStringField android_package_name = PBField.initString("");
    public final PBStringField android_signature = PBField.initString("");
    public final PBStringField ios_bundle_id = PBField.initString("");
    public final PBStringField pc_sign = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField sdk_version = PBField.initString("");
  }
  
  public static final class ExtInfo
    extends MessageMicro<ExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 98, 104, 112, 120 }, new String[] { "rpt_custom_featureid", "apns_wording", "uint32_group_savedb_flag", "receiver_appid", "msg_seq" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ExtInfo.class);
    public final PBStringField apns_wording = PBField.initString("");
    public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
    public final PBUInt32Field receiver_appid = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_custom_featureid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_group_savedb_flag = PBField.initUInt32(0);
  }
  
  public static final class ImageInfo
    extends MessageMicro<ImageInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 808, 816, 824 }, new String[] { "md5", "uuid", "img_type", "file_size", "width", "height", "original", "file_id", "server_ip", "server_port" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ImageInfo.class);
    public final PBUInt32Field file_id = PBField.initUInt32(0);
    public final PBUInt32Field file_size = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field img_type = PBField.initUInt32(0);
    public final PBStringField md5 = PBField.initString("");
    public final PBUInt32Field original = PBField.initUInt32(0);
    public final PBUInt32Field server_ip = PBField.initUInt32(0);
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    public final PBStringField uuid = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class MiniAppMsgBody
    extends MessageMicro<MiniAppMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 82 }, new String[] { "mini_app_appid", "mini_app_path", "web_page_url", "mini_app_type", "title", "desc", "json_str" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "" }, MiniAppMsgBody.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField json_str = PBField.initString("");
    public final PBUInt64Field mini_app_appid = PBField.initUInt64(0L);
    public final PBStringField mini_app_path = PBField.initString("");
    public final PBUInt32Field mini_app_type = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField web_page_url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 80, 88, 98, 106, 114, 122, 130, 138, 146 }, new String[] { "appid", "app_type", "msg_style", "sender_uin", "client_info", "text_msg", "ext_info", "send_type", "recv_uin", "rich_msg_body", "ark_msg_body", "recv_openid", "arkv1_msg_body", "ark_json_body", "xml_msg_body", "mini_app_msg_body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, "", null, Integer.valueOf(0), Long.valueOf(0L), null, null, "", null, null, null, null }, ReqBody.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public oidb_cmd0xb77.ArkJsonBody ark_json_body = new oidb_cmd0xb77.ArkJsonBody();
    public oidb_cmd0xb77.ArkMsgBody ark_msg_body = new oidb_cmd0xb77.ArkMsgBody();
    public oidb_cmd0xb77.ArkV1MsgBody arkv1_msg_body = new oidb_cmd0xb77.ArkV1MsgBody();
    public oidb_cmd0xb77.ClientInfo client_info = new oidb_cmd0xb77.ClientInfo();
    public oidb_cmd0xb77.ExtInfo ext_info = new oidb_cmd0xb77.ExtInfo();
    public oidb_cmd0xb77.MiniAppMsgBody mini_app_msg_body = new oidb_cmd0xb77.MiniAppMsgBody();
    public final PBUInt32Field msg_style = PBField.initUInt32(0);
    public final PBStringField recv_openid = PBField.initString("");
    public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
    public oidb_cmd0xb77.RichMsgBody rich_msg_body = new oidb_cmd0xb77.RichMsgBody();
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public final PBUInt64Field sender_uin = PBField.initUInt64(0L);
    public final PBStringField text_msg = PBField.initString("");
    public oidb_cmd0xb77.XmlMsgBody xml_msg_body = new oidb_cmd0xb77.XmlMsgBody();
  }
  
  public static final class RichMsgBody
    extends MessageMicro<RichMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90, 98, 106, 114, 122, 130, 170 }, new String[] { "using_ark", "title", "summary", "brief", "url", "picture_url", "action", "music_url", "image_info" }, new Object[] { Boolean.valueOf(false), "", "", "", "", "", "", "", null }, RichMsgBody.class);
    public final PBStringField action = PBField.initString("");
    public final PBStringField brief = PBField.initString("");
    public oidb_cmd0xb77.ImageInfo image_info = new oidb_cmd0xb77.ImageInfo();
    public final PBStringField music_url = PBField.initString("");
    public final PBStringField picture_url = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBBoolField using_ark = PBField.initBool(false);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "wording", "jump_result", "jump_url", "uint32_level", "uint32_sub_level", "develop_msg" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
    public final PBStringField develop_msg = PBField.initString("");
    public final PBUInt32Field jump_result = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_level = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class TemplateItem
    extends MessageMicro<TemplateItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "key", "type", "value" }, new Object[] { "", Integer.valueOf(0), "" }, TemplateItem.class);
    public final PBStringField key = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class XmlMsgBody
    extends MessageMicro<XmlMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 98 }, new String[] { "service_id", "xml" }, new Object[] { Integer.valueOf(0), "" }, XmlMsgBody.class);
    public final PBUInt32Field service_id = PBField.initUInt32(0);
    public final PBStringField xml = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77
 * JD-Core Version:    0.7.0.1
 */