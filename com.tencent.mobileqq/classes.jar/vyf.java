import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto.StItemContainer;

public class vyf
  implements View.OnClickListener
{
  public vyf(QCircleRecommendWidget paramQCircleRecommendWidget) {}
  
  public void onClick(View paramView)
  {
    if (QCircleRecommendWidget.a(this.a) != null)
    {
      uxo.a(this.a.getContext(), uxn.a(QCircleRecommendWidget.a(this.a).urlInfo.get(), "personRecomListUrl"));
      vrc.a(29, 2, QCircleRecommendWidget.a(this.a), this.a.d());
      vrr.a().a(new vrt().a("more").b("click").a(this.a.a()).a(QCircleRecommendWidget.a(this.a).mDataPosition));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyf
 * JD-Core Version:    0.7.0.1
 */