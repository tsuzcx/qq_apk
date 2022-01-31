import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StNotice;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class uhl
  implements View.OnClickListener
{
  uhl(uhk paramuhk, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.i("QCircleSystemMessagePresenter", 1, "clickSystemMessage messageId" + this.jdField_a_of_type_Uhk.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feedId.get());
    if ((this.jdField_a_of_type_Uhk.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData != null) && (this.jdField_a_of_type_Uhk.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.busiInfo.get() != null))
    {
      paramView = tqr.a(this.jdField_a_of_type_Uhk.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.busiInfo.get(), "noticeFeedJumpUrl");
      QLog.i("QCircleSystemMessagePresenter", 1, "clickSystemMessage get jumpUrl" + paramView);
      if (!TextUtils.isEmpty(paramView)) {
        tqs.b(this.jdField_a_of_type_AndroidContentContext, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhl
 * JD-Core Version:    0.7.0.1
 */