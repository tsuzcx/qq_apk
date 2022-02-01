import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.SSOAccountObserver;

public class arot
  extends SSOAccountObserver
{
  public arot(AuthorityActivity paramAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.this$0.dcJ = true;
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      arxy.a().b("agent_login", this.this$0.awg, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str, true);
      aryb.a().b(1, "LOGIN_GETTICKT", paramString, AuthorityActivity.cBq, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      arts.a().a(paramString, "", AuthorityActivity.cBq, "1", "1", "" + paramInt1, false, true);
      arts.a().a(paramString, "", AuthorityActivity.cBq, "1", "6", "" + paramInt1, false, true);
      ahlw.N("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
      ahlw.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, this.this$0.abu, null, true);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + artw.qx(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        this.this$0.awh = SystemClock.elapsedRealtime();
        arwt.d("Authority_TimeCost", "<TimeStamp> login cost : " + (this.this$0.awh - this.this$0.awg));
        if ((paramInt1 == 1002) && (this.this$0.ekG < 2))
        {
          paramString = this.this$0;
          paramString.ekG += 1;
          this.this$0.login();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        arwt.e("Authority_Report", "report login error : ", paramBundle);
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
      ((Bundle)localObject).putString("intext_5", "" + (l - AuthorityActivity.a(this.this$0).timeCost));
      arts.a().a((Bundle)localObject, AuthorityActivity.cBq, paramString, false, true);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + artw.qx(paramString) + " | ret : success | code: " + i);
      arwt.d("Authority_TimeCost", "<TimeStamp> login cost : " + (this.this$0.awh - this.this$0.awg));
    }
    try
    {
      arxy.a().b("agent_login", this.this$0.awg, this.this$0.aIE.length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null, true);
      aryb.a().b(0, "LOGIN_GETTICKT", paramString, AuthorityActivity.cBq, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      arts.a().a(paramString, "", AuthorityActivity.cBq, "1", "1", "0", false, true);
      this.this$0.dcJ = false;
      this.this$0.ekG = 0;
      localObject = null;
      if (paramInt == 4096) {
        localObject = new String(paramArrayOfByte);
      }
      this.this$0.d(paramString, (String)localObject, paramBundle);
      this.this$0.awh = SystemClock.elapsedRealtime();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("Authority_Report", "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("code");
    this.this$0.ekG = 0;
    this.this$0.awh = SystemClock.elapsedRealtime();
    arwt.d("Authority_TimeCost", "<TimeStamp> login cost : " + (this.this$0.awh - this.this$0.awg));
    ahlw.N("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
    ahlw.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, this.this$0.abu, null, false);
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + artw.qx(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arot
 * JD-Core Version:    0.7.0.1
 */