import android.view.View;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class cei
  extends ContactBindObserver
{
  public cei(Contacts paramContacts) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
    if (!((PhoneContactManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).f())
    {
      if (this.a.b != null) {
        this.a.b.setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidViewView != null) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cei
 * JD-Core Version:    0.7.0.1
 */