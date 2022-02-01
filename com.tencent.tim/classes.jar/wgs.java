import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wgs
  implements View.OnClickListener
{
  public wgs(VisitorsActivity.d paramd) {}
  
  public void onClick(View paramView)
  {
    this.c.a.aB(paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgs
 * JD-Core Version:    0.7.0.1
 */