package com.tencent.token.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.Face;
import com.tencent.jni.Face.ImgData;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceImageView;
import com.tencent.token.ui.base.co;
import com.tencent.token.utils.n;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

public class FaceRecognitionCameraActivityOld
  extends BaseActivity
{
  public static final int K_FLAG_PHOTO_CONFIRM_FACE = 3;
  public static final int K_FLAG_PHOTO_CONFIRM_IDPHOTO_BACK = 2;
  public static final int K_FLAG_PHOTO_CONFIRM_IDPHOTO_FRONT = 1;
  public static String LANUCH_RETRY_COUNT = "fr_retrycount";
  public static final int OPTYPE_FACE_ADD = 4;
  public static final int OPTYPE_REALNAME_REG = 3;
  public static final int OPTYPE_REGIST = 1;
  public static final int OPTYPE_VALIDATION = 2;
  public static final int RESULT_CHANGERTIPS = 13;
  public static final int RESULT_ERROR = 2;
  public static final int RESULT_START = 10;
  public static final int RESULT_SUCCESS = 11;
  public static final int RESULT_TOODARK = 12;
  public static final int SCENE_VALIDATION_COMMON = 1;
  public static final int SCENE_VALIDATION_REALNAME_BIND = 2;
  public static final int SCENE_VALIDATION_REALNAME_MODPWD = 3;
  public static final int SUBOPTYPE_VALIDATION_BOOT = 0;
  public static final int SUBOPTYPE_VALIDATION_COMPARE = 2;
  public static final int SUBOPTYPE_VALIDATION_REALNAME = 3;
  public static final int SUBOPTYPE_VALIDATION_REALNAME_FINDPWD = 5;
  public static final int SUBOPTYPE_VALIDATION_REALNAME_MODPWD = 4;
  public static final int SUBOPTYPE_VALIDATION_TRY = 1;
  public static boolean faceversionold;
  public static int frameCount;
  public static int initTime;
  public static String resolution;
  public static int scanTime;
  public static int transcodingTime;
  private final int ALLOW_MAX_RETRY = 5;
  private Handler animationHandler = new hd(this);
  private Button btn_change;
  private Button btn_start_scan;
  private Button btn_vry_original;
  private boolean canvideo;
  private boolean detectsucc;
  private View dialogView;
  private co drawable;
  private int flag;
  private Handler handler = new fz(this);
  private Face.ImgData imgData1;
  private Face.ImgData imgData2;
  private boolean isShowingErrorDialog = false;
  private FaceImageView iv;
  private int localOpType;
  private AlphaAnimation mAnimAlpha;
  private TranslateAnimation mAnimGoUp;
  private RotateAnimation mAnimRotate;
  private View mBgUpper;
  private Bitmap mBmpLogo;
  private Bitmap mBmpLogoGreen;
  private int mHeightUpper;
  private boolean mIsActiveSuccess = false;
  private ImageView mLogo;
  private View mLogoMiddle;
  private TranslateAnimation mOpenAnimGoDown;
  private TranslateAnimation mOpenAnimGoUp;
  private int mOpenHeightLower;
  private int mOpenHeightUpper;
  private FaceRecognitionCameraPreviewOld mPreview;
  private int mScene = 1;
  private boolean mShowPKDialog = false;
  private View open_lower;
  private View open_upper;
  private ImageView open_upper_door;
  private ImageView open_upper_door_bg;
  private ImageView open_upper_door_new;
  private View page_bg_upper;
  private Dialog picdialog;
  private ImageView progress;
  private long realNameBindUin;
  private int retryCount;
  private byte[] serverData;
  private int step;
  private View toastView;
  private int validationType;
  
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
    this.retryCount = s.j(LANUCH_RETRY_COUNT);
    e.c("retryCount = " + this.retryCount);
    if (this.retryCount >= 5) {
      jumpGesOrPWD();
    }
    QQUser localQQUser1;
    if (this.flag == 1)
    {
      ((TextView)findViewById(2131296571)).setText(2131362470);
      this.mPreview = ((FaceRecognitionCameraPreviewOld)findViewById(2131296481));
      this.iv = ((FaceImageView)findViewById(2131296482));
      localQQUser1 = ax.a().e();
      if ((this.flag != 2) || (this.validationType != 0)) {
        break label304;
      }
      QQUser localQQUser2 = t.g();
      if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb)) {
        this.iv.a();
      }
    }
    for (;;)
    {
      this.drawable = new co(this);
      if ((this.flag == 2) && (this.validationType == 2))
      {
        ((TextView)findViewById(2131296571)).setText(2131362471);
        if (t.i())
        {
          t.j();
          this.mShowPKDialog = true;
          showUserDialog(2131361808, getString(2131362473), 2131362474, new hg(this));
        }
        new Thread(new hh(this)).start();
      }
      return;
      if (this.flag == 3)
      {
        ((TextView)findViewById(2131296571)).setText(2131362609);
        break;
      }
      if (this.validationType != 1) {
        break;
      }
      ((TextView)findViewById(2131296571)).setText(2131362483);
      break;
      label304:
      if (((this.flag == 3) && (this.validationType == 5)) || ((this.flag == 2) && (this.validationType == 3)) || ((localQQUser1 != null) && (localQQUser1.mIsZzb) && ((this.flag != 2) || (this.validationType != 2))))
      {
        this.iv.a();
        this.toastView.setVisibility(0);
      }
    }
  }
  
  private void initValidationUI()
  {
    this.btn_change = ((Button)findViewById(2131296585));
    this.open_lower = findViewById(2131296586);
    this.open_upper = findViewById(2131296587);
    this.page_bg_upper = findViewById(2131296537);
    this.open_upper_door = ((ImageView)findViewById(2131296590));
    this.open_upper_door_new = ((ImageView)findViewById(2131296591));
    this.open_upper_door_bg = ((ImageView)findViewById(2131296589));
    QQUser localQQUser1 = ax.a().e();
    QQUser localQQUser2 = t.g();
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      this.animationHandler.post(new hp(this, this.open_upper_door));
      this.animationHandler.post(new hn(this, this.open_upper_door_new));
    }
    this.open_upper.postDelayed(new hi(this), 800L);
    this.mBgUpper = findViewById(2131296536);
    this.mBgUpper.postDelayed(new hj(this), 500L);
    this.mLogoMiddle = findViewById(2131296584);
    this.mLogoMiddle.setVisibility(4);
    this.mBmpLogo = t.a(getResources(), 2130837920);
    this.mBmpLogoGreen = t.a(getResources(), 2130837922);
    if ((localQQUser1 != null) && (localQQUser2 != null) && (localQQUser2.mIsZzb))
    {
      ((ImageView)this.mLogoMiddle).setImageDrawable(getResources().getDrawable(2130837919));
      this.mBmpLogoGreen = t.a(getResources(), 2130837924);
      this.mBmpLogo = t.a(getResources(), 2130837924);
    }
    if (this.mBmpLogo != null)
    {
      this.mLogo = ((ImageView)findViewById(2131296583));
      this.mLogo.setImageBitmap(this.mBmpLogo);
    }
    if (!RqdApplication.d()) {
      this.btn_change.setBackgroundResource(2130837631);
    }
    this.btn_change.setOnClickListener(new hk(this));
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
      this.handler.removeMessages(90);
      if (n.a().c())
      {
        this.handler.postDelayed(new hb(this), 300L);
        return true;
      }
      finish();
      return true;
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 10) {
      if (this.step <= 0)
      {
        this.imgData1 = null;
        this.mPreview.b(this.step);
        this.iv.a(0);
      }
    }
    label257:
    label339:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              Face.ImgData localImgData;
              do
              {
                do
                {
                  return;
                  this.imgData2 = null;
                  break;
                } while (paramInt2 != 20);
                if (this.flag != 1) {
                  break label257;
                }
                this.step += 1;
                if (this.step < 2)
                {
                  showOrangeToast(2131362479, 2130837964);
                  this.mPreview.b(this.step);
                  this.iv.a(0);
                  return;
                }
                paramIntent = this.imgData1;
                localImgData = this.imgData2;
              } while ((this.imgData1 == null) || (this.imgData2 == null));
              this.serverData = Face.EncodeData(new Face.ImgData[] { paramIntent, localImgData });
            } while ((this.serverData == null) || (this.serverData.length <= 100));
            setContentView(2130903098);
            this.progress = ((ImageView)findViewById(2131296624));
            this.progress.setBackgroundDrawable(this.drawable);
            this.handler.sendEmptyMessageDelayed(13, 10000L);
            af.a().a(0L, 0L, this.flag, this.serverData, 0, this.mScene, this.handler);
            this.localOpType = this.flag;
            this.mPreview.a();
            return;
            if (this.flag != 3) {
              break label460;
            }
            if (this.validationType != 5) {
              break label339;
            }
            this.serverData = Face.EncodeData(new Face.ImgData[] { this.imgData1 });
          } while ((this.serverData == null) || (this.serverData.length <= 100));
          paramIntent = new Intent();
          paramIntent.putExtra("facedata", this.serverData);
          setResult(0, paramIntent);
          finish();
          return;
          this.step += 1;
          if (this.step < 2)
          {
            showOrangeToast(2131362479, 2130837964);
            this.mPreview.b(this.step);
            this.iv.a(0);
            return;
          }
          this.serverData = Face.EncodeData(new Face.ImgData[] { this.imgData1, this.imgData2 });
        } while ((this.serverData == null) || (this.serverData.length <= 100));
        paramIntent = new Intent();
        paramIntent.putExtra("facedata", this.serverData);
        setResult(0, paramIntent);
        finish();
        return;
      } while (this.flag != 4);
      this.serverData = Face.EncodeData(new Face.ImgData[] { this.imgData1 });
    } while ((this.serverData == null) || (this.serverData.length <= 100));
    label460:
    setContentView(2130903098);
    this.progress = ((ImageView)findViewById(2131296624));
    this.progress.setBackgroundDrawable(this.drawable);
    this.handler.sendEmptyMessageDelayed(13, 10000L);
    if (ax.a().e() != null) {}
    for (long l = ax.a().e().mRealUin;; l = 0L)
    {
      paramInt1 = getLockStatus();
      af.a().a(0L, l, this.flag, this.serverData, paramInt1, this.mScene, this.handler);
      this.localOpType = this.flag;
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    this.flag = getIntent().getIntExtra("flag", 2);
    this.validationType = getIntent().getIntExtra("istry", 0);
    e.a("flag=" + this.flag + ",validationType=" + this.validationType + ",realuin=" + this.realNameBindUin);
    resolution = "";
    transcodingTime = 0;
    scanTime = 0;
    frameCount = 0;
    this.detectsucc = false;
    this.mIsActiveSuccess = false;
    if ((this.flag == 2) && (this.validationType == 0))
    {
      setContentView(2130903253);
      hideTitle();
      initValidationUI();
    }
    for (;;)
    {
      if ((this.flag == 2) && (this.validationType == 3))
      {
        this.mScene = 2;
        this.toastView.setVisibility(0);
      }
      if ((this.flag == 2) && (this.validationType == 4))
      {
        this.mScene = 3;
        this.btn_vry_original.setVisibility(0);
      }
      init();
      return;
      requestWindowFeature(1);
      setContentView(2130903093);
      hideTitle();
      this.toastView = findViewById(2131296574);
      findViewById(2131296572).setOnClickListener(new he(this));
      this.btn_vry_original = ((Button)findViewById(2131296577));
      this.btn_vry_original.setOnClickListener(new hf(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.serverData = null;
    if (this.mPreview != null) {
      this.mPreview.a();
    }
    this.handler = null;
    this.imgData1 = null;
    this.imgData2 = null;
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
      this.mPreview.a(this, this.flag, this.handler);
      this.mPreview.c();
    }
    if ((this.mShowPKDialog) || (this.detectsucc))
    {
      this.mShowPKDialog = false;
      this.mPreview.d();
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new hl(this));
    }
  }
  
  public void startAnimation()
  {
    if (this.mBmpLogoGreen != null) {
      this.mLogo.setImageBitmap(this.mBmpLogoGreen);
    }
    this.mLogoMiddle.setVisibility(0);
    this.animationHandler.post(new hr(this, this.mBgUpper, this.mLogoMiddle));
  }
  
  public void startOpenAnimation()
  {
    this.mOpenAnimGoUp = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mOpenHeightUpper);
    this.mOpenAnimGoUp.setDuration(500L);
    this.mOpenAnimGoDown = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mOpenHeightLower);
    this.mOpenAnimGoDown.setDuration(500L);
    this.mOpenAnimGoDown.setAnimationListener(new hc(this));
    this.open_upper.startAnimation(this.mOpenAnimGoUp);
    this.open_lower.startAnimation(this.mOpenAnimGoDown);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCameraActivityOld
 * JD-Core Version:    0.7.0.1
 */