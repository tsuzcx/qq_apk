package com.tencent.token.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.cx;
import com.tencent.token.dj;
import com.tencent.token.do;
import com.tencent.token.global.h;

public class BindUinActivity
  extends BaseActivity
  implements Runnable
{
  private int mBindRetryTimes = 0;
  Runnable mBindRunnable = new cc(this);
  private View.OnClickListener mChangeListener = new cf(this);
  Handler mHandler = new cd(this);
  private boolean mIsActiveSuccess = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private int mPageId;
  private View.OnClickListener mSmsListener = new ce(this);
  private String mSmsPort;
  private long mTimeConter;
  private String mUin;
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  
  private void displaySucc()
  {
    dismissDialog();
    Object localObject = do.a().d(this.mUser.mRealUin);
    if (localObject != null) {
      do.a().b((QQUser)localObject);
    }
    cx.c().n();
    localObject = this.mUser.mRealUin + "";
    Intent localIntent = new Intent(this, VerifySuccActivity.class);
    localIntent.putExtra("mRealUin", Long.parseLong((String)localObject));
    startActivity(localIntent);
    finish();
  }
  
  private void init()
  {
    this.mIsActiveSuccess = false;
    this.mUin = (this.mUser.mRealUin + "");
    String str = this.mUpDetermin.b();
    if ((str == null) || (str.length() == 0))
    {
      finish();
      return;
    }
    findViewById(2131558730).setOnClickListener(this.mSmsListener);
    findViewById(2131558731).setOnClickListener(this.mChangeListener);
    ((TextView)findViewById(2131558728)).setText(str);
  }
  
  private void sendBindUinSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      com.tencent.token.ch.a().a(System.currentTimeMillis(), 57);
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
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131230779, paramString, 2131230897, new ch(this));
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
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mHandler.sendEmptyMessage(3);
    startTimeTask();
    h.b("startTimeTask onActivityResult");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130968622);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    this.mPageId = getIntent().getIntExtra("page_id", 10);
    init();
    new Thread(this).start();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    cx.c().a.a(this.mHandler);
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
          h.c("removeTimeTask removeTimeTask");
          removeTimeTask();
          Message localMessage = new Message();
          localMessage.what = 15;
          this.mHandler.sendMessage(localMessage);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131231657, 2131230804, new cg(this));
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.BindUinActivity
 * JD-Core Version:    0.7.0.1
 */