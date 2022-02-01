import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class rhe
  implements View.OnClickListener
{
  rhe(rgy paramrgy) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if ((this.a.a != null) && (this.a.a.asi == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 4);
    }
    ras.so("0X80076C6");
    ras.sp("0X80075DA");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhe
 * JD-Core Version:    0.7.0.1
 */