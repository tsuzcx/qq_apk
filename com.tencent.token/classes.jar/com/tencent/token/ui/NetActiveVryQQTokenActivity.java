package com.tencent.token.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.h;

public class NetActiveVryQQTokenActivity
  extends BaseActivity
{
  private boolean isFirstFactor = false;
  private AlarmManager mAlarmMgr = null;
  private String mCountryCode = "+86";
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new qz(this);
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private EditText mMobileText;
  private PendingIntent mPending = null;
  private cw mTokenCore = cw.a();
  private Handler mUinListHandler = new cb(this);
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private View.OnClickListener mVryQQTokenButtonListener = new ra(this);
  private View mcountry;
  
  private void hideKeyBoard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  private void init()
  {
    findViewById(2131558730).setOnClickListener(this.mVryQQTokenButtonListener);
    this.mIsActiveSuccess = false;
    setTitle(2131231657);
    ((TextView)findViewById(2131558740)).setOnClickListener(new rb(this));
  }
  
  private void sendDnaBind()
  {
    this.mTokenCore.b(this.mUser.mRealUin, this.mVerifyType.a(), this.mMobile, this.mCountryCode, this.mHandler);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = this.mUser.mRealUin + "";
    Intent localIntent = new Intent(this, VerifySuccActivity.class);
    localIntent.putExtra("mRealUin", Long.parseLong((String)localObject));
    localIntent.putExtra("mMobile", this.mMobile);
    if (!this.mVerifyResult.b()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isHaveMobie", bool);
      localIntent.putExtra("bindMobileSucc", paramBoolean);
      if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
        localIntent.putExtra("mSourceId", 1);
      }
      startActivity(localIntent);
      finish();
      return;
    }
  }
  
  private void showKeyBoard(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramView, 1);
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("name");
    this.mCountryCode = ("+" + paramInt2);
    this.mCountry_name.setText(paramIntent);
    this.mCountry_number.setText(this.mCountryCode);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
    this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    this.isFirstFactor = getIntent().getBooleanExtra("intent.determin_first_verify_factor", false);
    if ((this.mUser == null) || (this.mVerifyResult == null) || (this.mVerifyType == null))
    {
      finish();
      return;
    }
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      setNeverShowLockVerifyView();
    }
    setContentView(2130968705);
    paramBundle = (EditText)findViewById(2131559085);
    if (paramBundle != null) {
      paramBundle.clearFocus();
    }
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    finish();
    abi.c();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mAlarmMgr != null) {
      this.mAlarmMgr.cancel(this.mPending);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new rc(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryQQTokenActivity
 * JD-Core Version:    0.7.0.1
 */