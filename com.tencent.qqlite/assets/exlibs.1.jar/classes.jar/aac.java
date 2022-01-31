import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class aac
  implements View.OnClickListener
{
  public aac(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      return;
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      return;
    case 1: 
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true);
      return;
    case 2: 
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
      return;
    case 3: 
      if (ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
      }
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363113);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("param_return_addr") != null) {}
      for (boolean bool = true;; bool = false)
      {
        ChatActivityUtils.a(paramView, (SessionInfo)localObject, str, bool);
        return;
      }
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, 2131624119);
    paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364295));
    paramView.a(2131364294, 3);
    paramView.d(2131362794);
    paramView.a(new aad(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aac
 * JD-Core Version:    0.7.0.1
 */