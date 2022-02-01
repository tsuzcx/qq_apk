import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;

public class uox
  extends ukl<stPostFeedDingRsp>
{
  public uox(String paramString, int paramInt)
  {
    super("PostFeedDing");
    this.a = new stPostFeedDingReq(paramString, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uox
 * JD-Core Version:    0.7.0.1
 */