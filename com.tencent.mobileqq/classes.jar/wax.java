import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCirclePYMKRecommendWidget;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto.StItemContainer;

public class wax
  implements View.OnClickListener
{
  public wax(QCirclePYMKRecommendWidget paramQCirclePYMKRecommendWidget) {}
  
  public void onClick(View paramView)
  {
    if (QCirclePYMKRecommendWidget.a(this.a) != null)
    {
      uyx.a(this.a.getContext(), uyw.a(QCirclePYMKRecommendWidget.a(this.a).urlInfo.get(), "personRecomListUrl"), null, -1);
      vtn.a(29, 2, QCirclePYMKRecommendWidget.a(this.a), this.a.d());
      vud.a().a(new vuf().a("more").b("click").a(this.a.a()).a(QCirclePYMKRecommendWidget.a(this.a).mDataPosition));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wax
 * JD-Core Version:    0.7.0.1
 */