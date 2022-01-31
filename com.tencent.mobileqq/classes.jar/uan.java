import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class uan
  implements tqy
{
  public uan(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
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
        if (paramInt == tqz.a)
        {
          if (QCircleFeedCommentWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
          {
            localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131698365);
            bdcd.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690648, 2131690626, new uao(this), new uap(this)).show();
            return;
          }
          QCircleFeedCommentWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget).b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
          return;
        }
        if (paramInt == tqz.b)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131698278);
          bdcd.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690648, 2131690626, new uaq(this), new uar(this)).show();
          return;
        }
        if (paramInt != tqz.c) {
          break;
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
    } while (paramInt != tqz.e);
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext().getString(2131698282);
      bdcd.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedCommentWidget.getContext(), 230, (String)localObject, null, 2131690648, 2131690626, new uas(this, paramInt), new uat(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uan
 * JD-Core Version:    0.7.0.1
 */