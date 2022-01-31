package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ag;
import com.tencent.token.as;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class BindUinActivity
  extends BaseActivity
  implements Runnable
{
  private int mBindRetryTimes = 0;
  Runnable mBindRunnable = new bp(this);
  private View.OnClickListener mChangeListener = new bt(this);
  private View.OnClickListener mCompleteButtonListener = new br(this);
  Handler mHandler = new bq(this);
  private boolean mIsActiveSuccess = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private int mPageId;
  private View.OnClickListener mSmsListener = new bs(this);
  private String mSmsPort;
  private long mTimeConter;
  private String mUin;
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  
  private void displaySucc()
  {
    dismissDialog();
    Object localObject = ax.a().d(this.mUser.mRealUin);
    if (localObject != null) {
      ax.a().b((QQUser)localObject);
    }
    ag.c().n();
    localObject = this.mUser.mRealUin + "";
    this.mIsActiveSuccess = true;
    setContentView(2130903050);
    this.mBackArrow.setVisibility(4);
    findViewById(2131296398).setOnClickListener(this.mCompleteButtonListener);
    setTitle(2131361842);
    ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
    ax.a().f(Long.parseLong((String)localObject));
    a.a().a(8);
  }
  
  private String getUrlFromXml()
  {
    int i = b.a();
    String str = getResources().getString(2131361845);
    e.b(str);
    switch (i)
    {
    case 1: 
    default: 
      return str;
    case 0: 
      return "test." + str;
    case 2: 
      return "exp." + str;
    }
    return "gray." + str;
  }
  
  private void init()
  {
    this.mIsActiveSuccess = false;
    this.mUin = (this.mUser.mRealUin + "");
    String str = this.mUpDetermin.mMobileMask;
    if ((str == null) || (str.length() == 0))
    {
      finish();
      return;
    }
    ((Button)findViewById(2131296442)).setOnClickListener(this.mSmsListener);
    ((Button)findViewById(2131296443)).setOnClickListener(this.mChangeListener);
    ((TextView)findViewById(2131296440)).setText(str);
  }
  
  private void sendBindUinSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      p.a().a(System.currentTimeMillis(), 57);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        e.b(paramString1.toString());
      }
    }
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131361831, paramString, 2131361800, new bv(this));
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
    this.mHandler.sendEmptyMessage(3);
    startTimeTask(3);
    e.b("startTimeTask onActivityResult");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130903058);
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
    ag.c().a.a(this.mHandler);
  }
  
  protected void onStop()
  {
    super.onStop();
    ag.c().a.a(null);
  }
  
  public void removeTimeTask(int paramInt)
  {
    this.mIsTimeTask = false;
  }
  
  public void run()
  {
    while (this.mIsRunning) {
      if ((this.mIsTimeTask) && (System.currentTimeMillis() - this.mTimeConter > 60000L)) {
        try
        {
          e.c("removeTimeTask removeTimeTask");
          removeTimeTask(6);
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
    showProDialog(this, 2131362363, 2131361827, new bu(this));
  }
  
  public void startTimeTask(int paramInt)
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.BindUinActivity
 * JD-Core Version:    0.7.0.1
 */