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
      paramAnonymousView = (EditText)VryMobileForStrategyActivity.this.findViewById(2131165996);
      String str = paramAnonymousView.getText().toString();
      if (paramAnonymousView != null) {
        paramAnonymousView.clearFocus();
      }
      if ((str != null) && (str.length() > 0))
      {
        VryMobileForStrategyActivity.this.vrySmsCode(str);
        paramAnonymousView = VryMobileForStrategyActivity.this;
        paramAnonymousView.showProDialog(paramAnonymousView, 2131492985, 2131493440, null);
        return;
      }
      VryMobileForStrategyActivity.this.showToast(2131493101);
    }
  };
  private int mCGISendSMSCount = 0;
  private View.OnClickListener mCancelButtonListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = VryMobileForStrategyActivity.this;
      l.a(paramAnonymousView, paramAnonymousView.getResources().getString(2131493003), VryMobileForStrategyActivity.this.getResources().getString(2131493764));
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
      Object localObject = VryMobileForStrategyActivity.this;
      if (localObject != null)
      {
        if ((localObject != null) && (((VryMobileForStrategyActivity)localObject).isFinishing())) {
          return;
        }
        int i = paramAnonymousMessage.what;
        if (i != -100)
        {
          if (i != 100)
          {
            switch (i)
            {
            default: 
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("unknown msg: ");
              ((StringBuilder)localObject).append(paramAnonymousMessage.what);
              g.c(((StringBuilder)localObject).toString());
              return;
            case 3066: 
              if (paramAnonymousMessage.arg1 == 0)
              {
                VryMobileForStrategyActivity.this.dismissDialog();
                com.tencent.token.global.RqdApplication.b = false;
                VryMobileForStrategyActivity.this.finish();
                return;
              }
              paramAnonymousMessage = (e)paramAnonymousMessage.obj;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("err ");
              ((StringBuilder)localObject).append(paramAnonymousMessage.a);
              g.c(((StringBuilder)localObject).toString());
              e.a(VryMobileForStrategyActivity.this.getResources(), paramAnonymousMessage);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("query up flow failed:");
              ((StringBuilder)localObject).append(paramAnonymousMessage.a);
              ((StringBuilder)localObject).append("-");
              ((StringBuilder)localObject).append(paramAnonymousMessage.b);
              ((StringBuilder)localObject).append("-");
              ((StringBuilder)localObject).append(paramAnonymousMessage.c);
              g.c(((StringBuilder)localObject).toString());
              VryMobileForStrategyActivity.this.showBindFailDialog(paramAnonymousMessage.c);
              return;
            }
            if (paramAnonymousMessage.arg1 != 0)
            {
              VryMobileForStrategyActivity.access$202(VryMobileForStrategyActivity.this, 0);
              paramAnonymousMessage = (e)paramAnonymousMessage.obj;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("err ");
              ((StringBuilder)localObject).append(paramAnonymousMessage.a);
              g.c(((StringBuilder)localObject).toString());
              e.a(VryMobileForStrategyActivity.this.getResources(), paramAnonymousMessage);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("get mobile code failed:");
              ((StringBuilder)localObject).append(paramAnonymousMessage.a);
              ((StringBuilder)localObject).append("-");
              ((StringBuilder)localObject).append(paramAnonymousMessage.b);
              ((StringBuilder)localObject).append("-");
              ((StringBuilder)localObject).append(paramAnonymousMessage.c);
              g.c(((StringBuilder)localObject).toString());
              VryMobileForStrategyActivity.this.mHandler.removeMessages(-100);
              if (124 == paramAnonymousMessage.a)
              {
                VryMobileForStrategyActivity.this.mUpDetermin.mSmsPrefix = ProtoGeneralGetMobileCode.f;
                VryMobileForStrategyActivity.this.showMobileFreqFail(paramAnonymousMessage.c);
                return;
              }
              VryMobileForStrategyActivity.this.showUserDialog(2131492985, paramAnonymousMessage.c, 2131493039, null);
              return;
            }
            VryMobileForStrategyActivity.this.mUpDetermin.mSmsPrefix = ProtoGeneralGetMobileCode.f;
            VryMobileForStrategyActivity.access$902(VryMobileForStrategyActivity.this, true);
            VryMobileForStrategyActivity.this.setContentView(2131296385);
            VryMobileForStrategyActivity.this.setTitle(2131493764);
            VryMobileForStrategyActivity.this.initSMS();
            return;
          }
          paramAnonymousMessage = VryMobileForStrategyActivity.this;
          paramAnonymousMessage.showProDialog(paramAnonymousMessage, 2131492985, 2131493440, null);
          return;
        }
        VryMobileForStrategyActivity.this.updateIntervalTimer();
        return;
      }
    }
  };
  private int mIntervalTime = 0;
  private boolean mIsAutoSumbit = false;
  private View.OnClickListener mReSendButtonListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new StringBuilder();
      paramAnonymousView.append("interval: ");
      paramAnonymousView.append(VryMobileForStrategyActivity.this.mIntervalTime);
      paramAnonymousView.append("  count: ");
      paramAnonymousView.append(VryMobileForStrategyActivity.this.mCGISendSMSCount);
      g.a(paramAnonymousView.toString());
      VryMobileForStrategyActivity.this.checkAndGetSMS();
    }
  };
  private cb mTokenCore = cb.a();
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  private boolean nextpage = false;
  
  private void checkAndGetSMS()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("interval: ");
    localStringBuilder.append(this.mIntervalTime);
    localStringBuilder.append("  count: ");
    localStringBuilder.append(this.mCGISendSMSCount);
    g.a(localStringBuilder.toString());
    if (this.mIntervalTime > 0) {
      return;
    }
    getSMS();
  }
  
  private void getSMS()
  {
    this.mCGISendSMSCount += 1;
    if (1 == this.mCGISendSMSCount) {
      this.mIntervalTime = 60;
    } else {
      this.mIntervalTime = 99;
    }
    updateIntervalTimer();
    this.mTokenCore.a(0L, Long.valueOf(this.mUser.mRealUin), 1006, this.mHandler);
  }
  
  private void hideKeyBoard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  private void init()
  {
    setTitle(2131493764);
    String str = this.mUpDetermin.mMobileMask;
    if ((str != null) && (str.length() != 0))
    {
      ((Button)findViewById(2131165767)).setOnClickListener(this.mConfirmSendSmsListener);
      Button localButton = (Button)findViewById(2131165351);
      localButton.setOnClickListener(this.mCancelButtonListener);
      localButton.setText(2131493648);
      ((TextView)findViewById(2131166184)).setText(2131493757);
      ((TextView)findViewById(2131165734)).setText(str);
      return;
    }
    finish();
  }
  
  private void initSMS()
  {
    Button localButton = (Button)findViewById(2131165897);
    Object localObject1 = (EditText)findViewById(2131165996);
    if (localObject1 != null) {
      ((EditText)localObject1).clearFocus();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getResources().getString(2131492942));
    ((StringBuilder)localObject1).append("\n(");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (this.mIntervalTime < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("0");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.mIntervalTime);
    ((StringBuilder)localObject2).append(")");
    localButton.setText(((StringBuilder)localObject2).toString());
    localButton.setTextColor(getResources().getColor(2130968662));
    localButton.setOnClickListener(this.mReSendButtonListener);
    findViewById(2131165308).setOnClickListener(this.mBindTokenListener);
  }
  
  private boolean setTime(long paramLong)
  {
    Button localButton = (Button)findViewById(2131165897);
    if (paramLong <= 0L)
    {
      if (localButton != null)
      {
        localButton.setTextColor(getResources().getColor(2130968657));
        localButton.setText(2131492942);
        localButton.setTextSize(0, getResources().getDimensionPixelSize(2131034253));
      }
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getResources().getString(2131492942));
    ((StringBuilder)localObject1).append("\n(");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (this.mIntervalTime < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("0");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.mIntervalTime);
    ((StringBuilder)localObject2).append(")");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (localButton != null)
    {
      localButton.setText((CharSequence)localObject1);
      localButton.setTextColor(getResources().getColor(2130968662));
      localButton.setTextSize(0, getResources().getDimensionPixelSize(2131034250));
    }
    return true;
  }
  
  private void showBindFailDialog(String paramString)
  {
    showUserDialog(2131492921, paramString, 2131493039, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VryMobileForStrategyActivity.this.setContentView(2131296385);
        VryMobileForStrategyActivity.this.setTitle(2131493764);
        VryMobileForStrategyActivity.this.initSMS();
        VryMobileForStrategyActivity.this.updateIntervalTimer();
        VryMobileForStrategyActivity.access$902(VryMobileForStrategyActivity.this, true);
      }
    });
  }
  
  private void showMobileFreqFail(String paramString)
  {
    showUserDialog(2131492985, paramString, 2131493039, new DialogInterface.OnClickListener()
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
    try
    {
      if ((this.nextpage) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
      {
        setContentView(2131296384);
        this.mIntervalTime = 0;
        this.nextpage = false;
        init();
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchKeyEvent exception ");
      localStringBuilder.append(this);
      localStringBuilder.append(paramKeyEvent.toString());
      g.d(localStringBuilder.toString());
    }
    return true;
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
    if ((this.mUser != null) && (this.mUpDetermin != null))
    {
      com.tencent.token.global.RqdApplication.b = true;
      if (getIntent().getBooleanExtra("succ", false))
      {
        g.c("isshowingverifyfalse");
        com.tencent.token.global.RqdApplication.b = false;
        finish();
        return;
      }
      setContentView(2131296502);
      init();
      return;
    }
    g.c("isshowingverifyfalse");
    com.tencent.token.global.RqdApplication.b = false;
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeMessages(-100);
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