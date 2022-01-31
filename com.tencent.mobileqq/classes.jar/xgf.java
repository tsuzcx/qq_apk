import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

public class xgf
  implements View.OnClickListener
{
  public xgf(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(BannerManager.a(this.a), GuideBindPhoneActivity.class);
    BannerManager.a(this.a).startActivity(paramView);
    BannerManager.a(this.a).getSharedPreferences("contact_bind_info" + BannerManager.a(this.a).app.getAccount(), 0).edit().putBoolean("key_show_contact_banner", false).commit();
    this.a.a(13, 0);
    BannerManager.a(this.a).removeMessages(11);
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X80053D9", "0X80053D9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgf
 * JD-Core Version:    0.7.0.1
 */