import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.fragments.main.QCircleAggregationFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vob
  implements View.OnClickListener
{
  public vob(QCircleAggregationFragment paramQCircleAggregationFragment) {}
  
  public void onClick(View paramView)
  {
    vtq.a("", 22, 13);
    aaak.a().a(new QCircleSelectTabEvent(6));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vob
 * JD-Core Version:    0.7.0.1
 */