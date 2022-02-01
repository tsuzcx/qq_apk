import com.tencent.biz.qqcircle.comment.QCircleReplyItemView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public class vkt
  implements vyx
{
  public vkt(QCircleReplyItemView paramQCircleReplyItemView) {}
  
  public void a(boolean paramBoolean)
  {
    FeedCloudMeta.StComment localStComment;
    FeedCloudMeta.StReply localStReply;
    aakb localaakb;
    QCircleCommentPraiseLayout localQCircleCommentPraiseLayout;
    if (QCircleReplyItemView.a(this.a) != null)
    {
      localStComment = QCircleReplyItemView.a(this.a);
      localStReply = QCircleReplyItemView.a(this.a);
      localaakb = QCircleReplyItemView.a(this.a);
      localQCircleCommentPraiseLayout = QCircleReplyItemView.a(this.a);
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i = 14;; i = 15)
    {
      localaakb.a(localQCircleCommentPraiseLayout, i, QCircleReplyItemView.a(this.a), new Object[] { localStComment, localStReply });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkt
 * JD-Core Version:    0.7.0.1
 */