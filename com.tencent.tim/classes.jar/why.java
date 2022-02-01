import Wallet.AcsMsg;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1;
import mqq.observer.BusinessObserver;

public class why
  implements BusinessObserver
{
  public why(ReminderListFragment paramReminderListFragment, AcsMsg paramAcsMsg, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ReminderListFragment.a(this.this$0).post(new ReminderListFragment.5.1(this, paramInt, paramBoolean, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     why
 * JD-Core Version:    0.7.0.1
 */