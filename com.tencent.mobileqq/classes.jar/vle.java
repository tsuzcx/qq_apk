import UserGrowth.stPostCommentReplyV2Req;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;

public class vle
  extends vfo<stPostCommentReplyV2Rsp>
{
  public vle(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    super("PostCommentReplyV2", 10003);
    this.a = new stPostCommentReplyV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vle
 * JD-Core Version:    0.7.0.1
 */