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
import com.tencent.token.aay;
import com.tencent.token.ajr;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.so;
import com.tencent.token.sp;
import com.tencent.token.sp.a;
import com.tencent.token.ss;
import com.tencent.token.sw;
import com.tencent.token.tt;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.LockPatternVerifyView.b;
import com.tencent.token.xt;
import com.tencent.token.xv;

public class StartPwdGestureDeleteActivity
  extends BaseActivity
{
  private int mActivityType;
  private Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (StartPwdGestureDeleteActivity.this.isFinishing()) {
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
          StartPwdGestureDeleteActivity.this.judgeNextStep();
          return;
        }
        StartPwdGestureDeleteActivity.this.dismissDialog();
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
        {
          localObject1 = StartPwdGestureDeleteActivity.this;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(StartPwdGestureDeleteActivity.this.getResources().getString(2131493563));
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
          ((StartPwdGestureDeleteActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
          return;
        }
        StartPwdGestureDeleteActivity.this.showToast(2131493563);
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        StartPwdGestureDeleteActivity.this.dismissDialog();
        paramAnonymousMessage = tt.a().k.b();
        if (paramAnonymousMessage == null)
        {
          so.a().a(System.currentTimeMillis(), 23);
          paramAnonymousMessage = StartPwdGestureDeleteActivity.this;
          paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493245, 2131493239);
          return;
        }
        StartPwdGestureDeleteActivity.this.dismissDialog();
        localObject1 = ss.a(StartPwdGestureDeleteActivity.this.getApplicationContext());
        localObject2 = StartPwdGestureDeleteActivity.this;
        Handler localHandler = ((StartPwdGestureDeleteActivity)localObject2).mHandler;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousMessage.mRealUin);
        ((ss)localObject1).a((Activity)localObject2, localHandler, localStringBuilder.toString());
        return;
      }
      StartPwdGestureDeleteActivity.this.dismissDialog();
      paramAnonymousMessage = (xt)paramAnonymousMessage.obj;
      StartPwdGestureDeleteActivity.this.showUserDialog(paramAnonymousMessage.c);
    }
  };
  private LockPatternVerifyView.b mListener = new LockPatternVerifyView.b()
  {
    public final void a()
    {
      sw.a().e();
      StartPwdGestureDeleteActivity.this.setResult(257);
      SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("start_pwd_config", 0).edit();
      localEditor.clear();
      localEditor.commit();
      if (!sw.a().c()) {
        StartPwdGestureDeleteActivity.this.pwdIsDelete();
      }
    }
    
    public final void a(boolean paramAnonymousBoolean)
    {
      StartPwdGestureDeleteActivity localStartPwdGestureDeleteActivity = StartPwdGestureDeleteActivity.this;
      localStartPwdGestureDeleteActivity.showUserDialog(2131492987, localStartPwdGestureDeleteActivity.getResources().getString(2131493261), 2131493041, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          StartPwdGestureDeleteActivity.access$302(StartPwdGestureDeleteActivity.this, 3);
          StartPwdGestureDeleteActivity.this.gotoQuickLoginWb();
        }
      });
    }
    
    public final void b()
    {
      StartPwdGestureDeleteActivity.access$302(StartPwdGestureDeleteActivity.this, 1);
      StartPwdGestureDeleteActivity.this.gotoQuickLoginWb();
    }
  };
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = tt.a().k.b();
    if ((localQQUser != null) && (localQQUser.mRealUin > 0L))
    {
      ss localss = ss.a(getApplicationContext());
      Handler localHandler = this.mHandler;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQUser.mRealUin);
      localss.a(this, localHandler, localStringBuilder.toString());
      return;
    }
    sp.a.a().b(this.mHandler);
    showProDialog(this, 2131492987, 2131493449, null);
  }
  
  private void judgeNextStep()
  {
    dismissDialog();
    sw.a().e();
    RqdApplication.l();
    aay.a(FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    sw.a();
    sw.a(0);
    setResult(257);
    SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("start_pwd_config", 0).edit();
    localEditor.clear();
    localEditor.commit();
    if (!sw.a().c()) {
      pwdIsDelete();
    }
  }
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131492987, getString(paramInt1), paramInt2, 2131493030, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          sw.a().e();
          RqdApplication.l();
          StartPwdGestureDeleteActivity.this.setResult(35);
          StartPwdGestureDeleteActivity.this.finish();
        }
      }, null);
    }
  }
  
  public void finish()
  {
    super.finish();
    aay.a(this, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("verify gesture: resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", requestCode=");
    localStringBuilder.append(paramInt1);
    xv.c(localStringBuilder.toString());
    if ((paramInt1 == 256) && (paramInt2 == 257))
    {
      setResult(35);
      finish();
      return;
    }
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      ss.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2131296461);
    ((ViewStub)findViewById(2131166323)).inflate();
    paramBundle = (LockPatternVerifyView)findViewById(2131165739);
    paramBundle.setVerifyListener(this.mListener);
    paramBundle.setAnimType(2);
    this.mTitleBar.setBackgroundColor(getResources().getColor(2130968774));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2130968790));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2131099762));
    this.mTitleText.setTextColor(getResources().getColor(2130968762));
  }
  
  public void pwdIsDelete()
  {
    setResult(257);
    new Handler().post(new Runnable()
    {
      public final void run()
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