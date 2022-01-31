package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aqb;
import aqc;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class GesturePWDSettingActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 999;
  public static final String a = "key_reset";
  static final int jdField_b_of_type_Int = 11;
  private static final int jdField_c_of_type_Int = 10;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aqc(this);
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private View jdField_c_of_type_AndroidViewView;
  private int d = 0;
  private int e = 0;
  
  private void c()
  {
    setTitle(2131363996);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297161);
    this.b = findViewById(2131297164);
    this.c = findViewById(2131297162);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297160));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aqb(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_reset", false);
    this.d = GesturePWDUtils.getGesturePWDState(this, this.app.a());
    switch (this.d)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.h != null) && ((this.h instanceof TextView))) {
          this.h.setText(2131363642);
        }
        startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 10);
        overridePendingTransition(2130968592, 2130968589);
        return;
      }
      startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 999);
      overridePendingTransition(2130968592, 2130968589);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    a(true);
    a();
  }
  
  private void e()
  {
    this.d = GesturePWDUtils.getGesturePWDState(this, this.app.a());
    switch (this.d)
    {
    default: 
      return;
    case 0: 
    case 1: 
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      return;
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
  }
  
  public void a()
  {
    this.e = GesturePWDUtils.getGesturePWDMode(this, this.app.a());
    if (this.e == 21)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(4);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.b.setVisibility(4);
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(getActivity(), PermisionPrivacyActivity.class);
      localIntent.putExtra("key_reset", this.jdField_a_of_type_Boolean);
      startActivity(localIntent);
      finish();
      return true;
    }
    return super.a();
  }
  
  protected String b_()
  {
    if (this.d == 0) {
      return getString(2131364283);
    }
    return getString(2131363996);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 999) || (paramInt1 == 10))
    {
      if (paramInt2 == -1)
      {
        e();
        a();
      }
    }
    else
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903207);
    c();
    d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity
 * JD-Core Version:    0.7.0.1
 */