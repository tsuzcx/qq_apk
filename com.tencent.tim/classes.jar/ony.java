import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;

public class ony
  extends okw<stPostFeedDingRsp>
{
  public ony(String paramString, int paramInt)
  {
    super("PostFeedDing");
    this.req = new stPostFeedDingReq(paramString, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ony
 * JD-Core Version:    0.7.0.1
 */