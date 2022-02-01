import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class vzr
  implements uze
{
  public vzr(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
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
        if (paramInt == uzf.a)
        {
          if (QCircleFeedCommentWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
          {
            localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697326);
            bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vzs(this), new vzt(this)).show();
            return;
          }
          QCircleFeedCommentWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().hashCode(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
          return;
        }
        if (paramInt == uzf.b)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697184);
          bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vzu(this), new vzv(this)).show();
          return;
        }
        if (paramInt != uzf.c) {
          break;
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
      if (paramInt == uzf.e)
      {
        if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697189);
          bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vzw(this, paramInt), new vzx(this)).show();
          return;
        }
      }
    } while (paramInt != uzf.d);
    Object localObject = new vax().e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.get())).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()).b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()).a();
    vwj.a(new vaw().a("wezone_comment").b("25041").c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get()).d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzr
 * JD-Core Version:    0.7.0.1
 */