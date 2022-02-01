import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class alub
  extends alty
{
  public uhv a;
  public boolean aRU = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_quick_register", false);
  private Intent al;
  private byte[] bW;
  private String bYs = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getStringExtra("key_register_fail_paid_lh");
  private String bYt;
  private String bYu;
  private String bYv;
  public boolean bac = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_send_sms", false);
  public boolean czr;
  public boolean czs = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_is_lh", false);
  public boolean czt;
  private AccountObserver d = new aluc(this);
  public String mSmsCode = "";
  private String mUin;
  
  public alub(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    if (this.mSmsCode == null) {
      this.mSmsCode = "";
    }
  }
  
  private void d(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "autoLogin, forceLogin=" + paramBoolean);
    }
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null) || (paramIntent == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterWithNickAndPwd", 2, "autoLogin, data is null");
      }
    }
    do
    {
      return;
      if (this.al == null) {
        this.al = paramIntent;
      }
      if (this.jdField_a_of_type_Uhv != null)
      {
        this.jdField_a_of_type_Uhv.onDestroy();
        this.jdField_a_of_type_Uhv = null;
      }
      this.jdField_a_of_type_Uhv = new uhv(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, this.al);
      this.jdField_a_of_type_Uhv.onCreate();
      this.jdField_a_of_type_Uhv.bGB();
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterByNicknameAndPwdActivity));
    ((RegisterByNicknameAndPwdActivity)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity).bVa();
  }
  
  public void bRp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "go2next, onRegisterCommitPassResp, mAutoLogin = " + this.czr + ", mIsfromLH=" + this.czs);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterQQNumberActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    localIntent.putExtra("uin", this.mUin);
    localIntent.putExtra("key_register_sign", this.bW);
    localIntent.putExtra("key_register_password", this.bYv);
    localIntent.putExtra("key_register_unbind", true);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aRQ);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aRR);
    localIntent.putExtra("key_register_from_send_sms", this.bac);
    localIntent.putExtra("key_register_chose_bind_phone", false);
    if ((this.czr) && (!this.czs))
    {
      d(localIntent, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
  }
  
  public void dI(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("key_register_nick");
    String str2 = paramIntent.getStringExtra("key_register_password");
    this.mSmsCode = paramIntent.getStringExtra("key_register_smscode");
    this.czr = paramIntent.getBooleanExtra("key_register_autologin", false);
    if (this.mSmsCode == null) {
      this.mSmsCode = "";
    }
    this.bYs = paramIntent.getStringExtra("key_register_fail_paid_lh");
    this.czt = paramIntent.getBooleanExtra("key_register_phonenum_bindnewqq", true);
    doAction(str1, str2);
  }
  
  public void dJL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "reAutoLogin");
    }
    d(this.al, true);
  }
  
  public void doAction(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RegisterWithNickAndPwd", 4, String.format(Locale.getDefault(), "doAction smsCode: %s, unBindLH:%s, nick: %s, pas: %s, isLH:%b, autoLogin: %b, isPhoneNumBindNewQQ:%b", new Object[] { this.mSmsCode, this.bYs, paramString1, arwu.toMD5(paramString2), Boolean.valueOf(this.czs), Boolean.valueOf(this.czr), Boolean.valueOf(this.czt) }));
    }
    this.bYu = paramString1;
    this.bYv = paramString2;
    AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
    try
    {
      if (this.aRU) {
        localAccountManager.getQuickRegisterAccount(this.app.getCurrentAccountUin(), this.bYu, this.bYv, AppSetting.getAppId(), "3.4.4", this.d);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.Bv(2131717031);
        return;
        akwp.a().b(this.app, true);
        localAccountManager.sendRegisterBySetPass(paramString2, paramString1, this.mSmsCode, this.bYs, this.czt, "3.4.4", aqnu.getToken(), this.d);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void j(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RegisterWithNickAndPwd", 4, String.format(Locale.getDefault(), "doAction autoLogin: %b, isPhoneNumBindNewQQ:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    this.czr = paramBoolean1;
    this.czt = paramBoolean2;
    doAction(paramString1, paramString2);
  }
  
  public void onAccountChanged()
  {
    if (this.jdField_a_of_type_Uhv != null) {
      this.jdField_a_of_type_Uhv.onAccountChanged();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Uhv != null)
    {
      this.jdField_a_of_type_Uhv.onDestroy();
      this.jdField_a_of_type_Uhv = null;
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Uhv != null) {
      this.jdField_a_of_type_Uhv.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Uhv != null) {
      this.jdField_a_of_type_Uhv.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alub
 * JD-Core Version:    0.7.0.1
 */