package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dk;
import com.tencent.token.utils.s;
import com.tencent.token.x;
import java.util.List;

public class UtilsLoginProtectActivity
  extends BaseActivity
{
  public static boolean mNeedRefreshLoginProtect;
  public String mA2;
  private or mAdapter;
  private View.OnClickListener mBindListener = new aef(this);
  private ErrorView mErrorView;
  public Handler mHandler = new aec(this);
  private boolean mIsIniting;
  private ListView mListView;
  public LoginProtectResult mLoginProtectResult;
  private dk mNeedVerifyView;
  private boolean mNormalStatus;
  private View mProgressView;
  private boolean mQueryMobile;
  private View.OnClickListener mRetryListener = new aeg(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  private void initUI()
  {
    this.mProgressView = findViewById(2131297223);
    this.mListView = ((ListView)findViewById(2131297222));
    this.mAdapter = new or(this);
    this.mListView.setAdapter(this.mAdapter);
    this.mTipBindQQDesc = getResources().getString(2131362193);
    this.mTipBindQQBtnDesc = getResources().getString(2131362297);
  }
  
  public com.tencent.token.core.bean.e getItem(int paramInt)
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
      com.tencent.token.core.bean.e locale = (com.tencent.token.core.bean.e)this.mLoginProtectResult.mLists.get(i);
      localObject = locale;
      if (locale.a == paramInt) {
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    mNeedRefreshLoginProtect = true;
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      this.mNormalStatus = false;
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 0);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837951, new aeh(this));
      ba.a().h.a("login_protect").a();
      return;
      setContentView(2130903236);
      initUI();
      this.mNormalStatus = true;
      mNeedRefreshLoginProtect = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((mNeedRefreshLoginProtect) && (this.mNormalStatus)) {
      queryLoginProtect();
    }
  }
  
  public void queryLoginProtect()
  {
    if (this.mIsIniting) {
      com.tencent.token.global.e.c("busy initing");
    }
    QQUser localQQUser;
    do
    {
      return;
      this.mIsIniting = true;
      showTip(-1, null, null, false);
      localQQUser = ax.a().e();
      if (!this.mQueryMobile)
      {
        af.a().e(0L, this.mHandler);
        return;
      }
      if ((this.mA2 != null) && (this.mA2.length() > 0))
      {
        af.a().d(0L, this.mA2, this.mHandler);
        return;
      }
    } while (localQQUser == null);
    byte[] arrayOfByte = x.a(RqdApplication.i()).a(localQQUser.mRealUin);
    if (arrayOfByte != null)
    {
      this.mA2 = s.a(arrayOfByte);
      af.a().d(0L, this.mA2, this.mHandler);
      return;
    }
    x.a(RqdApplication.i()).a(this, "" + localQQUser.mRealUin, this.mHandler, true);
  }
  
  public void showTip(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
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
 * Qualified Name:     com.tencent.token.ui.UtilsLoginProtectActivity
 * JD-Core Version:    0.7.0.1
 */