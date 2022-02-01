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

class vwa
  implements vjt
{
  vwa(vvz paramvvz, Activity paramActivity, vkl paramvkl, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean, vba paramvba) {}
  
  public void a()
  {
    QLog.d("QCircleCommentHelper", 1, "onClickSend()");
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      QLog.d("QCircleCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = this.jdField_a_of_type_Vkl.a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692047), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131693974), 0).a();
      return;
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)
    {
      QLog.e("QCircleCommentHelper", 1, "feed is null");
      return;
    }
    if (vvz.a(this.jdField_a_of_type_Vvz) != null) {}
    for (vwd localvwd = (vwd)vvz.a(this.jdField_a_of_type_Vvz).get();; localvwd = null)
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)
      {
        localObject = new FeedCloudMeta.StReply();
        ((FeedCloudMeta.StReply)localObject).id.set("fakeId_" + System.currentTimeMillis());
        ((FeedCloudMeta.StReply)localObject).content.set(str);
        ((FeedCloudMeta.StReply)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
        ((FeedCloudMeta.StReply)localObject).postUser.set(uyn.a());
        if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()))) {
          ((FeedCloudMeta.StReply)localObject).targetUser.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get());
        }
        if (localvwd != null)
        {
          QLog.d("QCircleCommentHelper", 1, "addFakeReply commentInputListener callback success");
          localvwd.a((FeedCloudMeta.StReply)localObject);
        }
        for (;;)
        {
          vvz.a(this.jdField_a_of_type_Vvz).a(this.jdField_a_of_type_AndroidAppActivity.hashCode(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, (FeedCloudMeta.StReply)localObject, this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_Vkl.a("");
          this.jdField_a_of_type_Vkl.b(null);
          this.jdField_a_of_type_Vkl.dismiss();
          aaak.a().a(new QCircleFuelAnimationEvent());
          return;
          QLog.e("QCircleCommentHelper", 1, "addFakeReply commentInputListener null");
        }
      }
      Object localObject = new FeedCloudMeta.StComment();
      ((FeedCloudMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StComment)localObject).content.set(str);
      ((FeedCloudMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StComment)localObject).postUser.set(uyn.a());
      if (localvwd != null)
      {
        QLog.d("QCircleCommentHelper", 1, "addFakeComment commentInputListener callback success");
        localvwd.a((FeedCloudMeta.StComment)localObject);
      }
      for (;;)
      {
        vvz.a(this.jdField_a_of_type_Vvz).a(this.jdField_a_of_type_AndroidAppActivity.hashCode(), this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, (FeedCloudMeta.StComment)localObject, this.jdField_a_of_type_Boolean);
        break;
        QLog.e("QCircleCommentHelper", 1, "addFakeComment commentInputListener null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwa
 * JD-Core Version:    0.7.0.1
 */