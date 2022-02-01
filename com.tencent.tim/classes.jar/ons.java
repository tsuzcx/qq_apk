import UserGrowth.stSimpleGetFeedDetailReq;
import UserGrowth.stSimpleGetFeedDetailRsp;

public class ons
  extends okw<stSimpleGetFeedDetailRsp>
{
  public ons(String paramString)
  {
    super("SimpleGetFeedDetail");
    stSimpleGetFeedDetailReq localstSimpleGetFeedDetailReq = new stSimpleGetFeedDetailReq();
    localstSimpleGetFeedDetailReq.feedid = paramString;
    this.req = localstSimpleGetFeedDetailReq;
    ooz.d("SimpleGetFeedDetailRequest", "stSimpleGetFeedDetailReq = " + localstSimpleGetFeedDetailReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ons
 * JD-Core Version:    0.7.0.1
 */