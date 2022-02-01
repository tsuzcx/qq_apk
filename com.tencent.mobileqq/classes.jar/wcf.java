import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto.StItemContainer;

public class wcf
  implements View.OnClickListener
{
  public wcf(QCircleTagRecommendWidget paramQCircleTagRecommendWidget) {}
  
  public void onClick(View paramView)
  {
    if (QCircleTagRecommendWidget.a(this.a) != null)
    {
      uyx.a(this.a.getContext(), uyw.a(QCircleTagRecommendWidget.a(this.a).urlInfo.get(), "smallWordRecomListUrl"), null, -1);
      vud.a().a(new vuf().a("more").b("click").a(this.a.a()).a(QCircleTagRecommendWidget.a(this.a).mDataPosition));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcf
 * JD-Core Version:    0.7.0.1
 */