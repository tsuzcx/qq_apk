package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.LockPatternSmallView;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.LockPatternView;
import com.tencent.token.utils.w;

public class StartPwdGestureModifyActivity
  extends BaseActivity
{
  public static final int MODIFY_STAGE_1 = 1;
  public static final int MODIFY_STAGE_2 = 2;
  public static final int MODIFY_STAGE_3 = 3;
  public static final int RIGHT_FINISH_DELAY = 1000;
  public static final int WRONG_PATTERN_DELAY = 1000;
  private int mActivityType;
  protected Runnable mClearView = new aaa(this);
  protected Runnable mFinishTask = new aab(this);
  private Handler mHandler = new zz(this);
  private LockPatternView mLockPatternView;
  private boolean mModifyMode = false;
  private int mModifyStage = 1;
  private TextView mPromtMsg;
  private LockPatternSmallView mSmallView;
  private String mStage1String;
  LockPatternVerifyView mVV;
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L))
    {
      cw.a().b(this.mHandler);
      showProDialog(this, 2131230843, 2131231298, null);
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void initUI()
  {
    this.mSmallView.a(this.mLockPatternView);
    this.mLockPatternView.setOnPatternListener(new aae(this));
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131493039));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131493053));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837617));
    this.mTitleText.setTextColor(getResources().getColor(2131493027));
  }
  
  private void judgeNextStep()
  {
    dismissDialog();
    ch.a().a(System.currentTimeMillis(), 25);
    cy.a().a(this);
    RqdApplication.i();
    w.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cy.a().a(this, 0);
    if (this.mVV != null) {
      this.mVV.d();
    }
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, 2131230886, new aaf(this, paramContext), null);
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
      w.a(this, 0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    h.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 256) && (paramInt2 == 257)) {
      if (this.mVV != null) {
        this.mVV.d();
      }
    }
    while ((paramInt1 != 1201) && (paramInt1 != 1202)) {
      return;
    }
    cp.a(getApplicationContext()).a(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130968768);
    if (cy.a().c())
    {
      ((ViewStub)findViewById(2131559318)).inflate();
      this.mVV = ((LockPatternVerifyView)findViewById(2131559462));
      this.mVV.setAnimType(1);
      this.mModifyMode = true;
      this.mVV.setVerifyListener(new aac(this));
    }
    this.mLockPatternView = ((LockPatternView)findViewById(2131559285));
    this.mSmallView = ((LockPatternSmallView)findViewById(2131559283));
    this.mPromtMsg = ((TextView)findViewById(2131559284));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureModifyActivity
 * JD-Core Version:    0.7.0.1
 */