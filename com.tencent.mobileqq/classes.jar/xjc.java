import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.statistics.ReportController;

public class xjc
  implements View.OnClickListener
{
  public xjc(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a(this.a).app.getPreferences();
    UpgradeController.a().a();
    if (UpgradeController.a().a() == 4)
    {
      UpgradeController.a().a(BannerManager.a(this.a));
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      return;
      UpgradeDetailActivity.a(BannerManager.a(this.a), UpgradeController.a().a(), true, true, true);
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjc
 * JD-Core Version:    0.7.0.1
 */