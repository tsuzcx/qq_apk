import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class dav
  extends SubAccountBindObserver
{
  public dav(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "onGetBindSubAccount: start");
    }
    this.a.f();
    if (LoginVerifyCodeActivity.a(this.a))
    {
      LoginVerifyCodeActivity.a(this.a, false);
      if ((paramBoolean) && (paramSubAccountBackProtocData != null))
      {
        SubAccountAssistantForward.b(this.a.b);
        SubAccountAssistantForward.a(this.a.b);
        SubAccountAssistantForward.c(this.a.b);
        SubAccountAssistantForward.d(this.a.b);
        SubAccountAssistantForward.a(this.a.b, this.a, this.a.b.getAccount());
        this.a.finish();
      }
    }
    while ((!paramBoolean) || (paramSubAccountBackProtocData == null) || (!paramSubAccountBackProtocData.a()))
    {
      return;
      this.a.a(2131561710, 1);
      return;
    }
    this.a.a(this.a.getString(2131562520), this.a.getString(2131563026), this.a.getString(2131562540), new dax(this));
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount: start");
    }
    this.a.g();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131561720, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      SubAccountAssistantForward.b(this.a.b);
      SubAccountAssistantForward.a(this.a.b);
      SubAccountAssistantForward.c(this.a.b);
      SubAccountAssistantForward.d(this.a.b);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", 0);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
      }
      return;
      String str;
      switch (paramSubAccountBackProtocData.p)
      {
      default: 
        this.a.a(2131561710, 0);
        break;
      case 1002: 
        localObject = this.a.getString(2131562520);
        str = this.a.getString(2131563298);
        this.a.a((String)localObject, str, new daw(this));
        break;
      case 1003: 
        this.a.a(2131563083, 0);
        break;
      case 1004: 
        str = paramSubAccountBackProtocData.a;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.a.getString(2131561474);
        }
        this.a.a((String)localObject, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dav
 * JD-Core Version:    0.7.0.1
 */