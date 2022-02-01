import UserGrowth.stQQGroupDetailReq;
import UserGrowth.stQQGroupDetailRsp;

public class uws
  extends urg<stQQGroupDetailRsp>
{
  public uws(String paramString1, String paramString2)
  {
    super("QQGroupDetail", 10007);
    stQQGroupDetailReq localstQQGroupDetailReq = new stQQGroupDetailReq();
    localstQQGroupDetailReq.groupId = paramString1;
    localstQQGroupDetailReq.posterPersonId = paramString2;
    this.a = localstQQGroupDetailReq;
    this.f = 15000L;
    uya.d("QQGroupDetailRequest", "QQGroupDetailRequest  = " + localstQQGroupDetailReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uws
 * JD-Core Version:    0.7.0.1
 */