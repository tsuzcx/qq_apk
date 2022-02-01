import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;

public class asru
  extends SSOAccountObserver
{
  public asru(Login paramLogin) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    String str = paramBundle.getString("error");
    try
    {
      int i = paramBundle.getInt("code");
      arxy.a().b("agent_login", this.a.awg, 0L, 0L, i, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str, true);
      label73:
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
        this.a.Q.sendMessage(localMessage);
        QLog.d("Login", 1, "rec | cmd:  | uin : *" + artw.qx(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
        return;
        localMessage.what = 2;
        paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
        Bundle localBundle = localMessage.getData();
        localBundle.putInt("ret", paramInt2);
        localBundle.putInt("code", paramInt1);
        if (paramBundle != null) {
          localBundle.putString("OTHER_ERROR", paramBundle.getMessage());
        }
        for (;;)
        {
          if (!this.a.dgv) {
            break label323;
          }
          localBundle.putBoolean("pwdblank", true);
          break;
          localBundle.putString("OTHER_ERROR", this.a.getResources().getString(2131696664));
        }
        label323:
        localBundle.putBoolean("pwdblank", false);
      }
    }
    catch (Exception localException)
    {
      break label73;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    }
    for (;;)
    {
      this.a.e(paramString, paramArrayOfByte, paramBundle);
      paramInt = paramBundle.getInt("code");
      QLog.d("Login", 1, "rec | cmd: g_t_n_p | uin : *" + artw.qx(paramString) + " | ret : success | code: " + paramInt);
      try
      {
        paramBundle = arxy.a();
        long l2 = this.a.awg;
        long l3 = this.a.axH;
        if (paramArrayOfByte == null) {}
        int i;
        for (long l1 = 0L;; l1 = i)
        {
          paramBundle.b("agent_login", l2, l3, l1, paramInt, Long.parseLong(paramString), "1000069", null, true);
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
      this.a.e(paramString, paramArrayOfByte, paramBundle);
      paramInt = paramBundle.getInt("code");
      QLog.d("Login", 1, "rec | cmd: s_s_o_l | uin : *" + artw.qx(paramString) + " | ret : success | code: " + paramInt);
      try
      {
        paramBundle = arxy.a();
        long l2 = this.a.awg;
        long l3 = this.a.axH;
        if (paramArrayOfByte == null) {}
        for (long l1 = 0L;; l1 = paramInt)
        {
          paramBundle.b("agent_login", l2, l3, l1, 0, Long.parseLong(paramString), "1000069", null, true);
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
    this.a.elD();
    paramInt = paramBundle.getInt("code");
    QLog.d("Login", 1, "rec | cmd:  | uin : *" + artw.qx(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asru
 * JD-Core Version:    0.7.0.1
 */