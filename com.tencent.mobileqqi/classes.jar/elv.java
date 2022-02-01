import android.view.View;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class elv
  implements ActionSheet.OnButtonClickListener
{
  public elv(SettingActivity2 paramSettingActivity2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b(2131562488);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new elw(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.a.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.a(2131562875, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     elv
 * JD-Core Version:    0.7.0.1
 */