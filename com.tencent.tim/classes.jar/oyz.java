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

class oyz
  implements peo.a
{
  oyz(oyu paramoyu, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void biG()
  {
    QLog.d("QCircleCommentPanelView", 1, "onClick onSendEvent, pageId: " + pcr.a().getPageId() + "  parentPageId: " + pcr.a().sb());
    if (oyu.a(this.this$0) == null) {
      QLog.d("QCircleCommentPanelView", 1, "onCommentSend(): mCommentInputPopupWindow null");
    }
    String str;
    do
    {
      return;
      str = oyu.a(this.this$0).getText();
    } while (TextUtils.isEmpty(str.trim()));
    if (!NetworkUtils.isNetworkAvailable(oyu.c(this.this$0)))
    {
      QQToast.a(oyu.f(this.this$0), 1, oyu.g(this.this$0).getString(2131696284), 0).show();
      return;
    }
    if (oyu.a(this.this$0) == null)
    {
      QLog.e("QCircleCommentPanelView", 1, "feed is null");
      return;
    }
    Object localObject;
    if (this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment != null)
    {
      if (oyu.a(this.this$0) == null) {
        oyu.a(this.this$0, oyu.a(this.this$0, this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_e_of_type_FeedcloudFeedCloudMeta$StReply));
      }
      oyu.a(this.this$0).content.set(str);
      localObject = new FeedCloudMeta.StReply();
      ((FeedCloudMeta.StReply)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StReply)localObject).content.set(str);
      ((FeedCloudMeta.StReply)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StReply)localObject).postUser.set(oyu.a(this.this$0));
      if ((this.jdField_e_of_type_FeedcloudFeedCloudMeta$StReply != null) && (!TextUtils.isEmpty(this.jdField_e_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get()))) {
        ((FeedCloudMeta.StReply)localObject).targetUser.set(this.jdField_e_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get());
      }
      if (oyu.a(this.this$0).targetUser != null) {
        oyu.a(this.this$0).put(Long.valueOf(oyu.a(this.this$0)), oyu.a(this.this$0).targetUser);
      }
      QLog.d("QCircleCommentPanelView", 1, "onClick onSendEvent addCommentReply, feedId: " + oyu.a(this.this$0).id + " commentId: " + this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment.id.get() + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
      oyu.a(this.this$0, this.this$0.a().a(oyu.a(this.this$0), this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment, (FeedCloudMeta.StReply)localObject));
      oyu.b(this.this$0, true);
      oyu.c(this.this$0, true);
      if (oyu.b(this.this$0) != null) {
        oyu.b(this.this$0).put(Long.valueOf(oyu.a(this.this$0)), oyu.a(this.this$0));
      }
      oyu.a(this.this$0, null);
      if (oyu.a(this.this$0) != null)
      {
        oyu.a(this.this$0).a(this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), (FeedCloudMeta.StReply)localObject);
        oyu.a(this.this$0).notifyDataSetChanged();
        oyu.a(this.this$0, this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
      }
    }
    for (;;)
    {
      oyu.a(this.this$0).setText("");
      oyu.a(this.this$0).qG(null);
      oyu.a(this.this$0).dismiss();
      rwv.a().a(new QCircleFuelAnimationEvent());
      if (((!pcr.a().ez(61)) || (!pcr.a().eA(57))) && (!pcr.a().ez(57))) {
        break;
      }
      pcp.b(oyu.a(this.this$0), 3, oyu.a(this.this$0));
      return;
      if (oyu.a(this.this$0) == null) {
        oyu.a(this.this$0, oyu.b(this.this$0, this.jdField_e_of_type_FeedcloudFeedCloudMeta$StComment));
      }
      oyu.a(this.this$0).content.set(str);
      localObject = new FeedCloudMeta.StComment();
      ((FeedCloudMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((FeedCloudMeta.StComment)localObject).content.set(str);
      ((FeedCloudMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StComment)localObject).postUser.set(oyu.a(this.this$0));
      QLog.d("QCircleCommentPanelView", 1, "onClick onSendEvent addFeedComment, feedId: " + oyu.a(this.this$0).id + " commentId: " + ((FeedCloudMeta.StComment)localObject).id.get());
      this.this$0.a().a(oyu.a(this.this$0), (FeedCloudMeta.StComment)localObject);
      oyu.b(this.this$0, true);
      oyu.c(this.this$0, true);
      oyu.a(this.this$0, null);
      if (oyu.a(this.this$0) != null)
      {
        oyu.a(this.this$0).a((FeedCloudMeta.StComment)localObject);
        oyu.a(this.this$0).notifyDataSetChanged();
      }
      if (this.this$0.l != null)
      {
        QLog.d("QCircleCommentPanelView", 1, "mNeedShowCommentList1");
        this.this$0.l.setSelection(0);
      }
    }
    pcl.a(oyu.a(this.this$0), 3, oyu.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyz
 * JD-Core Version:    0.7.0.1
 */