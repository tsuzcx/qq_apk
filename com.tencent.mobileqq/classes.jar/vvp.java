import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class vvp
  implements uxv
{
  public vvp(QCircleCommentListView paramQCircleCommentListView, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == uxw.c)
    {
      localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getSystemService("clipboard");
      if (localObject != null) {
        ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.content.get()));
      }
    }
    do
    {
      return;
      if (paramInt == uxw.e)
      {
        if (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697251);
          bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vvq(this, paramInt), new vvr(this)).show();
          return;
        }
      }
    } while (paramInt != uxw.d);
    Object localObject = new uzh().b(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).id.get()).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).d(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get()).e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.createTime.get())).a();
    vtl.a(new uzg().c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()).b("25014").a("wezone_reply").d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvp
 * JD-Core Version:    0.7.0.1
 */