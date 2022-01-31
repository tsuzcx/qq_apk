package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.global.e;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class NetActiveVryMobileNoSmsActivity
  extends BaseActivity
{
  private final int INTERVAL_TIME_AFTER_GET_SMS_1 = 60;
  private final int INTERVAL_TIME_AFTER_GET_SMS_2 = 99;
  private final int MSG_LOADING = 100;
  private final String RECEIVE_SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
  private final int SMS_INTERVAL = 3000;
  private final int UPDATE_TIME = -100;
  private View.OnClickListener mBindTokenListener = new rh(this);
  private int mCGISendSMSCount = 0;
  private View.OnClickListener mCancelButtonListener = new re(this);
  private View.OnClickListener mCompleteButtonListener = new rd(this);
  private View.OnClickListener mConfirmSendSmsListener = new rf(this);
  Handler mHandler = new ri(this);
  private int mIntervalTime = 0;
  private boolean mIsActiveSuccess = false;
  private boolean mIsAutoSumbit = false;
  private boolean mIsSMSRegisted = false;
  private int mPageId;
  private View.OnClickListener mReSendButtonListener = new rg(this);
  private BroadcastReceiver mSMSReceiver = new rb(this);
  private af mTokenCore = af.a();
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  
  private void checkAndGetSMS(boolean paramBoolean)
  {
    e.a("interval: " + this.mIntervalTime + "  count: " + this.mCGISendSMSCount);
    if (this.mIntervalTime > 0) {
      return;
    }
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this, NetActiveVryOtherListActivity.class);
      localIntent.putExtra("page_id", this.mPageId);
      localIntent.putExtra("intent.qquser", this.mUser);
      localIntent.putExtra("intent.upgradedetermin", this.mUpDetermin);
      startActivity(localIntent);
      finish();
      return;
    }
    getSMS();
  }
  
  private SmsMessage[] getMessage(Intent paramIntent)
  {
    paramIntent = (Object[])paramIntent.getSerializableExtra("pdus");
    if (paramIntent == null) {
      return null;
    }
    int j = paramIntent.length;
    SmsMessage[] arrayOfSmsMessage = new SmsMessage[j];
    int i = 0;
    while (i < j)
    {
      arrayOfSmsMessage[i] = SmsMessage.createFromPdu((byte[])paramIntent[i]);
      i += 1;
    }
    return arrayOfSmsMessage;
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
    setTitle(2131362363);
    String str = this.mUpDetermin.mMobileMask;
    if ((str == null) || (str.length() == 0))
    {
      finish();
      return;
    }
    ((Button)findViewById(2131296442)).setOnClickListener(this.mConfirmSendSmsListener);
    Button localButton = (Button)findViewById(2131296443);
    localButton.setOnClickListener(this.mCancelButtonListener);
    localButton.setText(2131361824);
    ((TextView)findViewById(2131296882)).setText(2131361819);
    ((TextView)findViewById(2131296440)).setText(str);
  }
  
  private void initSMS()
  {
    Button localButton = (Button)findViewById(2131296887);
    Object localObject = (EditText)findViewById(2131296886);
    if (localObject != null) {
      ((EditText)localObject).clearFocus();
    }
    String str = getResources().getString(2131361823) + "\n(";
    localObject = str;
    if (this.mIntervalTime < 10) {
      localObject = str + "0";
    }
    localButton.setText((String)localObject + this.mIntervalTime + ")");
    localButton.setTextColor(getResources().getColor(2131165197));
    localButton.setOnClickListener(this.mReSendButtonListener);
    findViewById(2131296889).setOnClickListener(this.mBindTokenListener);
  }
  
  private void registerSMSReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
    registerReceiver(this.mSMSReceiver, localIntentFilter, "android.permission.RECEIVE_SMS", null);
    this.mIsSMSRegisted = true;
  }
  
  private void sendDnaBind()
  {
    this.mTokenCore.c(this.mUser.mRealUin, 1, "", "+86", this.mHandler);
  }
  
  private void setActiveSucc()
  {
    Object localObject = ag.c();
    ((ag)localObject).i();
    ((ag)localObject).n();
    localObject = this.mUser.mRealUin + "";
    this.mIsActiveSuccess = true;
    setContentView(2130903050);
    this.mBackArrow.setVisibility(4);
    ax.a().f(Long.parseLong((String)localObject));
    findViewById(2131296398).setOnClickListener(this.mCompleteButtonListener);
    setTitle(2131361842);
    ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
    a.a().a(8);
  }
  
  private void setTextFromSMS(String paramString)
  {
    EditText localEditText = (EditText)findViewById(2131296886);
    if (localEditText != null)
    {
      localEditText.setText(paramString);
      findViewById(2131296888).setVisibility(0);
      if (this.mIsSMSRegisted)
      {
        unregisterReceiver(this.mSMSReceiver);
        this.mIsSMSRegisted = false;
      }
      this.mIsAutoSumbit = true;
      localEditText.postDelayed(new rj(this, paramString), 3000L);
    }
  }
  
  private boolean setTime(long paramLong)
  {
    Button localButton = (Button)findViewById(2131296887);
    if (paramLong <= 0L)
    {
      if (localButton != null)
      {
        localButton.setTextColor(getResources().getColor(2131165192));
        localButton.setText(2131361823);
        localButton.setTextSize(0, getResources().getDimensionPixelSize(2131230731));
      }
      return false;
    }
    String str2 = getResources().getString(2131361823) + "\n(";
    String str1 = str2;
    if (this.mIntervalTime < 10) {
      str1 = str2 + "0";
    }
    str1 = str1 + this.mIntervalTime + ")";
    if (localButton != null)
    {
      localButton.setText(str1);
      localButton.setTextColor(getResources().getColor(2131165197));
      localButton.setTextSize(0, getResources().getDimensionPixelSize(2131230728));
    }
    return true;
  }
  
  private void showBindFailDialog(String paramString)
  {
    showUserDialog(2131361831, paramString, 2131361800, new rk(this));
  }
  
  private void showKeyBoard(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramView, 1);
  }
  
  private void showMobileFreqFail(String paramString)
  {
    showUserDialog(2131361808, paramString, 2131361800, new rc(this));
  }
  
  private void unregisterSMSReceiver()
  {
    if (this.mIsSMSRegisted)
    {
      unregisterReceiver(this.mSMSReceiver);
      this.mIsSMSRegisted = false;
    }
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
    this.mTokenCore.c(this.mUser.mRealUin, paramString, this.mHandler);
  }
  
  public void cancelRequest()
  {
    this.mTokenCore.a(getClass().getName());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    this.mPageId = getIntent().getIntExtra("page_id", 0);
    setContentView(2130903147);
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeMessages(-100);
    }
    if (this.mIsSMSRegisted)
    {
      unregisterReceiver(this.mSMSReceiver);
      this.mIsSMSRegisted = false;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    e.a("pause");
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryMobileNoSmsActivity
 * JD-Core Version:    0.7.0.1
 */