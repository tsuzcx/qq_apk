package com.tencent.token.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.aay;
import com.tencent.token.aaz;
import com.tencent.token.aia;
import com.tencent.token.ajr;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.so;
import com.tencent.token.sp;
import com.tencent.token.sp.a;
import com.tencent.token.ss;
import com.tencent.token.su;
import com.tencent.token.sw;
import com.tencent.token.sx;
import com.tencent.token.tt;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.vg;
import com.tencent.token.xt;
import com.tencent.token.xv;
import com.tencent.token.yt;
import java.util.ArrayList;

public class FaceStartVryCameraActivity
  extends BaseActivity
{
  public static String LANUCH_RETRY_COUNT = "fr_retrycount";
  private final int ALLOW_MAX_RETRY = 5;
  private Handler animationHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage) {}
  };
  @SuppressLint({"HandlerLeak"})
  private Handler handler = new Handler()
  {
    private void a()
    {
      byte[] arrayOfByte = FaceStartVryCameraActivity.this.mFaceData.mUploadData;
      if (arrayOfByte == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(arrayOfByte);
      FaceStartVryCameraActivity.access$1502(FaceStartVryCameraActivity.this, aia.a(localArrayList));
      if (FaceStartVryCameraActivity.this.mServerData != null)
      {
        long l = aaz.e();
        int i = FaceStartVryCameraActivity.this.getLockStatus();
        FaceStartVryCameraActivity.access$1702(FaceStartVryCameraActivity.this, true);
        su.a().a(0L, l, FaceStartVryCameraActivity.this.mFaceOpType, FaceStartVryCameraActivity.this.mServerData, i, FaceStartVryCameraActivity.this.mFaceScene, FaceStartVryCameraActivity.this.mFaceView.getBrightModeIntValue(), FaceStartVryCameraActivity.this.handler);
        return;
      }
      xv.a("OPTYPE_VALIDATION serverData == null");
    }
    
    public final void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject1 = new StringBuilder("facepwd msg.what=");
      ((StringBuilder)localObject1).append(paramAnonymousMessage.what);
      xv.a(((StringBuilder)localObject1).toString());
      int j = paramAnonymousMessage.what;
      if (j != 2)
      {
        int i = 0;
        if (j != 11)
        {
          if (j != 13)
          {
            if (j != 71)
            {
              if (j != 73)
              {
                if (j != 1008)
                {
                  Object localObject2;
                  if (j != 3058)
                  {
                    if (j != 3082)
                    {
                      if (j != 4104)
                      {
                        if (j != 4109) {
                          return;
                        }
                        RqdApplication.g();
                        RqdApplication.l();
                        aay.a(FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
                        FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
                        FaceStartVryCameraActivity.this.startAnimation();
                        return;
                      }
                      FaceStartVryCameraActivity.this.dismissDialog();
                      if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
                      {
                        localObject1 = FaceStartVryCameraActivity.this;
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append(FaceStartVryCameraActivity.this.getResources().getString(2131493563));
                        ((StringBuilder)localObject2).append(":");
                        ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
                        ((FaceStartVryCameraActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
                        return;
                      }
                      FaceStartVryCameraActivity.this.showToast(2131493563);
                      return;
                    }
                    if (paramAnonymousMessage.arg1 != 0) {
                      break label1102;
                    }
                    if (paramAnonymousMessage.arg2 == 1)
                    {
                      paramAnonymousMessage = (int[])paramAnonymousMessage.obj;
                      if ((paramAnonymousMessage != null) && (paramAnonymousMessage.length > 0))
                      {
                        FaceStartVryCameraActivity.access$002(FaceStartVryCameraActivity.this, new int[paramAnonymousMessage.length]);
                        while (i < paramAnonymousMessage.length)
                        {
                          FaceStartVryCameraActivity.this.mActions[i] = paramAnonymousMessage[i];
                          i += 1;
                        }
                        FaceStartVryCameraActivity.access$102(FaceStartVryCameraActivity.this, true);
                        return;
                      }
                      FaceStartVryCameraActivity.access$102(FaceStartVryCameraActivity.this, false);
                      return;
                    }
                    FaceStartVryCameraActivity.access$102(FaceStartVryCameraActivity.this, false);
                    return;
                  }
                  localObject1 = new StringBuilder("K_MSG_POST_FACERECOGNITION = ");
                  ((StringBuilder)localObject1).append(paramAnonymousMessage.arg1);
                  xv.c(((StringBuilder)localObject1).toString());
                  if (paramAnonymousMessage.arg1 == 0)
                  {
                    RqdApplication.g();
                    i = paramAnonymousMessage.arg2;
                    RqdApplication.l();
                    aay.a(FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
                    FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
                    FaceStartVryCameraActivity.this.startAnimation();
                    return;
                  }
                  FaceStartVryCameraActivity.this.mVrySucc1.setVisibility(4);
                  FaceStartVryCameraActivity.this.mVrySucc2.setVisibility(4);
                  localObject1 = (xt)paramAnonymousMessage.obj;
                  xt.a(FaceStartVryCameraActivity.this.getResources(), (xt)localObject1);
                  paramAnonymousMessage = new StringBuilder("faceRe ret.mErrCode=");
                  paramAnonymousMessage.append(((xt)localObject1).a);
                  xv.c(paramAnonymousMessage.toString());
                  j = ((xt)localObject1).a;
                  if (j != 110)
                  {
                    i = 2131493178;
                    switch (j)
                    {
                    default: 
                      if (!RqdApplication.j()) {
                        i = 2131493178;
                      } else {
                        i = 2131493177;
                      }
                      FaceStartVryCameraActivity.this.showUserDialog(2131493080, ((xt)localObject1).c, 2131493025, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.jumpGesOrPWD();
                        }
                      }, new DialogInterface.OnCancelListener()
                      {
                        public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      });
                      return;
                    case 222: 
                      aaz.b(0L);
                      if (!RqdApplication.j())
                      {
                        paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493174);
                      }
                      else
                      {
                        paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493173);
                        i = 2131493177;
                      }
                      localObject2 = FaceStartVryCameraActivity.this;
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append(((xt)localObject1).c);
                      localStringBuilder.append("，");
                      localStringBuilder.append(paramAnonymousMessage);
                      ((FaceStartVryCameraActivity)localObject2).showUserDialog(2131493080, localStringBuilder.toString(), i, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.jumpGesOrPWD();
                        }
                      });
                      return;
                    }
                    FaceStartVryCameraActivity.access$1208(FaceStartVryCameraActivity.this);
                    if (!RqdApplication.j())
                    {
                      paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493183);
                      i = 2131493178;
                    }
                    else
                    {
                      paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493182);
                      i = 2131493177;
                    }
                    if (FaceStartVryCameraActivity.this.mRetryCount < 5)
                    {
                      aay.a(FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, FaceStartVryCameraActivity.this.mRetryCount);
                      FaceStartVryCameraActivity.this.showUserDialog(2131493180, ((xt)localObject1).c, 2131493179, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                      {
                        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.jumpGesOrPWD();
                        }
                      }, new DialogInterface.OnCancelListener()
                      {
                        public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      });
                      return;
                    }
                    aay.a(FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
                    FaceStartVryCameraActivity.this.showUserDialog(2131493181, paramAnonymousMessage, i, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        FaceStartVryCameraActivity.this.jumpGesOrPWD();
                      }
                    });
                    return;
                  }
                  paramAnonymousMessage = FaceStartVryCameraActivity.this;
                  paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493245, 2131493239);
                  return;
                }
                if (paramAnonymousMessage.arg1 == 0)
                {
                  FaceStartVryCameraActivity.this.dismissDialog();
                  paramAnonymousMessage = tt.a().k.b();
                  if (paramAnonymousMessage == null)
                  {
                    so.a().a(System.currentTimeMillis(), 23);
                    paramAnonymousMessage = FaceStartVryCameraActivity.this;
                    paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493244, 2131493246);
                    return;
                  }
                  FaceStartVryCameraActivity.this.dismissDialog();
                  long l2 = aaz.e();
                  long l1 = l2;
                  if (l2 <= 0L) {
                    l1 = paramAnonymousMessage.mRealUin;
                  }
                  paramAnonymousMessage = ss.a(FaceStartVryCameraActivity.this.getApplicationContext());
                  localObject1 = FaceStartVryCameraActivity.this;
                  paramAnonymousMessage.a((Activity)localObject1, ((FaceStartVryCameraActivity)localObject1).handler, String.valueOf(l1));
                  return;
                }
                FaceStartVryCameraActivity.this.dismissDialog();
                paramAnonymousMessage = (xt)paramAnonymousMessage.obj;
                FaceStartVryCameraActivity.this.showUserDialog(paramAnonymousMessage.c);
                return;
              }
              try
              {
                FaceStartVryCameraActivity.this.mPreview.setStop(false);
                FaceStartVryCameraActivity.this.resetFaceDetection();
                return;
              }
              catch (Exception paramAnonymousMessage)
              {
                paramAnonymousMessage.printStackTrace();
                return;
              }
            }
            if (FaceStartVryCameraActivity.this.mActions[0] <= 4) {
              FaceStartVryCameraActivity.this.mFaceView.setStatus(9);
            } else {
              FaceStartVryCameraActivity.this.mFaceView.setStatus(6);
            }
            FaceStartVryCameraActivity.this.mTipTxt.setText(2131492931);
            a();
          }
          else
          {
            paramAnonymousMessage = (TextView)FaceStartVryCameraActivity.this.findViewById(2131165546);
            if (paramAnonymousMessage != null)
            {
              paramAnonymousMessage.setText(2131493176);
              return;
            }
          }
          label1102:
          return;
        }
        FaceStartVryCameraActivity.access$502(FaceStartVryCameraActivity.this, (FaceData)paramAnonymousMessage.obj);
        if (FaceStartVryCameraActivity.this.mFaceData.mUploadData == null) {
          return;
        }
        if (FaceStartVryCameraActivity.this.mNeedLiveAction)
        {
          FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
          if (FaceStartVryCameraActivity.this.mTipTxt != null)
          {
            paramAnonymousMessage = FaceStartVryCameraActivity.this;
            paramAnonymousMessage.setLiveDetectTxt(paramAnonymousMessage.mActions[0]);
          }
          FaceStartVryCameraActivity.this.mPreview.a(false, true, FaceStartVryCameraActivity.this.mActions[0], 0);
          if (FaceStartVryCameraActivity.this.mActions[0] > 4)
          {
            FaceStartVryCameraActivity.this.mFaceView.setStatus(4);
            return;
          }
          FaceStartVryCameraActivity.this.mFaceView.setVryNodDirection(FaceStartVryCameraActivity.this.mActions[0]);
          FaceStartVryCameraActivity.this.mFaceView.setStatus(7);
          return;
        }
        FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
        FaceStartVryCameraActivity.this.mTipTxt.setText(2131492931);
        a();
        return;
      }
      if (FaceStartVryCameraActivity.this.mIsShowingErrorDialog) {
        return;
      }
      FaceStartVryCameraActivity.access$202(FaceStartVryCameraActivity.this, true);
      paramAnonymousMessage = FaceStartVryCameraActivity.this;
      paramAnonymousMessage.showUserDialog(2131492987, paramAnonymousMessage.getResources().getString(2131493427), 2131493041, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          FaceStartVryCameraActivity.this.dismissDialog();
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
        {
          FaceStartVryCameraActivity.this.mPreview.setStop(true);
          FaceStartVryCameraActivity.this.mPreview.c();
          FaceStartVryCameraActivity.access$202(FaceStartVryCameraActivity.this, false);
          if (!this.a) {
            FaceStartVryCameraActivity.this.finish();
          }
        }
      });
    }
  };
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
    if (aaz.e() != 0L)
    {
      if ((sw.a().c()) && (sw.a().a == 2)) {
        i = 19;
      } else {
        i = 18;
      }
    }
    else if ((sw.a().c()) && (sw.a().a == 2)) {
      i = 17;
    } else {
      i = 16;
    }
    xv.c("getLockStatus = ".concat(String.valueOf(i)));
    return i;
  }
  
  private void gotoQuickLoginWb()
  {
    tt.a().k.b();
    if (aaz.e() < 0L)
    {
      sp.a.a().b(this.handler);
      showProDialog(this, 2131492987, 2131493449, null);
      return;
    }
    ss localss = ss.a(getApplicationContext());
    Handler localHandler = this.handler;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(aaz.e());
    localss.a(this, localHandler, localStringBuilder.toString());
  }
  
  private void init()
  {
    this.mRetryCount = aay.j(LANUCH_RETRY_COUNT);
    Object localObject = new StringBuilder("retryCount = ");
    ((StringBuilder)localObject).append(this.mRetryCount);
    xv.c(((StringBuilder)localObject).toString());
    if (this.mRetryCount >= 5) {
      jumpGesOrPWD();
    }
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131165845));
    this.mPreview.setVisibility(4);
    this.mFaceView = ((FaceView)findViewById(2131165640));
    localObject = tt.a().k.b();
    QQUser localQQUser = aaz.g();
    this.mVrySucc1 = ((ImageView)findViewById(2131166321));
    this.mVrySucc2 = ((ImageView)findViewById(2131166322));
    this.mTipTxt = ((TextView)findViewById(2131165694));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTipTxt.getLayoutParams();
    int i = getResources().getDisplayMetrics().densityDpi;
    final float f = getResources().getDisplayMetrics().density;
    if (i <= 240) {
      localMarginLayoutParams.bottomMargin = ((int)(70.0F * f));
    } else {
      localMarginLayoutParams.bottomMargin = ((int)(90.0F * f));
    }
    if ((localObject != null) && (localQQUser != null) && (localQQUser.mIsZzb))
    {
      this.mFaceView.a(true, true);
      this.mVrySucc1.setImageResource(2131100237);
      this.mVrySucc2.setImageResource(2131100238);
    }
    else
    {
      this.mFaceView.a(false, true);
    }
    this.handler.postDelayed(new Runnable()
    {
      public final void run()
      {
        ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.this.mVrySucc1.getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.this.mFaceView.getCenterY() - f * 170.0F));
        ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.this.mVrySucc2.getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.this.mFaceView.getCenterY() - f * 170.0F));
      }
    }, 2000L);
  }
  
  private void initValidationUI()
  {
    this.mChangeVryTxt = ((TextView)findViewById(2131165523));
    this.mOpenLower = findViewById(2131165813);
    this.mOpenUper = findViewById(2131165814);
    this.mOpenUperDoor = ((ImageView)findViewById(2131165815));
    this.mOpenUperDoorNew = ((ImageView)findViewById(2131165817));
    QQUser localQQUser1 = tt.a().k.b();
    QQUser localQQUser2 = aaz.g();
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      this.animationHandler.post(new b(this.mOpenUperDoor));
      this.animationHandler.post(new a(this.mOpenUperDoorNew));
    }
    this.mOpenUper.postDelayed(new Runnable()
    {
      public final void run()
      {
        FaceStartVryCameraActivity.this.startOpenAnimation();
      }
    }, 800L);
    this.mBgUpper = findViewById(2131166315);
    this.mBgUpper.postDelayed(new Runnable()
    {
      public final void run()
      {
        FaceStartVryCameraActivity localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
        FaceStartVryCameraActivity.access$2002(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mBgUpper.getHeight());
        localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
        FaceStartVryCameraActivity.access$2202(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mOpenUper.getHeight() - FaceStartVryCameraActivity.this.mLogo.getBottom() - (FaceStartVryCameraActivity.this.mOpenUper.getHeight() - FaceStartVryCameraActivity.this.mOpenUperDoor.getBottom()));
        localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
        FaceStartVryCameraActivity.access$2602(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mOpenLower.getHeight());
      }
    }, 500L);
    this.mLogoMiddle = findViewById(2131166300);
    this.mLogoMiddle.setVisibility(4);
    this.mBmpLogo = aaz.a(getResources(), 2131100140);
    this.mBmpLogoGreen = aaz.a(getResources(), 2131100142);
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      ((ImageView)this.mLogoMiddle).setImageDrawable(getResources().getDrawable(2131100139));
      this.mBmpLogoGreen = aaz.a(getResources(), 2131100144);
      this.mBmpLogo = aaz.a(getResources(), 2131100144);
      this.mChangeVryTxt.setTextColor(getResources().getColor(2130968657));
    }
    else
    {
      this.mChangeVryTxt.setTextColor(getResources().getColor(2130968656));
    }
    if (this.mBmpLogo != null)
    {
      this.mLogo = ((ImageView)findViewById(2131166301));
      this.mLogo.setImageBitmap(this.mBmpLogo);
    }
    if (!RqdApplication.j()) {
      this.mChangeVryTxt.setText(2131493774);
    }
    this.mChangeVryTxt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        FaceStartVryCameraActivity.this.jumpGesOrPWD();
      }
    });
  }
  
  private void jumpGesOrPWD()
  {
    if (!RqdApplication.j())
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
    this.mTipTxt.setText(2131493296);
  }
  
  private void setLiveDetectTxt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.mTipTxt.setText(2131493292);
      return;
    case 5: 
      this.mTipTxt.setText(2131493291);
      return;
    case 4: 
      this.mTipTxt.setText(2131493300);
      return;
    case 3: 
      this.mTipTxt.setText(2131493299);
      return;
    case 2: 
      this.mTipTxt.setText(2131493298);
      return;
    }
    this.mTipTxt.setText(2131493297);
  }
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131492987, getString(paramInt1), paramInt2, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          sw.a().e();
          RqdApplication.l();
          FaceStartVryCameraActivity.this.setResult(35);
          FaceStartVryCameraActivity.this.finish();
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          sw.a().e();
          RqdApplication.l();
          FaceStartVryCameraActivity.this.setResult(35);
          FaceStartVryCameraActivity.this.finish();
        }
      });
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
      {
        if (RqdApplication.i())
        {
          exitToken();
          return true;
        }
        if (this.mIsActiveSuccess) {
          return true;
        }
        finish();
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("verify gesture: resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", requestCode=");
    localStringBuilder.append(paramInt1);
    xv.c(localStringBuilder.toString());
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      ss.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    paramBundle = new StringBuilder("flag=");
    paramBundle.append(this.mFaceOpType);
    paramBundle.append(",realuin=");
    paramBundle.append(this.realNameBindUin);
    xv.a(paramBundle.toString());
    this.mIsh5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.mDetectSucc = false;
    this.mIsActiveSuccess = false;
    setContentView(2131296342);
    hideTitle();
    initValidationUI();
    init();
    vg.d();
    su.a().d(aaz.e(), this.mScene, this.handler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mServerData = null;
    FaceRecognitionCameraPreview localFaceRecognitionCameraPreview = this.mPreview;
    if (localFaceRecognitionCameraPreview != null)
    {
      localFaceRecognitionCameraPreview.c();
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
      yt local11 = new yt()
      {
        public final void a()
        {
          FaceRecognitionCameraPreview localFaceRecognitionCameraPreview = FaceStartVryCameraActivity.this.mPreview;
          FaceStartVryCameraActivity localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
          localFaceRecognitionCameraPreview.a(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mScene, FaceStartVryCameraActivity.this.handler, FaceStartVryCameraActivity.this.mFaceView, FaceStartVryCameraActivity.this.mTipTxt);
          FaceStartVryCameraActivity.this.mPreview.setVisibility(0);
        }
        
        public final void b()
        {
          FaceRecognitionCameraPreview localFaceRecognitionCameraPreview = FaceStartVryCameraActivity.this.mPreview;
          FaceStartVryCameraActivity localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
          localFaceRecognitionCameraPreview.a(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mScene, FaceStartVryCameraActivity.this.handler, FaceStartVryCameraActivity.this.mFaceView, FaceStartVryCameraActivity.this.mTipTxt);
          FaceStartVryCameraActivity.this.mPreview.setVisibility(0);
        }
      };
      requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, local11);
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
      this.mBackArrow.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          xv.c("onBackPressed");
          FaceStartVryCameraActivity.this.finish();
        }
      });
    }
  }
  
  public void startAnimation()
  {
    Bitmap localBitmap = this.mBmpLogoGreen;
    if (localBitmap != null) {
      this.mLogo.setImageBitmap(localBitmap);
    }
    this.mLogoMiddle.setVisibility(0);
    this.animationHandler.post(new c(this.mBgUpper, this.mLogoMiddle));
  }
  
  public void startOpenAnimation()
  {
    this.mOpenAnimGoUp = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mOpenHeightUpper);
    this.mOpenAnimGoUp.setDuration(500L);
    this.mOpenAnimGoDown = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mOpenHeightLower);
    this.mOpenAnimGoDown.setDuration(500L);
    this.mOpenAnimGoDown.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        FaceStartVryCameraActivity.this.mOpenLower.setVisibility(8);
        FaceStartVryCameraActivity.this.mOpenUper.setVisibility(8);
        FaceStartVryCameraActivity.this.mPreview.a(true, false, 0, 0);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        FaceStartVryCameraActivity.this.mPreview.setStop(true);
      }
    });
    this.mOpenUper.startAnimation(this.mOpenAnimGoUp);
    this.mOpenLower.startAnimation(this.mOpenAnimGoDown);
  }
  
  final class a
    implements Runnable
  {
    private View b;
    
    public a(View paramView)
    {
      this.b = paramView;
      FaceStartVryCameraActivity.access$3402(FaceStartVryCameraActivity.this, new AlphaAnimation(0.0F, 1.0F));
      FaceStartVryCameraActivity.this.mAnimAlpha.setDuration(500L);
      FaceStartVryCameraActivity.this.mAnimAlpha.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.a.a(FaceStartVryCameraActivity.a.this).setVisibility(0);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.a.a(FaceStartVryCameraActivity.a.this).setVisibility(0);
        }
      });
    }
    
    public final void run()
    {
      this.b.startAnimation(FaceStartVryCameraActivity.this.mAnimAlpha);
    }
  }
  
  final class b
    implements Runnable
  {
    private View b;
    
    public b(View paramView)
    {
      this.b = paramView;
      FaceStartVryCameraActivity.access$3402(FaceStartVryCameraActivity.this, new AlphaAnimation(1.0F, 0.0F));
      FaceStartVryCameraActivity.this.mAnimAlpha.setDuration(500L);
      FaceStartVryCameraActivity.this.mAnimAlpha.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.b.a(FaceStartVryCameraActivity.b.this).setVisibility(4);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      this.b.startAnimation(FaceStartVryCameraActivity.this.mAnimAlpha);
    }
  }
  
  final class c
    implements Runnable
  {
    private View b;
    private View c;
    
    public c(View paramView1, View paramView2)
    {
      this.b = paramView1;
      this.c = paramView2;
      FaceStartVryCameraActivity.access$2902(FaceStartVryCameraActivity.this, new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F));
      FaceStartVryCameraActivity.this.mAnimRotate.setDuration(250L);
      FaceStartVryCameraActivity.access$3002(FaceStartVryCameraActivity.this, new TranslateAnimation(0.0F, 0.0F, 0.0F, -FaceStartVryCameraActivity.this.mHeightUpper));
      FaceStartVryCameraActivity.this.mAnimGoUp.setDuration(500L);
      FaceStartVryCameraActivity.this.mAnimRotate.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.c.a(FaceStartVryCameraActivity.c.this).setVisibility(4);
          FaceStartVryCameraActivity.c.b(FaceStartVryCameraActivity.c.this).startAnimation(FaceStartVryCameraActivity.this.mAnimGoUp);
          sx.a(RqdApplication.n()).a();
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      FaceStartVryCameraActivity.this.mAnimGoUp.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.this.mBgUpper.setVisibility(4);
          FaceStartVryCameraActivity.this.mLogoMiddle.setVisibility(4);
          IndexActivity.need_query_dual_msg = true;
          FaceStartVryCameraActivity.this.finish();
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      this.c.startAnimation(FaceStartVryCameraActivity.this.mAnimRotate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceStartVryCameraActivity
 * JD-Core Version:    0.7.0.1
 */