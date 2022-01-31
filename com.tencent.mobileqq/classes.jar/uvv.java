import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class uvv
  implements ActionSheet.OnButtonClickListener
{
  uvv(uvt paramuvt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    String str;
    if (this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      str = this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      paramView = null;
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_Uvt.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, str, true, this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, true, true, null, null);
      str = ChatActivityUtils.a(this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      ReportController.b(this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "12", paramView, "", "");
      ReportController.b(this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005974", "0X8005974", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Uvt.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvv
 * JD-Core Version:    0.7.0.1
 */