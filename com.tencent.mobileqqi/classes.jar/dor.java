import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class dor
  implements CompoundButton.OnCheckedChangeListener
{
  public dor(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130837880);
      if (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() == 0)
      {
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(1);
        label64:
        paramCompoundButton = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!paramBoolean) {
          break label153;
        }
      }
    }
    for (;;)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      return;
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      break;
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130837875);
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(0);
      break label64;
      label153:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dor
 * JD-Core Version:    0.7.0.1
 */