import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaie
  implements View.OnClickListener
{
  aaie(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    aahb.a(this.this$0).app.getPreferences();
    aqap.a().b();
    if (aqap.a().getDownloadState() == 4)
    {
      aqap.a().ft(aahb.a(this.this$0));
      anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, aqao.BH(), aqap.BJ(), aqap.BI(), "1");
    }
    for (;;)
    {
      this.this$0.d(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UpgradeDetailActivity.a(aahb.a(this.this$0), aqap.a().b(), true, true, true);
      anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, aqao.BH(), aqap.BJ(), aqap.BI(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaie
 * JD-Core Version:    0.7.0.1
 */