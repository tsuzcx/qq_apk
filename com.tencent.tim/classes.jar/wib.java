import Wallet.AcsGetMsgListRsp;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

public class wib
  implements BusinessObserver
{
  public wib(ReminderListFragment paramReminderListFragment, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = true;
    if (paramInt == 2000)
    {
      if (!paramBoolean) {
        break label228;
      }
      paramBundle = (AcsGetMsgListRsp)paramBundle.getSerializable("rsp");
      if (paramBundle == null) {
        break label218;
      }
      ArrayList localArrayList1 = paramBundle.data_list;
      ArrayList localArrayList2 = new ArrayList();
      if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
        break label208;
      }
      ReminderListFragment.a(this.this$0, ReminderListFragment.a(this.this$0) + localArrayList1.size());
      if (ReminderListFragment.a(this.this$0) < paramBundle.total) {
        break label183;
      }
      ReminderListFragment.a(this.this$0, false);
      ReminderListFragment localReminderListFragment = this.this$0;
      if (this.bNt != 0) {
        break label203;
      }
      paramBoolean = bool;
      label116:
      ReminderListFragment.a(localReminderListFragment, localArrayList1, localArrayList2, paramBoolean);
      label126:
      if (QLog.isColorLevel()) {
        QLog.i(ReminderListFragment.el(), 2, "acsGetMsgListRsp: " + paramBundle + " ");
      }
    }
    for (;;)
    {
      ReminderListFragment.a(this.this$0).post(new ReminderListFragment.9.1(this));
      return;
      label183:
      ReminderListFragment.a(this.this$0, true);
      ReminderListFragment.b(this.this$0);
      break;
      label203:
      paramBoolean = false;
      break label116;
      label208:
      ReminderListFragment.b(this.this$0);
      break label126;
      label218:
      ReminderListFragment.b(this.this$0);
      break label126;
      label228:
      ReminderListFragment.a(this.this$0, acfp.m(2131713877));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wib
 * JD-Core Version:    0.7.0.1
 */