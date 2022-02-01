package com.tencent.token.ui;

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
import com.tencent.token.bu;
import com.tencent.token.bv;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.ce;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.cr;
import com.tencent.token.eb;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.ArrayList;
import java.util.List;

public class FaceStartVryCameraActivity
  extends BaseActivity
{
  public static String LANUCH_RETRY_COUNT = "fr_retrycount";
  private final int ALLOW_MAX_RETRY = 5;
  private Handler animationHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage) {}
  };
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
      FaceStartVryCameraActivity.access$1502(FaceStartVryCameraActivity.this, eb.a(localArrayList));
      if (FaceStartVryCameraActivity.this.mServerData != null)
      {
        long l = m.e();
        int i = FaceStartVryCameraActivity.this.getLockStatus();
        FaceStartVryCameraActivity.access$1702(FaceStartVryCameraActivity.this, true);
        cb.a().a(0L, l, FaceStartVryCameraActivity.this.mFaceOpType, FaceStartVryCameraActivity.this.mServerData, i, FaceStartVryCameraActivity.this.mFaceScene, FaceStartVryCameraActivity.this.mFaceView.getBrightModeIntValue(), FaceStartVryCameraActivity.this.handler);
        return;
      }
      g.a("OPTYPE_VALIDATION serverData == null");
    }
    
    private void a(final boolean paramAnonymousBoolean)
    {
      FaceStartVryCameraActivity.access$202(FaceStartVryCameraActivity.this, true);
      FaceStartVryCameraActivity localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
      localFaceStartVryCameraActivity.showUserDialog(2131492985, localFaceStartVryCameraActivity.getResources().getString(2131493423), 2131493039, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          FaceStartVryCameraActivity.this.dismissDialog();
        }
      }, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymous2DialogInterface)
        {
          FaceStartVryCameraActivity.this.mPreview.setStop(true);
          FaceStartVryCameraActivity.this.mPreview.c();
          FaceStartVryCameraActivity.access$202(FaceStartVryCameraActivity.this, false);
          if (!paramAnonymousBoolean) {
            FaceStartVryCameraActivity.this.finish();
          }
        }
      });
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("facepwd msg.what=");
      ((StringBuilder)localObject1).append(paramAnonymousMessage.what);
      g.a(((StringBuilder)localObject1).toString());
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
                Object localObject2;
                StringBuilder localStringBuilder;
                if (j != 1008)
                {
                  if (j != 3058)
                  {
                    if (j != 3082)
                    {
                      if (j != 4104)
                      {
                        if (j != 4109) {
                          return;
                        }
                        RqdApplication.d();
                        RqdApplication.i();
                        l.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
                        FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
                        FaceStartVryCameraActivity.this.startAnimation();
                        return;
                      }
                      FaceStartVryCameraActivity.this.dismissDialog();
                      if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
                      {
                        localObject1 = FaceStartVryCameraActivity.this;
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append(FaceStartVryCameraActivity.this.getResources().getString(2131493553));
                        ((StringBuilder)localObject2).append(":");
                        ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
                        ((FaceStartVryCameraActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
                        return;
                      }
                      FaceStartVryCameraActivity.this.showToast(2131493553);
                      return;
                    }
                    if (paramAnonymousMessage.arg1 != 0) {
                      return;
                    }
                    if (paramAnonymousMessage.arg2 == 1)
                    {
                      paramAnonymousMessage = (int[])paramAnonymousMessage.obj;
                      if ((paramAnonymousMessage != null) && (paramAnonymousMessage.length >= 1))
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
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("K_MSG_POST_FACERECOGNITION = ");
                  ((StringBuilder)localObject1).append(paramAnonymousMessage.arg1);
                  g.c(((StringBuilder)localObject1).toString());
                  if (paramAnonymousMessage.arg1 == 0)
                  {
                    RqdApplication.d();
                    i = paramAnonymousMessage.arg2;
                    RqdApplication.i();
                    l.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
                    FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
                    FaceStartVryCameraActivity.this.startAnimation();
                    return;
                  }
                  FaceStartVryCameraActivity.this.mVrySucc1.setVisibility(4);
                  FaceStartVryCameraActivity.this.mVrySucc2.setVisibility(4);
                  localObject1 = (e)paramAnonymousMessage.obj;
                  e.a(FaceStartVryCameraActivity.this.getResources(), (e)localObject1);
                  paramAnonymousMessage = new StringBuilder();
                  paramAnonymousMessage.append("faceRe ret.mErrCode=");
                  paramAnonymousMessage.append(((e)localObject1).a);
                  g.c(paramAnonymousMessage.toString());
                  j = ((e)localObject1).a;
                  if (j != 110)
                  {
                    i = 2131493175;
                    switch (j)
                    {
                    default: 
                      if (!RqdApplication.g()) {
                        i = 2131493175;
                      } else {
                        i = 2131493174;
                      }
                      FaceStartVryCameraActivity.this.showUserDialog(2131493077, ((e)localObject1).c, 2131493023, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                      {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.jumpGesOrPWD();
                        }
                      }, new DialogInterface.OnCancelListener()
                      {
                        public void onCancel(DialogInterface paramAnonymous2DialogInterface)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      });
                      return;
                    case 222: 
                      m.b(0L);
                      if (!RqdApplication.g())
                      {
                        paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493171);
                      }
                      else
                      {
                        paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493170);
                        i = 2131493174;
                      }
                      localObject2 = FaceStartVryCameraActivity.this;
                      localStringBuilder = new StringBuilder();
                      localStringBuilder.append(((e)localObject1).c);
                      localStringBuilder.append("，");
                      localStringBuilder.append(paramAnonymousMessage);
                      ((FaceStartVryCameraActivity)localObject2).showUserDialog(2131493077, localStringBuilder.toString(), i, new DialogInterface.OnClickListener()
                      {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.jumpGesOrPWD();
                        }
                      });
                      return;
                    }
                    FaceStartVryCameraActivity.access$1208(FaceStartVryCameraActivity.this);
                    if (!RqdApplication.g())
                    {
                      paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493180);
                      i = 2131493175;
                    }
                    else
                    {
                      paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131493179);
                      i = 2131493174;
                    }
                    if (FaceStartVryCameraActivity.this.mRetryCount < 5)
                    {
                      l.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, FaceStartVryCameraActivity.this.mRetryCount);
                      FaceStartVryCameraActivity.this.showUserDialog(2131493177, ((e)localObject1).c, 2131493176, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                      {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                          FaceStartVryCameraActivity.this.jumpGesOrPWD();
                        }
                      }, new DialogInterface.OnCancelListener()
                      {
                        public void onCancel(DialogInterface paramAnonymous2DialogInterface)
                        {
                          FaceStartVryCameraActivity.this.resetFaceDetection();
                        }
                      });
                      return;
                    }
                    l.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
                    FaceStartVryCameraActivity.this.showUserDialog(2131493178, paramAnonymousMessage, i, new DialogInterface.OnClickListener()
                    {
                      public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        FaceStartVryCameraActivity.this.jumpGesOrPWD();
                      }
                    });
                    return;
                  }
                  paramAnonymousMessage = FaceStartVryCameraActivity.this;
                  paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493242, 2131493236);
                  return;
                }
                if (paramAnonymousMessage.arg1 == 0)
                {
                  FaceStartVryCameraActivity.this.dismissDialog();
                  paramAnonymousMessage = cr.a().e();
                  if (paramAnonymousMessage == null)
                  {
                    bu.a().a(System.currentTimeMillis(), 23);
                    paramAnonymousMessage = FaceStartVryCameraActivity.this;
                    paramAnonymousMessage.showNobindingAlert(paramAnonymousMessage, 2131493241, 2131493243);
                    return;
                  }
                  FaceStartVryCameraActivity.this.dismissDialog();
                  long l2 = m.e();
                  long l1 = l2;
                  if (l2 <= 0L) {
                    l1 = paramAnonymousMessage.mRealUin;
                  }
                  paramAnonymousMessage = bz.a(FaceStartVryCameraActivity.this.getApplicationContext());
                  localObject1 = FaceStartVryCameraActivity.this;
                  localObject2 = ((FaceStartVryCameraActivity)localObject1).handler;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(l1);
                  localStringBuilder.append("");
                  paramAnonymousMessage.a((Activity)localObject1, 523005419L, (Handler)localObject2, localStringBuilder.toString());
                  return;
                }
                FaceStartVryCameraActivity.this.dismissDialog();
                paramAnonymousMessage = (e)paramAnonymousMessage.obj;
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
            FaceStartVryCameraActivity.this.mTipTxt.setText(2131492929);
            a();
          }
          else
          {
            paramAnonymousMessage = (TextView)FaceStartVryCameraActivity.this.findViewById(2131165527);
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.setText(2131493173);
            }
          }
        }
        else
        {
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
          FaceStartVryCameraActivity.this.mTipTxt.setText(2131492929);
          a();
        }
      }
      else
      {
        if (FaceStartVryCameraActivity.this.mIsShowingErrorDialog) {
          return;
        }
        a(true);
      }
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
    if (m.e() != 0L)
    {
      if ((cd.a().c()) && (cd.a().e() == 2)) {
        i = 19;
      } else {
        i = 18;
      }
    }
    else if ((cd.a().c()) && (cd.a().e() == 2)) {
      i = 17;
    } else {
      i = 16;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLockStatus = ");
    localStringBuilder.append(i);
    g.c(localStringBuilder.toString());
    return i;
  }
  
  private void gotoQuickLoginWb()
  {
    cr.a().e();
    if (m.e() < 0L)
    {
      bv.a().e(this.handler);
      showProDialog(this, 2131492985, 2131493440, null);
      return;
    }
    bz localbz = bz.a(getApplicationContext());
    Handler localHandler = this.handler;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(m.e());
    localbz.a(this, 523005419L, localHandler, localStringBuilder.toString());
  }
  
  private void init()
  {
    this.mRetryCount = l.b(null, LANUCH_RETRY_COUNT);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("retryCount = ");
    ((StringBuilder)localObject).append(this.mRetryCount);
    g.c(((StringBuilder)localObject).toString());
    if (this.mRetryCount >= 5) {
      jumpGesOrPWD();
    }
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131165811));
    this.mPreview.setVisibility(4);
    this.mFaceView = ((FaceView)findViewById(2131165619));
    localObject = cr.a().e();
    QQUser localQQUser = m.g();
    this.mVrySucc1 = ((ImageView)findViewById(2131166264));
    this.mVrySucc2 = ((ImageView)findViewById(2131166265));
    this.mTipTxt = ((TextView)findViewById(2131165671));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTipTxt.getLayoutParams();
    int i = getResources().getDisplayMetrics().densityDpi;
    final float f = getResources().getDisplayMetrics().density;
    if (i <= 240) {
      localMarginLayoutParams.bottomMargin = ((int)(70.0F * f));
    } else if (i <= 320) {
      localMarginLayoutParams.bottomMargin = ((int)(90.0F * f));
    } else {
      localMarginLayoutParams.bottomMargin = ((int)(90.0F * f));
    }
    if ((localObject != null) && (localQQUser != null) && (localQQUser.mIsZzb))
    {
      this.mFaceView.a(true, true);
      this.mVrySucc1.setImageResource(2131100228);
      this.mVrySucc2.setImageResource(2131100229);
    }
    else
    {
      this.mFaceView.a(false, true);
    }
    this.handler.postDelayed(new Runnable()
    {
      public void run()
      {
        ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.this.mVrySucc1.getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.this.mFaceView.getCenterY() - f * 170.0F));
        ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.this.mVrySucc2.getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.this.mFaceView.getCenterY() - f * 170.0F));
      }
    }, 2000L);
  }
  
  private void initValidationUI()
  {
    this.mChangeVryTxt = ((TextView)findViewById(2131165504));
    this.mOpenLower = findViewById(2131165789);
    this.mOpenUper = findViewById(2131165790);
    this.mOpenUperDoor = ((ImageView)findViewById(2131165791));
    this.mOpenUperDoorNew = ((ImageView)findViewById(2131165793));
    QQUser localQQUser1 = cr.a().e();
    QQUser localQQUser2 = m.g();
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      this.animationHandler.post(new b(this.mOpenUperDoor));
      this.animationHandler.post(new a(this.mOpenUperDoorNew));
    }
    this.mOpenUper.postDelayed(new Runnable()
    {
      public void run()
      {
        FaceStartVryCameraActivity.this.startOpenAnimation();
      }
    }, 800L);
    this.mBgUpper = findViewById(2131166258);
    this.mBgUpper.postDelayed(new Runnable()
    {
      public void run()
      {
        FaceStartVryCameraActivity localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
        FaceStartVryCameraActivity.access$2002(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mBgUpper.getHeight());
        localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
        FaceStartVryCameraActivity.access$2202(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mOpenUper.getHeight() - FaceStartVryCameraActivity.this.mLogo.getBottom() - (FaceStartVryCameraActivity.this.mOpenUper.getHeight() - FaceStartVryCameraActivity.this.mOpenUperDoor.getBottom()));
        localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
        FaceStartVryCameraActivity.access$2602(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mOpenLower.getHeight());
      }
    }, 500L);
    this.mLogoMiddle = findViewById(2131166243);
    this.mLogoMiddle.setVisibility(4);
    this.mBmpLogo = m.a(getResources(), 2131100131);
    this.mBmpLogoGreen = m.a(getResources(), 2131100133);
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      ((ImageView)this.mLogoMiddle).setImageDrawable(getResources().getDrawable(2131100130));
      this.mBmpLogoGreen = m.a(getResources(), 2131100135);
      this.mBmpLogo = m.a(getResources(), 2131100135);
      this.mChangeVryTxt.setTextColor(getResources().getColor(2130968656));
    }
    else
    {
      this.mChangeVryTxt.setTextColor(getResources().getColor(2130968655));
    }
    if (this.mBmpLogo != null)
    {
      this.mLogo = ((ImageView)findViewById(2131166244));
      this.mLogo.setImageBitmap(this.mBmpLogo);
    }
    if (!RqdApplication.g()) {
      this.mChangeVryTxt.setText(2131493763);
    }
    this.mChangeVryTxt.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FaceStartVryCameraActivity.this.jumpGesOrPWD();
      }
    });
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
    this.mTipTxt.setText(2131493293);
  }
  
  private void setLiveDetectTxt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.mTipTxt.setText(2131493289);
      return;
    case 5: 
      this.mTipTxt.setText(2131493288);
      return;
    case 4: 
      this.mTipTxt.setText(2131493297);
      return;
    case 3: 
      this.mTipTxt.setText(2131493296);
      return;
    case 2: 
      this.mTipTxt.setText(2131493295);
      return;
    }
    this.mTipTxt.setText(2131493294);
  }
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131492985, getString(paramInt1), paramInt2, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          cd.a().a(paramContext);
          RqdApplication.i();
          FaceStartVryCameraActivity.this.setResult(35);
          FaceStartVryCameraActivity.this.finish();
        }
      }, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          cd.a().a(paramContext);
          RqdApplication.i();
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
        if (RqdApplication.f())
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("verify gesture: resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", requestCode=");
    localStringBuilder.append(paramInt1);
    g.c(localStringBuilder.toString());
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      bz.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    paramBundle = new StringBuilder();
    paramBundle.append("flag=");
    paramBundle.append(this.mFaceOpType);
    paramBundle.append(",realuin=");
    paramBundle.append(this.realNameBindUin);
    g.a(paramBundle.toString());
    this.mIsh5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.mDetectSucc = false;
    this.mIsActiveSuccess = false;
    setContentView(2131296336);
    hideTitle();
    initValidationUI();
    init();
    ProtoFaceCommon.e();
    cb.a().e(m.e(), this.mScene, this.handler);
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
      f local11 = new f()
      {
        public void a()
        {
          FaceRecognitionCameraPreview localFaceRecognitionCameraPreview = FaceStartVryCameraActivity.this.mPreview;
          FaceStartVryCameraActivity localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
          localFaceRecognitionCameraPreview.a(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mScene, FaceStartVryCameraActivity.this.handler, FaceStartVryCameraActivity.this.mFaceView, FaceStartVryCameraActivity.this.mTipTxt);
          FaceStartVryCameraActivity.this.mPreview.setVisibility(0);
        }
        
        public void a(List<String> paramAnonymousList)
        {
          paramAnonymousList = FaceStartVryCameraActivity.this.mPreview;
          FaceStartVryCameraActivity localFaceStartVryCameraActivity = FaceStartVryCameraActivity.this;
          paramAnonymousList.a(localFaceStartVryCameraActivity, localFaceStartVryCameraActivity.mScene, FaceStartVryCameraActivity.this.handler, FaceStartVryCameraActivity.this.mFaceView, FaceStartVryCameraActivity.this.mTipTxt);
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
        public void onClick(View paramAnonymousView)
        {
          g.c("onBackPressed");
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
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        FaceStartVryCameraActivity.this.mOpenLower.setVisibility(8);
        FaceStartVryCameraActivity.this.mOpenUper.setVisibility(8);
        FaceStartVryCameraActivity.this.mPreview.a(true, false, 0, 0);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        FaceStartVryCameraActivity.this.mPreview.setStop(true);
      }
    });
    this.mOpenUper.startAnimation(this.mOpenAnimGoUp);
    this.mOpenLower.startAnimation(this.mOpenAnimGoDown);
  }
  
  private class a
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
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.a.a(FaceStartVryCameraActivity.a.this).setVisibility(0);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.a.a(FaceStartVryCameraActivity.a.this).setVisibility(0);
        }
      });
    }
    
    public void run()
    {
      this.b.startAnimation(FaceStartVryCameraActivity.this.mAnimAlpha);
    }
  }
  
  private class b
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
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.b.a(FaceStartVryCameraActivity.b.this).setVisibility(4);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
    {
      this.b.startAnimation(FaceStartVryCameraActivity.this.mAnimAlpha);
    }
  }
  
  private class c
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
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.c.a(FaceStartVryCameraActivity.c.this).setVisibility(4);
          FaceStartVryCameraActivity.c.b(FaceStartVryCameraActivity.c.this).startAnimation(FaceStartVryCameraActivity.this.mAnimGoUp);
          ce.a(RqdApplication.l()).a();
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      FaceStartVryCameraActivity.this.mAnimGoUp.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FaceStartVryCameraActivity.this.mBgUpper.setVisibility(4);
          FaceStartVryCameraActivity.this.mLogoMiddle.setVisibility(4);
          IndexActivity.need_query_dual_msg = true;
          FaceStartVryCameraActivity.this.finish();
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
    {
      this.c.startAnimation(FaceStartVryCameraActivity.this.mAnimRotate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceStartVryCameraActivity
 * JD-Core Version:    0.7.0.1
 */