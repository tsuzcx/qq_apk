import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class eoy
  implements ActionSheet.OnButtonClickListener
{
  public eoy(RecentTroopMenuOption paramRecentTroopMenuOption, int paramInt, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(RecentTroopMenuOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562449, 1500);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
      while ((paramInt != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(paramInt - 1), "", "");
        break;
        paramInt = 1;
        continue;
        paramInt = 4;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("RecentTroopMenuOption", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eoy
 * JD-Core Version:    0.7.0.1
 */