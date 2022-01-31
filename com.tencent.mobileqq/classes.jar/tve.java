import android.content.Context;
import android.text.TextUtils;
import android.widget.ListView;
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
import java.util.Map;

class tve
  implements ucm
{
  tve(tuz paramtuz, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d("QCircleCommentPanelView", 1, "onClick onSendEvent, pageId: " + tzy.a().a() + "  parentPageId: " + tzy.a().b());
    if (tuz.a(this.jdField_a_of_type_Tuz) == null)
    {
      QLog.d("QCircleCommentPanelView", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = tuz.a(this.jdField_a_of_type_Tuz).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(tuz.f(this.jdField_a_of_type_Tuz), tuz.g(this.jdField_a_of_type_Tuz).getString(2131692457), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(tuz.c(this.jdField_a_of_type_Tuz)))
    {
      QQToast.a(tuz.h(this.jdField_a_of_type_Tuz), 1, tuz.i(this.jdField_a_of_type_Tuz).getString(2131694779), 0).a();
      return;
    }
    if (tuz.a(this.jdField_a_of_type_Tuz) == null)
    {
      QLog.e("QCircleCommentPanelView", 1, "feed is null");
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)
    {
      if (tuz.a(this.jdField_a_of_type_Tuz) == null) {
        tuz.a(this.jdField_a_of_type_Tuz, tuz.a(this.jdField_a_of_type_Tuz, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply));
      }
      tuz.a(this.jdField_a_of_type_Tuz).content.set(str);
      localObject = new FeedCloudMeta.StReply();
      ((FeedCloudMeta.StReply)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StReply)localObject).content.set(str);
      ((FeedCloudMeta.StReply)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StReply)localObject).postUser.set(tuz.a(this.jdField_a_of_type_Tuz));
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()))) {
        ((FeedCloudMeta.StReply)localObject).targetUser.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get());
      }
      if (tuz.a(this.jdField_a_of_type_Tuz).targetUser != null) {
        tuz.a(this.jdField_a_of_type_Tuz).put(Long.valueOf(tuz.a(this.jdField_a_of_type_Tuz)), tuz.a(this.jdField_a_of_type_Tuz).targetUser);
      }
      QLog.d("QCircleCommentPanelView", 1, "onClick onSendEvent addCommentReply, feedId: " + tuz.a(this.jdField_a_of_type_Tuz).id + " commentId: " + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get() + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
      tuz.a(this.jdField_a_of_type_Tuz, this.jdField_a_of_type_Tuz.a().a(tuz.a(this.jdField_a_of_type_Tuz), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, (FeedCloudMeta.StReply)localObject));
      tuz.b(this.jdField_a_of_type_Tuz, true);
      tuz.c(this.jdField_a_of_type_Tuz, true);
      if (tuz.b(this.jdField_a_of_type_Tuz) != null) {
        tuz.b(this.jdField_a_of_type_Tuz).put(Long.valueOf(tuz.a(this.jdField_a_of_type_Tuz)), tuz.a(this.jdField_a_of_type_Tuz));
      }
      tuz.a(this.jdField_a_of_type_Tuz, null);
      if (tuz.a(this.jdField_a_of_type_Tuz) != null)
      {
        tuz.a(this.jdField_a_of_type_Tuz).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), (FeedCloudMeta.StReply)localObject);
        tuz.a(this.jdField_a_of_type_Tuz).notifyDataSetChanged();
        tuz.a(this.jdField_a_of_type_Tuz, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
      }
    }
    for (;;)
    {
      tuz.a(this.jdField_a_of_type_Tuz).a("");
      tuz.a(this.jdField_a_of_type_Tuz).b(null);
      tuz.a(this.jdField_a_of_type_Tuz).dismiss();
      yiw.a().a(new QCircleFuelAnimationEvent());
      if (((!tzy.a().c(61)) || (!tzy.a().d(57))) && (!tzy.a().c(57))) {
        break;
      }
      tzw.a(tuz.a(this.jdField_a_of_type_Tuz), 3, tuz.a(this.jdField_a_of_type_Tuz));
      return;
      if (tuz.a(this.jdField_a_of_type_Tuz) == null) {
        tuz.a(this.jdField_a_of_type_Tuz, tuz.b(this.jdField_a_of_type_Tuz, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment));
      }
      tuz.a(this.jdField_a_of_type_Tuz).content.set(str);
      localObject = new FeedCloudMeta.StComment();
      ((FeedCloudMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StComment)localObject).content.set(str);
      ((FeedCloudMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StComment)localObject).postUser.set(tuz.a(this.jdField_a_of_type_Tuz));
      QLog.d("QCircleCommentPanelView", 1, "onClick onSendEvent addFeedComment, feedId: " + tuz.a(this.jdField_a_of_type_Tuz).id + " commentId: " + ((FeedCloudMeta.StComment)localObject).id.get());
      this.jdField_a_of_type_Tuz.a().a(tuz.a(this.jdField_a_of_type_Tuz), (FeedCloudMeta.StComment)localObject);
      tuz.b(this.jdField_a_of_type_Tuz, true);
      tuz.c(this.jdField_a_of_type_Tuz, true);
      tuz.a(this.jdField_a_of_type_Tuz, null);
      if (tuz.a(this.jdField_a_of_type_Tuz) != null)
      {
        tuz.a(this.jdField_a_of_type_Tuz).a((FeedCloudMeta.StComment)localObject);
        tuz.a(this.jdField_a_of_type_Tuz).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Tuz.a != null)
      {
        QLog.d("QCircleCommentPanelView", 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Tuz.a.setSelection(0);
      }
    }
    tzs.a(tuz.a(this.jdField_a_of_type_Tuz), 3, tuz.a(this.jdField_a_of_type_Tuz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tve
 * JD-Core Version:    0.7.0.1
 */