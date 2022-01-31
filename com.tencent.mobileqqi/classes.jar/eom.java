import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;

public class eom
  implements View.OnClickListener
{
  public eom(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    this.a.a(null);
    if (UpgradeController.a().a() == 4)
    {
      UpgradeController.a().a(BannerManager.a(this.a));
      return;
    }
    UpgradeDetailActivity.a(BannerManager.a(this.a), UpgradeController.a().a(), true, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eom
 * JD-Core Version:    0.7.0.1
 */