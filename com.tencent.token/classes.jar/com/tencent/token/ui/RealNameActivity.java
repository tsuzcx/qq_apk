package com.tencent.token.ui;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.token.ch;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.es;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.CommonActionSheetDialog;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.ba;
import com.tencent.token.ui.base.dd;
import com.tencent.token.ui.base.e;
import com.tencent.token.utils.k;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

public class RealNameActivity
  extends BaseActivity
{
  public static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  private final String UPDATE_INTERVAL_TIME_ACTION4 = "com.tencent.token.realname.AUDIT_INTERVAL4";
  private final String UPDATE_INTERVAL_TIME_ACTION5 = "com.tencent.token.realname.AUDIT_INTERVAL4";
  private final int UPDATE_TIME = -100;
  public final int ZZB_FLAUNT_SHARE = 1;
  public final int ZZB_RIGHT_BTN_SHARE = 2;
  TextView dayview;
  CommonActionSheetDialog dialog;
  TextView hourview;
  private boolean inAuditView;
  private boolean isFromAddFace = false;
  private boolean isFromRecommView = false;
  private boolean isFromSafeMsg = false;
  e listener = new ub(this);
  private long mAuditTime;
  public Handler mHandler = new tn(this);
  private AlarmManager mIntervalAlarmMgr5 = null;
  private PendingIntent mIntervalPending5 = null;
  private BroadcastReceiver mIntervalReceiver5 = new ty(this);
  private dd mNeedVerifyView;
  private RealNameStatusResult mResult;
  TextView mResultTipText;
  private IWXAPI mWeChatApi;
  TextView minview;
  TextView secview;
  private int shareWeChatScene = -1;
  
  private boolean formatTime(long paramLong)
  {
    if (paramLong < 0L)
    {
      if (isProDialogShow()) {
        return false;
      }
      showProDialog(this, 2131230843, 2131231601, null);
      cw.a().j(0L, this.mHandler);
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
      setContentView(2130968725);
      this.dayview = ((TextView)findViewById(2131559161));
      this.hourview = ((TextView)findViewById(2131559162));
      this.minview = ((TextView)findViewById(2131559163));
      this.secview = ((TextView)findViewById(2131559164));
      updateIntervalTimer4();
    }
    for (;;)
    {
      this.mTitleText.setText(2131230849);
      return;
      this.inAuditView = true;
      break;
      label96:
      setContentView(2130968726);
      this.mResultTipText = ((TextView)findViewById(2131559167));
      int i = w.c(this.mResult.mLeftTime);
      this.mResultTipText.setText(Html.fromHtml(String.format(getResources().getString(2131231671), new Object[] { Integer.valueOf(i) })));
    }
  }
  
  private void initNotifyToast()
  {
    String str1 = this.mResult.mToastText;
    String str2 = this.mResult.mToastUrl;
    View localView = findViewById(2131559531);
    ImageView localImageView = (ImageView)localView.findViewById(2131558988);
    if ((!TextUtils.isEmpty(str1)) && (localView.getVisibility() != 0))
    {
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131558987)).setText(str1);
      if (TextUtils.isEmpty(str2)) {
        localImageView.setOnClickListener(new to(this, localView));
      }
    }
    else
    {
      return;
    }
    localImageView.setImageResource(2130838015);
    localView.setOnClickListener(new tp(this, str2, localView));
  }
  
  private void initUITopArea()
  {
    setContentView(2130968720);
    ba localba = new ba(GradientDrawable.Orientation.BOTTOM_TOP, getResources().getColor(2131493015), getResources().getColor(2131493014));
    this.mTitleBar.setBackgroundDrawable(localba);
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131493014));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837617));
    this.mTitleText.setTextColor(getResources().getColor(2131493027));
    this.mTitleText.setText(2131231331);
    localba = new ba(GradientDrawable.Orientation.BOTTOM_TOP, getResources().getColor(2131493003), getResources().getColor(2131493004));
    ((ImageView)findViewById(2131559130)).setBackgroundDrawable(localba);
    ((TextView)findViewById(2131559142)).setOnClickListener(new tu(this));
    ((TextView)findViewById(2131559143)).setOnClickListener(new tv(this));
    ((TextView)findViewById(2131559145)).setOnClickListener(new tw(this));
    ((TextView)findViewById(2131559146)).setOnClickListener(new tx(this));
  }
  
  private void initView()
  {
    this.inAuditView = false;
    switch (this.mResult.mRealStatus)
    {
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("sp_name_global", 0);
      boolean bool = localSharedPreferences.getBoolean("key_realname_firsttime", true);
      if ((do.a().e().mIsZzb) && (bool))
      {
        Intent localIntent = new Intent(this, RealNameFirstJoinActivity.class);
        localIntent.putExtra("result", this.mResult);
        startActivityForResult(localIntent, 1);
        localSharedPreferences.edit().putBoolean("key_realname_firsttime", false).commit();
      }
      return;
      initViewInUse();
      continue;
      initViewInRegister(false);
      continue;
      initViewInRegister(true);
    }
  }
  
  private void initViewInRegister(boolean paramBoolean)
  {
    if ((this.isFromSafeMsg) && (paramBoolean))
    {
      initAuditResultView(true);
      if (this.mResult.mRealStatus == 3)
      {
        localObject = RqdApplication.l().getSharedPreferences("sp_name_global", 0);
        paramBoolean = ((SharedPreferences)localObject).getBoolean("key_zzb_refused_firsttime", true);
        if ((0L != this.mResult.mApplyRefuseTime) && (paramBoolean))
        {
          ((SharedPreferences)localObject).edit().putBoolean("key_zzb_refused_firsttime", false).commit();
          if (isInMonth(this.mResult))
          {
            localObject = findViewById(2131559531);
            ((View)localObject).setVisibility(0);
            ((View)localObject).findViewById(2131558988).setOnClickListener(new uf(this, (View)localObject));
          }
        }
      }
      return;
    }
    initUITopArea();
    setRightTitleImage(2130838010, new ud(this));
    ((TextView)findViewById(2131559137)).setText(2131231357);
    Object localObject = (TextView)findViewById(2131559140);
    Button localButton = (Button)findViewById(2131558730);
    if (paramBoolean)
    {
      ((TextView)localObject).setVisibility(8);
      localButton.setVisibility(0);
      localButton.setText(2131231356);
    }
    for (;;)
    {
      initNotifyToast();
      localButton.setOnClickListener(new ue(this, paramBoolean));
      break;
      if (this.mResult.mRealStatus != 3) {
        break label259;
      }
      ((TextView)localObject).setVisibility(8);
      localButton.setVisibility(0);
      localButton.setText(2131231339);
    }
    label259:
    ((TextView)localObject).setVisibility(0);
    if (!TextUtils.isEmpty(this.mResult.subTitle)) {
      ((TextView)localObject).setText(this.mResult.subTitle);
    }
    for (;;)
    {
      localButton.setVisibility(8);
      break;
      ((TextView)localObject).setText(2131231327);
    }
  }
  
  private void initViewInUse()
  {
    initUITopArea();
    setRightTitleImage(2130837960, new ua(this));
    findViewById(2131559133).setVisibility(8);
    findViewById(2131559134).setVisibility(0);
    RoundImageView localRoundImageView = (RoundImageView)findViewById(2131559135);
    QQUser localQQUser = do.a().e();
    if (localQQUser != null) {
      localRoundImageView.setImageDrawable(k.a(localQQUser.mRealUin + "", localQQUser.mUin + ""));
    }
    ((TextView)findViewById(2131559137)).setText(2131231357);
    ((LinearLayout)findViewById(2131559138)).setVisibility(0);
    ((TextView)findViewById(2131559139)).setText(this.mResult.realnameday + "");
  }
  
  private boolean isInMonth(RealNameStatusResult paramRealNameStatusResult)
  {
    long l = paramRealNameStatusResult.mApplyRefuseTime;
    return cx.c().s() / 1000L - l <= 2592000L;
  }
  
  private void shareToWechat(int paramInt)
  {
    this.mWeChatApi = WXAPIFactory.createWXAPI(this, "wx68451b483ebd18ce", false);
    this.mWeChatApi.registerApp("wx68451b483ebd18ce");
    Object localObject;
    SendMessageToWX.Req localReq;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.mWeChatApi.isWXAppInstalled())
      {
        if (this.mWeChatApi.getWXAppSupportAPI() >= 553779201)
        {
          if (this.shareWeChatScene == 1) {
            ch.a().a(System.currentTimeMillis(), 204);
          }
          for (;;)
          {
            localObject = new WXWebpageObject();
            ((WXWebpageObject)localObject).webpageUrl = this.mResult.urlShare;
            localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
            ((WXMediaMessage)localObject).title = this.mResult.shareTitle;
            ((WXMediaMessage)localObject).description = this.mResult.shareFriendText;
            ((WXMediaMessage)localObject).setThumbImage(x.a(getResources(), 2130837919));
            localReq = new SendMessageToWX.Req();
            localReq.transaction = String.valueOf(System.currentTimeMillis());
            localReq.message = ((WXMediaMessage)localObject);
            localReq.scene = 0;
            this.mWeChatApi.sendReq(localReq);
            return;
            if (this.shareWeChatScene == 2) {
              ch.a().a(System.currentTimeMillis(), 205);
            }
          }
        }
        showToast(getString(2131231444));
        return;
      }
      showWechatBindDialog();
      return;
    }
    if (this.mWeChatApi.isWXAppInstalled())
    {
      if (this.mWeChatApi.getWXAppSupportAPI() >= 553779201)
      {
        if (this.shareWeChatScene == 1) {
          ch.a().a(System.currentTimeMillis(), 204);
        }
        for (;;)
        {
          localObject = new WXWebpageObject();
          ((WXWebpageObject)localObject).webpageUrl = this.mResult.urlShare;
          localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
          ((WXMediaMessage)localObject).title = this.mResult.shareCircleText;
          ((WXMediaMessage)localObject).description = "";
          ((WXMediaMessage)localObject).setThumbImage(x.a(getResources(), 2130837919));
          localReq = new SendMessageToWX.Req();
          localReq.transaction = String.valueOf(System.currentTimeMillis());
          localReq.message = ((WXMediaMessage)localObject);
          localReq.scene = 1;
          this.mWeChatApi.sendReq(localReq);
          return;
          if (this.shareWeChatScene == 2) {
            ch.a().a(System.currentTimeMillis(), 205);
          }
        }
      }
      showToast(getString(2131231444));
      return;
    }
    showWechatBindDialog();
  }
  
  private void showTipDailog()
  {
    Dialog localDialog = new Dialog(this, 2131362064);
    View localView = View.inflate(this, 2130968827, null);
    Object localObject = (ImageView)localView.findViewById(2131559530);
    Button localButton = (Button)localView.findViewById(2131558797);
    ((ImageView)localObject).setOnClickListener(new tq(this, localDialog));
    localObject = (TextView)localView.findViewById(2131559528);
    ((TextView)localObject).setText(Html.fromHtml(getResources().getString(2131231660)));
    ((TextView)localObject).setOnClickListener(new tr(this));
    localObject = (TextView)localView.findViewById(2131559529);
    ((TextView)localObject).setText(Html.fromHtml(getResources().getString(2131231295)));
    ((TextView)localObject).setOnClickListener(new ts(this));
    localButton.setOnClickListener(new tt(this, localDialog));
    localDialog.setContentView(localView);
    localDialog.setOnCancelListener(null);
    localDialog.setCanceledOnTouchOutside(true);
    localDialog.show();
  }
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131230843, getString(2131231435), 2131231294, 2131231265, new uc(this), null);
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
    this.mAuditTime = (this.mResult.mCompleteTime - cx.c().s() / 1000L);
    if (formatTime(this.mAuditTime)) {
      this.mHandler.sendEmptyMessageDelayed(-100, 1000L);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((this.isFromAddFace) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      paramKeyEvent = new Intent(this, FaceRecognitionDefaultActivity.class);
      paramKeyEvent.addFlags(67108864);
      startActivity(paramKeyEvent);
      finish();
      return true;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      this.shareWeChatScene = 1;
      paramIntent = getResources().getString(2131230988);
      String str = getResources().getString(2131230989);
      this.dialog = new CommonActionSheetDialog(this, 2131362182, this.listener, new String[] { paramIntent, str });
      this.dialog.show();
    }
  }
  
  public void onBackPressed()
  {
    if (this.inAuditView)
    {
      initView();
      return;
    }
    if (this.isFromAddFace)
    {
      Intent localIntent = new Intent(this, FaceRecognitionDefaultActivity.class);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 7);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      dr.a().h.a("real_name").a();
      x.a(this, findViewById(2131558691), 2131493015);
      return;
      this.isFromSafeMsg = getIntent().getBooleanExtra("from_safe_msg", false);
      this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("realname_result"));
      this.isFromRecommView = getIntent().getBooleanExtra("zzb_recommend_view", false);
      this.isFromAddFace = getIntent().getBooleanExtra("from_add_face_succ", false);
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
    unregisterIntervalTimer5();
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new tz(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameActivity
 * JD-Core Version:    0.7.0.1
 */