package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.SetSplashImpl;
import mqq.app.AppActivity;

public class InstallActivity
  extends AppActivity
  implements Runnable
{
  public static final String a = "NT_AY";
  boolean a = false;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Intent localIntent = (Intent)getIntent().getParcelableExtra("NT_AY");
    paramBundle = localIntent;
    if (localIntent == null) {}
    label60:
    for (;;)
    {
      try
      {
        paramBundle = new Intent(this, Class.forName("com.tencent.mobileqq.activity.SplashActivity"));
        localClassNotFoundException1.printStackTrace();
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          paramBundle.addFlags(67108864);
          startActivity(paramBundle);
          finish();
          return false;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          break label60;
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        paramBundle = localIntent;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      setContentView(new LinearLayout(this));
      label16:
      this.mRuntime = null;
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.a) {
      BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.post(this);
    }
  }
  
  public void run()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources();
    SetSplashImpl.a(this);
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InstallActivity
 * JD-Core Version:    0.7.0.1
 */