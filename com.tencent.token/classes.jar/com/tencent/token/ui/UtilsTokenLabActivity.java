package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dk;
import com.tencent.token.utils.s;

public class UtilsTokenLabActivity
  extends BaseActivity
{
  private ImageView iv_new;
  private View.OnClickListener mBindListener = new agb(this);
  private ErrorView mErrorView;
  private Handler mHandler = new aga(this);
  private dk mNeedVerifyView;
  private String mOff;
  private String mOn;
  private View mRealNameView;
  private View.OnClickListener mRetryListener = new agc(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  private TextView mfaceStatus;
  private View mfaceView;
  private RealNameStatusResult result;
  
  private void init()
  {
    this.mTipBindQQDesc = getResources().getString(2131362193);
    this.mTipBindQQBtnDesc = getResources().getString(2131362297);
    this.mOn = getResources().getString(2131362380);
    this.mOff = getResources().getString(2131362381);
    this.mfaceView = findViewById(2131297163);
    this.iv_new = ((ImageView)findViewById(2131296288));
    this.mfaceView.setOnClickListener(new afy(this));
    this.mfaceStatus = ((TextView)findViewById(2131297166));
    this.mRealNameView = findViewById(2131297167);
    this.mRealNameView.setOnClickListener(new afz(this));
  }
  
  private void setView()
  {
    if (this.mfaceStatus != null)
    {
      if (!ax.a().j()) {
        break label59;
      }
      this.mfaceStatus.setText(2131362502);
      this.mfaceStatus.setTextAppearance(this, 2131427368);
    }
    for (;;)
    {
      if ((!s.i("util_lab_fr_new")) && (this.iv_new != null)) {
        this.iv_new.setVisibility(0);
      }
      return;
      label59:
      this.mfaceStatus.setText(2131362503);
      this.mfaceStatus.setTextAppearance(this, 2131427367);
    }
  }
  
  private void showTipView(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.mErrorView == null)
    {
      this.mErrorView = new ErrorView(this);
      addContentView(this.mErrorView);
    }
    this.mErrorView.a(paramInt);
    if (paramBoolean) {
      this.mErrorView.a(this.mBindListener);
    }
    for (;;)
    {
      this.mErrorView.setVisibility(0);
      bringChildToFront(this.mErrorView);
      return;
      this.mErrorView.a(this.mRetryListener);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, -2);
      }
      setContentView(this.mNeedVerifyView);
      return;
    }
    setContentView(2130903222);
    init();
    af.a().l(0L, this.mHandler);
    showProDialog(this, 2131361808, 2131362203, null);
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