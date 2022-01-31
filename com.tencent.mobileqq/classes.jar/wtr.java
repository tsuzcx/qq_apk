import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class wtr
  extends ContactBindObserver
{
  public wtr(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i;
    if ((this.a.b == 10) || (this.a.b == 11) || (this.a.b == 15) || (this.a.b == 17))
    {
      this.a.rightViewText.setEnabled(true);
      this.a.b();
      if (!paramBoolean) {
        break label570;
      }
      i = paramBundle.getInt("k_result");
      if ((i != 104) && (i != 0)) {
        break label304;
      }
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("kSrouce", this.a.b);
      paramBundle.putExtra("keyReqBindMode", this.a.c);
      paramBundle.putExtra("k_number", BindVerifyActivity.a(this.a));
      paramBundle.putExtra("k_country_code", BindVerifyActivity.b(this.a));
      paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
      paramBundle.putExtra("cmd_param_is_from_uni", BindVerifyActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_change_bind", BindVerifyActivity.b(this.a));
      paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      label226:
      if ((paramBundle != null) && (!this.a.isFinishing()))
      {
        paramBundle.addFlags(536870912);
        paramBundle.addFlags(67108864);
        this.a.startActivityForResult(paramBundle, 0);
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
      BindVerifyActivity.a(this.a, null);
      return;
      BindVerifyActivity.a(this.a).setEnabled(true);
      break;
      label304:
      if (i == 107)
      {
        Intent localIntent = new Intent(this.a, RebindActivity.class);
        localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
        localIntent.putExtra("k_number", BindVerifyActivity.a(this.a));
        localIntent.putExtra("k_country_code", BindVerifyActivity.b(this.a));
        localIntent.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
        localIntent.putExtra("cmd_param_is_from_uni", BindVerifyActivity.a(this.a));
        localIntent.putExtra("cmd_param_is_from_change_bind", BindVerifyActivity.b(this.a));
        localIntent.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
        paramBundle = localIntent;
        break label226;
      }
      if (i == 106)
      {
        paramBundle = new Intent();
        paramBundle.putExtra("bind_mobile", BindVerifyActivity.a(this.a).getText().toString().trim());
        this.a.setResult(-1, paramBundle);
        if (this.a.getIntent().getBooleanExtra("k_is_block", false)) {
          ReportController.b(this.a.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 2, 0, "", "", "", "");
        }
        this.a.finish();
        paramBundle = null;
        break label226;
      }
      this.a.b(a(i));
      paramBundle = null;
      break label226;
      label570:
      this.a.b(2131434455);
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b();
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onRebindMobile ,isSuccess = " + paramBoolean + ",data = " + paramBundle);
    }
    if (paramBoolean)
    {
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("kSrouce", this.a.b);
      paramBundle.putExtra("keyReqBindMode", this.a.c);
      paramBundle.putExtra("k_number", BindVerifyActivity.a(this.a));
      paramBundle.putExtra("k_country_code", BindVerifyActivity.b(this.a));
      paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
      paramBundle.putExtra("cmd_param_is_from_uni", BindVerifyActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_change_bind", BindVerifyActivity.b(this.a));
      paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      if ((paramBundle != null) && (!this.a.isFinishing()))
      {
        paramBundle.addFlags(536870912);
        paramBundle.addFlags(67108864);
        this.a.startActivityForResult(paramBundle, 0);
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
      BindVerifyActivity.a(this.a, null);
      return;
      this.a.b(2131434455);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtr
 * JD-Core Version:    0.7.0.1
 */