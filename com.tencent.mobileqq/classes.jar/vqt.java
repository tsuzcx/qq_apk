import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import mqq.os.MqqHandler;

public class vqt
  implements Runnable
{
  public vqt(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      this.a.a.a(this.a.a(), this.a);
      GameRoomChatPie.a(this.a).post(new vqu(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqt
 * JD-Core Version:    0.7.0.1
 */