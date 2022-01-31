package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.cw;
import com.tencent.token.global.h;

public class VryMobileForStrategyActivity
  extends BaseActivity
{
  private final int INTERVAL_TIME_AFTER_GET_SMS_1 = 60;
  private final int INTERVAL_TIME_AFTER_GET_SMS_2 = 99;
  private final int MSG_LOADING = 100;
  private final int UPDATE_TIME = -100;
  private View.OnClickListener mBindTokenListener = new afk(this);
  private int mCGISendSMSCount = 0;
  private View.OnClickListener mCancelButtonListener = new afh(this);
  private View.OnClickListener mConfirmSendSmsListener = new afi(this);
  Handler mHandler = new afl(this);
  private int mIntervalTime = 0;
  private boolean mIsAutoSumbit = false;
  private View.OnClickListener mReSendButtonListener = new afj(this);
  private cw mTokenCore = cw.a();
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  private boolean nextpage = false;
  
  private void checkAndGetSMS()
  {
    h.a("interval: " + this.mIntervalTime + "  count: " + this.mCGISendSMSCount);
    if (this.mIntervalTime > 0) {
      return;
    }
    getSMS();
  }
  
  private void getSMS()
  {
    this.mCGISendSMSCount += 1;
    if (1 == this.mCGISendSMSCount) {}
    for (this.mIntervalTime = 60;; this.mIntervalTime = 99)
    {
      updateIntervalTimer();
      this.mTokenCore.a(0L, Long.valueOf(this.mUser.mRealUin), 1006, this.mHandler);
      return;
    }
  }
  
  private void hideKeyBoard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  private void init()
  {
    setTitle(2131231620);
    String str = this.mUpDetermin.mMobileMask;
    if ((str == null) || (str.length() == 0))
    {
      finish();
      return;
    }
    ((Button)findViewById(2131558730)).setOnClickListener(this.mConfirmSendSmsListener);
    Button localButton = (Button)findViewById(2131558731);
    localButton.setOnClickListener(this.mCancelButtonListener);
    localButton.setText(2131231504);
    ((TextView)findViewById(2131559076)).setText(2131231613);
    ((TextView)findViewById(2131558728)).setText(str);
  }
  
  private void initSMS()
  {
    Button localButton = (Button)findViewById(2131559081);
    Object localObject = (EditText)findViewById(2131559080);
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    String str = getResources().getString(2131230800) + "\n(";
    localObject = str;
    if (this.mIntervalTime < 10) {
      localObject = str + "0";
    }
    localButton.setText((String)localObject + this.mIntervalTime + ")");
    localButton.setTextColor(getResources().getColor(2131492930));
    localButton.setOnClickListener(this.mReSendButtonListener);
    findViewById(2131559083).setOnClickListener(this.mBindTokenListener);
  }
  
  private boolean setTime(long paramLong)
  {
    Button localButton = (Button)findViewById(2131559081);
    if (paramLong <= 0L)
    {
      if (localButton != null)
      {
        localButton.setTextColor(getResources().getColor(2131492925));
        localButton.setText(2131230800);
        localButton.setTextSize(0, getResources().getDimensionPixelSize(2131296403));
      }
      return false;
    }
    String str2 = getResources().getString(2131230800) + "\n(";
    String str1 = str2;
    if (this.mIntervalTime < 10) {
      str1 = str2 + "0";
    }
    str1 = str1 + this.mIntervalTime + ")";
    if (localButton != null)
    {
      localButton.setText(str1);
      localButton.setTextColor(getResources().getColor(2131492930));
      localButton.setTextSize(0, getResources().getDimensionPixelSize(2131296400));
    }
    return true;
  }
  
  private void showBindFailDialog(String paramString)
  {
    showUserDialog(2131230779, paramString, 2131230897, new afm(this));
  }
  
  private void showMobileFreqFail(String paramString)
  {
    showUserDialog(2131230843, paramString, 2131230897, new afn(this));
  }
  
  private void updateIntervalTimer()
  {
    this.mIntervalTime -= 1;
    if (setTime(this.mIntervalTime)) {
      this.mHandler.sendEmptyMessageDelayed(-100, 1000L);
    }
  }
  
  private void vrySmsCode(String paramString)
  {
    this.mTokenCore.a(this.mUser.mUin, this.mUser.mRealUin, 1006, paramString, 0, this.mHandler);
  }
  
  public void cancelRequest()
  {
    this.mTokenCore.a(getClass().getName());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((this.nextpage) && (paramKeyEvent.getAction() == 0)) {}
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
      setContentView(2130968703);
      this.mIntervalTime = 0;
      this.nextpage = false;
      init();
      return true;
    }
  }
  
  public void onBackPressed()
  {
    exit();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      h.c("isshowingverifyfalse");
      com.tencent.token.global.RqdApplication.b = false;
      finish();
      return;
    }
    com.tencent.token.global.RqdApplication.b = true;
    if (getIntent().getBooleanExtra("succ", false))
    {
      h.c("isshowingverifyfalse");
      com.tencent.token.global.RqdApplication.b = false;
      finish();
      return;
    }
    setContentView(2130968821);
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeMessages(-100);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    h.a("pause");
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.VryMobileForStrategyActivity
 * JD-Core Version:    0.7.0.1
 */