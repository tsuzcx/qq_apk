import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;

public class tkh
  extends thb<stPublisherRsp>
{
  public tkh()
  {
    super("Publisher");
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.a = localstPublisherReq;
    tlo.b("GetPublisherRequest", "stSimpleGetFeedDetailReq = " + localstPublisherReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkh
 * JD-Core Version:    0.7.0.1
 */