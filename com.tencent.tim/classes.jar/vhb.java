import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class vhb
  extends acmf
{
  public vhb(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  protected void b(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    this.this$0.gV();
    Object localObject;
    if (paramBoolean)
    {
      this.this$0.J(2131720543, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      anxj.ea(this.this$0.app);
      anxj.dZ(this.this$0.app);
      anxj.eb(this.this$0.app);
      anxj.ec(this.this$0.app);
      localObject = new Intent(this.this$0, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
      ((Intent)localObject).setFlags(67108864);
      this.this$0.startActivity((Intent)localObject);
      this.this$0.finish();
    }
    for (;;)
    {
      if ((paramanxs != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramanxs.errorMsg + "...errorType = " + paramanxs.errorType);
      }
      return;
      if (paramanxs != null) {
        switch (paramanxs.errorType)
        {
        default: 
          this.this$0.J(2131720532, 0);
          break;
        case 1002: 
          anxk.a(this.this$0.app, this.this$0);
          break;
        case 1003: 
          this.this$0.J(2131720533, 0);
          break;
        case 1004: 
          String str = paramanxs.errorMsg;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.this$0.getString(2131720534);
          }
          this.this$0.cq((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhb
 * JD-Core Version:    0.7.0.1
 */