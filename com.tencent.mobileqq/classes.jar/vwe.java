import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class vwe
  implements uxv
{
  public vwe(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext() == null) {
      QLog.e("QCircleFeedCommentWidget", 1, "onSticky mContext is null");
    }
    do
    {
      do
      {
        return;
        if (paramInt != uxw.c) {
          break;
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.content.get()));
      return;
      if (paramInt == uxw.e)
      {
        if (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697251);
          bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vwf(this, paramInt), new vwg(this)).show();
          return;
        }
      }
    } while (paramInt != uxw.d);
    Object localObject = new uzh().e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.createTime.get())).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).d(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get()).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()).b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()).a();
    vtl.a(new uzg().a("wezone_reply").b("25042").c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()).d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwe
 * JD-Core Version:    0.7.0.1
 */