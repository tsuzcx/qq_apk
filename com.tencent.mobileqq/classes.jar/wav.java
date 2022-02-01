import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;

public class wav
  implements View.OnClickListener
{
  public wav(QCircleLightInteractPushWidget paramQCircleLightInteractPushWidget, FeedCloudMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
    localQCircleInitBean.setFromReportBean(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.a().clone().setElementIdStr("portrait"));
    uyx.b(paramView.getContext(), localQCircleInitBean);
    if (paramView == QCircleLightInteractPushWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget)) {
      vtn.a(87, 2, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.a, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.d());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vtn.a(87, 3, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.a, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wav
 * JD-Core Version:    0.7.0.1
 */