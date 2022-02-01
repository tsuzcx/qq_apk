package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.cb;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;

public class VryMobileForStrategyActivity
  extends BaseActivity
{
  private final int INTERVAL_TIME_AFTER_GET_SMS_1 = 60;
  private final int INTERVAL_TIME_AFTER_GET_SMS_2 = 99;
  private final int MSG_LOADING = 100;
  private final int UPDATE_TIME = -100;
  private View.OnClickListener mBindTokenListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (VryMobileForStrategyActivity.this.mIsAutoSumbit) {
        return;
      }
      VryMobileForStrategyActivity.this.hideKeyBoard();
      paramAnonymousView = (EditText)VryMobileForStrategyActivity.this.findViewById(2131559081);
      String str = paramAnonymousView.getText().toString();
      if (paramAnonymousView != null) {
        paramAnonymousView.clearFocus();
      }
      if ((str != null) && (str.length() > 0))
      {
        VryMobileForStrategyActivity.this.vrySmsCode(str);
        VryMobileForStrategyActivity.this.showProDialog(VryMobileForStrategyActivity.this, 2131230843, 2131231298, null);
        return;
      }
      VryMobileForStrategyActivity.this.showToast(2131230959);
    }
  };
  private int mCGISendSMSCount = 0;
  private View.OnClickListener mCancelButtonListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      l.a(VryMobileForStrategyActivity.this, VryMobileForStrategyActivity.this.getResources().getString(2131230861), VryMobileForStrategyActivity.this.getResources().getString(2131231620));
    }
  };
  private View.OnClickListener mConfirmSendSmsListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      VryMobileForStrategyActivity.this.updateIntervalTimer();
      VryMobileForStrategyActivity.this.checkAndGetSMS();
    }
  };
  Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((VryMobileForStrategyActivity.this == null) || ((VryMobileForStrategyActivity.this != null) && (VryMobileForStrategyActivity.this.isFinishing()))) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        g.c("unknown msg: " + paramAnonymousMessage.what);
        return;
      case -100: 
        VryMobileForStrategyActivity.this.updateIntervalTimer();
        return;
      case 100: 
        VryMobileForStrategyActivity.this.showProDialog(VryMobileForStrategyActivity.this, 2131230843, 2131231298, null);
        return;
      case 3065: 
        if (paramAnonymousMessage.arg1 != 0)
        {
          VryMobileForStrategyActivity.access$202(VryMobileForStrategyActivity.this, 0);
          paramAnonymousMessage = (e)paramAnonymousMessage.obj;
          g.c("err " + paramAnonymousMessage.a);
          e.a(VryMobileForStrategyActivity.this.getResources(), paramAnonymousMessage);
          g.c("get mobile code failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
          VryMobileForStrategyActivity.this.mHandler.removeMessages(-100);
          if (124 == paramAnonymousMessage.a)
          {
            VryMobileForStrategyActivity.this.mUpDetermin.mSmsPrefix = ProtoGeneralGetMobileCode.f;
            VryMobileForStrategyActivity.this.showMobileFreqFail(paramAnonymousMessage.c);
            return;
          }
          VryMobileForStrategyActivity.this.showUserDialog(2131230843, paramAnonymousMessage.c, 2131230897, null);
          return;
        }
        VryMobileForStrategyActivity.this.mUpDetermin.mSmsPrefix = ProtoGeneralGetMobileCode.f;
        VryMobileForStrategyActivity.access$902(VryMobileForStrategyActivity.this, true);
        VryMobileForStrategyActivity.this.setContentView(2130968704);
        VryMobileForStrategyActivity.this.setTitle(2131231620);
        VryMobileForStrategyActivity.this.initSMS();
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        VryMobileForStrategyActivity.this.dismissDialog();
        com.tencent.token.global.RqdApplication.b = false;
        VryMobileForStrategyActivity.this.finish();
        return;
      }
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      g.c("err " + paramAnonymousMessage.a);
      e.a(VryMobileForStrategyActivity.this.getResources(), paramAnonymousMessage);
      g.c("query up flow failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
      VryMobileForStrategyActivity.this.showBindFailDialog(paramAnonymousMessage.c);
    }
  };
  private int mIntervalTime = 0;
  private boolean mIsAutoSumbit = false;
  private View.OnClickListener mReSendButtonListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      g.a("interval: " + VryMobileForStrategyActivity.this.mIntervalTime + "  count: " + VryMobileForStrategyActivity.this.mCGISendSMSCount);
      VryMobileForStrategyActivity.this.checkAndGetSMS();
    }
  };
  private cb mTokenCore = cb.a();
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  private boolean nextpage = false;
  
  private void checkAndGetSMS()
  {
    g.a("interval: " + this.mIntervalTime + "  count: " + this.mCGISendSMSCount);
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
    ((Button)findViewById(2131558731)).setOnClickListener(this.mConfirmSendSmsListener);
    Button localButton = (Button)findViewById(2131558732);
    localButton.setOnClickListener(this.mCancelButtonListener);
    localButton.setText(2131231504);
    ((TextView)findViewById(2131559077)).setText(2131231613);
    ((TextView)findViewById(2131558729)).setText(str);
  }
  
  private void initSMS()
  {
    Button localButton = (Button)findViewById(2131559082);
    Object localObject = (EditText)findViewById(2131559081);
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
    findViewById(2131559084).setOnClickListener(this.mBindTokenListener);
  }
  
  private boolean setTime(long paramLong)
  {
    Button localButton = (Button)findViewById(2131559082);
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
    showUserDialog(2131230779, paramString, 2131230897, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VryMobileForStrategyActivity.this.setContentView(2130968704);
        VryMobileForStrategyActivity.this.setTitle(2131231620);
        VryMobileForStrategyActivity.this.initSMS();
        VryMobileForStrategyActivity.this.updateIntervalTimer();
        VryMobileForStrategyActivity.access$902(VryMobileForStrategyActivity.this, true);
      }
    });
  }
  
  private void showMobileFreqFail(String paramString)
  {
    showUserDialog(2131230843, paramString, 2131230897, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent(VryMobileForStrategyActivity.this, BindUinActivity.class);
        paramAnonymousDialogInterface.putExtra("intent.qquser", VryMobileForStrategyActivity.this.mUser);
        paramAnonymousDialogInterface.putExtra("intent.upgradedetermin", VryMobileForStrategyActivity.this.mUpDetermin);
        paramAnonymousDialogInterface.putExtra("page_id", 13);
        VryMobileForStrategyActivity.this.startActivity(paramAnonymousDialogInterface);
      }
    });
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
        g.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
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
      g.c("isshowingverifyfalse");
      com.tencent.token.global.RqdApplication.b = false;
      finish();
      return;
    }
    com.tencent.token.global.RqdApplication.b = true;
    if (getIntent().getBooleanExtra("succ", false))
    {
      g.c("isshowingverifyfalse");
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
    g.a("pause");
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