import NS_KING_INTERFACE.stPostCommentDingReq;
import NS_KING_INTERFACE.stPostCommentDingRsp;

public class tkj
  extends thb<stPostCommentDingRsp>
{
  public tkj(String paramString1, String paramString2, int paramInt)
  {
    super("PostCommentDing");
    this.a = new stPostCommentDingReq(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkj
 * JD-Core Version:    0.7.0.1
 */