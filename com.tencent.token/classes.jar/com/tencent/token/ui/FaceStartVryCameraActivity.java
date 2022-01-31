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
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cv;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

public class FaceStartVryCameraActivity
  extends BaseActivity
{
  public static String LANUCH_RETRY_COUNT = "fr_retrycount";
  private final int ALLOW_MAX_RETRY = 5;
  private Handler animationHandler = new jx(this);
  private Handler handler = new jl(this);
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
  private int mFaceScene = 6;
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
    if (t.e() != 0L) {
      if ((ah.a().c()) && (ah.a().e() == 2)) {
        i = 19;
      }
    }
    for (;;)
    {
      e.c("getLockStatus = " + i);
      return i;
      i = 18;
      continue;
      if ((ah.a().c()) && (ah.a().e() == 2)) {
        i = 17;
      } else {
        i = 16;
      }
    }
  }
  
  private void init()
  {
    this.mRetryCount = s.j(LANUCH_RETRY_COUNT);
    e.c("retryCount = " + this.mRetryCount);
    if (this.mRetryCount >= 5) {
      jumpGesOrPWD();
    }
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131296481));
    this.mFaceView = ((FaceView)findViewById(2131296482));
    QQUser localQQUser1 = ax.a().e();
    QQUser localQQUser2 = t.g();
    this.mVrySucc1 = ((ImageView)findViewById(2131296579));
    this.mVrySucc2 = ((ImageView)findViewById(2131296580));
    this.mTipTxt = ((TextView)findViewById(2131296578));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTipTxt.getLayoutParams();
    int i = getResources().getDisplayMetrics().densityDpi;
    float f = getResources().getDisplayMetrics().density;
    if (i <= 240)
    {
      localMarginLayoutParams.bottomMargin = ((int)(70.0F * f));
      if ((localQQUser1 == null) || (localQQUser2 == null) || (!localQQUser2.mIsZzb)) {
        break label263;
      }
      this.mFaceView.a(true, true);
      this.mVrySucc1.setImageResource(2130838027);
      this.mVrySucc2.setImageResource(2130838028);
    }
    for (;;)
    {
      this.handler.postDelayed(new ka(this, f), 2000L);
      return;
      localMarginLayoutParams.bottomMargin = ((int)(90.0F * f));
      break;
      label263:
      this.mFaceView.a(false, true);
    }
  }
  
  private void initValidationUI()
  {
    this.mChangeVryTxt = ((TextView)findViewById(2131296585));
    this.mOpenLower = findViewById(2131296586);
    this.mOpenUper = findViewById(2131296587);
    this.mOpenUperDoor = ((ImageView)findViewById(2131296590));
    this.mOpenUperDoorNew = ((ImageView)findViewById(2131296591));
    QQUser localQQUser1 = ax.a().e();
    QQUser localQQUser2 = t.g();
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      this.animationHandler.post(new ki(this, this.mOpenUperDoor));
      this.animationHandler.post(new kg(this, this.mOpenUperDoorNew));
    }
    this.mOpenUper.postDelayed(new kb(this), 800L);
    this.mBgUpper = findViewById(2131296536);
    this.mBgUpper.postDelayed(new kc(this), 500L);
    this.mLogoMiddle = findViewById(2131296584);
    this.mLogoMiddle.setVisibility(4);
    this.mBmpLogo = t.a(getResources(), 2130837920);
    this.mBmpLogoGreen = t.a(getResources(), 2130837922);
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      ((ImageView)this.mLogoMiddle).setImageDrawable(getResources().getDrawable(2130837919));
      this.mBmpLogoGreen = t.a(getResources(), 2130837924);
      this.mBmpLogo = t.a(getResources(), 2130837924);
      this.mChangeVryTxt.setTextColor(getResources().getColor(2131165326));
    }
    for (;;)
    {
      if (this.mBmpLogo != null)
      {
        this.mLogo = ((ImageView)findViewById(2131296583));
        this.mLogo.setImageBitmap(this.mBmpLogo);
      }
      if (!RqdApplication.d()) {
        this.mChangeVryTxt.setText(2131361941);
      }
      this.mChangeVryTxt.setOnClickListener(new kd(this));
      return;
      this.mChangeVryTxt.setTextColor(getResources().getColor(2131165325));
    }
  }
  
  private void jumpGesOrPWD()
  {
    if (!RqdApplication.d())
    {
      Intent localIntent = new Intent(this, StartPwdGestureForgetActivity.class);
      localIntent.putExtra("startpwd_forget_source", 3);
      startActivity(localIntent);
      finish();
      return;
    }
    startActivity(new Intent(this, StartPwdGestureVerifyActivity.class));
    finish();
  }
  
  private void resetFaceDetection()
  {
    this.mPreview.a(true, false, 0, 0);
    this.mFaceView.c(0);
    this.mTipTxt.setText(2131362782);
  }
  
  private void setLiveDetectTxt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.mTipTxt.setText(2131362787);
      return;
    case 2: 
      this.mTipTxt.setText(2131362788);
      return;
    case 3: 
      this.mTipTxt.setText(2131362789);
      return;
    }
    this.mTipTxt.setText(2131362790);
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131361808, getString(paramInt1), paramInt2, new jy(this, paramContext), new jz(this, paramContext));
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
      if (RqdApplication.c())
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    e.a("flag=" + this.mFaceOpType + ",realuin=" + this.realNameBindUin);
    this.mIsh5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.mDetectSucc = false;
    this.mIsActiveSuccess = false;
    setContentView(2130903092);
    hideTitle();
    initValidationUI();
    init();
    cv.e();
    af.a().h(t.e(), this.mScene, this.handler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mServerData = null;
    if (this.mPreview != null)
    {
      this.mPreview.a();
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
      this.mPreview.a(this, this.mScene, this.handler, this.mFaceView, this.mTipTxt);
      this.mPreview.a(false);
      this.mPreview.a(true, false, 0, 0);
      this.mFaceView.c(0);
      this.mTipTxt.setText(2131362782);
    }
    if (this.mDetectSucc) {
      this.mPreview.a(true);
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
      this.mBackArrow.setOnClickListener(new ke(this));
    }
  }
  
  public void startAnimation()
  {
    if (this.mBmpLogoGreen != null) {
      this.mLogo.setImageBitmap(this.mBmpLogoGreen);
    }
    this.mLogoMiddle.setVisibility(0);
    this.animationHandler.post(new kk(this, this.mBgUpper, this.mLogoMiddle));
  }
  
  public void startOpenAnimation()
  {
    this.mOpenAnimGoUp = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mOpenHeightUpper);
    this.mOpenAnimGoUp.setDuration(500L);
    this.mOpenAnimGoDown = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mOpenHeightLower);
    this.mOpenAnimGoDown.setDuration(500L);
    this.mOpenAnimGoDown.setAnimationListener(new kf(this));
    this.mOpenUper.startAnimation(this.mOpenAnimGoUp);
    this.mOpenLower.startAnimation(this.mOpenAnimGoDown);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceStartVryCameraActivity
 * JD-Core Version:    0.7.0.1
 */