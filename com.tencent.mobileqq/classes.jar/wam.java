import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleFuelRankItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StRankingItem;

public class wam
  implements View.OnClickListener
{
  public wam(QCircleFuelRankItemView paramQCircleFuelRankItemView, FeedCloudMeta.StRankingItem paramStRankingItem) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFuelRankItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView) != null) {
      vtr.a(89, 1, ((vfu)QCircleFuelRankItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView)).a(), this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.e());
    }
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StRankingItem.user);
    localQCircleInitBean.setFromReportBean(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.a().clone().setElementIdStr("portrait"));
    uyx.b(paramView.getContext(), localQCircleInitBean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wam
 * JD-Core Version:    0.7.0.1
 */