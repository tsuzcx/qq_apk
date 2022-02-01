import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StTagInfo;

class vyx
  implements View.OnClickListener
{
  vyx(vyw paramvyw) {}
  
  public void onClick(View paramView)
  {
    if (QzoneConfig.getQQCircleTagToLayer())
    {
      Object localObject = new uxk();
      ((uxk)localObject).a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
      localObject = ((uxk)localObject).a();
      if (localObject != null)
      {
        Intent localIntent = new Intent();
        ((QCircleInitBean)localObject).mFromReportBean = this.a.jdField_a_of_type_Vyv.a.a().clone().setElementIdStr("portraitlist");
        uxo.a(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), (QCircleInitBean)localObject, localIntent);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      uxo.a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get(), this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get(), this.a.jdField_a_of_type_Vyv.a.a().clone().setElementIdStr("portraitlist"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyx
 * JD-Core Version:    0.7.0.1
 */