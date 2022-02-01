import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

class wdy
  implements View.OnClickListener
{
  wdy(wdx paramwdx) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(vtt.a("ext1", this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get()));
    vtn.a(16, 2, this.a.jdField_a_of_type_Wdw.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, (List)localObject, this.a.jdField_a_of_type_Wdw.a.b());
    localObject = new QCirclePolymerizationBean();
    ((QCirclePolymerizationBean)localObject).setTagInfo(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
    ((QCirclePolymerizationBean)localObject).setSourceType(this.a.jdField_a_of_type_Wdw.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
    ((QCirclePolymerizationBean)localObject).setFromReportBean(this.a.jdField_a_of_type_Wdw.a.a().clone().setElementIdStr("portraitlist"));
    ((QCirclePolymerizationBean)localObject).setPolymerizationType(7);
    ((QCirclePolymerizationBean)localObject).setExt1From(1);
    uyx.a(paramView.getContext(), (QCirclePolymerizationBean)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdy
 * JD-Core Version:    0.7.0.1
 */