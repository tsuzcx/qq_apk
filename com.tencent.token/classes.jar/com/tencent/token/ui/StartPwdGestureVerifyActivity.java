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
import com.tencent.token.bv;
import com.tencent.token.bz;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
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
      int i = paramAnonymousMessage.what;
      Object localObject1;
      Object localObject2;
      if (i != 1008)
      {
        if (i != 4104)
        {
          if (i != 4109) {
            return;
          }
          StartPwdGestureVerifyActivity.this.judgeNextStep();
          return;
        }
        StartPwdGestureVerifyActivity.this.dismissDialog();
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
        {
          localObject1 = StartPwdGestureVerifyActivity.this;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(StartPwdGestureVerifyActivity.this.getResources().getString(2131493553));
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
          ((StartPwdGestureVerifyActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
          return;
        }
        StartPwdGestureVerifyActivity.this.showToast(2131493553);
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        paramAnonymousMessage = cr.a().e();
        if (paramAnonymousMessage == null)
        {
          StartPwdGestureVerifyActivity.this.dismissDialog();
          if (StartPwdGestureVerifyActivity.this.mActivityType == 1)
          {
            paramAnonymousMessage = StartPwdGestureVerifyActivity.this;
            paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493242, 2131493236);
            return;
          }
          paramAnonymousMessage = StartPwdGestureVerifyActivity.this;
          paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493241, 2131493243);
          return;
        }
        StartPwdGestureVerifyActivity.this.dismissDialog();
        localObject1 = bz.a(StartPwdGestureVerifyActivity.this.getApplicationContext());
        localObject2 = StartPwdGestureVerifyActivity.this;
        Handler localHandler = ((StartPwdGestureVerifyActivity)localObject2).mHandler;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousMessage.mRealUin);
        localStringBuilder.append("");
        ((bz)localObject1).a((Activity)localObject2, 523005419L, localHandler, localStringBuilder.toString());
        return;
      }
      StartPwdGestureVerifyActivity.this.dismissDialog();
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      StartPwdGestureVerifyActivity.this.showUserDialog(paramAnonymousMessage.c);
    }
  };
  LockPatternVerifyView mView;
  
  private void gotoQuickLoginWb()
  {
    try
    {
      QQUser localQQUser = cr.a().e();
      if ((localQQUser != null) && (localQQUser.mRealUin > 0L))
      {
        bz localbz = bz.a(getApplicationContext());
        Handler localHandler = this.mHandler;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localQQUser.b());
        localbz.a(this, 523005419L, localHandler, localStringBuilder.toString());
        return;
      }
      bv.a().e(this.mHandler);
      showProDialog(this, 2131492985, 2131493440, null);
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
    cd.a().a(this);
    RqdApplication.i();
    l.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cd.a().a(this, 0);
    int i = this.mActivityType;
    if (i == 2)
    {
      setResult(35);
      finish();
      return;
    }
    if (i == 1)
    {
      setResult(35);
      finish();
      return;
    }
    if (i == 4) {
      return;
    }
    Intent localIntent;
    if (i == 5)
    {
      localIntent = new Intent(this, FaceChangePwdIndexActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.setFlags(67108864);
      bu.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      return;
    }
    if (i == 6)
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
    if (!cd.a().c())
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
      showUserDialog(2131492985, getString(paramInt1), paramInt2, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          cd.a().a(paramContext);
          RqdApplication.i();
        }
      }, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          cd.a().a(paramContext);
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
    showUserDialog(2131492985, getString(2131493249), 2131493238, 2131493285, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      if (paramKeyEvent.getAction() == 0)
      {
        if (i != 4) {
          return true;
        }
        if (RqdApplication.g())
        {
          exitToken();
          return true;
        }
        setResult(0);
        finish();
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchKeyEvent exception ");
      localStringBuilder.append(this);
      localStringBuilder.append(paramKeyEvent.toString());
      g.d(localStringBuilder.toString());
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      bz.a(getApplicationContext()).a(paramIntent);
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
          localStartPwdGestureVerifyActivity = StartPwdGestureVerifyActivity.this;
          localStartPwdGestureVerifyActivity.mActivityType = 3;
          localStartPwdGestureVerifyActivity.gotoQuickLoginWb();
          return;
        }
        StartPwdGestureVerifyActivity localStartPwdGestureVerifyActivity = StartPwdGestureVerifyActivity.this;
        localStartPwdGestureVerifyActivity.showUserDialog(2131492985, localStartPwdGestureVerifyActivity.getResources().getString(2131493258), 2131493039, new DialogInterface.OnClickListener()
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
    m.a(this, this.mTitleBar, 2130968773);
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
    if (!cd.a().c())
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