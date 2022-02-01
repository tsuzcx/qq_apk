import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class vkj
  implements View.OnClickListener
{
  public vkj(QCircleContentOperationView paramQCircleContentOperationView, QQCircleFeedBase.StVideoBusiData paramStVideoBusiData) {}
  
  public void onClick(View paramView)
  {
    Object localObject = bgng.a(QQStoryContext.a(), paramView.getContext(), this.jdField_a_of_type_QqcircleQQCircleFeedBase$StVideoBusiData.simulate_date.simulate_schema.get());
    if (localObject != null) {
      ((bgmp)localObject).a();
    }
    ReportExtraTypeInfo localReportExtraTypeInfo = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a();
    if (QCircleContentOperationView.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView)) {}
    for (localObject = "1";; localObject = "2")
    {
      vrg.a(83, 2, localReportExtraTypeInfo, new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("ext1", (String)localObject) })), QCircleContentOperationView.h(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkj
 * JD-Core Version:    0.7.0.1
 */