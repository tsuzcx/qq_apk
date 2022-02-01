import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AutoLoginHelper.1;
import com.tencent.mobileqq.activity.AutoLoginHelper.5;
import com.tencent.mobileqq.activity.AutoLoginHelper.6;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class uhv
{
  akwl jdField_a_of_type_Akwl = new uhx(this);
  private aqwf jdField_a_of_type_Aqwf;
  private RegisterNewBaseActivity jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity;
  public String aLv;
  private String aLw;
  public boolean aRQ;
  public boolean aRR = true;
  private boolean aRS;
  private boolean aRT;
  private boolean aRU;
  private boolean aRV = true;
  private boolean aRW = true;
  private boolean aRX;
  private boolean aRY;
  private boolean aRZ;
  public boolean aSa;
  private QQAppInterface app;
  private byte[] bW;
  private byte[] bX;
  private AccountObserver jdField_c_of_type_MqqObserverAccountObserver = new uhy(this);
  WtloginObserver jdField_c_of_type_MqqObserverWtloginObserver = new uhw(this);
  public String countryCode = "86";
  public boolean isLogining;
  private Intent mIntent;
  private String mUin;
  public String phoneNum;
  private arhz w;
  
  public uhv(QQAppInterface paramQQAppInterface, RegisterNewBaseActivity paramRegisterNewBaseActivity, Intent paramIntent)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity = paramRegisterNewBaseActivity;
    this.mIntent = paramIntent;
  }
  
  private void bGA()
  {
    akwp.a().Nq(true);
    akwp.a().b(this.app, this.countryCode, this.phoneNum, this.jdField_c_of_type_MqqObserverWtloginObserver);
  }
  
  private void bwV()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new AutoLoginHelper.6(this));
  }
  
  private void showProgressDialog()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new AutoLoginHelper.5(this));
  }
  
  private void startMainActivity()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null) {}
    Object localObject;
    do
    {
      return;
      this.aSa = true;
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("afterRegAndAutoLogin", true);
      ((Intent)localObject).addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
      localObject = this.app.getHandler(LoginActivity.class);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(20140325);
  }
  
  public void aO(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.mUin))) {
      return;
    }
    this.aRX = paramBoolean;
    if ((!this.aRX) && (this.aRY))
    {
      bwV();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.J(2131717084, 0);
    }
    for (;;)
    {
      this.aRY = false;
      this.aRZ = false;
      return;
      if ((this.aRX) && (this.aRY)) {
        if (this.aRT) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime().login(this.mUin, this.bX, this.jdField_c_of_type_MqqObserverAccountObserver);
        } else {
          akwn.a(this.app, this.bW, this.mUin);
        }
      }
    }
  }
  
  public void bGB()
  {
    if (!this.aRV) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
      }
    }
    do
    {
      return;
      if (this.aRU) {
        anot.c(this.app, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
      }
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.J(2131693404, 0);
    return;
    this.isLogining = true;
    this.aSa = false;
    if ((this.aRW) && (!this.aRX))
    {
      if (!this.aRZ)
      {
        this.aRZ = true;
        if (this.jdField_a_of_type_Aqwf == null) {
          this.jdField_a_of_type_Aqwf = new aqwf(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, null);
        }
        this.jdField_a_of_type_Aqwf.a(this.mUin, new uhv.a(this));
      }
      this.aRY = true;
      showProgressDialog();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    showProgressDialog();
    if (QLog.isColorLevel())
    {
      if (this.bW == null) {
        break label274;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.bW));
      }
    }
    while (this.aRT)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime().login(this.mUin, this.bX, this.jdField_c_of_type_MqqObserverAccountObserver);
      return;
      label274:
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "swz mSign = null");
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.mUin, com.tencent.qphone.base.util.MD5.toMD5(this.bW) }));
    }
    akwn.a(this.app, this.bW, this.mUin);
  }
  
  public void bGz()
  {
    MqqHandler localMqqHandler = this.app.getHandler(RegisterChooseLoginActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(105);
    }
    localMqqHandler = this.app.getHandler(RegisterPhoneNumActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(103);
    }
    localMqqHandler = this.app.getHandler(RegisterPersonalInfoActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(109);
    }
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterSendUpSms))
    {
      localMqqHandler = this.app.getHandler(RegisterSendUpSms.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(107);
      }
    }
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterVerifyCodeActivity))
    {
      localMqqHandler = this.app.getHandler(RegisterVerifyCodeActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(106);
      }
    }
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterByNicknameAndPwdActivity))
    {
      localMqqHandler = this.app.getHandler(RegisterByNicknameAndPwdActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(110);
      }
    }
  }
  
  public Intent getIntent()
  {
    return this.mIntent;
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onAccountChanged success");
    }
    if (this.aRT)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
      if (this.aRU)
      {
        this.app = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime());
        LoginActivity.o(this.app, this.app.getAccount());
      }
      showProgressDialog();
      startMainActivity();
    }
    do
    {
      return;
      if (akwp.a().asQ()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoLoginHelper", 2, "onAccountChanged not phonenum login");
    return;
    this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
    this.app = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_Akwl);
    if (this.aRS)
    {
      this.app.execute(new AutoLoginHelper.1(this));
      QQToast.a(BaseApplicationImpl.sApplication, acfp.m(2131702966), 0).show();
    }
    showProgressDialog();
    LoginActivity.o(this.app, this.app.getAccount());
    startMainActivity();
  }
  
  public void onCreate()
  {
    if (QLog.isDevelopLevel()) {
      aqwc.h(getClass().getSimpleName(), getIntent());
    }
    this.aRU = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    if (this.aRU) {
      this.aLw = getIntent().getStringExtra("key_register_secret_phone");
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.aLv = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.aRQ = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.aRR = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.mUin = getIntent().getStringExtra("uin");
    this.bW = getIntent().getByteArrayExtra("key_register_sign");
    Locale localLocale;
    String str2;
    String str3;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      str2 = this.mUin;
      str3 = com.tencent.qphone.base.util.MD5.toMD5(this.bW);
      if (this.aLv != null) {
        break label323;
      }
    }
    label323:
    for (String str1 = "";; str1 = this.aLv)
    {
      QLog.d("AutoLoginHelper", 4, String.format(localLocale, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { str2, str3, str1 }));
      str1 = getIntent().getStringExtra("key_register_password");
      if (str1 != null) {
        this.bX = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte(str1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "onCreate ,pwd = " + str1 + ",mPassByte = " + this.bX);
      }
      this.aRT = getIntent().getBooleanExtra("key_register_unbind", false);
      if (this.app != null) {
        break;
      }
      QLog.d("AutoLoginHelper", 2, "onCreate app is null");
      return;
    }
    this.app.registObserver(this.jdField_a_of_type_Akwl);
    this.aRV = getIntent().getBooleanExtra("key_register_result", true);
    this.aRW = getIntent().getBooleanExtra("key_register_is_lh", false);
    if ((this.aRV) && (this.aRW))
    {
      this.aRY = false;
      this.aRZ = true;
      this.jdField_a_of_type_Aqwf = new aqwf(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, null);
      this.jdField_a_of_type_Aqwf.a(this.mUin, new uhv.a(this));
    }
    this.aSa = false;
    bGz();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onDestroy");
    }
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.gV();
    bwV();
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoLoginHelper", 2, "onResume， isStartingMain=" + this.aSa);
    }
    if (!this.aSa) {
      bwV();
    }
  }
  
  static class a
    implements aqwp.a
  {
    private final WeakReference<uhv> mRef;
    
    a(uhv paramuhv)
    {
      this.mRef = new WeakReference(paramuhv);
    }
    
    public void aP(String paramString, boolean paramBoolean)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        if (QLog.isColorLevel()) {
          QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
        }
      }
      uhv localuhv;
      do
      {
        return;
        localuhv = (uhv)this.mRef.get();
      } while (localuhv == null);
      localuhv.aO(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhv
 * JD-Core Version:    0.7.0.1
 */