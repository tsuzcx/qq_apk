package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GatewayVerify
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 610 }, new String[] { "msg_req_third_login", "msg_req_self_phone", "msg_req_connect_login", "msg_req_cmd_23" }, new Object[] { null, null, null, null }, ReqBody.class);
    public GatewayVerify.ReqCmd23 msg_req_cmd_23 = new GatewayVerify.ReqCmd23();
    public GatewayVerify.ReqConnectLogin msg_req_connect_login = new GatewayVerify.ReqConnectLogin();
    public GatewayVerify.ReqBodySelfPhone msg_req_self_phone = new GatewayVerify.ReqBodySelfPhone();
    public GatewayVerify.ReqBodyThirdLogin msg_req_third_login = new GatewayVerify.ReqBodyThirdLogin();
  }
  
  public static final class ReqBodyApple
    extends MessageMicro<ReqBodyApple>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 114, 242, 250 }, new String[] { "str_appid", "str_user_id", "str_identity_token", "str_authorization_code", "str_nick_name", "str_gender" }, new Object[] { "", "", "", "", "", "" }, ReqBodyApple.class);
    public final PBStringField str_appid = PBField.initString("");
    public final PBStringField str_authorization_code = PBField.initString("");
    public final PBStringField str_gender = PBField.initString("");
    public final PBStringField str_identity_token = PBField.initString("");
    public final PBStringField str_nick_name = PBField.initString("");
    public final PBStringField str_user_id = PBField.initString("");
  }
  
  public static final class ReqBodyFaceBook
    extends MessageMicro<ReqBodyFaceBook>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "str_appid", "str_access_token" }, new Object[] { "", "" }, ReqBodyFaceBook.class);
    public final PBStringField str_access_token = PBField.initString("");
    public final PBStringField str_appid = PBField.initString("");
  }
  
  public static final class ReqBodyGoogle
    extends MessageMicro<ReqBodyGoogle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "str_appid", "str_id_token" }, new Object[] { "", "" }, ReqBodyGoogle.class);
    public final PBStringField str_appid = PBField.initString("");
    public final PBStringField str_id_token = PBField.initString("");
  }
  
  public static final class ReqBodySelfPhone
    extends MessageMicro<ReqBodySelfPhone>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "msg_req_check_phone", "msg_req_get_url" }, new Object[] { null, null }, ReqBodySelfPhone.class);
    public GatewayVerify.ReqBodySelfPhoneCheck msg_req_check_phone = new GatewayVerify.ReqBodySelfPhoneCheck();
    public GatewayVerify.ReqBodySelfPhoneGetUrl msg_req_get_url = new GatewayVerify.ReqBodySelfPhoneGetUrl();
  }
  
  public static final class ReqBodySelfPhoneCheck
    extends MessageMicro<ReqBodySelfPhoneCheck>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 98, 104, 114 }, new String[] { "str_upurl", "str_token", "str_msg_id", "int32_channel_id", "str_cell_ip" }, new Object[] { "", "", "", Integer.valueOf(0), "" }, ReqBodySelfPhoneCheck.class);
    public final PBInt32Field int32_channel_id = PBField.initInt32(0);
    public final PBStringField str_cell_ip = PBField.initString("");
    public final PBStringField str_msg_id = PBField.initString("");
    public final PBStringField str_token = PBField.initString("");
    public final PBStringField str_upurl = PBField.initString("");
  }
  
  public static final class ReqBodySelfPhoneGetUrl
    extends MessageMicro<ReqBodySelfPhoneGetUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 90, 98, 104 }, new String[] { "uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, ReqBodySelfPhoneGetUrl.class);
    public final PBStringField str_cell_ip = PBField.initString("");
    public final PBStringField str_mobile_phone = PBField.initString("");
    public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBodyThirdLogin
    extends MessageMicro<ReqBodyThirdLogin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88, 162, 170, 178, 186 }, new String[] { "uint32_service_type", "uin_account_type", "msg_req_google", "msg_req_facebook", "msg_req_phone", "msg_req_apple" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, ReqBodyThirdLogin.class);
    public GatewayVerify.ReqBodyApple msg_req_apple = new GatewayVerify.ReqBodyApple();
    public GatewayVerify.ReqBodyFaceBook msg_req_facebook = new GatewayVerify.ReqBodyFaceBook();
    public GatewayVerify.ReqBodyGoogle msg_req_google = new GatewayVerify.ReqBodyGoogle();
    public GatewayVerify.ReqPhoneLogin msg_req_phone = new GatewayVerify.ReqPhoneLogin();
    public final PBUInt32Field uin_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  }
  
  public static final class ReqCmd23
    extends MessageMicro<ReqCmd23>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "msg_req_tim_wechat" }, new Object[] { null }, ReqCmd23.class);
    public GatewayVerify.ReqTimWeChat msg_req_tim_wechat = new GatewayVerify.ReqTimWeChat();
  }
  
  public static final class ReqConnectLogin
    extends MessageMicro<ReqConnectLogin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_connect_data" }, new Object[] { "" }, ReqConnectLogin.class);
    public final PBStringField str_connect_data = PBField.initString("");
  }
  
  public static final class ReqPhoneLogin
    extends MessageMicro<ReqPhoneLogin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "str_country_code", "str_phone_num" }, new Object[] { "", "" }, ReqPhoneLogin.class);
    public final PBStringField str_country_code = PBField.initString("");
    public final PBStringField str_phone_num = PBField.initString("");
  }
  
  public static final class ReqTimWeChat
    extends MessageMicro<ReqTimWeChat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "uint32_support_mobile_register" }, new Object[] { Integer.valueOf(0) }, ReqTimWeChat.class);
    public final PBUInt32Field uint32_support_mobile_register = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 690 }, new String[] { "msg_rsp_third_login", "msg_rsp_self_phone", "msg_rsp_connect_login", "msg_rsp_cmd_23" }, new Object[] { null, null, null, null }, RspBody.class);
    public GatewayVerify.RspCmd23 msg_rsp_cmd_23 = new GatewayVerify.RspCmd23();
    public GatewayVerify.RspConnectLogin msg_rsp_connect_login = new GatewayVerify.RspConnectLogin();
    public GatewayVerify.RspBodySelfPhone msg_rsp_self_phone = new GatewayVerify.RspBodySelfPhone();
    public GatewayVerify.RspBodyThirdLogin msg_rsp_third_login = new GatewayVerify.RspBodyThirdLogin();
  }
  
  public static final class RspBodyApple
    extends MessageMicro<RspBodyApple>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBodyApple.class);
  }
  
  public static final class RspBodyFaceBook
    extends MessageMicro<RspBodyFaceBook>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "str_user_profile" }, new Object[] { "" }, RspBodyFaceBook.class);
    public final PBStringField str_user_profile = PBField.initString("");
  }
  
  public static final class RspBodyGoogle
    extends MessageMicro<RspBodyGoogle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "str_user_profile" }, new Object[] { "" }, RspBodyGoogle.class);
    public final PBStringField str_user_profile = PBField.initString("");
  }
  
  public static final class RspBodySelfPhone
    extends MessageMicro<RspBodySelfPhone>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "msg_rsp_check_phone", "msg_rsp_get_url" }, new Object[] { null, null }, RspBodySelfPhone.class);
    public GatewayVerify.RspBodySelfPhoneCheck msg_rsp_check_phone = new GatewayVerify.RspBodySelfPhoneCheck();
    public GatewayVerify.RspBodySelfPhoneGetUrl msg_rsp_get_url = new GatewayVerify.RspBodySelfPhoneGetUrl();
  }
  
  public static final class RspBodySelfPhoneCheck
    extends MessageMicro<RspBodySelfPhoneCheck>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 96 }, new String[] { "str_upload_redirect_url", "str_msg_id", "int32_channel_id" }, new Object[] { "", "", Integer.valueOf(0) }, RspBodySelfPhoneCheck.class);
    public final PBInt32Field int32_channel_id = PBField.initInt32(0);
    public final PBStringField str_msg_id = PBField.initString("");
    public final PBStringField str_upload_redirect_url = PBField.initString("");
  }
  
  public static final class RspBodySelfPhoneGetUrl
    extends MessageMicro<RspBodySelfPhoneGetUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 96 }, new String[] { "str_upload_url", "str_msg_id", "int32_channel_id" }, new Object[] { "", "", Integer.valueOf(0) }, RspBodySelfPhoneGetUrl.class);
    public final PBInt32Field int32_channel_id = PBField.initInt32(0);
    public final PBStringField str_msg_id = PBField.initString("");
    public final PBStringField str_upload_url = PBField.initString("");
  }
  
  public static final class RspBodyThirdLogin
    extends MessageMicro<RspBodyThirdLogin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88, 96, 162, 170, 178, 186 }, new String[] { "uint32_service_type", "uint64_qq_uin", "uint32_register_flag", "msg_rsp_google", "msg_rsp_facebook", "msg_rsp_phone", "msg_rsp_apple" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, null, null }, RspBodyThirdLogin.class);
    public GatewayVerify.RspBodyApple msg_rsp_apple = new GatewayVerify.RspBodyApple();
    public GatewayVerify.RspBodyFaceBook msg_rsp_facebook = new GatewayVerify.RspBodyFaceBook();
    public GatewayVerify.RspBodyGoogle msg_rsp_google = new GatewayVerify.RspBodyGoogle();
    public GatewayVerify.RspPhoneLogin msg_rsp_phone = new GatewayVerify.RspPhoneLogin();
    public final PBUInt32Field uint32_register_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspCmd23
    extends MessageMicro<RspCmd23>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "msg_rsp_time_wechat" }, new Object[] { null }, RspCmd23.class);
    public GatewayVerify.RspTimWeChat msg_rsp_time_wechat = new GatewayVerify.RspTimWeChat();
  }
  
  public static final class RspConnectLogin
    extends MessageMicro<RspConnectLogin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspConnectLogin.class);
  }
  
  public static final class RspPhoneLogin
    extends MessageMicro<RspPhoneLogin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "str_user_profile" }, new Object[] { "" }, RspPhoneLogin.class);
    public final PBStringField str_user_profile = PBField.initString("");
  }
  
  public static final class RspTimWeChat
    extends MessageMicro<RspTimWeChat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "str_wechat_register_token" }, new Object[] { "" }, RspTimWeChat.class);
    public final PBStringField str_wechat_register_token = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.login.GatewayVerify
 * JD-Core Version:    0.7.0.1
 */