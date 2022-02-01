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

public class pfl
  implements ouy.a
{
  public pfl(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void onClick(int paramInt)
  {
    if (this.a.getContext() == null) {
      QLog.e("QCircleFeedCommentWidge", 1, "onSticky mContext is null");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (paramInt != ouy.b.bgr) {
          break;
        }
        localObject = (ClipboardManager)this.a.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ClipData localClipData = ClipData.newPlainText("", this.jdField_f_of_type_FeedcloudFeedCloudMeta$StReply.content.get());
      alkw.a((ClipboardManager)localObject, localClipData);
      ((ClipboardManager)localObject).setPrimaryClip(localClipData);
      return;
    } while (paramInt != ouy.b.bgt);
    if (ovd.a((FeedCloudMeta.StUser)this.jdField_f_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = this.a.getContext().getString(2131700170);
      aqha.a(this.a.getContext(), 230, (String)localObject, null, 2131721058, 2131691042, new pfm(this, paramInt), new pfn(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfl
 * JD-Core Version:    0.7.0.1
 */