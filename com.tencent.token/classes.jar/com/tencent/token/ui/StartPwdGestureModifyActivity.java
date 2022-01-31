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
import com.tencent.token.ah;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.LockPatternSmallView;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.LockPatternView;
import com.tencent.token.utils.s;

public class StartPwdGestureModifyActivity
  extends BaseActivity
{
  public static final int MODIFY_STAGE_1 = 1;
  public static final int MODIFY_STAGE_2 = 2;
  public static final int MODIFY_STAGE_3 = 3;
  public static final int RIGHT_FINISH_DELAY = 1000;
  public static final int WRONG_PATTERN_DELAY = 1000;
  protected Runnable mClearView = new abu(this);
  protected Runnable mFinishTask = new abv(this);
  private Handler mHandler = new abt(this);
  protected boolean mIsNewPwdPage = false;
  private LockPatternView mLockPatternView;
  private boolean mModifyMode = false;
  private int mModifyStage = 1;
  private TextView mPromtMsg;
  private LockPatternSmallView mSmallView;
  private String mStage1String;
  LockPatternVerifyView mVV;
  
  private void initUI()
  {
    this.mSmallView.a(this.mLockPatternView);
    this.mLockPatternView.a(new abz(this));
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165236));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131165298));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837537));
    this.mTitleText.setTextColor(getResources().getColor(2131165297));
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131361808, getString(paramInt1), paramInt2, 2131361804, new aca(this, paramContext), null);
    }
  }
  
  private void showPromtMsg(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mPromtMsg.setTextColor(getResources().getColor(2131165241));
    }
    for (;;)
    {
      this.mPromtMsg.setText(paramInt);
      return;
      this.mPromtMsg.setTextColor(getResources().getColor(2131165237));
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.mModifyMode) {
      s.a(this, 0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 256) && (paramInt2 == 257) && (this.mVV != null)) {
      this.mVV.f();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130903206);
    if (ah.a().c())
    {
      ((ViewStub)findViewById(2131297157)).inflate();
      this.mVV = ((LockPatternVerifyView)findViewById(2131297301));
      this.mVV.a(1);
      this.mModifyMode = true;
      this.mVV.a(new abw(this));
    }
    this.mLockPatternView = ((LockPatternView)findViewById(2131297124));
    this.mSmallView = ((LockPatternSmallView)findViewById(2131297122));
    this.mPromtMsg = ((TextView)findViewById(2131297123));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureModifyActivity
 * JD-Core Version:    0.7.0.1
 */