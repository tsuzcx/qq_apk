import UserGrowth.stGetCollectionReq;
import UserGrowth.stGetCollectionRsp;

public class uob
  extends ujr<stGetCollectionRsp>
{
  public uob(String paramString1, String paramString2, int paramInt)
  {
    super("GetCollection", paramInt);
    stGetCollectionReq localstGetCollectionReq = new stGetCollectionReq();
    localstGetCollectionReq.cid = paramString1;
    localstGetCollectionReq.attachInfo = paramString2;
    localstGetCollectionReq.scene = paramInt;
    this.a = localstGetCollectionReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uob
 * JD-Core Version:    0.7.0.1
 */