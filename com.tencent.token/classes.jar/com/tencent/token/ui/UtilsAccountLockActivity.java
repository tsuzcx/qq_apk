package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ListView;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.ef;
import com.tencent.token.es;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.dd;

public class UtilsAccountLockActivity
  extends BaseActivity
{
  static int windowWidth;
  private i mAdapter;
  private View.OnClickListener mBindListener = new abl(this);
  private ErrorView mErrorView;
  Handler mHandler = new abk(this);
  private ListView mListView;
  private dd mNeedVerifyView;
  private View mProgressView;
  private boolean mQueryingAccountLockStatus = false;
  private View.OnClickListener mRetryListener = new abm(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  private TitleOptionMenu mTitleMenu;
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131559350);
    this.mListView = ((ListView)findViewById(2131559349));
    this.mAdapter = new i(this, this.mListView, this.mHandler);
    this.mListView.setAdapter(this.mAdapter);
    this.mTipBindQQDesc = getResources().getString(2131231535);
    this.mTipBindQQBtnDesc = getResources().getString(2131230778);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((c.f()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      if ((this.mTitleMenu != null) && (this.mTitleMenu.getVisibility() == 0))
      {
        this.mTitleMenu.b();
        return true;
      }
    }
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public void hideTip()
  {
    this.mProgressView.setVisibility(8);
    this.mListView.setVisibility(0);
    if (this.mHandler != null)
    {
      Message localMessage = this.mHandler.obtainMessage(3033);
      this.mHandler.sendMessage(localMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 5);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838011, new abn(this));
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      windowWidth = paramBundle.widthPixels;
      return;
      setContentView(2130968789);
      initUI();
    }
  }
  
  protected void onDestroy()
  {
    if (this.mAdapter != null) {
      this.mAdapter.d();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    dr.a().b.b();
    dr.a().h.a("account_lock").a();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = do.a().e();
    if ((localQQUser != null) && (localQQUser.mIsBinded)) {
      queryAccountLockStatus();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void queryAccountLockStatus()
  {
    if (this.mQueryingAccountLockStatus) {
      return;
    }
    this.mQueryingAccountLockStatus = true;
    if (dr.a().j()) {
      hideTip();
    }
    for (;;)
    {
      cw.a().a(0L, this.mHandler);
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
 * Qualified Name:     com.tencent.token.ui.UtilsAccountLockActivity
 * JD-Core Version:    0.7.0.1
 */