import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;

public class cjt
  implements View.OnClickListener
{
  public cjt(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (UpgradeController.a().a() == 4)
    {
      UpgradeController.a().a(BannerManager.a(this.a));
      return;
    }
    UpgradeDetailActivity.a(BannerManager.a(this.a), UpgradeController.a().a(), true, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjt
 * JD-Core Version:    0.7.0.1
 */