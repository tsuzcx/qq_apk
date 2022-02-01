import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class vpe
  implements View.OnClickListener
{
  vpe(vpd paramvpd, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.i("QCircleSystemMessagePresenter", 1, "clickSystemMessage messageId" + this.jdField_a_of_type_Vpd.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feedId.get());
    if ((this.jdField_a_of_type_Vpd.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData != null) && (this.jdField_a_of_type_Vpd.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.busiInfo.get() != null))
    {
      String str = uyw.a(this.jdField_a_of_type_Vpd.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.busiInfo.get(), "noticeFeedJumpUrl");
      QLog.i("QCircleSystemMessagePresenter", 1, "clickSystemMessage get jumpUrl" + str);
      if (!TextUtils.isEmpty(str)) {
        uyx.a(this.jdField_a_of_type_AndroidContentContext, str);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpe
 * JD-Core Version:    0.7.0.1
 */