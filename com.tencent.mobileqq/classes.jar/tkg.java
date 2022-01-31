import UserGrowth.stSimpleGetFeedDetailReq;
import UserGrowth.stSimpleGetFeedDetailRsp;

public class tkg
  extends thb<stSimpleGetFeedDetailRsp>
{
  public tkg(String paramString)
  {
    super("SimpleGetFeedDetail");
    stSimpleGetFeedDetailReq localstSimpleGetFeedDetailReq = new stSimpleGetFeedDetailReq();
    localstSimpleGetFeedDetailReq.feedid = paramString;
    this.a = localstSimpleGetFeedDetailReq;
    tlo.b("SimpleGetFeedDetailRequest", "stSimpleGetFeedDetailReq = " + localstSimpleGetFeedDetailReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkg
 * JD-Core Version:    0.7.0.1
 */