import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;

public class wat
  implements View.OnClickListener
{
  public wat(QCircleLightInteractPolyLikeWidget paramQCircleLightInteractPolyLikeWidget, FeedCloudMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
    localQCircleInitBean.setFromReportBean(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPolyLikeWidget.a().clone().setElementIdStr("portrait"));
    uyx.b(paramView.getContext(), localQCircleInitBean);
    if (paramView == QCircleLightInteractPolyLikeWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPolyLikeWidget)) {
      vtn.a(71, 2, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPolyLikeWidget.a, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPolyLikeWidget.d());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vtn.a(72, 2, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPolyLikeWidget.a, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPolyLikeWidget.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wat
 * JD-Core Version:    0.7.0.1
 */