import NS_KING_INTERFACE.stPostCommentReplyReq;
import NS_KING_INTERFACE.stPostCommentReplyRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaReply;
import UserGrowth.stSimpleMetaFeed;

public class tkk
  extends thb<stPostCommentReplyRsp>
{
  public tkk(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment, stMetaReply paramstMetaReply)
  {
    super("PostCommentReply");
    this.a = new stPostCommentReplyReq(paramstSimpleMetaFeed.id, paramstMetaComment.id, paramstMetaReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkk
 * JD-Core Version:    0.7.0.1
 */