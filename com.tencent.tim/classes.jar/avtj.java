import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.PlusMenuContainer;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class avtj
  implements View.OnClickListener
{
  public avtj(PlusMenuContainer paramPlusMenuContainer) {}
  
  public void onClick(View paramView)
  {
    String str;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      str = (String)paramView.getTag();
      Intent localIntent = new Intent();
      localIntent.putExtra("cmd", "Schema");
      localIntent.putExtra("schema", str);
      avpw.a((Activity)this.a.context, avpw.d.a(), localIntent);
      if (!str.equals(PlusMenuContainer.W[0])) {
        break label101;
      }
      LpReportInfo_pf00064.report(133, 2);
    }
    for (;;)
    {
      this.a.hide();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      if (str.equals(PlusMenuContainer.W[1])) {
        LpReportInfo_pf00064.report(133, 3);
      } else if (str.equals(PlusMenuContainer.W[2])) {
        LpReportInfo_pf00064.report(133, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtj
 * JD-Core Version:    0.7.0.1
 */