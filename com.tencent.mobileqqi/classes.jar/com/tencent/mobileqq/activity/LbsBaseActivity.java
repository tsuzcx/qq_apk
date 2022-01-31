package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cxm;
import cxn;
import cxo;
import cxp;
import cxq;
import cxr;
import cxs;
import cxt;
import java.lang.reflect.Field;

public class LbsBaseActivity
  extends IphoneTitleBarActivity
{
  protected static final int a = 10;
  private Dialog a;
  private Dialog b;
  private Dialog c;
  
  private boolean c()
  {
    LocationManager localLocationManager = (LocationManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("location");
    try
    {
      bool = localLocationManager.isProviderEnabled("gps");
      if (QLog.isColorLevel()) {
        QLog.i("LBS", 2, "GPS Open " + bool);
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  private void e(Runnable paramRunnable)
  {
    if (!c())
    {
      g(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private void f(Runnable paramRunnable)
  {
    boolean bool = c();
    TelephonyManager localTelephonyManager = (TelephonyManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("phone");
    if ((localTelephonyManager != null) && (localTelephonyManager.getSimState() == 5) && ((localTelephonyManager.getCellLocation() instanceof CdmaCellLocation))) {}
    for (int i = 1;; i = 0)
    {
      if ((!bool) && (i != 0))
      {
        g(paramRunnable);
        return;
      }
      paramRunnable.run();
      return;
    }
  }
  
  private boolean f()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.m();
  }
  
  private void g(Runnable paramRunnable)
  {
    if (this.a == null)
    {
      this.a = a(17039380, 2131563091, 2131561088, 2131562541, new cxo(this), new cxp(this));
      this.a.setOnDismissListener(new cxq(this, paramRunnable));
    }
    c();
    this.a.show();
  }
  
  private void h(Runnable paramRunnable)
  {
    paramRunnable = new cxr(this, paramRunnable);
    this.jdField_b_of_type_AndroidAppDialog = a(2131562689, a(), 2131562511, 2131562541, new cxs(this), new cxt(this));
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(paramRunnable);
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  protected int a()
  {
    return 2131563281;
  }
  
  protected Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = getResources().getString(paramInt1);
    Object localObject1 = getResources().getString(paramInt2);
    String str2 = getResources().getString(paramInt3);
    String str1 = getResources().getString(paramInt4);
    Dialog localDialog = new Dialog(this, 2131624405);
    localDialog.setContentView(2130903162);
    TextView localTextView = (TextView)localDialog.findViewById(2131231469);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)localObject2);
      localTextView.setContentDescription((CharSequence)localObject2);
    }
    localObject2 = (TextView)localDialog.findViewById(2131231029);
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)localDialog.findViewById(2131231472);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(str2);
      ((TextView)localObject1).setContentDescription(str2);
      ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
    }
    paramOnClickListener1 = (TextView)localDialog.findViewById(2131231473);
    if (paramOnClickListener1 != null)
    {
      paramOnClickListener1.setText(str1);
      paramOnClickListener1.setContentDescription(str1);
      paramOnClickListener1.setOnClickListener(paramOnClickListener2);
    }
    return localDialog;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(d());
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(d());
    }
  }
  
  protected void a(Runnable paramRunnable)
  {
    f(paramRunnable);
  }
  
  protected int b()
  {
    try
    {
      int i = ((Integer)Class.forName("com.android.internal.R$id").getField("title_container").get(null)).intValue();
      i = ((ViewGroup)getWindow().findViewById(i)).getBottom();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void b() {}
  
  protected void b(Runnable paramRunnable)
  {
    if (f())
    {
      f(paramRunnable);
      return;
    }
    h(paramRunnable);
  }
  
  protected void c() {}
  
  protected void c(Runnable paramRunnable)
  {
    if (f()) {
      f(paramRunnable);
    }
  }
  
  public void d()
  {
    finish();
  }
  
  protected void d(Runnable paramRunnable)
  {
    this.c = a(2131561835, 2131561451, 2131561746, 2131561918, new cxm(this), new cxn(this, paramRunnable));
    this.c.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity
 * JD-Core Version:    0.7.0.1
 */