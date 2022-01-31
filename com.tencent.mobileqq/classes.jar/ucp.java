import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;

public class ucp
  extends FriendListObserver
{
  public ucp(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    ThreadManager.post(new ucq(this, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucp
 * JD-Core Version:    0.7.0.1
 */