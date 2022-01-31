import android.content.Intent;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class wzg
  extends ContactBindObserver
{
  public wzg(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    this.a.b();
    if (!paramBoolean)
    {
      this.a.b(2131434471);
      return;
    }
    if ((paramInt == 0) || (paramInt == 106))
    {
      if (1 == this.a.a) {
        MyBusinessActivity.a(true);
      }
      if (this.a.getIntent().getBooleanExtra("k_is_block", false)) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
      }
      if (this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("bind_mobile", BindVerifyActivity.a(this.a).getText().toString().trim());
        this.a.setResult(-1, (Intent)localObject);
        this.a.finish();
        return;
      }
      if (this.a.b == 10)
      {
        localObject = new Intent(this.a, SplashActivity.class);
        ((Intent)localObject).putExtra("main_tab_id", 1);
        ((Intent)localObject).setFlags(603979776);
        this.a.startActivity((Intent)localObject);
        this.a.setResult(-1, null);
        this.a.finish();
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("bind_mobile", BindVerifyActivity.a(this.a).getText().toString().trim());
      this.a.app.a(new wzh(this));
      if ((this.a.b == 15) || (this.a.b == 17) || (this.a.b == 0) || (this.a.b == 1) || (this.a.b == 6) || (this.a.b == 14) || (this.a.b == 9) || (this.a.b == 12))
      {
        QQToast.a(BaseApplicationImpl.sApplication, "寻找通讯录联系人中。", 0).a();
        if (this.a.b == 15) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X80077C7", "0X80077C7", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        this.a.setResult(-1, (Intent)localObject);
        this.a.finish();
        return;
        if (this.a.b == 17)
        {
          ReportController.b(this.a.app, "dc00898", "", "", "0X80077CB", "0X80077CB", 0, 0, "", "", "", "");
          continue;
          QQToast.a(BaseApplicationImpl.sApplication, "特征码匹配中。", 0).a();
        }
      }
    }
    if (paramInt == 213)
    {
      this.a.b("验证码错误，请重新输入。");
      return;
    }
    Object localObject = "请稍后重试。";
    if (paramInt == 107) {
      localObject = "此手机号已与其他帐号绑定，请返回重试。";
    }
    this.a.a("请求失败", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzg
 * JD-Core Version:    0.7.0.1
 */