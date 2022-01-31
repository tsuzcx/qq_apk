import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class wkp
  extends ContactBindObserver
{
  private wkp(PhoneContactFragment paramPhoneContactFragment) {}
  
  protected void a(boolean paramBoolean)
  {
    this.a.c();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "onQueryBindState " + paramBoolean1 + " " + paramBoolean2);
    }
    if (PhoneContactFragment.b(this.a))
    {
      if (this.a.a != null) {
        this.a.a.a(4, paramBoolean1, null);
      }
      if (paramBoolean1) {
        this.a.c();
      }
      PhoneContactFragment.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkp
 * JD-Core Version:    0.7.0.1
 */