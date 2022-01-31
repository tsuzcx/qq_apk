import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import mqq.os.MqqHandler;

public class vzb
  implements Runnable
{
  public vzb(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      this.a.a.a(this.a.a(), this.a);
      GameRoomChatPie.a(this.a).post(new vzc(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzb
 * JD-Core Version:    0.7.0.1
 */