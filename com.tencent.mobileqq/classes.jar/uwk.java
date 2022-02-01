import UserGrowth.stSimpleGetFeedDetailReq;
import UserGrowth.stSimpleGetFeedDetailRsp;

public class uwk
  extends urg<stSimpleGetFeedDetailRsp>
{
  public uwk(String paramString)
  {
    super("SimpleGetFeedDetail", 10002);
    stSimpleGetFeedDetailReq localstSimpleGetFeedDetailReq = new stSimpleGetFeedDetailReq();
    localstSimpleGetFeedDetailReq.feedid = paramString;
    this.a = localstSimpleGetFeedDetailReq;
    uya.b("SimpleGetFeedDetailRequest", "stSimpleGetFeedDetailReq = " + localstSimpleGetFeedDetailReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwk
 * JD-Core Version:    0.7.0.1
 */