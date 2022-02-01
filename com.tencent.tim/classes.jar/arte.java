import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;

public class arte
{
  public PBStringField access_token = PBField.initString("");
  public PBStringField callbackURL = PBField.initString("");
  public PBStringField code = PBField.initString("");
  public PBStringField encrykey = PBField.initString("");
  public PBStringField encrytoken = PBField.initString("");
  public PBInt64Field expires_in = PBField.initInt64(0L);
  public PBStringField installwording = PBField.initString("");
  public PBStringField md5QQkey = PBField.initString("");
  public PBStringField md5key = PBField.initString("");
  public PBStringField msg = PBField.initString("");
  public PBStringField openid = PBField.initString("");
  public PBRepeatMessageField<appType.PassData> passDataResp = PBField.initRepeatMessage(appType.PassData.class);
  public PBStringField pay_token = PBField.initString("");
  public PBStringField pf = PBField.initString("");
  public PBStringField pfkey = PBField.initString("");
  public auth.ProxyAuthResponse proxy_auth_resp = new auth.ProxyAuthResponse();
  public PBUInt32Field ret = PBField.initUInt32(0);
  public PBUInt32Field sendinstall = PBField.initUInt32(0);
  public PBStringField signQQkey = PBField.initString("");
  
  public static arte a(SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    arte localarte = new arte();
    localarte.ret = paramAuthorizeResponse.ret;
    localarte.msg = paramAuthorizeResponse.msg;
    localarte.access_token = paramAuthorizeResponse.access_token;
    localarte.expires_in = paramAuthorizeResponse.expires_in;
    localarte.openid = paramAuthorizeResponse.openid;
    localarte.pay_token = paramAuthorizeResponse.pay_token;
    localarte.encrytoken = paramAuthorizeResponse.encrytoken;
    localarte.pf = paramAuthorizeResponse.pf;
    localarte.pfkey = paramAuthorizeResponse.pfkey;
    localarte.encrykey = paramAuthorizeResponse.encrykey;
    localarte.md5key = paramAuthorizeResponse.md5key;
    localarte.sendinstall = paramAuthorizeResponse.sendinstall;
    localarte.installwording = paramAuthorizeResponse.installwording;
    localarte.passDataResp = paramAuthorizeResponse.passDataResp;
    localarte.signQQkey = paramAuthorizeResponse.signQQkey;
    localarte.md5QQkey = paramAuthorizeResponse.md5QQkey;
    localarte.callbackURL = paramAuthorizeResponse.callbackURL;
    return localarte;
  }
  
  public static arte a(auth.AuthResponse paramAuthResponse)
  {
    arte localarte = new arte();
    localarte.ret = paramAuthResponse.ret;
    localarte.msg = paramAuthResponse.msg;
    localarte.access_token = paramAuthResponse.access_token;
    localarte.expires_in = paramAuthResponse.expires_in;
    localarte.openid = paramAuthResponse.openid;
    localarte.pay_token = paramAuthResponse.pay_token;
    localarte.encrytoken = paramAuthResponse.encrytoken;
    localarte.pf = paramAuthResponse.pf;
    localarte.pfkey = paramAuthResponse.pfkey;
    localarte.passDataResp = paramAuthResponse.pass_data_resp;
    localarte.callbackURL = paramAuthResponse.callback_url;
    localarte.proxy_auth_resp = paramAuthResponse.proxy_auth_resp;
    localarte.code = paramAuthResponse.code;
    return localarte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arte
 * JD-Core Version:    0.7.0.1
 */