package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.h;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.es;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.dd;

public class UtilsQbQdProtectActivity
  extends BaseActivity
{
  private View.OnClickListener mBindListener = new aeh(this);
  private View mContentView;
  private ErrorView mErrorView;
  Handler mHandler = new aej(this);
  private dd mNeedVerifyView;
  private SwitchButton mQbQdProtectCB;
  private TextView mQbQdProtectName;
  private ProgressBar mQbQdProtectProgress;
  private View.OnClickListener mRetryListener = new aei(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  private void init()
  {
    this.mTipBindQQDesc = getResources().getString(2131231535);
    this.mTipBindQQBtnDesc = getResources().getString(2131230778);
    this.mContentView = findViewById(2131559444);
    this.mQbQdProtectCB = ((SwitchButton)findViewById(2131559446));
    this.mQbQdProtectName = ((TextView)findViewById(2131559445));
    this.mQbQdProtectProgress = ((ProgressBar)findViewById(2131559447));
    this.mQbQdProtectCB.setOnCheckedChangeListener(new aek(this));
  }
  
  private void queryQbQdProtectStatus()
  {
    refreshContentView();
    cw.a().c(0L, this.mHandler);
  }
  
  private void refreshContentView()
  {
    boolean bool = true;
    if ((isFinishing()) || (this.mContentView == null)) {
      return;
    }
    this.mContentView.setVisibility(0);
    Object localObject = dr.a();
    h localh = ((dr)localObject).g();
    if ((localh.e) || (!((dr)localObject).p()))
    {
      this.mQbQdProtectProgress.setVisibility(0);
      this.mQbQdProtectCB.setVisibility(0);
      this.mQbQdProtectCB.setEnabled(false);
      label72:
      if ((localh.b != null) && (localh.b.length() > 0)) {
        this.mQbQdProtectName.setText(localh.b);
      }
    }
    else
    {
      this.mQbQdProtectProgress.setVisibility(4);
      this.mQbQdProtectCB.setVisibility(0);
      this.mQbQdProtectCB.setEnabled(true);
      localObject = this.mQbQdProtectCB;
      if (localh.c) {
        break label146;
      }
    }
    for (;;)
    {
      ((SwitchButton)localObject).a(bool, false);
      break label72;
      break;
      label146:
      bool = false;
    }
  }
  
  private void setQbQdProtectStatus()
  {
    h localh = dr.a().g();
    if (localh.e) {
      return;
    }
    localh.e = true;
    refreshContentView();
    handleQbQdProtect();
  }
  
  private void showTipDialog(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(paramString);
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
  
  public void handleQbQdProtect()
  {
    int i = 1;
    Object localObject = dr.a().g();
    int j = ((h)localObject).a;
    if (((h)localObject).c) {
      i = 0;
    }
    localObject = cw.a();
    Handler localHandler = this.mHandler;
    ((cw)localObject).a(0L, new int[] { j }, new int[] { i }, "", localHandler);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 4);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838011, new ael(this));
      return;
      setContentView(2130968814);
      init();
    }
  }
  
  protected void onDestroy()
  {
    h localh = dr.a().g();
    if (localh != null) {
      localh.e = false;
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = do.a().e();
    if ((localQQUser != null) && (localQQUser.mIsBinded)) {
      queryQbQdProtectStatus();
    }
    dr.a().h.a("qb_prot").a();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsQbQdProtectActivity
 * JD-Core Version:    0.7.0.1
 */