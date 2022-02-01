package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NearbyTitleBarActivity
  extends IphoneTitleBarActivity
{
  public long Oi;
  public long adi = System.currentTimeMillis();
  public NearbyAppInterface b;
  public boolean cpT;
  public boolean cpU;
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.post(new NearbyTitleBarActivity.1(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  static void a(NearbyAppInterface paramNearbyAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    ReportRunnable localReportRunnable = null;
    if (paramLong1 != 0L) {}
    try
    {
      localReportRunnable = new ReportRunnable();
      localReportRunnable.mUin = paramNearbyAppInterface.getCurrentAccountUin();
      localReportRunnable.mState = paramNearbyAppInterface.dkh;
      localReportRunnable.mFrom = paramNearbyAppInterface.dki;
      localReportRunnable.adi = paramLong2;
      localReportRunnable.ie = paramLong1;
      localReportRunnable.Oi = paramLong3;
      paramNearbyAppInterface.iM(2, 0);
      ThreadManager.getUIHandler().post(localReportRunnable);
      return;
    }
    catch (Throwable paramNearbyAppInterface)
    {
      paramNearbyAppInterface.printStackTrace();
    }
  }
  
  public static void i(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface, paramString, "", "", "", "");
  }
  
  public boolean Qj()
  {
    return false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    int i;
    if (!this.cpT)
    {
      if (Qj()) {
        getWindow().addFlags(16777216);
      }
      i = getLayoutResId();
      if (i != 0)
      {
        setContentView(i);
        this.cpT = true;
      }
    }
    if ((this.cpT) && (!this.cpU)) {}
    try
    {
      initViews();
      this.cpU = true;
      i = vA();
      if (i == 0)
      {
        getWindow().setBackgroundDrawable(null);
        this.mUseOptimizMode = true;
        return bool;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        getWindow().setBackgroundDrawableResource(i);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.Oi == 0L)
    {
      this.Oi = System.currentTimeMillis();
      if (this.b.dkh == 2) {}
    }
    try
    {
      long l = getIntent().getLongExtra("ENTER_TIME", 0L);
      a(this.b, l, this.adi, this.Oi);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int getLayoutResId()
  {
    return 0;
  }
  
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public void initViews() {}
  
  public boolean showPreview()
  {
    int i = getLayoutResId();
    if (i != 0)
    {
      if (Qj()) {
        getWindow().addFlags(16777216);
      }
      setContentView(i);
      this.cpT = true;
    }
    try
    {
      initViews();
      this.cpU = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof NearbyAppInterface)) {
      this.b = ((NearbyAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 4, "NearbyActivity updateAppRuntime, " + localAppRuntime);
    }
  }
  
  public int vA()
  {
    return 0;
  }
  
  static class ReportRunnable
    implements Runnable
  {
    public long Oi;
    public long adi;
    public long ie;
    public int mFrom;
    public int mState;
    public String mUin;
    public long zn;
    
    public void run()
    {
      try
      {
        this.zn = System.currentTimeMillis();
        ThreadManager.post(new NearbyTitleBarActivity.ReportRunnable.1(this), 5, null, false);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */