import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountBaseActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class dnh
  extends SubAccountBindObserver
{
  public dnh(SubLoginActivity paramSubLoginActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetBindSubAccount: start");
    }
    this.a.e();
    if (SubLoginActivity.a(this.a))
    {
      SubLoginActivity.a(this.a, false);
      if ((paramBoolean) && (paramSubAccountBackProtocData != null))
      {
        SubAccountAssistantForward.b(this.a.b);
        SubAccountAssistantForward.a(this.a.b);
        SubAccountAssistantForward.a(this.a.b, this.a, this.a.b.getAccount());
        this.a.finish();
      }
    }
    while ((!paramBoolean) || (paramSubAccountBackProtocData == null) || (!paramSubAccountBackProtocData.a()))
    {
      return;
      this.a.a(this.a.getString(2131562086));
      return;
    }
    this.a.a(this.a.getString(2131562520), this.a.getString(2131563026), this.a.getString(2131562540), new dnk(this));
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (!this.a.c) {}
    for (;;)
    {
      return;
      this.a.c = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount: start");
      }
      this.a.e();
      Object localObject;
      if (paramBoolean)
      {
        if (SubAccountBaseActivity.b) {
          ReportController.a(this.a.b, "CliOper", "", "", "0X8004003", "0X8004003", 0, 0, "", "", "", "");
        }
        this.a.b(this.a.getString(2131561720));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        SubAccountAssistantForward.b(this.a.b);
        SubAccountAssistantForward.a(this.a.b);
        localObject = new Intent(this.a, SplashActivity.class);
        ((Intent)localObject).putExtra("tab_index", 0);
        ((Intent)localObject).setFlags(67108864);
        this.a.startActivity((Intent)localObject);
        this.a.finish();
      }
      while ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel()))
      {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
        return;
        String str;
        switch (paramSubAccountBackProtocData.p)
        {
        default: 
          this.a.a(this.a.getString(2131561710));
          break;
        case 1002: 
          localObject = this.a.getString(2131562520);
          str = this.a.getString(2131563286);
          this.a.a((String)localObject, str, new dni(this));
          break;
        case 1003: 
          this.a.a(this.a.getString(2131563083));
          break;
        case 1004: 
          str = paramSubAccountBackProtocData.a;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131561474);
          }
          this.a.a((String)localObject);
          this.a.runOnUiThread(new dnj(this));
          SubLoginActivity.a(this.a, null);
          SubAccountAssistantForward.a(this.a.b, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnh
 * JD-Core Version:    0.7.0.1
 */