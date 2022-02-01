import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;

public class vla
  extends vfo<stPublisherRsp>
{
  public vla()
  {
    super("Publisher", 10004);
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.a = localstPublisherReq;
    vmp.b("GetPublisherRequest", "stSimpleGetFeedDetailReq = " + localstPublisherReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vla
 * JD-Core Version:    0.7.0.1
 */