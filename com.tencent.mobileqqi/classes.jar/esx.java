import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class esx
  implements View.OnClickListener
{
  public esx(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (BannerManager.a(this.a) != null)
    {
      paramView = BannerManager.a(this.a).b;
      if (paramView == null) {
        break label314;
      }
      i = paramView.a().a();
      if ((i != 1) && (i != 2)) {
        break label159;
      }
      localIntent = new Intent(BannerManager.a(this.a).getApplicationContext(), AVActivity.class);
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("sessionType", i);
      localIntent.putExtra("uin", paramView.a().a());
      BannerManager.a(this.a).startActivity(localIntent);
      BannerManager.a(this.a).overridePendingTransition(2130968633, 0);
      ReportController.b(paramView, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
    }
    label159:
    label314:
    while (!QLog.isColorLevel())
    {
      do
      {
        int i;
        Intent localIntent;
        return;
        paramView = null;
        break;
        long l = BannerManager.a(this.a).b.a().a();
        if (l != 0L)
        {
          localIntent = new Intent(BannerManager.a(this.a).getApplicationContext(), AVActivity.class);
          localIntent.addFlags(262144);
          localIntent.addFlags(268435456);
          localIntent.putExtra("GroupId", String.valueOf(l));
          localIntent.putExtra("Type", 1);
          localIntent.putExtra("sessionType", i);
          BannerManager.a(this.a).startActivity(localIntent);
          BannerManager.a(this.a).overridePendingTransition(2130968633, 0);
          ReportController.b(paramView, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoBar", 2, "status error");
      return;
    }
    QLog.e("MultiVideoBar", 2, "app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     esx
 * JD-Core Version:    0.7.0.1
 */