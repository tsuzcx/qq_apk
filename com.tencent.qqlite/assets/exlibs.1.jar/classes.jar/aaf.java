import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class aaf
  implements ActionSheet.OnButtonClickListener
{
  aaf(aae paramaae, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ReportController.b(this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
      paramView = (StrangerHandler)this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(26);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      paramView.b(localArrayList);
      if (this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0);
      }
      this.jdField_a_of_type_Aae.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aaf
 * JD-Core Version:    0.7.0.1
 */