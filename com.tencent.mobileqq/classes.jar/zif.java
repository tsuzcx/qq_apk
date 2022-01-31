import android.content.SharedPreferences;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;

public class zif
  implements Runnable
{
  public zif(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    PhoneContactManagerImp.a(this.a, this.a.a());
    PhoneContactManagerImp.a(this.a);
    this.a.e = this.a.a.getLong("key_contacts_switches", 0L);
    ContactSyncManager localContactSyncManager = (ContactSyncManager)PhoneContactManagerImp.a(this.a).getManager(40);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zif
 * JD-Core Version:    0.7.0.1
 */