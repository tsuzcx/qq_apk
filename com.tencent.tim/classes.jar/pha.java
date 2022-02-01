import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pha
  implements View.OnClickListener
{
  public pha(QCircleRecommendWidget.b paramb) {}
  
  public void onClick(View paramView)
  {
    QCircleRecommendWidget.b.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pha
 * JD-Core Version:    0.7.0.1
 */