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

public class baq
  implements CompoundButton.OnCheckedChangeListener
{
  public baq(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == this.a.c.a())) && (!NetworkUtil.e(this.a.getActivity())))
    {
      this.a.a(2131363448, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        paramBoolean = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, paramCompoundButton, paramBoolean);
      }
    }
    label455:
    label625:
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
          ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_nearby", 0, i, String.valueOf(i), "", "", "");
          this.a.a(paramBoolean);
          this.a.app.b(paramBoolean, false);
          return;
        }
      }
      if (paramCompoundButton == this.a.b.a())
      {
        this.a.b.setContentDescription("允许附近的人赞我");
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.app.e(true, paramBoolean);
          return;
        }
      }
      if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
      {
        if (!NetworkUtil.e(this.a.app.getApplication().getApplicationContext()))
        {
          QQToast.a(this.a.getApplicationContext(), 2131363515, 1).a();
          this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
          paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
          if (this.a.app.f() == 1) {}
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
          ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
          this.a.a(this.a.getApplication().getResources().getString(2131364086));
          if (!paramBoolean) {
            break label455;
          }
        }
        for (i = 1;; i = 0)
        {
          this.a.app.g(i);
          return;
          i = 0;
          break;
        }
      }
      if (paramCompoundButton == this.a.e.a())
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
          if ((!NetworkUtil.e(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
            break;
          }
          this.a.e.setContentDescription("个性签名同步到说说");
          PermisionPrivacyActivity.a(this.a).a(paramBoolean);
          return;
        }
        paramCompoundButton = this.a;
        if (PermisionPrivacyActivity.a(this.a) != null)
        {
          i = 2131363448;
          PermisionPrivacyActivity.a(paramCompoundButton, i);
          paramCompoundButton = this.a;
          localObject = this.a.e.a();
          if (paramBoolean) {
            break label625;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
          return;
          i = 2131364036;
          break;
        }
      }
      if (paramCompoundButton == this.a.d.a())
      {
        this.a.d.setContentDescription("可通过系统通讯录发起QQ聊天");
        ((ContactSyncManager)this.a.app.getManager(37)).a(paramBoolean);
        return;
      }
    } while (paramCompoundButton != this.a.c.a());
    this.a.c.setContentDescription("向好友展示网络状态");
    PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean);
    this.a.app.d(paramBoolean, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     baq
 * JD-Core Version:    0.7.0.1
 */