package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
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

public class StartPwdGestureDeleteActivity
  extends BaseActivity
{
  private int mActivityType;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (StartPwdGestureDeleteActivity.this.isFinishing()) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1008: 
        if (paramAnonymousMessage.arg1 == 0)
        {
          StartPwdGestureDeleteActivity.this.dismissDialog();
          paramAnonymousMessage = cq.a().e();
          if (paramAnonymousMessage == null)
          {
            bu.a().a(System.currentTimeMillis(), 23);
            StartPwdGestureDeleteActivity.this.showNobindingAlert(StartPwdGestureDeleteActivity.this, 2131231100, 2131231094);
            return;
          }
          StartPwdGestureDeleteActivity.this.dismissDialog();
          by.a(StartPwdGestureDeleteActivity.this.getApplicationContext()).a(StartPwdGestureDeleteActivity.this, 523005419L, StartPwdGestureDeleteActivity.this.mHandler, paramAnonymousMessage.mRealUin + "");
          return;
        }
        StartPwdGestureDeleteActivity.this.dismissDialog();
        paramAnonymousMessage = (e)paramAnonymousMessage.obj;
        StartPwdGestureDeleteActivity.this.showUserDialog(paramAnonymousMessage.c);
        return;
      case 4104: 
        StartPwdGestureDeleteActivity.this.dismissDialog();
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
        {
          StartPwdGestureDeleteActivity.this.showToast(StartPwdGestureDeleteActivity.this.getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("exception"));
          return;
        }
        StartPwdGestureDeleteActivity.this.showToast(2131231411);
        return;
      }
      StartPwdGestureDeleteActivity.this.judgeNextStep();
    }
  };
  private LockPatternVerifyView.b mListener = new LockPatternVerifyView.b()
  {
    public void a()
    {
      cc.a().a(StartPwdGestureDeleteActivity.this);
      StartPwdGestureDeleteActivity.this.setResult(257);
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("start_pwd_config", 0).edit();
      localEditor.clear();
      localEditor.commit();
      if (!cc.a().c()) {
        StartPwdGestureDeleteActivity.this.pwdIsDelete();
      }
    }
    
    public void a(boolean paramAnonymousBoolean)
    {
      StartPwdGestureDeleteActivity.this.showUserDialog(2131230843, StartPwdGestureDeleteActivity.this.getResources().getString(2131231116), 2131230897, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          StartPwdGestureDeleteActivity.access$302(StartPwdGestureDeleteActivity.this, 3);
          StartPwdGestureDeleteActivity.this.gotoQuickLoginWb();
        }
      });
    }
    
    public void b()
    {
      StartPwdGestureDeleteActivity.access$302(StartPwdGestureDeleteActivity.this, 1);
      StartPwdGestureDeleteActivity.this.gotoQuickLoginWb();
    }
  };
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = cq.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L))
    {
      ca.a().b(this.mHandler);
      showProDialog(this, 2131230843, 2131231298, null);
      return;
    }
    by.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void judgeNextStep()
  {
    dismissDialog();
    cc.a().a(this);
    RqdApplication.i();
    l.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cc.a().a(this, 0);
    setResult(257);
    SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("start_pwd_config", 0).edit();
    localEditor.clear();
    localEditor.commit();
    if (!cc.a().c()) {
      pwdIsDelete();
    }
  }
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, 2131230886, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          cc.a().a(paramContext);
          RqdApplication.i();
          StartPwdGestureDeleteActivity.this.setResult(35);
          StartPwdGestureDeleteActivity.this.finish();
        }
      }, null);
    }
  }
  
  public void finish()
  {
    super.finish();
    l.a(this, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    g.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 256) && (paramInt2 == 257))
    {
      setResult(35);
      finish();
    }
    while ((paramInt1 != 1201) && (paramInt1 != 1202)) {
      return;
    }
    by.a(getApplicationContext()).a(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130968766);
    ((ViewStub)findViewById(2131559319)).inflate();
    paramBundle = (LockPatternVerifyView)findViewById(2131559463);
    paramBundle.setVerifyListener(this.mListener);
    paramBundle.setAnimType(2);
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131493039));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131493053));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837617));
    this.mTitleText.setTextColor(getResources().getColor(2131493027));
  }
  
  public void pwdIsDelete()
  {
    setResult(257);
    new Handler().post(new Runnable()
    {
      public void run()
      {
        StartPwdGestureDeleteActivity.this.finish();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureDeleteActivity
 * JD-Core Version:    0.7.0.1
 */