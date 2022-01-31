package com.tencent.mobileqq.app;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import mqq.app.Constants.LogoutReason;

public abstract class Frame
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  public boolean a_;
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
  
  public ContentResolver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getContentResolver();
  }
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public Object a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService(paramString);
  }
  
  public String a()
  {
    return null;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt);
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramIntent);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.post(paramRunnable);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    this.a_ = true;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Menu paramMenu)
  {
    return false;
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void b()
  {
    g();
    h();
    f();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public boolean b()
  {
    if (Conversation.d())
    {
      Conversation.n();
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  public void d()
  {
    this.a_ = false;
  }
  
  public void e() {}
  
  public abstract void f();
  
  public void g() {}
  
  public void j() {}
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame
 * JD-Core Version:    0.7.0.1
 */