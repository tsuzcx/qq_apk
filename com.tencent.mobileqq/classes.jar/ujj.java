import android.app.Activity;
import android.view.View;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class ujj
  implements ActionSheet.OnButtonClickListener
{
  public ujj(ActionSheet paramActionSheet, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt1, String paramString, int paramInt2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004863", "0X8004863", 0, 0, "", "", "", "");
      return;
      if ((this.b == 3) || (this.b == 4))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, true, null, null, 1, 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 3, 0, "", "", "", "");
        return;
      }
      if (this.b == 5)
      {
        PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, 2, 9);
        return;
      }
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, true, true, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004863", "0X8004863", 0, 0, "", "", "", "");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanelUtils", 2, "enterGAudioWithActionSheet");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujj
 * JD-Core Version:    0.7.0.1
 */