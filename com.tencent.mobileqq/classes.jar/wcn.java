import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wcn
  implements View.OnClickListener
{
  wcn(wcm paramwcm) {}
  
  public void onClick(View paramView)
  {
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    localQCirclePolymerizationBean.setTagInfo(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
    localQCirclePolymerizationBean.setFromReportBean(this.a.jdField_a_of_type_Wcl.a.a().clone().setElementIdStr("portraitlist"));
    localQCirclePolymerizationBean.setPolymerizationType(7);
    localQCirclePolymerizationBean.setExt1From(3);
    uyx.a(paramView.getContext(), localQCirclePolymerizationBean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcn
 * JD-Core Version:    0.7.0.1
 */