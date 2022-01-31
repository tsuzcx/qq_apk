package com.tencent.token.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.dj;
import com.tencent.token.do;
import com.tencent.token.global.h;

public class GeneralVerifyMobileUpActivity
  extends BaseActivity
  implements Runnable
{
  private boolean isCurrentMobile = true;
  private boolean isFirstFactor = false;
  private String mCountryCode = "+86";
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new kj(this);
  private boolean mIsActiveSuccess = false;
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private String mMobile = "";
  private EditText mMobileText;
  private int mRetryTimes = 0;
  private String mSMSChannel;
  private Button mStep2BindBtn;
  private long mTimeConter;
  private String mTitle = "身份验证";
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  Runnable mVrySMSRunnable = new kg(this);
  private View mcountry;
  
  private void setActiveSucc()
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = this.mUser.mRealUin + "";
    do.a().f(Long.parseLong((String)localObject));
    cw.a().b(this.mHandler);
  }
  
  private void showBindFailDialog(String paramString)
  {
    showUserDialog(2131230779, paramString, 2131230897, new kp(this));
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131231509, paramString, 2131230897, new kk(this), new kl(this));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((this.mIsModSetSucc) && (paramKeyEvent.getAction() == 0)) {}
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
    if (paramInt1 == 0)
    {
      this.mHandler.sendEmptyMessage(3);
      startTimeTask();
      h.b("startTimeTask onActivityResult");
    }
    while (paramInt2 == 0) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("name");
    this.mCountryCode = ("+" + paramInt2);
    this.mCountry_name.setText(paramIntent);
    this.mCountry_number.setText(this.mCountryCode);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras() == null)
    {
      finish();
      return;
    }
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
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
    setContentView(2130968671);
    this.mMobile = this.mVerifyResult.g();
    findViewById(2131558730).setOnClickListener(new km(this));
    findViewById(2131558731).setOnClickListener(new kn(this));
    ((TextView)findViewById(2131558728)).setText(this.mVerifyResult.g());
    ((TextView)findViewById(2131558740)).setOnClickListener(new ko(this));
    new Thread(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
    abi.c();
  }
  
  public void onResume()
  {
    super.onResume();
    cx.c().a.a(this.mHandler);
  }
  
  public void onStop()
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
      h.b(paramString1.toString());
    }
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new kh(this));
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131231657, 2131230804, new ki(this));
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.GeneralVerifyMobileUpActivity
 * JD-Core Version:    0.7.0.1
 */