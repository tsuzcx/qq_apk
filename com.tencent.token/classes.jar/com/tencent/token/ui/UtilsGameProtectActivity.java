package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.eo;
import com.tencent.token.es;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dd;

public class UtilsGameProtectActivity
  extends BaseActivity
{
  private int indexID;
  private kb mAdapter;
  private View.OnClickListener mBindListener = new acn(this);
  private ErrorView mErrorView;
  private Handler mHandler = new acl(this);
  public boolean mIsIniting = false;
  private ListView mListView;
  private dd mNeedVerifyView;
  private View mProgressView;
  private View.OnClickListener mRetryListener = new aco(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131559376);
    this.mListView = ((ListView)findViewById(2131559375));
    this.mAdapter = new kb(this, this.mListView, this.mHandler);
    if (this.indexID > 0) {
      this.mAdapter.a = false;
    }
    for (;;)
    {
      this.mListView.setScrollingCacheEnabled(true);
      this.mListView.setAdapter(this.mAdapter);
      this.mTipBindQQDesc = getResources().getString(2131231535);
      this.mTipBindQQBtnDesc = getResources().getString(2131230778);
      return;
      View localView = LayoutInflater.from(this).inflate(2130968811, this.mListView, false);
      this.mListView.addFooterView(localView);
      this.mAdapter.a(localView);
    }
  }
  
  public void hideTip()
  {
    this.mProgressView.setVisibility(8);
    this.mListView.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 2);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838011, new acp(this));
      return;
      setContentView(2130968796);
      this.indexID = getIntent().getIntExtra("indexid", 0);
      initUI();
    }
  }
  
  protected void onDestroy()
  {
    if (this.mAdapter != null) {
      this.mAdapter.a();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    dr.a().d.e();
    dr.a().h.a("account_prot").a();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = do.a().e();
    if ((localQQUser != null) && (localQQUser.mIsBinded)) {
      queryGameProtectStatus();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void queryGameProtectStatus()
  {
    if (this.mIsIniting)
    {
      h.c("busy initing");
      return;
    }
    this.mIsIniting = true;
    if (dr.a().l()) {
      hideTip();
    }
    for (;;)
    {
      cw.a().c(0L, this.mHandler);
      return;
      showTip(-1, null, null, false);
    }
  }
  
  public void showTip(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((isFinishing()) || (this.mProgressView == null) || (this.mListView == null)) {
      return;
    }
    if ((paramInt == -1) && (paramString1 == null) && (paramString2 == null))
    {
      this.mProgressView.setVisibility(0);
      this.mListView.setVisibility(8);
      return;
    }
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
  
  public void showTipDialog(int paramInt, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(paramInt, paramString, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsGameProtectActivity
 * JD-Core Version:    0.7.0.1
 */