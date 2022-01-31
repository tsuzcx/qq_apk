import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class cki
  implements View.OnClickListener
{
  public cki(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(BannerManager.a(this.a), TroopAssisSettingActivity.class);
    BannerManager.a(this.a).startActivityForResult(paramView, 9001);
    BannerManager.a(this.a).sendEmptyMessageDelayed(1, 1000L);
    ReportController.b(BannerManager.a(this.a).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cki
 * JD-Core Version:    0.7.0.1
 */