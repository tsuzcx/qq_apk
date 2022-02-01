import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
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

class vte
  implements vhp
{
  vte(vtd paramvtd, Activity paramActivity, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean, uzk paramuzk) {}
  
  public void a()
  {
    QLog.d("QCircleCommentHelper", 1, "onClickSend()");
    if ((this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (vtd.a(this.jdField_a_of_type_Vtd) == null))
    {
      QLog.d("QCircleCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = vtd.a(this.jdField_a_of_type_Vtd).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692042), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131693957), 0).a();
      return;
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)
    {
      QLog.e("QCircleCommentHelper", 1, "feed is null");
      return;
    }
    if (vtd.a(this.jdField_a_of_type_Vtd) != null) {}
    for (vth localvth = (vth)vtd.a(this.jdField_a_of_type_Vtd).get();; localvth = null)
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)
      {
        localObject = new FeedCloudMeta.StReply();
        ((FeedCloudMeta.StReply)localObject).id.set("fakeId_" + System.currentTimeMillis());
        ((FeedCloudMeta.StReply)localObject).content.set(str);
        ((FeedCloudMeta.StReply)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
        ((FeedCloudMeta.StReply)localObject).postUser.set(uxc.a());
        if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()))) {
          ((FeedCloudMeta.StReply)localObject).targetUser.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get());
        }
        if (localvth != null)
        {
          QLog.d("QCircleCommentHelper", 1, "addFakeReply commentInputListener callback success");
          localvth.a((FeedCloudMeta.StReply)localObject);
        }
        for (;;)
        {
          vtd.a(this.jdField_a_of_type_Vtd).a(this.jdField_a_of_type_AndroidAppActivity.hashCode(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, (FeedCloudMeta.StReply)localObject, this.jdField_a_of_type_Boolean);
          vtd.a(this.jdField_a_of_type_Vtd).a("");
          vtd.a(this.jdField_a_of_type_Vtd).b(null);
          vtd.a(this.jdField_a_of_type_Vtd).dismiss();
          zwp.a().a(new QCircleFuelAnimationEvent());
          return;
          QLog.e("QCircleCommentHelper", 1, "addFakeReply commentInputListener null");
        }
      }
      Object localObject = new FeedCloudMeta.StComment();
      ((FeedCloudMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StComment)localObject).content.set(str);
      ((FeedCloudMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StComment)localObject).postUser.set(uxc.a());
      if (localvth != null)
      {
        QLog.d("QCircleCommentHelper", 1, "addFakeComment commentInputListener callback success");
        localvth.a((FeedCloudMeta.StComment)localObject);
      }
      for (;;)
      {
        vtd.a(this.jdField_a_of_type_Vtd).a(this.jdField_a_of_type_AndroidAppActivity.hashCode(), this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, (FeedCloudMeta.StComment)localObject, this.jdField_a_of_type_Boolean);
        break;
        QLog.e("QCircleCommentHelper", 1, "addFakeComment commentInputListener null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vte
 * JD-Core Version:    0.7.0.1
 */