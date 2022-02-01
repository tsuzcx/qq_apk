import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ogi
  implements View.OnClickListener
{
  ogi(ogd paramogd, String paramString) {}
  
  public void onClick(View paramView)
  {
    ooz.i("WSUserAuthDialog", "dialog click ok");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.apZ, "authorized_window", 1000001);
    ogd.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogi
 * JD-Core Version:    0.7.0.1
 */