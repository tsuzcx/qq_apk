import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;

public class tkm
  extends thb<stPostFeedDingRsp>
{
  public tkm(String paramString, int paramInt)
  {
    super("PostFeedDing");
    this.a = new stPostFeedDingReq(paramString, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkm
 * JD-Core Version:    0.7.0.1
 */