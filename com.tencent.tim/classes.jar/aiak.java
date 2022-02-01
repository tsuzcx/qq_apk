import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class aiak
{
  private static void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, aiak.a parama)
  {
    QLog.d("FaceLoginHelper", 1, new Object[] { "start sendPacket appid : ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("srcAppId", paramInt);
      localBundle.putString("key", paramString1);
      localBundle.putString("lightInfo", paramString4);
      localBundle.putString("method", paramString2);
      localBundle.putString("uin", paramString3);
      localBundle.putLong("nonce", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("FaceLoginHelper", 1, "sendPacket" + paramString4);
      }
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new aian(parama));
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, aiak.a parama)
  {
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    YTAGReflectLiveCheckInterface.getLiveCheckType(paramContext.getApplicationContext(), new aiam(paramInt, localAtomicBoolean, paramString1, paramString2, paramString3, paramLong, parama));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, oidb_0x5e1.RspBody paramRspBody, FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse, Runnable paramRunnable)
  {
    if (((oidb_0x5e1.UdcUinData)paramRspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() == 0)
    {
      if ((paramSecureCheckResponse == null) || (!paramSecureCheckResponse.bool_sec_pass.get()))
      {
        if (System.currentTimeMillis() - AuthDevVerifyCodeActivity.Fn >= 60000L)
        {
          aneg.a(paramQQAppInterface, new aial(paramActivity, paramString, paramRunnable));
          return;
        }
        paramRspBody = new Intent(paramActivity, AuthDevVerifyCodeActivity.class);
        paramRspBody.putExtra("k_from", "f_SetFaceData");
        paramQQAppInterface = paramString;
        if (paramString == null) {
          paramQQAppInterface = "";
        }
        paramRspBody.putExtra("phone_num", paramQQAppInterface);
        paramActivity.startActivityForResult(paramRspBody, 11);
        return;
      }
      paramQQAppInterface = new Intent(paramActivity, QQIdentiferLegacyActivity.class);
      paramQQAppInterface.putExtra("platformAppId", 101810106);
      paramQQAppInterface.putExtra("srcAppId", 101810106);
      paramQQAppInterface.putExtra("srcOpenId", paramSecureCheckResponse.str_openid.get());
      paramQQAppInterface.putExtra("key", paramSecureCheckResponse.str_tmpkey.get());
      paramQQAppInterface.putExtra("method", "setFaceData");
      paramQQAppInterface.putExtra("serviceType", 2);
      paramActivity.startActivityForResult(paramQQAppInterface, 21);
      return;
    }
    PublicFragmentActivity.startForResult(paramActivity, DeleteFaceFragment.class, 12);
  }
  
  public static abstract interface a
  {
    public abstract void a(FaceDetectForThirdPartyManager.AppConf paramAppConf);
    
    public abstract void cz(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiak
 * JD-Core Version:    0.7.0.1
 */