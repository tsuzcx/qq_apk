package com.tencent.mobileqq.activity.voip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.PhoneFrame;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import exo;

public class VoipAddressBookActivity
  extends IphoneTitleBarActivity
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "voipAddressBookActivity";
  public MenuItem a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  PhoneFrame jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = null;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = ((PhoneFrame)findViewById(2131232036));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.d = true;
    g(getString(2131561872));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookActivity = this;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setPhoneContext(new exo(this));
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
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidViewMenuItem != null) {
      this.jdField_a_of_type_AndroidViewMenuItem.setVisible(true);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20001) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    for (;;)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = VoipHistoryActivity.a(getApplicationContext());
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "click_CallTab", 0, 1, 0, String.valueOf(paramInt1), "", "", "");
        startActivity(new Intent(this, VoipHistoryActivity.class));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(paramInt1, paramInt2, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2130903307);
    f();
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
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewMenuItem != null) {
      this.jdField_a_of_type_AndroidViewMenuItem.setVisible(false);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968593, 2130968594);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131231380: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView.m();
      }
      break;
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView.l();
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
        break label80;
      }
      paramMenu = paramMenu.add(0, 0, 0, " ");
      paramMenu.setIcon(2130840320);
      MenuItemCompat.setShowAsAction(paramMenu, 1);
    }
    for (;;)
    {
      paramMenu.setVisible(false);
      this.jdField_a_of_type_AndroidViewMenuItem = paramMenu;
      return true;
      label80:
      paramMenu = localMenuItem;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame != null)
      {
        paramMenu = localMenuItem;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView != null)
        {
          localMenuItem.setIcon(2130840320);
          paramMenu = localMenuItem;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipAddressBookActivity
 * JD-Core Version:    0.7.0.1
 */