import android.content.SharedPreferences;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;

public class zpd
  implements Runnable
{
  public zpd(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    PhoneContactManagerImp.a(this.a, this.a.a());
    PhoneContactManagerImp.a(this.a);
    this.a.e = this.a.a.getLong("key_contacts_switches", 0L);
    if (PhoneContactManagerImp.a(this.a) != null) {
      ContactSyncManager localContactSyncManager = (ContactSyncManager)PhoneContactManagerImp.a(this.a).getManager(40);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zpd
 * JD-Core Version:    0.7.0.1
 */