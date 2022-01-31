package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.en;
import com.tencent.token.es;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.dd;

public class UtilsGameLockActivity
  extends BaseActivity
{
  private int indexID;
  private jy mAdapter;
  private View.OnClickListener mBindListener = new acj(this);
  private ErrorView mErrorView;
  Handler mHandler = new acf(this);
  private ListView mListView;
  private dd mNeedVerifyView;
  private View mProgressView;
  private boolean mQueryingGameLockStatus = false;
  private View.OnClickListener mRetryListener = new ack(this);
  private View.OnClickListener mRightTitleButtonClickListener = new ach(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  private TitleOptionMenu mTitleMenu;
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131559368);
    this.mListView = ((ListView)findViewById(2131559367));
    this.mAdapter = new jy(this, this.mListView, this.mHandler);
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
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 6);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838013, this.mRightTitleButtonClickListener);
      this.mTitleMenu = getDialogMenu();
      if (this.mTitleMenu != null) {
        this.mTitleMenu.setDisplayMode(4);
      }
      return;
      setContentView(2130968794);
      this.indexID = getIntent().getIntExtra("indexid", 0);
      initUI();
    }
  }
  
  protected void onDestroy()
  {
    if (this.mAdapter != null) {
      this.mAdapter.c();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    dr.a().c.e();
    dr.a().h.a("game_lock").a();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = do.a().e();
    if ((localQQUser != null) && (localQQUser.mIsBinded)) {
      queryGameLockStatus();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void queryGameLockStatus()
  {
    if (this.mQueryingGameLockStatus) {
      return;
    }
    this.mQueryingGameLockStatus = true;
    if (dr.a().k()) {
      hideTip();
    }
    for (;;)
    {
      cw.a().b(0L, this.mHandler);
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
 * Qualified Name:     com.tencent.token.ui.UtilsGameLockActivity
 * JD-Core Version:    0.7.0.1
 */