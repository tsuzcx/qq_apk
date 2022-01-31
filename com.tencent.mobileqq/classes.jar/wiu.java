import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsDisAdapter;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wiu
  implements ActionSheet.OnButtonClickListener
{
  public wiu(ContactsDisAdapter paramContactsDisAdapter, boolean paramBoolean, DiscussionManager paramDiscussionManager, DiscussionInfo paramDiscussionInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a() >= 80))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.jdField_a_of_type_AndroidContentContext.getString(2131429829, new Object[] { String.valueOf(80) });
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.jdField_a_of_type_AndroidContentContext, 0, paramView, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.jdField_a_of_type_AndroidContentContext, 1, 2131432992, 0).a();
      }
      else
      {
        paramView = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView.e(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).longValue());
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808F", "0X800808F", 0, 0, "", "", "", "");
        }
        else
        {
          paramView.d(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).longValue());
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808E", "0X800808E", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wiu
 * JD-Core Version:    0.7.0.1
 */