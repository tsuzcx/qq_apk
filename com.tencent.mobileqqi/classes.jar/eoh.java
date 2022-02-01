import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class eoh
  implements View.OnClickListener
{
  public eoh(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (BannerManager.a(this.a) != null)
    {
      BannerManager.a(this.a).b();
      if (BannerManager.a(this.a) != null) {
        ReportController.b(BannerManager.a(this.a).b, "CliOper", "", "", "0X80040AA", "0X80040AA", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eoh
 * JD-Core Version:    0.7.0.1
 */