import UserGrowth.stSimpleGetFeedDetailReq;
import UserGrowth.stSimpleGetFeedDetailRsp;

public class vkz
  extends vfo<stSimpleGetFeedDetailRsp>
{
  public vkz(String paramString)
  {
    super("SimpleGetFeedDetail", 10002);
    stSimpleGetFeedDetailReq localstSimpleGetFeedDetailReq = new stSimpleGetFeedDetailReq();
    localstSimpleGetFeedDetailReq.feedid = paramString;
    this.a = localstSimpleGetFeedDetailReq;
    vmp.b("SimpleGetFeedDetailRequest", "stSimpleGetFeedDetailReq = " + localstSimpleGetFeedDetailReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkz
 * JD-Core Version:    0.7.0.1
 */