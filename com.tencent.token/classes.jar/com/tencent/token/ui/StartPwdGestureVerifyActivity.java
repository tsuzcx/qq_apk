package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.token.bu;
import com.tencent.token.by;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cq;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.LockPatternVerifyView.b;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;

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
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (StartPwdGestureVerifyActivity.this.isFinishing()) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1008: 
        if (paramAnonymousMessage.arg1 == 0)
        {
          paramAnonymousMessage = cq.a().e();
          if (paramAnonymousMessage == null)
          {
            StartPwdGestureVerifyActivity.this.dismissDialog();
            if (StartPwdGestureVerifyActivity.this.mActivityType == 1)
            {
              StartPwdGestureVerifyActivity.this.showNobindingAlert(StartPwdGestureVerifyActivity.this, 2131231100, 2131231094);
              return;
            }
            StartPwdGestureVerifyActivity.this.showNobindingAlert(StartPwdGestureVerifyActivity.this, 2131231099, 2131231101);
            return;
          }
          StartPwdGestureVerifyActivity.this.dismissDialog();
          by.a(StartPwdGestureVerifyActivity.this.getApplicationContext()).a(StartPwdGestureVerifyActivity.this, 523005419L, StartPwdGestureVerifyActivity.this.mHandler, paramAnonymousMessage.mRealUin + "");
          return;
        }
        StartPwdGestureVerifyActivity.this.dismissDialog();
        paramAnonymousMessage = (e)paramAnonymousMessage.obj;
        StartPwdGestureVerifyActivity.this.showUserDialog(paramAnonymousMessage.c);
        return;
      case 4109: 
        StartPwdGestureVerifyActivity.this.judgeNextStep();
        return;
      }
      StartPwdGestureVerifyActivity.this.dismissDialog();
      if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
      {
        StartPwdGestureVerifyActivity.this.showToast(StartPwdGestureVerifyActivity.this.getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("exception"));
        return;
      }
      StartPwdGestureVerifyActivity.this.showToast(2131231411);
    }
  };
  LockPatternVerifyView mView;
  
  private void gotoQuickLoginWb()
  {
    try
    {
      QQUser localQQUser = cq.a().e();
      if ((localQQUser == null) || (localQQUser.mRealUin <= 0L))
      {
        ca.a().b(this.mHandler);
        showProDialog(this, 2131230843, 2131231298, null);
        return;
      }
      by.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
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
    bu.a().a(System.currentTimeMillis(), 25);
    cc.a().a(this);
    RqdApplication.i();
    l.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cc.a().a(this, 0);
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
      bu.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      return;
    }
    if (this.mActivityType == 6)
    {
      localIntent = new Intent(this, FaceChangeMobileActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.setFlags(67108864);
      bu.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      finish();
      return;
    }
    RqdApplication.d();
    if (!cc.a().c())
    {
      showOldPwdDeletedAlert();
      return;
    }
    setResult(35);
    finish();
  }
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          cc.a().a(paramContext);
          RqdApplication.i();
        }
      }, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          cc.a().a(paramContext);
          RqdApplication.i();
          StartPwdGestureVerifyActivity.this.setResult(35);
          StartPwdGestureVerifyActivity.this.finish();
        }
      });
    }
  }
  
  private void showOldPwdDeletedAlert()
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(2131230843, getString(2131231107), 2131231096, 2131231143, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent(StartPwdGestureVerifyActivity.this, StartPwdGestureModifyActivity.class);
        StartPwdGestureVerifyActivity.this.startActivity(paramAnonymousDialogInterface);
        StartPwdGestureVerifyActivity.this.setResult(35);
        StartPwdGestureVerifyActivity.this.finish();
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        StartPwdGestureVerifyActivity.this.setResult(35);
        StartPwdGestureVerifyActivity.this.finish();
      }
    });
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
      g.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
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
      by.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mView = new LockPatternVerifyView(this);
    setNeverShowLockVerifyView();
    setContentView(this.mView);
    hideTitle();
    bu.a().a(System.currentTimeMillis(), 17);
    this.mActivityType = getIntent().getIntExtra("startpwd_verify_source", 0);
    int i = getSharedPreferences("start_pwd_config", 0).getInt("is_set_start_pwd_show", 1);
    if ((this.mActivityType == 0) && (i == 0)) {
      this.mView.setPatternViewInStealthMode(true);
    }
    this.mView.setVerifyListener(new LockPatternVerifyView.b()
    {
      public void a()
      {
        StartPwdGestureVerifyActivity.this.setResult(35);
        bu.a().a(System.currentTimeMillis(), 18);
        IndexActivity.need_query_dual_msg = true;
        StartPwdGestureVerifyActivity.this.finish();
      }
      
      public void a(boolean paramAnonymousBoolean)
      {
        g.a("verifyinit limit");
        if (paramAnonymousBoolean)
        {
          StartPwdGestureVerifyActivity.this.mActivityType = 3;
          StartPwdGestureVerifyActivity.this.gotoQuickLoginWb();
          return;
        }
        StartPwdGestureVerifyActivity.this.showUserDialog(2131230843, StartPwdGestureVerifyActivity.this.getResources().getString(2131231116), 2131230897, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            StartPwdGestureVerifyActivity.this.mActivityType = 3;
            StartPwdGestureVerifyActivity.this.gotoQuickLoginWb();
          }
        });
      }
      
      public void b()
      {
        StartPwdGestureVerifyActivity.this.gotoQuickLoginWb();
      }
    });
    m.a(this, this.mTitleBar, 2131493039);
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
    if (!cc.a().c())
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