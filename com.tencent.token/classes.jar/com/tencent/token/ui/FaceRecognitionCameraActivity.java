package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cv;
import com.tencent.token.ge;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.co;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.ArrayList;

public class FaceRecognitionCameraActivity
  extends BaseActivity
{
  public static String LANUCH_RETRY_COUNT = "fr_retrycount";
  public static final int OPTYPE_FACE_ADD = 4;
  public static final int OPTYPE_REALNAME_REG = 3;
  public static final int OPTYPE_VALIDATION = 2;
  public static final int SUBOPTYPE_VALIDATION_TRY = 1;
  private final int ALLOW_MAX_RETRY = 5;
  private boolean detectsucc;
  private co drawable;
  private Handler handler = new es(this);
  private boolean isShowingErrorDialog = false;
  boolean ish5zzb;
  private FaceView iv;
  private int[] mActions;
  private FaceData mFaceData;
  private int mFaceOpType = 2;
  private int mFaceScene = 1;
  private boolean mIsActiveSuccess = false;
  private boolean mNeedLiveAction = false;
  private FaceRecognitionCameraPreview mPreview;
  private int mScene;
  private TextView mTipTxt;
  private ImageView mVrySucc1;
  private ImageView mVrySucc2;
  private ImageView progress;
  private long realNameBindUin;
  private int retryCount;
  private byte[] serverData;
  
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
  
  private void gotoNextStep()
  {
    Object localObject;
    if (this.mScene == 3)
    {
      this.iv.c(0);
      localObject = new Intent(this, FaceRecognitionComfirmActivity.class);
      ((Intent)localObject).putExtra("data", this.mFaceData.mUploadData);
      ((Intent)localObject).putExtra("origindata", this.mFaceData.mOriginDataPath);
      ((Intent)localObject).putExtra("flag", 3);
      startActivityForResult((Intent)localObject, 100);
    }
    do
    {
      return;
      if (this.mScene == 7)
      {
        this.iv.c(0);
        localObject = new Intent(this, FaceRecognitionComfirmActivity.class);
        ((Intent)localObject).putExtra("data", this.mFaceData.mUploadData);
        ((Intent)localObject).putExtra("origindata", this.mFaceData.mOriginDataPath);
        ((Intent)localObject).putExtra("flag", 3);
        startActivityForResult((Intent)localObject, 100);
        return;
      }
      this.iv.c(3);
      this.mTipTxt.setText(2131362069);
      localObject = this.mFaceData.mUploadData;
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    this.serverData = ge.a(localArrayList);
    long l;
    if (this.serverData != null) {
      if (this.mScene == 4) {
        l = this.realNameBindUin;
      }
    }
    for (;;)
    {
      int i = getLockStatus();
      this.detectsucc = true;
      af.a().a(0L, l, 2, this.serverData, i, this.mFaceScene, this.handler);
      this.mFaceOpType = 2;
      return;
      if (ax.a().e() != null)
      {
        l = ax.a().e().mRealUin;
        continue;
        e.a("OPTYPE_VALIDATION serverData == null,scene=" + this.mScene);
      }
      else
      {
        l = 0L;
      }
    }
  }
  
  private void init()
  {
    this.retryCount = s.j(LANUCH_RETRY_COUNT);
    e.c("retryCount = " + this.retryCount);
    if (this.retryCount >= 5)
    {
      jumpGesOrPWD();
      return;
    }
    findViewById(2131296572).setOnClickListener(new fu(this));
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131296481));
    this.iv = ((FaceView)findViewById(2131296482));
    this.drawable = new co(this);
    this.mTipTxt = ((TextView)findViewById(2131296578));
    Object localObject = (ViewGroup.MarginLayoutParams)this.mTipTxt.getLayoutParams();
    int i = getResources().getDisplayMetrics().densityDpi;
    float f = getResources().getDisplayMetrics().density;
    TextView localTextView1;
    TextView localTextView2;
    if (i <= 240)
    {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ((int)(70.0F * f));
      localObject = findViewById(2131296574);
      localTextView1 = (TextView)findViewById(2131296576);
      localTextView2 = (TextView)findViewById(2131296571);
      QQUser localQQUser = ax.a().e();
      if ((localQQUser == null) || (!localQQUser.mIsZzb)) {
        break label668;
      }
    }
    label278:
    label668:
    for (int j = 1;; j = 0)
    {
      i = j;
      switch (this.mScene)
      {
      default: 
        i = j;
      case 5: 
        this.mVrySucc1 = ((ImageView)findViewById(2131296579));
        this.mVrySucc2 = ((ImageView)findViewById(2131296580));
        if (i != 0)
        {
          this.iv.a(true, false);
          this.mVrySucc1.setImageResource(2130838027);
          this.mVrySucc2.setImageResource(2130838028);
        }
        break;
      }
      for (;;)
      {
        this.handler.postDelayed(new fx(this, f), 2000L);
        return;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ((int)(90.0F * f));
        break;
        localTextView2.setText(2131362484);
        this.mFaceOpType = 4;
        i = j;
        break label278;
        localTextView2 = (TextView)findViewById(2131296577);
        localTextView2.setVisibility(0);
        localTextView2.setOnClickListener(new fv(this));
        ((View)localObject).setVisibility(0);
        if (j != 0)
        {
          ((View)localObject).setBackgroundResource(2130837849);
          localTextView1.setText(2131362797);
          findViewById(2131296575).setVisibility(0);
          localTextView1.setTextColor(-1);
        }
        for (;;)
        {
          this.mFaceScene = 4;
          i = j;
          break;
          ((View)localObject).setBackgroundResource(2131165315);
          findViewById(2131296575).setVisibility(8);
          localTextView1.setText(2131362810);
          localTextView1.setTextColor(-16777216);
        }
        findViewById(2131296577).setVisibility(0);
        findViewById(2131296577).setOnClickListener(new fw(this));
        ((View)localObject).setVisibility(4);
        this.mFaceScene = 5;
        e.a("mFaceScene" + this.mFaceScene);
        i = j;
        break label278;
        localTextView2.setText(2131362483);
        i = j;
        break label278;
        localTextView2.setText(2131362609);
        i = 1;
        break label278;
        this.mFaceScene = 2;
        ((View)localObject).setVisibility(0);
        if (this.ish5zzb)
        {
          localTextView1.setText(2131362802);
          i = 1;
          break label278;
        }
        localTextView1.setText(2131362798);
        i = 1;
        break label278;
        this.iv.a(false, false);
      }
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
    this.iv.c(0);
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
      showUserDialog(2131361808, getString(paramInt1), paramInt2, new fs(this, paramContext), new ft(this, paramContext));
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 10)
    {
      if (this.mFaceData != null)
      {
        this.mFaceData.mOriginDataPath = null;
        this.mFaceData.mUploadData = null;
        this.mFaceData = null;
      }
      this.mVrySucc1.setVisibility(4);
      this.mVrySucc2.setVisibility(4);
      this.mPreview.a(true, false, 0, 0);
      this.iv.c(0);
    }
    label331:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt2 != 20) {
              break label331;
            }
            if (this.mScene != 3) {
              break;
            }
            paramIntent = new ArrayList();
            if (this.mFaceData != null) {
              paramIntent.add(this.mFaceData.mUploadData);
            }
            this.serverData = ge.a(paramIntent);
          } while ((this.serverData == null) || (this.serverData.length <= 100));
          paramIntent = new Intent();
          paramIntent.putExtra("facedata", this.serverData);
          setResult(0, paramIntent);
          finish();
          return;
        } while (this.mScene != 7);
        paramIntent = new ArrayList();
        if (this.mFaceData != null) {
          paramIntent.add(this.mFaceData.mUploadData);
        }
        this.serverData = ge.a(paramIntent);
      } while ((this.serverData == null) || (this.serverData.length <= 100));
      setContentView(2130903098);
      this.progress = ((ImageView)findViewById(2131296624));
      this.progress.setBackgroundDrawable(this.drawable);
      this.handler.sendEmptyMessageDelayed(13, 10000L);
      long l = 0L;
      if (ax.a().e() != null) {
        l = ax.a().e().mRealUin;
      }
      paramInt1 = getLockStatus();
      af.a().a(0L, l, 4, this.serverData, paramInt1, this.mFaceScene, this.handler);
      this.mFaceOpType = 4;
      return;
    } while ((paramInt1 != 100) || (paramInt2 != 257));
    paramIntent = new Intent(this, ModifyQQPwdActivity.class);
    paramIntent.putExtra("verify_psw", true);
    p.a().a(System.currentTimeMillis(), 95);
    startActivity(paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    this.mScene = getIntent().getIntExtra("scene", 3);
    e.a(",realuin=" + this.realNameBindUin + ",scene=" + this.mScene);
    this.ish5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.detectsucc = false;
    this.mIsActiveSuccess = false;
    requestWindowFeature(1);
    setContentView(2130903089);
    hideTitle();
    init();
    cv.e();
    af.a().h(-1L, this.mScene, this.handler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.serverData = null;
    if (this.mPreview != null)
    {
      this.mPreview.a();
      this.mPreview = null;
    }
    this.handler = null;
    if (this.mFaceData != null)
    {
      this.mFaceData.mOriginDataPath = null;
      this.mFaceData.mUploadData = null;
      this.mFaceData = null;
    }
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
      this.mPreview.a(this, this.mScene, this.handler, this.iv, this.mTipTxt);
      this.mPreview.a(false);
    }
    if (this.detectsucc) {
      this.mPreview.a(true);
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new fy(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCameraActivity
 * JD-Core Version:    0.7.0.1
 */