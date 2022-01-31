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
import android.widget.Button;
import com.tencent.token.do;
import com.tencent.token.dt;
import com.tencent.token.du;
import com.tencent.token.er;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.PullToRefreshListView;
import com.tencent.token.ui.base.cg;
import java.lang.reflect.Method;
import java.util.TimeZone;

public class OpreateMsgActivity
  extends BaseActivity
  implements cg
{
  public static final String PREFER_TIME = "opreate_msg_refresh_time";
  public static boolean s_NeedShowNewMsgCnt;
  sn mAdapter;
  private er mCache = du.a().f;
  Button mEditSelectBtn;
  public Handler mHandler = new st(this);
  private int mHaveMsgReqTimes = 0;
  private boolean mIsEdit = false;
  public boolean mIsRefreshing = false;
  boolean mIsSelectAll;
  View mListEidt;
  PullToRefreshListView mListView;
  private du mMsgMgr = du.a();
  private View.OnClickListener mRightTitleButtonClickListener = new su(this);
  byte mSource = dt.e;
  Button mTitleButton;
  private long mUin;
  
  static
  {
    if (!OpreateMsgActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      s_NeedShowNewMsgCnt = false;
      return;
    }
  }
  
  private void saveTimeZoneFlag()
  {
    SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("msg_tips_timezone", 0).edit();
    localEditor.putBoolean("msg_tips_timezone_flag", true);
    localEditor.commit();
  }
  
  public static void setShowNewMsgCnt()
  {
    s_NeedShowNewMsgCnt = true;
  }
  
  private void showDeleteDlg()
  {
    if (this.mIsSelectAll) {}
    for (String str = getString(2131230920);; str = getString(2131230923) + this.mCache.e() + getString(2131230922))
    {
      showUserDialog(2131230921, str, 2131230897, 2131230886, new sv(this), null);
      return;
    }
  }
  
  void checkTimeZoneFlag()
  {
    if ((!RqdApplication.l().getSharedPreferences("msg_tips_timezone", 0).getBoolean("msg_tips_timezone_flag", false)) && (this.mCache.g() > 0))
    {
      if (TimeZone.getDefault().getOffset(System.currentTimeMillis()) != 28800000)
      {
        View localView = findViewById(2131558985);
        localView.setVisibility(0);
        findViewById(2131558988).setOnClickListener(new sw(this, localView));
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
      if (isListEdit())
      {
        hideListEdit();
        this.mCache.c();
        this.mAdapter.notifyDataSetChanged();
        return true;
      }
    }
  }
  
  public void finishRefresh(boolean paramBoolean)
  {
    this.mListView.b();
    this.mIsRefreshing = false;
    this.mListView.setRefreshTime(System.currentTimeMillis());
    this.mListView.a("opreate_msg_refresh_time");
    if (paramBoolean) {
      showToast();
    }
    if (this.mCache.g() <= 0)
    {
      this.mTitleButton.setVisibility(4);
      return;
    }
    this.mTitleButton.setVisibility(0);
  }
  
  public void hideListEdit()
  {
    this.mIsEdit = false;
    this.mTitleButton.setText(2131230766);
    this.mListEidt.setVisibility(8);
  }
  
  public boolean isListEdit()
  {
    return this.mIsEdit;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968693);
    try
    {
      Activity.class.getDeclaredMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(this, new Object[] { Integer.valueOf(2131034135), Integer.valueOf(2131034134) });
      this.mListEidt = findViewById(2131559025);
      this.mListEidt.findViewById(2131559026).setOnClickListener(new sx(this, null));
      this.mEditSelectBtn = ((Button)this.mListEidt.findViewById(2131559027));
      this.mEditSelectBtn.setOnClickListener(new sy(this, null));
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
      this.mAdapter = new sn(this);
      paramBundle = LayoutInflater.from(this).inflate(2130968698, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mListView.setSelector(2130837832);
      this.mAdapter.a(paramBundle);
      paramBundle = LayoutInflater.from(this).inflate(2130968695, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mAdapter.b(paramBundle);
      this.mAdapter.c();
      this.mListView.setScrollingCacheEnabled(true);
      this.mListView.setOnRefreshListener(this);
      this.mListView.a(2131231274);
      this.mListView.setRefreshTime(this.mListView.b("opreate_msg_refresh_time"));
      paramBundle = getIntent().getBundleExtra("com.tencent.input_param");
      if (paramBundle == null) {
        break label430;
      }
    }
    if (paramBundle.getLong("uin") > 0L)
    {
      this.mUin = paramBundle.getLong("uin");
      do.a().a(this.mUin);
      this.mSource = dt.d;
      this.mTitleButton = getRightTitleButton();
      this.mTitleButton.setVisibility(0);
      this.mTitleButton.setText(2131230766);
      this.mTitleButton.setOnClickListener(this.mRightTitleButtonClickListener);
      if (this.mUin == 0L) {
        break label438;
      }
      this.mAdapter.a(false);
    }
    for (;;)
    {
      this.mListView.setAdapter(this.mAdapter);
      return;
      label430:
      this.mUin = 0L;
      break;
      label438:
      if (s_NeedShowNewMsgCnt)
      {
        this.mAdapter.a(true);
        s_NeedShowNewMsgCnt = false;
      }
      else
      {
        this.mAdapter.a(false);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mAdapter = null;
    this.mListView.setAdapter(null);
  }
  
  public void onRefresh()
  {
    if (this.mIsRefreshing) {
      return;
    }
    this.mIsRefreshing = true;
    this.mMsgMgr.b();
    this.mMsgMgr.a(this.mSource, this.mHandler);
  }
  
  protected void onResume()
  {
    h.c("login user queryed: " + this.mMsgMgr.d() + ", muin: " + this.mUin);
    if (((!this.mMsgMgr.d()) && (!this.mIsRefreshing)) || ((this.mUin > 0L) && (!this.mIsRefreshing)))
    {
      h.c("refresh safe msg: ");
      startRefresh(this.mSource);
      this.mUin = 0L;
    }
    this.mAdapter.notifyDataSetChanged();
    super.onResume();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void setSelectState(boolean paramBoolean)
  {
    this.mIsSelectAll = paramBoolean;
    if (this.mIsSelectAll)
    {
      this.mEditSelectBtn.setText(2131230880);
      return;
    }
    this.mEditSelectBtn.setText(2131230882);
  }
  
  public void showListEdit()
  {
    this.mIsEdit = true;
    this.mTitleButton.setText(2131230765);
    this.mListEidt.setVisibility(0);
  }
  
  public void showToast()
  {
    if (this.mCache.h() > 0)
    {
      showOrangeToast(this.mMsgMgr.f() + getResources().getString(2131230893), 2130838017);
      return;
    }
    showOrangeToast(2131231271, 2130838017);
  }
  
  public void startRefresh(byte paramByte)
  {
    this.mMsgMgr.b();
    this.mSource = paramByte;
    this.mHaveMsgReqTimes = 0;
    this.mListView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.OpreateMsgActivity
 * JD-Core Version:    0.7.0.1
 */