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

public class vyl
  implements uze
{
  public vyl(QCircleCommentListView paramQCircleCommentListView, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == uzf.a)
    {
      QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 48);
      if (QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697326);
        bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vym(this), new vyn(this)).show();
      }
    }
    do
    {
      do
      {
        return;
        QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().hashCode(), QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        return;
        if (paramInt == uzf.b)
        {
          QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 49);
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697184);
          bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vyo(this), new vyp(this)).show();
          return;
        }
        if (paramInt != uzf.c) {
          break;
        }
        QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 46);
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
      if (paramInt == uzf.e)
      {
        QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView, 47);
        if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext().getResources().getString(2131697189);
          bhlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.getContext(), 230, (String)localObject, null, 2131690580, 2131690562, new vyq(this, paramInt), new vyr(this)).show();
          return;
        }
      }
    } while (paramInt != uzf.d);
    Object localObject = new vax().b(QCircleCommentListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView).id.get()).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.get())).a();
    vwj.a(new vaw().c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get()).b("25014").a("wezone_comment").d((String)localObject).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyl
 * JD-Core Version:    0.7.0.1
 */