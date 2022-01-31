package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.language.SelectLanguageActivity;
import com.tencent.mobileqq.activity.language.SelectTransLangActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import djx;
import djy;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 2;
  private static final String jdField_a_of_type_JavaLangString = "QQSetting2Activity";
  private static final boolean jdField_a_of_type_Boolean = true;
  private static final int jdField_b_of_type_Int = 1;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ProgressBar a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new djy(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new djx(this);
  public DevlockInfo a;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  
  public QQSettingSettingActivity()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  }
  
  private void d()
  {
    int i = 1;
    View localView = findViewById(2131233143);
    Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130840210);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch == 1)) {}
      while (i != 0)
      {
        a(localView, 0, localDrawable);
        return;
        i = 0;
      }
      a(localView, 8, localDrawable);
      return;
    }
    a(localView, 8, localDrawable);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = findViewById(paramInt1);
    if (localView == null) {
      return;
    }
    TextView localTextView = (TextView)localView.findViewById(2131233088);
    localTextView.setText(paramInt2);
    localTextView.setContentDescription(getString(paramInt2));
    if (paramInt3 > 0) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(a().getResources().getDrawable(paramInt3), null, null, null);
    }
    localView.setBackgroundResource(paramInt4);
    localView.setOnClickListener(this);
    if (paramInt1 == 2131233139)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
      this.jdField_b_of_type_AndroidWidgetTextView = localTextView;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131231889));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131231617));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131231888));
      return;
    }
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131233090);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131233089)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131233087);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  public void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562015));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838762);
        return;
        i = 0;
      }
      else
      {
        EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561949));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838761);
        return;
        i = 0;
      }
    }
  }
  
  public void c()
  {
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      QQToast.a(this, getString(2131562073), 0).b(d());
    }
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting2Activity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i = EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting2Activity", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
      {
        paramIntent = paramIntent.getExtras();
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
          break label112;
        }
        bool1 = true;
        bool1 = paramIntent.getBoolean("auth_dev_open", bool1);
        boolean bool2 = paramIntent.getBoolean("allow_set");
        if (!bool1) {
          break label118;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
        label90:
        if (!bool2) {
          break label129;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;
        label103:
        a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      }
    }
    label112:
    label118:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
        break label90;
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0;
        break label103;
        if ((paramInt1 == 1) && (paramInt2 != 0))
        {
          if (paramInt2 == 2)
          {
            paramIntent = new Intent(this, BindNumberActivity.class);
            paramIntent.putExtra("kNeedUnbind", true);
            paramIntent.putExtra("key_is_first_activity", false);
            startActivity(paramIntent);
            return;
          }
          startActivity(new Intent(this, PhoneLaunchActivity.class));
          return;
        }
      } while (paramInt2 != 0);
      paramInt1 = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b();
    } while ((paramInt1 != 1) && (paramInt1 != 2));
    label129:
    startActivity(new Intent(this, PhoneLaunchActivity.class));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903625);
    setTitle(2131562894);
    j(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131233135));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131561585));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131561585));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(2131233136, 2131562524, 0, 2130837880);
    a(2131233137, 2131562217, 0, 2130837877);
    a(2131233138, 2131562592, 0, 2130837880);
    a(2131233139, 2131562034, 0, 2130837879);
    a(2131233140, 2131562381, 0, 2130837877);
    a(2131233141, 2131559346, 0, 2130837880);
    a(2131233142, 2131559348, 0, 2130837877);
    a(2131233143, 2131561575, 0, 2130837875);
    paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(paramBundle, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    d();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    Drawable localDrawable = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (localDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localDrawable.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131233135: 
      startActivity(new Intent(this, AccountManageActivity.class));
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
      return;
    case 2131233136: 
      startActivity(new Intent(a(), NotifyPushSettingActivity.class));
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
      return;
    case 2131233137: 
      paramView = new Intent(a(), QQSettingMsgHistoryActivity.class);
      a().startActivity(paramView);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
      return;
    case 2131233138: 
      startActivityForResult(new Intent(a(), PermisionPrivacyActivity.class), 1);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
      return;
    case 2131233139: 
      paramView = new Intent(a(), LoginInfoActivity.class);
      paramView.putExtra("devlock_info", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      startActivityForResult(paramView, 0);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
      return;
    case 2131233140: 
      startActivity(new Intent(a(), AssistantSettingActivity.class));
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
      return;
    case 2131233141: 
      startActivity(new Intent(a(), SelectLanguageActivity.class));
      return;
    case 2131233142: 
      startActivity(new Intent(a(), SelectTransLangActivity.class));
      return;
    }
    startActivity(new Intent(a(), AboutActivity.class));
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */