import Wallet.AcsPullMsgRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import java.util.ArrayList;

public class wia
  implements wii.b
{
  public wia(ReminderListFragment paramReminderListFragment) {}
  
  public void z(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null)
      {
        paramBundle = paramBundle.msgs;
        if ((paramBundle != null) && (!paramBundle.isEmpty()))
        {
          ArrayList localArrayList = new ArrayList(paramBundle.size());
          ReminderListFragment.a(this.this$0, paramBundle, localArrayList, true);
          return;
        }
        ReminderListFragment.b(this.this$0);
        return;
      }
      ReminderListFragment.b(this.this$0);
      return;
    }
    ReminderListFragment.a(this.this$0, acfp.m(2131713869));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wia
 * JD-Core Version:    0.7.0.1
 */