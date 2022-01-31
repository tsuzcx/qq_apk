import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;

public class fnb
  implements AccountManagerCallback
{
  public fnb(ContactSyncManager paramContactSyncManager) {}
  
  public void run(AccountManagerFuture paramAccountManagerFuture)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "removeSyncAccount | is done = " + paramAccountManagerFuture.isDone());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fnb
 * JD-Core Version:    0.7.0.1
 */