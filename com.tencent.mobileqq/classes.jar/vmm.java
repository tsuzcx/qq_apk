import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class vmm
  implements View.OnClickListener
{
  vmm(vmg paramvmg) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if ((this.a.a != null) && (this.a.a.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 4);
    }
    vej.a("0X80076C6");
    vej.b("0X80075DA");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */