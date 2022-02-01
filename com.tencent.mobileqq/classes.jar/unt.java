import NS_KING_INTERFACE.stPostCommentDingReq;
import NS_KING_INTERFACE.stPostCommentDingRsp;

public class unt
  extends ujr<stPostCommentDingRsp>
{
  public unt(String paramString1, String paramString2, int paramInt)
  {
    super("PostCommentDing", 10003);
    this.a = new stPostCommentDingReq(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unt
 * JD-Core Version:    0.7.0.1
 */