import NS_KING_INTERFACE.stPostFeedCommentReq;
import NS_KING_INTERFACE.stPostFeedCommentRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;
import UserGrowth.stSimpleMetaFeed;

public class tkl
  extends thb<stPostFeedCommentRsp>
{
  public tkl(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment)
  {
    super("PostFeedComment");
    this.a = new stPostFeedCommentReq(paramstSimpleMetaFeed.id, paramstMetaComment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkl
 * JD-Core Version:    0.7.0.1
 */