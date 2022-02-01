import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqCmd23;
import tencent.im.login.GatewayVerify.ReqTimWeChat;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspCmd23;
import tencent.im.login.GatewayVerify.RspTimWeChat;

public class aqnu
{
  private static String cuq;
  
  public static void eeu()
  {
    cuq = null;
  }
  
  public static String getToken()
  {
    return cuq;
  }
  
  public void a(WUserSigInfo paramWUserSigInfo)
  {
    paramWUserSigInfo = WtloginHelper.getLoginResultData(paramWUserSigInfo, 1347);
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramWUserSigInfo);
      cuq = localRspBody.msg_rsp_cmd_23.msg_rsp_time_wechat.str_wechat_register_token.get();
      if (QLog.isColorLevel()) {
        QLog.d("WechatToken", 2, new Object[] { "storeToken:", cuq });
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramWUserSigInfo)
    {
      QLog.d("WechatToken", 1, "storeOpenLoginPhoneInfo error : ", paramWUserSigInfo);
    }
  }
  
  public void b(WUserSigInfo paramWUserSigInfo)
  {
    GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
    localReqBody.msg_req_cmd_23.msg_req_tim_wechat.uint32_support_mobile_register.set(1);
    localReqBody.msg_req_cmd_23.msg_req_tim_wechat.setHasFlag(true);
    localReqBody.msg_req_cmd_23.setHasFlag(true);
    localReqBody.setHasFlag(true);
    WtloginHelper.setExtraLoginTlvValue(paramWUserSigInfo, 1346, localReqBody.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnu
 * JD-Core Version:    0.7.0.1
 */