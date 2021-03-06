import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.9.1;
import com.tencent.mobileqq.activity.SubLoginActivity.9.2;
import com.tencent.mobileqq.activity.SubLoginActivity.9.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;

public class vwr
  extends SubAccountObserver
{
  public vwr(SubLoginActivity paramSubLoginActivity) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("SubLoginActivity.onGetKeyBack() start. subUin=").append(paramString2).append(" key=");
      if (paramString3 == null)
      {
        paramString1 = null;
        QLog.d("Q.subaccount.SubLoginActivity", 2, paramString1);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString3)) {
        break label164;
      }
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "subLogin");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.a.ath();
      this.a.wz(this.a.getString(2131720605));
      this.a.runOnUiThread(new SubLoginActivity.9.3(this));
    }
    for (;;)
    {
      return;
      paramString1 = "no null.";
      break;
      label164:
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "subLogin");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBGeykey", true, 0L, 0L, paramString1, "");
      if (!SubLoginActivity.a(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount onGetKeyBack not need bind");
        }
        this.a.ath();
        paramString1 = (anxr)this.a.app.getManager(61);
        if (paramString1 != null) {
          paramString1.R(paramString2, paramString3, true);
        }
        anxk.a(this.a.app, (byte)1, paramString2);
        anxk.G(this.a.app, paramString2, 7);
        anxj.ea(this.a.app);
        anxj.dZ(this.a.app);
        this.a.setTitle("");
        anxj.j(this.a.app, this.a, paramString2);
        this.a.finish();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: sucess .........");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SubAccount", 2, "subaccount onGetKeyBack goto bind");
        }
        paramString1 = (anxo)this.a.app.getManager(28);
        if (paramString1 != null) {
          paramString1.aV(paramString2, paramString3, this.a.aOa);
        }
        this.a.baD = true;
      }
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginFailed: subLogin ...onLoginTimeout  subuin =  uin .. .errorMsg = " + paramString4);
    }
    paramString2 = new HashMap();
    paramString2.put("param_FailCode", "12002");
    paramString2.put("fail_step", "loginFail");
    paramString3 = new StringBuilder().append("subLogin:");
    if (paramString4 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      paramString2.put("fail_location", paramString1);
      anpc.a(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString2, "");
      if (!this.a.getActivity().isFinishing()) {}
      try
      {
        this.a.ath();
        this.a.runOnUiThread(new SubLoginActivity.9.2(this));
        if (TextUtils.isEmpty(paramString4))
        {
          this.a.wz(this.a.getString(2131696270));
          return;
          paramString1 = paramString4;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
        this.a.b(this.a.getResources().getString(2131719009), paramString4, null);
      }
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginSuccess: start");
    }
    if (this.a.app == null) {
      return;
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12001");
    paramString1.put("fail_step", "loginsucc");
    paramString1.put("fail_location", "subLogin");
    anpc.a(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, paramString1, "");
    aqmj.i(this.a.app.getApplication().getApplicationContext(), paramString2, true);
    this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramString2, null);
    ThreadManager.post(new SubLoginActivity.9.1(this, paramString2), 8, null, true);
  }
  
  public void onLoginTimeout(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginTimeout:  subuin =  uin");
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12004");
    paramString1.put("fail_step", "loginTimeout");
    paramString1.put("fail_location", "subLogin");
    anpc.a(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.ath();
      this.a.wz(this.a.getString(2131696270));
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void onUserCancel(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12003");
    paramString1.put("fail_step", "onUserCancel");
    paramString1.put("fail_location", "subLogin");
    anpc.a(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onUserCancel: start");
    }
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.ath();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwr
 * JD-Core Version:    0.7.0.1
 */