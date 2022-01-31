package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import dhb;
import dhc;
import dhd;
import dhe;
import java.util.ArrayList;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public View a;
  public RadioButton a;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup = null;
  public VerifyPwdView a;
  IBaseTabViewEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = null;
  public QfileTabBarView a;
  dhe jdField_a_of_type_Dhe = null;
  public RelativeLayout b;
  public TextView b;
  TextView c;
  public final String c;
  public String d;
  public boolean d;
  
  public FMActivity()
  {
    this.jdField_c_of_type_JavaLangString = "FMActivity<FileAssistant>";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
    this.jdField_a_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131298006));
    if ((g()) && (paramInt != 5))
    {
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131297999));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
        p();
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
      this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131298001));
      this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
      q();
    }
    do
    {
      return;
      setLeftViewName(2131364503);
      i();
      switch (paramInt)
      {
      case 4: 
      default: 
        return;
      case 0: 
      case 6: 
        this.jdField_b_of_type_JavaLangString = getString(2131361947);
        setTitle(this.jdField_b_of_type_JavaLangString);
        q();
        return;
      case 2: 
      case 3: 
        this.jdField_b_of_type_JavaLangString = getString(2131361943);
        setTitle(this.jdField_b_of_type_JavaLangString);
        c(paramInt);
        return;
      }
      this.jdField_b_of_type_JavaLangString = getString(2131361941);
      setTitle(this.jdField_b_of_type_JavaLangString);
      r();
    } while (!g());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296898));
    this.jdField_c_of_type_AndroidWidgetTextView.setText("全部");
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    if (3 == paramInt) {
      f();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new dhd(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void n()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(17);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_d_of_type_JavaLangString), 0L, 2, null, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FMActivity<FileAssistant>", 2, localException.toString());
    }
  }
  
  private void o()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131624120);
    localQQCustomDialog.setContentView(2130903139);
    localQQCustomDialog.setTitle(getString(2131362363));
    localQQCustomDialog.setMessage(getString(2131362364));
    localQQCustomDialog.setNegativeButton(getString(2131362365), new dhb(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new dhc(this);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(3, getString(2131362061));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131362062));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(5, getString(2131362063));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(6, getString(2131362064));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(7, getString(2131362068));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    if (j())
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297998));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362061);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131362068));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131362062));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131362063));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131362064));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131362067));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      a(this);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = paramIBaseTabViewEvent;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramArrayList);
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(paramArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return;
    }
    int i = 0;
    if (paramBoolean) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int j = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setTabFrameHeight(j - i);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void c(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c(paramArrayList);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void d(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.d(paramArrayList);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("tab_tab_type", -1);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("from_aio", false);
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.jdField_a_of_type_Int + "],select[" + g() + "]");
    }
    if ((g()) && (this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 6)) {
      a(2130903416);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298005));
      b(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int == 6) {
        f();
      }
      int i = getResources().getDisplayMetrics().heightPixels;
      ((LinearLayout)findViewById(2131297997)).setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
      this.app.a().h();
      return true;
      setContentView(2130903416);
      ((RelativeLayout)findViewById(2131297141)).setVisibility(8);
    }
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_Dhe != null) {
      removeObserver(this.jdField_a_of_type_Dhe);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.jdField_d_of_type_JavaLangString != null))
    {
      ((TroopHandler)this.app.a(17)).l(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_Dhe = new dhe(this);
      addObserver(this.jdField_a_of_type_Dhe);
    }
    super.doOnResume();
  }
  
  public void e(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.e(paramArrayList);
  }
  
  public void f(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.f(paramArrayList);
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.app.a().b();
    this.app.a().a();
    if (g()) {
      overridePendingTransition(2130968583, 2130968584);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    FMDataCache.b();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (!c()) {}
    Intent localIntent;
    do
    {
      return;
      g();
      localIntent = new Intent(this, FMLocalFileActivity.class);
      localIntent.putExtra("STRING_Show_Music_Category", false);
      localIntent.putExtra("STRING_Show_Video_Category", false);
      localIntent.putExtra("STRING_Show_Apk_Category", false);
      localIntent.putExtra("STRING_Show_Pic_Category", false);
      localIntent.putExtra("STRING_Show_Driver_Category", false);
      localIntent.putExtra("STRING_Show_First_Space", false);
      if ((paramView.getId() == 2131297998) || (paramView.getId() == 2131296898))
      {
        localIntent.putExtra("localSdCardfile", 1408041717);
        localIntent.putExtra("STRING_Show_Download_Category", false);
        localIntent.putExtra("STRING_Show_MyFile_Category", true);
        a().ag();
        startActivityForResult(localIntent, paramView.getId());
        overridePendingTransition(2130968596, 2130968599);
        return;
      }
    } while (paramView.getId() != 2131298039);
    localIntent.putExtra("localSdCardfile", 1408041716);
    localIntent.putExtra("STRING_Show_Download_Category", false);
    a().an();
    startActivityForResult(localIntent, paramView.getId());
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.o();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  protected void onResume()
  {
    if (FMDataCache.a() > 0L) {
      m();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */