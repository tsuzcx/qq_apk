package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aty;
import atz;
import aua;
import aub;
import auf;
import aug;
import auh;
import aui;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.LoginInfoActivity";
  public static final int b = 20140331;
  private static final int jdField_d_of_type_Int = 0;
  private static final int e = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new aty(this);
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auh(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new auf(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private List jdField_a_of_type_JavaUtilList = null;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aug(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = 0;
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public LoginInfoActivity()
  {
    this.d = null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new atz(this, paramInt));
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int j = paramList.size();
    int i = 0;
    label64:
    Object localObject1;
    if (i < j)
    {
      localObject1 = (SvcDevLoginInfo)paramList.get(i);
      if (localObject1 != null) {
        break label93;
      }
    }
    for (;;)
    {
      i += 1;
      break label64;
      break;
      label93:
      Object localObject2 = getLayoutInflater().inflate(2130903228, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      Object localObject3 = getResources().getString(2131364155);
      TextView localTextView2 = (TextView)((View)localObject2).findViewById(2131297274);
      Button localButton = (Button)((View)localObject2).findViewById(2131297275);
      localTextView2.setContentDescription(getString(2131364155));
      localButton.setContentDescription(getString(2131364156));
      TextView localTextView3 = (TextView)((View)localObject2).findViewById(2131296455);
      TextView localTextView1 = (TextView)((View)localObject2).findViewById(2131296953);
      ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131296453);
      if (i == 0)
      {
        localTextView2.setText((CharSequence)localObject3);
        localTextView2.setClickable(false);
        localButton.setVisibility(8);
        localTextView2.setVisibility(0);
        localImageView.setImageResource(2130838125);
        label239:
        if (!TextUtils.isEmpty(((SvcDevLoginInfo)localObject1).strDeviceName)) {
          break label520;
        }
        localTextView3.setText(2131364159);
      }
      for (;;)
      {
        localObject3 = new StringBuffer();
        if (((SvcDevLoginInfo)localObject1).iLoginTime > 0L) {
          ((StringBuffer)localObject3).append(TimeFormatterUtils.a(((SvcDevLoginInfo)localObject1).iLoginTime * 1000L, "MM-dd HH:mm"));
        }
        if (!TextUtils.isEmpty(((SvcDevLoginInfo)localObject1).strLoginLocation))
        {
          ((StringBuffer)localObject3).append(" ");
          ((StringBuffer)localObject3).append(((SvcDevLoginInfo)localObject1).strLoginLocation);
        }
        if (!TextUtils.isEmpty(((SvcDevLoginInfo)localObject1).strDeviceTypeInfo))
        {
          ((StringBuffer)localObject3).append(" ");
          ((StringBuffer)localObject3).append(((SvcDevLoginInfo)localObject1).strDeviceTypeInfo);
        }
        if (((StringBuffer)localObject3).length() > 0) {
          localTextView1.setText(((StringBuffer)localObject3).toString());
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject1 = new ImageView(this);
        ((ImageView)localObject1).setBackgroundResource(2130837991);
        if (i != j - 1) {
          break label533;
        }
        localObject2 = new LinearLayout.LayoutParams(-1, 2);
        ((LinearLayout.LayoutParams)localObject2).setMargins((int)this.jdField_c_of_type_Float * 14, (int)this.jdField_c_of_type_Float * 10, (int)this.jdField_c_of_type_Float * 14, 0);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        break;
        localTextView2.setVisibility(8);
        localButton.setVisibility(0);
        localButton.setTag(localObject1);
        localButton.setClickable(true);
        localImageView.setImageResource(2130838124);
        localButton.setOnClickListener(new aub(this, localButton, i));
        break label239;
        label520:
        localTextView3.setText(((SvcDevLoginInfo)localObject1).strDeviceName);
      }
      label533:
      localObject1 = getLayoutInflater().inflate(2130903178, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    int i;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
        this.d.setText(getString(2131364194));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838667);
        return;
        i = 0;
      }
      else
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
        this.d.setText(getString(2131364193));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838666);
        return;
        i = 0;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aua(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131427468));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void f()
  {
    this.jdField_c_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.a());
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131363999));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131363998));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131363997));
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    Intent localIntent;
    boolean bool1;
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
    {
      localIntent = new Intent();
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
        break label71;
      }
      bool1 = true;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
        break label76;
      }
    }
    for (;;)
    {
      localIntent.putExtra("auth_dev_open", bool1);
      localIntent.putExtra("allow_set", bool2);
      setResult(0, localIntent);
      finish();
      return false;
      label71:
      bool1 = false;
      break;
      label76:
      bool2 = false;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.LoginInfoActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    String str = this.app.a();
    int i = EquipmentLockImpl.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      e();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
      {
        paramIntent = paramIntent.getExtras();
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
          break label149;
        }
        bool1 = true;
        bool1 = paramIntent.getBoolean("auth_dev_open", bool1);
        str = paramIntent.getString("phone_num");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1) {}
        bool2 = paramIntent.getBoolean("allow_set");
        if (!bool1) {
          break label155;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
        }
        if (!bool2) {
          break label166;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;
        a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      }
    }
    label149:
    label155:
    label166:
    while (paramInt1 != 1) {
      for (;;)
      {
        String str;
        boolean bool2;
        return;
        boolean bool1 = false;
        continue;
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
        continue;
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0;
      }
    }
    f();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903227);
    setTitle(2131364283);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297269));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297268));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297263));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297270));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297264));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297271));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297267));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131363034));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297272);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    boolean bool = SettingCloneUtil.readValue(this, this.app.a(), "login_accounts", "qqsetting_bothonline_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (!EquipmentLockImpl.a().b()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = new SpannableString(getResources().getString(2131364154));
    this.d = ((TextView)findViewById(2131297266));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297059));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297265));
    int i = paramBundle.length();
    paramBundle.setSpan(new aui(this, null), 0, i, 33);
    paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131427472)), 0, i, 33);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
    try
    {
      this.jdField_b_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "packName = " + this.jdField_b_of_type_JavaLangString);
      }
      a(null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "onCreate begin to getLoginDevList");
      }
      if (NetworkUtil.e(this))
      {
        bool = EquipmentLockImpl.a().a(this.app, this.jdField_b_of_type_JavaLangString, 0L);
        if (bool)
        {
          a(0);
          c();
          f();
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.devlock.LoginInfoActivity", 2, "onCreate getLoginDevList failed ret=" + bool);
          continue;
          QQToast.a(this, getString(2131362790), 0).b(getTitleBarHeight());
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(getClass());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131297263: 
      do
      {
        return;
        ReportController.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!NetworkUtil.e(this))
          {
            QQToast.a(this, getString(2131362790), 0).b(getTitleBarHeight());
            return;
          }
          c();
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          paramView = new Intent(this, AuthDevActivity.class);
          paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          paramView.putExtra("auth_dev_open", true);
          startActivityForResult(paramView, 0);
          return;
        }
        this.app.sendWirelessMeibaoReq(1);
        if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
        {
          paramView = new Intent(this, AuthDevOpenUgActivity.class);
          paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          startActivityForResult(paramView, 0);
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
        {
          paramView = new Intent(this, AuthDevOpenUgActivity.class);
          paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          startActivityForResult(paramView, 0);
          return;
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1);
      paramView = new Intent(this, AuthDevActivity.class);
      paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
      paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      paramView.putExtra("auth_dev_open", false);
      startActivityForResult(paramView, 0);
      return;
    case 2131297270: 
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, getString(2131362790), 0).b(getTitleBarHeight());
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
      startActivity(new Intent(this, RecentLoginDevActivity.class));
      return;
    case 2131297271: 
      startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
      return;
    }
    if (PhoneNumLoginImpl.a().a(this.app, this.app.a()))
    {
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.a());
      startActivity(paramView.putExtra("url", "http://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733&uin=" + this.app.a()));
      this.app.sendWirelessPswReq(1);
      return;
    }
    paramView = this.app.a();
    Object localObject = new StringBuilder("http://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("uin=");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append("&plat=1");
    ((StringBuilder)localObject).append("&app=1");
    ((StringBuilder)localObject).append("&version=3.4.0.607");
    ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
    ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    VasWebviewUtil.a(this, (String)localObject, 32768L, localIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */