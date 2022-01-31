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

class uay
  implements ucm
{
  uay(uax paramuax, Activity paramActivity, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, trx paramtrx) {}
  
  public void a()
  {
    QLog.d("QCircleCommentHelper", 1, "onClickSend()");
    if ((this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (uax.a(this.jdField_a_of_type_Uax) == null))
    {
      QLog.d("QCircleCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = uax.a(this.jdField_a_of_type_Uax).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692457), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131694779), 0).a();
      return;
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)
    {
      QLog.e("QCircleCommentHelper", 1, "feed is null");
      return;
    }
    if (uax.a(this.jdField_a_of_type_Uax) != null) {}
    for (ubb localubb = (ubb)uax.a(this.jdField_a_of_type_Uax).get();; localubb = null)
    {
      Object localObject;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)
      {
        localObject = new FeedCloudMeta.StReply();
        ((FeedCloudMeta.StReply)localObject).id.set("fakeId_" + System.currentTimeMillis());
        ((FeedCloudMeta.StReply)localObject).content.set(str);
        ((FeedCloudMeta.StReply)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
        ((FeedCloudMeta.StReply)localObject).postUser.set(tqg.a());
        if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()))) {
          ((FeedCloudMeta.StReply)localObject).targetUser.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get());
        }
        if (localubb != null)
        {
          QLog.d("QCircleCommentHelper", 1, "addMessageFakeReply commentInputListener callback success");
          localubb.a((FeedCloudMeta.StReply)localObject);
          uax.a(this.jdField_a_of_type_Uax, this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, (FeedCloudMeta.StReply)localObject);
        }
      }
      for (;;)
      {
        uax.a(this.jdField_a_of_type_Uax).a("");
        uax.a(this.jdField_a_of_type_Uax).b(null);
        uax.a(this.jdField_a_of_type_Uax).dismiss();
        return;
        QLog.e("QCircleCommentHelper", 1, "addMessageFakeReply commentInputListener null");
        break;
        localObject = new FeedCloudMeta.StComment();
        ((FeedCloudMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
        ((FeedCloudMeta.StComment)localObject).content.set(str);
        ((FeedCloudMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
        ((FeedCloudMeta.StComment)localObject).postUser.set(tqg.a());
        if (localubb != null) {
          localubb.a((FeedCloudMeta.StComment)localObject);
        }
        uax.a(this.jdField_a_of_type_Uax, this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, (FeedCloudMeta.StComment)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uay
 * JD-Core Version:    0.7.0.1
 */