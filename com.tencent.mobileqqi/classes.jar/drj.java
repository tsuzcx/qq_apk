import android.view.View;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class drj
  implements ActionSheet.OnButtonClickListener
{
  public drj(SubAccountMessageActivity paramSubAccountMessageActivity, ActionSheet paramActionSheet, boolean paramBoolean) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      paramView = SubAccountAssistantImpl.a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b;
      if (!this.jdField_a_of_type_Boolean)
      {
        paramView.a(localQQAppInterface, bool);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b;
        if (this.jdField_a_of_type_Boolean) {
          break label112;
        }
      }
      for (paramView = "1";; paramView = "0")
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Bind_account", "Top_bind_account", 0, 0, paramView, "", "", "");
        return;
        bool = false;
        break;
      }
    case 1: 
      label112:
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, true, false);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     drj
 * JD-Core Version:    0.7.0.1
 */