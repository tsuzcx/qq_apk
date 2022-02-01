import UserGrowth.stPostCommentReplyV2Req;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;

public class onw
  extends okw<stPostCommentReplyV2Rsp>
{
  public onw(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    super("PostCommentReplyV2");
    this.req = new stPostCommentReplyV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onw
 * JD-Core Version:    0.7.0.1
 */