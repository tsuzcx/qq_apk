import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;

public class vxl
  implements View.OnClickListener
{
  public vxl(QCircleLightInteractPushWidget paramQCircleLightInteractPushWidget, FeedCloudMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    uxo.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.a().clone().setElementIdStr("portrait"));
    if (paramView == QCircleLightInteractPushWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget)) {
      vrc.a(87, 2, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.a, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.d());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vrc.a(87, 3, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.a, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLightInteractPushWidget.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */