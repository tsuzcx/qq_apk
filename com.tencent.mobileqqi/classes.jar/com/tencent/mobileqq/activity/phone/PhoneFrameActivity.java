package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import elm;
import eln;

public class PhoneFrameActivity
  extends IphoneTitleBarActivity
{
  private static final int jdField_a_of_type_Int = 0;
  public View a;
  public ImageView a;
  public TextView a;
  public PhoneFrame a;
  boolean jdField_a_of_type_Boolean;
  public View b;
  boolean b;
  
  public PhoneFrameActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = new View(this);
    this.jdField_b_of_type_AndroidViewView = new View(this);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.k = new TextView(this);
    this.m.setText(2131562896);
    this.m.setOnClickListener(new elm(this));
    this.jdField_a_of_type_AndroidWidgetImageView = this.p;
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("设置");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = ((PhoneFrame)findViewById(2131232038));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setPhoneContext(new eln(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(null);
    Bundle localBundle;
    if (getIntent() != null)
    {
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("call_by_forward", false);
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("call_by_select_member", false);
      if (this.jdField_a_of_type_Boolean)
      {
        localBundle = new Bundle();
        localBundle.putBoolean("call_by_forward", true);
        if (this.jdField_b_of_type_Boolean)
        {
          localBundle = new Bundle();
          localBundle.putBoolean("call_by_select_member", true);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.b(localBundle);
      return;
      localBundle = null;
      break;
      localBundle = null;
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
    setContentView(2130903309);
    d();
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
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", 1);
      startActivity(localIntent);
    }
    super.finish();
    overridePendingTransition(2130968593, 2130968594);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131231379: 
      this.m.performClick();
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a.l();
      }
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem;
    if ((this.m != null) && (this.m.getVisibility() == 0) && (this.m.getText() != null))
    {
      localMenuItem = paramMenu.findItem(0);
      if (localMenuItem != null) {
        break label147;
      }
      localMenuItem = paramMenu.add(0, 0, 0, getString(2131562830));
      localMenuItem.setIcon(2130839698);
      MenuItemCompat.setShowAsAction(localMenuItem, 1);
      localMenuItem = paramMenu.findItem(this.m.getId());
      if (localMenuItem == null) {
        break label159;
      }
      localMenuItem.setIcon(2130838032);
    }
    for (;;)
    {
      if ((this.l != null) && (this.l.getVisibility() == 0) && (this.l.getText() != null) && (getSupportActionBar() != null)) {
        getSupportActionBar().setTitle(this.l.getText());
      }
      return true;
      label147:
      localMenuItem.setIcon(2130839698);
      break;
      label159:
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 2131231379, 0, this.m.getText()), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrameActivity
 * JD-Core Version:    0.7.0.1
 */