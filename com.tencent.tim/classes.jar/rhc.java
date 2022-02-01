import android.support.annotation.NonNull;
import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.a;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class rhc
  implements HorizontalSelectColorLayout.a
{
  rhc(rgy paramrgy) {}
  
  public void a(@NonNull rni paramrni)
  {
    switch (paramrni.type)
    {
    }
    do
    {
      return;
      int i = paramrni.subType;
      this.a.b.color = i;
      this.a.ag.setTextColor(i);
      ras.sp("0X80075D8");
    } while ((this.a.a == null) || (this.a.a.asi != 3));
    LpReportInfo_pf00064.allReport(615, 3, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhc
 * JD-Core Version:    0.7.0.1
 */