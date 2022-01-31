package com.tencent.token.ui;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cx;
import com.tencent.token.dj;
import com.tencent.token.do;
import com.tencent.token.eq;
import com.tencent.token.global.h;

public class UnbindUinActivity
  extends BaseActivity
  implements Runnable
{
  Handler handler = new aba(this);
  private View.OnClickListener mCancelListener = new abc(this);
  private View.OnClickListener mCannotUnbindListener = new abd(this);
  private View.OnClickListener mConfirmListener = new abb(this);
  private DialogInterface.OnCancelListener mDialogCancelListener = new abf(this);
  private DialogInterface.OnClickListener mDialogFinishListener = new abe(this);
  private String mFailStr = "";
  private long mHashUin = 0L;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private boolean mIsUnbindSuccess = false;
  private eq mMbInfoCache = eq.a();
  private String mMobile = "";
  private String mSmsPort;
  private long mTimeConter;
  private long mUin = 0L;
  int mUnBindRetryTimes = 0;
  Runnable mUnBindRunnable = new aay(this);
  private QQUser userToUnbind = null;
  
  private void gotoMbItemActivity()
  {
    Object localObject = do.a().e();
    if ((localObject != null) && (((QQUser)localObject).mIsBinded))
    {
      int i = this.mMbInfoCache.a(51);
      localObject = new Intent(this, UtilsMbInfoItemActivity.class);
      ((Intent)localObject).putExtra("position", i);
      startActivityForResult((Intent)localObject, 0);
      return;
    }
    startActivity(new Intent(this, UtilsMbInfoActivity.class));
  }
  
  private void init1()
  {
    findViewById(2131558730).setOnClickListener(this.mConfirmListener);
    findViewById(2131558731).setOnClickListener(this.mCancelListener);
    TextView localTextView = (TextView)findViewById(2131559267);
    new SpannableString(this.mMobile).setSpan(new ForegroundColorSpan(getResources().getColor(2131492904)), 0, this.mMobile.length(), 33);
    localTextView.setText(this.mMobile);
  }
  
  private void init2()
  {
    ((Button)findViewById(2131559269)).setOnClickListener(this.mCannotUnbindListener);
    TextView localTextView = (TextView)findViewById(2131559267);
    String str2 = Long.toString(this.mUin);
    String str1 = "";
    int i = 0;
    while (i < str2.length() - 3)
    {
      str1 = str1 + "*";
      i += 1;
    }
    str1 = str2.substring(0, 2) + str1 + str2.substring(str2.length() - 1, str2.length());
    str2 = getString(2131230763) + " ";
    Object localObject = getString(2131231513);
    localObject = new SpannableString(str2 + str1 + (String)localObject);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(getResources().getColor(2131492904));
    i = str2.length();
    int j = str2.length();
    ((SpannableString)localObject).setSpan(localForegroundColorSpan, i, str1.length() + j, 33);
    localTextView.setText((CharSequence)localObject);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131231509, paramString, 2131230897, new abh(this), new aaz(this));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsUnbindSuccess) && (paramKeyEvent.getAction() == 0)) {}
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
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.handler.sendEmptyMessage(3);
    startTimeTask();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mUin = 0L;
    paramBundle = paramBundle.getBundleExtra("com.tencent.real_uin");
    if (paramBundle == null)
    {
      finish();
      return;
    }
    this.mUin = paramBundle.getLong("real_uin");
    this.mHashUin = paramBundle.getLong("hash_uin");
    this.userToUnbind = do.a().c(this.mHashUin);
    if (this.userToUnbind == null)
    {
      finish();
      return;
    }
    this.mMobile = this.userToUnbind.mMobileMask;
    if ((this.mMobile == null) || (this.mUin == 0L) || (this.mHashUin == 0L))
    {
      finish();
      return;
    }
    if (this.mMobile.length() != 0)
    {
      setContentView(2130968765);
      init1();
    }
    for (;;)
    {
      new Thread(this).start();
      return;
      setContentView(2130968763);
      init2();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    cx.c().a.a(this.handler);
  }
  
  protected void onStop()
  {
    super.onStop();
    cx.c().a.a(null);
  }
  
  public void removeTimeTask()
  {
    this.mIsTimeTask = false;
  }
  
  public void run()
  {
    while (this.mIsRunning) {
      if ((this.mIsTimeTask) && (System.currentTimeMillis() - this.mTimeConter > 60000L)) {
        try
        {
          removeTimeTask();
          Message localMessage = new Message();
          localMessage.what = 15;
          this.handler.sendMessage(localMessage);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void sendUnBindUinSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      ch.a().a(System.currentTimeMillis(), 57);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        h.b(paramString1.toString());
      }
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131231514, 2131231517, new abg(this));
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
  
  void unbindResult()
  {
    finish();
    AccountPageActivity.mNeedRefreshEval = true;
    do.a().b();
    Intent localIntent = new Intent(this, IndexActivity.class);
    localIntent.putExtra("snap", true);
    localIntent.putExtra("index_from", 16);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UnbindUinActivity
 * JD-Core Version:    0.7.0.1
 */