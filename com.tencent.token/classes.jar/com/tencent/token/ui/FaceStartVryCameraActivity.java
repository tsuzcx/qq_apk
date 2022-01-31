package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

public class FaceStartVryCameraActivity
  extends BaseActivity
{
  public static String LANUCH_RETRY_COUNT = "fr_retrycount";
  private final int ALLOW_MAX_RETRY = 5;
  private Handler animationHandler = new iv(this);
  private Handler handler = new ij(this);
  private int[] mActions;
  private AlphaAnimation mAnimAlpha;
  private TranslateAnimation mAnimGoUp;
  private RotateAnimation mAnimRotate;
  private View mBgUpper;
  private Bitmap mBmpLogo;
  private Bitmap mBmpLogoGreen;
  private TextView mChangeVryTxt;
  private boolean mDetectSucc;
  private FaceData mFaceData;
  private int mFaceOpType = 2;
  private int mFaceScene = 10;
  private FaceView mFaceView;
  private int mHeightUpper;
  private boolean mIsActiveSuccess = false;
  private boolean mIsShowingErrorDialog = false;
  boolean mIsh5zzb;
  private ImageView mLogo;
  private View mLogoMiddle;
  private boolean mNeedLiveAction = false;
  private TranslateAnimation mOpenAnimGoDown;
  private TranslateAnimation mOpenAnimGoUp;
  private int mOpenHeightLower;
  private int mOpenHeightUpper;
  private View mOpenLower;
  private View mOpenUper;
  private ImageView mOpenUperDoor;
  private ImageView mOpenUperDoorNew;
  private FaceRecognitionCameraPreview mPreview;
  private int mRetryCount;
  private int mScene = 5;
  private byte[] mServerData;
  private TextView mTipTxt;
  private ImageView mVrySucc1;
  private ImageView mVrySucc2;
  private long realNameBindUin;
  
  private int getLockStatus()
  {
    int i;
    if (x.e() != 0L) {
      if ((cy.a().c()) && (cy.a().e() == 2)) {
        i = 19;
      }
    }
    for (;;)
    {
      h.c("getLockStatus = " + i);
      return i;
      i = 18;
      continue;
      if ((cy.a().c()) && (cy.a().e() == 2)) {
        i = 17;
      } else {
        i = 16;
      }
    }
  }
  
  private void gotoQuickLoginWb()
  {
    do.a().e();
    if (x.e() < 0L)
    {
      cw.a().b(this.handler);
      showProDialog(this, 2131230843, 2131231298, null);
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.handler, "" + x.e());
  }
  
  private void init()
  {
    this.mRetryCount = w.b(null, LANUCH_RETRY_COUNT);
    h.c("retryCount = " + this.mRetryCount);
    if (this.mRetryCount >= 5) {
      jumpGesOrPWD();
    }
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131558767));
    this.mPreview.setVisibility(4);
    this.mFaceView = ((FaceView)findViewById(2131558768));
    QQUser localQQUser1 = do.a().e();
    QQUser localQQUser2 = x.g();
    this.mVrySucc1 = ((ImageView)findViewById(2131558866));
    this.mVrySucc2 = ((ImageView)findViewById(2131558867));
    this.mTipTxt = ((TextView)findViewById(2131558865));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTipTxt.getLayoutParams();
    int i = getResources().getDisplayMetrics().densityDpi;
    float f = getResources().getDisplayMetrics().density;
    if (i <= 240)
    {
      localMarginLayoutParams.bottomMargin = ((int)(70.0F * f));
      if ((localQQUser1 == null) || (localQQUser2 == null) || (!localQQUser2.mIsZzb)) {
        break label293;
      }
      this.mFaceView.a(true, true);
      this.mVrySucc1.setImageResource(2130838079);
      this.mVrySucc2.setImageResource(2130838080);
    }
    for (;;)
    {
      this.handler.postDelayed(new iy(this, f), 2000L);
      return;
      if (i <= 320)
      {
        localMarginLayoutParams.bottomMargin = ((int)(90.0F * f));
        break;
      }
      localMarginLayoutParams.bottomMargin = ((int)(90.0F * f));
      break;
      label293:
      this.mFaceView.a(false, true);
    }
  }
  
  private void initValidationUI()
  {
    this.mChangeVryTxt = ((TextView)findViewById(2131558872));
    this.mOpenLower = findViewById(2131558873);
    this.mOpenUper = findViewById(2131558874);
    this.mOpenUperDoor = ((ImageView)findViewById(2131558877));
    this.mOpenUperDoorNew = ((ImageView)findViewById(2131558878));
    QQUser localQQUser1 = do.a().e();
    QQUser localQQUser2 = x.g();
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      this.animationHandler.post(new jg(this, this.mOpenUperDoor));
      this.animationHandler.post(new je(this, this.mOpenUperDoorNew));
    }
    this.mOpenUper.postDelayed(new iz(this), 800L);
    this.mBgUpper = findViewById(2131558822);
    this.mBgUpper.postDelayed(new ja(this), 500L);
    this.mLogoMiddle = findViewById(2131558871);
    this.mLogoMiddle.setVisibility(4);
    this.mBmpLogo = x.a(getResources(), 2130837982);
    this.mBmpLogoGreen = x.a(getResources(), 2130837984);
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      ((ImageView)this.mLogoMiddle).setImageDrawable(getResources().getDrawable(2130837981));
      this.mBmpLogoGreen = x.a(getResources(), 2130837986);
      this.mBmpLogo = x.a(getResources(), 2130837986);
      this.mChangeVryTxt.setTextColor(getResources().getColor(2131492924));
    }
    for (;;)
    {
      if (this.mBmpLogo != null)
      {
        this.mLogo = ((ImageView)findViewById(2131558870));
        this.mLogo.setImageBitmap(this.mBmpLogo);
      }
      if (!RqdApplication.g()) {
        this.mChangeVryTxt.setText(2131231619);
      }
      this.mChangeVryTxt.setOnClickListener(new jb(this));
      return;
      this.mChangeVryTxt.setTextColor(getResources().getColor(2131492923));
    }
  }
  
  private void jumpGesOrPWD()
  {
    if (!RqdApplication.g())
    {
      gotoQuickLoginWb();
      return;
    }
    startActivity(new Intent(this, StartPwdGestureVerifyActivity.class));
    finish();
  }
  
  private void resetFaceDetection()
  {
    this.mPreview.a(true, false, 0, 0);
    this.mFaceView.setStatus(0);
    this.mTipTxt.setText(2131231151);
  }
  
  private void setLiveDetectTxt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.mTipTxt.setText(2131231152);
      return;
    case 2: 
      this.mTipTxt.setText(2131231153);
      return;
    case 3: 
      this.mTipTxt.setText(2131231154);
      return;
    case 4: 
      this.mTipTxt.setText(2131231155);
      return;
    case 5: 
      this.mTipTxt.setText(2131231146);
      return;
    }
    this.mTipTxt.setText(2131231147);
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, new iw(this, paramContext), new ix(this, paramContext));
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if (paramKeyEvent.getAction() == 0) {}
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
      if (RqdApplication.f())
      {
        exitToken();
        return true;
      }
      if (this.mIsActiveSuccess) {
        break;
      }
      finish();
      return true;
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    h.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    h.a("flag=" + this.mFaceOpType + ",realuin=" + this.realNameBindUin);
    this.mIsh5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.mDetectSucc = false;
    this.mIsActiveSuccess = false;
    setContentView(2130968656);
    hideTitle();
    initValidationUI();
    init();
    ProtoFaceCommon.e();
    cw.a().f(x.e(), this.mScene, this.handler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mServerData = null;
    if (this.mPreview != null)
    {
      this.mPreview.c();
      this.mPreview = null;
    }
    this.handler = null;
  }
  
  protected void onPause()
  {
    super.onPause();
    RqdApplication.b = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    RqdApplication.b = true;
    if (this.mPreview != null)
    {
      jd localjd = new jd(this);
      requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, localjd);
      this.mPreview.setStop(false);
      resetFaceDetection();
    }
    if (this.mDetectSucc) {
      this.mPreview.setStop(true);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mDetectSucc = false;
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new jc(this));
    }
  }
  
  public void startAnimation()
  {
    if (this.mBmpLogoGreen != null) {
      this.mLogo.setImageBitmap(this.mBmpLogoGreen);
    }
    this.mLogoMiddle.setVisibility(0);
    this.animationHandler.post(new ji(this, this.mBgUpper, this.mLogoMiddle));
  }
  
  public void startOpenAnimation()
  {
    this.mOpenAnimGoUp = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mOpenHeightUpper);
    this.mOpenAnimGoUp.setDuration(500L);
    this.mOpenAnimGoDown = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mOpenHeightLower);
    this.mOpenAnimGoDown.setDuration(500L);
    this.mOpenAnimGoDown.setAnimationListener(new iu(this));
    this.mOpenUper.startAnimation(this.mOpenAnimGoUp);
    this.mOpenLower.startAnimation(this.mOpenAnimGoDown);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceStartVryCameraActivity
 * JD-Core Version:    0.7.0.1
 */