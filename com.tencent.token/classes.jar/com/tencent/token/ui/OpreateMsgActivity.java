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
import com.tencent.token.ax;
import com.tencent.token.bc;
import com.tencent.token.bd;
import com.tencent.token.fo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.PullToRefreshListView;
import com.tencent.token.ui.base.cq;
import java.lang.reflect.Method;
import java.util.TimeZone;

public class OpreateMsgActivity
  extends BaseActivity
  implements cq
{
  public static final String PREFER_TIME = "opreate_msg_refresh_time";
  public static boolean s_NeedShowNewMsgCnt;
  tj mAdapter;
  private fo mCache = bd.a().f;
  Button mEditSelectBtn;
  public Handler mHandler = new tp(this);
  private int mHaveMsgReqTimes = 0;
  private boolean mIsEdit = false;
  public boolean mIsRefreshing = false;
  boolean mIsSelectAll;
  View mListEidt;
  PullToRefreshListView mListView;
  private bd mMsgMgr = bd.a();
  private View.OnClickListener mRightTitleButtonClickListener = new tq(this);
  byte mSource = bc.e;
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
    SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("msg_tips_timezone", 0).edit();
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
    for (String str = getString(2131362012);; str = getString(2131362007) + this.mCache.e() + getString(2131362008))
    {
      showUserDialog(2131362006, str, 2131361800, 2131361804, new tr(this), null);
      return;
    }
  }
  
  void checkTimeZoneFlag()
  {
    if ((!RqdApplication.i().getSharedPreferences("msg_tips_timezone", 0).getBoolean("msg_tips_timezone_flag", false)) && (this.mCache.g() > 0))
    {
      if (TimeZone.getDefault().getOffset(System.currentTimeMillis()) != 28800000)
      {
        View localView = findViewById(2131296782);
        localView.setVisibility(0);
        findViewById(2131296785).setOnClickListener(new ts(this, localView));
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
    this.mListView.a(System.currentTimeMillis());
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
    this.mTitleButton.setText(2131362291);
    this.mListEidt.setVisibility(8);
  }
  
  public boolean isListEdit()
  {
    return this.mIsEdit;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903137);
    try
    {
      Activity.class.getDeclaredMethod("overridePendingTransition", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(this, new Object[] { Integer.valueOf(2130968585), Integer.valueOf(2130968584) });
      this.mListEidt = findViewById(2131296827);
      this.mListEidt.findViewById(2131296828).setOnClickListener(new tt(this));
      this.mEditSelectBtn = ((Button)this.mListEidt.findViewById(2131296829));
      this.mEditSelectBtn.setOnClickListener(new tu(this));
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
      this.mAdapter = new tj(this);
      paramBundle = LayoutInflater.from(this).inflate(2130903142, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mListView.setSelector(2130837756);
      this.mAdapter.a(paramBundle);
      paramBundle = LayoutInflater.from(this).inflate(2130903139, this.mListView, false);
      this.mListView.addFooterView(paramBundle);
      this.mAdapter.b(paramBundle);
      this.mAdapter.a();
      this.mListView.setScrollingCacheEnabled(true);
      this.mListView.a(this);
      this.mListView.a(2131362042);
      this.mListView.a(this.mListView.b("opreate_msg_refresh_time"));
      paramBundle = getIntent().getBundleExtra("com.tencent.input_param");
      if (paramBundle == null) {
        break label438;
      }
    }
    if (paramBundle.getLong("uin") > 0L)
    {
      this.mUin = paramBundle.getLong("uin");
      ax.a().a(this.mUin);
      this.mSource = bc.d;
      this.mTitleButton = getRightTitleButton();
      this.mTitleButton.setVisibility(0);
      this.mTitleButton.setText(2131362291);
      this.mTitleButton.setOnClickListener(this.mRightTitleButtonClickListener);
      if ((this.mUin != 0L) || (!s_NeedShowNewMsgCnt)) {
        break label446;
      }
      this.mAdapter.a(true);
      s_NeedShowNewMsgCnt = false;
    }
    for (;;)
    {
      this.mListView.setAdapter(this.mAdapter);
      return;
      label438:
      this.mUin = 0L;
      break;
      label446:
      this.mAdapter.a(false);
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
    e.c("login user queryed: " + this.mMsgMgr.d() + ", muin: " + this.mUin);
    if (((!this.mMsgMgr.d()) && (!this.mIsRefreshing)) || ((this.mUin > 0L) && (!this.mIsRefreshing)))
    {
      e.c("refresh safe msg: ");
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
      this.mEditSelectBtn.setText(2131362011);
      return;
    }
    this.mEditSelectBtn.setText(2131362010);
  }
  
  public void showListEdit()
  {
    this.mIsEdit = true;
    this.mTitleButton.setText(2131362292);
    this.mListEidt.setVisibility(0);
  }
  
  public void showToast()
  {
    if (this.mCache.i() > 0)
    {
      showOrangeToast(this.mMsgMgr.g() + getResources().getString(2131362016), 2130837964);
      return;
    }
    showOrangeToast(2131362015, 2130837964);
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