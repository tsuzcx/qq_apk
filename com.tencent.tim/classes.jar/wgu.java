import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity.a;
import com.tencent.mobileqq.activity.VisitorsActivity.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wgu
  implements View.OnClickListener
{
  public wgu(VisitorsActivity.d paramd, VisitorsActivity.a parama) {}
  
  public void onClick(View paramView)
  {
    this.c.a.aA(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgu
 * JD-Core Version:    0.7.0.1
 */