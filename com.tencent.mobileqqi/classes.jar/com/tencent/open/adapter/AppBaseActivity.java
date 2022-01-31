package com.tencent.open.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.component.cache.CacheManager;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class AppBaseActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static final int a = 1000;
  protected static final String a;
  protected Handler a;
  protected View a;
  protected ProgressBar a;
  protected TextView a;
  protected AppInterface a;
  protected BrowserAppInterface a;
  protected View b;
  protected TextView b;
  protected String b;
  protected TextView c;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppBaseActivity.class.getSimpleName();
  }
  
  public AppBaseActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
    }
  }
  
  protected void a(AppRuntime paramAppRuntime)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    do
    {
      do
      {
        return;
      } while (paramAppRuntime == null);
      this.jdField_b_of_type_JavaLangString = ((TicketManager)paramAppRuntime.getManager(2)).getVkey(paramAppRuntime.getAccount());
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    CommonDataAdapter.a().a(this.jdField_b_of_type_JavaLangString);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void d()
  {
    Object localObject3 = null;
    a(getAppRuntime());
    Object localObject1 = getIntent();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Intent)localObject1).getStringExtra("uin");
      localObject3 = ((Intent)localObject1).getStringExtra("sid");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equals("0")) {}
      }
      else
      {
        localObject1 = String.valueOf(CommonDataAdapter.a().a());
      }
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        CommonDataAdapter.a().a();
      }
      localObject3 = (AppInterface)getAppRuntime();
      if ((!(localObject3 instanceof QQAppInterface)) || (!APNUtil.d(CommonDataAdapter.a().a()))) {
        break label145;
      }
      localObject2 = ((QQAppInterface)localObject3).getAccount();
      ((QQAppInterface)localObject3).f();
      label118:
      if ((localObject2 != null) && (!((String)localObject2).equals("0"))) {
        break label184;
      }
    }
    label145:
    label184:
    while (((String)localObject2).equals(String.valueOf(CommonDataAdapter.a().a())))
    {
      return;
      LogUtility.b(jdField_a_of_type_JavaLangString, ">>>initUserData intent  is null>>>");
      localObject2 = null;
      break;
      localObject2 = localObject1;
      if (!(localObject3 instanceof BrowserAppInterface)) {
        break label118;
      }
      localObject2 = localObject1;
      if (!APNUtil.d(CommonDataAdapter.a().a())) {
        break label118;
      }
      localObject2 = ((BrowserAppInterface)localObject3).getAccount();
      localObject1 = this.jdField_b_of_type_JavaLangString;
      break label118;
    }
    CommonDataAdapter.a().a(Long.valueOf((String)localObject2).longValue());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      Class.forName("android.os.AsyncTask");
      super.doOnCreate(paramBundle);
      a(getAppRuntime());
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("sid");
        if (!TextUtils.isEmpty(paramBundle)) {
          CommonDataAdapter.a().a(paramBundle);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      CacheManager.a(CommonDataAdapter.a().a());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    d();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = this.k;
    this.jdField_b_of_type_AndroidWidgetTextView = this.m;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131231448);
    View localView1 = getLayoutInflater().inflate(2130903334, null);
    View localView2 = getLayoutInflater().inflate(2130903335, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13, 1);
    localRelativeLayout.addView(localView1, localLayoutParams);
    localRelativeLayout.addView(localView2, localLayoutParams);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232129);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131232128);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.c = ((TextView)localView1.findViewById(2131232126));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView1.findViewById(2131232127));
    f();
  }
  
  protected void f()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((getAppRuntime() instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)getAppRuntime());
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;; localObject = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)localObject);
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        break;
      }
      return;
    }
    LogUtility.b(jdField_a_of_type_JavaLangString, ">>>setNightTheme runtime:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getClass().getName());
    localObject = findViewById(2131232112);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      ((View)localObject).setVisibility(0);
      return;
    }
    ((View)localObject).setVisibility(8);
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    }
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    super.onDestroy();
  }
  
  public void onPostThemeChanged()
  {
    f();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(CommonDataAdapter.a().a())) {
      paramBundle.putString("sid", CommonDataAdapter.a().a());
    }
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.adapter.AppBaseActivity
 * JD-Core Version:    0.7.0.1
 */