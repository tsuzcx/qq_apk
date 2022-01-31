import android.view.View;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wmi
  implements ActionSheet.OnButtonClickListener
{
  public wmi(ContactsTroopAdapter paramContactsTroopAdapter, boolean paramBoolean, TroopInfo paramTroopInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_AndroidContentContext, 1, 2131433009, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      paramView = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, 1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808D", "0X800808D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808C", "0X800808C", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmi
 * JD-Core Version:    0.7.0.1
 */