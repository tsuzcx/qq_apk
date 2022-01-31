import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.statistics.ReportController;

public class xol
  implements View.OnClickListener
{
  public xol(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (UpgradeController.a().a() == 4) {
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "0");
    }
    for (;;)
    {
      this.a.a(10, 0);
      this.a.a(-1, null);
      return;
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xol
 * JD-Core Version:    0.7.0.1
 */