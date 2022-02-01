import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class vvi
  implements uxv
{
  public vvi(QCircleCommentListView paramQCircleCommentListView, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == uxw.a)
    {
      QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 48);
      if (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697249);
        bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vvj(this), new vvk(this)).show();
      }
    }
    do
    {
      do
      {
        return;
        QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().hashCode(), QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        return;
        if (paramInt == uxw.b)
        {
          QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 49);
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697123);
          bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vvl(this), new vvm(this)).show();
          return;
        }
        if (paramInt != uxw.c) {
          break;
        }
        QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 46);
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
      if (paramInt == uxw.e)
      {
        QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 47);
        if (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697128);
          bglp.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690582, 2131690566, new vvn(this, paramInt), new vvo(this)).show();
          return;
        }
      }
    } while (paramInt != uxw.d);
    Object localObject = new uzh().b(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).id.get()).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.get())).a();
    vtl.a(new uzg().c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get()).b("25014").a("wezone_comment").d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvi
 * JD-Core Version:    0.7.0.1
 */