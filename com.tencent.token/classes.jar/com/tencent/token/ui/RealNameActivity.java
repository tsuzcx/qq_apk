package com.tencent.token.ui;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameShakeResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.fp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.dk;

public class RealNameActivity
  extends BaseActivity
{
  private final String UPDATE_INTERVAL_TIME_ACTION4 = "com.tencent.token.realname.AUDIT_INTERVAL4";
  private final String UPDATE_INTERVAL_TIME_ACTION5 = "com.tencent.token.realname.AUDIT_INTERVAL4";
  private final int UPDATE_TIME = -100;
  TextView dayview;
  TextView hourview;
  private boolean inAuditView;
  private boolean isFromSafeMsg = false;
  private TextView mAuditTextView;
  private long mAuditTime;
  TextView mChanceLeft;
  public Handler mHandler = new ue(this);
  private AlarmManager mIntervalAlarmMgr5 = null;
  private PendingIntent mIntervalPending5 = null;
  private BroadcastReceiver mIntervalReceiver5 = new un(this);
  private long mLeftTime;
  private dk mNeedVerifyView;
  private RealNameStatusResult mResult;
  TextView mTip1;
  TextView mTip3;
  TextView minview;
  RealNameShakeResult rsk;
  TextView secview;
  RelativeLayout topToast;
  TextView topToastText;
  
  private boolean formatTime(long paramLong)
  {
    if (paramLong < 0L)
    {
      if (isProDialogShow()) {
        return false;
      }
      showProDialog(this, 2131361808, 2131362203, null);
      af.a().l(0L, this.mHandler);
      return false;
    }
    int i = (int)(paramLong / 86400L);
    int j = (int)(paramLong % 86400L / 3600L);
    int k = (int)(paramLong % 86400L % 3600L / 60L);
    int m = (int)(paramLong % 60L);
    this.dayview.setText(String.valueOf(i));
    this.hourview.setText(String.valueOf(j));
    this.minview.setText(String.valueOf(k));
    this.secview.setText(String.valueOf(m));
    return true;
  }
  
  private void initAuditResultView(boolean paramBoolean)
  {
    if (this.isFromSafeMsg)
    {
      this.inAuditView = false;
      if (paramBoolean) {
        break label96;
      }
      setContentView(2130903163);
      this.dayview = ((TextView)findViewById(2131296946));
      this.hourview = ((TextView)findViewById(2131296947));
      this.minview = ((TextView)findViewById(2131296948));
      this.secview = ((TextView)findViewById(2131296949));
      updateIntervalTimer4();
    }
    for (;;)
    {
      this.mTitleText.setText(2131362604);
      return;
      this.inAuditView = true;
      break;
      label96:
      setContentView(2130903164);
      this.mTip3 = ((TextView)findViewById(2131296961));
      this.mTip3.setText(Html.fromHtml(String.format(getResources().getString(2131362777), new Object[] { Integer.valueOf(this.mResult.chanceLeft) })));
      this.mTip1 = ((TextView)findViewById(2131296955));
      this.mTip1.setText(String.format(getResources().getString(2131362775), new Object[] { Integer.valueOf(this.mResult.mDispatchTime), Integer.valueOf(this.mResult.mDailyZzbCnt) }));
      this.topToast = ((RelativeLayout)findViewById(2131296950));
      this.topToastText = ((TextView)findViewById(2131296784));
      if ((!TextUtils.isEmpty(this.mResult.mMsgText)) && (this.mResult.chanceLeft > 0))
      {
        this.topToast.setVisibility(0);
        this.topToastText.setText(this.mResult.mMsgText);
      }
    }
  }
  
  private void initNotifyToast()
  {
    String str1 = this.mResult.mToastText;
    String str2 = this.mResult.mToastUrl;
    View localView = findViewById(2131297337);
    ImageView localImageView = (ImageView)localView.findViewById(2131296785);
    if ((!TextUtils.isEmpty(str1)) && (localView.getVisibility() != 0))
    {
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131296784)).setText(str1);
      if (TextUtils.isEmpty(str2)) {
        localImageView.setOnClickListener(new ut(this, localView));
      }
    }
    else
    {
      return;
    }
    localImageView.setImageResource(2130837959);
    localView.setOnClickListener(new uu(this, str2, localView));
  }
  
  private void initUITopArea()
  {
    setContentView(2130903157);
    com.tencent.token.ui.base.ba localba = new com.tencent.token.ui.base.ba(GradientDrawable.Orientation.BOTTOM_TOP, getResources().getColor(2131165309), getResources().getColor(2131165310));
    this.mTitleBar.setBackgroundDrawable(localba);
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131165310));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837537));
    this.mTitleText.setTextColor(getResources().getColor(2131165297));
    this.mTitleText.setText(2131362513);
    localba = new com.tencent.token.ui.base.ba(GradientDrawable.Orientation.BOTTOM_TOP, getResources().getColor(2131165308), getResources().getColor(2131165307));
    ((ImageView)findViewById(2131296918)).setBackgroundDrawable(localba);
    ((TextView)findViewById(2131296925)).setOnClickListener(new uj(this));
    ((TextView)findViewById(2131296926)).setOnClickListener(new uk(this));
    ((TextView)findViewById(2131296928)).setOnClickListener(new ul(this));
    ((TextView)findViewById(2131296929)).setOnClickListener(new um(this));
  }
  
  private void initView()
  {
    this.inAuditView = false;
    switch (this.mResult.mRealStatus)
    {
    default: 
      return;
    case 1: 
      Intent localIntent = new Intent(this, RealNameGuidActivity.class);
      localIntent.putExtra("result", this.mResult);
      startActivity(localIntent);
      finish();
      return;
    case 3: 
    case 4: 
      initViewInRegister(false);
      return;
    }
    initViewInRegister(true);
  }
  
  private void initViewInRegister(boolean paramBoolean)
  {
    if ((this.isFromSafeMsg) && (paramBoolean))
    {
      initAuditResultView(true);
      if (this.mResult.mRealStatus == 3)
      {
        localObject = RqdApplication.i().getSharedPreferences("sp_name_global", 0);
        paramBoolean = ((SharedPreferences)localObject).getBoolean("key_zzb_refused_firsttime", true);
        if ((0L != this.mResult.mApplyRefuseTime) && (paramBoolean))
        {
          ((SharedPreferences)localObject).edit().putBoolean("key_zzb_refused_firsttime", false).commit();
          if (isInMonth(this.mResult))
          {
            localObject = findViewById(2131297337);
            ((View)localObject).setVisibility(0);
            ((View)localObject).findViewById(2131296785).setOnClickListener(new us(this, (View)localObject));
          }
        }
      }
      return;
    }
    initUITopArea();
    setRightTitleImage(2130837950, new uq(this));
    ((TextView)findViewById(2131296922)).setText(2131362589);
    Object localObject = (TextView)findViewById(2131296923);
    Button localButton = (Button)findViewById(2131296442);
    if (paramBoolean)
    {
      ((TextView)localObject).setVisibility(8);
      localButton.setVisibility(0);
      if (this.mResult.regVersion == 1) {
        localButton.setText(2131362595);
      }
    }
    for (;;)
    {
      initNotifyToast();
      localButton.setOnClickListener(new ur(this, paramBoolean));
      break;
      localButton.setText(2131362596);
      continue;
      if (this.mResult.mRealStatus != 3) {
        break label280;
      }
      ((TextView)localObject).setVisibility(8);
      localButton.setVisibility(0);
      localButton.setText(2131362597);
    }
    label280:
    ((TextView)localObject).setVisibility(0);
    if (!TextUtils.isEmpty(this.mResult.subTitle)) {
      ((TextView)localObject).setText(this.mResult.subTitle);
    }
    for (;;)
    {
      localButton.setVisibility(8);
      break;
      ((TextView)localObject).setText(2131362598);
    }
  }
  
  private void initViewInUse()
  {
    initUITopArea();
    setRightTitleImage(2130837848, new up(this));
    ((TextView)findViewById(2131296922)).setText(2131362575);
    TextView localTextView = (TextView)findViewById(2131296923);
    localTextView.setVisibility(0);
    localTextView.setText(2131362576);
    localTextView.setTextAppearance(this, 2131427366);
  }
  
  private boolean isInMonth(RealNameStatusResult paramRealNameStatusResult)
  {
    long l = paramRealNameStatusResult.mApplyRefuseTime;
    return ag.c().r() / 1000L - l <= 2592000L;
  }
  
  private void jumptoSucc()
  {
    Intent localIntent = new Intent(this, RealNameGuidActivity.class);
    localIntent.putExtra("result", this.mResult);
    startActivity(localIntent);
    finish();
  }
  
  private void registerIntervalTimer5()
  {
    if (this.mIntervalAlarmMgr5 != null) {
      return;
    }
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.token.realname.AUDIT_INTERVAL4");
    registerReceiver(this.mIntervalReceiver5, (IntentFilter)localObject);
    localObject = new Intent("com.tencent.token.realname.AUDIT_INTERVAL4");
    this.mIntervalAlarmMgr5 = ((AlarmManager)getSystemService("alarm"));
    this.mIntervalPending5 = PendingIntent.getBroadcast(this, 0, (Intent)localObject, 0);
  }
  
  private void showTipDailog()
  {
    Dialog localDialog = new Dialog(this, 2131427443);
    View localView = View.inflate(this, 2130903264, null);
    Object localObject = (ImageView)localView.findViewById(2131297336);
    TextView localTextView = (TextView)localView.findViewById(2131297333);
    Button localButton = (Button)localView.findViewById(2131296514);
    ((ImageView)localObject).setOnClickListener(new uf(this, localDialog));
    localTextView.setText(String.format(getResources().getString(2131362767), new Object[] { Integer.valueOf(this.mResult.mDispatchTime), Integer.valueOf(this.mResult.mDailyZzbCnt) }));
    localObject = (TextView)localView.findViewById(2131296944);
    ((TextView)localObject).setText(Html.fromHtml(getResources().getString(2131362770)));
    ((TextView)localObject).setOnClickListener(new ug(this));
    localObject = (TextView)localView.findViewById(2131296945);
    ((TextView)localObject).setText(Html.fromHtml(getResources().getString(2131362772)));
    ((TextView)localObject).setOnClickListener(new uh(this));
    localButton.setOnClickListener(new ui(this, localDialog));
    localDialog.setContentView(localView);
    localDialog.setOnCancelListener(null);
    localDialog.setCanceledOnTouchOutside(true);
    localDialog.show();
  }
  
  private void unregisterIntervalTimer5()
  {
    if (this.mIntervalAlarmMgr5 != null)
    {
      this.mIntervalAlarmMgr5.cancel(this.mIntervalPending5);
      unregisterReceiver(this.mIntervalReceiver5);
      this.mIntervalAlarmMgr5 = null;
    }
  }
  
  private void updateIntervalTimer4()
  {
    this.mAuditTime = (this.mResult.mCompleteTime - ag.c().r() / 1000L);
    if (formatTime(this.mAuditTime)) {
      this.mHandler.sendEmptyMessageDelayed(-100, 1000L);
    }
  }
  
  public void onBackPressed()
  {
    if (this.inAuditView)
    {
      initView();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 8);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      com.tencent.token.ba.a().h.a("real_name").a();
      return;
      this.isFromSafeMsg = getIntent().getBooleanExtra("from_safe_msg", false);
      this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("realname_result"));
      if (this.mResult == null)
      {
        finish();
        return;
      }
      initView();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mIntervalAlarmMgr5 != null)
    {
      this.mIntervalAlarmMgr5.cancel(this.mIntervalPending5);
      unregisterReceiver(this.mIntervalReceiver5);
      this.mIntervalAlarmMgr5 = null;
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new uo(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameActivity
 * JD-Core Version:    0.7.0.1
 */