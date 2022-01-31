import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class czg
  implements CompoundButton.OnCheckedChangeListener
{
  public czg(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a))) && (!NetworkUtil.e(this.a.a())))
    {
      this.a.a(2131562445, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        paramBoolean = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, paramCompoundButton, paramBoolean);
      }
    }
    label462:
    do
    {
      return;
      paramBoolean = false;
      break;
      int i;
      if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("对附近的人可见");
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Visible_nearby", 0, i, String.valueOf(i), "", "", "");
          this.a.a(paramBoolean);
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(paramBoolean, false);
          return;
        }
      }
      if (paramCompoundButton == this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("允许附近的人赞我");
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(true, paramBoolean);
          return;
        }
      }
      if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
      {
        if (!NetworkUtil.e(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
        {
          QQToast.a(this.a.getApplicationContext(), 2131562449, 1).a();
          this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
          paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
          if (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f() == 1) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramCompoundButton.setChecked(paramBoolean);
            this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
            return;
          }
        }
        if (paramBoolean)
        {
          i = 1;
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
          this.a.a(this.a.getApplication().getResources().getString(2131562662));
          if (!paramBoolean) {
            break label462;
          }
        }
        for (i = 1;; i = 0)
        {
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(i);
          return;
          i = 0;
          break;
        }
      }
      if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(paramBoolean, false);
          this.a.b(paramBoolean);
          return;
        }
      }
      if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false, paramBoolean);
          return;
        }
      }
      if (paramCompoundButton == this.a.d.a())
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
          if ((!NetworkUtil.e(this.a.a())) || (PermisionPrivacyActivity.a(this.a) == null)) {
            break;
          }
          this.a.d.setContentDescription("个性签名同步到说说");
          PermisionPrivacyActivity.a(this.a).a(paramBoolean);
          return;
        }
        paramCompoundButton = this.a;
        if (PermisionPrivacyActivity.a(this.a) != null)
        {
          i = 2131562445;
          PermisionPrivacyActivity.a(paramCompoundButton, i);
          paramCompoundButton = this.a;
          localObject = this.a.d.a();
          if (paramBoolean) {
            break label774;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
          return;
          i = 2131562080;
          break;
        }
      }
    } while (paramCompoundButton != this.a.c.a());
    label774:
    this.a.c.setContentDescription("可通过系统通讯录发起QQ聊天");
    ((ContactSyncManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39)).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czg
 * JD-Core Version:    0.7.0.1
 */