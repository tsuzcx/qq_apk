import UserGrowth.stFriendFeedReq;
import UserGrowth.stFriendFeedRsp;

public class unm
  extends ujr<stFriendFeedRsp>
{
  public unm(String paramString)
  {
    super("FriendFeed", 10006);
    stFriendFeedReq localstFriendFeedReq = new stFriendFeedReq();
    localstFriendFeedReq.attachInfo = paramString;
    this.a = localstFriendFeedReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unm
 * JD-Core Version:    0.7.0.1
 */