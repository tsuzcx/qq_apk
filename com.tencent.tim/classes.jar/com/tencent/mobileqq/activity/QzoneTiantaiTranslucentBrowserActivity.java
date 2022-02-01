package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import awnj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;

public class QzoneTiantaiTranslucentBrowserActivity
  extends QQTranslucentBrowserActivity
{
  private static volatile long GO;
  private awnj a;
  
  private awnj a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      switch (localIntent.getIntExtra("translucent_controller", 0))
      {
      default: 
        return new awnj(this);
      }
      return new awnj(this);
    }
    return new awnj(this);
  }
  
  public static void aO(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    if (l - GO > 60000L)
    {
      QLog.e("WebLog_QQBrowserActivity", 1, "  nowCallTime =" + l + "gLastLoadToolsProcessTime =" + GO);
      GO = l;
      aP(paramQQAppInterface);
    }
  }
  
  public static void aP(QQAppInterface paramQQAppInterface)
  {
    QLog.i("WebLog_QQBrowserActivity", 1, "preloadToolsProcessImpl running");
    Object localObject = null;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = localObject;
      if (BaseApplicationImpl.getApplication() != null)
      {
        paramQQAppInterface = localObject;
        if (BaseApplicationImpl.getApplication().getRuntime() == null) {}
      }
    }
    for (paramQQAppInterface = (WebProcessManager)BaseApplicationImpl.getApplication().getRuntime().getManager(13);; paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.Yc(1);
      }
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.a != null) && (this.a.onBackPressed())) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (this.a != null) {
      this.a.onCreate();
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.a != null) {
      this.a.onDestory();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.a = a();
    super.onCreate(paramBundle);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (this.a != null) {
      this.a.eEx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */