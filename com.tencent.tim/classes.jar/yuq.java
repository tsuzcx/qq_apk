import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class yuq
  extends akwm
{
  public yuq(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  protected void AT(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onQueryShowBindPhonePage result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      paramBoolean = PhoneContactManagerImp.b(this.this$0, PhoneContactManagerImp.g(this.this$0));
      PhoneContactManagerImp.d(this.this$0, paramBoolean);
    }
  }
  
  protected void AU(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onSetShowBindPhonePageResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yuq
 * JD-Core Version:    0.7.0.1
 */