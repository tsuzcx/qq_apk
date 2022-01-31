import UserGrowth.stFollowReq;
import UserGrowth.stFollowRsp;

public class tkc
  extends thb<stFollowRsp>
{
  public tkc(String paramString, int paramInt)
  {
    super("Follow");
    this.a = new stFollowReq(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkc
 * JD-Core Version:    0.7.0.1
 */