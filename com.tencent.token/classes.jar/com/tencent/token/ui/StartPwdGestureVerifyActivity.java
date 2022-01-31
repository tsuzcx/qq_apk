package com.tencent.token.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.token.ah;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.LockPatternVerifyView;

public class StartPwdGestureVerifyActivity
  extends BaseActivity
{
  public static final int K_ACTIVITY_TYPE_DELETE = 1;
  public static final int K_ACTIVITY_TYPE_MODIFY = 2;
  public static final int K_ACTIVITY_TYPE_NORMAL = 0;
  public static final int K_ACTIVITY_TYPE_RETRY_LIMIT = 3;
  public static final int K_ACTIVITY_TYPE_VRY_ORIGINAL = 4;
  public static final int K_ACTIVITY_TYPE_VRY_PSW = 5;
  public static final int K_VERIFY2FORGET_REQUEST = 256;
  public static final int K_VERIFY2FORGET_RESPONSE = 257;
  public int mActivityType = 0;
  LockPatternVerifyView mView;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      int i = paramKeyEvent.getKeyCode();
      if (paramKeyEvent.getAction() != 0) {
        break label91;
      }
      switch (i)
      {
      case 4: 
        if (RqdApplication.d())
        {
          exitToken();
          return true;
        }
        break;
      }
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
      return true;
    }
    setResult(0);
    finish();
    return true;
    label91:
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    return bool;
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 256) && (paramInt2 == 257))
    {
      setResult(35);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mView = new LockPatternVerifyView(this);
    setNeverShowLockVerifyView();
    setContentView(this.mView);
    hideTitle();
    p.a().a(System.currentTimeMillis(), 17);
    this.mActivityType = getIntent().getIntExtra("startpwd_verify_source", 0);
    int i = getSharedPreferences("start_pwd_config", 0).getInt("is_set_start_pwd_show", 1);
    if ((this.mActivityType == 0) && (i == 0)) {
      this.mView.d();
    }
    this.mView.a(new ace(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mView.e();
  }
  
  public void onPause()
  {
    super.onPause();
    RqdApplication.b = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    RqdApplication.b = true;
    if (!ah.a().c())
    {
      setResult(35);
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureVerifyActivity
 * JD-Core Version:    0.7.0.1
 */