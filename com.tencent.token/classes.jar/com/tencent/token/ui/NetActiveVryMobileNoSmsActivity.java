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
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.h;

public class NetActiveVryMobileNoSmsActivity
  extends BaseActivity
{
  private final int INTERVAL_TIME_AFTER_GET_SMS_1 = 60;
  private final int INTERVAL_TIME_AFTER_GET_SMS_2 = 99;
  private final int MSG_LOADING = 100;
  private final int SMS_INTERVAL = 3000;
  private final int UPDATE_TIME = -100;
  private boolean isFirstFactor = false;
  private View.OnClickListener mBindTokenListener = new qn(this);
  private int mCGISendSMSCount = 0;
  private View.OnClickListener mCancelButtonListener = new qk(this);
  private View.OnClickListener mConfirmSendSmsListener = new ql(this);
  Handler mHandler = new qo(this);
  private int mIntervalTime = 0;
  private boolean mIsActiveSuccess = false;
  private boolean mIsAutoSumbit = false;
  private boolean mIsSMSRegisted = false;
  private int mPageId;
  private View.OnClickListener mReSendButtonListener = new qm(this);
  private cw mTokenCore = cw.a();
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  
  private void checkAndGetSMS(boolean paramBoolean1, boolean paramBoolean2)
  {
    h.a("interval: " + this.mIntervalTime + "  count: " + this.mCGISendSMSCount);
    if (this.mIntervalTime > 0)
    {
      if (paramBoolean2) {
        showUserDialog(2131230779, String.format(getResources().getString(2131230805), new Object[] { Integer.valueOf(this.mIntervalTime) }), 2131230897, null);
      }
      return;
    }
    if (paramBoolean1)
    {
      Intent localIntent = new Intent(this, NetActiveVryOtherListActivity.class);
      localIntent.putExtra("page_id", this.mPageId);
      localIntent.putExtra("intent.qquser", this.mUser);
      localIntent.putExtra("intent.determin_factors_result", this.mVerifyResult);
      localIntent.putExtra("intent.determin_verify_type", this.mVerifyType);
      startActivity(localIntent);
      finish();
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
      this.mTokenCore.f(this.mUser.mRealUin, this.mHandler);
      return;
    }
  }
  
  private void hideKeyBoard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  private void init()
  {
    setTitle(2131231657);
    String str = this.mVerifyResult.g();
    if ((str == null) || (str.length() == 0))
    {
      finish();
      return;
    }
    ((Button)findViewById(2131558730)).setOnClickListener(this.mConfirmSendSmsListener);
    ((TextView)findViewById(2131558740)).setOnClickListener(this.mCancelButtonListener);
    ((TextView)findViewById(2131559076)).setText(2131230796);
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
  
  private void sendDnaBind()
  {
    this.mTokenCore.b(this.mUser.mRealUin, this.mVerifyType.a(), "", "+86", this.mHandler);
  }
  
  private void setActiveSucc()
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = this.mUser.mRealUin + "";
    do.a().f(Long.parseLong((String)localObject));
    cw.a().b(this.mHandler);
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
    showUserDialog(2131230779, paramString, 2131230897, new qp(this));
  }
  
  private void showMobileFreqFail(String paramString)
  {
    showUserDialog(2131230843, paramString, 2131230897, new qq(this), new qr(this));
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
    this.mTokenCore.c(this.mUser.mRealUin, paramString, this.mVerifyType.a(), this.mHandler);
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
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        default: 
          if ((this.isFirstFactor) && (paramKeyEvent.getAction() == 0)) {}
          switch (paramKeyEvent.getKeyCode())
          {
          case 4: 
            return super.dispatchKeyEvent(paramKeyEvent);
          }
          break;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      startActivity(abi.a().a(this));
      return true;
    }
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
    this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    this.isFirstFactor = getIntent().getBooleanExtra("intent.determin_first_verify_factor", false);
    if ((this.mUser == null) || (this.mVerifyResult == null))
    {
      finish();
      return;
    }
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      setNeverShowLockVerifyView();
    }
    this.mPageId = getIntent().getIntExtra("page_id", 0);
    setContentView(2130968703);
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeMessages(-100);
    }
    abi.c();
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
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new qs(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryMobileNoSmsActivity
 * JD-Core Version:    0.7.0.1
 */