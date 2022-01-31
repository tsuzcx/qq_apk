import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class xjm
  implements View.OnClickListener
{
  public xjm(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    this.a.a(18, 0);
    this.a.a(-1, null);
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "QQWIFI", "clk_buleClose", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjm
 * JD-Core Version:    0.7.0.1
 */