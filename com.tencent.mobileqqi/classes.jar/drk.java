import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class drk
  implements ActionSheet.OnButtonClickListener
{
  public drk(SubAccountMessageActivity paramSubAccountMessageActivity, ActionSheet paramActionSheet, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        paramView = "";
        if (SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity) != null) {
          paramView = SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b, "CliOper", "", paramView, "Bind_account", "Clean_msg_tipslist", 0, 0, "", "", "", "");
      } while (SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity) == null);
      SubAccountDataControll.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b, SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin);
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b.a().c(AppConstants.O, 7000);
      if (SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity)) {
        ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b.a(0)).a().a(SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.getString(2131561834));
      SubAccountMessageActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity);
      return;
    } while ((!this.b) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.f()) || ((SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity) != null) && (TextUtils.isEmpty(SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin))));
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.d();
    if (SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity))
    {
      ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b.a(0)).a().a(SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin, "sub.account.unbind");
      return;
    }
    SubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b, SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     drk
 * JD-Core Version:    0.7.0.1
 */