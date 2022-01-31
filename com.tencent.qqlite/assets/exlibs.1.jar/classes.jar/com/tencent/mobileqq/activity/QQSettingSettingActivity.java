package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bge;
import bgf;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "QQSetting2Activity";
  private static final boolean jdField_a_of_type_Boolean = true;
  private long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ProgressBar a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new bgf(this);
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new bge(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  TextView b = null;
  
  public QQSettingSettingActivity()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void d()
  {
    int i = 1;
    View localView = findViewById(2131298496);
    Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130839373);
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = findViewById(paramInt1);
    if (localView == null) {
      return;
    }
    TextView localTextView = (TextView)localView.findViewById(2131298455);
    localTextView.setText(paramInt2);
    localTextView.setContentDescription(getString(paramInt2));
    if (paramInt3 > 0) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
    }
    localView.setBackgroundResource(2130837758);
    localView.setOnClickListener(this);
    if (paramInt1 == 2131298494)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
      this.b = localTextView;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297270));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131297063));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297269));
      return;
    }
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131298457);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131298456)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131298454);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramBoolean)
    {
      EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364209));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838692);
      return;
    }
    EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364208));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838691);
  }
  
  public void c()
  {
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      QQToast.a(this, getString(2131364234), 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.a(33);
    if (localSecSvcHandler != null)
    {
      localSecSvcHandler.b();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 0) && ((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      a(paramIntent.getExtras().getBoolean("auth_dev_open", false));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903553);
    setTitle(2131362939);
    d(2130837633);
    a(2131298491, 2131364296, 0);
    a(2131298492, 2131364306, 0);
    a(2131298493, 2131364297, 0);
    a(2131298494, 2131364298, 0);
    a(2131298495, 2131364299, 0);
    a(2131298496, 2131364300, 0);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    d();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public int getPathNodeID()
  {
    return 16;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298491: 
      startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
      return;
    case 2131298492: 
      paramView = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      getActivity().startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
      return;
    case 2131298493: 
      startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
      return;
    case 2131298494: 
      startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
      return;
    case 2131298495: 
      startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
      return;
    }
    startActivity(new Intent(getActivity(), AboutActivity.class));
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */