import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class tkp
  implements Runnable
{
  public int a;
  
  public tkp(QQSettingCleanActivity paramQQSettingCleanActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.getString(2131435412) + "(" + QQSettingCleanActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_a_of_type_Long) + ")");
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.getString(2131435421) + QQSettingCleanActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_c_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_f_of_type_Long));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.getString(2131435419));
      return;
    case 3: 
      FMToastUtil.a(2131434613);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.getString(2131435418));
      return;
    }
    TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_c_of_type_Long <= 0L)
    {
      str = "0M";
      localTextView.setText(str);
      localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_c_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_d_of_type_Long > 0L) {
        break label471;
      }
    }
    label471:
    for (String str = "0M";; str = QQSettingCleanActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_d_of_type_Long))
    {
      localTextView.setText(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_d_of_type_AndroidWidgetTextView.setText(QQSettingCleanActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_c_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_e_of_type_Long));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_e_of_type_AndroidWidgetTextView.setText(QQSettingCleanActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_e_of_type_Long));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838491);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_b_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.getResources().getColor(2131494236));
      return;
      str = QQSettingCleanActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity.jdField_c_of_type_Long);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkp
 * JD-Core Version:    0.7.0.1
 */