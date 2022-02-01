import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment.a;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspBodySelfPhone;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneCheck;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneGetUrl;

public class vie
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  public vie(NewAuthDevUgFragment paramNewAuthDevUgFragment) {}
  
  public void onReceive(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt, Object paramObject)
  {
    int i = 1;
    if (this.a.Qk())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onReceive getActivity is null or activity is finish");
      return;
    }
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onReceive, type is ", paramNotifyType, ", ret is ", Integer.valueOf(paramInt), "data == null ? ", Boolean.valueOf(bool) });
      if ((paramNotifyType != VerifyDevLockManager.NotifyType.NOTIFY_GET_GATEWAY_URL) || (paramInt != 239)) {
        break label317;
      }
      if (paramObject != null) {
        break;
      }
      try
      {
        QLog.e("NewAuthDevUgFragment", 1, "data is null");
        NewAuthDevUgFragment.a(this.a);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramNotifyType)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "onReceive, GatewayVerify.RspBody mergeFrom error : ", paramNotifyType.getMessage() });
        NewAuthDevUgFragment.a(this.a, "V_GET_GATEWAY_URL_ERROR", paramInt, paramNotifyType.getMessage());
        NewAuthDevUgFragment.a(this.a);
        return;
      }
    }
    paramObject = (byte[])paramObject;
    paramNotifyType = new GatewayVerify.RspBody();
    paramNotifyType.mergeFrom(paramObject);
    paramObject = paramNotifyType.msg_rsp_self_phone.msg_rsp_get_url.str_upload_url.get();
    NewAuthDevUgFragment.a(this.a, paramNotifyType.msg_rsp_self_phone.msg_rsp_get_url.int32_channel_id.get());
    NewAuthDevUgFragment.a(this.a, paramNotifyType.msg_rsp_self_phone.msg_rsp_get_url.str_msg_id.get());
    NewAuthDevUgFragment.b(this.a, 0);
    NewAuthDevUgFragment.a(this.a, true);
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "msgid: ", NewAuthDevUgFragment.a(this.a), " channelId : ", Integer.valueOf(NewAuthDevUgFragment.a(this.a)) });
    NewAuthDevUgFragment.a(this.a).a(paramObject, NewAuthDevUgFragment.a(this.a));
    return;
    label317:
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_CHECK_SELF_PHONE)
    {
      if (paramInt == 160)
      {
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "");
        NewAuthDevUgFragment.a(this.a);
        return;
      }
      if (paramInt == 241)
      {
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "");
        NewAuthDevUgFragment.b(this.a);
        return;
      }
      if (paramInt == 242)
      {
        if (paramObject == null) {
          try
          {
            QLog.e("NewAuthDevUgFragment", 1, "data is null");
            NewAuthDevUgFragment.a(this.a);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramNotifyType)
          {
            QLog.e("NewAuthDevUgFragment", 1, new Object[] { "onReceive, GatewayVerify.RspBody mergeFrom error : ", paramNotifyType.getMessage() });
            NewAuthDevUgFragment.a(this.a);
            return;
          }
        }
        paramNotifyType = (byte[])paramObject;
        paramObject = new GatewayVerify.RspBody();
        paramObject.mergeFrom(paramNotifyType);
        paramNotifyType = paramObject.msg_rsp_self_phone.msg_rsp_check_phone.str_upload_redirect_url.get();
        NewAuthDevUgFragment.a(this.a).vP(paramNotifyType);
        return;
      }
      NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "");
      NewAuthDevUgFragment.a(this.a);
      return;
    }
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_GET_GATEWAY_URL) {
      if (i == 0) {
        break label544;
      }
    }
    label544:
    for (paramNotifyType = "V_GET_GATEWAY_URL_ERROR";; paramNotifyType = "V_VERIFY_TOKEN_ERROR")
    {
      NewAuthDevUgFragment.a(this.a, paramNotifyType, paramInt, "");
      NewAuthDevUgFragment.a(this.a);
      return;
      i = 0;
      break;
    }
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.a.Qk())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onVerifyClose getActivity is null or activity is finish");
      return;
    }
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onVerifyClose ret : ", Integer.valueOf(paramInt2) });
    if (paramInt2 == 0)
    {
      NewAuthDevUgFragment.a(this.a, false);
      NewAuthDevUgFragment.a(this.a, "V_RET_SUCCESS", paramInt2, "");
      this.a.getActivity().finish();
      return;
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onVerifyClose error, ret : ", Integer.valueOf(paramInt2) });
    NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, paramErrMsg.getMessage());
    NewAuthDevUgFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vie
 * JD-Core Version:    0.7.0.1
 */