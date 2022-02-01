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

public class vzh
  implements uze
{
  public vzh(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
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
        if (paramInt != uzf.c) {
          break;
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.content.get()));
      return;
      if (paramInt == uzf.e)
      {
        if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697328);
          bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vzi(this, paramInt), new vzj(this)).show();
          return;
        }
      }
    } while (paramInt != uzf.d);
    Object localObject = new vax().e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.createTime.get())).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).d(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get()).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()).b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()).a();
    vwj.a(new vaw().a("wezone_reply").b("25042").c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()).d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzh
 * JD-Core Version:    0.7.0.1
 */