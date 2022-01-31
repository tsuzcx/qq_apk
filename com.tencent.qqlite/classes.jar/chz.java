import android.view.View;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class chz
  implements ActionSheet.OnButtonClickListener
{
  public chz(SettingActivity2 paramSettingActivity2, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b(2131363450);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b = new cia(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.a.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b(2131363381, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chz
 * JD-Core Version:    0.7.0.1
 */