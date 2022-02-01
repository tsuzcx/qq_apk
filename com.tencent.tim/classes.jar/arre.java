import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.SSOAccountObserver;

public class arre
  extends SSOAccountObserver
{
  public arre(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "ssoLoginObserver onFailed");
    OpenAuthorityFragment.a(this.this$0, true);
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      arxy.a().b("agent_login", OpenAuthorityFragment.b(this.this$0), 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str, true);
      aryb.a().b(1, "LOGIN_GETTICKT", paramString, OpenAuthorityFragment.a(this.this$0), null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      arts.a().a(paramString, "", OpenAuthorityFragment.a(this.this$0), "1", "1", "" + paramInt1, false, true);
      arts.a().a(paramString, "", OpenAuthorityFragment.a(this.this$0), "1", "6", "" + paramInt1, false, true);
      ahlw.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, OpenAuthorityFragment.c(this.this$0), null, false);
      ahlw.N("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: g_t_n_p | uin : *" + artw.qx(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        OpenAuthorityFragment.a(this.this$0, SystemClock.elapsedRealtime());
        QLog.d("SSOAccountObserver", 1, "<TimeStamp> login cost : " + (OpenAuthorityFragment.a(this.this$0) - OpenAuthorityFragment.b(this.this$0)));
        if ((paramInt1 == 1002) && (OpenAuthorityFragment.a(this.this$0) < 2))
        {
          OpenAuthorityFragment.b(this.this$0);
          this.this$0.login();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "report login error : ", paramBundle);
      }
      this.this$0.ef(3003, this.this$0.getResources().getString(2131696664));
      paramString = this.this$0.b.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.this$0.getResources().getString(2131696664);
      this.this$0.b.sendMessage(paramString);
      return;
    }
    this.this$0.WO(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramBundle.getBoolean("fake_callback");
    if ((!bool) && (paramInt == 4096)) {
      aryn.bz(paramString, l);
    }
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "ssoLoginObserver onGetTicketNoPasswd fakeCb=", Boolean.valueOf(bool) });
    int i;
    Object localObject;
    if (!bool)
    {
      i = paramBundle.getInt("code");
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "103");
      ((Bundle)localObject).putString("act_type", "10");
      ((Bundle)localObject).putString("stringext_1", "GetTicketNoPassword");
      ((Bundle)localObject).putString("intext_2", "" + i);
      ((Bundle)localObject).putString("intext_5", "" + (l - OpenAuthorityFragment.a(this.this$0).timeCost));
      arts.a().a((Bundle)localObject, OpenAuthorityFragment.a(this.this$0), paramString, false, true);
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onGetTicketNoPasswd | uin : *" + artw.qx(paramString) + " | ret : success | code: " + i + " | cost" + (OpenAuthorityFragment.a(this.this$0) - OpenAuthorityFragment.b(this.this$0)));
    }
    try
    {
      arxy.a().b("agent_login", OpenAuthorityFragment.b(this.this$0), OpenAuthorityFragment.b(this.this$0).length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null, true);
      aryb.a().b(0, "LOGIN_GETTICKT", paramString, OpenAuthorityFragment.a(this.this$0), null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      arts.a().a(paramString, "", OpenAuthorityFragment.a(this.this$0), "1", "1", "0", false, true);
      OpenAuthorityFragment.a(this.this$0, false);
      OpenAuthorityFragment.a(this.this$0, 0);
      localObject = null;
      if (paramInt == 4096) {
        localObject = new String(paramArrayOfByte);
      }
      this.this$0.d(paramString, (String)localObject, paramBundle);
      OpenAuthorityFragment.a(this.this$0, SystemClock.elapsedRealtime());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "ssoLoginObserver onUserCancel");
    paramInt = paramBundle.getInt("code");
    OpenAuthorityFragment.a(this.this$0, 0);
    OpenAuthorityFragment.a(this.this$0, SystemClock.elapsedRealtime());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<TimeStamp> login cost : " + (OpenAuthorityFragment.a(this.this$0) - OpenAuthorityFragment.b(this.this$0)));
    ahlw.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, OpenAuthorityFragment.c(this.this$0), null, false);
    ahlw.N("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: g_t_n_p | uin : *" + artw.qx(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arre
 * JD-Core Version:    0.7.0.1
 */