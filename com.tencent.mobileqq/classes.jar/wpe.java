import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class wpe
  extends FriendListObserver
{
  public wpe(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new wpf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpe
 * JD-Core Version:    0.7.0.1
 */