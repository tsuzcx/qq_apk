import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;

public class wdz
  extends Handler
{
  public wdz(AddContactsActivity paramAddContactsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.b();
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    PADetailReportUtil.a().a(300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdz
 * JD-Core Version:    0.7.0.1
 */