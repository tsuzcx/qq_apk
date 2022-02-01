import UserGrowth.stFollowReq;
import UserGrowth.stFollowRsp;

public class onn
  extends okw<stFollowRsp>
{
  public onn(String paramString, int paramInt)
  {
    super("Follow");
    this.req = new stFollowReq(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onn
 * JD-Core Version:    0.7.0.1
 */