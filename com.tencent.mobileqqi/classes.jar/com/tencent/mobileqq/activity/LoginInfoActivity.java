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
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import daa;
import dab;
import dac;
import dad;
import dah;
import dai;
import daj;
import dak;
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
  private Handler jdField_a_of_type_AndroidOsHandler = new daa(this);
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new daj(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dah(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = null;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private List jdField_a_of_type_JavaUtilList = null;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new dai(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
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
    this.jdField_a_of_type_AndroidOsHandler.post(new dab(this, paramInt));
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label93;
        }
        i += 1;
      }
    }
    label93:
    View localView = getLayoutInflater().inflate(2130903270, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131230995);
    label133:
    Object localObject2;
    TextView localTextView1;
    Button localButton;
    TextView localTextView2;
    ImageView localImageView;
    if (j == 1)
    {
      ((RelativeLayout)localObject1).setBackgroundResource(2130837875);
      getResources().getString(2131561840);
      localObject2 = getResources().getString(2131561897);
      localTextView1 = (TextView)localView.findViewById(2131231898);
      localButton = (Button)localView.findViewById(2131231899);
      localTextView1.setContentDescription(getString(2131561897));
      localButton.setContentDescription(getString(2131561840));
      localTextView2 = (TextView)localView.findViewById(2131231000);
      localObject1 = (TextView)localView.findViewById(2131231506);
      localImageView = (ImageView)localView.findViewById(2131230940);
      if (i != 0) {
        break label464;
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130838117);
      label273:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label517;
      }
      localTextView2.setText(2131563124);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject2).length() > 0) {
        ((TextView)localObject1).setText(((StringBuffer)localObject2).toString());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      if (i == 0)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130837880);
        break label133;
      }
      if (i == j - 1)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130837877);
        break label133;
      }
      ((RelativeLayout)localObject1).setBackgroundResource(2130837879);
      break label133;
      label464:
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130838116);
      localButton.setOnClickListener(new dad(this, localButton, i));
      break label273;
      label517:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
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
        EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
        this.d.setText(getString(2131562015));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838762);
        return;
        i = 0;
      }
      else
      {
        EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
        this.d.setText(getString(2131561949));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838761);
        return;
        i = 0;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dac(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131362072));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void f()
  {
    this.jdField_c_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131562561));
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131561839));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131562513));
  }
  
  protected boolean b()
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
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i = EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
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
    setContentView(2130903269);
    setTitle(2131562034);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231893));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231892));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231886));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231894));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231887));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131231890));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131231895));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231891));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131562418));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231896);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231897));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131562841));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    boolean bool = SettingCloneUtil.readValue(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "login_accounts", "qqsetting_bothonline_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    SettingCloneUtil.writeValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    if (!EquipmentLockImpl.a().b()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = new SpannableString(getResources().getString(2131561943));
    this.d = ((TextView)findViewById(2131231889));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131231617));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231888));
    int i = paramBundle.length();
    paramBundle.setSpan(new dak(this, null), 0, i, 33);
    paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131362076)), 0, i, 33);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
    try
    {
      this.jdField_b_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "packName = " + this.jdField_b_of_type_JavaLangString);
      }
      a(null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "onCreate begin to getLoginDevList");
      }
      if (NetworkUtil.e(this))
      {
        bool = EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, 0L);
        if (bool)
        {
          a(0);
          if (getIntent() != null) {
            break label658;
          }
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
          QQToast.a(this, getString(2131562452), 0).b(d());
          continue;
          label658:
          if (getIntent().getExtras() == null)
          {
            c();
          }
          else
          {
            this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)getIntent().getExtras().get("devlock_info"));
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) {
              c();
            } else {
              a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
            }
          }
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131231887: 
    case 2131231888: 
    case 2131231889: 
    case 2131231890: 
    case 2131231891: 
    case 2131231892: 
    case 2131231893: 
    default: 
    case 2131231886: 
      do
      {
        return;
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!NetworkUtil.e(this))
          {
            QQToast.a(this, getString(2131562452), 0).b(d());
            return;
          }
          c();
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendWirelessMeibaoReq(1);
          paramView = new Intent(this, AuthDevActivity.class);
          paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          paramView.putExtra("auth_dev_open", true);
          startActivityForResult(paramView, 0);
          return;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendWirelessMeibaoReq(1);
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
    case 2131231894: 
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, getString(2131562452), 0).b(d());
        return;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
      startActivity(new Intent(this, RecentLoginDevActivity.class));
      return;
    case 2131231895: 
      startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
      return;
    }
    if (PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      startActivity(paramView.putExtra("url", "http://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733&uin=" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendWirelessPswReq(1);
      return;
    }
    paramView = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject = new StringBuilder("https://aq.qq.com/en/change_psw/mobile/mobile_change_mqq_reg_input_pwd");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("source_id=2997");
    ((StringBuilder)localObject).append("&uin=");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append("&plat=1");
    ((StringBuilder)localObject).append("&app=1");
    ((StringBuilder)localObject).append("&version=6.0.0.6500");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */