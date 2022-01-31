import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouchManager;

public class wsl
  implements Runnable
{
  public wsl(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.a.app.getManager(35);
    this.a.a = localRedTouchManager.a("100100.100125.100127");
    this.a.runOnUiThread(new wsm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsl
 * JD-Core Version:    0.7.0.1
 */