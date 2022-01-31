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
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.as;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.e;

public class UtilsModSetMobileStep2SmsActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  private boolean isCurrentMobile = true;
  private int mBindRetryTimes = 0;
  private String mCountryCode;
  private Handler mHandler = new afq(this);
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private String mMobile;
  private int mOpType;
  private int mPageId;
  private int mRetryTimes = 0;
  private String mSMSChannel;
  Runnable mSetModMobileRunnable = new afo(this);
  private Button mStep2BindBtn;
  private long mTimeConter;
  private String mTitle;
  private String mUin;
  private QQUser mUser;
  
  private void init()
  {
    if (this.mUser != null) {
      this.mUin = (this.mUser.mRealUin + "");
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    if ((localBundle.getInt("op_type", 0) == 0) || (localBundle.getString("title") == null) || (localBundle.getString("mobile") == null))
    {
      finish();
      return;
    }
    this.mPageId = localBundle.getInt("page_id");
    this.mOpType = localBundle.getInt("op_type", 0);
    this.mMobile = localBundle.getString("mobile");
    this.mTitle = localBundle.getString("title");
    this.mCountryCode = localBundle.getString("area_code");
    setTitle(this.mTitle);
    e.c("test mbinfo, positon=, optype=" + this.mOpType + ", mobile=" + this.mMobile + ", area_code=" + this.mCountryCode);
    this.mStep2BindBtn = ((Button)findViewById(2131296442));
    this.mStep2BindBtn.setOnClickListener(this);
    ((Button)findViewById(2131296443)).setOnClickListener(this);
    ((TextView)findViewById(2131296440)).setText(this.mMobile);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131361907, paramString, 2131361800, new afr(this), new afs(this));
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mHandler.sendEmptyMessage(3);
    startTimeTask(3);
    e.b("startTimeTask onActivityResult");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296442: 
      this.isCurrentMobile = true;
      af.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
      showProDialog(this, 2131361808, getResources().getString(2131362216) + this.mTitle + getResources().getString(2131362217), null);
      return;
    case 2131296443: 
      this.isCurrentMobile = false;
      af.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
      showProDialog(this, 2131361808, getResources().getString(2131362216) + this.mTitle + getResources().getString(2131362217), null);
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
      startActivity(new Intent(this, IndexActivity.class));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903245);
    this.mUser = ax.a().e();
    init();
    new Thread(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
  }
  
  public void onResume()
  {
    super.onResume();
    ag.c().a.a(this.mHandler);
  }
  
  public void onStop()
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
  
  public void sendUpSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      e.b(paramString1.toString());
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131362363, 2131361827, new afp(this));
  }
  
  public void startTimeTask(int paramInt)
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsModSetMobileStep2SmsActivity
 * JD-Core Version:    0.7.0.1
 */