import android.view.View;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class elu
  implements ActionSheet.OnButtonClickListener
{
  public elu(SettingActivity2 paramSettingActivity2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt == 0)
    {
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b(2131562488);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.setResult(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     elu
 * JD-Core Version:    0.7.0.1
 */