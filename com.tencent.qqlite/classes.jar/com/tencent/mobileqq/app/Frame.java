package com.tencent.mobileqq.app;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.utils.pathtracker.VipPathTracker;
import mqq.app.Constants.LogoutReason;

public abstract class Frame
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 2, 3, 4 };
  private View jdField_a_of_type_AndroidViewView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  protected boolean d;
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
  
  public int a()
  {
    return hashCode();
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
  
  protected String a()
  {
    return null;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt);
  }
  
  public String a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt, new Object[] { paramString });
  }
  
  public void a()
  {
    b();
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
    this.d = true;
  }
  
  public void a(boolean paramBoolean, Context paramContext) {}
  
  public boolean a()
  {
    return true;
  }
  
  void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public void c() {}
  
  public void d()
  {
    VipPathTracker.a().a(a(), jdField_a_of_type_ArrayOfInt);
    this.d = false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  public abstract void f();
  
  protected void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void k()
  {
    g();
    b();
    f();
  }
  
  public void l() {}
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame
 * JD-Core Version:    0.7.0.1
 */