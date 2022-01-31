package com.tencent.token.ui;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel;
import com.tencent.token.cx;
import com.tencent.token.dj;
import com.tencent.token.do;
import com.tencent.token.global.h;

public class SmsContentTipActivity
  extends BaseActivity
  implements Runnable
{
  private View btnLayout;
  private TextView errorTip;
  private boolean isReadyModSetMB = false;
  private String mA2 = "";
  private int mBindRetryTimes = 0;
  Runnable mBindRunnable = new zg(this);
  private String mCountryCode;
  private DialogInterface.OnCancelListener mDialogCancelListener = new zm(this);
  private DialogInterface.OnClickListener mDialogFinishListener = new zl(this);
  Handler mHandler = new zj(this);
  private boolean mIsActiveSuccess = false;
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private boolean mIsUnbindSuccess = false;
  private String mMobile;
  private int mOpType;
  private int mPageId;
  private ProgressBar mPb;
  private int mSceneId;
  Runnable mSetModMobileRunnable = new zh(this);
  private int mSetRetryTimes = 0;
  private String mSmsPort;
  private long mTimeConter;
  private String mTitle;
  private String mUin;
  private int mUnBindRetryTimes = 0;
  Runnable mUnBindRunnable = new zi(this);
  private UpgradeDeterminResult mUpDetermin = null;
  private QQUser mUser = null;
  private QQUser mUserToUnbind = null;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private TextView mobileNum;
  private TextView okText;
  private TextView smsContent;
  private int upSmsSceneId;
  private TextView useTip;
  private String useTipContent;
  
  private void displaySucc()
  {
    resetBtn();
    dismissDialog();
    Object localObject = do.a().d(this.mUser.mRealUin);
    if (localObject != null) {
      do.a().b((QQUser)localObject);
    }
    cx.c().n();
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUser.mRealUin);
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      ((Intent)localObject).putExtra("mSourceId", 1);
    }
    startActivity((Intent)localObject);
    finish();
  }
  
  private void gotoSetMobile()
  {
    this.mSetRetryTimes = 0;
    this.mHandler.postDelayed(this.mSetModMobileRunnable, 10000L);
    this.isReadyModSetMB = true;
  }
  
  private void initView()
  {
    this.useTip = ((TextView)findViewById(2131559270));
    this.smsContent = ((TextView)findViewById(2131559273));
    this.mobileNum = ((TextView)findViewById(2131559276));
    this.errorTip = ((TextView)findViewById(2131559154));
    this.okText = ((TextView)findViewById(2131559277));
    this.btnLayout = findViewById(2131558720);
    this.mPb = ((ProgressBar)findViewById(2131559153));
    if ((this.upSmsSceneId == 0) || (this.upSmsSceneId == 7))
    {
      String str = this.mUpDetermin.b();
      if ((str == null) || (str.length() == 0))
      {
        finish();
        return;
      }
      this.useTipContent = String.format(getString(2131231525), new Object[] { this.mUpDetermin.b() });
      if (this.upSmsSceneId != 8) {
        break label348;
      }
      this.mobileNum.setText(this.mVerifyResult.e());
      this.smsContent.setText(this.mVerifyResult.d());
    }
    for (;;)
    {
      this.useTip.setText(this.useTipContent);
      this.btnLayout.setOnClickListener(new zn(this));
      return;
      if ((this.upSmsSceneId == 3) || (this.upSmsSceneId == 4))
      {
        this.useTipContent = String.format(getString(2131231525), new Object[] { this.mMobile });
        break;
      }
      if (this.upSmsSceneId == 6)
      {
        this.useTipContent = String.format(getString(2131231525), new Object[] { this.mUserToUnbind.mMobileMask });
        break;
      }
      if (this.upSmsSceneId != 8) {
        break;
      }
      this.useTipContent = String.format(getString(2131231525), new Object[] { this.mMobile });
      break;
      label348:
      this.mobileNum.setText(ProtoGetSMSChannel.d);
      this.smsContent.setText(ProtoGetSMSChannel.e);
    }
  }
  
  private void resetBtn()
  {
    this.mPb.setVisibility(4);
    this.okText.setText(getResources().getString(2131231121));
    this.btnLayout.setClickable(true);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131231509, paramString, 2131230897, new zp(this));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (((this.mIsModSetSucc) || (this.mIsUnbindSuccess) || (this.mIsActiveSuccess)) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          if (this.isReadyModSetMB)
          {
            h.c(this + "---isReadyModSetMB:" + this.isReadyModSetMB + "\n----removeCallbacks(mSetModMobileRunnable)");
            this.mHandler.removeCallbacks(this.mSetModMobileRunnable);
            this.isReadyModSetMB = false;
          }
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.upSmsSceneId = getIntent().getIntExtra("up_sms_scene_id", -1);
    if ((this.upSmsSceneId == 0) || (this.upSmsSceneId == 7))
    {
      this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
      this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
      this.mSceneId = getIntent().getIntExtra("scene_id", 1004);
      if ((this.mUser == null) || (this.mUpDetermin == null)) {
        finish();
      }
    }
    else
    {
      if ((this.upSmsSceneId != 3) && (this.upSmsSceneId != 4)) {
        break label331;
      }
      this.mMobile = getIntent().getStringExtra("mobile");
      this.mSmsPort = getIntent().getStringExtra("sms_port");
      this.mCountryCode = getIntent().getStringExtra("area_code");
      this.mOpType = getIntent().getIntExtra("op_type", 1);
      this.mPageId = getIntent().getIntExtra("page_id", 10);
      this.mUser = do.a().e();
      if (this.mUser == null)
      {
        finish();
        return;
      }
      this.mUin = (this.mUser.mRealUin + "");
    }
    for (;;)
    {
      setContentView(2130968764);
      initView();
      new Thread(this).start();
      if ((getIntent() == null) || (getIntent().getStringExtra("title") == null) || (getIntent().getStringExtra("title").length() <= 0)) {
        break;
      }
      this.mTitle = getIntent().getStringExtra("title");
      setTitle(this.mTitle);
      return;
      label331:
      if (this.upSmsSceneId == 6)
      {
        this.mUserToUnbind = ((QQUser)getIntent().getSerializableExtra("user_to_unbind"));
        if (this.mUserToUnbind == null) {
          finish();
        }
      }
      else if (this.upSmsSceneId == 8)
      {
        this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
        this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
        this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
        this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
        if ((this.mUser == null) || (this.mVerifyResult == null))
        {
          finish();
          return;
        }
        if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
          setNeverShowLockVerifyView();
        }
        this.mSceneId = 1007;
        this.mMobile = this.mVerifyResult.g();
        this.mUin = (this.mUser.mRealUin + "");
        this.mSmsPort = this.mVerifyResult.e();
        this.mCountryCode = "+86";
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
    abi.c();
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
    showProDialog(this, 2131231657, 2131230804, new zo(this));
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
    do.a().k = false;
    Intent localIntent = new Intent(this, IndexActivity.class);
    localIntent.putExtra("index_from", 16);
    localIntent.putExtra("snap", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SmsContentTipActivity
 * JD-Core Version:    0.7.0.1
 */