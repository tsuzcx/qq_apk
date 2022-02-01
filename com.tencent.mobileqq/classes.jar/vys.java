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

public class vys
  implements uze
{
  public vys(QCircleCommentListView paramQCircleCommentListView, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == uzf.c)
    {
      localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getSystemService("clipboard");
      if (localObject != null) {
        ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.content.get()));
      }
    }
    do
    {
      return;
      if (paramInt == uzf.e)
      {
        if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697328);
          bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vyt(this, paramInt), new vyu(this)).show();
          return;
        }
      }
    } while (paramInt != uzf.d);
    Object localObject = new vax().b(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).id.get()).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).d(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get()).e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.createTime.get())).a();
    vwj.a(new vaw().c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()).b("25014").a("wezone_reply").d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vys
 * JD-Core Version:    0.7.0.1
 */