import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto.StItemContainer;

public class pgw
  implements View.OnClickListener
{
  public pgw(QCircleRecommendWidget paramQCircleRecommendWidget) {}
  
  public void onClick(View paramView)
  {
    if (QCircleRecommendWidget.a(this.a) != null)
    {
      oux.aX(this.a.getContext(), ouw.c(QCircleRecommendWidget.a(this.a).urlInfo.get(), "personRecomListUrl"));
      pcl.a(29, 2, QCircleRecommendWidget.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgw
 * JD-Core Version:    0.7.0.1
 */