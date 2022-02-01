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

class pfz
  implements rxc.a<FeedCloudWrite.StRecomForwardFeedRsp>
{
  pfz(pfy parampfy) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StRecomForwardFeedRsp paramStRecomForwardFeedRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStRecomForwardFeedRsp == null) || (TextUtils.isEmpty(paramStRecomForwardFeedRsp.feed.recomForward.id.get())))
    {
      ram.i("QCircleBaseInputPopupWindow", "QCircleRecomForwardRequest  error, retCode == " + paramLong);
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131700166), 0).show();
      return;
    }
    ram.i("QCircleBaseInputPopupWindow", "QCircleRecomForwardRequest  success, rsp.feed.recomForward.id.get() == " + paramStRecomForwardFeedRsp.feed.recomForward.id.get() + " , commentId:" + paramStRecomForwardFeedRsp.comment.id.get());
    QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131700167), 0).show();
    pfy.a(this.b).recomForward.id.set(paramStRecomForwardFeedRsp.feed.recomForward.id.get());
    if (pfy.a(this.b).isSelected())
    {
      rwv.a().a(new QCircleForwardEvent(pfy.a(this.b), true));
      return;
    }
    rwv.a().a(new QCircleForwardEvent(pfy.a(this.b), false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfz
 * JD-Core Version:    0.7.0.1
 */