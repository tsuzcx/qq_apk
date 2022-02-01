package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.bu;
import com.tencent.token.bv;
import com.tencent.token.bz;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.LockPatternSmallView;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.LockPatternVerifyView.b;
import com.tencent.token.ui.base.LockPatternView;
import com.tencent.token.ui.base.LockPatternView.DisplayMode;
import com.tencent.token.ui.base.LockPatternView.a;
import com.tencent.token.ui.base.LockPatternView.b;
import com.tencent.token.utils.l;
import java.util.List;

public class StartPwdGestureModifyActivity
  extends BaseActivity
{
  public static final int MODIFY_STAGE_1 = 1;
  public static final int MODIFY_STAGE_2 = 2;
  public static final int MODIFY_STAGE_3 = 3;
  public static final int RIGHT_FINISH_DELAY = 1000;
  public static final int WRONG_PATTERN_DELAY = 1000;
  private int mActivityType;
  protected Runnable mClearView = new Runnable()
  {
    public void run()
    {
      StartPwdGestureModifyActivity.this.mLockPatternView.a();
      StartPwdGestureModifyActivity.this.mLockPatternView.c();
    }
  };
  protected Runnable mFinishTask = new Runnable()
  {
    public void run()
    {
      StartPwdGestureModifyActivity.this.setResult(259);
      StartPwdGestureModifyActivity.this.finish();
    }
  };
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (StartPwdGestureModifyActivity.this.isFinishing()) {
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
          StartPwdGestureModifyActivity.this.judgeNextStep();
          return;
        }
        StartPwdGestureModifyActivity.this.dismissDialog();
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
        {
          localObject1 = StartPwdGestureModifyActivity.this;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(StartPwdGestureModifyActivity.this.getResources().getString(2131493553));
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
          ((StartPwdGestureModifyActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
          return;
        }
        StartPwdGestureModifyActivity.this.showToast(2131493553);
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        StartPwdGestureModifyActivity.this.dismissDialog();
        paramAnonymousMessage = cr.a().e();
        if (paramAnonymousMessage == null)
        {
          bu.a().a(System.currentTimeMillis(), 23);
          paramAnonymousMessage = StartPwdGestureModifyActivity.this;
          paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493241, 2131493243);
          return;
        }
        StartPwdGestureModifyActivity.this.dismissDialog();
        localObject1 = bz.a(StartPwdGestureModifyActivity.this.getApplicationContext());
        localObject2 = StartPwdGestureModifyActivity.this;
        Handler localHandler = ((StartPwdGestureModifyActivity)localObject2).mHandler;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousMessage.mRealUin);
        localStringBuilder.append("");
        ((bz)localObject1).a((Activity)localObject2, 523005419L, localHandler, localStringBuilder.toString());
        return;
      }
      StartPwdGestureModifyActivity.this.dismissDialog();
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      StartPwdGestureModifyActivity.this.showUserDialog(paramAnonymousMessage.c);
    }
  };
  private LockPatternView mLockPatternView;
  private boolean mModifyMode = false;
  private int mModifyStage = 1;
  private TextView mPromtMsg;
  private LockPatternSmallView mSmallView;
  private String mStage1String;
  LockPatternVerifyView mVV;
  
  private void gotoQuickLoginWb()
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
  }
  
  private void initUI()
  {
    this.mSmallView.a(this.mLockPatternView);
    this.mLockPatternView.setOnPatternListener(new LockPatternView.b()
    {
      public void a()
      {
        g.b("RESULT_START");
        StartPwdGestureModifyActivity.this.mLockPatternView.removeCallbacks(StartPwdGestureModifyActivity.this.mClearView);
      }
      
      public void a(List<LockPatternView.a> paramAnonymousList)
      {
        g.b("CellAdded");
      }
      
      public void b()
      {
        g.b("CLEARED");
      }
      
      public void b(List<LockPatternView.a> paramAnonymousList)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Detected: ");
        ((StringBuilder)localObject).append(StartPwdGestureModifyActivity.this.mLockPatternView.getPatternString());
        g.b(((StringBuilder)localObject).toString());
        if (StartPwdGestureModifyActivity.this.mModifyStage == 1)
        {
          if (paramAnonymousList.size() < 3)
          {
            StartPwdGestureModifyActivity.this.mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            StartPwdGestureModifyActivity.this.mSmallView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            StartPwdGestureModifyActivity.this.showPromtMsg(2131493253, true);
            StartPwdGestureModifyActivity.this.mLockPatternView.b();
            StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
            return;
          }
          StartPwdGestureModifyActivity.this.showPromtMsg(2131493247, false);
          StartPwdGestureModifyActivity.this.mLockPatternView.b();
          StartPwdGestureModifyActivity.access$602(StartPwdGestureModifyActivity.this, 2);
          paramAnonymousList = StartPwdGestureModifyActivity.this;
          StartPwdGestureModifyActivity.access$902(paramAnonymousList, paramAnonymousList.mLockPatternView.getPatternString());
          StartPwdGestureModifyActivity.this.mSmallView.b = 2;
          StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
          return;
        }
        if (!StartPwdGestureModifyActivity.this.mLockPatternView.getPatternString().equals(StartPwdGestureModifyActivity.this.mStage1String))
        {
          StartPwdGestureModifyActivity.this.mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
          StartPwdGestureModifyActivity.this.showPromtMsg(2131493251, true);
          StartPwdGestureModifyActivity.this.mLockPatternView.b();
          StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
          return;
        }
        StartPwdGestureModifyActivity.this.showPromtMsg(2131493250, false);
        StartPwdGestureModifyActivity.this.mLockPatternView.b();
        StartPwdGestureModifyActivity.this.mSmallView.b = 3;
        StartPwdGestureModifyActivity.this.mSmallView.b(paramAnonymousList);
        paramAnonymousList = cd.a();
        localObject = StartPwdGestureModifyActivity.this;
        paramAnonymousList.b((Context)localObject, ((StartPwdGestureModifyActivity)localObject).mStage1String);
        StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mFinishTask, 1000L);
      }
    });
    this.mTitleBar.setBackgroundColor(getResources().getColor(2130968773));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2130968789));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2131099762));
    this.mTitleText.setTextColor(getResources().getColor(2130968761));
  }
  
  private void judgeNextStep()
  {
    dismissDialog();
    bu.a().a(System.currentTimeMillis(), 25);
    cd.a().a(this);
    RqdApplication.i();
    l.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cd.a().a(this, 0);
    LockPatternVerifyView localLockPatternVerifyView = this.mVV;
    if (localLockPatternVerifyView != null) {
      localLockPatternVerifyView.d();
    }
  }
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131492985, getString(paramInt1), paramInt2, 2131493028, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          cd.a().a(paramContext);
          RqdApplication.i();
          StartPwdGestureModifyActivity.this.setResult(35);
          StartPwdGestureModifyActivity.this.finish();
        }
      }, null);
    }
  }
  
  private void showPromtMsg(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mPromtMsg.setTextColor(getResources().getColor(2130968778));
    } else {
      this.mPromtMsg.setTextColor(getResources().getColor(2130968777));
    }
    this.mPromtMsg.setText(paramInt);
  }
  
  public void finish()
  {
    super.finish();
    if (this.mModifyMode) {
      l.a(this, 0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("verify gesture: resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", requestCode=");
    localStringBuilder.append(paramInt1);
    g.c(localStringBuilder.toString());
    if ((paramInt1 == 256) && (paramInt2 == 257))
    {
      paramIntent = this.mVV;
      if (paramIntent != null) {
        paramIntent.d();
      }
    }
    else if ((paramInt1 == 1201) || (paramInt1 == 1202))
    {
      bz.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2131296449);
    if (cd.a().c())
    {
      ((ViewStub)findViewById(2131166266)).inflate();
      this.mVV = ((LockPatternVerifyView)findViewById(2131165716));
      this.mVV.setAnimType(1);
      this.mModifyMode = true;
      this.mVV.setVerifyListener(new LockPatternVerifyView.b()
      {
        public void a() {}
        
        public void a(boolean paramAnonymousBoolean)
        {
          StartPwdGestureModifyActivity localStartPwdGestureModifyActivity = StartPwdGestureModifyActivity.this;
          localStartPwdGestureModifyActivity.showUserDialog(2131492985, localStartPwdGestureModifyActivity.getResources().getString(2131493258), 2131493039, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              StartPwdGestureModifyActivity.access$402(StartPwdGestureModifyActivity.this, 3);
              StartPwdGestureModifyActivity.this.gotoQuickLoginWb();
            }
          });
        }
        
        public void b()
        {
          StartPwdGestureModifyActivity.access$402(StartPwdGestureModifyActivity.this, 2);
          StartPwdGestureModifyActivity.this.gotoQuickLoginWb();
        }
      });
    }
    this.mLockPatternView = ((LockPatternView)findViewById(2131166249));
    this.mSmallView = ((LockPatternSmallView)findViewById(2131166248));
    this.mPromtMsg = ((TextView)findViewById(2131166250));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureModifyActivity
 * JD-Core Version:    0.7.0.1
 */