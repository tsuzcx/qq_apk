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
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.ag;
import com.tencent.token.as;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.ea;
import com.tencent.token.global.e;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class SmsContentTipActivity
  extends BaseActivity
  implements Runnable
{
  private View btnLayout;
  private TextView errorTip;
  private boolean isReadyModSetMB = false;
  private int mBindRetryTimes = 0;
  Runnable mBindRunnable = new aao(this);
  private View.OnClickListener mCompleteButtonListener = new aay(this);
  private String mCountryCode;
  private DialogInterface.OnCancelListener mDialogCancelListener = new aav(this);
  private DialogInterface.OnClickListener mDialogFinishListener = new aau(this);
  Handler mHandler = new aas(this);
  private boolean mIsActiveSuccess = false;
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private boolean mIsUnbindSuccess = false;
  private String mMobile;
  private int mOpType;
  private int mPageId;
  private ProgressBar mPb;
  private long mRealUin;
  private RealNameStatusResult mResult;
  private int mSceneId;
  Runnable mSetModMobileRunnable = new aaq(this);
  private int mSetRetryTimes = 0;
  private String mSmsPort;
  private int mSourceId;
  private long mTimeConter;
  private String mUin;
  private int mUnBindRetryTimes = 0;
  Runnable mUnBindRunnable = new aar(this);
  private UpgradeDeterminResult mUpDetermin = null;
  private QQUser mUser = null;
  private QQUser mUserToUnbind = null;
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
  
  private void initView()
  {
    this.useTip = ((TextView)findViewById(2131297100));
    this.smsContent = ((TextView)findViewById(2131297103));
    this.mobileNum = ((TextView)findViewById(2131297106));
    this.errorTip = ((TextView)findViewById(2131296593));
    this.okText = ((TextView)findViewById(2131297107));
    this.btnLayout = findViewById(2131296430);
    this.mPb = ((ProgressBar)findViewById(2131296936));
    if ((this.upSmsSceneId == 0) || (this.upSmsSceneId == 7))
    {
      String str = this.mUpDetermin.mMobileMask;
      if ((str == null) || (str.length() == 0))
      {
        finish();
        return;
      }
      this.useTipContent = String.format(getString(2131361877), new Object[] { this.mUpDetermin.mMobileMask });
    }
    for (;;)
    {
      this.mobileNum.setText(ea.c);
      this.smsContent.setText(ea.d);
      this.useTip.setText(this.useTipContent);
      this.btnLayout.setOnClickListener(new aaw(this));
      return;
      if ((this.upSmsSceneId == 3) || (this.upSmsSceneId == 4)) {
        this.useTipContent = String.format(getString(2131361877), new Object[] { this.mMobile });
      } else if (this.upSmsSceneId == 6) {
        this.useTipContent = String.format(getString(2131361877), new Object[] { this.mUserToUnbind.mMobileMask });
      }
    }
  }
  
  private void resetBtn()
  {
    this.mPb.setVisibility(4);
    this.okText.setText(getResources().getString(2131361880));
    this.btnLayout.setClickable(true);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131361907, paramString, 2131361800, new aap(this));
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
            e.c(this + "---isReadyModSetMB:" + this.isReadyModSetMB + "\n----removeCallbacks(mSetModMobileRunnable)");
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
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
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
        break label222;
      }
      this.mMobile = getIntent().getStringExtra("mobile");
      this.mSmsPort = getIntent().getStringExtra("sms_port");
      this.mCountryCode = getIntent().getStringExtra("area_code");
      this.mOpType = getIntent().getIntExtra("op_type", 1);
      this.mPageId = getIntent().getIntExtra("page_id", 10);
    }
    label222:
    do
    {
      do
      {
        setContentView(2130903201);
        initView();
        new Thread(this).start();
        return;
      } while (this.upSmsSceneId != 6);
      this.mUserToUnbind = ((QQUser)getIntent().getSerializableExtra("user_to_unbind"));
    } while (this.mUserToUnbind != null);
    finish();
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
    showProDialog(this, 2131362363, 2131361827, new aax(this));
  }
  
  public void startTimeTask(int paramInt)
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
  
  void unbindResult()
  {
    finish();
    AccountPageActivity.mNeedRefreshEval = true;
    ax.a();
    ax.b();
    ax.a().k = false;
    SettingPageActivity.mNeedRefreshMbInfo = true;
    Intent localIntent = new Intent(this, IndexActivity.class);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SmsContentTipActivity
 * JD-Core Version:    0.7.0.1
 */