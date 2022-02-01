package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qconn.protofile.appType.LoginSig;
import com.tencent.qconn.protofile.appType.PassData;

public final class SdkAuthorize
{
  public static final class AuthorizeRequest
    extends MessageMicro<AuthorizeRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 122, 128, 138, 144, 152, 160, 170, 178, 522, 562 }, new String[] { "response_type", "client_id", "openapi", "pf", "need_pay", "sign", "sdkv", "sdkp", "time", "qqv", "os", "passData", "skey", "vkey", "sid", "app_type", "appUniqueIdentifier", "referer", "vID", "needUniversalLink", "bundleid_from_app", "universal_link_from_app", "login_sig", "url_encoded_data" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", Long.valueOf(0L), "", "", "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(1), Long.valueOf(0L), Boolean.valueOf(false), "", "", null, "" }, AuthorizeRequest.class);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBStringField bundleid_from_app = PBField.initString("");
    public final PBInt64Field client_id = PBField.initInt64(0L);
    public appType.LoginSig login_sig = new appType.LoginSig();
    public final PBBoolField needUniversalLink = PBField.initBool(false);
    public final PBSInt32Field need_pay = PBField.initSInt32(0);
    public final PBRepeatField<Integer> openapi = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField os = PBField.initString("");
    public final PBStringField passData = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField qqv = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public final PBStringField response_type = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField sdkv = PBField.initString("");
    public final PBStringField sid = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0L);
    public final PBStringField universal_link_from_app = PBField.initString("");
    public final PBStringField url_encoded_data = PBField.initString("");
    public final PBUInt64Field vID = PBField.initUInt64(0L);
    public final PBStringField vkey = PBField.initString("");
  }
  
  public static final class AuthorizeResponse
    extends MessageMicro<AuthorizeResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130, 138, 146 }, new String[] { "ret", "msg", "access_token", "expires_in", "openid", "pay_token", "encrytoken", "pf", "pfkey", "encrykey", "md5key", "sendinstall", "installwording", "passDataResp", "signQQkey", "md5QQkey", "callbackURL", "universalLink" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), "", "", "", "", "", "", "", Integer.valueOf(0), "", null, "", "", "", "" }, AuthorizeResponse.class);
    public final PBStringField access_token = PBField.initString("");
    public final PBStringField callbackURL = PBField.initString("");
    public final PBStringField encrykey = PBField.initString("");
    public final PBStringField encrytoken = PBField.initString("");
    public final PBInt64Field expires_in = PBField.initInt64(0L);
    public final PBStringField installwording = PBField.initString("");
    public final PBStringField md5QQkey = PBField.initString("");
    public final PBStringField md5key = PBField.initString("");
    public final PBStringField msg = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBRepeatMessageField<appType.PassData> passDataResp = PBField.initRepeatMessage(appType.PassData.class);
    public final PBStringField pay_token = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBUInt32Field sendinstall = PBField.initUInt32(0);
    public final PBStringField signQQkey = PBField.initString("");
    public final PBStringField universalLink = PBField.initString("");
  }
  
  public static final class GetAuthApiListRequest
    extends MessageMicro<GetAuthApiListRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 80, 90, 96, 106, 112, 522, 562 }, new String[] { "client_id", "scope", "pf", "sign", "sdkv", "sdkp", "time", "qqv", "os", "need_pay", "skey", "app_type", "appUniqueIdentifier", "referer", "login_sig", "url_encoded_data" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(1), null, "" }, GetAuthApiListRequest.class);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBInt64Field client_id = PBField.initInt64(0L);
    public appType.LoginSig login_sig = new appType.LoginSig();
    public final PBSInt32Field need_pay = PBField.initSInt32(0);
    public final PBStringField os = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField qqv = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public final PBStringField scope = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField sdkv = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0L);
    public final PBStringField url_encoded_data = PBField.initString("");
  }
  
  public static final class GetAuthApiListResponse
    extends MessageMicro<GetAuthApiListResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "ret", "msg", "oauth_host_nick", "oauth_host_uin", "oauth_app_name", "oauth_portrait_url", "authorized_form_list", "key_type", "redirect_time", "auth_response", "AuthorizedUnionText" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), "", "", null, Integer.valueOf(0), Integer.valueOf(0), null, "" }, GetAuthApiListResponse.class);
    public final PBStringField AuthorizedUnionText = PBField.initString("");
    public SdkAuthorize.AuthorizeResponse auth_response = new SdkAuthorize.AuthorizeResponse();
    public final PBRepeatMessageField<appType.AuthItem> authorized_form_list = PBField.initRepeatMessage(appType.AuthItem.class);
    public final PBUInt32Field key_type = PBField.initUInt32(0);
    public final PBStringField msg = PBField.initString("");
    public final PBStringField oauth_app_name = PBField.initString("");
    public final PBStringField oauth_host_nick = PBField.initString("");
    public final PBInt64Field oauth_host_uin = PBField.initInt64(0L);
    public final PBStringField oauth_portrait_url = PBField.initString("");
    public final PBUInt32Field redirect_time = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize
 * JD-Core Version:    0.7.0.1
 */