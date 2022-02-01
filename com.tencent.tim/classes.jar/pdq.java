import android.app.Activity;
import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import mqq.util.WeakReference;

class pdq
  implements peo.a
{
  pdq(pdp parampdp, Activity paramActivity, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, ovx paramovx) {}
  
  public void biG()
  {
    QLog.d("QCircleCommentHelper", 1, "onClickSend()");
    if ((this.val$activity.isFinishing()) || (pdp.a(this.b) == null)) {
      QLog.d("QCircleCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
    }
    String str;
    do
    {
      return;
      str = pdp.a(this.b).getText();
    } while (TextUtils.isEmpty(str.trim()));
    if (!NetworkUtils.isNetworkAvailable(this.val$activity))
    {
      QQToast.a(this.val$activity, 1, this.val$activity.getString(2131696284), 0).show();
      return;
    }
    if (this.i == null)
    {
      QLog.e("QCircleCommentHelper", 1, "feed is null");
      return;
    }
    if (pdp.a(this.b) != null) {}
    for (pdp.a locala = (pdp.a)pdp.a(this.b).get();; locala = null)
    {
      Object localObject;
      if (this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment != null)
      {
        localObject = new FeedCloudMeta.StReply();
        ((FeedCloudMeta.StReply)localObject).id.set("fakeId_" + System.currentTimeMillis());
        ((FeedCloudMeta.StReply)localObject).content.set(str);
        ((FeedCloudMeta.StReply)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
        ((FeedCloudMeta.StReply)localObject).postUser.set(oum.a());
        if ((this.jdField_e_of_type_FeedcloudFeedCloudMeta$StReply != null) && (!TextUtils.isEmpty(this.jdField_e_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()))) {
          ((FeedCloudMeta.StReply)localObject).targetUser.set(this.jdField_e_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get());
        }
        if (locala != null)
        {
          QLog.d("QCircleCommentHelper", 1, "addMessageFakeReply commentInputListener callback success");
          locala.a((FeedCloudMeta.StReply)localObject);
          pdp.a(this.b, this.val$activity).a(this.i, this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment, (FeedCloudMeta.StReply)localObject);
        }
      }
      for (;;)
      {
        pdp.a(this.b).setText("");
        pdp.a(this.b).qG(null);
        pdp.a(this.b).dismiss();
        return;
        QLog.e("QCircleCommentHelper", 1, "addMessageFakeReply commentInputListener null");
        break;
        localObject = new FeedCloudMeta.StComment();
        ((FeedCloudMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
        ((FeedCloudMeta.StComment)localObject).content.set(str);
        ((FeedCloudMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
        ((FeedCloudMeta.StComment)localObject).postUser.set(oum.a());
        if (locala != null) {
          locala.a((FeedCloudMeta.StComment)localObject);
        }
        pdp.a(this.b, this.val$activity).a(this.a.mFeed, (FeedCloudMeta.StComment)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdq
 * JD-Core Version:    0.7.0.1
 */