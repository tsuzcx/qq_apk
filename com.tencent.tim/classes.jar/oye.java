import com.tencent.biz.qqcircle.comment.ItemReplyView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout.a;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public class oye
  implements QCircleCommentPraiseLayout.a
{
  public oye(ItemReplyView paramItemReplyView) {}
  
  public void rj(boolean paramBoolean)
  {
    FeedCloudMeta.StComment localStComment;
    FeedCloudMeta.StReply localStReply;
    sdw localsdw;
    QCircleCommentPraiseLayout localQCircleCommentPraiseLayout;
    if (ItemReplyView.a(this.a) != null)
    {
      localStComment = ItemReplyView.a(this.a);
      localStReply = ItemReplyView.a(this.a);
      localsdw = ItemReplyView.a(this.a);
      localQCircleCommentPraiseLayout = ItemReplyView.a(this.a);
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i = 14;; i = 15)
    {
      localsdw.a(localQCircleCommentPraiseLayout, i, ItemReplyView.a(this.a), new Object[] { localStComment, localStReply });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oye
 * JD-Core Version:    0.7.0.1
 */