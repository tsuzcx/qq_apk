import UserGrowth.stPostCommentReplyV2Req;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;

public class uov
  extends ukl<stPostCommentReplyV2Rsp>
{
  public uov(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    super("PostCommentReplyV2", 10003);
    this.a = new stPostCommentReplyV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uov
 * JD-Core Version:    0.7.0.1
 */