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
import com.tencent.token.by;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cq;
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
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1008: 
        if (paramAnonymousMessage.arg1 == 0)
        {
          StartPwdGestureModifyActivity.this.dismissDialog();
          paramAnonymousMessage = cq.a().e();
          if (paramAnonymousMessage == null)
          {
            bu.a().a(System.currentTimeMillis(), 23);
            StartPwdGestureModifyActivity.this.showNobindingAlert(StartPwdGestureModifyActivity.this, 2131231099, 2131231101);
            return;
          }
          StartPwdGestureModifyActivity.this.dismissDialog();
          by.a(StartPwdGestureModifyActivity.this.getApplicationContext()).a(StartPwdGestureModifyActivity.this, 523005419L, StartPwdGestureModifyActivity.this.mHandler, paramAnonymousMessage.mRealUin + "");
          return;
        }
        StartPwdGestureModifyActivity.this.dismissDialog();
        paramAnonymousMessage = (e)paramAnonymousMessage.obj;
        StartPwdGestureModifyActivity.this.showUserDialog(paramAnonymousMessage.c);
        return;
      case 4104: 
        StartPwdGestureModifyActivity.this.dismissDialog();
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
        {
          StartPwdGestureModifyActivity.this.showToast(StartPwdGestureModifyActivity.this.getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("exception"));
          return;
        }
        StartPwdGestureModifyActivity.this.showToast(2131231411);
        return;
      }
      StartPwdGestureModifyActivity.this.judgeNextStep();
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
    QQUser localQQUser = cq.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L))
    {
      ca.a().b(this.mHandler);
      showProDialog(this, 2131230843, 2131231298, null);
      return;
    }
    by.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
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
        g.b("Detected: " + StartPwdGestureModifyActivity.this.mLockPatternView.getPatternString());
        if (StartPwdGestureModifyActivity.this.mModifyStage == 1)
        {
          if (paramAnonymousList.size() < 3)
          {
            StartPwdGestureModifyActivity.this.mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            StartPwdGestureModifyActivity.this.mSmallView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            StartPwdGestureModifyActivity.this.showPromtMsg(2131231111, true);
            StartPwdGestureModifyActivity.this.mLockPatternView.b();
            StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
            return;
          }
          StartPwdGestureModifyActivity.this.showPromtMsg(2131231105, false);
          StartPwdGestureModifyActivity.this.mLockPatternView.b();
          StartPwdGestureModifyActivity.access$602(StartPwdGestureModifyActivity.this, 2);
          StartPwdGestureModifyActivity.access$902(StartPwdGestureModifyActivity.this, StartPwdGestureModifyActivity.this.mLockPatternView.getPatternString());
          StartPwdGestureModifyActivity.this.mSmallView.b = 2;
          StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
          return;
        }
        if (!StartPwdGestureModifyActivity.this.mLockPatternView.getPatternString().equals(StartPwdGestureModifyActivity.this.mStage1String))
        {
          StartPwdGestureModifyActivity.this.mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
          StartPwdGestureModifyActivity.this.showPromtMsg(2131231109, true);
          StartPwdGestureModifyActivity.this.mLockPatternView.b();
          StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mClearView, 1000L);
          return;
        }
        StartPwdGestureModifyActivity.this.showPromtMsg(2131231108, false);
        StartPwdGestureModifyActivity.this.mLockPatternView.b();
        StartPwdGestureModifyActivity.this.mSmallView.b = 3;
        StartPwdGestureModifyActivity.this.mSmallView.b(paramAnonymousList);
        cc.a().b(StartPwdGestureModifyActivity.this, StartPwdGestureModifyActivity.this.mStage1String);
        StartPwdGestureModifyActivity.this.mLockPatternView.postDelayed(StartPwdGestureModifyActivity.this.mFinishTask, 1000L);
      }
    });
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131493039));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131493053));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837617));
    this.mTitleText.setTextColor(getResources().getColor(2131493027));
  }
  
  private void judgeNextStep()
  {
    dismissDialog();
    bu.a().a(System.currentTimeMillis(), 25);
    cc.a().a(this);
    RqdApplication.i();
    l.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cc.a().a(this, 0);
    if (this.mVV != null) {
      this.mVV.d();
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
          StartPwdGestureModifyActivity.this.setResult(35);
          StartPwdGestureModifyActivity.this.finish();
        }
      }, null);
    }
  }
  
  private void showPromtMsg(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mPromtMsg.setTextColor(getResources().getColor(2131493044));
    }
    for (;;)
    {
      this.mPromtMsg.setText(paramInt);
      return;
      this.mPromtMsg.setTextColor(getResources().getColor(2131493043));
    }
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
    g.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 256) && (paramInt2 == 257)) {
      if (this.mVV != null) {
        this.mVV.d();
      }
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
    setContentView(2130968768);
    if (cc.a().c())
    {
      ((ViewStub)findViewById(2131559319)).inflate();
      this.mVV = ((LockPatternVerifyView)findViewById(2131559463));
      this.mVV.setAnimType(1);
      this.mModifyMode = true;
      this.mVV.setVerifyListener(new LockPatternVerifyView.b()
      {
        public void a() {}
        
        public void a(boolean paramAnonymousBoolean)
        {
          StartPwdGestureModifyActivity.this.showUserDialog(2131230843, StartPwdGestureModifyActivity.this.getResources().getString(2131231116), 2131230897, new DialogInterface.OnClickListener()
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
    this.mLockPatternView = ((LockPatternView)findViewById(2131559286));
    this.mSmallView = ((LockPatternSmallView)findViewById(2131559284));
    this.mPromtMsg = ((TextView)findViewById(2131559285));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureModifyActivity
 * JD-Core Version:    0.7.0.1
 */