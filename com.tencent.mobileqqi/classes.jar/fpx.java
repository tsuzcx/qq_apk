import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class fpx
  implements DialogInterface.OnDismissListener
{
  public fpx(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.c == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.a.jdField_b_of_type_Int);
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("年龄" + ConditionSearchFriendActivity.jdField_b_of_type_ArrayOfJavaLangString[this.a.jdField_b_of_type_Int] + ", 触摸两次选择");
      ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.a.jdField_b_of_type_Int + "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("性别" + ConditionSearchFriendActivity.jdField_a_of_type_ArrayOfJavaLangString[this.a.jdField_a_of_type_Int] + ", 触摸两次选择");
    ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, this.a.jdField_a_of_type_Int + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpx
 * JD-Core Version:    0.7.0.1
 */