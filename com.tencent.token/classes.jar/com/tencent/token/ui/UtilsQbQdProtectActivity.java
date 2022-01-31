package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import com.tencent.token.fp;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.dk;

public class UtilsQbQdProtectActivity
  extends BaseActivity
{
  private View.OnClickListener mBindListener = new aft(this);
  private View mContentView;
  private ErrorView mErrorView;
  Handler mHandler = new afv(this);
  private dk mNeedVerifyView;
  private SwitchButton mQbQdProtectCB;
  private TextView mQbQdProtectName;
  private ProgressBar mQbQdProtectProgress;
  private View.OnClickListener mRetryListener = new afu(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  private void init()
  {
    this.mTipBindQQDesc = getResources().getString(2131362193);
    this.mTipBindQQBtnDesc = getResources().getString(2131362297);
    this.mContentView = findViewById(2131297292);
    this.mQbQdProtectCB = ((SwitchButton)findViewById(2131297294));
    this.mQbQdProtectName = ((TextView)findViewById(2131297293));
    this.mQbQdProtectProgress = ((ProgressBar)findViewById(2131297295));
    this.mQbQdProtectCB.setOnCheckedChangeListener(new afw(this));
  }
  
  private void queryQbQdProtectStatus()
  {
    refreshContentView();
    af.a().c(0L, this.mHandler);
  }
  
  private void refreshContentView()
  {
    boolean bool = true;
    if ((isFinishing()) || (this.mContentView == null)) {
      return;
    }
    this.mContentView.setVisibility(0);
    Object localObject = ba.a();
    g localg = ((ba)localObject).g();
    if ((localg.e) || (!((ba)localObject).o()))
    {
      this.mQbQdProtectProgress.setVisibility(0);
      this.mQbQdProtectCB.setVisibility(0);
      this.mQbQdProtectCB.setEnabled(false);
      label72:
      if ((localg.b != null) && (localg.b.length() > 0)) {
        this.mQbQdProtectName.setText(localg.b);
      }
    }
    else
    {
      this.mQbQdProtectProgress.setVisibility(4);
      this.mQbQdProtectCB.setVisibility(0);
      this.mQbQdProtectCB.setEnabled(true);
      localObject = this.mQbQdProtectCB;
      if (localg.c) {
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
    g localg = ba.a().g();
    if (localg.e) {
      return;
    }
    localg.e = true;
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
  
  public void handleQbQdProtect()
  {
    int i = 1;
    Object localObject = ba.a().g();
    int j = ((g)localObject).a;
    if (((g)localObject).c) {
      i = 0;
    }
    localObject = af.a();
    Handler localHandler = this.mHandler;
    ((af)localObject).a(0L, new int[] { j }, new int[] { i }, "", localHandler);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 3);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837951, new afx(this));
      return;
      setContentView(2130903251);
      init();
    }
  }
  
  protected void onDestroy()
  {
    g localg = ba.a().g();
    if (localg != null) {
      localg.e = false;
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
    QQUser localQQUser = ax.a().e();
    if ((localQQUser != null) && (localQQUser.mIsBinded))
    {
      refreshContentView();
      af.a().c(0L, this.mHandler);
    }
    ba.a().h.a("qb_prot").a();
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