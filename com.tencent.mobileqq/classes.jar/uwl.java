import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;

public class uwl
  extends urg<stPublisherRsp>
{
  public uwl()
  {
    super("Publisher", 10004);
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.a = localstPublisherReq;
    uya.b("GetPublisherRequest", "stSimpleGetFeedDetailReq = " + localstPublisherReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwl
 * JD-Core Version:    0.7.0.1
 */