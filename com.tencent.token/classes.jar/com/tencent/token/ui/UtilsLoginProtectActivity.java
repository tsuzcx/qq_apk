package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.f;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.es;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dd;
import com.tencent.token.utils.w;
import java.util.List;

public class UtilsLoginProtectActivity
  extends BaseActivity
{
  public static boolean mNeedRefreshLoginProtect;
  public String mA2;
  private nu mAdapter;
  private View.OnClickListener mBindListener = new act(this);
  private ErrorView mErrorView;
  public Handler mHandler = new acq(this);
  private ListView mListView;
  public LoginProtectResult mLoginProtectResult;
  private dd mNeedVerifyView;
  private boolean mNormalStatus;
  private View mProgressView;
  private boolean mQueryMobile;
  private View.OnClickListener mRetryListener = new acu(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131559382);
    this.mListView = ((ListView)findViewById(2131559381));
    this.mAdapter = new nu(this);
    this.mListView.setAdapter(this.mAdapter);
    this.mTipBindQQDesc = getResources().getString(2131231535);
    this.mTipBindQQBtnDesc = getResources().getString(2131230778);
  }
  
  private void judgeNextStep()
  {
    queryLoginProtect();
  }
  
  public f getItem(int paramInt)
  {
    Object localObject;
    if ((this.mLoginProtectResult == null) || (this.mLoginProtectResult.mLists.size() == 0))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.mLoginProtectResult.mLists.size()) {
        break label81;
      }
      f localf = (f)this.mLoginProtectResult.mLists.get(i);
      localObject = localf;
      if (localf.a == paramInt) {
        break;
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  public void hideTip()
  {
    this.mProgressView.setVisibility(8);
    this.mListView.setVisibility(0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    mNeedRefreshLoginProtect = true;
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      this.mNormalStatus = false;
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 1);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838011, new acv(this));
      dr.a().h.a("login_protect").a();
      return;
      setContentView(2130968798);
      initUI();
      this.mNormalStatus = true;
      mNeedRefreshLoginProtect = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((mNeedRefreshLoginProtect) && (this.mNormalStatus))
    {
      queryLoginProtect();
      showTip(-1);
    }
  }
  
  public void queryLoginProtect()
  {
    QQUser localQQUser = do.a().e();
    if (localQQUser == null)
    {
      finish();
      return;
    }
    if (!this.mQueryMobile)
    {
      cw.a().e(0L, this.mHandler);
      return;
    }
    cp localcp = cp.a(RqdApplication.l());
    byte[] arrayOfByte = localcp.b(do.a().e().mRealUin);
    h.a("mailprotect data=" + arrayOfByte);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (!localcp.b("" + localQQUser.mRealUin, 523005419L)))
    {
      this.mA2 = w.a(arrayOfByte);
      cw.a().c(0L, this.mA2, this.mHandler);
      return;
    }
    cp.a(RqdApplication.l()).a("" + localQQUser.mRealUin, this.mHandler, 523005419L, 64);
  }
  
  public void showTip(int paramInt)
  {
    if (paramInt == -1)
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
    this.mErrorView.setAction(this.mRetryListener);
    this.mErrorView.a();
    bringChildToFront(this.mErrorView);
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
 * Qualified Name:     com.tencent.token.ui.UtilsLoginProtectActivity
 * JD-Core Version:    0.7.0.1
 */