import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class fmx
  extends ContactBindObserver
{
  public fmx(ContactSyncManager paramContactSyncManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (PhoneContactManager)this.a.a.getManager(10);
    int i = ((PhoneContactManager)localObject).b();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i);
    }
    String str;
    if (((PhoneContactManager)localObject).h())
    {
      localObject = this.a.a.a();
      str = this.a.a();
      if (!TextUtils.isEmpty(str)) {}
    }
    do
    {
      do
      {
        ContactSyncManager.a(this.a);
        do
        {
          return;
        } while (((String)localObject).equals(str));
        ContactSyncManager.a(this.a);
        ContactSyncManager.a(this.a);
        return;
      } while ((i != 2) && (i != 1));
      ContactSyncManager.b(this.a);
      localObject = this.a.a();
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.a.a.a())));
    ContactSyncManager.a(this.a);
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean1 + " | hasUpdate = " + paramBoolean2);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fmx
 * JD-Core Version:    0.7.0.1
 */