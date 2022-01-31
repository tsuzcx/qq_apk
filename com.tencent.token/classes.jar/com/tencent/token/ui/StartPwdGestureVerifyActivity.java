package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

public class StartPwdGestureVerifyActivity
  extends BaseActivity
{
  public static final int K_ACTIVITY_TYPE_DELETE = 1;
  public static final int K_ACTIVITY_TYPE_MODIFY = 2;
  public static final int K_ACTIVITY_TYPE_NORMAL = 0;
  public static final int K_ACTIVITY_TYPE_RETRY_LIMIT = 3;
  public static final int K_ACTIVITY_TYPE_VRY_MOBILE = 6;
  public static final int K_ACTIVITY_TYPE_VRY_ORIGINAL = 4;
  public static final int K_ACTIVITY_TYPE_VRY_PSW = 5;
  public static final int K_VERIFY2FORGET_REQUEST = 256;
  public static final int K_VERIFY2FORGET_RESPONSE = 257;
  public int mActivityType = 0;
  private Handler mHandler = new aaj(this);
  LockPatternVerifyView mView;
  
  private void gotoQuickLoginWb()
  {
    try
    {
      QQUser localQQUser = do.a().e();
      if ((localQQUser == null) || (localQQUser.mRealUin <= 0L))
      {
        cw.a().b(this.mHandler);
        showProDialog(this, 2131230843, 2131231298, null);
        return;
      }
      cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void judgeNextStep()
  {
    dismissDialog();
    ch.a().a(System.currentTimeMillis(), 25);
    cy.a().a(this);
    RqdApplication.i();
    w.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cy.a().a(this, 0);
    if (this.mActivityType == 2)
    {
      setResult(35);
      finish();
    }
    do
    {
      return;
      if (this.mActivityType == 1)
      {
        setResult(35);
        finish();
        return;
      }
    } while (this.mActivityType == 4);
    Intent localIntent;
    if (this.mActivityType == 5)
    {
      localIntent = new Intent(this, FaceChangePwdIndexActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.setFlags(67108864);
      ch.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      return;
    }
    if (this.mActivityType == 6)
    {
      localIntent = new Intent(this, FaceChangeMobileActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.setFlags(67108864);
      ch.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      finish();
      return;
    }
    RqdApplication.d();
    if (!cy.a().c())
    {
      showOldPwdDeletedAlert();
      return;
    }
    setResult(35);
    finish();
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, new aam(this, paramContext), new aan(this, paramContext));
    }
  }
  
  private void showOldPwdDeletedAlert()
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(2131230843, getString(2131231107), 2131231096, 2131231143, new aak(this), new aal(this));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      int i = paramKeyEvent.getKeyCode();
      if (paramKeyEvent.getAction() != 0) {
        break label92;
      }
      switch (i)
      {
      case 4: 
        if (RqdApplication.g())
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
      h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
      return true;
    }
    setResult(0);
    finish();
    return true;
    label92:
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    return bool;
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mView = new LockPatternVerifyView(this);
    setNeverShowLockVerifyView();
    setContentView(this.mView);
    hideTitle();
    ch.a().a(System.currentTimeMillis(), 17);
    this.mActivityType = getIntent().getIntExtra("startpwd_verify_source", 0);
    int i = getSharedPreferences("start_pwd_config", 0).getInt("is_set_start_pwd_show", 1);
    if ((this.mActivityType == 0) && (i == 0)) {
      this.mView.setPatternViewInStealthMode(true);
    }
    this.mView.setVerifyListener(new aao(this));
    x.a(this, this.mTitleBar, 2131493039);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mView.c();
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
    if (!cy.a().c())
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