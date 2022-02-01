package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import coy;
import coz;

public class GesturePWDSettingActivity
  extends IphoneTitleBarActivity
{
  static final int jdField_a_of_type_Int = 11;
  public static final String a = "key_reset";
  private static final int jdField_b_of_type_Int = 10;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new coz(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  
  private void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(d());
  }
  
  private void d()
  {
    setTitle(2131562589);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231745);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131231749);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131231752);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231746));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231750));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231748);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231744));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new coy(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_reset", false);
    this.jdField_c_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.k != null) && ((this.k instanceof TextView))) {
          this.k.setText(2131562839);
        }
        startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 10);
        overridePendingTransition(2130968598, 2130968595);
        return;
      }
      startActivityForResult(new Intent(this, GesturePWDGuideActivity.class), 10);
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
  
  private void f()
  {
    this.jdField_c_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    switch (this.jdField_c_of_type_Int)
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
    this.jdField_d_of_type_Int = GesturePWDUtils.getGesturePWDMode(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (this.jdField_d_of_type_Int == 21)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130840348));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130840346));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130840346));
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130840348));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(4);
  }
  
  protected String a_()
  {
    if (this.jdField_c_of_type_Int == 0) {
      return getString(2131562034);
    }
    return getString(2131562589);
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(a(), PermisionPrivacyActivity.class);
      localIntent.putExtra("key_reset", this.jdField_a_of_type_Boolean);
      startActivity(localIntent);
      finish();
      return true;
    }
    return super.b();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10)
    {
      if (paramInt2 == -1)
      {
        f();
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
    setContentView(2130903244);
    d();
    e();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity
 * JD-Core Version:    0.7.0.1
 */