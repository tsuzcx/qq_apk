import android.util.Log;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;

public class frm
  implements Runnable
{
  public frm(ContactSyncManager paramContactSyncManager) {}
  
  public void run()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ContactSync.Manager", 2, "onQQContactRefreshed | syncAllContacts exception = " + Log.getStackTraceString(localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     frm
 * JD-Core Version:    0.7.0.1
 */