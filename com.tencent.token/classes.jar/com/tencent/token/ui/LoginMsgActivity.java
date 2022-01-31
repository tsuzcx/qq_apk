package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SecurityReporterResult;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.dt;
import com.tencent.token.er;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.LoginMsgMenuDialog;
import com.tencent.token.ui.base.PullToRefreshListView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.bv;
import com.tencent.token.utils.w;
import java.lang.reflect.Method;
import java.util.TimeZone;

public class LoginMsgActivity
  extends BaseActivity
{
  private static final String PREFER_TIME = "login_msg_refresh_time";
  public static boolean mConfirmLogin;
  private static boolean mNeedShowNewMsgCnt;
  public static int mNewMsgCntSetByAccount;
  public static String mSkey;
  private ps mAdapter;
  private er mCache = ds.a().f;
  public Handler mHandler = new ne(this);
  private int mHaveMsgReqTimes = 0;
  private boolean mIsBusy = false;
  private boolean mKickOff = false;
  private PullToRefreshListView mListView;
  private bv mListener = new ng(this);
  private LoginMsgMenuDialog mMenuDialog;
  private int mNewMsgCnt = 0;
  private boolean mQuerySecurityReporter = false;
  private SecurityReporterResult mSecurityResult;
  private String mSessId;
  private byte mSource = dt.e;
  private TitleOptionMenu mTitleMenu;
  private long mUin;
  private long mUinHash;
  
  static
  {
    if (!LoginMsgActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      mNeedShowNewMsgCnt = false;
      mConfirmLogin = false;
      mNewMsgCntSetByAccount = 0;
      return;
    }
  }
  
  private void getA2()
  {
    QQUser localQQUser = do.a().e();
    if (localQQUser == null) {
      return;
    }
    cp localcp = cp.a(RqdApplication.l());
    byte[] arrayOfByte = cp.a(RqdApplication.l()).b(do.a().e().mRealUin);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (!localcp.b("" + localQQUser.mRealUin, 523005419L)))
    {
      mSkey = w.a(arrayOfByte);
      ds.a().a(this.mSource, mSkey, this.mHandler);
      return;
    }
    cp.a(RqdApplication.l()).a("" + localQQUser.mRealUin, this.mHandler, 523005419L, 64);
  }
  
  private void getLoginMsg()
  {
    if (this.mIsBusy) {}
    do
    {
      return;
      this.mIsBusy = true;
      resetParams();
    } while (do.a().e() == null);
    getA2();
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void judgeNextStep() {}
  
  private void saveTimeZoneFlag()
  {
    SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("msg_tips_timezone", 0).edit();
    localEditor.putBoolean("msg_tips_timezone_flag", true);
    localEditor.commit();
  }
  
  private void seekIpcMsg()
  {
    int i = this.mCache.d;
    h.c("login msg ipc index= " + i);
    if (i >= 0)
    {
      this.mListView.clearFocus();
      this.mListView.post(new ni(this, i));
      this.mCache.k();
    }
  }
  
  public static void setShowNewMsgCnt(boolean paramBoolean, int paramInt)
  {
    mNeedShowNewMsgCnt = paramBoolean;
    mNewMsgCntSetByAccount = paramInt;
  }
  
  void checkTimeZoneFlag()
  {
    if ((!RqdApplication.l().getSharedPreferences("msg_tips_timezone", 0).getBoolean("msg_tips_timezone_flag", false)) && (this.mCache.g() > 0))
    {
      int i = TimeZone.getDefault().getOffset(System.currentTimeMillis());
      h.b("checkTimeZoneFlag offset=" + i);
      if (i != 28800000)
      {
        View localView = findViewById(2131558985);
        localView.setVisibility(0);
        findViewById(2131558988).setOnClickListener(new nj(this, localView));
      }
      return;
    }
    findViewById(2131558985).setVisibility(8);
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
      if ((this.mMenuDialog != null) && (this.mMenuDialog.isShowing()))
      {
        this.mMenuDialog.cancel();
        return true;
      }
    }
  }
  
  public void finishRefresh()
  {
    h.c("finish refresh");
    if (this.mKickOff) {
      this.mKickOff = false;
    }
    do
    {
      return;
      this.mListView.b();
    } while ((isFinishing()) || (this.mAdapter == null));
    if (this.mNewMsgCnt > 0) {
      showOrangeToast(this.mNewMsgCnt + getResources().getString(2131230893), 2130838017);
    }
    this.mListView.setRefreshTime(System.currentTimeMillis());
    this.mListView.a("login_msg_refresh_time");
    this.mAdapter.a(ds.a().f, ds.a().b);
    this.mAdapter.notifyDataSetChanged();
    seekIpcMsg();
  }
  
  public boolean isValid()
  {
    QQUser localQQUser = do.a().e();
    if ((this.mSessId == null) || (localQQUser == null)) {}
    String str;
    do
    {
      return false;
      str = this.mSessId;
      do.a();
    } while ((!str.equals(do.c)) || (this.mUinHash != localQQUser.mUin) || (!this.mQuerySecurityReporter));
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968683);
    try
    {
      Activity.class.getDeclaredMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(this, new Object[] { Integer.valueOf(2131034135), Integer.valueOf(2131034134) });
      this.mListView = ((PullToRefreshListView)findViewById(2131558521));
      if ((!$assertionsDisabled) && (this.mListView == null)) {
        throw new AssertionError();
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
      this.mAdapter = new ps(this);
      this.mAdapter.a(ds.a().f, ds.a().b);
      paramBundle = LayoutInflater.from(this).inflate(2130968698, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mAdapter.a(paramBundle);
      paramBundle = LayoutInflater.from(this).inflate(2130968695, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mAdapter.c(paramBundle);
      this.mAdapter.e();
      paramBundle = LayoutInflater.from(this).inflate(2130968694, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mListView.setSelector(2130837832);
      this.mAdapter.b(paramBundle);
      this.mListView.setScrollingCacheEnabled(true);
      paramBundle = getIntent().getStringExtra("skey");
      if ((paramBundle != null) && (paramBundle.length() > 0)) {
        mSkey = paramBundle;
      }
      paramBundle = getIntent().getBundleExtra("com.tencent.input_param");
      if (paramBundle == null) {
        break label416;
      }
    }
    if (paramBundle.getLong("uin") > 0L)
    {
      this.mUin = paramBundle.getLong("uin");
      do.a().a(this.mUin);
      this.mSource = dt.d;
      w.a(String.valueOf(this.mUin), false);
      mNewMsgCntSetByAccount = 0;
    }
    for (;;)
    {
      this.mAdapter.a();
      this.mListView.a(2131231171);
      this.mListView.setAdapter(this.mAdapter);
      this.mListView.setRefreshTime(this.mListView.b("login_msg_refresh_time"));
      this.mListView.setOnRefreshListener(new nh(this));
      return;
      label416:
      this.mUin = 0L;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mAdapter = null;
    this.mListView.setAdapter(null);
  }
  
  protected void onPause()
  {
    this.mCache.k();
    AccountPageActivity.mNeedShowIpcMsg = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    if ((!ds.a().d()) || (this.mUin > 0L))
    {
      resetParams();
      this.mUin = 0L;
      this.mListView.a();
    }
    if (mConfirmLogin)
    {
      showOrangeToast(2131231466, 2130838017);
      mConfirmLogin = false;
    }
    seekIpcMsg();
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (mNeedShowNewMsgCnt))
    {
      if (mNewMsgCntSetByAccount > 0) {
        showOrangeToast(mNewMsgCntSetByAccount + getResources().getString(2131230893), 2130838017);
      }
      mNeedShowNewMsgCnt = false;
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void resetParams()
  {
    ds.a().c();
    this.mNewMsgCnt = 0;
    this.mHaveMsgReqTimes = 0;
    mNeedShowNewMsgCnt = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LoginMsgActivity
 * JD-Core Version:    0.7.0.1
 */