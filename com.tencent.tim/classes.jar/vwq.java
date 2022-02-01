import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity.8.1;
import com.tencent.qphone.base.util.QLog;

public class vwq
  extends acmf
{
  public vwq(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.baD);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    if (!this.a.baD) {}
    label428:
    for (;;)
    {
      return;
      this.a.baD = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount: start");
      }
      this.a.ath();
      if (paramBoolean)
      {
        this.a.wA(this.a.getString(2131720543));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        anxj.ea(this.a.app);
        anxj.dZ(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((paramanxs == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramanxs.errorMsg + "...errorType = " + paramanxs.errorType);
        return;
        if (paramanxs == null) {
          break;
        }
        switch (paramanxs.errorType)
        {
        default: 
          this.a.wz(this.a.getString(2131720532));
          break;
        case 1002: 
          anxk.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.wz(this.a.getString(2131720533));
          break;
        case 1004: 
          String str2 = paramanxs.errorMsg;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131720534);
          }
          this.a.wz(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          anxj.s(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwq
 * JD-Core Version:    0.7.0.1
 */