import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaif
  implements View.OnClickListener
{
  aaif(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if (aqap.a().getDownloadState() == 4) {
      anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, aqao.BH(), aqap.BJ(), aqap.BI(), "0");
    }
    for (;;)
    {
      this.this$0.gm(14, 0);
      this.this$0.d(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, aqao.BH(), aqap.BJ(), aqap.BI(), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaif
 * JD-Core Version:    0.7.0.1
 */