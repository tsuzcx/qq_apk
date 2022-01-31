import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;

public class vym
  implements Runnable
{
  public vym(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    if (FriendChatPie.a(this.a) != null)
    {
      FriendChatPie.a(this.a).b(1);
      FriendChatPie.a(this.a).b(2);
      FriendChatPie.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vym
 * JD-Core Version:    0.7.0.1
 */