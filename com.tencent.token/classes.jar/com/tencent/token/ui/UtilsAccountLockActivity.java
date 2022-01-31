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
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import com.tencent.token.fc;
import com.tencent.token.fp;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.dk;

public class UtilsAccountLockActivity
  extends BaseActivity
{
  static int windowWidth;
  private k mAdapter;
  private View.OnClickListener mBindListener = new acz(this);
  private ErrorView mErrorView;
  Handler mHandler = new acy(this);
  private ListView mListView;
  private dk mNeedVerifyView;
  private View mProgressView;
  private boolean mQueryingAccountLockStatus = false;
  private View.OnClickListener mRetryListener = new ada(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  private TitleOptionMenu mTitleMenu;
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131297189);
    this.mListView = ((ListView)findViewById(2131297188));
    this.mAdapter = new k(this, this.mListView, this.mHandler);
    this.mListView.setAdapter(this.mAdapter);
    this.mTipBindQQDesc = getResources().getString(2131362193);
    this.mTipBindQQBtnDesc = getResources().getString(2131362297);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      if ((this.mTitleMenu != null) && (this.mTitleMenu.getVisibility() == 0))
      {
        this.mTitleMenu.a();
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
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 4);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837951, new adb(this));
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      windowWidth = paramBundle.widthPixels;
      return;
      setContentView(2130903226);
      initUI();
    }
  }
  
  protected void onDestroy()
  {
    if (this.mAdapter != null)
    {
      int j = ba.a().a(true);
      int i = 0;
      g localg;
      while (i < j)
      {
        localg = ba.a().a(i, true);
        if (localg != null) {
          localg.e = false;
        }
        i += 1;
      }
      j = ba.a().a(false);
      i = 0;
      while (i < j)
      {
        localg = ba.a().a(i, false);
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
    ba.a().b.b();
    ba.a().h.a("account_lock").a();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = ax.a().e();
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
    if (ba.a().j()) {
      hideTip();
    }
    for (;;)
    {
      af.a().a(0L, this.mHandler);
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
 * Qualified Name:     com.tencent.token.ui.UtilsAccountLockActivity
 * JD-Core Version:    0.7.0.1
 */