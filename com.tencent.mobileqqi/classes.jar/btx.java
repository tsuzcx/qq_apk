import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class btx
  extends FriendListObserver
{
  public btx(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  protected void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null) {
      AddFriendLogicActivity.a(this.a, paramBundle.getInt("safety_flag"));
    }
    if ((!paramBoolean) || (AddFriendLogicActivity.a(this.a) == 0) || (paramInt != 147))
    {
      AddFriendLogicActivity.a(this.a);
      return;
    }
    AntiFraudConfigFileUtil.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "SecWarningCfg");
    try
    {
      AddFriendLogicActivity.a(this.a, DialogUtil.a(this.a, 230, "", "", this.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.a.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener));
      AddFriendLogicActivity.b(this.a);
      AddFriendLogicActivity.a(this.a).setOnDismissListener(this.a.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      AddFriendLogicActivity.a(this.a).show();
      ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_AntiFraud", this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "AlertDialog", "Display", 0, AddFriendLogicActivity.a(this.a), "", "", "", "");
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramBoolean)
    {
      int i = paramBundle.getInt("friend_setting");
      ArrayList localArrayList = paramBundle.getStringArrayList("user_question");
      paramBundle = Boolean.valueOf(paramBundle.getBoolean("contact_bothway"));
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendLogicActivity", 2, "onUpdateAddFriendSetting | setting = " + i + " | bothway = " + paramBundle);
      }
      if ((paramBundle.booleanValue()) && (i != 0))
      {
        if (this.a.u == 3006) {
          this.a.v = 2;
        }
        this.a.a(i, paramBundle.booleanValue(), localArrayList, AutoRemarkActivity.class);
        return;
      }
      switch (i)
      {
      default: 
        return;
      case 0: 
        this.a.a(i, paramBundle.booleanValue(), localArrayList, AutoRemarkActivity.class);
        return;
      case 1: 
      case 3: 
      case 4: 
        this.a.a(i, paramBundle.booleanValue(), localArrayList, AddFriendVerifyActivity.class);
        return;
      }
      paramBundle = this.a.getIntent().getStringExtra("nick_name");
      if ((paramBundle == null) || (paramBundle.length() == 0)) {
        this.a.getString(2131561597);
      }
      QQToast.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131563292, 0).b(this.a.d());
      this.a.finish();
      return;
    }
    QQToast.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131562782, 0).b(this.a.d());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     btx
 * JD-Core Version:    0.7.0.1
 */