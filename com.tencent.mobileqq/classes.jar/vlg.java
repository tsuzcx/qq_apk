import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;

public class vlg
  extends vfo<stPostFeedDingRsp>
{
  public vlg(String paramString, int paramInt)
  {
    super("PostFeedDing");
    this.a = new stPostFeedDingReq(paramString, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlg
 * JD-Core Version:    0.7.0.1
 */