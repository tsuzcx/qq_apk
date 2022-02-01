package com.tencent.mobileqq.activity.richmedia;

import acfp;
import aijz;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anfv;
import angp.a;
import anhs;
import anhs.a;
import ankl;
import ankq;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import qqy;

public class NewPreFlowCamera
  extends BaseActivity
  implements View.OnClickListener, angp.a, anhs.a, ShortVideoResourceManager.c
{
  TextView Oy;
  CameraPreviewNew jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew = null;
  private qqy jdField_a_of_type_Qqy;
  private int aEt;
  private volatile int bHF;
  private boolean byH;
  private boolean byI;
  private boolean byJ;
  private boolean byK;
  private int cjq;
  private int cjr;
  private int cjs = 10000;
  CircleProgress f;
  Button fn;
  private int mEntranceType;
  RelativeLayout root;
  
  private void AL(String paramString)
  {
    cxK();
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.1(this, paramString));
  }
  
  private void AM(String paramString)
  {
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.2(this, paramString));
  }
  
  private boolean WX()
  {
    return false;
  }
  
  private void cxJ()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    VideoEnvironment.k("NewPreFlowCamera", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709092), null);
      ShortVideoResourceManager.b(this.app, this);
      return;
    }
    AM(acfp.m(2131709103));
  }
  
  private void cxK()
  {
    if (WX())
    {
      int i = (this.cjr + this.bHF) / 2;
      AM(acfp.m(2131709093) + i + "%");
      return;
    }
    AM(acfp.m(2131709099) + this.cjr + "%");
  }
  
  private void cxL()
  {
    if (WX()) {
      if ((this.byH) && (this.byI) && (this.bHF > 100)) {
        cxM();
      }
    }
    while ((!this.byH) || (!this.byI)) {
      return;
    }
    cxM();
  }
  
  public void aFW()
  {
    AM(acfp.m(2131709090));
    VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709097), null);
    anfv.jw(3, -1500);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.4(this, paramBoolean1, paramInt));
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("NewPreFlowCamera", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709091) + paramInt2 + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131709089));
        anfv.jw(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709094), null);
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        paramInt1 = ankq.aB(VideoEnvironment.getContext());
        if (paramInt1 == 2)
        {
          ShortVideoResourceManager.b(this.app, localArrayList, this);
          return;
        }
        if (paramInt1 == 1) {
          ShortVideoResourceManager.b(this.app, localArrayList, null);
        }
        this.cjq = 100;
        this.byI = true;
        VideoEnvironment.k("NewPreFlowCamera", "onConfigResult| getFilterSoState != 2", null);
        return;
      }
      VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709098) + paramInt1 + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131709096));
      anfv.jw(1, paramInt1);
      return;
    }
    VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709086) + paramInt2 + "]", null);
    ShortVideoResourceManager.Qu(acfp.m(2131709100));
    anfv.jw(1, paramInt2);
  }
  
  public void cxM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "startNewFlow=====" + this.aEt + "hasStartAct=" + this.byK);
    }
    if (this.byK) {
      return;
    }
    this.byK = true;
    Intent localIntent = getIntent();
    SessionInfo localSessionInfo2 = (SessionInfo)getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    SessionInfo localSessionInfo1 = localSessionInfo2;
    if (localSessionInfo2 == null)
    {
      localSessionInfo1 = new SessionInfo();
      localSessionInfo1.cZ = 0;
    }
    localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo1);
    localIntent.putExtra("sv_config", DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
    localIntent.putExtra("sv_whitelist", DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
    QLog.d("NewPreFlowCamera", 2, "ShortVideoUtils.loadShortVideoSo: loadBeginStatus=" + VideoEnvironment.Jq());
    ShortVideoUtils.B(this.app);
    boolean bool = ShortVideoUtils.awI();
    QLog.d("NewPreFlowCamera", 2, "ShortVideoUtils.loadShortVideoSo: avCodecIsOK=" + bool);
    if (bool)
    {
      int i = VideoEnvironment.Jr();
      QLog.d("NewPreFlowCamera", 2, "is load AVCodec: versionCode=" + i);
      bool = ankq.f(this.app, BaseApplicationImpl.getContext());
      VideoEnvironment.k("NewPreFlowCamera", "startNewFlow startDownloadFilterSo=" + bool, null);
      localIntent.putExtra("edit_video_type", this.cjs);
      localIntent.putExtra("entrance_type", this.mEntranceType);
      localIntent.putExtra("flow_camera_use_filter_function", bool);
      localIntent.putExtra("flow_camera_use_3dfilter_function", ankl.kQ("TKGLRenderer"));
      localIntent.putExtra("flow_camera_video_mode", true);
      localIntent.putExtra("flow_key_from_guide", this.byJ);
      localIntent.putExtra("activity_start_time", SystemClock.elapsedRealtime());
      localIntent.setClass(this, NewFlowCameraActivity.class);
      if (this.cjs == 10002) {
        this.jdField_a_of_type_Qqy.bj(localIntent);
      }
      if (this.cjs == 10004)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewPreFlowCamera", 2, "startActivityForResult[REQUEST_CODE_SHOOT_QUICKLY]=" + localIntent.getComponent().toString());
        }
        startActivityForResult(localIntent, 9010);
      }
    }
    else
    {
      AM(acfp.m(2131709088));
      QLog.d("NewPreFlowCamera", 2, "ShortVideoUtils.loadShortVideoSo:AVCodec load error code=" + VideoEnvironment.Jq());
      return;
    }
    if (this.mEntranceType == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewPreFlowCamera", 2, "QQStoryApiPlugin.gotoStoryTakeVideoActivity");
      }
      aijz.ex(this);
      super.finish();
      return;
    }
    if (localIntent.getBooleanExtra("need_result", false))
    {
      startActivityForResult(localIntent, 12345);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "startActivity:" + localIntent.getComponent().toString());
    }
    startActivity(localIntent);
    super.finish();
  }
  
  public void cxN()
  {
    this.bHF = 0;
    anhs.a().a(true, this);
    boolean bool = anhs.a().ug();
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new NewPreFlowCamera.3(this));
      return;
    }
    this.bHF = 101;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9010)
    {
      setResult(-1, paramIntent);
      finish();
      return;
    }
    if (paramInt1 == 12345)
    {
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.aEt = 0;
    super.doOnCreate(paramBundle);
    if (this.app == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "NewPreFlowCamera-> app == null");
      finish();
      return false;
    }
    this.jdField_a_of_type_Qqy = new qqy(this.app);
    this.byJ = getIntent().getBooleanExtra("flow_key_from_guide", false);
    this.cjs = getIntent().getIntExtra("edit_video_type", 10000);
    this.mEntranceType = getIntent().getIntExtra("entrance_type", 99);
    setContentView(2131561361);
    this.root = ((RelativeLayout)findViewById(2131377546));
    this.fn = ((Button)findViewById(2131367251));
    this.f = ((CircleProgress)findViewById(2131365505));
    this.f.setBgAndProgressColor(100, getResources().getColor(2131167654), 100, getResources().getColor(2131165409));
    this.f.setStrokeWidth(6.0F);
    this.f.setProgress(0.0F);
    this.f.setOnClickListener(this);
    this.Oy = ((TextView)findViewById(2131367345));
    this.fn.setOnClickListener(this);
    if (!VideoEnvironment.p(this.app))
    {
      QQToast.a(VideoEnvironment.getContext(), acfp.m(2131709095), 1).show();
      super.finish();
      return true;
    }
    boolean bool2;
    if (WX())
    {
      cxN();
      bool2 = VideoEnvironment.r(this.app);
      if (ankq.aB(this) == 2) {
        break label360;
      }
    }
    label360:
    for (boolean bool1 = true;; bool1 = false)
    {
      VideoEnvironment.k("NewPreFlowCamera", "checkAVCodecLoadIsOK loaded=" + bool2 + ",exists=" + bool1, null);
      if ((bool2) && (bool1)) {
        break label365;
      }
      anfv.UL(2);
      cxJ();
      return true;
      this.bHF = 101;
      break;
    }
    label365:
    cxM();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      ShortVideoResourceManager.a(this.app, this);
      ShortVideoResourceManager.b(this.app, this);
    }
    anhs.a().a(false, this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    View localView = this.root.findViewById(2131367243);
    if (localView != null) {
      this.root.removeView(localView);
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew = new CameraPreviewNew(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew.setCamera(this.byJ);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew.setId(2131367243);
    this.root.addView(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaCameraPreviewNew, 0, localLayoutParams);
  }
  
  public void f(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.aEt = i;
    }
    for (;;)
    {
      this.cjr = ((this.aEt + this.cjq) / 2);
      AL("doUserDownloadResourceAVCodec:");
      VideoEnvironment.k("NewPreFlowCamera", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_")) {
        this.cjq = i;
      }
    }
  }
  
  public void finish()
  {
    if (this.byJ)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    super.finish();
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709102) + paramInt + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131709104));
        anfv.jw(2, paramInt);
      }
    }
    else if (paramString1.startsWith("new_qq_android_native_short_filter_"))
    {
      if (paramInt == 0) {
        break label237;
      }
      VideoEnvironment.k("NewPreFlowCamera", acfp.m(2131709101) + paramInt + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131709087));
      anfv.jw(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.k("NewPreFlowCamera", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.aEt = 100;
      this.byH = true;
      if (!isFinishing())
      {
        VideoEnvironment.k("NewPreFlowCamera", "[AVCodec]isFilterDownloaded=" + this.byI, null);
        cxL();
        break;
      }
      VideoEnvironment.k("NewPreFlowCamera", "isFinishing= true", null);
      break;
      label237:
      this.cjq = 100;
      this.byI = true;
      if (!isFinishing())
      {
        VideoEnvironment.k("NewPreFlowCamera", "[Filter]isAvCodecDownloaded=" + this.byH, null);
        cxL();
      }
      else
      {
        VideoEnvironment.k("NewPreFlowCamera", "isFinishing= true", null);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    ThreadManager.getUIHandler().post(new NewPreFlowCamera.5(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera
 * JD-Core Version:    0.7.0.1
 */