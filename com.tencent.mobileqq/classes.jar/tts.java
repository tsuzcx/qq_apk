import com.tencent.biz.qqcircle.comment.ItemReplyView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public class tts
  implements uad
{
  public tts(ItemReplyView paramItemReplyView) {}
  
  public void a(boolean paramBoolean)
  {
    FeedCloudMeta.StComment localStComment;
    FeedCloudMeta.StReply localStReply;
    yde localyde;
    QCircleCommentPraiseLayout localQCircleCommentPraiseLayout;
    if (ItemReplyView.a(this.a) != null)
    {
      localStComment = ItemReplyView.a(this.a);
      localStReply = ItemReplyView.a(this.a);
      localyde = ItemReplyView.a(this.a);
      localQCircleCommentPraiseLayout = ItemReplyView.a(this.a);
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i = 14;; i = 15)
    {
      localyde.a(localQCircleCommentPraiseLayout, i, ItemReplyView.a(this.a), new Object[] { localStComment, localStReply });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tts
 * JD-Core Version:    0.7.0.1
 */