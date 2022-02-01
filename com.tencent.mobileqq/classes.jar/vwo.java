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

public class vwo
  implements uxv
{
  public vwo(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
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
        if (paramInt == uxw.a)
        {
          if (QCircleFeedCommentWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
          {
            localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697249);
            bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vwp(this), new vwq(this)).show();
            return;
          }
          QCircleFeedCommentWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().hashCode(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
          return;
        }
        if (paramInt == uxw.b)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697123);
          bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vwr(this), new vws(this)).show();
          return;
        }
        if (paramInt != uxw.c) {
          break;
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
      if (paramInt == uxw.e)
      {
        if (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131697128);
          bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vwt(this, paramInt), new vwu(this)).show();
          return;
        }
      }
    } while (paramInt != uxw.d);
    Object localObject = new uzh().e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.get())).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()).b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()).a();
    vtl.a(new uzg().a("wezone_comment").b("25041").c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get()).d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwo
 * JD-Core Version:    0.7.0.1
 */