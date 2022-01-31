import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class uau
  implements tqy
{
  public uau(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext() == null) {
      QLog.e("QCircleFeedCommentWidge", 1, "onSticky mContext is null");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (paramInt != tqz.c) {
          break;
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.content.get()));
      return;
    } while (paramInt != tqz.e);
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131698367);
      bdcd.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690648, 2131690626, new uav(this, paramInt), new uaw(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uau
 * JD-Core Version:    0.7.0.1
 */