import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class wtl
  extends ContactBindObserver
{
  public wtl(BindNumberActivity paramBindNumberActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    int i;
    BindNumberActivity localBindNumberActivity;
    if ((BindNumberActivity.a(this.a) == 10) || (BindNumberActivity.a(this.a) == 11) || (BindNumberActivity.a(this.a) == 15) || (BindNumberActivity.a(this.a) == 17))
    {
      this.a.rightViewText.setEnabled(true);
      this.a.b();
      if (!paramBoolean) {
        break label1314;
      }
      localObject = ContactUtils.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ReportController.b(this.a.app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      i = paramBundle.getInt("k_result");
      localBindNumberActivity = this.a;
      if (!paramBundle.getBoolean("k_buto_bind", false)) {
        break label317;
      }
      if (BindNumberActivity.a(this.a) != 10) {
        break label242;
      }
      paramBundle = new Intent(localBindNumberActivity, SplashActivity.class);
      paramBundle.putExtra("main_tab_id", 1);
      paramBundle.setFlags(603979776);
      localBindNumberActivity.startActivity(paramBundle);
      label182:
      this.a.setResult(-1);
      BindNumberActivity.a(this.a, 3);
    }
    for (;;)
    {
      ContactUtils.a();
      this.a.app.unRegistObserver(BindNumberActivity.b(this.a));
      BindNumberActivity.b(this.a, null);
      return;
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      break;
      label242:
      paramBundle = (PhoneContactManagerImp)this.a.app.getManager(10);
      localObject = paramBundle.a();
      if ((paramBundle.e()) || (localObject == null) || (((RespondQueryQQBindingStat)localObject).isStopFindMatch)) {
        break label182;
      }
      paramBundle = new Intent(this.a, PhoneMatchActivity.class);
      paramBundle.putExtra("key_from_contact_first", true);
      this.a.startActivity(paramBundle);
      break label182;
      label317:
      if ((i == 104) || (i == 0))
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("kSrouce", BindNumberActivity.a(this.a));
        paramBundle.putExtra("keyReqBindMode", 0);
        paramBundle.putExtra("k_number", this.a.jdField_b_of_type_JavaLangString);
        paramBundle.putExtra("k_country_code", this.a.jdField_a_of_type_JavaLangString);
        paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
        paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
        paramBundle.putExtra("cmd_param_is_from_uni", BindNumberActivity.a(this.a));
        paramBundle.putExtra("key_is_from_qav_multi_call", BindNumberActivity.b(this.a));
        paramBundle.putExtra("cmd_param_is_from_change_bind", BindNumberActivity.c(this.a));
      }
      for (;;)
      {
        if ((paramBundle == null) || (this.a.isFinishing())) {
          break label1312;
        }
        paramBundle.addFlags(536870912);
        paramBundle.addFlags(67108864);
        this.a.startActivityForResult(paramBundle, 2);
        break;
        if (i == 107)
        {
          if ((BindNumberActivity.a(this.a) == 10) || (BindNumberActivity.a(this.a) == 11) || (BindNumberActivity.a(this.a) == 15) || (BindNumberActivity.a(this.a) == 17))
          {
            localObject = paramBundle.getString("k_uin");
            paramBundle = (Bundle)localObject;
            if (((String)localObject).contains("***")) {
              paramBundle = ((String)localObject).replace("***", "");
            }
            if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {}
            for (localObject = this.a.jdField_b_of_type_JavaLangString;; localObject = this.a.jdField_a_of_type_JavaLangString + " " + this.a.jdField_b_of_type_JavaLangString)
            {
              paramBundle = DialogUtil.a(localBindNumberActivity, 230, "是否切换绑定QQ？", this.a.getResources().getString(2131428425, new Object[] { localObject, paramBundle, this.a.app.getCurrentAccountUin() }), "取消", "确定", new wtm(this), new wtn(this));
              if ((paramBundle == null) || (paramBundle.isShowing()) || (this.a.isFinishing())) {
                break;
              }
              paramBundle.show();
              return;
            }
          }
          localObject = new Intent(this.a, RebindActivity.class);
          ((Intent)localObject).putExtra("k_uin", paramBundle.getString("k_uin"));
          ((Intent)localObject).putExtra("k_number", this.a.jdField_b_of_type_JavaLangString);
          ((Intent)localObject).putExtra("k_country_code", this.a.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("kSrouce", BindNumberActivity.a(this.a));
          ((Intent)localObject).putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
          ((Intent)localObject).putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
          ((Intent)localObject).putExtra("cmd_param_is_from_uni", BindNumberActivity.a(this.a));
          ((Intent)localObject).putExtra("key_is_from_qav_multi_call", BindNumberActivity.b(this.a));
          ((Intent)localObject).putExtra("cmd_param_is_from_change_bind", BindNumberActivity.c(this.a));
          paramBundle = (Bundle)localObject;
        }
        else if (i == 106)
        {
          if (this.a.getIntent().getBooleanExtra("k_is_block", false)) {
            ReportController.b(this.a.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 1, 0, "", "", "", "");
          }
          this.a.setResult(-1);
          BindNumberActivity.a(this.a, 2);
          paramBundle = null;
        }
        else
        {
          if (i == 227)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
            if (this.a.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
              this.a.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localBindNumberActivity, 230, "绑定冲突", "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, "我知道了", new wto(this), null);
            }
            if ((this.a.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.a.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
              paramBundle = null;
            }
          }
          else if (i == 226)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8005B77", "0X8005B77", 0, 0, "", "", "", "");
            if (this.a.c == null) {
              this.a.c = DialogUtil.a(localBindNumberActivity, 230, "无法绑定", "当前要改绑QQ号未设置密码，无法绑定新的手机号码。请设置密码后重试。", null, "我知道了", new wtp(this), null);
            }
            if ((this.a.c != null) && (!this.a.c.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.c.show();
              paramBundle = null;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("IphoneTitleBarActivity", 2, "bind error " + i);
            }
            this.a.b(a(i));
          }
          paramBundle = null;
        }
      }
      label1312:
      continue;
      label1314:
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "onBindMobile failed");
      }
      this.a.b(2131434455);
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    if ((BindNumberActivity.a(this.a) == 10) || (BindNumberActivity.a(this.a) == 11) || (BindNumberActivity.a(this.a) == 15) || (BindNumberActivity.a(this.a) == 17))
    {
      this.a.b();
      if (!paramBoolean) {
        break label264;
      }
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("k_number", this.a.jdField_b_of_type_JavaLangString);
      paramBundle.putExtra("kBindType", 0);
      paramBundle.putExtra("k_country_code", this.a.jdField_a_of_type_JavaLangString);
      paramBundle.putExtra("cmd_param_is_from_uni", BindNumberActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_change_bind", BindNumberActivity.c(this.a));
      paramBundle.putExtra("kSrouce", BindNumberActivity.a(this.a));
      paramBundle.putExtra("keyReqBindMode", 1);
      paramBundle.addFlags(67108864);
      paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
      paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      paramBundle.putExtra("key_is_from_qav_multi_call", this.a.getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
      this.a.startActivityForResult(paramBundle, 2);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindNumberActivity.b(this.a));
      BindNumberActivity.b(this.a, null);
      return;
      label264:
      this.a.b(2131434455);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtl
 * JD-Core Version:    0.7.0.1
 */