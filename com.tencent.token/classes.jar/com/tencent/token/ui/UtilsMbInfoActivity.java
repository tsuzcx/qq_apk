package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fp;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dk;

public class UtilsMbInfoActivity
  extends BaseActivity
{
  private pg mAdapter;
  private View.OnClickListener mBindListener = new aeu(this);
  private ErrorView mErrorView;
  public Handler mHandler = new aew(this);
  public boolean mIsIniting = false;
  private ListView mListView;
  private dk mNeedVerifyView;
  private View mProgressView;
  private View.OnClickListener mRetryListener = new aev(this);
  
  private void checkView()
  {
    if (this.mProgressView == null)
    {
      setContentView(2130903244);
      initUI();
    }
  }
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131297255);
    this.mListView = ((ListView)findViewById(2131297254));
    this.mAdapter = new pg(this);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  public void getMbInfo()
  {
    if (this.mIsIniting) {
      return;
    }
    this.mIsIniting = true;
    showTip(-1, null, null, false);
    af.a().e(0L, this.mHandler);
  }
  
  public void hideTip()
  {
    if (this.mProgressView == null)
    {
      setContentView(2130903244);
      initUI();
    }
    this.mProgressView.setVisibility(8);
    this.mListView.setVisibility(0);
    this.mAdapter.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, -1);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837951, new aex(this));
      return;
      setContentView(2130903244);
      initUI();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = ax.a().e();
    if ((localObject != null) && (((QQUser)localObject).mIsBinded)) {
      getMbInfo();
    }
    localObject = ba.a().h;
    if ((localObject != null) && (((fp)localObject).a("mb_tools") != null)) {
      ((fp)localObject).a("mb_tools").a();
    }
  }
  
  public void onStop()
  {
    af.a().a(getClass().getName());
    super.onStop();
  }
  
  public void showTip(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.mProgressView == null)
    {
      setContentView(2130903244);
      initUI();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsMbInfoActivity
 * JD-Core Version:    0.7.0.1
 */