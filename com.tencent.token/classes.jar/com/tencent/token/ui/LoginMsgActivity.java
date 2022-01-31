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
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.bc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SecurityReporterResult;
import com.tencent.token.fo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.LoginMsgMenuDialog;
import com.tencent.token.ui.base.PullToRefreshListView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.cc;
import com.tencent.token.utils.s;
import com.tencent.token.x;
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
  private qf mAdapter;
  private fo mCache = bb.a().f;
  public Handler mHandler = new oa(this);
  private int mHaveMsgReqTimes = 0;
  private boolean mIsBusy = false;
  private boolean mKickOff = false;
  private PullToRefreshListView mListView;
  private cc mListener = new oc(this);
  private LoginMsgMenuDialog mMenuDialog;
  private int mNewMsgCnt = 0;
  private boolean mQuerySecurityReporter = false;
  private View.OnClickListener mRightTitleButtonClickListener = new oe(this);
  private SecurityReporterResult mSecurityResult;
  private String mSessId;
  private byte mSource = bc.e;
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
  
  private void getLoginMsg()
  {
    if (this.mIsBusy) {}
    do
    {
      return;
      this.mIsBusy = true;
      resetParams();
    } while (ax.a().e() == null);
    byte[] arrayOfByte = x.a(RqdApplication.i()).a(ax.a().e().mRealUin);
    if (arrayOfByte != null)
    {
      mSkey = s.a(arrayOfByte);
      bb.a().a(this.mSource, mSkey, this.mHandler);
      return;
    }
    x.a(RqdApplication.i()).a(this, "" + ax.a().e().mRealUin, this.mHandler, true);
  }
  
  private void saveTimeZoneFlag()
  {
    SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("msg_tips_timezone", 0).edit();
    localEditor.putBoolean("msg_tips_timezone_flag", true);
    localEditor.commit();
  }
  
  private void seekIpcMsg()
  {
    int i = this.mCache.d;
    e.c("login msg ipc index= " + i);
    if (i >= 0)
    {
      this.mListView.clearFocus();
      this.mListView.post(new of(this, i));
      fo localfo = this.mCache;
      localfo.d = -1;
      localfo.e = 0L;
    }
  }
  
  public static void setShowNewMsgCnt(boolean paramBoolean, int paramInt)
  {
    mNeedShowNewMsgCnt = paramBoolean;
    mNewMsgCntSetByAccount = paramInt;
  }
  
  void checkTimeZoneFlag()
  {
    if ((!RqdApplication.i().getSharedPreferences("msg_tips_timezone", 0).getBoolean("msg_tips_timezone_flag", false)) && (this.mCache.g() > 0))
    {
      int i = TimeZone.getDefault().getOffset(System.currentTimeMillis());
      e.b("checkTimeZoneFlag offset=" + i);
      if (i != 28800000)
      {
        View localView = findViewById(2131296782);
        localView.setVisibility(0);
        findViewById(2131296785).setOnClickListener(new og(this, localView));
      }
      return;
    }
    findViewById(2131296782).setVisibility(8);
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
      if ((this.mMenuDialog != null) && (this.mMenuDialog.isShowing()))
      {
        this.mMenuDialog.cancel();
        return true;
      }
    }
  }
  
  public void finishRefresh()
  {
    e.c("finish refresh");
    if (this.mKickOff) {
      this.mKickOff = false;
    }
    do
    {
      return;
      this.mListView.b();
    } while ((isFinishing()) || (this.mAdapter == null));
    if (this.mNewMsgCnt > 0) {
      showOrangeToast(this.mNewMsgCnt + getResources().getString(2131362016), 2130837964);
    }
    this.mListView.a(System.currentTimeMillis());
    this.mListView.a("login_msg_refresh_time");
    this.mAdapter.a(bb.a().f, bb.a().b);
    this.mAdapter.notifyDataSetChanged();
    seekIpcMsg();
  }
  
  public boolean isValid()
  {
    QQUser localQQUser = ax.a().e();
    if ((this.mSessId == null) || (localQQUser == null)) {}
    String str;
    do
    {
      return false;
      str = this.mSessId;
      ax.a();
    } while ((!str.equals(ax.c)) || (this.mUinHash != localQQUser.mUin) || (!this.mQuerySecurityReporter));
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903126);
    try
    {
      Activity.class.getDeclaredMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(this, new Object[] { Integer.valueOf(2130968585), Integer.valueOf(2130968584) });
      this.mListView = ((PullToRefreshListView)findViewById(2131296262));
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
      this.mAdapter = new qf(this);
      this.mAdapter.a(bb.a().f, bb.a().b);
      paramBundle = LayoutInflater.from(this).inflate(2130903142, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mAdapter.a(paramBundle);
      paramBundle = LayoutInflater.from(this).inflate(2130903139, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mAdapter.c(paramBundle);
      this.mAdapter.e();
      paramBundle = LayoutInflater.from(this).inflate(2130903138, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mListView.setSelector(2130837756);
      this.mAdapter.b(paramBundle);
      this.mListView.setScrollingCacheEnabled(true);
      paramBundle = getIntent().getStringExtra("skey");
      if ((paramBundle != null) && (paramBundle.length() > 0)) {
        mSkey = paramBundle;
      }
      paramBundle = getIntent().getBundleExtra("com.tencent.input_param");
      if (paramBundle == null) {
        break label435;
      }
    }
    if (paramBundle.getLong("uin") > 0L)
    {
      this.mUin = paramBundle.getLong("uin");
      ax.a().a(this.mUin);
      this.mSource = bc.d;
      s.a(String.valueOf(this.mUin), false);
      mNewMsgCntSetByAccount = 0;
    }
    for (;;)
    {
      this.mAdapter.a();
      this.mListView.a(2131362020);
      this.mListView.setAdapter(this.mAdapter);
      this.mListView.a(this.mListView.b("login_msg_refresh_time"));
      this.mListView.a(new od(this));
      setRightTitleImage(2130837952, this.mRightTitleButtonClickListener);
      this.mRightOptionImage.setVisibility(0);
      return;
      label435:
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
    fo localfo = this.mCache;
    localfo.d = -1;
    localfo.e = 0L;
    AccountPageActivity.mNeedShowIpcMsg = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    if ((!bb.a().d()) || (this.mUin > 0L))
    {
      resetParams();
      this.mUin = 0L;
      this.mListView.a();
    }
    if (mConfirmLogin)
    {
      showOrangeToast(2131362037, 2130837964);
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
        showOrangeToast(mNewMsgCntSetByAccount + getResources().getString(2131362016), 2130837964);
      }
      mNeedShowNewMsgCnt = false;
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void resetParams()
  {
    bb.a().c();
    this.mNewMsgCnt = 0;
    this.mHaveMsgReqTimes = 0;
    mNeedShowNewMsgCnt = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LoginMsgActivity
 * JD-Core Version:    0.7.0.1
 */