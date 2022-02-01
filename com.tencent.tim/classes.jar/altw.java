import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.register.QueryAccount.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class altw
  extends alty
{
  private Intent O;
  private altz a;
  private String aPv;
  public String bYo;
  public String bYp;
  public String bYq;
  private AccountObserver d = new altx(this);
  public int dxA;
  private HashMap<String, altw.a> mE = new HashMap();
  
  public altw(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    this.app.registObserver(this.d);
  }
  
  private void OV(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    localIntent.putExtra("key_register_prompt_info", paramString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aRQ);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aRR);
    localIntent.putExtra("key_register_binded_qq", this.aPv);
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131712620));
    localIntent.putExtra("key_register_from", 7);
    dH(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(localIntent);
  }
  
  private void am(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aRQ);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aRR);
    localIntent.putExtra("key_register_binded_qq", this.aPv);
    localIntent.putExtra("key_register_left_time", paramInt);
    localIntent.putExtra("key_register_exit_time", paramLong);
    localIntent.putExtra("register_verify_code_start_time", System.currentTimeMillis());
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131712623));
    localIntent.putExtra("key_register_from", 7);
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, "go2next countryCode=" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + ", phoneNum=" + aqje.encrypt(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum) + ", leftTime=" + paramInt + ", exitTime=" + paramLong);
    }
    dH(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivityForResult(localIntent, 2);
  }
  
  private boolean bt(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return TextUtils.isEmpty(paramString2);
    }
    return paramString1.equals(paramString2);
  }
  
  private void dJK()
  {
    if ((this.O != null) && (this.O.getBooleanExtra("key_register_from_fail_pay_lh", false)))
    {
      if (this.jdField_a_of_type_Altz == null) {
        this.jdField_a_of_type_Altz = new altz(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity);
      }
      this.jdField_a_of_type_Altz.dI(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.gV();
    RegisterPersonalInfoActivity.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, "", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aRQ, false, null, 7);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
  }
  
  private void wp(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new QueryAccount.1(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void OU(String paramString)
  {
    if (!Qd()) {
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("wifi_mac", this.bYo);
      localBundle.putString("os_language", this.bYp);
      localBundle.putInt("qq_language", this.dxA);
      localBundle.putString("gps_location", this.bYq);
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv, Long.valueOf(AppSetting.getAppId()), "3.4.4", localBundle, null);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean Qd()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.oX();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum = hh(str);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.J(2131717079, 1);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.oY();
    return true;
  }
  
  public void bRq()
  {
    if (!Qd()) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum;
    if (this.mE.containsKey(str))
    {
      Object localObject = this.mE.get(str);
      if ((localObject != null) && ((localObject instanceof altw.a)))
      {
        altw.a locala = (altw.a)localObject;
        if ((locala.dxB > 0) && (locala.tT > 0L) && (bt(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv, locala.aLv)))
        {
          long l = System.currentTimeMillis() - locala.tT;
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("startQueryAccount countryCode=").append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode).append(", phoneNum=").append(aqje.encrypt(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum)).append(", leftTime=").append(locala.dxB).append(", exitTime=").append(locala.tT).append(", interval=").append(l).append(", inviteCode=");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv != null) {
              break label281;
            }
          }
          label281:
          for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.aLv)
          {
            QLog.d("QueryAccount", 2, (String)localObject);
            if ((l <= 0L) || (l >= locala.dxB * 1000L)) {
              break;
            }
            am(locala.dxB, locala.tT);
            return;
          }
        }
      }
      this.mE.remove(str);
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.J(2131693404, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "startQueryAccount countryCode=" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + " phoneNum=" + aqje.encrypt(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum));
      }
      ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.Bv(2131717125);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void dG(Intent paramIntent)
  {
    this.O = paramIntent;
    if (QLog.isDevelopLevel()) {
      QLog.i("QueryAccount", 4, "setExtraInfo");
    }
  }
  
  public void dH(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.O != null)) {
      paramIntent.putExtras(this.O);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    String str1;
    String str2;
    long l;
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("phonenum");
      String str3 = paramIntent.getStringExtra("key");
      str1 = paramIntent.getStringExtra("invite_code");
      str2 = str3 + (String)localObject;
      if (this.mE.containsKey(str2)) {
        this.mE.remove(str2);
      }
      paramInt1 = paramIntent.getIntExtra("key_register_left_time", 0);
      l = paramIntent.getLongExtra("key_register_exit_time", 0L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doOnActivityResult countryCode=").append(str3).append(", phoneNum=").append(aqje.encrypt((String)localObject)).append(", leftTime=").append(paramInt1).append(", exitTime=").append(l).append(", inviteCode=");
        if (str1 != null) {
          break label231;
        }
      }
    }
    label231:
    for (paramIntent = "";; paramIntent = str1)
    {
      QLog.d("QueryAccount", 2, paramIntent);
      if ((paramInt1 > 0) && (l > 0L))
      {
        paramIntent = new altw.a();
        paramIntent.dxB = paramInt1;
        paramIntent.tT = l;
        paramIntent.aLv = str1;
        this.mE.put(str2, paramIntent);
      }
      return;
    }
  }
  
  @RequiresApi(api=23)
  public void eP(Context paramContext)
  {
    String str2 = Locale.getDefault().getLanguage();
    Object localObject = aczz.h(BaseApplicationImpl.getContext(), "key_local_cache", "0");
    if ("0".equals(localObject)) {
      QLog.e("QueryAccount", 1, "addLocaleIdCookie, localeIdStr = 0");
    }
    for (;;)
    {
      return;
      try
      {
        i = Integer.parseInt((String)localObject);
        try
        {
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          if (paramContext == null) {
            break label210;
          }
          paramContext = alkz.a(paramContext);
          if (paramContext == null) {
            break label210;
          }
          paramContext = alkz.c(paramContext);
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QLog.e("QueryAccount", 1, paramContext, new Object[0]);
            paramContext = "02:00:00:00:00:00";
          }
        }
        localObject = "";
        try
        {
          String str1 = SosoInterface.getCityCode();
          localObject = str1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("QueryAccount", 1, localThrowable, new Object[0]);
          }
        }
        this.bYo = paramContext;
        this.bYp = str2;
        this.dxA = i;
        this.bYq = ((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QueryAccount", 2, new Object[] { "regMacAddr:", this.bYo, " regOS:", this.bYp, " regQQLang:", Integer.valueOf(this.dxA), " regLocation:", this.bYq });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QueryAccount", 1, localException.toString());
          int i = 0;
        }
      }
    }
  }
  
  public String hh(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode)) {
          break label191;
        }
        if ("853".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode))
        {
          break label191;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode)) {
            i = 0;
          }
        }
        if (!"86".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode)) {
          break label183;
        }
        j = paramString.length();
        if (j == 11) {
          break label183;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label166;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
      if (bool)
      {
        i = 9;
        continue;
        label166:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label183:
        continue;
        label191:
        i = 6;
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.gV();
    this.app.unRegistObserver(this.d);
    if (this.jdField_a_of_type_Altz != null) {
      this.jdField_a_of_type_Altz.onDestroy();
    }
  }
  
  public class a
  {
    public String aLv;
    public int dxB;
    public long tT;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altw
 * JD-Core Version:    0.7.0.1
 */