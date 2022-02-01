package com.tencent.qqconnect.wtlogin;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import htu;
import java.net.URLEncoder;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevUgActivity2
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
  public static String j = null;
  private static final String k = "Q.devlock.AuthDevUgActivity2";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new htu(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private int d = -1;
  private String l = null;
  
  private void d()
  {
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        String str = getString(2131562606) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        this.c.setText(str);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131563162));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.k.setVisibility(4);
      c(2131561746, this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562394));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131563162));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561942));
    }
  }
  
  private void e()
  {
    Object localObject2 = "http://aq.qq.com/cn2/manage/mobile_h5/mobile_index";
    Object localObject1 = localObject2;
    if (j != null)
    {
      localObject1 = localObject2;
      if (j.length() > 0) {
        if (!j.startsWith("http")) {
          break label257;
        }
      }
    }
    label257:
    for (localObject1 = j;; localObject1 = "http://" + j)
    {
      localObject1 = new StringBuilder((String)localObject1);
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append("plat=1");
      ((StringBuilder)localObject1).append("&app=1");
      ((StringBuilder)localObject1).append("&version=6.0.3.6604");
      ((StringBuilder)localObject1).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject1).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject1).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      localObject1 = ((StringBuilder)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevUgActivity2", 2, "AuthDevUgAct url=" + (String)localObject1);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("uin", this.l);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      VasWebviewUtil.a(this, (String)localObject1, 16384L, (Intent)localObject2, false, -1);
      return;
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean b()
  {
    setResult(0);
    VerifyDevLockManager localVerifyDevLockManager = (VerifyDevLockManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(7);
    if (localVerifyDevLockManager != null) {
      localVerifyDevLockManager.cancelVerify(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
    }
    finish();
    overridePendingTransition(0, 2130968599);
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232961: 
      e();
      return;
    case 2131232950: 
      paramView = new Intent(this, AuthDevVerifyCodeActivity2.class);
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      }
      paramView.putExtra("uin", this.l);
      paramView.putExtra("seq", this.d);
      startActivityForResult(paramView, 1002);
      return;
    }
    paramView = (VerifyDevLockManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(7);
    if (paramView != null) {
      paramView.cancelVerify(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
    }
    finish();
    overridePendingTransition(0, 2130968599);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (BaseActivity.a(getIntent()))
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    if (localIntent.getExtras() == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)getIntent().getExtras().get("DevlockInfo"));
    this.l = getIntent().getExtras().getString("uin");
    this.d = getIntent().getExtras().getInt("seq");
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        QLog.d("Q.devlock.AuthDevUgActivity2", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
        QLog.d("Q.devlock.AuthDevUgActivity2", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.AuthDevUgActivity2", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.AuthDevUgActivity2", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.AuthDevUgActivity2", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
      }
      QLog.d("Q.devlock.AuthDevUgActivity2", 2, "seq=" + this.d);
    }
    getWindow().setFormat(-3);
    setTheme(2131624531);
    super.onCreate(paramBundle);
    setContentView(2130903575);
    setTitle(2131561941);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo))) {
      j = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232958));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232959));
    this.c = ((TextView)findViewById(2131232960));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232961));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131232950));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    d();
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.AuthDevUgActivity2
 * JD-Core Version:    0.7.0.1
 */