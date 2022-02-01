import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;

public class avqd
  implements View.OnClickListener
{
  public avqd(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.mInstalling)
    {
      if (1 == this.a.mMode) {
        LpReportInfo_dc00321.report(8, 129, 0, false, false, null);
      }
      this.a.updateTextProgress(false, false);
      this.a.installPlugin();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqd
 * JD-Core Version:    0.7.0.1
 */