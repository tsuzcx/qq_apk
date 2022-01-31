package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import com.tencent.token.fl;
import com.tencent.token.fp;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dk;

public class UtilsGameProtectActivity
  extends BaseActivity
{
  private int indexID;
  private kx mAdapter;
  private View.OnClickListener mBindListener = new adz(this);
  private ErrorView mErrorView;
  private Handler mHandler = new adx(this);
  public boolean mIsIniting = false;
  private ListView mListView;
  private dk mNeedVerifyView;
  private View mProgressView;
  private View.OnClickListener mRetryListener = new aea(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131297216);
    this.mListView = ((ListView)findViewById(2131297215));
    this.mAdapter = new kx(this, this.mListView, this.mHandler);
    if (this.indexID > 0) {
      this.mAdapter.a = false;
    }
    for (;;)
    {
      this.mListView.setScrollingCacheEnabled(true);
      this.mListView.setAdapter(this.mAdapter);
      this.mTipBindQQDesc = getResources().getString(2131362193);
      this.mTipBindQQBtnDesc = getResources().getString(2131362297);
      return;
      View localView = LayoutInflater.from(this).inflate(2130903248, this.mListView, false);
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
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 1);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837951, new aeb(this));
      return;
      setContentView(2130903233);
      this.indexID = getIntent().getIntExtra("indexid", 0);
      initUI();
    }
  }
  
  protected void onDestroy()
  {
    if (this.mAdapter != null)
    {
      int j = ba.a().f();
      int i = 0;
      while (i < j)
      {
        g localg = ba.a().b(i);
        if (localg != null) {
          localg.e = false;
        }
        i += 1;
      }
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    ba.a().d.d();
    ba.a().h.a("account_prot").a();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = ax.a().e();
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
      e.c("busy initing");
      return;
    }
    this.mIsIniting = true;
    if (ba.a().l()) {
      hideTip();
    }
    for (;;)
    {
      af.a().c(0L, this.mHandler);
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
  
  public void showTipDialog(int paramInt, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(paramInt, paramString, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsGameProtectActivity
 * JD-Core Version:    0.7.0.1
 */