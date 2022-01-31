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

class ubj
  implements yvn<FeedCloudWrite.StRecomForwardFeedRsp>
{
  ubj(ubi paramubi) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StRecomForwardFeedRsp paramStRecomForwardFeedRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStRecomForwardFeedRsp == null) || (TextUtils.isEmpty(paramStRecomForwardFeedRsp.feed.recomForward.id.get())))
    {
      wsv.c("QCircleBaseInputPopupWindow", "QCircleRecomForwardRequest  error, retCode == " + paramLong);
      QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131698363), 0).a();
      return;
    }
    wsv.c("QCircleBaseInputPopupWindow", "QCircleRecomForwardRequest  success, rsp.feed.recomForward.id.get() == " + paramStRecomForwardFeedRsp.feed.recomForward.id.get() + " , commentId:" + paramStRecomForwardFeedRsp.comment.id.get());
    QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131698364), 0).a();
    ubi.a(this.a).recomForward.id.set(paramStRecomForwardFeedRsp.feed.recomForward.id.get());
    if (ubi.a(this.a).isSelected())
    {
      yej.a().a(new QCircleForwardEvent(ubi.a(this.a), true));
      return;
    }
    yej.a().a(new QCircleForwardEvent(ubi.a(this.a), false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubj
 * JD-Core Version:    0.7.0.1
 */