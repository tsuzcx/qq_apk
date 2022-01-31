import NS_KING_INTERFACE.stDeleteFeedCommentReq;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_SOCIALIZE_META.stMetaComment;

public class tkd
  extends thb<stDeleteFeedCommentRsp>
{
  public tkd(String paramString, stMetaComment paramstMetaComment)
  {
    super("DeleteFeedComment");
    this.a = new stDeleteFeedCommentReq(paramString, paramstMetaComment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkd
 * JD-Core Version:    0.7.0.1
 */