import UserGrowth.stFollowReq;
import UserGrowth.stFollowRsp;

public class uwf
  extends urg<stFollowRsp>
{
  public uwf(String paramString, int paramInt)
  {
    super("Follow");
    this.a = new stFollowReq(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwf
 * JD-Core Version:    0.7.0.1
 */