import NS_KING_INTERFACE.stPostCommentDingReq;
import NS_KING_INTERFACE.stPostCommentDingRsp;

public class onv
  extends okw<stPostCommentDingRsp>
{
  public onv(String paramString1, String paramString2, int paramInt)
  {
    super("PostCommentDing");
    this.req = new stPostCommentDingReq(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onv
 * JD-Core Version:    0.7.0.1
 */