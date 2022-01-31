package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import chk;
import chl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class PhoneFrameActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 0;
  public static final String a = "key_req_type";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public View a;
  public ImageView a;
  public TextView a;
  public PhoneFrame a;
  boolean a;
  public View b;
  public ImageView b;
  boolean b;
  private int e = 0;
  
  public PhoneFrameActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131296894).getParent());
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296901));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("通讯录");
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364541));
    this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296905));
    this.j.setText(2131364391);
    this.j.setOnClickListener(new chk(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296912));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296913));
    if (this.e == 2) {
      findViewById(2131296911).setVisibility(0);
    }
    for (;;)
    {
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidViewView);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetTextView);
      IphoneTitleBarActivity.setLayerType(this.j);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
      IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = ((PhoneFrame)findViewById(2131297410));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setActivity(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setPhoneContext(new chl(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(null);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_req_type", this.e);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.b(localBundle);
      return;
      if (this.e != 1) {
        if (this.e == 0) {
          findViewById(2131296911).setVisibility(0);
        } else {
          findViewById(2131296911).setVisibility(8);
        }
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20001)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2130903261);
    this.e = getIntent().getIntExtra("key_req_type", 0);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.d();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.b();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a();
  }
  
  public void finish()
  {
    if ((this.app.isLogin()) && (this.e == 0))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", 1);
      startActivity(localIntent);
    }
    super.finish();
    overridePendingTransition(2130968587, 2130968588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrameActivity
 * JD-Core Version:    0.7.0.1
 */