import android.widget.ImageView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;

public class cia
  extends ContactBindObserver
{
  private cia(ContactListView paramContactListView) {}
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || (!NetworkUtil.e(this.a.getContext())))
    {
      this.a.i();
      this.a.g();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
    if (!paramBoolean1)
    {
      this.a.i();
      this.a.g();
      if (((i == 0) || (i == 4)) && (this.a.l == 0)) {
        this.a.a(2131363394, 3000L);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.a.b.setEnabled(true);
      if (i == 4)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cib(this));
          return;
        }
        this.a.i();
        this.a.jdField_a_of_type_Cid.sendEmptyMessageDelayed(1, 0L);
        return;
      }
    } while (!this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h());
    this.a.a(2131363392, 0L, false);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cia
 * JD-Core Version:    0.7.0.1
 */