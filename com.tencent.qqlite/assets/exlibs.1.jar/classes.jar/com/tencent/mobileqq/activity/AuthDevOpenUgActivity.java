package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yv;

public class AuthDevOpenUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1001;
  public static final String a = "from_login";
  public static final int b = 1002;
  public static final String b = "phone_num";
  public static final int c = 1003;
  public static final String c = "country_code";
  public static final String d = "auth_dev_open";
  public static final String e = "allow_set";
  public static final String f = "user_guide";
  public static final String g = "user_uin";
  public static final String h = "seq";
  public static final String i = "DevlockInfo";
  private static final String j = "Q.devlock.AuthDevOpenUgActivity";
  private static final String k = "UserBehavior";
  private static final String l = "Manually";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new yv(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int d;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  
  private void a(String paramString)
  {
    for (;;)
    {
      int i1;
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        this.s = paramString.getString("title");
        this.t = paramString.getString("smallTitle");
        this.u = paramString.getString("guideTitle");
        paramString = paramString.getJSONArray("guideArray");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label144;
        }
        i1 = 0;
        if (i1 >= paramString.length()) {
          break label144;
        }
        str = paramString.getString(i1);
        if (i1 == 0) {
          this.v = str;
        } else if (i1 == 1) {
          this.w = str;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "parseJson error.");
        }
        return;
      }
      if (i1 == 2)
      {
        this.x = str;
      }
      else if (i1 == 3)
      {
        this.y = str;
        break label265;
        label144:
        if (TextUtils.isEmpty(this.s)) {
          this.s = getString(2131364239);
        }
        if (TextUtils.isEmpty(this.v)) {
          this.v = getString(2131364230);
        }
        if (TextUtils.isEmpty(this.w)) {
          this.w = getString(2131364231);
        }
        if (TextUtils.isEmpty(this.x)) {
          this.x = getString(2131364232);
        }
        if (TextUtils.isEmpty(this.y)) {
          this.y = getString(2131364233);
        }
        if (!TextUtils.isEmpty(this.u)) {
          continue;
        }
        this.u = getString(2131364229);
        return;
      }
      label265:
      i1 += 1;
    }
  }
  
  private void b(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131296897);
    localTextView = (TextView)findViewById(2131298179);
    if (TextUtils.isEmpty(paramString)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.b.setText(getString(2131364228));
      this.b.setContentDescription(getString(2131364192));
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.app.a(), "UserBehavior", "Manually", 0, 1, "", "", "", "");
      return;
      localTextView.setText(paramString);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected boolean a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    a(0, localIntent);
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if (!EquipmentLockImpl.a().a()) {
          break label123;
        }
        paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("allow_set", true);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        }
        a(-1, paramIntent);
      }
    }
    label123:
    do
    {
      do
      {
        do
        {
          boolean bool;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    paramIntent = new Intent(this, AuthDevActivity.class);
                    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                    {
                      paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                      paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                    }
                    paramIntent.putExtra("auth_dev_open", true);
                    startActivity(paramIntent);
                    break;
                    if (paramInt1 != 1002) {
                      break label202;
                    }
                  } while (paramInt2 != -1);
                  finish();
                  return;
                } while (paramInt1 != 1003);
                if (paramInt2 != -1) {
                  break label581;
                }
              } while ((paramIntent == null) || (paramIntent.getExtras() == null));
              paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
              }
            } while (paramInt1 != 2);
            String str = paramIntent.getExtras().getString("resultMobileMask");
            bool = paramIntent.getExtras().getBoolean("resultSetMobile");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
            }
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
            }
          } while (!bool);
          EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
          if (EquipmentLockImpl.a().a())
          {
            paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
            {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            startActivity(paramIntent);
          }
          for (;;)
          {
            QQToast.a(getApplicationContext(), 2, getString(2131364194), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            a(-1, paramIntent);
            return;
            paramIntent = new Intent(this, AuthDevActivity.class);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
            {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
          }
        } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
        }
      } while (paramInt1 != 2);
      paramIntent = paramIntent.getExtras().getString("resultMobileMask");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        EquipmentLockImpl.a().a(this.app, this.app.a(), null);
      }
    } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
    label202:
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    label581:
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298188: 
      if (this.app != null) {
        this.app.sendWirelessMeibaoReq(1);
      }
      if (mAppForground)
      {
        if ((!TextUtils.isEmpty(this.n)) && (this.n.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "subaccount enter webview mUin=" + this.m + " mMainAccount=" + this.o);
          }
          if ((TextUtils.isEmpty(this.m)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
          }
          EquipLockWebEntrance.a(this, this.o, this.m);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mainaccount enter webview mUin=" + this.m);
        }
        if ((TextUtils.isEmpty(this.m)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.m, this.m);
        return;
      }
      EquipLockWebEntrance.a(this, this.app);
      return;
    }
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.app.a(), "UserBehavior", "Manually", 0, 3, "", "", "", "");
      label282:
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        paramView = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
        paramView.putExtra("ParaTextUp", this.x);
        paramView.putExtra("ParaTextDown", this.y);
        paramView.putExtra("PhoneNO", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramView.putExtra("mainaccount", this.o);
        paramView.putExtra("uin", this.m);
        paramView.putExtra("from_where", this.n);
        paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramView, 1001);
        overridePendingTransition(0, 2130968592);
        return;
      }
      EquipLockWebEntrance.a(this, this.app, 1003, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onClick.cancelVerifyCode mVerifyObserver.seq=" + this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq());
      }
      EquipmentLockImpl.a().a(this.app, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
      finish();
      overridePendingTransition(0, 2130968593);
      return;
    }
    catch (Exception paramView)
    {
      break label282;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    EquipmentLockImpl.a().a(false);
    this.jdField_a_of_type_Boolean = ((Bundle)localObject).getBoolean("from_login");
    this.d = ((Bundle)localObject).getInt("seq");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    this.m = ((Bundle)localObject).getString("uin");
    this.n = ((Bundle)localObject).getString("from_where");
    this.o = ((Bundle)localObject).getString("mainaccount");
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.d + " mUin=" + this.m + " mFromWhere=" + this.n + " mMainAccount=" + this.o);
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
      }
    }
    super.onCreate(paramBundle);
    super.setContentView(2130903478);
    super.setTitle(2131364189);
    this.b = ((Button)findViewById(2131298180));
    this.b.setOnClickListener(this);
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
      a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
    }
    b(this.s);
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.d);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevOpenUgActivity
 * JD-Core Version:    0.7.0.1
 */