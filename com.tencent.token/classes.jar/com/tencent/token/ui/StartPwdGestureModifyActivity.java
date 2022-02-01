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
import com.tencent.token.aac;
import com.tencent.token.ahg;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.rt;
import com.tencent.token.ru;
import com.tencent.token.ru.a;
import com.tencent.token.ry;
import com.tencent.token.sc;
import com.tencent.token.sz;
import com.tencent.token.ui.base.LockPatternSmallView;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.LockPatternVerifyView.b;
import com.tencent.token.ui.base.LockPatternView;
import com.tencent.token.ui.base.LockPatternView.DisplayMode;
import com.tencent.token.ui.base.LockPatternView.a;
import com.tencent.token.ui.base.LockPatternView.b;
import com.tencent.token.wy;
import com.tencent.token.xa;
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
    public final void run()
    {
      StartPwdGestureModifyActivity.this.mLockPatternView.a();
      StartPwdGestureModifyActivity.this.mLockPatternView.c = true;
    }
  };
  protected Runnable mFinishTask = new Runnable()
  {
    public final void run()
    {
      StartPwdGestureModifyActivity.this.setResult(259);
      StartPwdGestureModifyActivity.this.finish();
    }
  };
  private Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
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
          ((StringBuilder)localObject2).append(StartPwdGestureModifyActivity.this.getResources().getString(2131493555));
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
          ((StartPwdGestureModifyActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
          return;
        }
        StartPwdGestureModifyActivity.this.showToast(2131493555);
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        StartPwdGestureModifyActivity.this.dismissDialog();
        paramAnonymousMessage = sz.a().k.b();
        if (paramAnonymousMessage == null)
        {
          rt.a().a(System.currentTimeMillis(), 23);
          paramAnonymousMessage = StartPwdGestureModifyActivity.this;
          paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493242, 2131493244);
          return;
        }
        StartPwdGestureModifyActivity.this.dismissDialog();
        localObject1 = ry.a(StartPwdGestureModifyActivity.this.getApplicationContext());
        localObject2 = StartPwdGestureModifyActivity.this;
        Handler localHandler = ((StartPwdGestureModifyActivity)localObject2).mHandler;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousMessage.mRealUin);
        ((ry)localObject1).a((Activity)localObject2, localHandler, localStringBuilder.toString());
        return;
      }
      StartPwdGestureModifyActivity.this.dismissDialog();
      paramAnonymousMessage = (wy)paramAnonymousMessage.obj;
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
    QQUser localQQUser = sz.a().k.b();
    if ((localQQUser != null) && (localQQUser.mRealUin > 0L))
    {
      ry localry = ry.a(getApplicationContext());
      Handler localHandler = this.mHandler;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQUser.mRealUin);
      localry.a(this, localHandler, localStringBuilder.toString());
      return;
    }
    ru.a.a().c(this.mHandler);
    showProDialog(this, 2131492986, 2131493441, null);
  }
  
  private void initUI()
  {
    LockPatternSmallView localLockPatternSmallView = this.mSmallView;
    LockPatternView localLockPatternView = this.mLockPatternView;
    localLockPatternSmallView.a = localLockPatternView;
    localLockPatternView.b = localLockPatternSmallView;
    localLockPatternView.setOnPatternListener(new LockPatternView.b()
    {
      public final void a()
      {
        xa.b("RESULT_START");
        StartPwdGestureModifyActivity.this.mLockPatternView.removeCallbacks(StartPwdGestureModifyActivity.this.mClearView);
      }
      
      public final void a(List<LockPatternView.a> paramAnonymousList)
      {
        StringBuilder localStringBuilder = new StringBuilder("Detected: ");
        localStringBuilder.append(StartPwdGestureModifyActivity.this.mLockPatternView.getPatternString());
        xa.b(localStringBuilder.toString());
        if (StartPwdGestureModifyActivity.this.mModifyStage == 1)
        {
          if (paramAnonymousList.size() < 3)
          {
            StartPwdGestureModifyActivity.this.mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            StartPwdGestureModifyActivity.this.mSmallView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            StartPwdGestureModifyActivity.this.showPromtMsg(2131493254, true);
            StartPwdGestureModifyActivity.this.mLockPatternView.c = false;
            StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
            return;
          }
          StartPwdGestureModifyActivity.this.showPromtMsg(2131493248, false);
          StartPwdGestureModifyActivity.this.mLockPatternView.c = false;
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
          StartPwdGestureModifyActivity.this.showPromtMsg(2131493252, true);
          StartPwdGestureModifyActivity.this.mLockPatternView.c = false;
          StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
          return;
        }
        StartPwdGestureModifyActivity.this.showPromtMsg(2131493251, false);
        StartPwdGestureModifyActivity.this.mLockPatternView.c = false;
        StartPwdGestureModifyActivity.this.mSmallView.b = 3;
        StartPwdGestureModifyActivity.this.mSmallView.a(paramAnonymousList);
        sc.a().c(StartPwdGestureModifyActivity.this.mStage1String);
        StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mFinishTask, 1000L);
      }
      
      public final void b()
      {
        xa.b("CLEARED");
      }
      
      public final void c()
      {
        xa.b("CellAdded");
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
    rt.a().a(System.currentTimeMillis(), 25);
    sc.a().e();
    RqdApplication.k();
    aac.a(FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    sc.a();
    sc.a(0);
    LockPatternVerifyView localLockPatternVerifyView = this.mVV;
    if (localLockPatternVerifyView != null) {
      localLockPatternVerifyView.d();
    }
  }
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131492986, getString(paramInt1), paramInt2, 2131493029, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          sc.a().e();
          RqdApplication.k();
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
      aac.a(this, 0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("verify gesture: resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", requestCode=");
    localStringBuilder.append(paramInt1);
    xa.c(localStringBuilder.toString());
    if ((paramInt1 == 256) && (paramInt2 == 257))
    {
      paramIntent = this.mVV;
      if (paramIntent != null) {
        paramIntent.d();
      }
    }
    else if ((paramInt1 == 1201) || (paramInt1 == 1202))
    {
      ry.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2131296450);
    if (sc.a().c())
    {
      ((ViewStub)findViewById(2131166281)).inflate();
      this.mVV = ((LockPatternVerifyView)findViewById(2131165722));
      this.mVV.setAnimType(1);
      this.mModifyMode = true;
      this.mVV.setVerifyListener(new LockPatternVerifyView.b()
      {
        public final void a() {}
        
        public final void a(boolean paramAnonymousBoolean)
        {
          StartPwdGestureModifyActivity localStartPwdGestureModifyActivity = StartPwdGestureModifyActivity.this;
          localStartPwdGestureModifyActivity.showUserDialog(2131492986, localStartPwdGestureModifyActivity.getResources().getString(2131493259), 2131493040, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              StartPwdGestureModifyActivity.access$402(StartPwdGestureModifyActivity.this, 3);
              StartPwdGestureModifyActivity.this.gotoQuickLoginWb();
            }
          });
        }
        
        public final void b()
        {
          StartPwdGestureModifyActivity.access$402(StartPwdGestureModifyActivity.this, 2);
          StartPwdGestureModifyActivity.this.gotoQuickLoginWb();
        }
      });
    }
    this.mLockPatternView = ((LockPatternView)findViewById(2131166264));
    this.mSmallView = ((LockPatternSmallView)findViewById(2131166263));
    this.mPromtMsg = ((TextView)findViewById(2131166265));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureModifyActivity
 * JD-Core Version:    0.7.0.1
 */