package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dd;
import com.tencent.token.utils.w;

public class UtilsTokenLabActivity
  extends BaseActivity
{
  private ImageView iv_new;
  private View.OnClickListener mBindListener = new aep(this);
  private ErrorView mErrorView;
  private Handler mHandler = new aeo(this);
  private dd mNeedVerifyView;
  private String mOff;
  private String mOn;
  private View mRealNameView;
  private View.OnClickListener mRetryListener = new aeq(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  private TextView mfaceStatus;
  private View mfaceView;
  private RealNameStatusResult result;
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void init()
  {
    this.mTipBindQQDesc = getResources().getString(2131231535);
    this.mTipBindQQBtnDesc = getResources().getString(2131230778);
    this.mOn = getResources().getString(2131231443);
    this.mOff = getResources().getString(2131231442);
    this.mfaceView = findViewById(2131559324);
    this.iv_new = ((ImageView)findViewById(2131559264));
    this.mfaceView.setOnClickListener(new aem(this));
    this.mfaceStatus = ((TextView)findViewById(2131559327));
    this.mRealNameView = findViewById(2131559328);
    this.mRealNameView.setOnClickListener(new aen(this));
  }
  
  private void judgeNextStep() {}
  
  private void setView()
  {
    if (this.mfaceStatus != null)
    {
      if (!do.a().j()) {
        break label60;
      }
      this.mfaceStatus.setText(2131231142);
      this.mfaceStatus.setTextAppearance(this, 2131362196);
    }
    for (;;)
    {
      if ((!w.a(null, "util_lab_fr_new")) && (this.iv_new != null)) {
        this.iv_new.setVisibility(0);
      }
      return;
      label60:
      this.mfaceStatus.setText(2131231141);
      this.mfaceStatus.setTextAppearance(this, 2131362197);
    }
  }
  
  private void showTipView(int paramInt, boolean paramBoolean)
  {
    if (this.mErrorView == null)
    {
      this.mErrorView = new ErrorView(this);
      addContentView(this.mErrorView);
    }
    this.mErrorView.setErrorType(paramInt);
    if (paramBoolean) {
      this.mErrorView.setAction(this.mBindListener);
    }
    for (;;)
    {
      this.mErrorView.a();
      bringChildToFront(this.mErrorView);
      return;
      this.mErrorView.setAction(this.mRetryListener);
    }
  }
  
  public void getSKey(String paramString, long paramLong, Handler paramHandler, boolean paramBoolean)
  {
    cp localcp = cp.a(RqdApplication.l());
    if (!localcp.b(paramString, paramLong))
    {
      localcp.a(paramString, paramHandler, paramLong, 4096);
      return;
    }
    if (!paramBoolean)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(4105));
      return;
    }
    gotoQuickLoginWb();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, -2);
      }
      setContentView(this.mNeedVerifyView);
      return;
    }
    setContentView(2130968784);
    init();
    cw.a().j(0L, this.mHandler);
    showProDialog(this, 2131230843, 2131231601, null);
  }
  
  protected void onResume()
  {
    super.onResume();
    setView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsTokenLabActivity
 * JD-Core Version:    0.7.0.1
 */