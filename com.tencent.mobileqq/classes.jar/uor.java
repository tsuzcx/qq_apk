import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;

public class uor
  extends ukl<stPublisherRsp>
{
  public uor()
  {
    super("Publisher", 10004);
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.a = localstPublisherReq;
    uqf.b("GetPublisherRequest", "stSimpleGetFeedDetailReq = " + localstPublisherReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uor
 * JD-Core Version:    0.7.0.1
 */