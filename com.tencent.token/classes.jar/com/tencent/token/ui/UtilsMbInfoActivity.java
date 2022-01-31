package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.es;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dd;

public class UtilsMbInfoActivity
  extends BaseActivity
{
  private or mAdapter;
  private View.OnClickListener mBindListener = new adj(this);
  private ErrorView mErrorView;
  public Handler mHandler = new adl(this);
  public boolean mIsIniting = false;
  private ListView mListView;
  private dd mNeedVerifyView;
  private View mProgressView;
  private View.OnClickListener mRetryListener = new adk(this);
  
  private void checkView()
  {
    if (this.mProgressView == null)
    {
      setContentView(2130968807);
      initUI();
    }
  }
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131559414);
    this.mListView = ((ListView)findViewById(2131559413));
    this.mAdapter = new or(this);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  public void getMbInfo()
  {
    if (this.mIsIniting) {
      return;
    }
    this.mIsIniting = true;
    showTip(-1, null, null, false);
    cw.a().e(0L, this.mHandler);
  }
  
  public void hideTip()
  {
    checkView();
    this.mProgressView.setVisibility(8);
    this.mListView.setVisibility(0);
    this.mAdapter.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, -1);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838011, new adm(this));
      return;
      setContentView(2130968807);
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
    Object localObject = do.a().e();
    if ((localObject != null) && (((QQUser)localObject).mIsBinded)) {
      getMbInfo();
    }
    localObject = dr.a().h;
    if ((localObject != null) && (((es)localObject).a("mb_tools") != null)) {
      ((es)localObject).a("mb_tools").a();
    }
  }
  
  public void onStop()
  {
    cw.a().a(getClass().getName());
    super.onStop();
  }
  
  public void showTip(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    checkView();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsMbInfoActivity
 * JD-Core Version:    0.7.0.1
 */