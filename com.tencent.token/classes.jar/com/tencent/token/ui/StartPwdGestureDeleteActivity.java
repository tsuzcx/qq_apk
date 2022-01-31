package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.LockPatternVerifyView;
import com.tencent.token.ui.base.bs;
import com.tencent.token.utils.w;

public class StartPwdGestureDeleteActivity
  extends BaseActivity
{
  private int mActivityType;
  private Handler mHandler = new zq(this);
  private bs mListener = new zr(this);
  
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
  
  private void judgeNextStep()
  {
    dismissDialog();
    cy.a().a(this);
    RqdApplication.i();
    w.a(null, FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    cy.a().a(this, 0);
    setResult(257);
    SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("start_pwd_config", 0).edit();
    localEditor.clear();
    localEditor.commit();
    if (!cy.a().c()) {
      pwdIsDelete();
    }
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, 2131230886, new zu(this, paramContext), null);
    }
  }
  
  public void finish()
  {
    super.finish();
    w.a(this, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    h.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 256) && (paramInt2 == 257))
    {
      setResult(35);
      finish();
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
    setContentView(2130968766);
    ((ViewStub)findViewById(2131559318)).inflate();
    paramBundle = (LockPatternVerifyView)findViewById(2131559462);
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
    new Handler().post(new zt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureDeleteActivity
 * JD-Core Version:    0.7.0.1
 */