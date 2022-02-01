import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;

public class ont
  extends okw<stPublisherRsp>
{
  public ont()
  {
    super("Publisher");
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.req = localstPublisherReq;
    ooz.d("GetPublisherRequest", "stSimpleGetFeedDetailReq = " + localstPublisherReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ont
 * JD-Core Version:    0.7.0.1
 */