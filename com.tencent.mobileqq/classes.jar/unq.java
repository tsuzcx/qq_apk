import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;

public class unq
  extends ujr<stPublisherRsp>
{
  public unq()
  {
    super("Publisher", 10004);
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.a = localstPublisherReq;
    upe.b("GetPublisherRequest", "stSimpleGetFeedDetailReq = " + localstPublisherReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unq
 * JD-Core Version:    0.7.0.1
 */