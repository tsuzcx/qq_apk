import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleFuelRankItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StRankingItem;

public class vxf
  implements View.OnClickListener
{
  public vxf(QCircleFuelRankItemView paramQCircleFuelRankItemView, FeedCloudMeta.StRankingItem paramStRankingItem) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFuelRankItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView) != null) {
      vrg.a(89, 1, ((vdq)QCircleFuelRankItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView)).a(), this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.e());
    }
    uxo.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StRankingItem.user, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.a().clone().setElementIdStr("portrait"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */