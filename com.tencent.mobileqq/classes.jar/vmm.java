import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class vmm
  implements View.OnClickListener
{
  public vmm(QCircleContentOperationView paramQCircleContentOperationView, QQCircleFeedBase.StImageBusiData paramStImageBusiData) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = new QQCircleFeedBase.StSimulateData();
    ((QQCircleFeedBase.StSimulateData)localObject1).material_id.set(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StImageBusiData.simulate_date.material_id.get());
    ((QQCircleFeedBase.StSimulateData)localObject1).simulate_name.set(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StImageBusiData.simulate_date.simulate_name.get());
    ((QQCircleFeedBase.StSimulateData)localObject1).simulate_schema.set(brdx.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StImageBusiData.simulate_date.material_id.get(), ""));
    Object localObject2 = new QCirclePolymerizationBean();
    ((QCirclePolymerizationBean)localObject2).setSimulateData((QQCircleFeedBase.StSimulateData)localObject1);
    ((QCirclePolymerizationBean)localObject2).setPolymerizationType(20);
    ((QCirclePolymerizationBean)localObject2).setExt1From(2);
    uyx.a(paramView.getContext(), (QCirclePolymerizationBean)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.a();
    if (QCircleContentOperationView.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView)) {}
    for (localObject1 = "1";; localObject1 = "2")
    {
      vtr.a(83, 2, (ExtraTypeInfo)localObject2, new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ext1", (String)localObject1) })), QCircleContentOperationView.g(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */