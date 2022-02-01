import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class ysu
  implements View.OnClickListener
{
  ysu(yso paramyso) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if ((this.a.a != null) && (this.a.a.mBusinessId == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 4);
    }
    ykw.a("0X80076C6");
    ykw.b("0X80075DA");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysu
 * JD-Core Version:    0.7.0.1
 */