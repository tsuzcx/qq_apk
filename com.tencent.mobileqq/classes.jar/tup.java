import android.content.Context;
import android.text.TextUtils;
import android.widget.ListView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;

class tup
  implements tzy
{
  tup(tuk paramtuk, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(tuk.a(), 1, "onCommentSend()");
    if (tuk.a(this.jdField_a_of_type_Tuk) == null)
    {
      QLog.d(tuk.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = tuk.a(this.jdField_a_of_type_Tuk).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(tuk.f(this.jdField_a_of_type_Tuk), tuk.g(this.jdField_a_of_type_Tuk).getString(2131692456), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(tuk.c(this.jdField_a_of_type_Tuk)))
    {
      QQToast.a(tuk.h(this.jdField_a_of_type_Tuk), 1, tuk.i(this.jdField_a_of_type_Tuk).getString(2131694777), 0).a();
      return;
    }
    if (tuk.a(this.jdField_a_of_type_Tuk) == null)
    {
      QLog.e(tuk.a(), 1, "feed is null");
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)
    {
      if (tuk.a(this.jdField_a_of_type_Tuk) == null) {
        tuk.a(this.jdField_a_of_type_Tuk, tuk.a(this.jdField_a_of_type_Tuk, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply));
      }
      tuk.a(this.jdField_a_of_type_Tuk).content.set(str);
      localObject = new FeedCloudMeta.StReply();
      ((FeedCloudMeta.StReply)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StReply)localObject).content.set(str);
      ((FeedCloudMeta.StReply)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StReply)localObject).postUser.set(tuk.a(this.jdField_a_of_type_Tuk));
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()))) {
        ((FeedCloudMeta.StReply)localObject).targetUser.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get());
      }
      if (tuk.a(this.jdField_a_of_type_Tuk).targetUser != null) {
        tuk.a(this.jdField_a_of_type_Tuk).put(Long.valueOf(tuk.a(this.jdField_a_of_type_Tuk)), tuk.a(this.jdField_a_of_type_Tuk).targetUser);
      }
      tuk.a(this.jdField_a_of_type_Tuk, this.jdField_a_of_type_Tuk.a().a(tuk.a(this.jdField_a_of_type_Tuk), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, (FeedCloudMeta.StReply)localObject));
      tuk.b(this.jdField_a_of_type_Tuk, true);
      tuk.c(this.jdField_a_of_type_Tuk, true);
      if (tuk.b(this.jdField_a_of_type_Tuk) != null) {
        tuk.b(this.jdField_a_of_type_Tuk).put(Long.valueOf(tuk.a(this.jdField_a_of_type_Tuk)), tuk.a(this.jdField_a_of_type_Tuk));
      }
      tuk.a(this.jdField_a_of_type_Tuk, null);
      if (tuk.a(this.jdField_a_of_type_Tuk) != null)
      {
        tuk.a(this.jdField_a_of_type_Tuk).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), (FeedCloudMeta.StReply)localObject);
        tuk.a(this.jdField_a_of_type_Tuk).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      tuk.a(this.jdField_a_of_type_Tuk).a("");
      tuk.a(this.jdField_a_of_type_Tuk).b(null);
      tuk.a(this.jdField_a_of_type_Tuk).dismiss();
      if (((!tym.a().c(61)) || (!tym.a().d(57))) && (!tym.a().c(57))) {
        break;
      }
      tyk.a(tuk.a(this.jdField_a_of_type_Tuk), 3, tuk.a(this.jdField_a_of_type_Tuk));
      return;
      if (tuk.a(this.jdField_a_of_type_Tuk) == null) {
        tuk.a(this.jdField_a_of_type_Tuk, tuk.b(this.jdField_a_of_type_Tuk, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment));
      }
      tuk.a(this.jdField_a_of_type_Tuk).content.set(str);
      localObject = new FeedCloudMeta.StComment();
      ((FeedCloudMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StComment)localObject).content.set(str);
      ((FeedCloudMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StComment)localObject).postUser.set(tuk.a(this.jdField_a_of_type_Tuk));
      this.jdField_a_of_type_Tuk.a().a(tuk.a(this.jdField_a_of_type_Tuk), (FeedCloudMeta.StComment)localObject);
      tuk.b(this.jdField_a_of_type_Tuk, true);
      tuk.c(this.jdField_a_of_type_Tuk, true);
      tuk.a(this.jdField_a_of_type_Tuk, null);
      if (tuk.a(this.jdField_a_of_type_Tuk) != null)
      {
        tuk.a(this.jdField_a_of_type_Tuk).a((FeedCloudMeta.StComment)localObject);
        tuk.a(this.jdField_a_of_type_Tuk).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Tuk.a != null)
      {
        QLog.d(tuk.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Tuk.a.setSelection(0);
      }
    }
    tyg.a(tuk.a(this.jdField_a_of_type_Tuk), 3, tuk.a(this.jdField_a_of_type_Tuk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tup
 * JD-Core Version:    0.7.0.1
 */