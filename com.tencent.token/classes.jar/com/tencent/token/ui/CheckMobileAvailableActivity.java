package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.c;
import com.tencent.token.global.h;

public class CheckMobileAvailableActivity
  extends BaseActivity
  implements Runnable
{
  public static final int UP_SMS_SCENE_APPLY_REALNAME = 5;
  public static final String UP_SMS_SCENE_ID = "up_sms_scene_id";
  public static final int UP_SMS_SCENE_MOD_MOBILE = 3;
  public static final int UP_SMS_SCENE_NORMAL_BIND = 0;
  public static final int UP_SMS_SCENE_REALNAME_BIND = 1;
  public static final int UP_SMS_SCENE_REALNAME_FIND_PSW = 2;
  public static final int UP_SMS_SCENE_SET_MOBILE = 4;
  public static final int UP_SMS_SCENE_UNBIND_APP = 6;
  public static final int UP_SMS_SCENE_UNITE_VERIFY = 8;
  public static final int UP_SMS_SCENE_VERIFY = 7;
  private boolean isFromRecommView = false;
  private Handler mHandler = new ci(this);
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private String mMobile;
  private RealNameStatusResult mRealNameResult;
  private long mRealUin;
  private int mSceneId;
  private String mSmsPort;
  private long mTimeConter;
  private UpgradeDeterminResult mUpDetermin = null;
  private QQUser mUser = null;
  private QQUser mUserToUnbind = null;
  private TextView mobileMask;
  private int upSmsSceneId;
  
  private String getUrlFromXml()
  {
    int i = c.a();
    String str2 = getResources().getString(2131230810);
    h.b(str2);
    String str1 = str2;
    switch (i)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      return "http://" + str1;
      str1 = "test." + str2;
      continue;
      str1 = "exp." + str2;
      continue;
      str1 = "gray." + str2;
    }
  }
  
  private void initView()
  {
    this.mobileMask = ((TextView)findViewById(2131558728));
    if ((this.upSmsSceneId == 0) || (this.upSmsSceneId == 7)) {
      this.mobileMask.setText(this.mUpDetermin.b());
    }
    for (;;)
    {
      Button localButton1 = (Button)findViewById(2131558746);
      Button localButton2 = (Button)findViewById(2131558747);
      localButton1.setOnClickListener(new cj(this));
      localButton2.setOnClickListener(new ck(this));
      return;
      if (this.upSmsSceneId == 5) {
        this.mobileMask.setText(this.mRealNameResult.mMaskMobile);
      } else if (this.upSmsSceneId == 6) {
        this.mobileMask.setText(this.mUserToUnbind.mMobileMask);
      }
    }
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131230779, paramString, 2131230897, new cm(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent();
    this.upSmsSceneId = paramBundle.getIntExtra("up_sms_scene_id", -1);
    if ((this.upSmsSceneId == 0) || (this.upSmsSceneId == 7))
    {
      this.mUser = ((QQUser)paramBundle.getSerializableExtra("intent.qquser"));
      this.mUpDetermin = ((UpgradeDeterminResult)paramBundle.getSerializableExtra("intent.upgradedetermin"));
      this.mSceneId = paramBundle.getIntExtra("scene_id", 1004);
      if ((this.mUser == null) || (this.mUpDetermin == null)) {
        finish();
      }
    }
    else
    {
      if (this.upSmsSceneId != 5) {
        break label180;
      }
      this.mRealNameResult = ((RealNameStatusResult)paramBundle.getSerializableExtra("realname_result"));
      this.mSceneId = paramBundle.getIntExtra("scene_id", 1001);
      this.mMobile = paramBundle.getStringExtra("realname_mobile");
      this.mRealUin = paramBundle.getLongExtra("real_uin", 0L);
      this.isFromRecommView = getIntent().getBooleanExtra("zzb_recommend_view", false);
    }
    label180:
    do
    {
      do
      {
        setContentView(2130968626);
        initView();
        return;
      } while (this.upSmsSceneId != 6);
      this.mRealUin = paramBundle.getLongExtra("real_uin", 0L);
      this.mUserToUnbind = ((QQUser)paramBundle.getSerializableExtra("user_to_unbind"));
    } while (this.mUserToUnbind != null);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
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
    showProDialog(this, 2131231657, 2131230804, new cl(this));
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.CheckMobileAvailableActivity
 * JD-Core Version:    0.7.0.1
 */