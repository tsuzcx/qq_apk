import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class fil
  extends SSOAccountObserver
{
  public fil(Login paramLogin) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    String str = paramBundle.getString("error");
    try
    {
      int i = paramBundle.getInt("code");
      ReportManager.a().a("agent_login", this.a.jdField_a_of_type_Long, 0L, 0L, i, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      label72:
      if (QLog.isColorLevel()) {
        QLog.d("SSOAccountObserver", 2, "onFail:account=" + paramString + " action=" + paramInt1 + " ret=" + paramInt2);
      }
      Message localMessage = new Message();
      paramInt1 = paramBundle.getInt("code");
      if (paramInt2 == -1000) {
        localMessage.what = 1;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        QLog.d("Login", 1, "rec | cmd:  | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
        return;
        localMessage.what = 2;
        ErrMsg localErrMsg = null;
        if (paramBundle != null) {
          localErrMsg = (ErrMsg)paramBundle.getParcelable("lastError");
        }
        paramBundle = localMessage.getData();
        if (localErrMsg != null) {
          paramBundle.putString("OTHER_ERROR", localErrMsg.getMessage());
        }
        for (;;)
        {
          if (!this.a.jdField_b_of_type_Boolean) {
            break label312;
          }
          paramBundle.putBoolean("pwdblank", true);
          break;
          if (!TextUtils.isEmpty(str)) {
            paramBundle.putString("OTHER_ERROR", str);
          }
        }
        label312:
        paramBundle.putBoolean("pwdblank", false);
      }
    }
    catch (Exception localException)
    {
      break label72;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    }
    for (;;)
    {
      this.a.a(paramString, paramArrayOfByte, paramBundle);
      paramInt = paramBundle.getInt("code");
      QLog.d("Login", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : success" + " | code: " + paramInt);
      try
      {
        paramBundle = ReportManager.a();
        long l2 = this.a.jdField_a_of_type_Long;
        long l3 = this.a.jdField_b_of_type_Long;
        if (paramArrayOfByte == null) {}
        int i;
        for (long l1 = 0L;; l1 = i)
        {
          paramBundle.a("agent_login", l2, l3, l1, paramInt, Long.parseLong(paramString), "1000069", null);
          return;
          i = paramArrayOfByte.length();
        }
        paramArrayOfByte = null;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    }
    for (;;)
    {
      this.a.a(paramString, paramArrayOfByte, paramBundle);
      paramInt = paramBundle.getInt("code");
      QLog.d("Login", 1, "rec | cmd: s_s_o_l | uin : *" + AuthorityUtil.a(paramString) + " | ret : success" + " | code: " + paramInt);
      try
      {
        paramBundle = ReportManager.a();
        long l2 = this.a.jdField_a_of_type_Long;
        long l3 = this.a.jdField_b_of_type_Long;
        if (paramArrayOfByte == null) {}
        for (long l1 = 0L;; l1 = paramInt)
        {
          paramBundle.a("agent_login", l2, l3, l1, 0, Long.parseLong(paramString), "1000069", null);
          return;
          paramInt = paramArrayOfByte.length();
        }
        paramArrayOfByte = null;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOAccountObserver", 2, "onUserCancel ssoAccount=" + paramString + " action=" + paramInt);
    }
    this.a.f();
    paramInt = paramBundle.getInt("code");
    QLog.d("Login", 1, "rec | cmd:  | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel" + " | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fil
 * JD-Core Version:    0.7.0.1
 */