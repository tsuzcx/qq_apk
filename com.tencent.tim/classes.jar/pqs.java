import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class pqs
  extends plt
{
  public final int bjU;
  public CommentLikeFeedItem c;
  public int commentId;
  public final String feedId;
  public int what = 0;
  
  public pqs(int paramInt1, String paramString, int paramInt2)
  {
    this.what = paramInt2;
    this.feedId = paramString;
    this.bjU = paramInt1;
  }
  
  public pqs(int paramInt1, String paramString, int paramInt2, CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.c = paramCommentLikeFeedItem;
    this.what = paramInt2;
    this.feedId = paramString;
    this.bjU = paramInt1;
  }
  
  public String toString()
  {
    return "InteractionInfoChangeEvent{, feedId=" + this.feedId + ", what=" + this.what + ", commentLikeFeedItem=" + this.c + ", commentId=" + this.commentId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqs
 * JD-Core Version:    0.7.0.1
 */