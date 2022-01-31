import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.statistics.ReportController;

public class wga
  implements View.OnClickListener
{
  public wga(TroopView paramTroopView) {}
  
  public void onClick(View paramView)
  {
    if (TroopView.a(this.a) != null) {
      TroopView.a(this.a).c();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */