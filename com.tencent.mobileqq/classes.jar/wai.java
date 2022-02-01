import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

class wai
  implements View.OnClickListener
{
  wai(wah paramwah) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(vri.a("ext1", this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get()));
    vrc.a(16, 2, this.a.jdField_a_of_type_Wag.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, (List)localObject, this.a.jdField_a_of_type_Wag.a.b());
    if (QzoneConfig.getQQCircleTagToLayer())
    {
      localObject = new uxk();
      ((uxk)localObject).a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
      ((uxk)localObject).a(this.a.jdField_a_of_type_Wag.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
      localObject = ((uxk)localObject).a();
      if (localObject != null)
      {
        Intent localIntent = new Intent();
        vrf.a("", 17, 3);
        ((QCircleInitBean)localObject).mFromReportBean = this.a.jdField_a_of_type_Wag.a.a().clone().setElementIdStr("portraitlist");
        uxo.a(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), (QCircleInitBean)localObject, localIntent);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vrf.a("", 17, 3);
      uxo.a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get(), this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get(), this.a.jdField_a_of_type_Wag.a.a().clone().setElementIdStr("portraitlist"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wai
 * JD-Core Version:    0.7.0.1
 */