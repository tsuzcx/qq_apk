package com.tencent.token.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;

public class UtilsModSetMobileStep2Activity
  extends BaseActivity
  implements View.OnClickListener
{
  private final int INTERVAL_TIME_SEND_SMS = 60;
  private final String RECEIVE_SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
  private final String UPDATE_INTERVAL_TIME_ACTION = "com.tencent.token.GET_MOBILE_CODE_INTERVAL";
  private String mCountryCode;
  private Handler mHandler = new afm(this);
  private AlarmManager mIntervalAlarmMgr = null;
  private PendingIntent mIntervalPending = null;
  private BroadcastReceiver mIntervalReceiver = new afj(this);
  private int mIntervalTime = 60;
  private boolean mIsModSetSucc = false;
  private boolean mIsSMSRegisted = false;
  private String mMobile;
  private int mOpType;
  private int mPageId;
  private BroadcastReceiver mSMSReceiver = new afk(this);
  private String mSmsPrefix;
  private Button mStep2BindBtn;
  private TextView mStep2CodeText;
  private Button mStep2ReSendBtn;
  private String mTitle;
  
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
  
  private void init()
  {
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      finish();
      return;
    }
    if ((((Bundle)localObject).getInt("op_type", 0) == 0) || (((Bundle)localObject).getString("title") == null) || (((Bundle)localObject).getString("mobile") == null))
    {
      finish();
      return;
    }
    this.mPageId = ((Bundle)localObject).getInt("page_id");
    this.mOpType = ((Bundle)localObject).getInt("op_type", 0);
    this.mSmsPrefix = ((Bundle)localObject).getString("sms_prefix");
    this.mMobile = ((Bundle)localObject).getString("mobile");
    this.mCountryCode = ((Bundle)localObject).getString("area_code");
    this.mTitle = ((Bundle)localObject).getString("title");
    setTitle(this.mTitle);
    e.c("test mbinfo, positon=, optype=" + this.mOpType + ", sms_prefix=" + this.mSmsPrefix + ", mobile=" + this.mMobile + ", area_code=" + this.mCountryCode);
    registerSMSReceiver();
    registerIntervalTimer();
    localObject = getResources().getString(2131362210);
    String str = s.a(this.mMobile);
    SpannableString localSpannableString = new SpannableString((String)localObject + str + getResources().getString(2131362211));
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131165212)), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
    ((TextView)findViewById(2131297257)).setText(localSpannableString);
    this.mStep2CodeText = ((EditText)findViewById(2131297259));
    if (this.mStep2CodeText != null) {
      this.mStep2CodeText.clearFocus();
    }
    this.mStep2ReSendBtn = ((Button)findViewById(2131297260));
    this.mStep2BindBtn = ((Button)findViewById(2131297261));
    this.mStep2ReSendBtn.setOnClickListener(this);
    this.mStep2BindBtn.setOnClickListener(this);
  }
  
  private void registerIntervalTimer()
  {
    if (this.mIntervalAlarmMgr != null) {
      return;
    }
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.token.GET_MOBILE_CODE_INTERVAL");
    registerReceiver(this.mIntervalReceiver, (IntentFilter)localObject);
    localObject = new Intent("com.tencent.token.GET_MOBILE_CODE_INTERVAL");
    this.mIntervalAlarmMgr = ((AlarmManager)getSystemService("alarm"));
    this.mIntervalPending = PendingIntent.getBroadcast(this, 0, (Intent)localObject, 0);
  }
  
  private void registerSMSReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
    registerReceiver(this.mSMSReceiver, localIntentFilter, "android.permission.RECEIVE_SMS", null);
    this.mIsSMSRegisted = true;
  }
  
  private void unregisterIntervalTimer()
  {
    if (this.mIntervalAlarmMgr != null)
    {
      this.mIntervalAlarmMgr.cancel(this.mIntervalPending);
      unregisterReceiver(this.mIntervalReceiver);
      this.mIntervalAlarmMgr = null;
    }
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
    e.a("update interval: " + this.mIntervalTime);
    this.mIntervalTime -= 1;
    if (this.mIntervalTime <= 0)
    {
      this.mStep2ReSendBtn.setTextColor(getResources().getColor(2131165192));
      this.mStep2ReSendBtn.setText(2131362212);
      this.mStep2ReSendBtn.setTextSize(0, getResources().getDimensionPixelSize(2131230731));
      this.mStep2ReSendBtn.setEnabled(true);
    }
    long l;
    do
    {
      return;
      this.mStep2ReSendBtn.setEnabled(false);
      String str2 = getResources().getString(2131362212) + "\n(";
      String str1 = str2;
      if (this.mIntervalTime < 10) {
        str1 = str2 + "0";
      }
      str1 = str1 + this.mIntervalTime + ")";
      if (this.mStep2ReSendBtn != null)
      {
        this.mStep2ReSendBtn.setText(str1);
        this.mStep2ReSendBtn.setTextColor(getResources().getColor(2131165197));
        this.mStep2ReSendBtn.setTextSize(0, getResources().getDimensionPixelSize(2131230728));
      }
      l = System.currentTimeMillis();
    } while (this.mIntervalAlarmMgr == null);
    this.mIntervalAlarmMgr.set(1, l + 1000L, this.mIntervalPending);
  }
  
  private void vryMobileCode()
  {
    if (this.mStep2CodeText == null) {
      return;
    }
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    String str = this.mStep2CodeText.getText().toString();
    if ((str != null) && (str.length() != 0))
    {
      af.a().a(0L, str, this.mHandler);
      showProDialog(this, 2131361808, getResources().getString(2131362216) + this.mTitle + getResources().getString(2131362217), null);
      return;
    }
    showToast(2131362214);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsModSetSucc) && (paramKeyEvent.getAction() == 0)) {}
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297260: 
      this.mIntervalTime = 60;
      updateIntervalTimer();
      af.a().b(0L, this.mOpType, this.mMobile, this.mCountryCode, this.mHandler);
      return;
    case 2131297261: 
      vryMobileCode();
      return;
    }
    if (this.mPageId == 10)
    {
      paramView = new Intent(this, IndexActivity.class);
      paramView.putExtra("index_from", 16);
      startActivity(paramView);
    }
    for (;;)
    {
      finish();
      return;
      startActivity(new Intent(this, UtilsMbInfoActivity.class));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903246);
    init();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mIsSMSRegisted)
    {
      unregisterReceiver(this.mSMSReceiver);
      this.mIsSMSRegisted = false;
    }
    if (this.mIntervalAlarmMgr != null)
    {
      this.mIntervalAlarmMgr.cancel(this.mIntervalPending);
      unregisterReceiver(this.mIntervalReceiver);
      this.mIntervalAlarmMgr = null;
    }
    af.a().a(getClass().getName());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mIntervalAlarmMgr != null) {
      updateIntervalTimer();
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsModSetMobileStep2Activity
 * JD-Core Version:    0.7.0.1
 */