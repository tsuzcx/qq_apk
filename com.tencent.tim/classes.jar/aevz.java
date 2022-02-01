import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager.1.1;
import com.tencent.qphone.base.util.QLog;

public class aevz
  extends akwl
{
  aevz(aevy paramaevy) {}
  
  protected void aI(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean + " | updateFlag = " + paramInt);
    }
    this.this$0.aii();
  }
  
  protected void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    ajdo localajdo = (ajdo)this.this$0.app.getManager(11);
    int i = localajdo.xy();
    String str1 = this.this$0.app.getCurrentAccountUin();
    String str2 = this.this$0.ui();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + aevy.kp(str2) + " | currentUin = " + aevy.kp(str1));
    }
    if (localajdo.Ur()) {
      if (TextUtils.isEmpty(str2)) {
        aevy.a(this.this$0).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        aevy.a(this.this$0).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        aevy.a(this.this$0).removeCallbacksAndMessages(null);
        aevy.a(this.this$0).sendEmptyMessage(2);
        aevy.a(this.this$0).sendEmptyMessage(1);
        return;
      } while ((i != 5) && (i != 1) && ((i != 6) || (localajdo.a() == null) || (localajdo.a().lastUsedFlag != 3L)) && ((i != 7) || (localajdo.a() == null) || (!localajdo.a().isStopFindMatch)));
      if ((i == 5) || (i == 1)) {
        ThreadManager.excute(new ContactSyncManager.1.1(this), 16, null, false);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.this$0.app.getCurrentAccountUin())));
    aevy.a(this.this$0).removeCallbacksAndMessages(null);
    aevy.a(this.this$0).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aevz
 * JD-Core Version:    0.7.0.1
 */