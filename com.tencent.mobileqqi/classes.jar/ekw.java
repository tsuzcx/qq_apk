import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ekw
  extends ContactBindObserver
{
  private ekw(ContactListView paramContactListView) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
    if (!paramBoolean1)
    {
      this.a.i();
      this.a.g();
      if (((i == 0) || (i == 4)) && (this.a.j == 0)) {
        this.a.a(2131562782, 3000L);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      if (i == 4)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new ekx(this));
          return;
        }
        this.a.i();
        this.a.jdField_a_of_type_Ekz.sendEmptyMessageDelayed(1, 0L);
        return;
      }
    } while (!this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i());
    this.a.a(2131562875, 0L, false);
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((!paramBoolean) || (!NetworkUtil.e(this.a.getContext())))
    {
      this.a.i();
      this.a.g();
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.i();
      ContactListView.a(this.a, true);
      if (!paramBoolean2) {
        this.a.g();
      }
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ekw
 * JD-Core Version:    0.7.0.1
 */