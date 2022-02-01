import UserGrowth.stSimpleGetFeedDetailReq;
import UserGrowth.stSimpleGetFeedDetailRsp;

public class uoq
  extends ukl<stSimpleGetFeedDetailRsp>
{
  public uoq(String paramString)
  {
    super("SimpleGetFeedDetail", 10002);
    stSimpleGetFeedDetailReq localstSimpleGetFeedDetailReq = new stSimpleGetFeedDetailReq();
    localstSimpleGetFeedDetailReq.feedid = paramString;
    this.a = localstSimpleGetFeedDetailReq;
    uqf.b("SimpleGetFeedDetailRequest", "stSimpleGetFeedDetailReq = " + localstSimpleGetFeedDetailReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoq
 * JD-Core Version:    0.7.0.1
 */