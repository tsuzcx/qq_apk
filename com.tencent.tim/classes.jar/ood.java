import UserGrowth.stGetCollectionReq;
import UserGrowth.stGetCollectionRsp;

public class ood
  extends okw<stGetCollectionRsp>
{
  public ood(String paramString1, String paramString2, int paramInt)
  {
    super("GetCollection");
    stGetCollectionReq localstGetCollectionReq = new stGetCollectionReq();
    localstGetCollectionReq.cid = paramString1;
    localstGetCollectionReq.attachInfo = paramString2;
    localstGetCollectionReq.scene = paramInt;
    this.req = localstGetCollectionReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ood
 * JD-Core Version:    0.7.0.1
 */