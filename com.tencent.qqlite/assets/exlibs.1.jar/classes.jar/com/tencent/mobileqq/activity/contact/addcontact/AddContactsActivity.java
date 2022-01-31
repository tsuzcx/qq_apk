package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ccq;
import cct;
import ccu;
import com.tencent.mobileqq.app.BaseActivity;

public class AddContactsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  private static final int b = 250;
  public Handler a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public LinearLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AddContactsView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView;
  public ContactBaseView.IAddContactContext a;
  private ContactBaseView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
  public boolean a;
  
  public AddContactsActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext = new ccq(this);
    this.jdField_a_of_type_AndroidOsHandler = new ccu(this);
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, AddContactsActivity.class));
  }
  
  private void a(ContactBaseView paramContactBaseView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != paramContactBaseView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView = paramContactBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.e();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.b();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView);
      }
    }
  }
  
  private void c()
  {
    ((TextView)findViewById(2131296892)).setText(2131363407);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296567));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296898));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363407);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364539));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298103));
    d();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView = new AddContactsView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView instanceof AddContactsView)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903462);
    getWindow().setBackgroundDrawable(null);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.c();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.f();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      Looper.myQueue().addIdleHandler(new cct(this));
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.e();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.g();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */