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
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fk;
import com.tencent.token.fp;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.dk;

public class UtilsGameLockActivity
  extends BaseActivity
{
  private int indexID;
  private ku mAdapter;
  private View.OnClickListener mBindListener = new adv(this);
  private ErrorView mErrorView;
  Handler mHandler = new adr(this);
  private ListView mListView;
  private dk mNeedVerifyView;
  private View mProgressView;
  private boolean mQueryingGameLockStatus = false;
  private View.OnClickListener mRetryListener = new adw(this);
  private View.OnClickListener mRightTitleButtonClickListener = new adt(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  private TitleOptionMenu mTitleMenu;
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131297208);
    this.mListView = ((ListView)findViewById(2131297207));
    this.mAdapter = new ku(this, this.mListView, this.mHandler);
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
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 5);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837953, this.mRightTitleButtonClickListener);
      this.mTitleMenu = getDialogMenu();
      if (this.mTitleMenu != null) {
        this.mTitleMenu.a(4);
      }
      return;
      setContentView(2130903231);
      this.indexID = getIntent().getIntExtra("indexid", 0);
      initUI();
    }
  }
  
  protected void onDestroy()
  {
    if (this.mAdapter != null) {
      ku.d();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    ba.a().c.e();
    ba.a().h.a("game_lock").a();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    QQUser localQQUser = ax.a().e();
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
    if (ba.a().k()) {
      hideTip();
    }
    for (;;)
    {
      af.a().b(0L, this.mHandler);
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
 * Qualified Name:     com.tencent.token.ui.UtilsGameLockActivity
 * JD-Core Version:    0.7.0.1
 */