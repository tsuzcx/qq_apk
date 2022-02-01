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
import com.tencent.token.by;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.cq;
import com.tencent.token.ea;
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
      FaceStartVryCameraActivity.access$1502(FaceStartVryCameraActivity.this, ea.a(localArrayList));
      if (FaceStartVryCameraActivity.this.mServerData != null)
      {
        long l = m.e();
        int i = FaceStartVryCameraActivity.this.getLockStatus();
        FaceStartVryCameraActivity.access$1702(FaceStartVryCameraActivity.this, true);
        ca.a().a(0L, l, FaceStartVryCameraActivity.this.mFaceOpType, FaceStartVryCameraActivity.this.mServerData, i, FaceStartVryCameraActivity.this.mFaceScene, FaceStartVryCameraActivity.this.mFaceView.getBrightModeIntValue(), FaceStartVryCameraActivity.this.handler);
        return;
      }
      g.a("OPTYPE_VALIDATION serverData == null");
    }
    
    private void a(final boolean paramAnonymousBoolean)
    {
      FaceStartVryCameraActivity.access$202(FaceStartVryCameraActivity.this, true);
      FaceStartVryCameraActivity.this.showUserDialog(2131230843, FaceStartVryCameraActivity.this.getResources().getString(2131231281), 2131230897, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
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
      int i = 0;
      g.a("facepwd msg.what=" + paramAnonymousMessage.what);
      long l;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 3082: 
      case 2: 
      case 13: 
      case 73: 
      case 11: 
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (paramAnonymousMessage.arg1 != 0);
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
            } while (FaceStartVryCameraActivity.this.mIsShowingErrorDialog);
            a(true);
            return;
            paramAnonymousMessage = (TextView)FaceStartVryCameraActivity.this.findViewById(2131558914);
          } while (paramAnonymousMessage == null);
          paramAnonymousMessage.setText(2131231031);
          return;
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
          FaceStartVryCameraActivity.access$502(FaceStartVryCameraActivity.this, (FaceData)paramAnonymousMessage.obj);
        } while (FaceStartVryCameraActivity.this.mFaceData.mUploadData == null);
        if (FaceStartVryCameraActivity.this.mNeedLiveAction)
        {
          FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
          if (FaceStartVryCameraActivity.this.mTipTxt != null) {
            FaceStartVryCameraActivity.this.setLiveDetectTxt(FaceStartVryCameraActivity.this.mActions[0]);
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
        FaceStartVryCameraActivity.this.mTipTxt.setText(2131230787);
        a();
        return;
      case 71: 
        if (FaceStartVryCameraActivity.this.mActions[0] <= 4) {
          FaceStartVryCameraActivity.this.mFaceView.setStatus(9);
        }
        for (;;)
        {
          FaceStartVryCameraActivity.this.mTipTxt.setText(2131230787);
          a();
          return;
          FaceStartVryCameraActivity.this.mFaceView.setStatus(6);
        }
      case 3058: 
        g.c("K_MSG_POST_FACERECOGNITION = " + paramAnonymousMessage.arg1);
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
        e locale = (e)paramAnonymousMessage.obj;
        e.a(FaceStartVryCameraActivity.this.getResources(), locale);
        g.c("faceRe ret.mErrCode=" + locale.a);
        switch (locale.a)
        {
        default: 
          if (RqdApplication.g()) {
            break;
          }
        }
        for (i = 2131231033;; i = 2131231032)
        {
          FaceStartVryCameraActivity.this.showUserDialog(2131230935, locale.c, 2131230881, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
          FaceStartVryCameraActivity.this.showNobindingAlert(FaceStartVryCameraActivity.this, 2131231100, 2131231094);
          return;
          FaceStartVryCameraActivity.access$1208(FaceStartVryCameraActivity.this);
          if (!RqdApplication.g()) {
            i = 2131231033;
          }
          for (paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131231038); FaceStartVryCameraActivity.this.mRetryCount < 5; paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131231037))
          {
            l.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, FaceStartVryCameraActivity.this.mRetryCount);
            FaceStartVryCameraActivity.this.showUserDialog(2131231035, locale.c, 2131231034, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            i = 2131231032;
          }
          l.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
          FaceStartVryCameraActivity.this.showUserDialog(2131231036, paramAnonymousMessage, i, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              FaceStartVryCameraActivity.this.jumpGesOrPWD();
            }
          });
          return;
          m.b(0L);
          if (!RqdApplication.g()) {
            i = 2131231033;
          }
          for (paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131231029);; paramAnonymousMessage = FaceStartVryCameraActivity.this.getResources().getString(2131231028))
          {
            FaceStartVryCameraActivity.this.showUserDialog(2131230935, locale.c + "，" + paramAnonymousMessage, i, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                FaceStartVryCameraActivity.this.jumpGesOrPWD();
              }
            });
            return;
            i = 2131231032;
          }
        }
      case 1008: 
        if (paramAnonymousMessage.arg1 == 0)
        {
          FaceStartVryCameraActivity.this.dismissDialog();
          paramAnonymousMessage = cq.a().e();
          if (paramAnonymousMessage == null)
          {
            bu.a().a(System.currentTimeMillis(), 23);
            FaceStartVryCameraActivity.this.showNobindingAlert(FaceStartVryCameraActivity.this, 2131231099, 2131231101);
            return;
          }
          FaceStartVryCameraActivity.this.dismissDialog();
          l = m.e();
          if (l > 0L) {
            break label1311;
          }
          l = paramAnonymousMessage.mRealUin;
        }
        break;
      }
      label1311:
      for (;;)
      {
        by.a(FaceStartVryCameraActivity.this.getApplicationContext()).a(FaceStartVryCameraActivity.this, 523005419L, FaceStartVryCameraActivity.this.handler, l + "");
        return;
        FaceStartVryCameraActivity.this.dismissDialog();
        paramAnonymousMessage = (e)paramAnonymousMessage.obj;
        FaceStartVryCameraActivity.this.showUserDialog(paramAnonymousMessage.c);
        return;
        FaceStartVryCameraActivity.this.dismissDialog();
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
        {
          FaceStartVryCameraActivity.this.showToast(FaceStartVryCameraActivity.this.getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("exception"));
          return;
        }
        FaceStartVryCameraActivity.this.showToast(2131231411);
        return;
        RqdApplication.d();
        RqdApplication.i();
        l.a(null, FaceStartVryCameraActivity.LANUCH_RETRY_COUNT, 0);
        FaceStartVryCameraActivity.this.mFaceView.setStatus(3);
        FaceStartVryCameraActivity.this.startAnimation();
        return;
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
    if (m.e() != 0L) {
      if ((cc.a().c()) && (cc.a().e() == 2)) {
        i = 19;
      }
    }
    for (;;)
    {
      g.c("getLockStatus = " + i);
      return i;
      i = 18;
      continue;
      if ((cc.a().c()) && (cc.a().e() == 2)) {
        i = 17;
      } else {
        i = 16;
      }
    }
  }
  
  private void gotoQuickLoginWb()
  {
    cq.a().e();
    if (m.e() < 0L)
    {
      ca.a().b(this.handler);
      showProDialog(this, 2131230843, 2131231298, null);
      return;
    }
    by.a(getApplicationContext()).a(this, 523005419L, this.handler, "" + m.e());
  }
  
  private void init()
  {
    this.mRetryCount = l.b(null, LANUCH_RETRY_COUNT);
    g.c("retryCount = " + this.mRetryCount);
    if (this.mRetryCount >= 5) {
      jumpGesOrPWD();
    }
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131558768));
    this.mPreview.setVisibility(4);
    this.mFaceView = ((FaceView)findViewById(2131558769));
    QQUser localQQUser1 = cq.a().e();
    QQUser localQQUser2 = m.g();
    this.mVrySucc1 = ((ImageView)findViewById(2131558867));
    this.mVrySucc2 = ((ImageView)findViewById(2131558868));
    this.mTipTxt = ((TextView)findViewById(2131558866));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTipTxt.getLayoutParams();
    int i = getResources().getDisplayMetrics().densityDpi;
    final float f = getResources().getDisplayMetrics().density;
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
      this.handler.postDelayed(new Runnable()
      {
        public void run()
        {
          ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.this.mVrySucc1.getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.this.mFaceView.getCenterY() - f * 170.0F));
          ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.this.mVrySucc2.getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.this.mFaceView.getCenterY() - f * 170.0F));
        }
      }, 2000L);
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
    this.mChangeVryTxt = ((TextView)findViewById(2131558873));
    this.mOpenLower = findViewById(2131558874);
    this.mOpenUper = findViewById(2131558875);
    this.mOpenUperDoor = ((ImageView)findViewById(2131558878));
    this.mOpenUperDoorNew = ((ImageView)findViewById(2131558879));
    QQUser localQQUser1 = cq.a().e();
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
    this.mBgUpper = findViewById(2131558823);
    this.mBgUpper.postDelayed(new Runnable()
    {
      public void run()
      {
        FaceStartVryCameraActivity.access$2002(FaceStartVryCameraActivity.this, FaceStartVryCameraActivity.this.mBgUpper.getHeight());
        FaceStartVryCameraActivity.access$2202(FaceStartVryCameraActivity.this, FaceStartVryCameraActivity.this.mOpenUper.getHeight() - FaceStartVryCameraActivity.this.mLogo.getBottom() - (FaceStartVryCameraActivity.this.mOpenUper.getHeight() - FaceStartVryCameraActivity.this.mOpenUperDoor.getBottom()));
        FaceStartVryCameraActivity.access$2602(FaceStartVryCameraActivity.this, FaceStartVryCameraActivity.this.mOpenLower.getHeight());
      }
    }, 500L);
    this.mLogoMiddle = findViewById(2131558872);
    this.mLogoMiddle.setVisibility(4);
    this.mBmpLogo = m.a(getResources(), 2130837982);
    this.mBmpLogoGreen = m.a(getResources(), 2130837984);
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      ((ImageView)this.mLogoMiddle).setImageDrawable(getResources().getDrawable(2130837981));
      this.mBmpLogoGreen = m.a(getResources(), 2130837986);
      this.mBmpLogo = m.a(getResources(), 2130837986);
      this.mChangeVryTxt.setTextColor(getResources().getColor(2131492924));
    }
    for (;;)
    {
      if (this.mBmpLogo != null)
      {
        this.mLogo = ((ImageView)findViewById(2131558871));
        this.mLogo.setImageBitmap(this.mBmpLogo);
      }
      if (!RqdApplication.g()) {
        this.mChangeVryTxt.setText(2131231619);
      }
      this.mChangeVryTxt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FaceStartVryCameraActivity.this.jumpGesOrPWD();
        }
      });
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
  
  private void showNobindingAlert(final Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          cc.a().a(paramContext);
          RqdApplication.i();
          FaceStartVryCameraActivity.this.setResult(35);
          FaceStartVryCameraActivity.this.finish();
        }
      }, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          cc.a().a(paramContext);
          RqdApplication.i();
          FaceStartVryCameraActivity.this.setResult(35);
          FaceStartVryCameraActivity.this.finish();
        }
      });
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
    g.c("verify gesture: resultCode=" + paramInt2 + ", requestCode=" + paramInt1);
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      by.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    g.a("flag=" + this.mFaceOpType + ",realuin=" + this.realNameBindUin);
    this.mIsh5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.mDetectSucc = false;
    this.mIsActiveSuccess = false;
    setContentView(2130968656);
    hideTitle();
    initValidationUI();
    init();
    ProtoFaceCommon.e();
    ca.a().f(m.e(), this.mScene, this.handler);
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
      f local11 = new f()
      {
        public void a()
        {
          FaceStartVryCameraActivity.this.mPreview.a(FaceStartVryCameraActivity.this, FaceStartVryCameraActivity.this.mScene, FaceStartVryCameraActivity.this.handler, FaceStartVryCameraActivity.this.mFaceView, FaceStartVryCameraActivity.this.mTipTxt);
          FaceStartVryCameraActivity.this.mPreview.setVisibility(0);
        }
        
        public void a(List<String> paramAnonymousList)
        {
          FaceStartVryCameraActivity.this.mPreview.a(FaceStartVryCameraActivity.this, FaceStartVryCameraActivity.this.mScene, FaceStartVryCameraActivity.this.handler, FaceStartVryCameraActivity.this.mFaceView, FaceStartVryCameraActivity.this.mTipTxt);
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
    if (this.mBmpLogoGreen != null) {
      this.mLogo.setImageBitmap(this.mBmpLogoGreen);
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
          cd.a(RqdApplication.l()).a();
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