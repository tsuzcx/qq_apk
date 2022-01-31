package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.ch;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.fi;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.cd;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.util.ArrayList;

public class FaceRecognitionCameraActivity
  extends BaseActivity
{
  public static final int ACTIVITY_REQUEST_CODE_CHANGE_MOBILE = 114;
  public static final int ACTIVITY_REQUEST_CODE_CHANGE_PSW = 113;
  public static final int ACTIVITY_REQUEST_CODE_FACE_CONFIRM = 115;
  public static final int ACTIVITY_REQUEST_CODE_VRY_OTHER_FACTOR = 111;
  public static final int ACTIVITY_RESULT_CODE = 112;
  public static String LANUCH_RETRY_COUNT = "fr_retrycount";
  public static final int OPTYPE_FACE_ADD = 4;
  public static final int OPTYPE_REALNAME_REG = 3;
  public static final int OPTYPE_VALIDATION = 2;
  public static final int SUBOPTYPE_VALIDATION_TRY = 1;
  private final int ALLOW_MAX_RETRY = 5;
  private TextView changeTypeTv;
  private boolean detectsucc;
  private cd drawable;
  private Handler handler = new fj(this);
  private boolean isFirstFactor = false;
  private boolean isShowingErrorDialog = false;
  boolean ish5zzb;
  private FaceView iv;
  private int[] mActions;
  private String mCountryCode = "+86";
  private FaceData mFaceData;
  private int mFaceOpType = 2;
  private int mFaceScene = 1;
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private boolean mNeedLiveAction = false;
  private FaceRecognitionCameraPreview mPreview;
  private int mScene;
  private int mSourceId;
  private TextView mTipTxt;
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private ImageView mVrySucc1;
  private ImageView mVrySucc2;
  private int pageid;
  private ImageView progress;
  private long realNameBindUin;
  private int retryCount;
  private byte[] serverData;
  private boolean verifyFaceFactor = false;
  
  public static int getLockStatus()
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
  
  private void gotoNextStep()
  {
    Object localObject;
    if (this.mScene == 3)
    {
      this.iv.setStatus(0);
      localObject = new Intent(this, FaceRecognitionComfirmActivity.class);
      ((Intent)localObject).putExtra("data", this.mFaceData.mUploadData);
      ((Intent)localObject).putExtra("origindata", this.mFaceData.mOriginDataPath);
      ((Intent)localObject).putExtra("flag", 3);
      ((Intent)localObject).putExtra("scene", this.mScene);
      startActivityForResult((Intent)localObject, 115);
    }
    do
    {
      return;
      if (this.mScene == 7)
      {
        this.iv.setStatus(0);
        localObject = new Intent(this, FaceRecognitionComfirmActivity.class);
        ((Intent)localObject).putExtra("data", this.mFaceData.mUploadData);
        ((Intent)localObject).putExtra("origindata", this.mFaceData.mOriginDataPath);
        ((Intent)localObject).putExtra("flag", 3);
        ((Intent)localObject).putExtra("scene", this.mScene);
        ((Intent)localObject).putExtra("face_scene", this.mFaceScene);
        ((Intent)localObject).putExtra("bright_mode_int", this.iv.getBrightModeIntValue());
        startActivityForResult((Intent)localObject, 115);
        return;
      }
      this.iv.setStatus(3);
      this.mTipTxt.setText(2131231424);
      localObject = this.mFaceData.mUploadData;
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    this.serverData = fi.a(localArrayList);
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
      if (this.mScene == 13)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("facedata", this.serverData);
        setResult(0, (Intent)localObject);
        finish();
      }
      for (;;)
      {
        this.mFaceOpType = 2;
        return;
        if (do.a().e() == null) {
          break label493;
        }
        l = do.a().e().mRealUin;
        break;
        if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
          cw.a().a(w.f(this.realNameBindUin), this.realNameBindUin, 2, this.serverData, i, this.mFaceScene, this.iv.getBrightModeIntValue(), this.handler);
        } else {
          cw.a().a(0L, l, 2, this.serverData, i, this.mFaceScene, this.iv.getBrightModeIntValue(), this.handler);
        }
      }
      h.a("OPTYPE_VALIDATION serverData == null,scene=" + this.mScene);
      return;
      label493:
      l = 0L;
    }
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if (localQQUser != null) {
      cp.a(getApplicationContext()).a(this, 523005419L, this.handler, "" + localQQUser.b());
    }
  }
  
  private void init()
  {
    this.retryCount = w.b(null, LANUCH_RETRY_COUNT);
    h.c("retryCount = " + this.retryCount);
    if (this.retryCount >= 5)
    {
      jumpGesOrPWD();
      return;
    }
    findViewById(2131558858).setOnClickListener(new gp(this));
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131558767));
    this.mPreview.setVisibility(4);
    this.iv = ((FaceView)findViewById(2131558768));
    this.drawable = new cd(this);
    this.mTipTxt = ((TextView)findViewById(2131558865));
    Object localObject = (ViewGroup.MarginLayoutParams)this.mTipTxt.getLayoutParams();
    int i = getResources().getDisplayMetrics().densityDpi;
    float f = getResources().getDisplayMetrics().density;
    if (i <= 240) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ((int)(70.0F * f));
    }
    for (;;)
    {
      localObject = findViewById(2131558861);
      TextView localTextView1 = (TextView)findViewById(2131558863);
      TextView localTextView2 = (TextView)findViewById(2131558857);
      try
      {
        if ((Build.VERSION.SDK_INT >= 21) && (x.c(this))) {
          ((ViewGroup.MarginLayoutParams)findViewById(2131558856).getLayoutParams()).topMargin = x.b(this);
        }
        QQUser localQQUser = do.a().e();
        if ((localQQUser != null) && (localQQUser.mIsZzb))
        {
          bool2 = true;
          bool1 = bool2;
          switch (this.mScene)
          {
          default: 
            bool1 = bool2;
          case 5: 
            this.mVrySucc1 = ((ImageView)findViewById(2131558866));
            this.mVrySucc2 = ((ImageView)findViewById(2131558867));
            if (bool1)
            {
              this.iv.a(true, false);
              this.mVrySucc1.setImageResource(2130838079);
              this.mVrySucc2.setImageResource(2130838080);
              this.changeTypeTv = ((TextView)findViewById(2131558740));
              if (!this.verifyFaceFactor) {
                break label1069;
              }
              this.changeTypeTv.setVisibility(0);
              this.changeTypeTv.setOnClickListener(new gu(this, localQQUser));
              this.handler.postDelayed(new gk(this, f), 2000L);
              return;
              if (i <= 320)
              {
                ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ((int)(90.0F * f));
                continue;
              }
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ((int)(90.0F * f));
            }
            break;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool2;
          localException.printStackTrace();
          continue;
          localTextView2.setText(2131231020);
          this.mFaceOpType = 4;
          boolean bool1 = bool2;
          continue;
          localTextView2 = (TextView)findViewById(2131558864);
          localTextView2.setVisibility(0);
          localTextView2.setOnClickListener(new gq(this));
          ((View)localObject).setVisibility(0);
          if (bool2)
          {
            ((View)localObject).setBackgroundResource(2130837917);
            localTextView1.setText(2131231672);
            findViewById(2131558862).setVisibility(0);
            localTextView1.setTextColor(-1);
          }
          for (;;)
          {
            this.mFaceScene = 4;
            bool1 = bool2;
            break;
            ((View)localObject).setBackgroundResource(2131492983);
            findViewById(2131558862).setVisibility(8);
            localTextView1.setText(2131230979);
            localTextView1.setTextColor(-16777216);
          }
          findViewById(2131558864).setVisibility(0);
          findViewById(2131558864).setOnClickListener(new gr(this));
          ((View)localObject).setVisibility(4);
          this.mFaceScene = 5;
          h.a("mFaceScene" + this.mFaceScene);
          bool1 = bool2;
          continue;
          this.pageid = getIntent().getIntExtra("page_id", 0);
          findViewById(2131558864).setVisibility(0);
          findViewById(2131558864).setOnClickListener(new gs(this));
          ((View)localObject).setVisibility(0);
          if (bool2)
          {
            ((View)localObject).setBackgroundResource(2130837917);
            localTextView1.setText(2131230999);
            findViewById(2131558862).setVisibility(0);
            localTextView1.setTextColor(-1);
          }
          for (;;)
          {
            this.mFaceScene = 6;
            bool1 = bool2;
            break;
            ((View)localObject).setBackgroundResource(2131492983);
            findViewById(2131558862).setVisibility(8);
            localTextView1.setText(2131230998);
            localTextView1.setTextColor(-16777216);
          }
          findViewById(2131558864).setVisibility(0);
          findViewById(2131558864).setOnClickListener(new gt(this));
          ((View)localObject).setVisibility(4);
          this.mFaceScene = 7;
          h.a("mFaceScene" + this.mFaceScene);
          bool1 = bool2;
          continue;
          localTextView2.setText(2131231022);
          bool1 = bool2;
          continue;
          localTextView2.setText(2131231657);
          bool1 = bool2;
          if (this.mVerifyResult != null)
          {
            bool1 = this.mVerifyResult.h();
            continue;
            localTextView2.setText(2131231371);
            bool1 = true;
            continue;
            localTextView2.setText(2131231371);
            bool1 = true;
            continue;
            this.mFaceScene = 2;
            ((View)localObject).setVisibility(0);
            if (this.ish5zzb)
            {
              localTextView1.setText(2131230783);
              bool1 = true;
            }
            else
            {
              localTextView1.setText(2131231673);
              bool1 = true;
              continue;
              this.iv.a(false, false);
              continue;
              label1069:
              this.changeTypeTv.setVisibility(8);
              continue;
              bool2 = false;
            }
          }
        }
      }
    }
  }
  
  private void judgeNextStep()
  {
    Intent localIntent;
    switch (this.mScene)
    {
    case 6: 
    case 7: 
    default: 
      return;
    case 9: 
      localIntent = new Intent(this, FaceChangePwdIndexActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.setFlags(67108864);
      ch.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      finish();
      return;
    case 11: 
      localIntent = new Intent(this, FaceChangeMobileActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.setFlags(67108864);
      ch.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      finish();
      return;
    case 8: 
      localIntent = new Intent(this, ModifyQQPwdActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.putExtra("source_id", this.mSourceId);
      ch.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
      finish();
      return;
    case 10: 
      localIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
      localIntent.putExtra("title", getResources().getString(2131230997));
      localIntent.putExtra("op_type", 3);
      localIntent.putExtra("page_id", 16);
      startActivity(localIntent);
      finish();
      return;
    }
    cy.a().a(this);
    RqdApplication.i();
    w.a(null, LANUCH_RETRY_COUNT, 0);
    cy.a().a(this, 0);
    finish();
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
    this.iv.setStatus(0);
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
    }
    this.mTipTxt.setText(2131231155);
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131230843, getString(paramInt1), paramInt2, new gn(this, paramContext), new go(this, paramContext));
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
      if (this.isFirstFactor)
      {
        startActivity(abi.a().a(this));
        return true;
      }
      finish();
      return true;
    }
    return true;
  }
  
  protected void goNextVerify()
  {
    if (!this.mVerifyType.a(Integer.valueOf(this.mVerifyFactorId)))
    {
      abi.a().a(this, this.mVerifyResult, this.mVerifyType, this.mVerifyType.a(this.mVerifyFactorId), false, this.handler);
      if (this.mPreview != null) {
        this.mPreview.a();
      }
      return;
    }
    if (this.mVerifyResult.b())
    {
      cw.a().b(this.realNameBindUin, this.mVerifyType.a(), this.mMobile, this.mCountryCode, this.handler);
      return;
    }
    dismissDialog();
    Intent localIntent = new Intent(this, NetActiveSetDirBySeqActivity.class);
    localIntent.putExtra("intent.qquser", this.mUser);
    localIntent.putExtra("intent.determin_factors_result", this.mVerifyResult);
    localIntent.putExtra("intent.determin_verify_type", this.mVerifyType);
    localIntent.putExtra("intent.determin_verify_factor_id", 5);
    startActivity(localIntent);
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
      this.iv.setStatus(0);
    }
    label337:
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
              do
              {
                do
                {
                  return;
                  if (paramInt2 != 20) {
                    break label337;
                  }
                  if (this.mScene != 3) {
                    break;
                  }
                  paramIntent = new ArrayList();
                  if (this.mFaceData != null) {
                    paramIntent.add(this.mFaceData.mUploadData);
                  }
                  this.serverData = fi.a(paramIntent);
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
              this.serverData = fi.a(paramIntent);
            } while ((this.serverData == null) || (this.serverData.length <= 100));
            setContentView(2130968661);
            this.progress = ((ImageView)findViewById(2131558912));
            this.progress.setBackgroundDrawable(this.drawable);
            this.handler.sendEmptyMessageDelayed(13, 10000L);
            long l = 0L;
            if (do.a().e() != null) {
              l = do.a().e().mRealUin;
            }
            paramInt1 = getLockStatus();
            cw.a().a(0L, l, 4, this.serverData, paramInt1, this.mFaceScene, this.iv.getBrightModeIntValue(), this.handler);
            this.mFaceOpType = 4;
            return;
            if (paramInt1 != 113) {
              break;
            }
          } while (paramInt2 != 257);
          paramIntent = new Intent(this, ModifyQQPwdActivity.class);
          paramIntent.putExtra("verify_psw", true);
          paramIntent.putExtra("source_id", this.mSourceId);
          ch.a().a(System.currentTimeMillis(), 95);
          startActivity(paramIntent);
          finish();
          return;
          if (paramInt1 != 114) {
            break;
          }
        } while (paramInt2 != 257);
        paramIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
        paramIntent.putExtra("title", getResources().getString(2131230997));
        paramIntent.putExtra("op_type", 3);
        paramIntent.putExtra("page_id", 16);
        startActivity(paramIntent);
        finish();
        return;
        if (paramInt1 != 111) {
          break;
        }
      } while (paramInt2 != 112);
      this.serverData = null;
      if (this.mPreview != null)
      {
        this.mPreview.c();
        this.mPreview = null;
      }
      this.handler = null;
      if (this.mFaceData != null)
      {
        this.mFaceData.mOriginDataPath = null;
        this.mFaceData.mUploadData = null;
        this.mFaceData = null;
      }
      finish();
      return;
    } while ((paramInt1 != 1201) && (paramInt1 != 1202));
    cp.a(getApplicationContext()).a(paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {
      this.mSourceId = getIntent().getIntExtra("source_id", 0);
    }
    h.a("sourceid=" + this.mSourceId);
    this.realNameBindUin = getIntent().getLongExtra("real_uin", 0L);
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.mScene = getIntent().getIntExtra("scene", 3);
    h.a(",realuin=" + this.realNameBindUin + ",scene=" + this.mScene);
    this.ish5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.detectsucc = false;
    this.mIsActiveSuccess = false;
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    if (this.mVerifyFactorId != -1)
    {
      this.verifyFaceFactor = true;
      this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
      this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
      this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
      this.isFirstFactor = getIntent().getBooleanExtra("intent.determin_first_verify_factor", false);
      if ((this.mUser == null) || (this.mVerifyResult == null) || (this.mVerifyType == null))
      {
        finish();
        return;
      }
      this.realNameBindUin = this.mUser.mRealUin;
      this.mScene = 12;
    }
    requestWindowFeature(1);
    setContentView(2130968654);
    hideTitle();
    init();
    ProtoFaceCommon.e();
    if (this.mScene == 3)
    {
      cw.a().f(this.realNameBindUin, this.mScene, this.handler);
      return;
    }
    cw.a().f(-1L, this.mScene, this.handler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.serverData = null;
    if (this.mPreview != null)
    {
      this.mPreview.c();
      this.mPreview = null;
    }
    this.handler = null;
    if (this.mFaceData != null)
    {
      this.mFaceData.mOriginDataPath = null;
      this.mFaceData.mUploadData = null;
      this.mFaceData = null;
    }
    abi.c();
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
      this.mPreview.b();
      gm localgm = new gm(this);
      requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, localgm);
      this.mPreview.setStop(false);
    }
    if (this.detectsucc)
    {
      this.mPreview.setStop(true);
      if (this.mVerifyType != null)
      {
        int i = this.mVerifyType.a(this.mVerifyFactorId);
        if ((i == 2) || (i == 3) || (i == 4) || (i == 7))
        {
          this.iv.setStatus(0);
          this.mPreview.setStop(false);
        }
      }
    }
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new gl(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCameraActivity
 * JD-Core Version:    0.7.0.1
 */