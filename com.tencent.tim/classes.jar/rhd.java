import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class rhd
  implements View.OnClickListener
{
  rhd(rgy paramrgy) {}
  
  public void onClick(View paramView)
  {
    this.a.ag.setText(this.a.aAz);
    this.a.ag.setTextColor(this.a.brj);
    this.a.b.color = this.a.brj;
    this.a.b.brg = this.a.brk;
    this.a.dismiss();
    if ((this.a.a != null) && (this.a.a.asi == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 3);
    }
    ras.so("0X80076C5");
    ras.sp("0X80075D9");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhd
 * JD-Core Version:    0.7.0.1
 */