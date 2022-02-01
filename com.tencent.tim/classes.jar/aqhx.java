import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aqhx
  extends jnm.d
{
  aqhx(aqhv paramaqhv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ahlw.x("KEY_STAGE_2_CONNECT_MINI_D55", bool);
      if (this.this$0.cUh)
      {
        this.this$0.cUh = false;
        this.this$0.hideProgressDialog();
      }
      if (!this.this$0.cUg) {
        break;
      }
      QQToast.a(this.this$0.context, 1, 2131701796, 1).show();
      paramArrayOfByte = new Intent(this.this$0.context, SplashActivity.class);
      paramArrayOfByte.addFlags(67108864);
      paramArrayOfByte.addFlags(268435456);
      this.this$0.context.startActivity(paramArrayOfByte);
      aqhv.d(this.this$0);
      return;
    }
    if (this.this$0.dJ != null) {
      this.this$0.dJ.removeCallbacksAndMessages(null);
    }
    paramBundle = aqhv.a(this.this$0);
    if (paramInt == 0)
    {
      anot.a(this.this$0.app, "dc01160", "", "", "0X800A51A", "0X800A51A", 0, 0, "", "", this.ctp, this.ctq);
      paramBundle.putExtra("mini_app_id", this.ctq);
      paramBundle.putExtra("mini_app_path", this.ctr);
      paramBundle.putExtra("mini_app_type", this.cts);
    }
    for (;;)
    {
      this.this$0.context.startActivity(paramBundle);
      aqhv.d(this.this$0);
      return;
      if (paramInt == 25501)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "Account not the same");
        }
        anot.a(this.this$0.app, "dc01160", "", "", "0X800A51A", "0X800A51A", 0, 0, "", "", this.ctp, this.ctq);
        paramBundle.putExtra("mini_app_id", this.ctq);
        paramBundle.putExtra("mini_app_path", this.ctr);
        paramBundle.putExtra("mini_app_type", this.cts);
        paramBundle.putExtra("openid", this.ctt);
        paramBundle.putExtra("appid", this.ctp);
        paramBundle.putExtra("pull_show_open_id_diff_main", true);
      }
      else
      {
        paramArrayOfByte = aceo.p(paramArrayOfByte);
        anot.a(this.this$0.app, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, paramInt, "", "", this.ctp, this.ctq);
        if (paramInt == 25601)
        {
          paramBundle.putExtra("pull_mini_app_not_privilege_not_bind", true);
          paramBundle.putExtra("pull_mini_app_not_privilege_not_bind_app_name", this.ctu);
        }
        paramBundle.putExtra("pull_mini_app_not_privilege", true);
        paramBundle.putExtra("pull_mini_app_not_privilege_string", paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhx
 * JD-Core Version:    0.7.0.1
 */