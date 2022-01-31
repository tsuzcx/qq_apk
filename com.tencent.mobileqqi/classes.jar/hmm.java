import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SSOAccountObserver;

public class hmm
  extends SSOAccountObserver
{
  public hmm(AuthorityActivity paramAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.j = true;
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      ReportManager.a().a("agent_login", this.a.e, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        this.a.f = SystemClock.elapsedRealtime();
        LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
        if ((paramInt1 == 1002) && (this.a.A < 2))
        {
          paramString = this.a;
          paramString.A += 1;
          this.a.i();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", paramBundle);
      }
      this.a.a(3003, this.a.getResources().getString(2131562443));
      paramString = this.a.a.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.a.getResources().getString(2131562443);
      this.a.a.sendMessage(paramString);
      return;
    }
    this.a.e(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    int i = paramBundle.getInt("code");
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : success" + " | code: " + i);
    LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
    try
    {
      ReportManager.a().a("agent_login", this.a.e, this.a.n.length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null);
      this.a.j = false;
      this.a.A = 0;
      String str = null;
      if (paramInt == 4096) {
        str = new String(paramArrayOfByte);
      }
      this.a.a(paramString, str, paramBundle);
      this.a.f = SystemClock.elapsedRealtime();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("code");
    this.a.A = 0;
    this.a.f = SystemClock.elapsedRealtime();
    LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel" + " | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hmm
 * JD-Core Version:    0.7.0.1
 */