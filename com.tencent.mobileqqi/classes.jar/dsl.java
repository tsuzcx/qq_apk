import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;

public class dsl
  extends SubAccountObserver
{
  public dsl(SubLoginActivity paramSubLoginActivity) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: start");
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.b.a(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.a.e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack:subLogin ...has Failed key  =  null");
      }
      this.a.a(this.a.getString(2131562096));
      this.a.runOnUiThread(new dsn(this));
    }
    label487:
    for (;;)
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.b.a(), "actSBGeykey", true, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: key no null");
      }
      if (!SubLoginActivity.b(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubAccount", 2, "subaccount onGetKeyBack not need bind");
        }
        this.a.e();
        SubAccountAssistantImpl.a().a(this.a.b, paramString2, paramString3);
        long l1 = SubAccountAssistantImpl.a().a(this.a.b, paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "sublogin activity status = " + l1);
        }
        SubAccountAssistantImpl localSubAccountAssistantImpl = SubAccountAssistantImpl.a();
        QQAppInterface localQQAppInterface = this.a.b;
        long l2 = Long.parseLong(paramString2);
        if (paramString3 == null)
        {
          paramString1 = null;
          localSubAccountAssistantImpl.a(localQQAppInterface, (byte)1, l2, paramString1, (int)l1);
          SubAccountAssistantImpl.a().a(this.a.b, System.currentTimeMillis() / 1000L);
          SubAccountAssistantForward.b(this.a.b);
          SubAccountAssistantForward.a(this.a.b);
          this.a.setTitle("");
          SubAccountAssistantForward.a(this.a.b, this.a, this.a.b.getAccount());
          this.a.finish();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label487;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: sucess .........");
        return;
        paramString1 = HexUtil.a(paramString3);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("SubAccount", 2, "subaccount onGetKeyBack goto bind");
        }
        SubAccountAssistantManager.a().a(this.a.b, paramString2, paramString3);
        this.a.c = true;
      }
    }
  }
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, String paramString4)
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
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.b.a(), "actSBLogin", false, 0L, 0L, paramString2, "");
      if (!this.a.a().isFinishing()) {}
      try
      {
        this.a.e();
        this.a.runOnUiThread(new dsm(this));
        if (TextUtils.isEmpty(paramString4))
        {
          this.a.a(this.a.getString(2131562451));
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
        this.a.a(paramString4);
      }
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginSuccess: start");
    }
    if (this.a.b == null) {
      return;
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12001");
    paramString1.put("fail_step", "loginsucc");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.b.a(), "actSBLogin", true, 0L, 0L, paramString1, "");
    SharedPreUtils.a(this.a.b.getApplication().getApplicationContext(), paramString2, true);
    this.a.getAppRuntime().getSubAccountKey(this.a.b.getAccount(), paramString2, SubLoginActivity.a(this.a));
    SubAccountAssistantImpl.a().a(this.a.b, paramString2, 0, "");
  }
  
  protected void onLoginTimeout(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginTimeout:  subuin =  uin");
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12004");
    paramString1.put("fail_step", "loginTimeout");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.b.a(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (!this.a.a().isFinishing()) {}
    try
    {
      this.a.e();
      this.a.a(this.a.getString(2131562451));
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
  
  protected void onUserCancel(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12003");
    paramString1.put("fail_step", "onUserCancel");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.b.a(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onUserCancel: start");
    }
    if (!this.a.a().isFinishing()) {}
    try
    {
      this.a.e();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsl
 * JD-Core Version:    0.7.0.1
 */