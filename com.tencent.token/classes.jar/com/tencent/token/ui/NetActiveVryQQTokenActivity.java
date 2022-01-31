package com.tencent.token.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
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

public class NetActiveVryQQTokenActivity
  extends BaseActivity
{
  private AlarmManager mAlarmMgr = null;
  private View.OnClickListener mBindButtonListener = new ru(this);
  private View.OnClickListener mCompleteButtonListener = new rt(this);
  private View.OnClickListener mConfirmMobileButtonListener = new rv(this);
  private String mCountryCode = "+86";
  private View.OnClickListener mCountryListener = new rw(this);
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new rs(this);
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private EditText mMobileText;
  private PendingIntent mPending = null;
  private af mTokenCore = af.a();
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  private View.OnClickListener mVryQQTokenButtonListener = new rx(this);
  private View mcountry;
  
  private void hideKeyBoard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  private void init()
  {
    int i = 1;
    findViewById(2131296442).setOnClickListener(this.mVryQQTokenButtonListener);
    this.mIsActiveSuccess = false;
    setTitle(2131362363);
    if (this.mUpDetermin.mQqtokenAppear == 1) {}
    for (;;)
    {
      if (i == 0) {
        finish();
      }
      return;
      i = 0;
    }
  }
  
  private void sendDnaBind()
  {
    this.mTokenCore.c(this.mUser.mRealUin, 1, this.mMobile, this.mCountryCode, this.mHandler);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = ag.c();
    ((ag)localObject).i();
    ((ag)localObject).n();
    localObject = this.mUser.mRealUin + "";
    this.mIsActiveSuccess = true;
    int i;
    if (this.mUpDetermin.mHaveMobile == 1)
    {
      i = 1;
      if (i != 0) {
        break label265;
      }
      if (!paramBoolean) {
        break label255;
      }
      setContentView(2130903052);
      label70:
      this.mBackArrow.setVisibility(4);
      ax.a().f(Long.parseLong((String)localObject));
      ((Button)findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
      setTitle(2131361842);
      ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
      if (this.mUpDetermin.mHaveMobile != 1) {
        break label275;
      }
      i = 1;
      label168:
      if (i == 0)
      {
        localObject = (TextView)findViewById(2131296402);
        if (!paramBoolean) {
          break label280;
        }
        String str = getString(2131361843) + " ";
        ((TextView)localObject).setText(str + this.mMobile);
      }
    }
    for (;;)
    {
      a.a().a(8);
      return;
      i = 0;
      break;
      label255:
      setContentView(2130903051);
      break label70;
      label265:
      setContentView(2130903050);
      break label70;
      label275:
      i = 0;
      break label168;
      label280:
      ((Button)findViewById(2131296403)).setOnClickListener(this.mBindButtonListener);
      ((TextView)localObject).setText(getResources().getString(2131361832));
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt2 == 1111) {}
    for (paramIntent = "+1";; paramIntent = "+" + paramInt2)
    {
      this.mCountryCode = paramIntent;
      s.a(paramInt2, this.mCountry_name, this.mCountry_number);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903149);
    paramBundle = (EditText)findViewById(2131296891);
    if (paramBundle != null) {
      paramBundle.clearFocus();
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    finish();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryQQTokenActivity
 * JD-Core Version:    0.7.0.1
 */