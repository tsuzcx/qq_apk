import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class uwb
  implements ActionSheet.OnButtonClickListener
{
  uwb(uvz paramuvz, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_Uvz.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_Uvz.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uvz.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Uvz.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uvz.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, null, true, this.jdField_a_of_type_Uvz.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, true, true, null, "from_internal");
    ReportController.b(this.jdField_a_of_type_Uvz.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005974", "0X8005974", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwb
 * JD-Core Version:    0.7.0.1
 */