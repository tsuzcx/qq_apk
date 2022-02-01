import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

public class pew
  implements rxc.a<FeedCloudWrite.StDoLikeRsp>
{
  public pew(QCircleCommentPraiseLayout paramQCircleCommentPraiseLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    if ((paramBoolean) && (paramLong == 0L)) {
      if (QCircleCommentPraiseLayout.a(this.this$0) != null)
      {
        paramString = QCircleCommentPraiseLayout.a(this.this$0).id.get();
        if (QCircleCommentPraiseLayout.a(this.this$0) == null) {
          break label183;
        }
        paramStDoLikeRsp = QCircleCommentPraiseLayout.a(this.this$0).id.get();
        label60:
        if ((QCircleCommentPraiseLayout.a(this.this$0) != 1) || (QCircleCommentPraiseLayout.a(this.this$0) == null)) {
          break label190;
        }
        QCircleCommentPraiseLayout.a(this.this$0).likeInfo.status.set(this.Is);
        QCircleCommentPraiseLayout.a(this.this$0).likeInfo.count.set(this.bia);
        label121:
        rwv.a().a(new QCircleCommentPraiseUpdateEvent(QCircleCommentPraiseLayout.a(this.this$0), this.Is, QCircleCommentPraiseLayout.a(this.this$0).id.get(), paramString, paramStDoLikeRsp, this.bia));
      }
    }
    for (;;)
    {
      QCircleCommentPraiseLayout.a(this.this$0, true);
      return;
      paramString = "";
      break;
      label183:
      paramStDoLikeRsp = "";
      break label60;
      label190:
      if ((QCircleCommentPraiseLayout.a(this.this$0) != 2) || (QCircleCommentPraiseLayout.a(this.this$0) == null)) {
        break label121;
      }
      QCircleCommentPraiseLayout.a(this.this$0).likeInfo.status.set(this.Is);
      QCircleCommentPraiseLayout.a(this.this$0).likeInfo.count.set(this.bia);
      break label121;
      this.this$0.Q(this.bib, this.bic);
      QQToast.a(this.this$0.getContext(), paramString, 0).show();
      QLog.d("QCircleCommentPraiseLay", 4, "zan failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pew
 * JD-Core Version:    0.7.0.1
 */