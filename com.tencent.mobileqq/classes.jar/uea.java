import android.text.TextUtils;
import android.widget.ImageButton;
import com.tencent.biz.qqcircle.events.QCircleForwardEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudWrite.StRecomForwardFeedRsp;

class uea
  implements zac<FeedCloudWrite.StRecomForwardFeedRsp>
{
  uea(udz paramudz) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StRecomForwardFeedRsp paramStRecomForwardFeedRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStRecomForwardFeedRsp == null) || (TextUtils.isEmpty(paramStRecomForwardFeedRsp.feed.recomForward.id.get())))
    {
      wxe.c("QCircleBaseInputPopupWindow", "QCircleRecomForwardRequest  error, retCode == " + paramLong);
      QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131698375), 0).a();
      return;
    }
    wxe.c("QCircleBaseInputPopupWindow", "QCircleRecomForwardRequest  success, rsp.feed.recomForward.id.get() == " + paramStRecomForwardFeedRsp.feed.recomForward.id.get() + " , commentId:" + paramStRecomForwardFeedRsp.comment.id.get());
    QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131698376), 0).a();
    udz.a(this.a).recomForward.id.set(paramStRecomForwardFeedRsp.feed.recomForward.id.get());
    if (udz.a(this.a).isSelected())
    {
      yiw.a().a(new QCircleForwardEvent(udz.a(this.a), true));
      return;
    }
    yiw.a().a(new QCircleForwardEvent(udz.a(this.a), false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uea
 * JD-Core Version:    0.7.0.1
 */