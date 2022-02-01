import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaho
  implements View.OnClickListener
{
  aaho(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    this.this$0.d(-1, null);
    if (aqap.a().getDownloadState() == 4)
    {
      anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, aqao.BH(), aqap.BJ(), aqap.BI(), "1");
      aqap.a().ft(aahb.a(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, aqao.BH(), aqap.BJ(), aqap.BI(), "1");
      UpgradeDetailActivity.a(aahb.a(this.this$0), aqap.a().b(), true, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaho
 * JD-Core Version:    0.7.0.1
 */